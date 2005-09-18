package com.jmonkey.xtracker.profile.persistor;

import java.util.Date;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.profile.Person;

public class PersonPersistor {

	public PersonPersistor() {
		super();
	}

	public void savePerson(Person person) throws HibernateException {
		person.setCreateDate(new Date());
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		session.save(person);
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

	public void updatePerson(Person person) throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		session.update(person);
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

	// XXX This is bogus becuase a person can never be deleted as they may have
	// tickets assigned to them that are closed.
	// public void deletePerson(Person person) throws HibernateException {
	// Session session = HibernateSessionFactory.currentSession();
	// Transaction transaction = session.beginTransaction();
	// session.delete(person);
	// transaction.commit();
	// HibernateSessionFactory.closeSession();
	// }
}
