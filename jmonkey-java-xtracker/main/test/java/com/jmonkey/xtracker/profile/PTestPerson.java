package com.jmonkey.xtracker.profile;

import java.util.Date;

import junit.framework.TestCase;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.profile.Person;

public class PTestPerson extends TestCase {

	public void testCanAddAndDeletePerson() throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();

		Person person = new Person();
		person.setUsername("test");
		person.setCreateDate(new Date());
		// person.setAddress("123 Anyplace St.");
		person.setInitials("TB");
		person.setPlainPassword("test");
		person.setRealname("Test Bugger");
		person.setSignature("");
		// person.setPhoneNumbers(phoneNumbers);
		session.save(person);
		transaction.commit();
//		session.delete(person);
//		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
//		HibernateSessionFactory.setConfigFileLocation("/test-hibernate.cfg.xml");
	}

	@Override
	protected void tearDown() throws Exception {
		HibernateSessionFactory.resetSessionFactory();
//		HibernateSessionFactory.setConfigFileLocation(HibernateSessionFactory.DEFAULT_CONFIG_FILE_LOCATION);
		super.tearDown();
	}

}
