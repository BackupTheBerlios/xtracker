package com.jmonkey.xtracker.cipher;

import junit.framework.TestCase;

public class TestPersonCipher extends TestCase {
	private final byte[]	testSalt		= { (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c, (byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99 };
	private final String	cipherText		= "7be63f1d3ead3c12";
	private final String	clearText		= "test";
	private PersonCipher	personCipher	= null;

	public void testCanEncryptClearText() throws Exception {
		String result = personCipher.encrypt(clearText);
		assertNotNull(result);
		assertEquals(cipherText, result);
	}

	public void testCanDecryptCipherText() throws Exception {
		String result = personCipher.decrypt(cipherText);
		assertNotNull(result);
		assertEquals(clearText, result);
	}
	
	public void testUsingExpectedValues() throws Exception {
		PersonCipher c = new PersonCipher();
		c.setUsername("brill");
		c.setPassword("8e77beaa69e3b932c1f151afeb330bdc");
		String result = c.encrypt(clearText);
		assertNotNull(result);
		assertEquals("3f9d6a04b7517595", result);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		personCipher = new PersonCipher();
		personCipher.setUsername(clearText);
		personCipher.setPassword(clearText);
		personCipher.setSalt(testSalt);
		personCipher.setIterationCount(3);
	}

	@Override
	protected void tearDown() throws Exception {
		personCipher = null;
		super.tearDown();
	}

}
