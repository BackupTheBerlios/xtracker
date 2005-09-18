package com.jmonkey.xtracker.my.tickets;

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
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.smtp.SMTPMailSender;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class SaveReplyTicketAction extends BaseAction {
	private Logger		logger		= LogManager.getLogger(SaveReplyTicketAction.class);
	private MailConfig	mailConfig	= new MailConfig();

	public SaveReplyTicketAction() {
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
		TicketMessageForm ticketMessageForm = (TicketMessageForm) form;
		Long ticketId = ticketMessageForm.getId();

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);
		History history = addTicketHistory(request, ticketMessageForm, ticket);

		forceClosedTicketOpen(ticket);

		logger.debug("Updating ticket...");
		TicketPersistor ticketSaver = new TicketPersistor();
		ticketSaver.updateTicket(ticket);

		sendReplyEmail(ticket, history);

		ActionForwardFactory forwardFactory = new ActionForwardFactory();
		return forwardFactory.getOpenTicketForward(ticketId);
		// return mapping.findForward("display");
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

	private History addTicketHistory(HttpServletRequest request, TicketMessageForm form, Ticket ticket) throws HibernateException {
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
