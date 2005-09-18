package com.jmonkey.xtracker.anon.tickets;

import java.util.Date;
import java.util.prefs.BackingStoreException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.StatusLoader;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.smtp.SMTPMailSender;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class SaveAnonReplyTicketAction extends BaseAction {
	private MailConfig	mailConfig	= new MailConfig();
	private Logger		logger		= LogManager.getLogger(SaveAnonReplyTicketAction.class);

	public SaveAnonReplyTicketAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		logger.debug("Save called...");
		AnonTicketMessageForm anonTicketMessageForm = (AnonTicketMessageForm) form;
		Long ticketId = anonTicketMessageForm.getId();

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);
		History history = addTicketHistory(request, anonTicketMessageForm, ticket);
		setStatusToOpen(ticket);
		TicketPersistor ticketSaver = new TicketPersistor();
		ticketSaver.updateTicket(ticket);

		sendReplyEmail(ticket, history);

		AnonForwardFactory forwardFactory = new AnonForwardFactory();
		return forwardFactory.getOpenTicketForward(ticketId);
	}

	private void sendReplyEmail(Ticket ticket, History history) throws BackingStoreException, Exception {
		// JdkPrefsConfig config = JdkPrefsConfig.loadedInstance();
		SMTPMailSender sender = new SMTPMailSender();
		sender.setHostName(mailConfig.getSmtpMailHost());
		if (mailConfig.isSmtpHostRequiresPassword()) {
			sender.setUsername(mailConfig.getSmtpHostUsername());
			sender.setPassword(mailConfig.getSmtpHostPassword());
		}
		sender.sendReplyMail(ticket, history);
	}

	private void setStatusToOpen(Ticket ticket) throws HibernateException {
		Status oldStatus = ticket.getStatus();
		if (oldStatus.getId() == 0) {
			StatusLoader statusLoader = new StatusLoader();
			Status nextStatus = statusLoader.loadStatus(1L);
			ticket.setStatus(nextStatus);
		}
	}

	private History addTicketHistory(HttpServletRequest request, AnonTicketMessageForm form, Ticket ticket) throws HibernateException {
		AuthEnvironment authEnv = new AuthEnvironment(request);
		PersonLoader personLoader = new PersonLoader();
		Person author = personLoader.loadPersonForPrincipal(authEnv.getPrincipal());
		History history = new History();
		history.setSystem(false);
		history.setAuthor(author);
		history.setSubject(form.getSubject());
		history.setImportance(form.getImportance());
		history.setContent(form.getContent());
		history.setCreateDate(new Date());
		String encoding = request.getCharacterEncoding();
		if (encoding == null) {
			encoding = System.getProperty("file.encoding");
		}
		history.setEncoding(encoding);
		ticket.getHistory().add(history);
		return history;
	}
}
