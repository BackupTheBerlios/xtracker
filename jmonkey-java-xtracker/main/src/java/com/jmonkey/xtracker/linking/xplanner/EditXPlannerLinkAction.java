package com.jmonkey.xtracker.linking.xplanner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.xplanner.soap.IterationData;
import org.xplanner.soap.ProjectData;

import com.jmonkey.xtracker.PreferencesConfig;
import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.cipher.PersonCipher;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.linking.LinkingConfig;
import com.jmonkey.xtracker.linking.xplanner.soap.XPlanner;
import com.jmonkey.xtracker.linking.xplanner.soap.XPlannerServiceLocator;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.Template;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;
import com.jmonkey.xtracker.util.QueueUtil;

public class EditXPlannerLinkAction extends Action {
	private Logger	logger	= LogManager.getLogger(EditXPlannerLinkAction.class);

	public EditXPlannerLinkAction() {
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
		XPlannerLinkForm xPlannerLinkForm = (XPlannerLinkForm) form;

		AuthEnvironment authEnvironment = new AuthEnvironment(request);
		LinkingConfig linkingConfig = new LinkingConfig();

		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.loadPersonForPrincipal(authEnvironment.getPrincipal());

		XPlanner xplanner = getXPlanner(linkingConfig, person);

		List<ViewElement> iterationList = new ArrayList<ViewElement>();
		ProjectData[] projectData = xplanner.getProjects();
		Calendar today = Calendar.getInstance();
		for (ProjectData project : projectData) {
			IterationData[] iterationData = xplanner.getIterations(project.getId());
			for (IterationData iteration : iterationData) {
				Calendar end = iteration.getEndDate();
				if (end.after(today) || end.equals(today)) {
					iterationList.add(new ViewElement(project.getName() + " :: " + iteration.getName(), iteration.getId()));
				}
			}
		}

		xPlannerLinkForm.setIterationList(iterationList);

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(xPlannerLinkForm.getTicketId());

		xPlannerLinkForm.setSubject(ticket.getSubject());

		StringBuffer message = generateDefaultContent(person, ticket);
		xPlannerLinkForm.setContent(message.toString());

		request.getSession().setAttribute("xPlannerLinkForm", xPlannerLinkForm);

		return mapping.getInputForward();
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

	private XPlanner getXPlanner(LinkingConfig linkingConfig, Person person) throws Exception {
		XPlannerServiceLocator serviceLocator = new XPlannerServiceLocator();
		serviceLocator.setXPlannerAddress(linkingConfig.getXplannerContext() + "/soap/XPlanner");
		serviceLocator.setUsername(person.getXplannerUsername());
		PersonCipher personCipher = new PersonCipher();
		personCipher.setUsername(person.getUsername());
		personCipher.setPassword(person.getPassword());
		String xppasswd = person.getXplannerPassword();
		if (xppasswd != null) {
			serviceLocator.setPassword(personCipher.decrypt(xppasswd));
		}
		XPlanner xplanner = serviceLocator.getXPlanner();
		return xplanner;
	}

	public static StringBuffer getDefaultTemplate(boolean includePerson) {
		StringBuffer buffer = new StringBuffer();
		if (includePerson) {
			buffer.append("@@PERSON_REALNAME@@ linked ticket #@@TICKET_ID@@ from XTracker\n");
		} else {
			buffer.append("Ticket #@@TICKET_ID@@ linked from XTracker\n");
		}
		buffer.append("\n");
		buffer.append("   * Queue: @@QUEUE_NAME@@\n");
		buffer.append("   * Project: @@PROJECT_NAME@@\n");
		buffer.append("   * Disposition: @@TICKET_DISPOSITION@@\n");
		buffer.append("   * Severity: @@TICKET_SEVERITY@@\n");
		buffer.append("\n");
		buffer.append("You can view the the ticket at:\n");
		buffer.append("@@TICKET_URI@@\n");
		buffer.append("\n");
		buffer.append("You can send tickets to the @@QUEUE_NAME@@ queue at any time by sending mail to @@QUEUE_EMAIL@@\n");
		return buffer;
	}

//	private String getQueueEmailAddress(Queue queue) {
//		MailConfig mailConfig = new MailConfig();
//		String emailDomain = mailConfig.getEmailDomain();
//		if (!emailDomain.startsWith("@")) {
//			emailDomain = "@" + emailDomain;
//		}
//		return queue.getEmailAlias() + emailDomain;
//	}
}
