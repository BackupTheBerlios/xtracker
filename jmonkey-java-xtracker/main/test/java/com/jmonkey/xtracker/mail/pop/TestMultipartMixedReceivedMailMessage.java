package com.jmonkey.xtracker.mail.pop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import com.jmonkey.xtracker.mail.pop.ReceivedMailAttachement;
import com.jmonkey.xtracker.mail.pop.ReceivedMailMessage;

import junit.framework.TestCase;

public class TestMultipartMixedReceivedMailMessage extends TestCase {
	private ReceivedMailMessage	mailMessage	= null;

	public void testCanGetMessageId() {
		String value = mailMessage.getMessageId();
		assertNotNull(value);
		assertEquals("<42BB557E.4060207@pappin.ca>", value);
	}

	public void testCanGetMessageReferenceIds() {
		List<String> list = mailMessage.getMessageReferenceIds();
		assertNotNull(list);
		assertEquals(0, list.size());
	}
	
	public void testCanGetSubject() {
		String subject = mailMessage.getSubject();
		assertNotNull(subject);
		assertEquals("attachment test", subject);
	}

	public void testCanGetContents() {
		String value = mailMessage.getBody();
		assertNotNull(value);
		assertEquals("attachment test", value.trim());
	}

	public void testCanGetContentType() {
		String value = mailMessage.getContentType();
		assertNotNull(value);
		assertEquals("multipart/mixed", value);
	}

	public void testCanGetCharset() {
		String value = mailMessage.getCharset();
		assertNull(value);
	}

	public void testHasPersonalName() {
		String value = mailMessage.getFromPersonalName();
		assertNotNull(value);
		assertEquals("Brill Pappin", value);
	}

	public void testHasEmailAddress() {
		String value = mailMessage.getFromEmailAddress();
		assertNotNull(value);
		assertEquals("brill@pappin.ca", value);
	}

	public void testHasAttachments() {
		List<ReceivedMailAttachement> value = mailMessage.getAttachements();
		assertNotNull(value);
		assertEquals(1, value.size());

		ReceivedMailAttachement attachment = value.get(0);
		assertNotNull(attachment);
		assertEquals("image/gif", attachment.getContentType());
		assertEquals("example.gif", attachment.getFileName());
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
		File testSource = new File("main/etc/test/multipart-mixed-mime-message.txt");
		FileInputStream input = new FileInputStream(testSource);
		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage mimeMessage = new MimeMessage(session, input);
		return mimeMessage;
	}
}
