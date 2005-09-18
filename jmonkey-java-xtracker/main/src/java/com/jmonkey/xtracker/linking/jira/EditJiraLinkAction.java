package com.jmonkey.xtracker.linking.jira;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.atlassian.jira.rpc.soap.beans.RemoteIssueType;
import com.atlassian.jira.rpc.soap.beans.RemotePriority;
import com.atlassian.jira.rpc.soap.beans.RemoteProject;
import com.atlassian.jira.rpc.soap.beans.RemoteStatus;
import com.jmonkey.xtracker.PreferencesConfig;
import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.cipher.PersonCipher;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.linking.LinkingConfig;
import com.jmonkey.xtracker.linking.jira.soap.JiraSoapService;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.Template;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;
import com.jmonkey.xtracker.util.QueueUtil;

public class EditJiraLinkAction extends BaseJiraAction {
	private Logger	logger	= LogManager.getLogger(EditJiraLinkAction.class);

	public EditJiraLinkAction() {
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
		logger.debug("Edit called...");
		JiraLinkForm jiraLinkForm = (JiraLinkForm) form;

		AuthEnvironment authEnvironment = new AuthEnvironment(request);
		LinkingConfig linkingConfig = new LinkingConfig();

		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.loadPersonForPrincipal(authEnvironment.getPrincipal());

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(jiraLinkForm.getTicketId());

		jiraLinkForm.setSubject(ticket.getSubject());

		PersonCipher personCipher = new PersonCipher();
		personCipher.setUsername(person.getUsername());
		personCipher.setPassword(person.getPassword());

		JiraSoapService jira = getJiraService(linkingConfig, person, personCipher);
		String token = jira.login(person.getJiraUsername(), personCipher.decrypt(person.getJiraPassword()));

		RemoteProject[] projectList = jira.getProjects(token);
		jiraLinkForm.setProjectList(projectList);
		// jiraLinkForm.setProjectId(token); // we don't know what it might be

		RemoteIssueType[] typeList = jira.getIssueTypes(token);
		jiraLinkForm.setIssueTypeList(typeList);
		jiraLinkForm.setIssueTypeId(JiraAttributeMapper.getJiraIssueTypeId(ticket.getDisposition()));

		RemotePriority[] priorityList = jira.getPriorities(token);
		jiraLinkForm.setPriorityList(priorityList);
		jiraLinkForm.setPriorityId(JiraAttributeMapper.getJiraPriorityId(ticket.getSeverity()));

		RemoteStatus[] statusList = jira.getStatuses(token);
		jiraLinkForm.setStatusList(statusList);
		jiraLinkForm.setStatusId(JiraAttributeMapper.getJiraStatusId(ticket.getStatus()));

		jiraLinkForm.setSubject(ticket.getSubject());

		StringBuffer message = generateDefaultContent(person, ticket);

		// XXX This is temporary as the JIRA SOAP addComment method is broken.
		appendHistoryToContent(ticket, message);
		jiraLinkForm.setContent(message.toString());

		request.getSession().setAttribute("jiraLinkForm", jiraLinkForm);

		return mapping.getInputForward();
	}

	private void appendHistoryToContent(Ticket ticket, StringBuffer message) {
		logger.warn("JIRA SOAP interface is broken, the ticket history will be added to the issue details instead until its fixed.");
		message.append("\n\nTicket History\n========================\n");
		List<History> historyList = ticket.getHistory();
		for (History history : historyList) {
			if (!history.isSystem()) {
				String subject = history.getSubject();
				message.append("Subject: ");
				if (subject != null) {
					message.append(subject);
				}
				message.append("\n");

				Date created = history.getCreateDate();
				message.append("Created: ");
				if (created != null) {
					message.append(created.toString());
				}
				message.append("\n");

				Person author = history.getAuthor();
				message.append("Author: ");
				if (author != null) {
					message.append(author.getRealname());
				}
				message.append("\n");

				message.append("\n");
				String content = history.getContent();
				if (content != null) {
					message.append(content);
				}
				message.append("\n------------------------\n\n");
			}

		}
	}

	private StringBuffer generateDefaultContent(Person person, Ticket ticket) {
		logger.debug("generating story comment...");
		Template templateParser = new Template();
		templateParser.setTag("@@TICKET_ID@@", ticket.getId().toString());
		templateParser.setTag("@@TICKET_SUBJECT@@", ticket.getSubject());
		templateParser.setTag("@@QUEUE_NAME@@", ticket.getQueue().getName());

		MailConfig mailConfig = new MailConfig();
		String queueEmail = QueueUtil.getQueueEmailAddress(mailConfig, ticket.getQueue());
		templateParser.setTag("@@QUEUE_EMAIL@@", queueEmail);

		if (ticket.getProject() != null) {
			templateParser.setTag("@@PROJECT_NAME@@", ticket.getProject().getName());
		} else {
			templateParser.setTag("@@PROJECT_NAME@@", "Unspecified");
		}
		templateParser.setTag("@@TICKET_PRIORITY@@", ticket.getPriority().toString());
		if (ticket.getDisposition() != null) {
			templateParser.setTag("@@TICKET_DISPOSITION@@", ticket.getDisposition().getLabel());
		} else {
			templateParser.setTag("@@TICKET_DISPOSITION@@", "Unspecified");
		}
		if (ticket.getSeverity() != null) {
			templateParser.setTag("@@TICKET_SEVERITY@@", ticket.getSeverity().getLabel());
		} else {
			templateParser.setTag("@@TICKET_SEVERITY@@", "Unspecified");
		}

		PreferencesConfig preferencesConfig = new PreferencesConfig();
		String context = preferencesConfig.getRootXTrackerUriContext();
		if (context.endsWith("/")) {
			context = context.substring(0, context.length() - 1);
		}
		templateParser.setTag("@@TICKET_URI@@", context + "/open.do?id=" + ticket.getId().toString());
		if (person != null) {
			templateParser.setTag("@@PERSON_ID@@", person.getId());
			templateParser.setTag("@@PERSON_REALNAME@@", person.getRealname());
		}
		StringBuffer buffer = getDefaultTemplate((person != null));
		templateParser.setBuffer(buffer);
		StringBuffer message = templateParser.parseBuffer();
		return message;
	}

	public static StringBuffer getDefaultTemplate(boolean includePerson) {
		StringBuffer buffer = new StringBuffer();
		if (includePerson) {
			buffer.append("@@PERSON_REALNAME@@ linked ticket #@@TICKET_ID@@ from XTracker\n");
		} else {
			buffer.append("Ticket #@@TICKET_ID@@ linked from XTracker\n");
		}
		buffer.append("\n");
		buffer.append("* Queue: @@QUEUE_NAME@@\n");
		buffer.append("* Project: @@PROJECT_NAME@@\n");
		buffer.append("* Disposition: @@TICKET_DISPOSITION@@\n");
		buffer.append("* Severity: @@TICKET_SEVERITY@@\n");
		buffer.append("\n");
		buffer.append("You can view the the ticket at:\n");
		buffer.append("@@TICKET_URI@@\n");
		buffer.append("\n");
		buffer.append("You can send tickets to the @@QUEUE_NAME@@ queue at any time by sending mail to @@QUEUE_EMAIL@@\n");
		return buffer;
	}
}
