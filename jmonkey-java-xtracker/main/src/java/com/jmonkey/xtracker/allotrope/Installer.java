package com.jmonkey.xtracker.allotrope;

import java.util.Date;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.template.TemplateData;
import com.jmonkey.xtracker.util.Parser;

public class Installer {

	public Installer() {
		super();
	}

	public static void main(String[] args) {
		Installer installer = new Installer();
		try {
			Session session = HibernateSessionFactory.currentSession();

			Transaction transaction = session.beginTransaction();
			installer.setupStatus(session);
			installer.setupSeverity(session);
			installer.setupDisposition(session);
			installer.setupPerson(session);
			installer.setupQueue(session);
			installer.setupTemplates(session);
			transaction.commit();

			HibernateSessionFactory.closeSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	public void setupTemplates(Session session) throws HibernateException {

		TemplateData ticketAssigned = new TemplateData("Ticket Assigned", "xtracker.required.ticket.assigned", Parser.XTRACKER, true,
				"A new Ticket [#@@TICKET_ID@@] was assigned to you.\n" + "@@TICKET_URI@@\n\n" + "Date   : @@HISTORY_DATE@@\n" + "Author : @@HISTORY_AUTHOR@@\n"
						+ "Subject: @@HISTORY_SUBJECT@@\n");
		session.save(ticketAssigned);

		TemplateData ticketDue = new TemplateData("Ticket Due In Days", "xtracker.required.ticket.dueindays", Parser.XTRACKER, true, "Ticket @@TICKET_ID@@ is due @@DAYS@@\n\n"
				+ "Due Date: @@TICKET_DUEDATE@@\n" + "Suject: @@TICKET_SUBJECT@@\n\n" + "View the ticket at:\n" + "@@TICKET_URI@@" + "Ticket @@TICKET_ID@@ is due @@DAYS@@\n\n"
				+ "Due Date: @@TICKET_DUEDATE@@\n" + "Suject: @@TICKET_SUBJECT@@\n\n" + "View the ticket at:\n" + "@@TICKET_URI@@");
		session.save(ticketDue);

		TemplateData newPerson = new TemplateData("New Person", "xtracker.required.new.person", Parser.XTRACKER, true, "New Login Created\n\n"
				+ "Welcome to XTracker  @@PERSON_REALNAME@@,\n\n" + "A new account has been created for you:\n" + "Username:\t @@PERSON_USERNAME@@\n"
				+ "Password:\t @@PERSON_PASSWORD@@\n\n" + "You can view the status of the tickets you submit at:\n" + "@@CONTEXT_URI@@\n\n"
				+ "You can send tickets to the @@QUEUE_NAME@@ queue at any time by sending mail to @@QUEUE_EMAIL@@\n");
		session.save(newPerson);

		TemplateData ticketReply = new TemplateData("Ticket Reply", "xtracker.required.ticket.reply", Parser.XTRACKER, true,
				"@@HISTORY_MESSAGE@@\n\n-- \n===============================\n" + "A new message was added to Ticket #@@TICKET_ID@@\n" + "Date   : @@HISTORY_DATE@@\n"
						+ "Author : @@HISTORY_AUTHOR@@\n" + "Subject: @@HISTORY_SUBJECT@@\n" + "You can view the entire ticket at:\n" + "@@TICKET_URI@@\n");
		session.save(ticketReply);

		TemplateData ticketInQueue = new TemplateData("Ticket In Queue", "xtracker.required.ticket.inqueue", Parser.XTRACKER, true,
				"A new Ticket [#@@TICKET_ID@@] was added to the Queue\n" + "@@QUEUE_NAME@@ (You are the manager of that Queue)\n\n\n"
						+ "You must assign this ticket to someone in order for it\n" + "to be resolved.\n@@TICKET_URI@@\n\n\n" + "Date   : @@HISTORY_DATE@@\n"
						+ "Author : @@HISTORY_AUTHOR@@\n" + "Subject: @@HISTORY_SUBJECT@@\n");
		session.save(ticketInQueue);

	}

	public void setupDisposition(Session session) throws HibernateException {
		Date created = new Date();
		Disposition unspecified = new Disposition("Unspecified", "#FFFFB0".toUpperCase(), created);
		unspecified.setId(1);
		unspecified.setImmutable(true);
		unspecified.setActive(true);
		unspecified.setSelectable(true);

		Disposition action = new Disposition("Action Request", "#C8C8FF".toUpperCase(), created);
		action.setId(2);
		action.setImmutable(true);
		action.setActive(true);
		action.setSelectable(true);

		Disposition bug = new Disposition("Software Bug", "#CCEEDD".toUpperCase(), created);
		bug.setId(3);
		bug.setImmutable(true);
		bug.setActive(true);
		bug.setSelectable(true);

		Disposition feature = new Disposition("Feature Request", "#FFA0A0".toUpperCase(), created);
		feature.setId(4);
		feature.setImmutable(true);
		feature.setActive(true);
		feature.setSelectable(true);

		Disposition text = new Disposition("Text or Typo", "#FFD850".toUpperCase(), created);
		text.setId(5);
		text.setImmutable(true);
		text.setActive(true);
		text.setSelectable(true);
		//
		// Disposition info = new Disposition("Information Request",
		// "#FFFFB0".toUpperCase(), created);
		// info.setId(6);
		// info.setActive(true);
		// info.setSelectable(true);
		//
		// Disposition suggestion = new Disposition("Suggestion",
		// "#FFA0A0".toUpperCase(), created);
		// suggestion.setId(7);
		// suggestion.setActive(true);
		// suggestion.setSelectable(true);
		//
		// Disposition usage = new Disposition("Usage Problem",
		// "#C8C8FF".toUpperCase(), created);
		// usage.setId(8);
		// usage.setActive(true);
		// usage.setSelectable(true);

		session.save(unspecified);
		session.save(action);
		session.save(bug);
		session.save(feature);
		session.save(text);
		// session.save(info);
		// session.save(suggestion);
		// session.save(usage);
	}

	public void setupSeverity(Session session) throws HibernateException {
		Date created = new Date();
		Severity unspecified = new Severity("Unspecified", "#E8E8E8", created);
		unspecified.setId(1);
		unspecified.setImmutable(true);
		unspecified.setActive(true);
		unspecified.setSelectable(true);

		Severity trivial = new Severity("Trivial", "#FFF2EC", created);
		trivial.setId(2);
		trivial.setImmutable(true);
		trivial.setActive(true);
		trivial.setSelectable(true);

		Severity tweak = new Severity("Tweak", "#FFEADF", created);
		tweak.setId(3);
		tweak.setImmutable(true);
		tweak.setActive(true);
		tweak.setSelectable(true);

		Severity minor = new Severity("Minor", "#FFDECE", created);
		minor.setId(4);
		minor.setImmutable(true);
		minor.setActive(true);
		minor.setSelectable(true);

		Severity major = new Severity("Major", "#FFC5A8".toUpperCase(), created);
		major.setId(5);
		major.setImmutable(true);
		major.setActive(true);
		major.setSelectable(true);

		Severity crash = new Severity("Crash", "#FF9B6A", created);
		crash.setId(6);
		crash.setImmutable(true);
		crash.setActive(true);
		crash.setSelectable(true);

		Severity block = new Severity("Blocker", "#FF8040".toUpperCase(), created);
		block.setId(7);
		block.setImmutable(true);
		block.setActive(true);
		block.setSelectable(true);

		session.save(unspecified);
		session.save(trivial);
		session.save(tweak);
		session.save(minor);
		session.save(major);
		session.save(crash);
		session.save(block);
	}

	public void setupStatus(Session session) throws HibernateException {
		Date created = new Date();
		Status newStatus = new Status("New", "#FFD850", created);
		newStatus.setId(1);
		newStatus.setImmutable(true);
		newStatus.setActive(true);
		newStatus.setSelectable(true);

		Status openStatus = new Status("Open", "#C8C8FF", created);
		openStatus.setId(2);
		openStatus.setImmutable(true);
		openStatus.setActive(true);
		openStatus.setSelectable(true);

		Status resolvedStatus = new Status("Resolved", "#CCEEDD", created);
		resolvedStatus.setId(3);
		resolvedStatus.setImmutable(true);
		resolvedStatus.setActive(true);
		resolvedStatus.setSelectable(true);

		Status closedStatus = new Status("Closed", "#E8E8E8", created);
		closedStatus.setId(4);
		closedStatus.setImmutable(true);
		closedStatus.setActive(true);
		closedStatus.setSelectable(true);

		Status holdStatus = new Status("On Hold", "#FFFFB0", created);
		holdStatus.setId(5);
		holdStatus.setImmutable(true);
		holdStatus.setActive(true);
		holdStatus.setSelectable(true);

		Status rejected = new Status("Rejected", "#FF50A8", created);
		rejected.setId(6);
		rejected.setImmutable(true);
		rejected.setActive(true);
		rejected.setSelectable(true);

		// Status feedbackStatus = new Status("Feedback", "#C0C0C0", created);
		// feedbackStatus.setActive(true);
		// feedbackStatus.setSelectable(true);
		//
		// Status acknowledgedStatus = new Status("Acknowledged", "#C0C0C0",
		// created);
		// acknowledgedStatus.setActive(true);
		// acknowledgedStatus.setSelectable(true);
		//
		// Status confirmedStatus = new Status("Confirmed", "#C0C0C0", created);
		// confirmedStatus.setActive(true);
		// confirmedStatus.setSelectable(true);
		//
		// Status assignedStatus = new Status("Assigned", "#C0C0C0", created);
		// assignedStatus.setActive(true);
		// assignedStatus.setSelectable(true);

		session.save(newStatus);
		session.save(openStatus);
		session.save(resolvedStatus);
		session.save(closedStatus);
		session.save(holdStatus);
		session.save(rejected);
		// session.save(acknowledgedStatus);
		// session.save(confirmedStatus);
		// session.save(assignedStatus);
		// session.save(feedbackStatus);
	}

	public void setupPerson(Session session) throws HibernateException {
		Date created = new Date();
		Person sysadmin = new Person();
		sysadmin.setCreateDate(created);
		sysadmin.setUsername("admin");
		sysadmin.setInitials("SA");
		sysadmin.setRealname("System Admin");
		sysadmin.setPlainPassword("admin");
		sysadmin.setEmailAddress("");
		sysadmin.setActive(true);
		sysadmin.setSelectable(false);
		sysadmin.setAdministrator(true);
		sysadmin.setEmailAddress("");

		session.save(sysadmin);
	}

	public void setupQueue(Session session) throws HibernateException {
		Date created = new Date();
		Queue anonymous = new Queue();
		anonymous.setCreateDate(created);
		anonymous.setActive(true);
		anonymous.setName("Anonymous");
		anonymous.setEmailAlias("anonymous");
		anonymous.setActive(true);
		anonymous.setSelectable(true);

		session.save(anonymous);
	}

}
