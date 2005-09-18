package com.jmonkey.xtracker;

import java.util.Date;

import net.sf.hibernate.HibernateException;

import org.apache.struts.action.Action;

import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.StatusLoader;
import com.jmonkey.xtracker.util.TicketUtil;

public class BaseAction extends Action {

	public BaseAction() {
		super();
	}

	protected void addHistoryToTicket(Ticket ticket, Date created, String subject, String message, Integer importance) {
		History history = new History();
		history.setSystem(true);
		history.setCreateDate(created);
		history.setImportance(importance);
		history.setSubject(subject);
		history.setContent(message);
		ticket.getHistory().add(history);
	}

	protected void forceClosedTicketOpen(Ticket ticket) throws HibernateException {
		if (TicketUtil.isTicketClosed(ticket)) {
			StatusLoader statusLoader = new StatusLoader();
			Status nextStatus = statusLoader.loadOpenStatus();
			ticket.setStatus(nextStatus);
		}
	}

}
