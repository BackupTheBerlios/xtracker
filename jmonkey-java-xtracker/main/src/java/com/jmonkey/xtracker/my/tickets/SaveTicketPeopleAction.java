package com.jmonkey.xtracker.my.tickets;

import java.util.Date;
import java.util.List;

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
		Person person = loader.loadPersonForPrincipal(authEnv.getPrincipal());
		Date messageDate = new Date();

		Long ticketId = ticketPeopleForm.getId();

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);

		TicketPersistor ticketSaver = new TicketPersistor();

		addOwner(ticketPeopleForm, person, messageDate, ticket);
		ticketSaver.updateTicket(ticket);

		addWatcher(ticketPeopleForm, person, messageDate, ticket);
		ticketSaver.updateTicket(ticket);

		String[] deletedOwners = ticketPeopleForm.getDeletedOwners();
		deleteOwners(person, messageDate, ticket, deletedOwners);
		ticketSaver.updateTicket(ticket);

		String[] deletedWatchers = ticketPeopleForm.getDeletedWatchers();
		deleteWatchers(person, messageDate, ticket, deletedWatchers);
		ticketSaver.updateTicket(ticket);

		// ticketSaver.updateTicket(ticket);

		ActionForwardFactory forwardFactory = new ActionForwardFactory();
		return forwardFactory.getOpenTicketForward(ticketId);
		// return mapping.findForward("mytickets");
	}

	private void addOwner(TicketPeopleForm ticketPeopleForm, Person person, Date messageDate, Ticket ticket) throws HibernateException {
		String newOwnerId = ticketPeopleForm.getNewOwnerId();
		if (newOwnerId != null && newOwnerId.length() > 0) {
			PersonLoader loader = new PersonLoader();
			Person newPerson = loader.loadPerson(newOwnerId);
			ticket.getOwners().add(newPerson);
			String historySubject = "System: Owner " + newPerson.getRealname() + " added by " + person.getRealname();
			addHistoryToTicket(ticket, messageDate, historySubject, null, new Integer(3));
		}
	}

	private void addWatcher(TicketPeopleForm ticketPeopleForm, Person person, Date messageDate, Ticket ticket) throws HibernateException {
		String newWatcherId = ticketPeopleForm.getNewWatcherId();
		if (newWatcherId != null && newWatcherId.length() > 0) {
			PersonLoader loader = new PersonLoader();
			Person newPerson = loader.loadPerson(newWatcherId);
			ticket.getWatchers().add(newPerson);
			String historySubject = "System: Watcher " + newPerson.getRealname() + " added by " + person.getRealname();
			addHistoryToTicket(ticket, messageDate, historySubject, null, new Integer(3));
		}
	}

	private void deleteOwners(Person person, Date messageDate, Ticket ticket, String[] deletedOwners) {
		for (String ownerId : deletedOwners) {
			List<Person> owners = ticket.getOwners();
			for (int i = 0; i < owners.size(); i++) {
				Person curOwner = owners.get(i);
				if (curOwner.getId().equals(ownerId)) {
					owners.remove(i);
					String historySubject = "System: Owner " + curOwner.getRealname() + " removed by " + person.getRealname();
					addHistoryToTicket(ticket, messageDate, historySubject, null, new Integer(3));
					break;
				}
			}
		}
	}

	private void deleteWatchers(Person person, Date messageDate, Ticket ticket, String[] deleted) {
		for (String personId : deleted) {
			List<Person> watchers = ticket.getWatchers();
			for (int i = 0; i < watchers.size(); i++) {
				Person curWatcher = watchers.get(i);
				if (curWatcher.getId().equals(personId)) {
					watchers.remove(i);
					String historySubject = "System: Watcher " + curWatcher.getRealname() + " removed by " + person.getRealname();
					addHistoryToTicket(ticket, messageDate, historySubject, null, new Integer(3));
					break;
				}
			}
		}
	}

}
