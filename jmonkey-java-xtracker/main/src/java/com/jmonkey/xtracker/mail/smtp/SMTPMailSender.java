package com.jmonkey.xtracker.mail.smtp;

import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.PreferencesConfig;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.MailReference;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.Template;
import com.jmonkey.xtracker.mail.TokenManipulator;
import com.jmonkey.xtracker.mail.pop.ReceivedMailMessage;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.template.TemplateData;
import com.jmonkey.xtracker.template.loader.TemplateDataLoader;
import com.jmonkey.xtracker.util.DateFormatter;
import com.jmonkey.xtracker.util.QueueUtil;

public class SMTPMailSender {
	private Logger							logger				= LogManager.getLogger(SMTPMailSender.class);

	private final Hashtable<String, String>	headers				= new Hashtable<String, String>();

	private String							hostName			= null;
	private String							username			= null;
	private String							password			= null;

	private String							recipient			= null;
	private String							sender				= null;
	private String							subject				= null;
	private StringBuffer					tokenTemplate		= null;
	private Map<String, String>				tokenParams			= new HashMap<String, String>();
	private PreferencesConfig				preferencesConfig	= new PreferencesConfig();
	private MailConfig						mailConfig			= new MailConfig();

	public SMTPMailSender() {
		super();
	}

	private StringBuffer generateReplyTemplate(Ticket ticket, History history) {
		// JdkPrefsConfig config = JdkPrefsConfig.loadedInstance();

		Template templateParser = new Template();
		templateParser.setTag("@@TICKET_ID@@", ticket.getId().toString());
		templateParser.setTag("@@TICKET_SUBJECT@@", ticket.getSubject());
		String context = preferencesConfig.getRootXTrackerUriContext();
		if (context.endsWith("/")) {
			context = context.substring(0, context.length() - 1);
		}
		templateParser.setTag("@@TICKET_URI@@", context + "/open.do?id=" + ticket.getId());

		Person author = history.getAuthor();
		Date historyDate = history.getCreateDate();
		Integer historyImportance = history.getImportance();
		String historySubject = history.getSubject();
		String historyContent = history.getContent();
		templateParser.setTag("@@HISTORY_AUTHOR@@", author.getRealname());
		// XXX Need to format the date
		templateParser.setTag("@@HISTORY_DATE@@", historyDate.toString());
		templateParser.setTag("@@HISTORY_SUBJECT@@", historySubject);
		templateParser.setTag("@@HISTORY_MESSAGE@@", historyContent);
		templateParser.setTag("@@HISTORY_IMPORTANCE@@", historyImportance.toString());

		if (tokenTemplate == null) {
			tokenTemplate = getDefaultReplyTemplate();
		}
		templateParser.setBuffer(tokenTemplate);
		StringBuffer message = templateParser.parseBuffer();
		return message;
	}

	private StringBuffer generateNewPersonTemplate(Person newPerson, String newPassword, Queue queue) throws Exception {
		// JdkPrefsConfig config = JdkPrefsConfig.loadedInstance();

		Template templateParser = new Template();
		templateParser.setTag("@@PERSON_USERNAME@@", newPerson.getUsername());
		templateParser.setTag("@@PERSON_REALNAME@@", newPerson.getRealname());
		templateParser.setTag("@@PERSON_PASSWORD@@", newPassword);
		templateParser.setTag("@@QUEUE_NAME@@", queue.getName());
		templateParser.setTag("@@QUEUE_EMAIL@@", queue.getEmailAlias() + getEmailDomain());

		String context = preferencesConfig.getRootXTrackerUriContext();
		if (context.endsWith("/")) {
			context = context.substring(0, context.length() - 1);
		}
		templateParser.setTag("@@CONTEXT_URI@@", context);

		if (tokenTemplate == null) {
			tokenTemplate = getDefaultNewPersonTemplate();
		}
		templateParser.setBuffer(tokenTemplate);
		StringBuffer message = templateParser.parseBuffer();
		return message;
	}

	private StringBuffer generateNewTicketInQueueTemplate(Ticket ticket, History history, Queue queue) throws Exception {
		Template templateParser = new Template();
		templateParser.setTag("@@QUEUE_NAME@@", queue.getName());
		templateParser.setTag("@@QUEUE_EMAIL@@", queue.getEmailAlias() + getEmailDomain());
		templateParser.setTag("@@TICKET_ID@@", ticket.getId().toString());
		templateParser.setTag("@@TICKET_SUBJECT@@", ticket.getSubject());
		String context = preferencesConfig.getRootXTrackerUriContext();
		if (context.endsWith("/")) {
			context = context.substring(0, context.length() - 1);
		}
		templateParser.setTag("@@TICKET_URI@@", context + "/open.do?id=" + ticket.getId());

		Person author = history.getAuthor();
		Date historyDate = history.getCreateDate();
		Integer historyImportance = history.getImportance();
		String historySubject = history.getSubject();
		String historyContent = history.getContent();
		templateParser.setTag("@@HISTORY_AUTHOR@@", author.getRealname());
		// XXX Need to format the date
		templateParser.setTag("@@HISTORY_DATE@@", historyDate.toString());
		templateParser.setTag("@@HISTORY_SUBJECT@@", historySubject);
		templateParser.setTag("@@HISTORY_MESSAGE@@", historyContent);
		templateParser.setTag("@@HISTORY_IMPORTANCE@@", historyImportance.toString());

		if (tokenTemplate == null) {
			tokenTemplate = getDefaultTicketInQueueTemplate();
		}
		templateParser.setBuffer(tokenTemplate);
		StringBuffer message = templateParser.parseBuffer();
		return message;
	}

	private StringBuffer generateTicketDueTemplate(Ticket ticket, int days) {
		Template templateParser = new Template();
		templateParser.setTag("@@TICKET_ID@@", ticket.getId().toString());
		templateParser.setTag("@@TICKET_SUBJECT@@", ticket.getSubject());
		DateFormatter dateFormatter = new DateFormatter();
		templateParser.setTag("@@TICKET_DUEDATE@@", dateFormatter.formatStandardDate(ticket.getDueDate()));
		templateParser.setTag("@@DAYS@@", ((days > 0) ? "in " + Integer.toString(days) + " days" : "today"));
		String context = preferencesConfig.getRootXTrackerUriContext();
		if (context.endsWith("/")) {
			context = context.substring(0, context.length() - 1);
		}
		templateParser.setTag("@@TICKET_URI@@", context + "/open.do?id=" + ticket.getId());

		StringBuffer template = getDefaultTicketDueTemplate();
		templateParser.setBuffer(template);
		StringBuffer message = templateParser.parseBuffer();
		return message;
	}

	protected Hashtable<String, String> getMailHeaders() {
		headers.put("X-Mailer", "jMonkey XTracker");
		return headers;
	}

	public void sendNewPersonMail(Person newPerson, String newPassword, Queue queue) throws Exception {
		logger.debug("Sending Welcome Mail for Person [" + newPerson.getUsername() + "] joining Queue [" + queue.getName() + "]");
		StringBuffer message = generateNewPersonTemplate(newPerson, newPassword, queue);
		Hashtable<String, String> mailHeaders = getMailHeaders();

		SMTPMail smtpMail = new SMTPMail();
		smtpMail.setHost(hostName);

		smtpMail.addTo(newPerson.getEmailAddress(), newPerson.getRealname());

		String emailDomain = getEmailDomain();

		String fromAddr = queue.getEmailAlias() + emailDomain;
		smtpMail.setFrom(fromAddr, queue.getName());
		smtpMail.setSubject("XTracker Account Created");

		smtpMail.setMessage(message.toString());
		smtpMail.setHeaders(mailHeaders);

		smtpMail.setSentDate(new Date());

		if (username != null) {
			smtpMail.setAuthentication(username, password);
		}

		smtpMail.send();
	}

	public void sendNewTicketInQueueMail(Ticket ticket, History history, Queue queue) throws Exception {
		logger.debug("Sending New Ticket for Queue " + queue.getName());
		StringBuffer message = generateNewTicketInQueueTemplate(ticket, history, queue);
		Hashtable<String, String> mailHeaders = getMailHeaders();

		SMTPMail smtpMail = new SMTPMail();
		smtpMail.setHost(hostName);

		Person author = history.getAuthor();
		logger.debug("Author: " + author.getRealname());

		smtpMail.setSubject("New tickets to assign in Queue " + queue.getName());
		smtpMail.setMessage(message.toString());
		smtpMail.setHeaders(mailHeaders);

		smtpMail.setSentDate(new Date());

		String fromEmail = QueueUtil.getQueueEmailAddress(mailConfig, ticket.getQueue());
		logger.debug("From: " + fromEmail);
		smtpMail.setFrom(fromEmail, queue.getName());

		Person manager = queue.getManager();
		smtpMail.addTo(manager.getEmailAddress(), manager.getRealname());

		smtpMail.send();
	}

	// private String getQueueEmailAddress(Queue queue) {
	// logger.debug("Queue: " + queue.getName());
	// String emailDomain = mailConfig.getEmailDomain();
	// if (!emailDomain.startsWith("@")) {
	// emailDomain = "@" + emailDomain;
	// }
	// String fromEmail = queue.getEmailAlias() + emailDomain;
	// return fromEmail;
	// }

	private String getEmailDomain() {
		String emailDomain = mailConfig.getEmailDomain();
		if (!emailDomain.startsWith("@")) {
			emailDomain = "@" + emailDomain;
		}
		return emailDomain;
	}

	@SuppressWarnings("unchecked")
	public void sendReplyMail(Ticket ticket, History history) throws Exception {
		logger.debug("Sending Reply Mail for Ticket [" + ticket.getId() + "] and history [" + history.getSubject() + "]");
		StringBuffer message = generateReplyTemplate(ticket, history);
		Hashtable mailHeaders = getMailHeaders();

		SMTPMail smtpMail = new SMTPMail();
		smtpMail.setHost(hostName);

		Person author = history.getAuthor();
		logger.debug("Author: " + author.getRealname());

		Person requestor = ticket.getRequestor();
		logger.debug("Requestor: " + requestor.getRealname());
		if (!author.getId().equals(requestor.getId())) {
			smtpMail.addTo(requestor.getEmailAddress(), requestor.getRealname());
		}

		List<Person> toList = ticket.getOwners();
		for (Person toPerson : toList) {
			logger.debug("Owner: " + toPerson.getRealname());
			if (!author.getId().equals(toPerson.getId())) {
				smtpMail.addTo(toPerson.getEmailAddress(), toPerson.getRealname());
			}
		}

		if (smtpMail.hasRecipient()) {
			List<Person> ccList = ticket.getWatchers();
			for (Person ccPerson : ccList) {
				logger.debug("Watcher: " + ccPerson.getRealname());
				if (!author.getId().equals(ccPerson.getId())) {
					if (toList.size() > 0) {
						smtpMail.addCc(ccPerson.getEmailAddress(), ccPerson.getRealname());
					} else {
						smtpMail.addTo(ccPerson.getEmailAddress(), ccPerson.getRealname());
					}
				}
			}

			Queue queue = ticket.getQueue();
			String fromEmail = QueueUtil.getQueueEmailAddress(mailConfig, queue);
			logger.debug("From: " + fromEmail);
			smtpMail.setFrom(fromEmail, requestor.getRealname() + " (via XTracker)");

			TokenManipulator tokenMaipulator = new TokenManipulator();
			String newSubject = tokenMaipulator.addTokenToSubject(ticket.getId(), history.getSubject());
			smtpMail.setSubject(newSubject);
			logger.debug("Subject: " + newSubject);

			smtpMail.setMessage(message.toString());
			smtpMail.setHeaders(mailHeaders);

			smtpMail.setSentDate(new Date());
			if (username != null) {
				logger.debug("Using SMTP Authentication: " + username);
				smtpMail.setAuthentication(username, password);
			}

			List<MailReference> refList = history.getMessageReferences();
			if (refList.size() > 0) {
				StringBuffer refBuffer = new StringBuffer();
				for (MailReference ref : refList) {
					refBuffer.append(ref.getMessageId());
					refBuffer.append("\n");
				}
				smtpMail.addHeader("References", refBuffer.toString());
			}

			logger.debug("Sending mail...");
			smtpMail.send();
		}
	}

	private void addMessageReferences(ReceivedMailMessage mailMessage, SMTPMail smtpMail) {
		List<String> refs = mailMessage.getMessageReferenceIds();
		if (refs.size() > 0) {
			StringBuffer refBuffer = new StringBuffer();
			for (String string : refs) {
				refBuffer.append(string);
				refBuffer.append("\n");
			}
			smtpMail.addHeader("References", refBuffer.toString());
		}
	}

	public void addHeader(String key, String value) {
		headers.put(key, value);
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void addTokenParam(String key, String value) {
		tokenParams.put(key, value);
	}

	public StringBuffer getTokenTemplate() {
		return tokenTemplate;
	}

	public void setTokenTemplate(StringBuffer tokenTemplate) {
		this.tokenTemplate = tokenTemplate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void sendTicketDueDatePending(List<Ticket> ticketList, int days) throws Exception {
		logger.debug("Sending Tickets Due message");
		Hashtable<String, String> mailHeaders = getMailHeaders();
		SMTPMail smtpMail = new SMTPMail();
		smtpMail.setHost(hostName);
		smtpMail.setHeaders(mailHeaders);
		smtpMail.setSentDate(new Date());

		for (Ticket ticket : ticketList) {
			Queue queue = ticket.getQueue();
			List<Person> toOwners = ticket.getOwners();

			smtpMail.setSubject("Ticket #" + ticket.getId() + " is due in " + days + " days");

			StringBuffer message = generateTicketDueTemplate(ticket, days);
			smtpMail.setMessage(message.toString());

			String fromEmail = QueueUtil.getQueueEmailAddress(mailConfig, queue);
			logger.debug("From: " + fromEmail);
			smtpMail.setFrom(fromEmail, queue.getName());

			for (Person person : toOwners) {
				smtpMail.addTo(person.getEmailAddress(), person.getRealname());
			}

			smtpMail.send();
		}
	}

	public void sendTicketDueDateToday(List<Ticket> ticketList) throws Exception {
		logger.debug("Sending Ticket Due today message");
		Hashtable<String, String> mailHeaders = getMailHeaders();
		SMTPMail smtpMail = new SMTPMail();
		smtpMail.setHost(hostName);
		smtpMail.setHeaders(mailHeaders);
		smtpMail.setSentDate(new Date());

		for (Ticket ticket : ticketList) {
			Queue queue = ticket.getQueue();
			List<Person> toOwners = ticket.getOwners();

			smtpMail.setSubject("Ticket #" + ticket.getId() + " is due today");

			StringBuffer message = generateTicketDueTemplate(ticket, 0);
			smtpMail.setMessage(message.toString());

			String fromEmail = QueueUtil.getQueueEmailAddress(mailConfig, queue);
			logger.debug("From: " + fromEmail);
			smtpMail.setFrom(fromEmail, queue.getName());

			for (Person person : toOwners) {
				smtpMail.addTo(person.getEmailAddress(), person.getRealname());
			}

			smtpMail.send();
		}
	}

	public void sendErrorReport(String to, String from, String content) throws Exception {
		logger.debug("Sending Error Report");
		Hashtable<String, String> mailHeaders = getMailHeaders();
		SMTPMail smtpMail = new SMTPMail();
		smtpMail.setHost(hostName);
		smtpMail.setHeaders(mailHeaders);
		smtpMail.setSentDate(new Date());
		smtpMail.setSubject("Auto generated error report");
		smtpMail.setMessage(content);
		smtpMail.setFrom(from);
		smtpMail.addTo(to);
		smtpMail.send();
	}

	public void sendNewTicketAssigned(Ticket ticket, History history, Queue queue) throws Exception {
		logger.debug("Sending New Ticket for Queue " + queue.getName());
		StringBuffer message = generateNewTicketAssignedTemplate(ticket, history, queue);
		Hashtable<String, String> mailHeaders = getMailHeaders();

		SMTPMail smtpMail = new SMTPMail();
		smtpMail.setHost(hostName);

		Person author = history.getAuthor();
		logger.debug("Author: " + author.getRealname());

		smtpMail.setSubject("A New ticket was assigned to you in Queue " + queue.getName());
		smtpMail.setMessage(message.toString());
		smtpMail.setHeaders(mailHeaders);

		smtpMail.setSentDate(new Date());

		String fromEmail = QueueUtil.getQueueEmailAddress(mailConfig, ticket.getQueue());
		logger.debug("From: " + fromEmail);
		smtpMail.setFrom(fromEmail, queue.getName());

		List<Person> owners = ticket.getOwners();
		for (Person owner : owners) {
			logger.debug("Adding To: " + owner.getEmailAddress());
			smtpMail.addTo(owner.getEmailAddress(), owner.getRealname());
		}

		smtpMail.send();
	}

	private StringBuffer generateNewTicketAssignedTemplate(Ticket ticket, History history, Queue queue) {
		Template templateParser = new Template();
		templateParser.setTag("@@QUEUE_NAME@@", queue.getName());
		templateParser.setTag("@@QUEUE_EMAIL@@", queue.getEmailAlias() + getEmailDomain());
		templateParser.setTag("@@TICKET_ID@@", ticket.getId().toString());
		templateParser.setTag("@@TICKET_SUBJECT@@", ticket.getSubject());
		String context = preferencesConfig.getRootXTrackerUriContext();
		if (context.endsWith("/")) {
			context = context.substring(0, context.length() - 1);
		}
		templateParser.setTag("@@TICKET_URI@@", context + "/open.do?id=" + ticket.getId());

		Person author = history.getAuthor();
		Date historyDate = history.getCreateDate();
		Integer historyImportance = history.getImportance();
		String historySubject = history.getSubject();
		String historyContent = history.getContent();
		templateParser.setTag("@@HISTORY_AUTHOR@@", author.getRealname());
		// XXX Need to format the date
		templateParser.setTag("@@HISTORY_DATE@@", historyDate.toString());
		templateParser.setTag("@@HISTORY_SUBJECT@@", historySubject);
		templateParser.setTag("@@HISTORY_MESSAGE@@", historyContent);
		templateParser.setTag("@@HISTORY_IMPORTANCE@@", historyImportance.toString());

		if (tokenTemplate == null) {
			tokenTemplate = getDefaultTicketAssignedTemplate();
		}
		templateParser.setBuffer(tokenTemplate);
		StringBuffer message = templateParser.parseBuffer();
		return message;
	}

	private StringBuffer getDefaultTicketAssignedTemplate() {
		// XXX partially refactored to load from DB.
		StringBuffer buffer = loadTemplate("xtracker.required.ticket.assigned");
		return buffer;
	}

	private static void appendSentByTagLine(StringBuffer buffer) {
		buffer.append("\n\n-- \n");
		buffer.append("Sent by jmonkey.com XTracker\n");
		buffer.append("http://xtracker.berlios.de\n");
	}

	public static StringBuffer getDefaultTicketInQueueTemplate() {
		// XXX partially refactored to load from DB.
		StringBuffer buffer = loadTemplate("xtracker.required.ticket.inqueue");
		return buffer;
	}

	public static StringBuffer getDefaultReplyTemplate() {
		// XXX partially refactored to load from DB.
		StringBuffer buffer = loadTemplate("xtracker.required.ticket.reply");
		return buffer;
	}

	public static StringBuffer getDefaultNewPersonTemplate() {
		// XXX partially refactored to load from DB.
		StringBuffer buffer = loadTemplate("xtracker.required.new.person");
		return buffer;
	}

	private static StringBuffer loadTemplate(String key) {
		StringBuffer buffer = new StringBuffer();

		TemplateDataLoader loader = new TemplateDataLoader();
		TemplateData data;
		try {
			data = loader.loadByResourceKey(key);
			buffer.append(data.getContent());
		} catch (HibernateException e) {
			Logger.getLogger(SMTPMailSender.class).error("failed to load: " + key, e);
			buffer.append(e.getMessage());
		}
		appendSentByTagLine(buffer);
		return buffer;
	}

	public static StringBuffer getDefaultTicketDueTemplate() {
		StringBuffer buffer = loadTemplate("xtracker.required.ticket.dueindays");
		return buffer;
	}

}
