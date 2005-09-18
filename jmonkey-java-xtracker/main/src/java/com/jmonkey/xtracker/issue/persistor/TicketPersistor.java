package com.jmonkey.xtracker.issue.persistor;

import java.util.Date;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.StatusLoader;

public class TicketPersistor extends PersistanceManager {

	public TicketPersistor() {
		super();
	}

	public void saveTicket(Ticket ticket) throws HibernateException {
		Transaction transaction = null;
		try {
			ticket.setModifyDate(new Date());
			checkOpen();

			transaction = session.beginTransaction();
			session.save(ticket);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			throw e;
		} finally {
			checkClose();
		}
	}

	public void updateTicket(Ticket ticket) throws HibernateException {
		Status status = ticket.getStatus();
		if ((status != null) && (status.getId() == 1) && (ticket.getOwners().size() > 0)) {
			StatusLoader statusLoader = new StatusLoader();
			Status newStatus = statusLoader.loadOpenStatus();
			ticket.setStatus(newStatus);
		}
		if (status != null) {
			long statusPriority = status.getId();
			if (statusPriority == 3 || statusPriority == 4 || statusPriority == 6) {
				ticket.setClosedDate(new Date());
			}
		}

		ticket.setModifyDate(new Date());

		Transaction transaction = null;
		try {
			checkOpen();
			transaction = session.beginTransaction();
			session.update(ticket);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			throw e;
		} finally {
			checkClose();
		}
	}
}
