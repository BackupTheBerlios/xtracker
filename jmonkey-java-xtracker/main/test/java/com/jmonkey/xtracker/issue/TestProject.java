package com.jmonkey.xtracker.issue;

import java.util.Date;

import com.jmonkey.xtracker.issue.Project;

import junit.framework.TestCase;

public class TestProject extends TestCase {
	private Project	project	= null;

	public void testNewInstanceHasDefaultActiveTrue() {
		Boolean active = project.isActive();
		assertNotNull(active);
		assertTrue(active.booleanValue());
	}

	public void testNewInstanceHasDefaultCreateDate() {
		Date value = project.getCreateDate();
		assertNotNull(value);
	}

//	public void testNewInstanceHasDefaultTicketList() {
//		List value = project.getTickets();
//		assertNotNull(value);
//		assertEquals(0, value.size());
//	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		project = new Project();
	}

	@Override
	protected void tearDown() throws Exception {
		project = null;
		super.tearDown();
	}

}
