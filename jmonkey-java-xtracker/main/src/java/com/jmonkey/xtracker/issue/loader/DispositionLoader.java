package com.jmonkey.xtracker.issue.loader;

import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Disposition;

public class DispositionLoader extends PersistanceManager {

	public DispositionLoader() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Disposition> loadDispositionList(boolean filterActive, boolean filterSelectable) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Disposition.class);
		if (filterActive) {
			criteria.add(Expression.eq("active", true));
		}
		if (filterSelectable) {
			criteria.add(Expression.eq("selectable", true));
		}
		criteria.addOrder(Order.asc("id"));
		List<Disposition> list = criteria.list();
		transaction.commit();
		checkClose();
		return list;
	}

	public Disposition loadDisposition(long id) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Disposition disposition = (Disposition) session.load(Disposition.class, id);
		transaction.commit();
		checkClose();
		return disposition;
	}

	public Disposition loadUnspecifiedDisposition() throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Disposition.class);
		criteria.add(Expression.eq("id", new Long(1)));
		criteria.setMaxResults(1);
		Disposition disposition = (Disposition) criteria.uniqueResult();
		transaction.commit();
		checkClose();
		return disposition;
	}
}
