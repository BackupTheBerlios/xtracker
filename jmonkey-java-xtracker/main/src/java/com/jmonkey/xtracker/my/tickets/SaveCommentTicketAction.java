package com.jmonkey.xtracker.my.tickets;

import java.util.Date;

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
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class SaveCommentTicketAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(SaveCommentTicketAction.class);

	public SaveCommentTicketAction() {
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
		addTicketHistory(request, ticketMessageForm, ticket);

		forceClosedTicketOpen(ticket);
		TicketPersistor ticketSaver = new TicketPersistor();
		ticketSaver.updateTicket(ticket);

		ActionForwardFactory forwardFactory = new ActionForwardFactory();
		return forwardFactory.getOpenTicketForward(ticketId);
		// return mapping.findForward("display");
	}

	private void addTicketHistory(HttpServletRequest request, TicketMessageForm form, Ticket ticket) throws HibernateException {
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
	}

}
