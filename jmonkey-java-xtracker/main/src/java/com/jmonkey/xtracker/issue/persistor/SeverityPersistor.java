package com.jmonkey.xtracker.issue.persistor;

import java.util.Date;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Severity;

public class SeverityPersistor extends PersistanceManager {

	public SeverityPersistor() {
		super();
	}

	public void saveSeverity(Severity severity) throws HibernateException {
		severity.setCreateDate(new Date());
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.save(severity);
		transaction.commit();
		checkClose();
	}

	public void updateSeverity(Severity severity) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.update(severity);
		transaction.commit();
		checkClose();
	}

	public void deleteSeverity(Severity severity) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.delete(severity);
		transaction.commit();
		checkClose();
	}
}
