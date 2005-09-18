package com.jmonkey.xtracker.issue;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.jmonkey.xtracker.issue");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestStatus.class);
		suite.addTestSuite(TestQueue.class);
		suite.addTestSuite(TestSeverity.class);
		suite.addTestSuite(TestHistory.class);
		suite.addTestSuite(TestTicket.class);
		suite.addTestSuite(TestProject.class);
		//$JUnit-END$
		return suite;
	}

}
