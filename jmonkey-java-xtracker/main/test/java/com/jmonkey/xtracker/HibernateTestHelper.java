package com.jmonkey.xtracker;

import java.io.Serializable;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

public class HibernateTestHelper {

	public HibernateTestHelper() {
		super();
	}

	@SuppressWarnings("unchecked")
	public void cleanUpDatabase(Class clazz) throws HibernateException {
		List list = null;
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		list = session.find("from " + clazz.getName());
		for (int i = 0; i < list.size(); i++) {
			session.delete(list.get(i));
		}
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

	public void insertTestData(Object data) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		session.save(data);
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

	public List loadAllObjects(Class clazz) throws HibernateException {
		List statusList = null;
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		statusList = session.find("from " + clazz.getName());
		transaction.commit();
		HibernateSessionFactory.closeSession();
		return statusList;
	}

	public Object loadInsertedTestData(Class clazz, Serializable id) throws HibernateException {
		Object value = null;
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		value = session.load(clazz, id);
		transaction.commit();
		HibernateSessionFactory.closeSession();
		return value;
	}

	public void updateTestData(Object data) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		session.update(data);
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}
}
