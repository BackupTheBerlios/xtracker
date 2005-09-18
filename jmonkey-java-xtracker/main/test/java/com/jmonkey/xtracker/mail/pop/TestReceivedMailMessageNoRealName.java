package com.jmonkey.xtracker.mail.pop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import junit.framework.TestCase;

public class TestReceivedMailMessageNoRealName extends TestCase {
	private ReceivedMailMessage	mailMessage	= null;

	public void testHasPersonalName() {
		String valueEmail = mailMessage.getFromEmailAddress();
		String valuePersonal = mailMessage.getFromPersonalName();
		assertNotNull(valueEmail);
		assertNotNull(valuePersonal);
		assertEquals("somebody@somebody.com", valueEmail);
		assertEquals(valueEmail, valuePersonal);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		MimeMessage mimeMessage = setupMimeMessage();
		mailMessage = new ReceivedMailMessage(mimeMessage);
		mailMessage.processMessage();
	}

	@Override
	protected void tearDown() throws Exception {
		mailMessage = null;
		super.tearDown();
	}

	private MimeMessage setupMimeMessage() throws MessagingException, FileNotFoundException {
		File testSource = new File("main/etc/test/text-plain-mime-message-no-realname.txt");
		FileInputStream input = new FileInputStream(testSource);
		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage mimeMessage = new MimeMessage(session, input);
		return mimeMessage;
	}
}
