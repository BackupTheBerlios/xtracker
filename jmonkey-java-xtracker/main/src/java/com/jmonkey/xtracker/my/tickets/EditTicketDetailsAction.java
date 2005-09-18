package com.jmonkey.xtracker.my.tickets;

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
import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.DispositionLoader;
import com.jmonkey.xtracker.issue.loader.ProjectLoader;
import com.jmonkey.xtracker.issue.loader.QueueLoader;
import com.jmonkey.xtracker.issue.loader.SeverityLoader;
import com.jmonkey.xtracker.issue.loader.StatusLoader;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.util.TicketUtil;

public class EditTicketDetailsAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(EditTicketDetailsAction.class);

	public EditTicketDetailsAction() {
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
		TicketDetailsForm ticketDetailsForm = (TicketDetailsForm) form;
		Long ticketId = ticketDetailsForm.getId();

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);
		setTicketDetails(ticketDetailsForm, ticket);
		setOptionLists(ticketDetailsForm);

		setStatusOptions(ticketDetailsForm, ticket);

		request.getSession().setAttribute("ticketDetailsForm", ticketDetailsForm);
		return mapping.findForward("input");
	}

	private void setStatusOptions(TicketDetailsForm ticketDetailsForm, Ticket ticket) throws HibernateException {
		StatusLoader statusLoader = new StatusLoader();
		List<Status> statusList = null;
		if (hasOpenDependsOn(ticket)) {
			logger.debug("Excluding status' that close a ticket...");
			statusList = statusLoader.loadStatusListNotClosed();
		} else {
			logger.debug("Including status' that close a ticket...");
			statusList = statusLoader.loadStatusList();
		}
		ticketDetailsForm.setStatusList(statusList);
	}

	private boolean hasOpenDependsOn(Ticket ticket) {
		boolean hasUnresolved = false;
		List<Ticket> depends = ticket.getDependsOn();
		for (Ticket t : depends) {
			hasUnresolved = !TicketUtil.isTicketClosed(t);
			if (hasUnresolved) {
				break;
			}
		}
		return hasUnresolved;
	}

	private void setOptionLists(TicketDetailsForm form) throws HibernateException {
		ProjectLoader projectLoader = new ProjectLoader();

		List<Project> projectList = projectLoader.loadProjectList(false, false);
		form.setProjectList(projectList);

		SeverityLoader severityLoader = new SeverityLoader();
		List<Severity> severityList = severityLoader.loadSeverityList();
		form.setSeverityList(severityList);

		DispositionLoader dispositionLoader = new DispositionLoader();
		List<Disposition> dispositionList = dispositionLoader.loadDispositionList(true, true);
		form.setDispositionList(dispositionList);

		QueueLoader queueLoader = new QueueLoader();
		List<Queue> queueList = queueLoader.loadQueueList(false, false);
		form.setQueueList(queueList);
	}

	private void setTicketDetails(TicketDetailsForm form, Ticket ticket) {
		form.setSubject(ticket.getSubject());
		form.setPriority(ticket.getPriority());

		Disposition disposition = ticket.getDisposition();
		if (disposition != null) {
			form.setDispositionId(ticket.getDisposition().getId());
		}

		Project project = ticket.getProject();
		if (project != null) {
			form.setProjectId(ticket.getProject().getId());
		} else {
			form.setProjectId("");
		}

		form.setQueueId(ticket.getQueue().getId());

		Severity severity = ticket.getSeverity();
		if (severity != null) {
			form.setSeverityId(severity.getId());
		}

		Status status = ticket.getStatus();
		if (status != null) {
			form.setStatusId(status.getId());
		}
	}

}
