package com.jmonkey.xtracker.test.fake.issue;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;

public class FakeTicketPersistor extends TicketPersistor {
	private Long	newTestId		= null;
	private Ticket	savedTicket		= null;
	private Ticket	updatedTicket	= null;

	public FakeTicketPersistor() {
		return;
	}

	/**
	 * @see com.jmonkey.xtracker.issue.persistor.TicketPersistor#saveTicket(com.jmonkey.xtracker.issue.Ticket)
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public void saveTicket(Ticket ticket) throws HibernateException {
		savedTicket = ticket;
		savedTicket.setId(newTestId);
	}

	/**
	 * @see com.jmonkey.xtracker.issue.persistor.TicketPersistor#updateTicket(com.jmonkey.xtracker.issue.Ticket)
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public void updateTicket(Ticket ticket) throws HibernateException {
		updatedTicket = ticket;
	}

	public Ticket getSavedTicket() {
		return savedTicket;
	}

	public Ticket getUpdatedTicket() {
		return updatedTicket;
	}

	public void setNewTestId(Long newTestId) {
		this.newTestId = newTestId;
	}

	@SuppressWarnings("unusedThrown")
	@Override
	protected void checkClose() throws HibernateException {
		return;
	}

	@SuppressWarnings("unusedThrown")
	@Override
	protected void checkOpen() throws HibernateException {
		return;
	}

	@SuppressWarnings("unusedThrown")
	@Override
	public void close() throws HibernateException {
		return;
	}

	@SuppressWarnings("unusedThrown")
	@Override
	public void open() throws HibernateException {
		return;
	}

}
