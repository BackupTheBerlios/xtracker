package com.jmonkey.xtracker.my.tickets;

import junit.framework.TestCase;

import org.apache.struts.action.ActionForward;

import com.jmonkey.xtracker.my.tickets.ActionForwardFactory;

public class TestActionForwardFactory extends TestCase {
	private ActionForwardFactory	factory	= null;

	public void testCanGetOpenTicketForward() {
		ActionForward forward = factory.getOpenTicketForward(new Long(2));
		assertTrue(forward.getRedirect());
		assertEquals("/my/openTicket.do?id=2", forward.getPath());
	}
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		factory = new ActionForwardFactory();
	}

	@Override
	protected void tearDown() throws Exception {
		factory = null;
		super.tearDown();
	}

}
