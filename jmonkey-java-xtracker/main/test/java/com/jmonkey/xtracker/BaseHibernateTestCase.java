package com.jmonkey.xtracker;

import junit.framework.TestCase;

public class BaseHibernateTestCase extends TestCase {
	protected HibernateTestHelper	hibernate	= null;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		HibernateSessionFactory.setConfigFileLocation("/test-hibernate.cfg.xml");
		HibernateSessionFactory.resetSessionFactory();
		HibernateSessionFactory.closeSession();
		hibernate	= new HibernateTestHelper();
	}

	@Override
	protected void tearDown() throws Exception {
		hibernate	= null;
		HibernateSessionFactory.resetSessionFactory();
		HibernateSessionFactory.closeSession();
		// HibernateSessionFactory.setConfigFileLocation(HibernateSessionFactory.DEFAULT_CONFIG_FILE_LOCATION);
		super.tearDown();
	}
}
