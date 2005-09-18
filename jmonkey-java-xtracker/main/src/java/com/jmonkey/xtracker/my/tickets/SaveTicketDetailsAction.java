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
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class SaveTicketDetailsAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(SaveTicketDetailsAction.class);

	public SaveTicketDetailsAction() {
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
		TicketDetailsForm ticketDetailsForm = (TicketDetailsForm) form;
		Long ticketId = ticketDetailsForm.getId();

		AuthEnvironment authEnv = new AuthEnvironment(request);
		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.loadPersonForPrincipal(authEnv.getPrincipal());

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);

		setTicketDetails(ticketDetailsForm, ticket, person);
		TicketPersistor ticketSaver = new TicketPersistor();
		ticketSaver.updateTicket(ticket);

		ActionForwardFactory forwardFactory = new ActionForwardFactory();
		return forwardFactory.getOpenTicketForward(ticketId);
		// return mapping.findForward("mytickets");
	}

	private void setTicketDetails(TicketDetailsForm form, Ticket ticket, Person person) throws HibernateException {
		Date createDate = new Date();

		String subject = form.getSubject();
		if (!ticket.getSubject().equals(subject)) {
			String origSubject = ticket.getSubject();
			ticket.setSubject(subject);

			String historySubject = person.getRealname() + " changed the ticket Subject";
			String historyMessage = "The Subject was changed by " + person.getRealname() + ":\n Original Subject:\n" + origSubject + "\nNew Subject:\n" + subject + "\n";
			addHistoryToTicket(ticket, createDate, historySubject, historyMessage, new Integer(3));
		}

		Integer priority = form.getPriority();
		if (!ticket.getPriority().equals(priority)) {
			Integer origPriority = ticket.getPriority();
			ticket.setPriority(priority);

			String historySubject = person.getRealname() + " changed the Priority from " + origPriority.toString() + " to " + priority.toString();
			addHistoryToTicket(ticket, createDate, historySubject, null, new Integer(3));
		}

		Double worked = form.getWorked();
		if (ticket.getWorked() != null) {
			if (worked != null && !ticket.getWorked().equals(worked)) {
				Double origWorked = ticket.getWorked();
				ticket.setWorked(worked);

				String historySubject = person.getRealname() + " changed the hours worked from " + origWorked.toString() + " to " + worked.toString();
				addHistoryToTicket(ticket, createDate, historySubject, null, new Integer(3));
			}
		} else {
			if (worked != null) {
				ticket.setWorked(worked);
				String historySubject = person.getRealname() + " set the hours worked to " + worked.toString();
				addHistoryToTicket(ticket, createDate, historySubject, null, new Integer(3));
			}
		}

		long dispositionId = form.getDispositionId();
		if (ticket.getDisposition().getId() != dispositionId) {
			Disposition origDisposition = ticket.getDisposition();
			DispositionLoader dispositionLoader = new DispositionLoader();
			Disposition disposition = dispositionLoader.loadDisposition(dispositionId);
			ticket.setDisposition(disposition);
			String historySubject = person.getRealname() + " changed the Disposition from " + origDisposition.getLabel() + " to " + disposition.getLabel();
			addHistoryToTicket(ticket, createDate, historySubject, null, new Integer(3));
		}

		ProjectLoader projectLoader = new ProjectLoader();
		String projectId = form.getProjectId();
		if (projectId != null && !projectId.equals("")) {
			Project ticketProject = ticket.getProject();
			if (ticketProject != null) {
				if (!ticketProject.getId().equals(projectId)) {
					Project project = projectLoader.loadProject(projectId);
					ticket.setProject(project);
					String historySubject = person.getRealname() + " changed the Project from " + ticketProject.getName() + " to " + project.getName();
					addHistoryToTicket(ticket, createDate, historySubject, null, new Integer(3));
				}
			} else {
				Project project = projectLoader.loadProject(projectId);
				ticket.setProject(project);
				String historySubject = person.getRealname() + " set the Project to " + project.getName();
				addHistoryToTicket(ticket, createDate, historySubject, null, new Integer(3));
			}
		} else if (projectId == null || projectId.equals("")) {
			ticket.setProject(null);
			String historySubject = person.getRealname() + " removed the Project";
			addHistoryToTicket(ticket, createDate, historySubject, null, new Integer(3));
		}

		String queueId = form.getQueueId();
		if (!ticket.getQueue().getId().equals(queueId)) {
			Queue origQueue = ticket.getQueue();
			QueueLoader queueLoader = new QueueLoader();
			Queue queue = queueLoader.loadQueue(queueId);
			ticket.setQueue(queue);

			String historySubject = person.getRealname() + " changed the Queue from " + origQueue.getName() + " to " + queue.getName();
			addHistoryToTicket(ticket, createDate, historySubject, null, new Integer(3));
		}

		long severityId = form.getSeverityId();
		if (ticket.getSeverity().getId() != severityId) {
			Severity origSeverity = ticket.getSeverity();
			SeverityLoader severityLoader = new SeverityLoader();
			Severity severity = severityLoader.loadSeverity(severityId);
			ticket.setSeverity(severity);

			String historySubject = person.getRealname() + " changed the severity from " + origSeverity.getLabel() + " to " + severity.getLabel();
			addHistoryToTicket(ticket, createDate, historySubject, null, new Integer(3));
		}

		// XXX Should check ticket deps here
		// and not set it to closed if it has open deps.
		long statusId = form.getStatusId();
		if (ticket.getStatus().getId() != statusId) {
			boolean hasDeps = false;
			if (statusId == 3 && statusId == 4 && statusId == 6) {
				List<Ticket> dependsOn = ticket.getDependsOn();
				for (Ticket t : dependsOn) {
					long sid = t.getStatus().getId();
					if (sid != 3 && sid != 4 && sid != 6) {
						hasDeps = true;
						break;
					}
				}
			}
			if (!hasDeps) {
				Status origStatus = ticket.getStatus();
				StatusLoader statusLoader = new StatusLoader();
				Status status = statusLoader.loadStatus(statusId);
				ticket.setStatus(status);
				String historySubject = person.getRealname() + " changed the status from " + origStatus.getLabel() + " to " + status.getLabel();
				addHistoryToTicket(ticket, createDate, historySubject, null, new Integer(3));
			}
		}
	}
}
