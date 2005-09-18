package com.jmonkey.xtracker.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

	public DateFormatter() {
		super();
	}

	public String formatStandardDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	public String formatStandardDateTime(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(date);
	}

}
