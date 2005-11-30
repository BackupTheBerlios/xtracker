package com.jmonkey.xtracker.escalation;

import java.util.List;
import java.util.TimerTask;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.PreferencesConfig;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;

public class MaxTimeEscalateTask extends TimerTask {
	private Logger	logger	= LogManager.getLogger(MaxTimeEscalateTask.class);

	public MaxTimeEscalateTask() {
		super();
		logger.debug("Creating: " + this.getClass().getName());
	}

	@Override
	public void run() {
		PreferencesConfig preferencesConfig = new PreferencesConfig();
		if (preferencesConfig.isMaxModifyAgeEnabled()) {
			int modifiedDaysAgo = preferencesConfig.getMaxModifiedAgeDays();
			int incrementBy = preferencesConfig.getMaxModifiedIncrement();

			TicketPersistor ticketPersistor = new TicketPersistor();
			TicketLoader ticketLoader = new TicketLoader();
			try {
				List<Ticket> ticketList = ticketLoader.loadTicketsForModifiedDateEscalation(modifiedDaysAgo);
				for (Ticket ticket : ticketList) {
					Integer priority = ticket.getPriority();
					long oldPriority = priority.longValue();
					long newPriority = oldPriority + incrementBy;
					if (newPriority > 99) {
						newPriority = 99;
					}

					ticket.setPriority(new Integer((int) newPriority));
					ticketPersistor.updateTicket(ticket);
				}
			} catch (HibernateException e) {
				logger.debug("Task failed", e);
			}
		}
	}

}
