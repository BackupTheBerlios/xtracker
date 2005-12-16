package com.jmonkey.xtracker.escalation;

import java.util.Calendar;

import junit.framework.TestCase;

public class DueDateEscalationCalculatorTest extends TestCase {
	private static final int			START_VALUE	= 50;
	private static final int			MAX_VALUE	= 100;
	private Calendar					testEndDate	= null;
	private DueDateEscalationCalculator	calculator	= null;
	private Calendar					testStartDate;

	public void testNullValueResultsInNullCalculation() {
		calculator.setValue(null);
		Integer result = calculator.calculate();
		assertNull(result);
	}

	public void testNullEndDateDoesntIncrement() {
		calculator.setEndDate(null);
		Integer result = calculator.calculate();
		assertNotNull(result);
		assertEquals(START_VALUE, result.intValue());
	}

	public void testValuePerDayIs25() {
		Integer result = calculator.valuePerDay();
		assertNotNull(result);
		assertEquals(25, result.intValue());

	}

	public void testTwoDaysFromNowResultsInCalcOf75() {
		Integer result = calculator.calculate();
		assertNotNull(result);
		assertEquals(75, result.intValue());
	}

	public void testFractionalDaysDontIncrement() {
		Calendar over100Days = Calendar.getInstance();
		over100Days.setTimeInMillis(0);
		over100Days.set(2005, Calendar.NOVEMBER, 28, 0, 0, 0);
		calculator.setStartDate(over100Days);
		
		Integer result = calculator.calculate();
		assertNotNull(result);
		assertEquals(START_VALUE, result.intValue());
	}
	@Override
	protected void setUp() throws Exception {
		super.setUp();

		testStartDate = Calendar.getInstance();
		testStartDate.setTimeInMillis(0);
		testStartDate.set(2005, Calendar.JANUARY, 28, 0, 0, 0);

		testEndDate = Calendar.getInstance();
		testEndDate.setTimeInMillis(0);
		testEndDate.set(2005, Calendar.JANUARY, 30, 0, 0, 0);

		calculator = new DueDateEscalationCalculator();
		calculator.setMaxValue(MAX_VALUE);
		calculator.setValue(START_VALUE);
		calculator.setEndDate(testEndDate);
		calculator.setStartDate(testStartDate);
	}

	@Override
	protected void tearDown() throws Exception {
		calculator = null;
		super.tearDown();
	}

}
