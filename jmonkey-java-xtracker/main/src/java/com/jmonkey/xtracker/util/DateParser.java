package com.jmonkey.xtracker.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {

	public DateParser() {
		super();
	}

	public Date parseStandardDate(String string) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(string);
	}

}
