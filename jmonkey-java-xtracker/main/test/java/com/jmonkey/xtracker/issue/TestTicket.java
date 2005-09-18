package com.jmonkey.xtracker.issue;

import java.util.Date;

import com.jmonkey.xtracker.issue.Ticket;

import junit.framework.TestCase;

public class TestTicket extends TestCase {
	private Ticket	ticket	= null;

	public void testNewInstanceHasDefaultPriority() {
		Integer priority = ticket.getPriority();
		assertNotNull(priority);
		assertEquals(50, priority.intValue());
	}

	public void testNewInstanceHasDefaultDates() {
		Date createDate = ticket.getCreateDate();
		Date modifyDate = ticket.getModifyDate();
		assertNotNull(createDate);
		assertNotNull(modifyDate);
	}

	public void testNewInstanceHasDefaultLists() {
		assertNotNull(ticket.getHistory());
		assertNotNull(ticket.getOwners());
//		assertNotNull(ticket.getRelationships());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ticket = new Ticket();
	}

	@Override
	protected void tearDown() throws Exception {
		ticket = null;
		super.tearDown();
	}

}
