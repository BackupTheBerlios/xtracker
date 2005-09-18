package com.jmonkey.xtracker.test;

import java.security.Principal;
import java.util.Date;

import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.test.fake.FakePrincipal;

public class ObjectMother {
	public static final String	TEST_QUEUE_NAME						= "Test Queue";
	public static final String	TEST_QUEUE_EMAIL_ALIAS				= "test";
	public static final String	TEST_TICKET_SUBJECT					= "Test Ticket";
	public static final String	TEST_LABEL_UNSPECIFIED				= "Unspecified";
	public static final String	TEST_PERSON_EMAIL_ADDRESS			= "test@example.com";
	public static final String	TEST_PERSON_DEFAULT_EMAIL_LOCATION	= "default-email-location";
	public static final String	TEST_PERSON_INITIALS				= "TRN";
	public static final String	TEST_PERSON_REAL_NAME				= "test real name";
	public static final String	TEST_PERSON_PASSWORD				= "test-password";
	public static final String	TEST_PERSON_USERNAME				= "test-username";

	public ObjectMother() {
		super();
	}

	public static Person birthPerson() {
		Person person = new Person();
		person.setActive(true);
		person.setAdministrator(false);
		person.setAnonymous(false);
		person.setPlainPassword(TEST_PERSON_PASSWORD);
		person.setUsername(TEST_PERSON_USERNAME);
		person.setRealname(TEST_PERSON_REAL_NAME);
		person.setInitials(TEST_PERSON_INITIALS);

//		Email email = new Email();
//		email.setLocation(TEST_PERSON_DEFAULT_EMAIL_LOCATION);
//		email.setActive(true);
//		email.setAddress(TEST_PERSON_EMAIL_ADDRESS);
//		email.setPriority(0);
//		List<Email> emailAddesses = new ArrayList<Email>();
//		emailAddesses.add(email);
		person.setEmailAddress(TEST_PERSON_EMAIL_ADDRESS);
		return person;
	}

	public static Principal birthPrincipal() {
		Principal principal = new FakePrincipal(TEST_PERSON_USERNAME);
		return principal;
	}

	public static Status birthStatus() {
		Status status = new Status();
		status.setActive(true);
		status.setColour("#000000");
		status.setCreateDate(new Date());
		status.setId(1);
		status.setImmutable(true);
		status.setLabel("New");
		status.setSelectable(true);
		return status;
	}

	public static Project birthProject() {
		Project project = new Project();
		project.setActive(true);
		project.setCreateDate(new Date());
		project.setName("Test Project");
		project.setSelectable(true);
		return project;
	}

	public static Disposition birthDisposition() {
		Disposition disposition = new Disposition();
		disposition.setActive(true);
		disposition.setColour("#000000");
		disposition.setCreateDate(new Date());
		disposition.setImmutable(false);
		disposition.setLabel(TEST_LABEL_UNSPECIFIED);
		disposition.setSelectable(true);
		return disposition;
	}

	public static Severity birthSeverity() {
		Severity severity = new Severity();
		severity.setActive(true);
		severity.setColour("#000000");
		severity.setCreateDate(new Date());
		severity.setImmutable(false);
		severity.setLabel(TEST_LABEL_UNSPECIFIED);
		severity.setSelectable(true);
		return severity;
	}

	public static Ticket birthTicket() {
		Ticket ticket = new Ticket();
		ticket.setPriority(50);
		ticket.setSubject(TEST_TICKET_SUBJECT);
		return ticket;
	}

	public static Queue birthQueue() {
		Queue queue = new Queue();
		queue.setActive(true);
		queue.setCreateDate(new Date());
		queue.setEmailAlias(TEST_QUEUE_EMAIL_ALIAS);
		queue.setName(TEST_QUEUE_NAME);
		queue.setSelectable(true);
		return queue;
	}

}
