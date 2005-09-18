package com.jmonkey.xtracker.anon.tickets;

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
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class DisplayAnonTicketsAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(DisplayAnonTicketsAction.class);

	public DisplayAnonTicketsAction() {
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
		AnonTicketsForm anonTicketsForm = (AnonTicketsForm) form;

		if (anonTicketsForm == null) {
			anonTicketsForm = new AnonTicketsForm();
		}

		AuthEnvironment authEnv = new AuthEnvironment(request);
		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.loadPersonForPrincipal(authEnv.getPrincipal());

		TicketLoader ticketLoader = new TicketLoader();
		List<Ticket> ticketList = ticketLoader.loadTicketListForRequestor(person, false);

		anonTicketsForm.setTicketList(ticketList);
		request.getSession().setAttribute("anonTicketsForm", anonTicketsForm);

		return mapping.findForward("input");
	}
}
