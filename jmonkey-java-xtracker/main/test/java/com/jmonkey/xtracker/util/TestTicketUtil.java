package com.jmonkey.xtracker.util;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.jmonkey.xtracker.issue.Ticket;

public class TestTicketUtil extends TestCase {
	private List<Ticket>	testTicketList	= null;

	public void testEmptyTicketListResultsInEmptyIdArray() {
		List<Long> result = TicketUtil.getTicketIdList(new ArrayList<Ticket>());
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	public void testTickerIdFromTicketListAreReturned() {
		List<Long> result = TicketUtil.getTicketIdList(testTicketList);
		assertNotNull(result);
		assertEquals(2, result.size());
		assertEquals(new Long(123), result.get(0));
		assertEquals(new Long(321), result.get(1));
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testTicketList = new ArrayList<Ticket>();
		Ticket t1 = new Ticket();
		t1.setId(123L);
		testTicketList.add(t1);
		Ticket t2 = new Ticket();
		t2.setId(321L);
		testTicketList.add(t2);
	}

	@Override
	protected void tearDown() throws Exception {
		testTicketList = null;
		super.tearDown();
	}

}
