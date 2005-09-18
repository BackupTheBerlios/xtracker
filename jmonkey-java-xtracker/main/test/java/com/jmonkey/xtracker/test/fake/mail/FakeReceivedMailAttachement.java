package com.jmonkey.xtracker.test.fake.mail;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.MessagingException;

import com.jmonkey.xtracker.mail.pop.ReceivedMailAttachement;

public class FakeReceivedMailAttachement extends ReceivedMailAttachement {
	private String		testContentType		= null;
	private String		testFileName		= null;
	private InputStream	testInputStream		= null;
	private int			testSize			= 0;
	private boolean		processMailCalled	= false;

	public FakeReceivedMailAttachement() {
		super(null);
	}

	/**
	 * @see com.jmonkey.xtracker.mail.pop.ReceivedMailAttachement#getContentType()
	 */
	@Override
	public String getContentType() {
		return testContentType;
	}

	/**
	 * @see com.jmonkey.xtracker.mail.pop.ReceivedMailAttachement#getFileName()
	 */
	@Override
	public String getFileName() {
		return testFileName;
	}

	/**
	 * @see com.jmonkey.xtracker.mail.pop.ReceivedMailAttachement#getInputStream()
	 */
	@Override
	public InputStream getInputStream() {
		return testInputStream;
	}

	/**
	 * @see com.jmonkey.xtracker.mail.pop.ReceivedMailAttachement#getSize()
	 */
	@Override
	public int getSize() {
		return testSize;
	}

	/**
	 * @see com.jmonkey.xtracker.mail.pop.ReceivedMailAttachement#processPart()
	 */
	@Override
	public void processPart() throws MessagingException, IOException {
		processMailCalled = true;
	}

	public boolean isProcessMailCalled() {
		return processMailCalled;
	}

	public void setTestContentType(String testContentType) {
		this.testContentType = testContentType;
	}

	public void setTestFileName(String testFileName) {
		this.testFileName = testFileName;
	}

	public void setTestInputStream(InputStream testInputStream) {
		this.testInputStream = testInputStream;
	}

	public void setTestSize(int testSize) {
		this.testSize = testSize;
	}

}
