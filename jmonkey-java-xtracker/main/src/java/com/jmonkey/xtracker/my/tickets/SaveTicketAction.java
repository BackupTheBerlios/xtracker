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
import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.History;
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
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.smtp.SMTPMailSender;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class SaveTicketAction extends BaseAction {
	private Logger		logger		= LogManager.getLogger(SaveTicketAction.class);
	private MailConfig	mailConfig	= new MailConfig();

	public SaveTicketAction() {
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
		logger.debug("Add called...");
		MyTicketsForm myTicketsForm = (MyTicketsForm) form;

		PersonLoader personLoader = new PersonLoader();

		Ticket ticket = new Ticket();
		Date created = new Date();
		ticket.setCreateDate(created);
		ticket.setModifyDate(created);

		String subject = myTicketsForm.getSubject();
		if (subject == null && subject.length() == 0) {
			subject = "No Subject";
		}
		ticket.setSubject(subject);

		Integer priority = myTicketsForm.getPriority();
		ticket.setPriority(priority);

		AuthEnvironment authEnv = new AuthEnvironment(request);
		Person requestor = personLoader.loadPersonForPrincipal(authEnv.getPrincipal());
		ticket.setRequestor(requestor);

		DispositionLoader dispositionLoader = new DispositionLoader();
		Disposition disposition = dispositionLoader.loadDisposition(myTicketsForm.getDispositionId());
		ticket.setDisposition(disposition);

		String projectId = myTicketsForm.getProjectId();
		if (projectId != null && projectId.length() > 0) {
			ProjectLoader projectLoader = new ProjectLoader();
			Project project = projectLoader.loadProject(projectId);
			if (project != null) {
				ticket.setProject(project);
			}
		}

		QueueLoader queueLoader = new QueueLoader();
		Queue queue = queueLoader.loadQueue(myTicketsForm.getQueueId());
		ticket.setQueue(queue);

		SeverityLoader severityLoader = new SeverityLoader();
		Severity severity = severityLoader.loadSeverity(myTicketsForm.getSeverityId());
		ticket.setSeverity(severity);

		StatusLoader statusLoader = new StatusLoader();
		Status status = statusLoader.loadNewStatus();
		ticket.setStatus(status);

		History history = addTicketHistory(request, myTicketsForm, ticket, created, subject, requestor);

		String ownerId = myTicketsForm.getOwnerId();
		if (ownerId != null && ownerId.length() > 0) {
			Person owner = personLoader.loadPerson(ownerId);
			if (owner != null) {
				ticket.getOwners().add(owner);
			}
		}

		TicketPersistor ticketSaver = new TicketPersistor();
		ticketSaver.saveTicket(ticket);

		SMTPMailSender mailSender = new SMTPMailSender();
		mailSender.setHostName(mailConfig.getSmtpMailHost());
		mailSender.setUsername(mailConfig.getSmtpHostUsername());
		mailSender.setPassword(mailConfig.getSmtpHostPassword());
		mailSender.sendNewTicketInQueueMail(ticket, history, queue);

		return mapping.findForward("display");
	}

	private History addTicketHistory(HttpServletRequest request, MyTicketsForm form, Ticket ticket, Date created, String subject, Person requestor) {
		History history = new History();
		history.setSystem(false);
		history.setAuthor(requestor);
		history.setCreateDate(created);
		String encoding = request.getCharacterEncoding();
		if (encoding == null) {
			encoding = System.getProperty("file.encoding");
		}
		history.setEncoding(encoding);
		history.setImportance(new Integer(0));
		history.setSubject(subject);

		String content = form.getContent();
		history.setContent(content);
		ticket.getHistory().add(history);
		return history;
	}

}
