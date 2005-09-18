package com.jmonkey.xtracker.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.jmonkey.xtracker.util.DateParser;

import junit.framework.TestCase;

public class TestDateParser extends TestCase {
	private DateParser	parser	= null;

	public void testParseStandardDate() throws ParseException {
		Date value = parser.parseStandardDate("2004-02-21");
		assertNotNull(value);
		Calendar calendar = Calendar.getInstance(Locale.CANADA);
		calendar.setTime(value);
		assertEquals(2004, calendar.get(Calendar.YEAR));
		assertEquals(Calendar.FEBRUARY, calendar.get(Calendar.MONTH));
		assertEquals(21, calendar.get(Calendar.DAY_OF_MONTH));
	}

	public void testBogusDateThrowsException() {
		try {
			parser.parseStandardDate("2004:02:21");
			fail("Expected parse exception...");
		} catch (ParseException e) {
			// expected
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		parser = new DateParser();
	}

	@Override
	protected void tearDown() throws Exception {
		parser = null;
		super.tearDown();
	}

}
