package com.jmonkey.xtracker.escalation;

import java.util.Calendar;

public class DueDateEscalationCalculator {
	private Calendar	startDate	= null;
	private Calendar	endDate		= null;
	private Integer		value		= null;
	private Integer		maxValue	= null;

	public DueDateEscalationCalculator() {
		super();
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar end) {
		this.endDate = end;
	}

	public Integer getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer calculate() {
		if (value == null) {
			return null;
		}
		Integer result = value;
		if (endDate != null) {
			Integer perDay = valuePerDay();
			result = result + perDay;
			if (result > maxValue) {
				result = maxValue;
			}
		}
		return result;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar start) {
		this.startDate = start;
	}

	public Integer valuePerDay() {
		int days = findDaysBetweenDates();
		int remaining = findValueRemaining();
		int part = remaining / days;
		return part;
	}

	private int findValueRemaining() {
		int remaining = maxValue - value;
		return remaining;
	}

	private int findDaysBetweenDates() {
		long startDateMillis = startDate.getTimeInMillis();
		long endDateMillis = endDate.getTimeInMillis();
		long diff = endDateMillis - startDateMillis;
		int days = (int) (diff / (1000L * 60L * 60L * 24L));
		return days;
	}
}
