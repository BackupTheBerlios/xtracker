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
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class SaveTicketPeopleAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(SaveTicketPeopleAction.class);

	public SaveTicketPeopleAction() {
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
		TicketPeopleForm ticketPeopleForm = (TicketPeopleForm) form;
		
		AuthEnvironment authEnv = new AuthEnvironment(request);
		PersonLoader loader = new PersonLoader();
		Person authenticatedPerson = loader.loadPersonForPrincipal(authEnv.getPrincipal());
		Date messageDate = new Date();

		Long ticketId = ticketPeopleForm.getId();

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);

		TicketPersistor ticketSaver = new TicketPersistor();
		PersonLoader personLoader = new PersonLoader();
		
		addOwners(ticketPeopleForm, authenticatedPerson, messageDate, ticket, personLoader);
//		ticketSaver.updateTicket(ticket);
		
		addWatchers(ticketPeopleForm, authenticatedPerson, messageDate, ticket, personLoader);
		
		ticketSaver.updateTicket(ticket);

		ActionForwardFactory forwardFactory = new ActionForwardFactory();
		return forwardFactory.getOpenTicketForward(ticketId);
		// return mapping.findForward("mytickets");
	}

	private void addWatchers(TicketPeopleForm ticketPeopleForm, Person person, Date messageDate, Ticket ticket, PersonLoader personLoader) throws HibernateException {
		logger.debug("Clearing watcher list...");
		ticket.getWatchers().clear();
		logger.debug("Adding selected watchers...");
		String[] selectedWatchers = ticketPeopleForm.getSelectedWatchers();
		for (String watcherId : selectedWatchers) {
			Person newPerson = personLoader.loadPerson(watcherId);
			ticket.getWatchers().add(newPerson);
			logger.debug("Added watcher: " + newPerson.getInitials());
			String historySubject = person.getRealname() + " added watcher " + newPerson.getRealname();
			addHistoryToTicket(ticket, messageDate, historySubject, null, new Integer(3));
		}
	}

	private void addOwners(TicketPeopleForm ticketPeopleForm, Person person, Date messageDate, Ticket ticket, PersonLoader personLoader) throws HibernateException {
		logger.debug("Clearing owner list...");
		ticket.getOwners().clear();
		logger.debug("Adding selected owners...");
		String[] selectedOwners = ticketPeopleForm.getSelectedOwners();
		for (String ownerId : selectedOwners) {
			Person newPerson = personLoader.loadPerson(ownerId);
			ticket.getOwners().add(newPerson);
			logger.debug("Added owner: " + newPerson.getInitials());
			String historySubject = person.getRealname() + " added owner " + newPerson.getRealname();
			addHistoryToTicket(ticket, messageDate, historySubject, null, new Integer(3));
		}
	}
}
