package com.jmonkey.xtracker.issue;

import java.util.Date;

import com.jmonkey.xtracker.issue.Queue;

import junit.framework.TestCase;

public class TestQueue extends TestCase {
	private Queue	queue	= null;

	public void testNewInstanceHasDefaultActiveTrue() {
		Boolean active = queue.isActive();
		assertNotNull(active);
		assertTrue(active.booleanValue());
	}

	public void testNewInstanceHasDefaultCreateDate() {
		Date value = queue.getCreateDate();
		assertNotNull(value);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		queue = new Queue();
	}

	@Override
	protected void tearDown() throws Exception {
		queue = null;
		super.tearDown();
	}

}
