package com.jmonkey.xtracker;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

public class PersistanceManager {
	protected boolean	autoClose	= false;
	protected Session	session		= null;

	public PersistanceManager() {
		super();
	}

	public void open() throws HibernateException {
		if (session == null) {
			session = HibernateSessionFactory.currentSession();
		}
	}

	public void close() throws HibernateException {
		HibernateSessionFactory.closeSession();
	}

	protected void checkClose() throws HibernateException {
		if (autoClose) {
			HibernateSessionFactory.closeSession();
			session = null;
			autoClose = false;
		}
	}

	protected void checkOpen() throws HibernateException {
		if (session == null) {
			session = HibernateSessionFactory.currentSession();
			autoClose = true;
		}
	}

}
