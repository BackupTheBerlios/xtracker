package com.jmonkey.xtracker.my.tickets;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class EditTicketPeopleAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(EditTicketPeopleAction.class);

	public EditTicketPeopleAction() {
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
		TicketPeopleForm ticketPeopleForm = (TicketPeopleForm) form;
		Long ticketId = ticketPeopleForm.getId();

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);
		ticketPeopleForm.setRequestor(ticket.getRequestor());
		
		List<Person> ownerList = ticket.getOwners();
		Map<String, String> ownerSourceMap = new TreeMap<String, String>();
		ticketPeopleForm.setOwnerList(ownerList);
		for (Person person : ownerList) {
			ownerSourceMap.put(person.getId(), person.getRealname());
		}
		ticketPeopleForm.setOwnerSource(ownerSourceMap);
		
		ticketPeopleForm.setWatcherList(ticket.getWatchers());

		PersonLoader personLoader = new PersonLoader();
		List<Person> personList = personLoader.loadPersonList(true);
		ticketPeopleForm.setAllPeopleList(personList);

		request.getSession().setAttribute("ticketPeopleForm", ticketPeopleForm);
		return mapping.findForward("input");
	}
}
