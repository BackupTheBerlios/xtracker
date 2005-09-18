package com.jmonkey.xtracker.mail.pop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import junit.framework.TestCase;

public class TestTextPlainReceivedMailMessage extends TestCase {
	private ReceivedMailMessage	mailMessage	= null;

	public void testCanGetMessageId() {
		String value = mailMessage.getMessageId();
		assertNotNull(value);
		assertEquals("<20050622024130.31775@mail.optonline.net>", value);
	}

	public void testCanGetMessageReferenceIds() {
		List<String> list = mailMessage.getMessageReferenceIds();
		assertNotNull(list);
		assertEquals("<20050622004036.26396@mail.optonline.net>", list.get(0));
		assertEquals("<42B8C99D.5010005@pappin.ca>", list.get(1));
	}

	public void testCanGetSubject() {
		String subject = mailMessage.getSubject();
		assertNotNull(subject);
		assertEquals("This is a test subject", subject);
	}

	public void testCanGetContents() {
		String value = mailMessage.getBody();
		assertNotNull(value);
		assertEquals("This is a test message...", value);
	}

	public void testCanGetContentType() {
		String value = mailMessage.getContentType();
		assertNotNull(value);
		assertEquals("text/plain", value);
	}

	public void testCanGetCharset() {
		String value = mailMessage.getCharset();
		assertNotNull(value);
		assertEquals("US-ASCII", value);
	}

	public void testHasPersonalName() {
		String value = mailMessage.getFromPersonalName();
		assertNotNull(value);
		assertEquals("Jane Doe", value);
	}

	public void testHasFromEmailAddress() {
		String value = mailMessage.getFromEmailAddress();
		assertNotNull(value);
		assertEquals("somebody@somebody.com", value);
	}

	public void testHasToEmailAddress() {
		String value = mailMessage.getToEmailAddress();
		assertNotNull(value);
		assertEquals("me@example.com", value);
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
		File testSource = new File("main/etc/test/text-plain-mime-message.txt");
		FileInputStream input = new FileInputStream(testSource);
		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage mimeMessage = new MimeMessage(session, input);
		return mimeMessage;
	}
}
