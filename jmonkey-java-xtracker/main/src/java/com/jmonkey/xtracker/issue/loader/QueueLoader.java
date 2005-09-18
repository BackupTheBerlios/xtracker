package com.jmonkey.xtracker.issue.loader;

import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Queue;

public class QueueLoader extends PersistanceManager {

	public QueueLoader() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Queue> loadQueueList(boolean selectable, boolean active) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Queue.class);
		if (!active) {
			criteria.add(Expression.eq("active", true));
		}
		if (!selectable) {
			criteria.add(Expression.eq("selectable", true));
		}
		List<Queue> queueList = criteria.list();

		transaction.commit();
		checkClose();
		return queueList;
	}

	public Queue loadQueue(String id) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Queue queue = (Queue) session.load(Queue.class, id);
		transaction.commit();
		checkClose();
		return queue;
	}

	public Queue loadAnonymousQueue() throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Queue.class);
		criteria.add(Expression.eq("name", "Anonymous"));
		criteria.setMaxResults(1);
		Queue queue = (Queue) criteria.uniqueResult();

		transaction.commit();
		checkClose();
		return queue;
	}

	public Queue loadQueueByAlias(String string) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Queue.class);
		criteria.add(Expression.ilike("emailAlias", string));
		criteria.setMaxResults(1);
		Queue queue = (Queue) criteria.uniqueResult();

		transaction.commit();
		checkClose();
		return queue;
	}
}
