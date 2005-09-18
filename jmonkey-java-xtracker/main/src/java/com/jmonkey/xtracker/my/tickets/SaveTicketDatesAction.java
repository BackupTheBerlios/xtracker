package com.jmonkey.xtracker.my.tickets;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;
import com.jmonkey.xtracker.util.DateFormatter;
import com.jmonkey.xtracker.util.DateParser;

public class SaveTicketDatesAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(SaveTicketDatesAction.class);

	public SaveTicketDatesAction() {
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
		logger.debug("Edit called...");
		TicketDatesForm ticketDatesForm = (TicketDatesForm) form;
		Long ticketId = ticketDatesForm.getId();

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);
		
		DateFormatter formatter = new DateFormatter();
		DateParser parser = new DateParser();

		String dueDateStr = ticketDatesForm.getDueDate();
		if (dueDateStr != null && dueDateStr.length() > 0) {
			Date dueDate = parser.parseStandardDate(dueDateStr);
			ticket.setDueDate(dueDate);

			AuthEnvironment authEnv = new AuthEnvironment(request);
			PersonLoader personLoader = new PersonLoader();
			Person principal = personLoader.loadPersonForPrincipal(authEnv.getPrincipal());
			String historySubject = principal.getRealname() + " chenged Due Date to " + formatter.formatStandardDate(dueDate);
			addHistoryToTicket(ticket, new Date(), historySubject, null, new Integer(3));

		} else {
			// XXX we're removing the due date
			ticket.setDueDate(null);
			AuthEnvironment authEnv = new AuthEnvironment(request);
			PersonLoader personLoader = new PersonLoader();
			Person principal = personLoader.loadPersonForPrincipal(authEnv.getPrincipal());
			String historySubject = principal.getRealname() + " removed Due Date";
			addHistoryToTicket(ticket, new Date(), historySubject, null, new Integer(3));
		}

		TicketPersistor persistor = new TicketPersistor();
		persistor.updateTicket(ticket);

		ActionForwardFactory forwardFactory = new ActionForwardFactory();
		return forwardFactory.getOpenTicketForward(ticketId);
	}
}
