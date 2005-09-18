package com.jmonkey.xtracker.issue.persistor;

import java.util.Date;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Disposition;

public class DispositionPersistor extends PersistanceManager {

	public DispositionPersistor() {
		super();
	}

	public void saveDisposition(Disposition disposition) throws HibernateException {
		disposition.setCreateDate(new Date());
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.save(disposition);
		transaction.commit();
		checkClose();
	}

	public void updateDisposition(Disposition disposition) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.update(disposition);
		transaction.commit();
		checkClose();
	}

	public void deleteDisposition(Disposition disposition) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.delete(disposition);
		transaction.commit();
		checkClose();
	}
}
