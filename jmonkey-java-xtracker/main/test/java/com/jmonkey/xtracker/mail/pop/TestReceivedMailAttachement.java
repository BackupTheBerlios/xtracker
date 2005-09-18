package com.jmonkey.xtracker.mail.pop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.jmonkey.xtracker.mail.pop.ReceivedMailAttachement;

import junit.framework.TestCase;

public class TestReceivedMailAttachement extends TestCase {
	private ReceivedMailAttachement	attachment	= null;

	public void testHasContentType() {
		String value = attachment.getContentType();
		assertNotNull(value);
		assertEquals("image/gif", value);
	}

	public void testHasFileName() {
		String value = attachment.getFileName();
		assertNotNull(value);
		assertEquals("example.gif", value);
	}

	public void testHasInputStream() {
		InputStream input = attachment.getInputStream();
		assertNotNull(input);
	}

	public void testHasSize() {
		int value = attachment.getSize();
		assertEquals(58898, value);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		MimeMessage mimeMessage = setupMimeMessage();
		Part part = findInlinePart(mimeMessage);
		attachment = new ReceivedMailAttachement(part);
		attachment.processPart();
	}

	@Override
	protected void tearDown() throws Exception {
		attachment = null;
		super.tearDown();
	}

	private Part findInlinePart(MimeMessage mimeMessage) throws IOException, MessagingException {
		Part part = null;
		MimeMultipart multipart = (MimeMultipart) mimeMessage.getContent();
		for (int i = 0, n = multipart.getCount(); i < n; i++) {
			Part messagePart = multipart.getBodyPart(i);
			String disposition = messagePart.getDisposition();
			if (disposition != null && disposition.equalsIgnoreCase(Part.INLINE)) {
				part = messagePart;
			}
			if (part != null) {
				break;
			}
		}
		return part;
	}

	private MimeMessage setupMimeMessage() throws FileNotFoundException, MessagingException {
		File testSource = new File("main/etc/test/multipart-mixed-mime-message.txt");
		FileInputStream input = new FileInputStream(testSource);
		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage mimeMessage = new MimeMessage(session, input);
		return mimeMessage;
	}

}
