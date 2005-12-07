package com.jmonkey.xtracker.profile.loader;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.profile.Person;

public class PersonLoader {
	private Logger	logger	= LogManager.getLogger(PersonLoader.class);

	public PersonLoader() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Person> loadPersonList(boolean selectable) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Person.class);
		criteria.add(Expression.eq("active", true));
		if (selectable) {
			criteria.add(Expression.eq("selectable", true));
		}
		List<Person> list = criteria.list();
		transaction.commit();
		HibernateSessionFactory.closeSession();
		return list;
	}

	public Person loadPerson(String id) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		Person newPperson = (Person) session.load(Person.class, id);
		transaction.commit();
		HibernateSessionFactory.closeSession();
		return newPperson;
	}

	@SuppressWarnings("unchecked")
	public Person loadPersonForPrincipal(Principal principal) throws HibernateException {
		// Principal principal = request.getUserPrincipal();
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Person.class);
		criteria.add(Expression.eq("username", principal.getName()));
		criteria.setMaxResults(1);
		List<Person> personList = criteria.list();
		Person person = null;
		if (personList.size() == 1) {
			person = personList.get(0);
		}
		transaction.commit();
		HibernateSessionFactory.closeSession();
		return person;
	}

	public Person findPersonByEmail(String emailAddress) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Person.class);
		// criteria.createAlias("emailAddesses", "email");
		criteria.add(Expression.eq("emailAddress", emailAddress));
		// criteria.add(Expression.like("realname", personalName,
		// MatchMode.ANYWHERE));
		criteria.setMaxResults(1);
		Person person = (Person) criteria.uniqueResult();
		transaction.commit();
		HibernateSessionFactory.closeSession();
		return person;
	}

	public Person authenticatePerson(String username, char[] password) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Person.class);
		criteria.add(Expression.eq("username", username));
		criteria.setMaxResults(1);
		Person person = (Person) criteria.uniqueResult();
		transaction.commit();
		HibernateSessionFactory.closeSession();
		logger.debug("Found person: " + person.getUsername());
		if (person.checkPlainPassword(new String(password))) {
			return person;
		}
		return null;
	}

	public List<Person> loadExcludedPersonList(List<String> excludeList, boolean selectable) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Person.class);
		criteria.add(Expression.eq("active", true));
		if (selectable) {
			criteria.add(Expression.eq("selectable", true));
		}
		if (excludeList != null && !excludeList.isEmpty()) {
			criteria.add(Expression.not(Expression.in("id", excludeList)));
		}
		List<Person> list = criteria.list();
		transaction.commit();
		HibernateSessionFactory.closeSession();
		return list;
	}
}
