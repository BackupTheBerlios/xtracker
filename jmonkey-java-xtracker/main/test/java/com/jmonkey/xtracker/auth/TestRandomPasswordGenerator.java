package com.jmonkey.xtracker.auth;

import junit.framework.TestCase;

public class TestRandomPasswordGenerator extends TestCase {
	private RandomPasswordGenerator	generator	= null;

	public void testCanGenerateTwoDifferentPasswords() {
		String value1 = generator.getNextPassword();
		String value2 = generator.getNextPassword();
		assertNotNull(value1);
		assertNotNull(value2);
		assertFalse(value1.equals(value2));
	}

	public void testDifferentPasswordOnEveryRequest() {
		String lastPassword = null;
		for (int i = 0; i < 20; i++) {
			String pwd = generator.getNextPassword();
			if (lastPassword != null) {
				assertFalse(pwd.equals(lastPassword));
			}
			lastPassword = pwd;
		}
		assertNotNull(lastPassword);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		generator = new RandomPasswordGenerator();
	}

	@Override
	protected void tearDown() throws Exception {
		generator = null;
		super.tearDown();
	}

}
