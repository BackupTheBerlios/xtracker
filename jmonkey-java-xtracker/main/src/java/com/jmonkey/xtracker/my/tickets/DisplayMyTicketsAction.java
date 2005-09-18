package com.jmonkey.xtracker.my.tickets;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.auth.PathForwardFactory;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.ProjectLoader;
import com.jmonkey.xtracker.issue.loader.QueueLoader;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class DisplayMyTicketsAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(DisplayMyTicketsAction.class);

	public DisplayMyTicketsAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Display called...");
		MyTicketsForm myTicketsForm = (MyTicketsForm) form;
		AuthEnvironment authEnv = new AuthEnvironment(request);
		Principal principal = authEnv.getPrincipal();
		ActionForward forward = null;
		if (principal == null) {
			PathForwardFactory forwardFactory = new PathForwardFactory();
			String redirUrl = authEnv.getRequestLocation();
			logger.debug("Requesting login and redir to: " + redirUrl);
			forward = forwardFactory.getRedirectingLoginForward(redirUrl);
		} else {

			PersonLoader personLoader = new PersonLoader();
			Person person = personLoader.loadPersonForPrincipal(authEnv.getPrincipal());

			TicketLoader ticketLoader = new TicketLoader();
			List<Ticket> ticketList = ticketLoader.loadTicketListForPerson(person, false);
			List<Ticket> requestedTicketList = ticketLoader.loadTicketListForRequestor(person, false);
			List<Ticket> watchedTicketList = ticketLoader.loadWatchedTicketListForPerson(person, false);
			List<Ticket> unassignedTicketList = ticketLoader.loadUnassignedTicketListForPersonQueue(person, 10);

			QueueLoader queueLoader = new QueueLoader();
			List<Queue> queueList = queueLoader.loadQueueList(false, false);

			ProjectLoader projectLoader = new ProjectLoader();
			List<Project> projectList = projectLoader.loadProjectList(false, false);

			myTicketsForm.setTicketList(ticketList);
			myTicketsForm.setWatchedTicketList(watchedTicketList);
			myTicketsForm.setRequestedTicketList(requestedTicketList);
			myTicketsForm.setQueueList(queueList);
			myTicketsForm.setProjectList(projectList);

			myTicketsForm.setUnassignedTicketList(unassignedTicketList);

			// TicketSorter ticketSorter = new TicketSorter();
			// ticketSorter.setTickets(ticketList);
			// MenuComponent menuRoot = new MenuComponent();
			// menuRoot.setName("tickets");
			// setupTicketTreeView(request, menuRoot, ticketSorter);

			request.getSession().setAttribute("myTicketsForm", myTicketsForm);

			forward = mapping.findForward("input");
		}
		return forward;
	}

}
