package com.jmonkey.xtracker.my.tickets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.my.tickets.TicketSorter;

public class TestTicketSorter extends TestCase {
	private List<Ticket>	testTickets	= null;
	private TicketSorter	sorter		= null;

	public void testTicketListNullOnNewInstance() {
		assertNull(sorter.getTickets());
		sorter.setTickets(new ArrayList<Ticket>());
		assertNotNull(sorter.getTickets());
		assertEquals(0, sorter.getTickets().size());
	}

	public void testSortTicketsByProject() {
		sorter.setTickets(testTickets);
		Map<Project, List<Ticket>> byProject = sorter.getTicketsWithProject();
		assertNotNull(byProject);
		assertEquals(2, byProject.size());
		Iterator<Project> projectIter = byProject.keySet().iterator();
		while (projectIter.hasNext()) {
			Project p = projectIter.next();
			assertNotNull(p.getName());
			assertTrue(p.getName().equals("p1") || p.getName().equals("p2"));
		}
	}

	public void testListTicketsWithNoProject() {
		sorter.setTickets(testTickets);
		List<Ticket> list = sorter.getTicketsWithoutProject();
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals("test4", list.get(0).getSubject());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		sorter = new TicketSorter();
		testTickets = new ArrayList<Ticket>();
		setupTestTickets();
	}

	private void setupTestTickets() {
		Project project1 = new Project();
		project1.setName("p1");
		Project project2 = new Project();
		project2.setName("p2");

		Ticket ticket1 = new Ticket();
		ticket1.setSubject("test1");
		ticket1.setProject(project1);
		testTickets.add(ticket1);

		Ticket ticket2 = new Ticket();
		ticket2.setSubject("test2");
		ticket2.setProject(project2);
		testTickets.add(ticket2);

		Ticket ticket3 = new Ticket();
		ticket3.setSubject("test3");
		ticket3.setProject(project2);
		testTickets.add(ticket3);

		Ticket ticket4 = new Ticket();
		ticket4.setSubject("test4");
		testTickets.add(ticket4);
	}

	@Override
	protected void tearDown() throws Exception {
		sorter = null;
		testTickets = null;
		super.tearDown();
	}

}
