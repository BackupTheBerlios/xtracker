package com.jmonkey.xtracker.my.tickets;

import junit.framework.TestCase;

public class TestReplyStringFormatter extends TestCase {
	private ReplyStringFormatter	formatter	= null;

	public void testFormattedStringBreaksAtWordBoundry() {
		String result = formatter.format("this is a test.");
		assertNotNull(result);
		assertEquals("> this is a test.", result);
	}

	public void testNullStringResultsInZeroLengthString() {
		String result = formatter.format(null);
		assertNotNull(result);
		assertEquals("", result);
	}

	public void testHasLeadingLinesIfAnySpecified() {
		formatter.setLeadingLines(2);
		String result = formatter.format("this is a test.");
		assertNotNull(result);
		assertEquals("\r\n\r\n> this is a test.", result);
	}

	public void testAlreadyPrefixedHasSecondPrefix() {
		String result = formatter.format("> this is a test.");
		assertNotNull(result);
		assertEquals("> > this is a test.", result);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		formatter = new ReplyStringFormatter();
//		formatter.setLineLength(10);
		formatter.setLineTerminator("\r\n");
//		formatter.setPrefixString("> ");
	}

	@Override
	protected void tearDown() throws Exception {
		formatter = null;
		super.tearDown();
	}

}
