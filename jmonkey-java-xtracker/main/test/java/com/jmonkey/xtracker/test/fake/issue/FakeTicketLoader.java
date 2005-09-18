package com.jmonkey.xtracker.test.fake.issue;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.my.search.SearchCriteria;
import com.jmonkey.xtracker.profile.Person;

public class FakeTicketLoader extends TicketLoader {
	private Ticket			ticketToReturn		= null;

	private List<Ticket>	ticketListToReturn	= null;

	public FakeTicketLoader() {
		return;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.TicketLoader#loadTicket(java.lang.Long)
	 */
	@SuppressWarnings("unused")
	@Override
	public Ticket loadTicket(Long id) throws HibernateException {
		return ticketToReturn;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.TicketLoader#loadTicketListForPerson(com.jmonkey.xtracker.profile.Person)
	 */
	@SuppressWarnings("unused")
	@Override
	public List<Ticket> loadTicketListForPerson(Person person, boolean exclude) throws HibernateException {
		return ticketListToReturn;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.TicketLoader#loadTicketListForRequestor(com.jmonkey.xtracker.profile.Person)
	 */
	@SuppressWarnings("unused")
	@Override
	public List<Ticket> loadTicketListForRequestor(Person person, boolean exclude) throws HibernateException {
		return ticketListToReturn;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.TicketLoader#loadTicketsInProject(com.jmonkey.xtracker.issue.Project)
	 */
	@SuppressWarnings("unused")
	@Override
	public List<Ticket> loadTicketsInProject(Project project, boolean includeClosed) throws HibernateException {
		return ticketListToReturn;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.loader.TicketLoader#loadTicketsInQueue(com.jmonkey.xtracker.issue.Queue)
	 */
	@SuppressWarnings("unused")
	@Override
	public List<Ticket> loadTicketsInQueue(Queue queue, boolean includeClose) throws HibernateException {
		return ticketListToReturn;
	}

	public void setupTicketListToReturn(List<Ticket> ticketListToReturn) {
		this.ticketListToReturn = ticketListToReturn;
	}

	public void setupTicketToReturn(Ticket ticketToReturn) {
		this.ticketToReturn = ticketToReturn;
	}

	@SuppressWarnings("unused")
	@Override
	public List<Ticket> loadTicketsForDueDateEscalation() throws HibernateException {
		return this.ticketListToReturn;
	}

	@SuppressWarnings("unused")
	@Override
	public List<Ticket> loadTicketsWithDueDateDaysInFuture(int days) throws HibernateException {
		return this.ticketListToReturn;
	}

	@SuppressWarnings("unused")
	@Override
	public List<Ticket> loadTicketsWithDueDateToday() throws HibernateException {
		return this.ticketListToReturn;
	}

	@SuppressWarnings("unused")
	@Override
	public List<Ticket> loadUnassignedTicketListForPersonQueue(Person person, int maxCount) throws HibernateException {
		return this.ticketListToReturn;
	}

	@SuppressWarnings("unused")
	@Override
	public List<Ticket> loadWatchedTicketListForPerson(Person person, boolean includeClosed) throws HibernateException {
		return this.ticketListToReturn;
	}

	@SuppressWarnings("unused")
	@Override
	protected void checkClose() throws HibernateException {
		return;
	}

	@SuppressWarnings("unused")
	@Override
	protected void checkOpen() throws HibernateException {
		return;
	}

	@SuppressWarnings("unused")
	@Override
	public void close() throws HibernateException {
		return;
	}

	@SuppressWarnings("unused")
	@Override
	public void open() throws HibernateException {
		return;
	}

	@SuppressWarnings("unused")
	@Override
	public List<Ticket> loadTicketListPartialId(long id, int maxIn) throws HibernateException {
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public List<Ticket> loadTicketsForModifiedDateEscalation(int modifiedDaysAgo) throws HibernateException {
		return null;
	}

	@SuppressWarnings("unused")
	@Override
	public List<Ticket> searchForTickets(Map<String, SearchCriteria> criteriaMap) throws HibernateException, ParseException {
		return null;
	}

}
