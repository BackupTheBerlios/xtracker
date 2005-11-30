package com.jmonkey.xtracker.escalation;

import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.smtp.SMTPMailSender;

public class DueDatePendingTask extends TimerTask {
	private Logger	logger	= LogManager.getLogger(DueDatePendingTask.class);

	public DueDatePendingTask() {
		super();
		logger.debug("Creating: " + DueDatePendingTask.class.getName());
	}

	@Override
	public void run() {
		MailConfig mailConfig = new MailConfig();
		SMTPMailSender mailSender = new SMTPMailSender();
		mailSender.setHostName(mailConfig.getSmtpMailHost());
		mailSender.setUsername(mailConfig.getSmtpHostUsername());
		mailSender.setPassword(mailConfig.getSmtpHostPassword());

		TicketLoader ticketLoader = new TicketLoader();
		try {
			List<Ticket> ticketListDueInFiveDays = ticketLoader.loadTicketsWithDueDateDaysInFuture(5);
			mailSender.sendTicketDueDatePending(ticketListDueInFiveDays, 5);

			List<Ticket> ticketListDueInTwoDays = ticketLoader.loadTicketsWithDueDateDaysInFuture(2);
			mailSender.sendTicketDueDatePending(ticketListDueInTwoDays, 2);

			List<Ticket> ticketListDueToday = ticketLoader.loadTicketsWithDueDateToday();
			mailSender.sendTicketDueDateToday(ticketListDueToday);
		} catch (Exception e) {
			logger.error("Task failed", e);
		}
	}

}
