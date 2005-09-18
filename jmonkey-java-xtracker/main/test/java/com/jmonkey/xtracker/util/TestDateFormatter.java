package com.jmonkey.xtracker.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.jmonkey.xtracker.util.DateFormatter;

import junit.framework.TestCase;

public class TestDateFormatter extends TestCase {
	private Date			testDate1	= null;
	private DateFormatter	formatter	= null;

	public void testStandardShortDateFormat() {
		String value = formatter.formatStandardDate(testDate1);
		assertNotNull(value);
		assertEquals("2005-01-05", value);

	}

	public void testStardardDateTimeFormat() {
		String value = formatter.formatStandardDateTime(testDate1);
		assertNotNull(value);
		assertEquals("2005-01-05 09:30:02", value);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		Calendar calendar = Calendar.getInstance(Locale.CANADA);
		calendar.set(Calendar.YEAR, 2005);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 5);
		calendar.set(Calendar.HOUR, 9);
		calendar.set(Calendar.MINUTE, 30);
		calendar.set(Calendar.SECOND, 2);
		testDate1 = calendar.getTime();
		formatter = new DateFormatter();
	}

	@Override
	protected void tearDown() throws Exception {
		formatter = null;
		super.tearDown();
	}

}
