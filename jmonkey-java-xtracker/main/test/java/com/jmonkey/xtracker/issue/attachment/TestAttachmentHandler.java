package com.jmonkey.xtracker.issue.attachment;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.test.fake.mail.FakeReceivedMailAttachement;

public class TestAttachmentHandler extends TestCase {
	private FakeReceivedMailAttachement	fakeReceivedMailAttachement	= null;
	private File						testAttachmentDir			= null;
	private File						testRootDir					= null;
	private AttachmentHandler			handler						= null;
	private History						testHistory					= null;

	public void testDataWrittenToFile() throws IOException {
		handler.storeAttachment(testHistory, fakeReceivedMailAttachement);

		File[] files = testAttachmentDir.listFiles();
		assertEquals(1, files.length);
		assertEquals("test.txt", files[0].getName());
		assertEquals(10, files[0].length());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testHistory = new History();
		testHistory.setId("TestAttachmentHandler");
		fakeReceivedMailAttachement = new FakeReceivedMailAttachement();
		fakeReceivedMailAttachement.setTestContentType("test/plain");
		fakeReceivedMailAttachement.setTestFileName("test.txt");
		fakeReceivedMailAttachement.setTestSize(10);
		ByteArrayInputStream testInputStream = new ByteArrayInputStream("1234567890".getBytes());
		fakeReceivedMailAttachement.setTestInputStream(testInputStream);

		testRootDir = new File("target/test-temp/attachments");
		testAttachmentDir = new File("target/test-temp/attachments/TestAttachmentHandler");

		handler = new AttachmentHandler();
		handler.setAttachmentRoot(testRootDir);
	}

	@Override
	protected void tearDown() throws Exception {
		handler = null;
		// File[] files = testAttachmentDir.listFiles();
		// for(int i = 0; i < files.length; i++) {
		// files[i].delete();
		// }
		super.tearDown();
	}

}
