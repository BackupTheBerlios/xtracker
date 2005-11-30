package com.jmonkey.xtracker.scheduler;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.escalation.DueDatePendingTask;
import com.jmonkey.xtracker.escalation.EscalateTask;
import com.jmonkey.xtracker.escalation.MaxTimeEscalateTask;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.pop.PopReaderTask;

public class SchedulerServlet extends GenericServlet {
	private Logger				logger		= LogManager.getLogger(SchedulerServlet.class);

	private final Timer			scheduler	= new Timer("Task Scheduler", true);
	private MailConfig			mailConfig	= new MailConfig();
	private PopReaderTask		popReaderTask;
	private EscalateTask		escalateTask;
	private DueDatePendingTask	dueDatePendingTask;
	private MaxTimeEscalateTask	maxTimeEscalateTask;

	public SchedulerServlet() {
		super();
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.getWriter().write("PopReaderTask scheduled to execute at: " + new Date(popReaderTask.scheduledExecutionTime()).toString());
		response.getWriter().write("EscalateTask scheduled to execute at: " + new Date(escalateTask.scheduledExecutionTime()).toString());
		response.getWriter().write("DueDatePendingTask scheduled to execute at: " + new Date(dueDatePendingTask.scheduledExecutionTime()).toString());
		response.getWriter().write("MaxTimeEscalateTask scheduled to execute at: " + new Date(maxTimeEscalateTask.scheduledExecutionTime()).toString());
	}

	/**
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		logger.debug("Stopping task timer...");
		scheduler.cancel();
		logger.debug("Timer stopped...");
	}

	/**
	 * @see javax.servlet.GenericServlet#init()
	 */
	@SuppressWarnings("unused")
	@Override
	public void init() throws ServletException {
		logger.debug("Starting tasks...");
		schedulePOPReaderJob();
		scheduleEscalateJob();
		scheduleDueDatePendingJob();
		scheduleMaxTimeEscalate();
		logger.debug("Tasks started...");
	}

	private void scheduleMaxTimeEscalate() {
		maxTimeEscalateTask = new MaxTimeEscalateTask();
		logger.debug("Scheduling max time escalate task...");
		scheduler.schedule(maxTimeEscalateTask, 60000, 3600000L); // every 1
	}

	private void scheduleDueDatePendingJob() {
		dueDatePendingTask = new DueDatePendingTask();
		logger.debug("Scheduling due date pending task...");
		scheduler.schedule(dueDatePendingTask, 60000, 86400000L); // every day
	}

	private void scheduleEscalateJob() {
		escalateTask = new EscalateTask();
		logger.debug("Scheduling escalate task...");
		scheduler.schedule(escalateTask, 60000, 3600000L); // every 1 hours
	}

	private void schedulePOPReaderJob() {
		int minutes = mailConfig.getPopCheckIntervalMinutes();
		popReaderTask = new PopReaderTask();
		logger.debug("Scheduling POP3 reader task...");
		scheduler.schedule(popReaderTask, 30000, (minutes + 1000)); // every
		// minute
	}

}
