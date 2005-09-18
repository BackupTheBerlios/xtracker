package com.jmonkey.xtracker.issue.loader;

import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Severity;

public class SeverityLoader extends PersistanceManager {

	public SeverityLoader() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Severity> loadSeverityList() throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Severity.class);
		criteria.addOrder(Order.asc("id"));
		List<Severity> list = criteria.list();
		transaction.commit();
		checkClose();
		return list;
	}

	public Severity loadSeverity(long id) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Severity severity = (Severity) session.load(Severity.class, id);
		transaction.commit();
		checkClose();
		return severity;
	}

	public Severity loadUnspecifiedSeverity() throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Severity.class);
		criteria.add(Expression.eq("id", new Long(1)));
		criteria.setMaxResults(1);
		Severity severity = (Severity) criteria.uniqueResult();
		transaction.commit();
		checkClose();
		return severity;
	}
}
