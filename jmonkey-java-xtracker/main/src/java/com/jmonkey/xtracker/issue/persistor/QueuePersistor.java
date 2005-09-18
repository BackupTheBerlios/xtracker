package com.jmonkey.xtracker.issue.persistor;

import java.util.Date;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Queue;

public class QueuePersistor extends PersistanceManager {

	public QueuePersistor() {
		super();
	}

	public void saveQueue(Queue queue) throws HibernateException {
		queue.setCreateDate(new Date());
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.save(queue);
		transaction.commit();
		checkClose();
	}

	public void updateQueue(Queue queue) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.update(queue);
		transaction.commit();
		checkClose();
	}

	public void deleteQueue(Queue queue) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.delete(queue);
		transaction.commit();
		checkClose();
	}
}
