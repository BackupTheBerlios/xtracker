package com.jmonkey.xtracker.issue.loader;

import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Status;

public class StatusLoader extends PersistanceManager {

	public StatusLoader() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Status> loadStatusList() throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Status.class);
		criteria.addOrder(Order.asc("id"));
		List<Status> list = criteria.list();
		transaction.commit();
		checkClose();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Status> loadStatusListNotClosed() throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Status.class);
		criteria.add(Expression.and(Expression.not(Expression.eq("id", new Long(3))), Expression.and(Expression.not(Expression.eq("id", new Long(4))), Expression.not(Expression.eq("id", new Long(6))))));
		criteria.addOrder(Order.asc("id"));
		List<Status> list = criteria.list();
		transaction.commit();
		checkClose();
		return list;
	}

	public Status loadStatus(long id) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Status status = (Status) session.load(Status.class, id);
		transaction.commit();
		checkClose();
		return status;
	}

	public Status loadStatusWithNextId(Status status) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Status.class);
		criteria.add(Expression.gt("id", status.getId()));
		criteria.addOrder(Order.asc("id"));
		criteria.setMaxResults(1);
		Status newStatus = (Status) criteria.uniqueResult();
		transaction.commit();
		checkClose();
		return newStatus;
	}

	public Status loadNewStatus() throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Status.class);
		criteria.add(Expression.eq("id", new Long(1)));
		criteria.setMaxResults(1);
		Status newStatus = (Status) criteria.uniqueResult();
		transaction.commit();
		checkClose();
		return newStatus;
	}

	public Status loadOpenStatus() throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Status.class);
		criteria.add(Expression.eq("id", new Long(2)));
		criteria.setMaxResults(1);
		Status newStatus = (Status) criteria.uniqueResult();
		transaction.commit();
		checkClose();
		return newStatus;
	}

}
