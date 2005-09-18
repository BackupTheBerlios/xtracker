package com.jmonkey.xtracker.mail.pop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import com.jmonkey.xtracker.mail.pop.ReceivedMailMessage;

import junit.framework.TestCase;

public class TestMultipartAlternativeReceivedMailMessage extends TestCase {
	private ReceivedMailMessage	mailMessage	= null;

	public void testCanGetMessageId() {
		String value = mailMessage.getMessageId();
		assertNotNull(value);
		assertEquals("<29F99D4B-3329-4A36-AB40-82966BAA6166@dowman.net>", value);
	}

	public void testCanGetMessageReferenceIds() {
		List<String> list = mailMessage.getMessageReferenceIds();
		assertNotNull(list);
		assertEquals(0, list.size());
	}

	public void testCanGetSubject() {
		String subject = mailMessage.getSubject();
		assertNotNull(subject);
		assertEquals("on setting up objects by constructor or setters", subject);
	}

	public void testCanGetContents() {
		String value = mailMessage.getBody();
		assertNotNull(value);
		System.err.println(value);
		assertEquals("This relates to something we talked", value.substring(0, 35));
	}

	public void testCanGetContentType() {
		String value = mailMessage.getContentType();
		assertNotNull(value);
		assertEquals("multipart/alternative", value);
	}

	public void testCanGetCharset() {
		String value = mailMessage.getCharset();
		assertNull(value);
	}

	public void testHasPersonalName() {
		String value = mailMessage.getFromPersonalName();
		assertNotNull(value);
		assertEquals("Paul Dowman", value);
	}

	public void testHasEmailAddress() {
		String value = mailMessage.getFromEmailAddress();
		assertNotNull(value);
		assertEquals("paul@dowman.net", value);
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
		File testSource = new File("main/etc/test/multipart-alternative-mime-message.txt");
		FileInputStream input = new FileInputStream(testSource);
		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage mimeMessage = new MimeMessage(session, input);
		return mimeMessage;
	}
}
