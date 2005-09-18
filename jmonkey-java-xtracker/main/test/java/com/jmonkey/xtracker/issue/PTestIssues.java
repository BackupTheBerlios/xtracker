package com.jmonkey.xtracker.issue;

import java.util.List;

import junit.framework.TestCase;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.profile.Person;

public class PTestIssues extends TestCase {
	// private Session session = null;
	// private Transaction transaction = null;
	// private Person manager = null;
	// private Queue queue1 = null;

	// public void testAddQueue() throws HibernateException {
	// Session session = HibernateSessionFactory.currentSession();
	// Transaction transaction = session.beginTransaction();
	//		
	// Person manager = new Person();
	// manager.setUsername("manager");
	// manager.setCreateDate(new Date());
	// manager.setInitials("TM");
	// manager.setPlainPassword("test");
	// manager.setRealname("Test Manager");
	// manager.setSignature("");
	// manager.setAdministrator(true);
	// manager.setAnonymous(false);
	// manager.setCreateDate(new Date());
	// manager.setImmutable(false);
	// manager.setSelectable(true);
	// manager.getEmailAddesses().add(new
	// Email("default","brill@pappin.ca",0,true,new Date()));
	// session.save(manager);
	// transaction.commit();
	// HibernateSessionFactory.closeSession();
	//
	// session = HibernateSessionFactory.currentSession();
	// transaction = session.beginTransaction();
	// Queue queue1 = new Queue();
	//		
	// queue1.setCreateDate(new Date());
	// queue1.setName("test 1");
	// queue1.setEmailAlias("test");
	// queue1.setManager(manager);
	// session.save(queue1);
	// transaction.commit();
	// HibernateSessionFactory.closeSession();
	//
	// // session = HibernateSessionFactory.currentSession();
	// // transaction = session.beginTransaction();
	// // session.delete(queue1);
	// // transaction.commit();
	// // session.delete(manager);
	// // transaction.commit();
	// // HibernateSessionFactory.closeSession();
	// }

	public void testAddTicketsToQueue() throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		Person manager = (Person) session.load(Person.class, "402880e405ab82950105ab8298c70001");
		transaction.commit();
		HibernateSessionFactory.closeSession();

		session = HibernateSessionFactory.currentSession();
		transaction = session.beginTransaction();
		Queue queue = (Queue) session.load(Queue.class, "402880e405ab82950105ab8299250003");
		transaction.commit();
		HibernateSessionFactory.closeSession();

		// session = HibernateSessionFactory.currentSession();
		// transaction = session.beginTransaction();
		// Project project = new Project();
		// project.setName("Default");
		// project.setActive(Boolean.TRUE);
		// project.setCreateDate(new Date());
		// session.save(project);
		// transaction.commit();
		// HibernateSessionFactory.closeSession();

		session = HibernateSessionFactory.currentSession();
		transaction = session.beginTransaction();
		Ticket ticket1 = new Ticket();
		ticket1.setRequestor(manager);
		ticket1.setSubject("test ticket");
		ticket1.setQueue(queue);
		session.save(ticket1);
		transaction.commit();
		HibernateSessionFactory.closeSession();

		session = HibernateSessionFactory.currentSession();
		transaction = session.beginTransaction();
		Ticket ticket2 = new Ticket();
		ticket2.setRequestor(manager);
		ticket2.setSubject("test ticket");
		ticket2.setQueue(queue);
		session.save(ticket2);
		transaction.commit();
		HibernateSessionFactory.closeSession();

		session = HibernateSessionFactory.currentSession();
		transaction = session.beginTransaction();
		ticket1.getDependsOn().add(ticket2);
		session.update(ticket1);
		transaction.commit();
		HibernateSessionFactory.closeSession();

		// session = HibernateSessionFactory.currentSession();
		// transaction = session.beginTransaction();
		// // project.getTickets().add(ticket);
		// // session.update(project);
		// session.update(queue);
		// transaction.commit();
		// HibernateSessionFactory.closeSession();

		// session = HibernateSessionFactory.currentSession();
		// transaction = session.beginTransaction();
		// session.delete(queue);
		// transaction.commit();
		// session.delete(manager);
		// transaction.commit();
		// HibernateSessionFactory.closeSession();
	}

	public void testDependsRef() throws HibernateException {
		Session session = HibernateSessionFactory.currentSession();
		Transaction transaction = session.beginTransaction();
		Ticket ticket2 = (Ticket) session.load(Ticket.class, new Long(3));

		List<Ticket> dobl = ticket2.getDependedOnBy();
		for (Ticket t : dobl) {
			System.out.println(t.getId());
		}
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// HibernateSessionFactory.setConfigFileLocation("/test-hibernate.cfg.xml");
	}

	@Override
	protected void tearDown() throws Exception {
		HibernateSessionFactory.resetSessionFactory();
		// HibernateSessionFactory.setConfigFileLocation(HibernateSessionFactory.DEFAULT_CONFIG_FILE_LOCATION);
		super.tearDown();
	}

}
