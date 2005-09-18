package com.jmonkey.xtracker.linking.jira;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.atlassian.jira.rpc.exception.RemoteAuthenticationException;
import com.atlassian.jira.rpc.exception.RemotePermissionException;
import com.atlassian.jira.rpc.soap.beans.RemoteComment;
import com.atlassian.jira.rpc.soap.beans.RemoteComponent;
import com.atlassian.jira.rpc.soap.beans.RemoteCustomFieldValue;
import com.atlassian.jira.rpc.soap.beans.RemoteIssue;
import com.atlassian.jira.rpc.soap.beans.RemoteUser;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.cipher.PersonCipher;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;
import com.jmonkey.xtracker.linking.LinkingConfig;
import com.jmonkey.xtracker.linking.jira.soap.JiraSoapService;
import com.jmonkey.xtracker.my.tickets.ActionForwardFactory;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class SaveJiraLinkAction extends BaseJiraAction {
	private Logger	logger	= LogManager.getLogger(SaveJiraLinkAction.class);

	public SaveJiraLinkAction() {
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
		logger.debug("Save called...");
		try {
			JiraLinkForm jiraLinkForm = (JiraLinkForm) form;

			AuthEnvironment authEnvironment = new AuthEnvironment(request);
			LinkingConfig linkingConfig = new LinkingConfig();

			Long ticketId = jiraLinkForm.getTicketId();

			PersonLoader personLoader = new PersonLoader();
			Person person = personLoader.loadPersonForPrincipal(authEnvironment.getPrincipal());

			Calendar today = Calendar.getInstance();

			TicketPersistor ticketPersistor = new TicketPersistor();
			TicketLoader ticketLoader = new TicketLoader();
			Ticket ticket = ticketLoader.loadTicket(ticketId);

			PersonCipher personCipher = new PersonCipher();
			personCipher.setUsername(person.getUsername());
			personCipher.setPassword(person.getPassword());

			JiraSoapService jira = getJiraService(linkingConfig, person, personCipher);
			String token = jira.login(person.getJiraUsername(), personCipher.decrypt(person.getJiraPassword()));
			RemoteUser jiraUser = jira.getUser(token, person.getJiraUsername());

			RemoteIssue savedIssue = createNewJiraIssue(jiraLinkForm, today, ticket, jira, token);
			logger.debug("New JIRA Issue: " + savedIssue.getId() + "[" + savedIssue.getKey() + "]");
			addLinkToTicket(person, today, ticketPersistor, ticket, savedIssue);
			addHistoryToJiraIssue(ticket, jira, token, jiraUser, savedIssue);

			logger.debug("sending the user back to the ticket...");
			ActionForwardFactory forwardFactory = new ActionForwardFactory();
			return forwardFactory.getOpenTicketForward(ticketId);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private void addHistoryToJiraIssue(Ticket ticket, JiraSoapService jira, String token, RemoteUser jiraUser, RemoteIssue savedIssue) throws RemoteException,
			RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, RemoteAuthenticationException {
		logger.debug("Adding ticket history to JIRA Issue...");
		String issueKey = savedIssue.getKey();
		List<RemoteComment> commentList = new ArrayList<RemoteComment>();
		List<History> historyList = ticket.getHistory();
		for (History history : historyList) {
			RemoteComment comment = new RemoteComment();
			comment.setId("");
			comment.setLevel("");

			comment.setUsername(jiraUser.getName());

			// XXX another dumbass JIRA this, nothing can be null!
			String histContent = history.getContent();
			if (histContent == null) {
				histContent = "";
			}
			comment.setBody(histContent);

			Calendar createDate = Calendar.getInstance();
			createDate.setTime(history.getCreateDate());
			comment.setTimePerformed(createDate);

			// XXX This looks like a permissions level?
			// comment.setLevel(token);
			commentList.add(comment);
		}
		for (RemoteComment comment : commentList) {
			logger.debug("Adding comment to issue: " + issueKey);
			jira.addComment(token, issueKey, comment);
		}
	}

	private void addLinkToTicket(Person person, Calendar today, TicketPersistor ticketPersistor, Ticket ticket, RemoteIssue savedIssue) throws HibernateException {
		logger.debug("Adding JIRA Link to Ticket...");
		JiraLink jiraLink = new JiraLink();
		jiraLink.setCreated(today.getTime());
		jiraLink.setUpdated(today.getTime());
		jiraLink.setCreator(person);
		jiraLink.setKey(savedIssue.getKey());
		jiraLink.setName(savedIssue.getSummary());
		ticket.setJiraLink(jiraLink);
		ticketPersistor.updateTicket(ticket);
	}

	private RemoteIssue createNewJiraIssue(JiraLinkForm jiraLinkForm, Calendar today, Ticket ticket, JiraSoapService jira, String token) throws Exception {
		logger.debug("Creating new JIRA Issue...");
		RemoteIssue issue = new RemoteIssue();

		// ================================================
		// XXX The dumbass SOAP API requires all this to be set even
		// though no values are used.
		issue.setId("");
		issue.setKey("");
		issue.setAssignee("-1"); // XXX Assign to "Automatic" ?...
		issue.setAttachmentNames(new String[0]);
		issue.setAffectsVersions(new RemoteVersion[0]);
		issue.setFixVersions(new RemoteVersion[0]);
		issue.setComponents(new RemoteComponent[0]);
		issue.setCustomFieldValues(new RemoteCustomFieldValue[0]);
		issue.setEnvironment("");
		issue.setResolution("");
		issue.setUpdated(Calendar.getInstance());
		issue.setReporter("");
		// ================================================

		issue.setCreated(today);
		issue.setProject(jiraLinkForm.getProjectId());
		issue.setPriority(jiraLinkForm.getPriorityId());
		issue.setStatus(jiraLinkForm.getStatusId());
		issue.setType(jiraLinkForm.getIssueTypeId());
		issue.setSummary(jiraLinkForm.getSubject());
		issue.setDescription(jiraLinkForm.getContent());

		if (ticket.getDueDate() != null) {
			Calendar ticketDue = Calendar.getInstance();
			ticketDue.setTime(ticket.getDueDate());
			issue.setDuedate(ticketDue);
		} else {
			// XXX JIRA SOAP forces a value in this field
			// to be set despite it not being needed.
			issue.setDuedate(Calendar.getInstance());
		}

		RemoteIssue savedIssue = null;
		try {
			savedIssue = jira.createIssue(token, issue);
		} catch (Exception e) {
			logger.error("Could not create new issue", e);
			throw e;
		}
		return savedIssue;
	}
}
