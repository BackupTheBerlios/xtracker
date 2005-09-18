package com.jmonkey.xtracker.profile;

import java.util.Date;

import junit.framework.TestCase;

public class TestPerson extends TestCase {
	private final String	testPlainPassword	= "Test";
	private Person			person				= null;

	public void testNewInstanceHasDefaultCreateDate() {
		Date value = person.getCreateDate();
		assertNotNull(value);
	}

	public void testNewInstanceHasDefaultPhoneNumbersList() {
		String value = person.getPhoneNumber();
		assertNull(value);
	}

	public void testPlainPasswordWhenMatches() {
		person.setPlainPassword(testPlainPassword);
		boolean result = person.checkPlainPassword(testPlainPassword);
		assertTrue(result);
	}

	public void testSetPlainPasswordDigestsWithMd5() {
		person.setPlainPassword(testPlainPassword);
		String password = person.getPassword();
		assertEquals(32, password.length());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		person = new Person();
		person.setUsername("test");
		person.setCreateDate(new Date());
	}

	@Override
	protected void tearDown() throws Exception {
		person = null;
		super.tearDown();
	}

}
