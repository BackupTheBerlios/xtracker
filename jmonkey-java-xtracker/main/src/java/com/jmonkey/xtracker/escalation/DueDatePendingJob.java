package com.jmonkey.xtracker.escalation;

import java.util.List;

import net.sf.hibernate.HibernateException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.smtp.SMTPMailSender;

public class DueDatePendingJob implements Job {

	public DueDatePendingJob() {
		super();
	}

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
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
		} catch (HibernateException e) {
			throw new JobExecutionException(e);
		} catch (Exception e) {
			throw new JobExecutionException(e);
		}
	}
}
