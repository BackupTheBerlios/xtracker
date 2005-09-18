package com.jmonkey.xtracker.issue;

import java.util.Date;

import com.jmonkey.xtracker.issue.Status;

import junit.framework.TestCase;

public class TestStatus extends TestCase {
	private Status	status	= null;


	public void testNewInstanceHasDefaultCreateDate() {
		Date value = status.getCreateDate();
		assertNotNull(value);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		status = new Status();
	}

	@Override
	protected void tearDown() throws Exception {
		status = null;
		super.tearDown();
	}

}
