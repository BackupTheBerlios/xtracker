package com.jmonkey.xtracker.issue.persistor;

import java.util.Date;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Status;

public class StatusPersistor extends PersistanceManager {

	public StatusPersistor() {
		super();
	}

	public void saveStatus(Status status) throws HibernateException {
		status.setCreateDate(new Date());
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.save(status);
		transaction.commit();
		checkClose();
	}

	public void updateStatus(Status status) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.update(status);
		transaction.commit();
		checkClose();
	}

	public void deleteStatus(Status status) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.delete(status);
		transaction.commit();
		checkClose();
	}
}
