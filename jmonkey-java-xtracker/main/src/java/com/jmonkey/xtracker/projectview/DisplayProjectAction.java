package com.jmonkey.xtracker.projectview;

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

public class DisplayProjectAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(DisplayProjectAction.class);

	public DisplayProjectAction() {
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
		DisplayProjectForm displayProjectForm = (DisplayProjectForm) form;
		String projectId = displayProjectForm.getId();

		QueueLoader queueLoader = new QueueLoader();
		List<Queue> queueList = queueLoader.loadQueueList(false,false);
		displayProjectForm.setQueueList(queueList);

		ProjectLoader projectLoader = new ProjectLoader();
		Project project = projectLoader.loadProject(projectId);
		List<Project> projectList = projectLoader.loadProjectList(false,false);
		displayProjectForm.setProjectList(projectList);

		TicketLoader ticketLoader = new TicketLoader();
		List<Ticket> queueTicketList = ticketLoader.loadTicketsInProject(project,false);
		displayProjectForm.setTicketList(queueTicketList);

		request.getSession().setAttribute("displayProjectForm", displayProjectForm);

		return mapping.findForward("input");
	}
}
