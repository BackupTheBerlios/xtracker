package com.jmonkey.xtracker.mail;

import junit.framework.TestCase;

public class TestTokenManipulator extends TestCase {
	private String				testSubject0				= "[Test 1234] This is the rest...";
	private String				testSubject1				= "Re: [Test 3456] This is the rest...";
	private String				testSubject2				= "Re: [Test1234] This is the rest...";
	private String				testSubject3				= "Re: [45] This is the rest...";
	private String				testSubject4				= "This is the rest...";
	private String				testSubject5				= "Re: This is the rest...";
	private String				testSubject6				= "Re: [Test 666 This is the rest...";
	private String				testForBugInMailProcessor	= "Re: [XTracker 123] This is a test message...";
	private TokenManipulator	manipulator					= null;

	public void testMailProcessorBug() {
		manipulator.setPrefix("XTracker");
		boolean matches = manipulator.hasTicketToken(testForBugInMailProcessor);
		assertTrue(matches);
	}

	public void testHasTokenTrueForNoReplyTag() {
		boolean matches = manipulator.hasTicketToken(testSubject0);
		assertTrue(matches);
	}

	public void testHasTokenTrueForReply() {
		boolean matches = manipulator.hasTicketToken(testSubject1);
		assertTrue(matches);
	}

	public void testHasTokenFalseForMalformedReplyNoSpace() {
		boolean matches = manipulator.hasTicketToken(testSubject2);
		assertFalse(matches);
	}

	public void testHasTokenFalseForMalformedReplyTag() {
		boolean matches = manipulator.hasTicketToken(testSubject3);
		assertFalse(matches);
	}

	public void testHasTokenFalseForNewSubject() {
		boolean matches = manipulator.hasTicketToken(testSubject4);
		assertFalse(matches);
	}

	public void testHasTokenFalseForMalformedReplyNoCloseBracket() {
		boolean matches = manipulator.hasTicketToken(testSubject5);
		assertFalse(matches);
	}

	public void testHasTokenFalseForReplySubject() {
		boolean matches = manipulator.hasTicketToken(testSubject6);
		assertFalse(matches);
	}

	public void testCanExtrackTicketIdForOriginalSubject() {
		Long id = manipulator.extractTicketNumber(testSubject0);
		assertNotNull(id);
		assertEquals(1234, id.longValue());
	}

	public void testCanExtrackTicketIdForReplySubject() {
		Long id = manipulator.extractTicketNumber(testSubject1);
		assertNotNull(id);
		assertEquals(3456, id.longValue());
	}

	public void testExtrackTicketIdIsNullForNoToken() {
		Long id = manipulator.extractTicketNumber(testSubject4);
		assertNull(id);
	}

	public void testCanStripTokenFromSubject() {
		String result = manipulator.stripToken(testSubject0);
		assertNotNull(result);
		assertEquals("This is the rest...", result);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		manipulator = new TokenManipulator();
		manipulator.setPrefix("Test");
	}

	@Override
	protected void tearDown() throws Exception {
		manipulator = null;
		super.tearDown();
	}

}
