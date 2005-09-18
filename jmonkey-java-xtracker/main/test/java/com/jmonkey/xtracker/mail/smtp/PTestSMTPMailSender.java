package com.jmonkey.xtracker.mail.smtp;

import java.util.Date;

import junit.framework.TestCase;

import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.profile.Person;

public class PTestSMTPMailSender extends TestCase {
	private SMTPMailSender	sender	= null;

	public void testSendReplyMail() throws Exception {

		Person requestor = new Person();
		requestor.setId("zxcvbn");
		requestor.setRealname("John Doe");
		requestor.setEmailAddress("brill@pappin.ca");

		Person author = new Person();
		author.setId("abcdefg");
		author.setRealname("Brill Pappin");
		author.setEmailAddress("brill@pappin.ca");

		Ticket ticket = new Ticket();
		ticket.setId(12345L);
		ticket.setSubject("Test Ticket Subject");
		ticket.setRequestor(requestor);

		Queue queue = new Queue("Helpdesk", true, new Date());
		queue.setEmailAlias("helpdesk@pappin.ca");
		ticket.setQueue(queue);

		History history = new History();

		history.setAuthor(author);
		history.setSubject("PTest subject");
		history.setContent("This is the content of the history...");
		sender.sendReplyMail(ticket, history);
	}

	public void testSendNewPersonMail() throws Exception {

		Person author = new Person();
		author.setId("abcdefg");
		author.setRealname("Brill Pappin");
		author.setUsername("brill@pappin.ca");
		author.setEmailAddress("brill@pappin.ca");

		Queue queue = new Queue("Helpdesk", true, new Date());
		queue.setEmailAlias("helpdesk@pappin.ca");

		sender.sendNewPersonMail(author, "test123", queue);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// StringBuffer buffer = new StringBuffer();
		// buffer.append("Test mail...\n\n");
		// buffer.append("Ticket Id: @@TICKET_ID@@\n");
		// buffer.append("Ticket Subject: @@TICKET_SUBJECT@@\n");
		// buffer.append("Ticket Author: @@AUTHOR@@\n");
		// buffer.append("Ticket Message: \n@@MESSAGE@@\n\n");
		// buffer.append("Ticket Link: @@TICKET_URI@@\n");

		sender = new SMTPMailSender();
		sender.setHostName("mail.pappin.ca");
		// sender.setRecipient("brill@pappin.ca");
		// sender.setSender("test@example.com");
		// sender.setSubject("Test Email");
		// sender.setTokenTemplate(buffer);
	}

	@Override
	protected void tearDown() throws Exception {
		sender = null;
		super.tearDown();
	}

}
