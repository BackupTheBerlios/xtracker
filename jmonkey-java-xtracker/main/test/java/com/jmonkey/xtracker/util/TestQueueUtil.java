package com.jmonkey.xtracker.util;

import junit.framework.TestCase;

import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.mail.FakeMailConfig;

public class TestQueueUtil extends TestCase {
	private Queue			testQueue		= null;
	private FakeMailConfig	fakeMailConfig	= null;

	public void testGetExpectedQueueAddress() {
		String addr = QueueUtil.getQueueEmailAddress(fakeMailConfig, testQueue);
		assertNotNull(addr);
		assertEquals("test@example.com", addr);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testQueue = new Queue();
		testQueue.setEmailAlias("test");

		fakeMailConfig = new FakeMailConfig();
		fakeMailConfig.setEmailDomain("example.com");
	}

	@Override
	protected void tearDown() throws Exception {
		fakeMailConfig = null;
		testQueue = null;
		super.tearDown();
	}

}
