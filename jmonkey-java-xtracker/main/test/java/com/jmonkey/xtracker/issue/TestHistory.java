package com.jmonkey.xtracker.issue;

import java.util.Date;

import com.jmonkey.xtracker.issue.History;

import junit.framework.TestCase;

public class TestHistory extends TestCase {
	private History	history	= null;

	public void testNewInstanceHasDefaultImportance() {
		Integer importance = history.getImportance();
		assertNotNull(importance);
		assertEquals(5, importance.intValue());
	}

	public void testNewInstanceHasDefaultCreateDate() {
		Date created = history.getCreateDate();
		assertNotNull(created);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		history = new History();
	}

	@Override
	protected void tearDown() throws Exception {
		history = null;
		super.tearDown();
	}

}
