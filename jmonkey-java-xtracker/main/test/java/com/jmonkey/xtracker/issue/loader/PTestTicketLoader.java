package com.jmonkey.xtracker.issue.loader;

import java.util.List;

import junit.framework.TestCase;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.issue.Ticket;

public class PTestTicketLoader extends TestCase {

	@SuppressWarnings("unchecked")
	// public void testWorkingOutTicketSelect() throws HibernateException {
	// Session session = HibernateSessionFactory.currentSession();
	// Transaction transaction = session.beginTransaction();
	//
	// // Criteria criteria = session.createCriteria(Ticket.class);
	// // criteria.createAlias("owners", "ownerPerson");
	// // // Expression.sql("owners.empty = true")
	// // criteria.add(Expression.and(Expression.eq("queue", queue),
	// Expression.sql("size(owners) = 0")));
	// // // criteria.setMaxResults(maxCount);
	// // List<Ticket> ticketList = criteria.list();
	//
	// // Query query = session.createQuery("from
	// // "+Ticket.class.getName()+" ticket where ticket.owners is empty
	// // and ticket.queue = :q");
	// // query.setParameter("q", queue);
	// // query.setMaxResults(maxCount);
	// // ticketList = query.list();
	//		
	// List<Ticket> ticketList = session.find("from Ticket t where t.queue.id =
	// \"402880e404f4691c0104f46a7b1e0009\" and size(t.owners) = 0");
	//
	// transaction.commit();
	// HibernateSessionFactory.closeSession();
	//		
	// assertNotNull(ticketList);
	// }
	public void testPrintTicketsWithDueDate() throws HibernateException {
		TicketLoader ticketLoader = new TicketLoader();
		List<Ticket> ticketList = ticketLoader.loadTicketsForDueDateEscalation();
		for (Ticket ticket : ticketList) {
			System.out.println(ticket.getSubject());
		}
	}
}
