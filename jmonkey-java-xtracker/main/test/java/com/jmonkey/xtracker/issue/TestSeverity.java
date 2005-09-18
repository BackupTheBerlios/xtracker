package com.jmonkey.xtracker.issue;

import java.util.Date;

import com.jmonkey.xtracker.issue.Severity;

import junit.framework.TestCase;

public class TestSeverity extends TestCase {
	private Severity	severity	= null;

	public void testNewInstanceHasDefaultCreateDate() {
		Date value = severity.getCreateDate();
		assertNotNull(value);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		severity = new Severity();
	}

	@Override
	protected void tearDown() throws Exception {
		severity = null;
		super.tearDown();
	}

}
