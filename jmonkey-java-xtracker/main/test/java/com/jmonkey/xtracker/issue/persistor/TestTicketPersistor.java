package com.jmonkey.xtracker.issue.persistor;

import java.util.Date;
import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.test.ObjectMother;

public class TestTicketPersistor extends BaseHibernateTestCase {
	private Person			requestor	= null;
	private Ticket			testTicket1	= null;
	private Ticket			testTicket2	= null;
	private Status			testStatus	= null;
	private TicketPersistor	persistor	= null;

	@SuppressWarnings("unchecked")
	public void testSaveTicketSucceedsOnNewTicket() throws HibernateException {
		try {
			persistor.saveTicket(testTicket1);
		} catch (HibernateException e) {
			fail(e.getMessage());
		}

		List list = hibernate.loadAllObjects(Ticket.class);
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(testTicket1.getSubject(), ((Ticket) list.get(0)).getSubject());
	}

	@SuppressWarnings("unchecked")
	public void testUpdateTicketWithExistingId() throws HibernateException {
		hibernate.insertTestData(testTicket1);

		Long id = testTicket1.getId();
		testTicket2.setId(id);
		persistor.updateTicket(testTicket2);

		List list = hibernate.loadAllObjects(Ticket.class);
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(testTicket2.getSubject(), ((Ticket) list.get(0)).getSubject());

	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		persistor = new TicketPersistor();

		testStatus = ObjectMother.birthStatus();
		hibernate.insertTestData(testStatus);
		setupTestPerson();
		setupTicket1();
		setupTicket2();

	}

	private void setupTicket2() {
		testTicket2 = new Ticket();
		testTicket2.setCreateDate(new Date());
		testTicket2.setPriority(new Integer(50));
		testTicket2.setSubject("Test Ticket 2");
		testTicket2.setWorked(new Double(1.4));
		testTicket2.setRequestor(requestor);
		testTicket1.setStatus(testStatus);
	}

	private void setupTicket1() {
		testTicket1 = new Ticket();
		testTicket1.setCreateDate(new Date());
		testTicket1.setPriority(new Integer(50));
		testTicket1.setSubject("Test Ticket 1");
		testTicket1.setWorked(new Double(1.4));
		testTicket1.setRequestor(requestor);
		testTicket1.setStatus(testStatus);
	}

	private void setupTestPerson() throws HibernateException {
		requestor = new Person();
		requestor.setUsername("test");
		requestor.setInitials("TU");
		requestor.setRealname("test");
		requestor.setActive(Boolean.TRUE);
		requestor.setCreateDate(new Date());
		requestor.setPlainPassword("test");
		requestor.setSelectable(Boolean.TRUE);
		requestor.setEmailAddress("brill@pappin.ca");
		hibernate.insertTestData(requestor);
	}

	@Override
	protected void tearDown() throws Exception {
		persistor = null;
		hibernate.cleanUpDatabase(Ticket.class);
		hibernate.cleanUpDatabase(Person.class);
		hibernate.cleanUpDatabase(Status.class);
		super.tearDown();
	}

}
