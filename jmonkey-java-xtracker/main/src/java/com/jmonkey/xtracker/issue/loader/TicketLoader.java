package com.jmonkey.xtracker.issue.loader;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.my.search.SearchCriteria;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.util.DateParser;

public class TicketLoader extends PersistanceManager {
	private Logger				logger		= LogManager.getLogger(TicketLoader.class);
	private static final Long[]	CLOSED_LIST	= { new Long(3), new Long(4), new Long(6) };

	public TicketLoader() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> loadTicketListForPerson(Person person, boolean includeClosed) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);
		criteria.createAlias("owners", "owner");
		criteria.add(Expression.eq("owner.id", person.getId()));
		if (!includeClosed) {
			criteria.createAlias("status", "status");
			criteria.add(Expression.not(Expression.in("status.id", CLOSED_LIST)));
		}
		criteria.addOrder(Order.desc("priority"));
		criteria.addOrder(Order.asc("createDate"));
		List<Ticket> ticketList = criteria.list();
		transaction.commit();
		checkClose();
		return ticketList;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> loadWatchedTicketListForPerson(Person person, boolean includeClosed) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);
		criteria.createAlias("watchers", "watcher");
		criteria.add(Expression.eq("watcher.id", person.getId()));
		if (!includeClosed) {
			criteria.createAlias("status", "status");
			criteria.add(Expression.not(Expression.in("status.id", CLOSED_LIST)));
		}
		criteria.addOrder(Order.desc("priority"));
		criteria.addOrder(Order.asc("createDate"));
		List<Ticket> ticketList = criteria.list();
		transaction.commit();
		checkClose();
		return ticketList;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> loadTicketListForRequestor(Person person, boolean includeClosed) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);

		criteria.add(Expression.eq("requestor.id", person.getId()));
		// criteria.createAlias("owners", "owner");
		// criteria.add(
		// Expression.and(
		// Expression.eq("requestor.id", person.getId()),
		// Expression.not(Expression.in("owner.id", new
		// Object[]{person.getId()}))
		// )
		// );

		if (!includeClosed) {
			criteria.createAlias("status", "status");
			criteria.add(Expression.not(Expression.in("status.id", CLOSED_LIST)));
		}
		criteria.addOrder(Order.desc("priority"));
		criteria.addOrder(Order.asc("createDate"));
		List<Ticket> ticketList = criteria.list();
		transaction.commit();
		checkClose();
		return ticketList;
	}

	public Ticket loadTicket(Long id) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Ticket ticket = (Ticket) session.load(Ticket.class, id);
		transaction.commit();
		checkClose();
		return ticket;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> loadTicketsInQueue(Queue queue, boolean includeClosed) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);
		criteria.add(Expression.eq("queue", queue));
		if (!includeClosed) {
			criteria.createAlias("status", "status");
			criteria.add(Expression.not(Expression.in("status.id", CLOSED_LIST)));
		}
		criteria.addOrder(Order.desc("priority"));
		criteria.addOrder(Order.asc("createDate"));
		List<Ticket> ticketList = criteria.list();
		transaction.commit();
		checkClose();
		if (ticketList == null) {
			ticketList = new ArrayList<Ticket>();
		}
		return ticketList;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> loadTicketsInProject(Project project, boolean includeClosed) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);
		criteria.add(Expression.eq("project", project));
		if (!includeClosed) {
			criteria.createAlias("status", "status");
			criteria.add(Expression.not(Expression.in("status.id", CLOSED_LIST)));
		}
		criteria.addOrder(Order.desc("priority"));
		criteria.addOrder(Order.asc("createDate"));
		List<Ticket> ticketList = criteria.list();
		transaction.commit();
		checkClose();
		if (ticketList == null) {
			ticketList = new ArrayList<Ticket>();
		}
		return ticketList;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> loadUnassignedTicketListForPersonQueue(Person person, int maxCount) throws HibernateException {
		Queue queue = person.getDefaultQueue();
		List<Ticket> ticketList = new ArrayList<Ticket>();
		if (queue != null) {
			checkOpen();
			Transaction transaction = session.beginTransaction();

			// XXX This was a bit of bastard to sort out, and may not work on
			// all dialets.
			Query query = session
					.createQuery("from Ticket t where t.queue.manager.id = :personid and size(t.owners) = 0 and t.status.id not in (3, 4, 6) ORDER BY t.priority DESC, t.createDate ASC");
			query.setParameter("personid", person.getId(), Hibernate.STRING);
			query.setMaxResults(maxCount);
			ticketList = query.list();

			transaction.commit();
			checkClose();
		}
		return ticketList;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> loadTicketsForDueDateEscalation() throws HibernateException {
		Calendar calendar = getTodaysCalendar();
		Date today = calendar.getTime();

		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);
		criteria.createAlias("status", "stat");
		criteria.add(Expression.and(Expression.and(Expression.isNotNull("dueDate"), Expression.gt("dueDate", today)), Expression.not(Expression.in("stat.id", CLOSED_LIST))));

		criteria.addOrder(Order.desc("priority"));
		criteria.addOrder(Order.asc("dueDate"));

		List<Ticket> ticketList = criteria.list();
		transaction.commit();
		checkClose();
		return ticketList;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> loadTicketsWithDueDateDaysInFuture(int days) throws HibernateException {
		Calendar calendar = getTodaysCalendar();
		calendar.add(Calendar.DAY_OF_MONTH, days);
		Date future = calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date futurePlusOneDay = calendar.getTime();

		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);
		criteria.createAlias("status", "stat");
		criteria.add(Expression.and(Expression.and(Expression.isNotNull("dueDate"), Expression.and(Expression.ge("dueDate", future), Expression.lt("dueDate", futurePlusOneDay))),
				Expression.not(Expression.in("stat.id", CLOSED_LIST))));

		criteria.addOrder(Order.desc("priority"));
		criteria.addOrder(Order.asc("dueDate"));

		List<Ticket> ticketList = criteria.list();
		transaction.commit();
		checkClose();
		return ticketList;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> loadTicketsWithDueDateToday() throws HibernateException {
		Calendar calendar = getTodaysCalendar();
		Date today = calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date tomorrow = calendar.getTime();

		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);
		criteria.createAlias("status", "stat");
		criteria.add(Expression.and(Expression.and(Expression.isNotNull("dueDate"), Expression.and(Expression.ge("dueDate", today), Expression.lt("dueDate", tomorrow))),
				Expression.not(Expression.in("stat.id", CLOSED_LIST))));

		criteria.addOrder(Order.desc("priority"));
		criteria.addOrder(Order.asc("dueDate"));

		List<Ticket> ticketList = criteria.list();
		transaction.commit();
		checkClose();
		return ticketList;
	}

	private Calendar getTodaysCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> loadTicketsForModifiedDateEscalation(int modifiedDaysAgo) throws HibernateException {
		Calendar calendar = getTodaysCalendar();
		calendar.add(Calendar.DAY_OF_MONTH, ((~modifiedDaysAgo) + 1));
		Date lastModified = calendar.getTime();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		Date nextDay = calendar.getTime();

		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);
		criteria.createAlias("status", "stat");
		criteria.add(Expression.and(Expression.and(Expression.isNotNull("modifyDate"), Expression.and(Expression.ge("modifyDate", lastModified), Expression.lt("modifyDate",
				nextDay))), Expression.not(Expression.in("stat.id", CLOSED_LIST))));

		criteria.addOrder(Order.desc("priority"));
		criteria.addOrder(Order.asc("modifyDate"));

		List<Ticket> ticketList = criteria.list();
		transaction.commit();
		checkClose();
		return ticketList;
	}

	public List<Ticket> searchForTickets(Map<String, SearchCriteria> criteriaMap) throws HibernateException, ParseException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);
		for (Iterator<String> iter = criteriaMap.keySet().iterator(); iter.hasNext();) {
			String key = iter.next();
			SearchCriteria sc = criteriaMap.get(key);
			logger.debug(key + ": " + sc.getPrintableString());
			if (SearchCriteria.WATCHER.equals(key)) {
				criteria.createAlias("watchers", "watcher");
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("watcher.id", sc.getValue()));
				} else {
					criteria.add(Expression.not(Expression.eq("watcher.id", sc.getValue())));
				}
			} else if (SearchCriteria.OWNER.equals(key)) {
				criteria.createAlias("owners", "owner");
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("owner.id", sc.getValue()));
				} else {
					criteria.add(Expression.not(Expression.eq("owner.id", sc.getValue())));
				}
			} else if (SearchCriteria.REQUESTOR.equals(key)) {
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("requestor.id", sc.getValue()));
				} else {
					criteria.add(Expression.not(Expression.eq("requestor.id", sc.getValue())));
				}
			} else if (SearchCriteria.DISPOSITION.equals(key) && valueIsNumeric(sc.getValue())) {
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("disposition.id", new Long(sc.getValue().toString())));
				} else {
					criteria.add(Expression.not(Expression.eq("disposition.id", new Long(sc.getValue().toString()))));
				}
			} else if (SearchCriteria.SEVERITY.equals(key) && valueIsNumeric(sc.getValue())) {
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("severity.id", new Long(sc.getValue().toString())));
				} else {
					criteria.add(Expression.not(Expression.eq("severity.id", new Long(sc.getValue().toString()))));
				}
			} else if (SearchCriteria.STATUS.equals(key) && valueIsNumeric(sc.getValue())) {
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("status.id", new Long(sc.getValue().toString())));
				} else {
					criteria.add(Expression.not(Expression.eq("status.id", new Long(sc.getValue().toString()))));
				}
			} else if (SearchCriteria.PROJECT.equals(key)) {
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("project.id", sc.getValue()));
				} else {
					criteria.add(Expression.not(Expression.eq("project.id", sc.getValue())));
				}
			} else if (SearchCriteria.QUEUE.equals(key)) {
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("queue.id", sc.getValue()));
				} else {
					criteria.add(Expression.not(Expression.eq("queue.id", sc.getValue())));
				}
			} else if (SearchCriteria.PRIORITY.equals(key)) {
				if (sc.getOperation().equals("is") && valueIsNumeric(sc.getValue())) {
					criteria.add(Expression.eq("priority", new Integer(sc.getValue().toString())));
				} else if (sc.getOperation().equals("gt")) {
					criteria.add(Expression.gt("priority", new Integer(sc.getValue().toString())));
				} else if (sc.getOperation().equals("lt")) {
					criteria.add(Expression.lt("priority", new Integer(sc.getValue().toString())));
				}
			} else if (SearchCriteria.SUBJECT.equals(key)) {
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("subject", sc.getValue()));
				} else if (sc.getOperation().equals("like")) {
					criteria.add(Expression.like("subject", "%" + sc.getValue() + "%"));
				}
			} else if (SearchCriteria.WORKED.equals(key) && valueIsNumeric(sc.getValue())) {
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("worked", new Double(sc.getValue().toString())));
				} else if (sc.getOperation().equals("gt")) {
					criteria.add(Expression.gt("worked", new Double(sc.getValue().toString())));
				} else if (sc.getOperation().equals("lt")) {
					criteria.add(Expression.lt("worked", new Double(sc.getValue().toString())));
				}
			} else if (SearchCriteria.CREATE_DATE.equals(key)) {
				DateParser dp = new DateParser();
				Date date = dp.parseStandardDate((String) sc.getValue());
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("createDate", date));
				} else if (sc.getOperation().equals("gt")) {
					criteria.add(Expression.gt("createDate", date));
				} else if (sc.getOperation().equals("lt")) {
					criteria.add(Expression.lt("createDate", date));
				}
			} else if (SearchCriteria.MODIFY_DATE.equals(key)) {
				DateParser dp = new DateParser();
				Date date = dp.parseStandardDate((String) sc.getValue());
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("modifyDate", date));
				} else if (sc.getOperation().equals("gt")) {
					criteria.add(Expression.gt("modifyDate", date));
				} else if (sc.getOperation().equals("lt")) {
					criteria.add(Expression.lt("modifyDate", date));
				}
			} else if (SearchCriteria.CLOSED_DATE.equals(key)) {
				DateParser dp = new DateParser();
				Date date = dp.parseStandardDate((String) sc.getValue());
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("closedDate", date));
				} else if (sc.getOperation().equals("gt")) {
					criteria.add(Expression.gt("closedDate", date));
				} else if (sc.getOperation().equals("lt")) {
					criteria.add(Expression.lt("closedDate", date));
				}
			} else if (SearchCriteria.DUE_DATE.equals(key)) {
				DateParser dp = new DateParser();
				Date date = dp.parseStandardDate((String) sc.getValue());
				if (sc.getOperation().equals("is")) {
					criteria.add(Expression.eq("dueDate", date));
				} else if (sc.getOperation().equals("gt")) {
					criteria.add(Expression.gt("dueDate", date));
				} else if (sc.getOperation().equals("lt")) {
					criteria.add(Expression.lt("dueDate", date));
				}
			}
		}
		criteria.addOrder(Order.desc("priority"));
		criteria.addOrder(Order.asc("dueDate"));

		logger.debug(criteria.toString());

		@SuppressWarnings("unchecked")
		List<Ticket> ticketList = criteria.list();

		transaction.commit();
		checkClose();
		return ticketList;
	}

	private boolean valueIsNumeric(Object value) {
		try {
			Double.parseDouble(value.toString());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Ticket> loadTicketListPartialId(long id, int inLength) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Ticket.class);
		List<Long> idList = new ArrayList<Long>();
		for (long i = id; idList.size() < inLength; i = i * 10) {
			idList.add(new Long(i));
		}
		criteria.add(Expression.in("id", idList));
		criteria.addOrder(Order.asc("id"));
		List<Ticket> ticketList = criteria.list();
		transaction.commit();
		checkClose();
		return ticketList;
	}
}
