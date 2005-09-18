package com.jmonkey.xtracker.issue.loader;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.jmonkey.xtracker.issue.loader");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestStatusLoader.class);
		suite.addTestSuite(TestProjectLoader.class);
		suite.addTestSuite(TestDispositionLoader.class);
		suite.addTestSuite(TestTicketLoader.class);
		suite.addTestSuite(TestQueueLoader.class);
		suite.addTestSuite(TestSeverityLoader.class);
		//$JUnit-END$
		return suite;
	}

}
