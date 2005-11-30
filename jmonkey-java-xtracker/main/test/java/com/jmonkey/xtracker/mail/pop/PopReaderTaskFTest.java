package com.jmonkey.xtracker.mail.pop;

import junit.framework.TestCase;

public class PopReaderTaskFTest extends TestCase {
	private PopReaderTask	task	= null;

	public void testRunTask() {
		task.run();
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		task = new PopReaderTask();
	}

	@Override
	protected void tearDown() throws Exception {
		task.cancel();
		task = null;
		super.tearDown();
	}

}
