package com.jmonkey.xtracker.escalation;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;

public class EscalateTask extends TimerTask {
	private Logger	logger	= LogManager.getLogger(EscalateTask.class);

	public EscalateTask() {
		super();
		logger.debug("Creating: " + getClass().getName());
	}

	@Override
	public void run() {
		TicketPersistor ticketPersistor = new TicketPersistor();
		TicketLoader ticketLoader = new TicketLoader();
		try {
			List<Ticket> ticketList = ticketLoader.loadTicketsForDueDateEscalation();
			for (Ticket ticket : ticketList) {
				Date dueDate = ticket.getDueDate();
				Integer priority = ticket.getPriority();

				long oldPriority = priority.longValue();

				Calendar today = Calendar.getInstance();
				long numDays = (dueDate.getTime() - today.getTime().getTime() + 43200000) / 86400000;
				long numPoints = 100 - oldPriority;

				if (numDays == 0) {
					numDays = 1;
				}
				long incrementBy = numPoints / numDays;
				long newPriority = oldPriority + incrementBy;
				if (newPriority > 99) {
					newPriority = 99;
				}
				ticket.setPriority(new Integer((int) newPriority));
				ticketPersistor.updateTicket(ticket);
			}
		} catch (HibernateException e) {
			logger.error("Escalation failed", e);
		}
	}

}