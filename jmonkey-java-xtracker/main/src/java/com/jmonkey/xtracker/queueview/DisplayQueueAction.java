package com.jmonkey.xtracker.queueview;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.ProjectLoader;
import com.jmonkey.xtracker.issue.loader.QueueLoader;
import com.jmonkey.xtracker.issue.loader.TicketLoader;

public class DisplayQueueAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(DisplayQueueAction.class);

	public DisplayQueueAction() {
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
		DisplayQueueForm displayQueueForm = (DisplayQueueForm) form;
		String queueId = displayQueueForm.getId();

		QueueLoader queueLoader = new QueueLoader();
		Queue queue = queueLoader.loadQueue(queueId);
		List<Queue> queueList = queueLoader.loadQueueList(false, false);
		displayQueueForm.setQueueList(queueList);

		ProjectLoader projectLoader = new ProjectLoader();
		List<Project> projectList = projectLoader.loadProjectList(false, false);
		displayQueueForm.setProjectList(projectList);

		TicketLoader ticketLoader = new TicketLoader();
		List<Ticket> queueTicketList = ticketLoader.loadTicketsInQueue(queue,false);
		displayQueueForm.setTicketList(queueTicketList);

		request.getSession().setAttribute("displayQueueForm", displayQueueForm);

		return mapping.findForward("input");
	}
}
