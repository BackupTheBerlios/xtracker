package com.jmonkey.xtracker.auth;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

import com.jmonkey.xtracker.auth.Digest;

import junit.framework.TestCase;

public class TestDigest extends TestCase {
	private final String	testPlainString		= "a string";
	private final String	testDigestedString	= "3a315533c0f34762e0c45e3d4e9d525c";
	private Digest			digest				= null;

	public void testCanDigestBytesWithMD5() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		byte[] data1 = testPlainString.getBytes(Digest.DEFAULT_CHARSET);
		byte[] value = digest.digest(data1);
		assertNotNull(value);
		assertEquals(testDigestedString, new String(Hex.encodeHex(value)));
	}

	public void testCanDigestStringWithMD5() throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String value = digest.digest(testPlainString);
		assertNotNull(value);
		assertEquals(testDigestedString, value);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		digest = new Digest();
	}

	@Override
	protected void tearDown() throws Exception {
		digest = null;
		super.tearDown();
	}

}
