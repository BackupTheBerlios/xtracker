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
				Calendar dueDate = getDueDateCalendar(ticket);
				Integer priority = ticket.getPriority();

				DueDateEscalationCalculator calculator = new DueDateEscalationCalculator();
				calculator.setMaxValue(100);
				calculator.setStartDate(Calendar.getInstance());
				calculator.setEndDate(dueDate);
				calculator.setValue(priority);
				Integer newPriority = calculator.calculate();

				ticket.setPriority(newPriority);
				ticketPersistor.updateTicket(ticket);
			}
		} catch (HibernateException e) {
			logger.error("Escalation failed", e);
		}
	}

	private Calendar getDueDateCalendar(Ticket ticket) {
		Calendar dueDate = Calendar.getInstance();
		dueDate.setTimeInMillis(0);
		dueDate.setTime(ticket.getDueDate());
		return dueDate;
	}

}
