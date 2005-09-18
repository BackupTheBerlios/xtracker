package com.jmonkey.xtracker.mail.pop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.auth.RandomPasswordGenerator;
import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.MailReference;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.attachment.AttachmentHandler;
import com.jmonkey.xtracker.issue.loader.DispositionLoader;
import com.jmonkey.xtracker.issue.loader.QueueLoader;
import com.jmonkey.xtracker.issue.loader.SeverityLoader;
import com.jmonkey.xtracker.issue.loader.StatusLoader;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.TokenManipulator;
import com.jmonkey.xtracker.mail.smtp.SMTPMailSender;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;
import com.jmonkey.xtracker.profile.persistor.PersonPersistor;
import com.jmonkey.xtracker.util.TicketUtil;

public class ReceivedMailProcessor {
	private Logger					logger				= LogManager.getLogger(ReceivedMailProcessor.class);
	private MailConfig				mailConfig			= new MailConfig();
	private PersonLoader			personLoader		= null;
	private PersonPersistor			personPersistor		= null;
	private TicketLoader			ticketLoader		= null;
	private TicketPersistor			ticketPersistor		= null;
	private StatusLoader			statusLoader		= null;
	private DispositionLoader		dispositionLoader	= null;
	private SeverityLoader			severityLoader		= null;
	private QueueLoader				queueLoader			= null;
	private Integer					defaultPriority		= null;
	private AttachmentHandler		attachmentHandler	= null;
	private RandomPasswordGenerator	passwordGenerator	= null;
	private SMTPMailSender			mailSender			= null;

	public ReceivedMailProcessor() {
		super();
	}

	public void processMail(ReceivedMailMessage mailMessage) throws Exception {
		mailMessage.processMessage();
		String subject = mailMessage.getSubject();
		logger.debug("Processing mail message: " + subject);
		if (subject == null || subject.length() == 0) {
			subject = "No Subject";
		}
		TokenManipulator tokenManipulator = new TokenManipulator();
		tokenManipulator.setPrefix("XTracker");
		if (!tokenManipulator.hasTicketToken(subject)) {
			// System.out.println("storeNewTicket: " + subject);
			storeNewTicket(mailMessage, subject);
		} else {
			// System.out.println("updateExistingTicket: " + subject);
			Long id = tokenManipulator.extractTicketNumber(subject);
			updateExistingTicket(mailMessage, id);
		}
	}

	private void updateExistingTicket(ReceivedMailMessage message, Long id) throws Exception {
		Ticket ticket = ticketLoader.loadTicket(id);
		Date messageDate = message.getReceivedDate();
		if (messageDate == null) {
			messageDate = new Date();
		}
		Date nowDate = new Date();
		ticket.setModifyDate(nowDate);
		Person requestor = determinRequestor(message, ticket.getQueue());
		History history = buildNewHistoryItem(message, messageDate, requestor);
		setHistorySubject(message, history);
		ticket.getHistory().add(history);

		forceClosedTicketOpen(ticket);

		ticketPersistor.updateTicket(ticket);

		List<ReceivedMailAttachement> attachments = message.getAttachements();
		for (ReceivedMailAttachement attachment : attachments) {
			attachmentHandler.storeAttachment(history, attachment);
		}

		mailSender.setHostName(mailConfig.getSmtpMailHost());
		mailSender.setUsername(mailConfig.getSmtpHostUsername());
		mailSender.setPassword(mailConfig.getSmtpHostPassword());
		mailSender.sendReplyMail(ticket, history);
	}

	protected void forceClosedTicketOpen(Ticket ticket) throws HibernateException {
		if (TicketUtil.isTicketClosed(ticket)) {
			Status nextStatus = statusLoader.loadOpenStatus();
			ticket.setStatus(nextStatus);
		}
	}

	private History buildNewHistoryItem(ReceivedMailMessage message, Date messageDate, Person requestor) {
		History history = new History();
		history.setMessageId(message.getMessageId());
		List<MailReference> mailReferences = new ArrayList<MailReference>();
		List<String> refs = message.getMessageReferenceIds();
		for (String ref : refs) {
			MailReference mailReference = new MailReference();
			mailReference.setMessageId(ref);
			mailReferences.add(mailReference);
			mailReference.setMessageDate(messageDate);
		}
		history.setMessageReferences(mailReferences);
		history.setAuthor(requestor);
		String body = message.getBody();
		body = chopOffSig(body);
		history.setContent(body);
		history.setCreateDate(messageDate);
		return history;
	}

	private void setHistorySubject(ReceivedMailMessage message, History history) {
		String subject = message.getSubject();
		if (subject == null || subject.length() == 0) {
			subject = "No Subject";
		}
		history.setSubject(subject);
	}

	private void storeNewTicket(ReceivedMailMessage message, String subject) throws Exception {
		Ticket ticket = new Ticket();
		ticket.setSubject(subject);
		Date messageDate = message.getReceivedDate();
		if (messageDate == null) {
			messageDate = new Date();
		}

		ticket.setCreateDate(messageDate);

		Status status = statusLoader.loadNewStatus();
		ticket.setStatus(status);

		Disposition disposition = dispositionLoader.loadUnspecifiedDisposition();
		ticket.setDisposition(disposition);

		Severity severity = severityLoader.loadUnspecifiedSeverity();
		ticket.setSeverity(severity);

		String toAddress = null;
		if (mailConfig.isCustomQueueMailHeaderEnabled()) {
			toAddress = message.getHeader(mailConfig.getCustomQueueMailHeader());
		}
		if (toAddress == null) {
			toAddress = message.getToEmailAddress();
		}

		logger.debug("New mail to address is: " + toAddress);
		String[] namePart = toAddress.split("@");
		logger.debug("Searching for queue with alias: " + namePart[0]);
		Queue addToQueue = queueLoader.loadQueueByAlias(namePart[0]);
		if (addToQueue == null) {
			addToQueue = queueLoader.loadAnonymousQueue();
		}
		logger.debug("Found queue " + addToQueue.getName() + "[" + addToQueue.getEmailAlias() + "] for address " + toAddress);
		ticket.setQueue(addToQueue);

		Person requestor = determinRequestor(message, addToQueue);
		ticket.setRequestor(requestor);

		ticket.setPriority(defaultPriority);

		History history = buildNewHistoryItem(message, messageDate, requestor);
		history.setSubject(subject);
		ticket.getHistory().add(history);

		ticketPersistor.saveTicket(ticket);

		List<ReceivedMailAttachement> attachments = message.getAttachements();
		for (ReceivedMailAttachement attachment : attachments) {
			attachmentHandler.storeAttachment(history, attachment);
		}

		mailSender.setHostName(mailConfig.getSmtpMailHost());
		mailSender.setUsername(mailConfig.getSmtpHostUsername());
		mailSender.setPassword(mailConfig.getSmtpHostPassword());
		mailSender.sendNewTicketInQueueMail(ticket, history, addToQueue);
	}

	private String chopOffSig(String body) {
		if (body != null) {
			int chopIndex = body.lastIndexOf("-- ");
			if (chopIndex > 0) {
				body = body.substring(0, chopIndex);
			}
			
			// XXX Of course, we have to do something special for MS sigs
			String msSig = "_________________________________________________________________";
			int chopMsIndex = body.lastIndexOf(msSig);
			if (chopMsIndex > 0) {
				body = body.substring(0, chopMsIndex);
			}
		}
		return body;
	}

	private Person determinRequestor(ReceivedMailMessage message, Queue queue) throws Exception {
		String personalName = message.getFromPersonalName();
		String emailAddress = message.getFromEmailAddress();
		Person requestor = personLoader.findPersonByEmail(emailAddress);
		if (requestor == null) {
			Person newPerson = new Person();
			newPerson.setActive(true);
			newPerson.setAnonymous(true);
			newPerson.setSelectable(false);
			newPerson.setUsername(emailAddress);
			newPerson.setRealname(personalName);
			String initials = extractPersonInitials(personalName);
			newPerson.setInitials(initials);

			Date dateNow = new Date();
			// Email email = new Email("default", emailAddress, new Integer(0),
			// true, dateNow);
			// newPerson.getEmailAddesses().add(email);
			newPerson.setEmailAddress(emailAddress);
			newPerson.setCreateDate(dateNow);
			newPerson.setDefaultQueue(queue);

			// FIXME Generate password and mail to user.
			String newPassword = passwordGenerator.getNextPassword();
			newPerson.setPlainPassword(newPassword);

			personPersistor.savePerson(newPerson);

			// JdkPrefsConfig config = JdkPrefsConfig.loadedInstance();
			// SMTPMailSender mailSender = new SMTPMailSender();
			mailSender.setHostName(mailConfig.getSmtpMailHost());
			mailSender.setUsername(mailConfig.getSmtpHostUsername());
			mailSender.setPassword(mailConfig.getSmtpHostPassword());
			mailSender.sendNewPersonMail(newPerson, newPassword, queue);

			requestor = newPerson;
		}
		return requestor;
	}

	private String extractPersonInitials(String personalName) {
		String initials = "~?";
		if (personalName != null) {
			if (personalName.indexOf(" ") > -1) {
				// has a space separated personal name.
				StringBuffer nameBuffer = new StringBuffer();
				String[] nameParts = personalName.trim().split(" ");
				nameBuffer.append("~");
				nameBuffer.append(nameParts[0].charAt(0));
				nameBuffer.append(nameParts[1].charAt(0));
				initials = nameBuffer.toString().toUpperCase();
			} else if (personalName.indexOf("@") > -1) {
				// no personal name, email was used instead.
				int end = determinMaxCharsForInitials(personalName);
				initials = "~" + personalName.substring(0, end);
			} else {
				int end = determinMaxCharsForInitials(personalName);
				initials = "~" + personalName.substring(0, end);
			}
		}
		return initials;
	}

	private int determinMaxCharsForInitials(String personalName) {
		int end = (personalName.length() > 2) ? 1 : personalName.length();
		return end;
	}

	public PersonLoader getPersonLoader() {
		return personLoader;
	}

	public void setPersonLoader(PersonLoader personLoader) {
		this.personLoader = personLoader;
	}

	public TicketLoader getTicketLoader() {
		return ticketLoader;
	}

	public void setTicketLoader(TicketLoader ticketLoader) {
		this.ticketLoader = ticketLoader;
	}

	public TicketPersistor getTicketPersistor() {
		return ticketPersistor;
	}

	public void setTicketPersistor(TicketPersistor ticketPersistor) {
		this.ticketPersistor = ticketPersistor;
	}

	public PersonPersistor getPersonPersistor() {
		return personPersistor;
	}

	public void setPersonPersistor(PersonPersistor personPersistor) {
		this.personPersistor = personPersistor;
	}

	public StatusLoader getStatusLoader() {
		return statusLoader;
	}

	public void setStatusLoader(StatusLoader statusLoader) {
		this.statusLoader = statusLoader;
	}

	public DispositionLoader getDispositionLoader() {
		return dispositionLoader;
	}

	public void setDispositionLoader(DispositionLoader dispositionLoader) {
		this.dispositionLoader = dispositionLoader;
	}

	public QueueLoader getQueueLoader() {
		return queueLoader;
	}

	public void setQueueLoader(QueueLoader queueLoader) {
		this.queueLoader = queueLoader;
	}

	public SeverityLoader getSeverityLoader() {
		return severityLoader;
	}

	public void setSeverityLoader(SeverityLoader severityLoader) {
		this.severityLoader = severityLoader;
	}

	public Integer getDefaultPriority() {
		return defaultPriority;
	}

	public void setDefaultPriority(Integer defaultPriority) {
		this.defaultPriority = defaultPriority;
	}

	public AttachmentHandler getAttachmentHandler() {
		return attachmentHandler;
	}

	public void setAttachmentHandler(AttachmentHandler attachmentHandler) {
		this.attachmentHandler = attachmentHandler;
	}

	public RandomPasswordGenerator getPasswordGenerator() {
		return passwordGenerator;
	}

	public void setPasswordGenerator(RandomPasswordGenerator passwordGenerator) {
		this.passwordGenerator = passwordGenerator;
	}

	public SMTPMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(SMTPMailSender mailSender) {
		this.mailSender = mailSender;
	}

}
