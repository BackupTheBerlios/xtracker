package com.jmonkey.xtracker.template.persistor;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.template.TemplateData;

public class TemplateDataPersistor {

	public TemplateDataPersistor() {
		super();
	}

	public void saveTemplate(TemplateData data) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		session.save(data);
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

	public void updateTemplate(TemplateData data) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		session.update(data);
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}
}
