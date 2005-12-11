package com.jmonkey.xtracker.template.loader;

import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.template.TemplateData;

public class TemplateDataLoader {
	private Logger	logger	= LogManager.getLogger(TemplateDataLoader.class);

	public TemplateDataLoader() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<TemplateData> loadTemplateList() throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(TemplateData.class);
		List<TemplateData> list = criteria.list();
		transaction.commit();
		HibernateSessionFactory.closeSession();
		return list;
	}

	public TemplateData loadTemplate(String id) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		TemplateData result = (TemplateData) session.load(TemplateData.class, id);
		transaction.commit();
		HibernateSessionFactory.closeSession();
		return result;
	}

	public TemplateData loadByResourceKey(String key) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(TemplateData.class);
		criteria.add(Expression.eq("resourceKey", key));
		criteria.setMaxResults(1);
		TemplateData result = (TemplateData) criteria.uniqueResult();
		transaction.commit();
		HibernateSessionFactory.closeSession();
		return result;
	}

	public TemplateData findTemplateByName(String name) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(TemplateData.class);
		criteria.add(Expression.eq("name", name));
		criteria.setMaxResults(1);
		TemplateData result = (TemplateData) criteria.uniqueResult();
		transaction.commit();
		HibernateSessionFactory.closeSession();
		return result;
	}
}
