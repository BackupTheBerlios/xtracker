package com.jmonkey.xtracker.util;

import junit.framework.TestCase;

public class TestStringList extends TestCase {
	private StringList	stringList	= null;

	public void testCanJoinLongValues() {
		stringList.join(1L);
		stringList.join(2L);
		stringList.join(234L);
		stringList.join(44L);
		String result = stringList.getBuffer();
		assertNotNull(result);
		assertEquals("1 2 234 44", result);
	}

	public void testCanJoinLongValuesWithSeparator() {
		stringList.setSeparator(", ");
		stringList.join(1L);
		stringList.join(2L);
		stringList.join(234L);
		stringList.join(44L);
		String result = stringList.getBuffer();
		assertNotNull(result);
		assertEquals("1, 2, 234, 44", result);
	}

	public void testCanConvertLongStringToLongArray() {
		stringList.setBuffer("1 2 234 44");
		long[] longArray = stringList.getLongArray();
		assertNotNull(longArray);
		assertEquals(4, longArray.length);
		assertEquals(1L, longArray[0]);
		assertEquals(2L, longArray[1]);
		assertEquals(234L, longArray[2]);
		assertEquals(44L, longArray[3]);
	}

	public void testCanConvertLongStringToLongArrayWithSeparator() {
		stringList.setSeparator(", ");
		stringList.setBuffer("1, 2, 234, 44");
		long[] longArray = stringList.getLongArray();
		assertNotNull(longArray);
		assertEquals(4, longArray.length);
		assertEquals(1L, longArray[0]);
		assertEquals(2L, longArray[1]);
		assertEquals(234L, longArray[2]);
		assertEquals(44L, longArray[3]);
	}

	public void testZeroLengthInputStringResultsInZeroLengthArray() {
		stringList.setBuffer("");
		long[] longArray = stringList.getLongArray();
		assertNotNull(longArray);
		assertEquals(0, longArray.length);
	}

	public void testWhitespaceInputStringResultsInZeroLengthArray() {
		stringList.setBuffer(" ");
		long[] longArray = stringList.getLongArray();
		assertNotNull(longArray);
		assertEquals(0, longArray.length);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		stringList = new StringList();
	}

	@Override
	protected void tearDown() throws Exception {
		stringList = null;
		super.tearDown();
	}

}
