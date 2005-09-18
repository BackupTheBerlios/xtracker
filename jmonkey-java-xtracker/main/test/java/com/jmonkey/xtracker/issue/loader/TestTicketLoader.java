package com.jmonkey.xtracker.issue.loader;

import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.test.ObjectMother;

public class TestTicketLoader extends BaseHibernateTestCase {
	private Queue			testQueue	= null;
	private Project			testProject	= null;
	private Person			testPerson	= null;
	private Ticket			testTicket	= null;
	// private Ticket testTicket2 = null;
	private TicketLoader	loader		= null;

	public void testShouldLoadTicketById() throws HibernateException {
		Ticket ticket = loader.loadTicket(new Long(1));
		assertNotNull(ticket);
		assertEquals(ObjectMother.TEST_TICKET_SUBJECT, ticket.getSubject());
	}

	public void testShouldLoadTicketListForPerson() throws HibernateException {
		List<Ticket> ticketList = loader.loadTicketListForPerson(testPerson, true);
		assertNotNull(ticketList);
		assertEquals(1, ticketList.size());
	}

	public void testShouldLoadTicketListForRequestor() throws HibernateException {
		List<Ticket> ticketList = loader.loadTicketListForRequestor(testPerson, true);
		assertNotNull(ticketList);
		assertEquals(1, ticketList.size());
	}

	public void testShouldLoadTicketListForProject() throws HibernateException {
		List<Ticket> ticketList = loader.loadTicketsInProject(testProject, true);
		assertNotNull(ticketList);
		assertEquals(1, ticketList.size());
	}

	public void testShouldLoadTicketListForQueue() throws HibernateException {
		List<Ticket> ticketList = loader.loadTicketsInQueue(testQueue, true);
		assertNotNull(ticketList);
		assertEquals(1, ticketList.size());
	}

	public void testShouldLoadTicketListForWatcher() throws HibernateException {
		List<Ticket> ticketList = loader.loadWatchedTicketListForPerson(testPerson, true);
		assertNotNull(ticketList);
		assertEquals(1, ticketList.size());
	}
	
	public void testCanLoadTicketListFromPartialId() throws HibernateException {
		List<Ticket> ticketList = loader.loadTicketListPartialId(testTicket.getId(), 11);
		assertNotNull(ticketList);
		assertEquals(1, ticketList.size());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		loader = new TicketLoader();

		Status status = ObjectMother.birthStatus();
		hibernate.insertTestData(status);
		Disposition disposition = ObjectMother.birthDisposition();
		hibernate.insertTestData(disposition);
		Severity severity = ObjectMother.birthSeverity();
		hibernate.insertTestData(severity);
		testPerson = ObjectMother.birthPerson();
		hibernate.insertTestData(testPerson);
		testQueue = ObjectMother.birthQueue();
		testQueue.setManager(testPerson);
		hibernate.insertTestData(testQueue);
		testProject = ObjectMother.birthProject();
		hibernate.insertTestData(testProject);

		testTicket = ObjectMother.birthTicket();
		testTicket.setDisposition(disposition);
		testTicket.setSeverity(severity);
		testTicket.setStatus(status);
		testTicket.setRequestor(testPerson);

		List<Person> owners = new ArrayList<Person>();
		owners.add(testPerson);
		testTicket.setOwners(owners);

		List<Person> watchers = new ArrayList<Person>();
		watchers.add(testPerson);
		testTicket.setWatchers(watchers);

		testTicket.setQueue(testQueue);
		testTicket.setProject(testProject);
		hibernate.insertTestData(testTicket);

	}

	@Override
	protected void tearDown() throws Exception {
		loader = null;
		testQueue.setManager(null);
		hibernate.updateTestData(testQueue);

		testTicket.getOwners().clear();
		testTicket.getWatchers().clear();
		hibernate.updateTestData(testTicket);
		hibernate.cleanUpDatabase(Ticket.class);

		hibernate.cleanUpDatabase(Queue.class);

		hibernate.cleanUpDatabase(Status.class);
		hibernate.cleanUpDatabase(Disposition.class);
		hibernate.cleanUpDatabase(Severity.class);
		hibernate.cleanUpDatabase(Project.class);
		hibernate.cleanUpDatabase(Person.class);
		super.tearDown();
	}

}
