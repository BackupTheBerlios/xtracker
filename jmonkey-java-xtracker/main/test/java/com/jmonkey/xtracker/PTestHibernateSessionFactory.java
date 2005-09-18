package com.jmonkey.xtracker;

import junit.framework.TestCase;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

public class PTestHibernateSessionFactory extends TestCase {
	public void testCanMakeConnection() throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		assertNotNull(session);
		assertTrue(session.isConnected());
		assertTrue(session.isOpen());
		assertFalse(session.isDirty());
		HibernateSessionFactory.closeSession();
		HibernateSessionFactory.resetSessionFactory();
	}
}
