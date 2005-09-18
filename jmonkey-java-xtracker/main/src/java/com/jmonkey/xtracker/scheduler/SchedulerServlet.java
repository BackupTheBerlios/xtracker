package com.jmonkey.xtracker.scheduler;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.lang.BooleanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.jmonkey.xtracker.escalation.DueDatePendingJob;
import com.jmonkey.xtracker.escalation.EscalateJob;
import com.jmonkey.xtracker.escalation.MaxTimeEscalateJob;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.pop.POPReaderJob;

public class SchedulerServlet extends GenericServlet {
	private Logger				logger				= LogManager.getLogger(SchedulerServlet.class);
	private SchedulerFactory	schedulerFactory	= null;
	private Scheduler			scheduler			= null;
	private MailConfig			mailConfig			= new MailConfig();

	public SchedulerServlet() {
		super();
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String pauseStr = request.getParameter("pause");
		if (pauseStr != null) {
			boolean pause = BooleanUtils.toBoolean(pauseStr);
			try {
				if (scheduler.isPaused() && !pause) {
					scheduler.resumeAll();
				} else if (!scheduler.isPaused() && pause) {
					scheduler.pauseAll();
				}
				response.getWriter().write("Scheduler Paused: " + scheduler.isPaused());
			} catch (SchedulerException e) {
				throw new ServletException(e);
			}
		} else {
			try {
				boolean running = (!scheduler.isPaused() && !scheduler.isShutdown());
				if (running) {
					response.getWriter().write("Scheduler Running...");
				} else {
					response.getWriter().write("Scheduler Stopped...");
				}
			} catch (SchedulerException e) {
				throw new ServletException(e);
			}
		}
	}

	/**
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void destroy() {
		Collection<Scheduler> schedulerCollection = null;
		try {
			schedulerCollection = schedulerFactory.getAllSchedulers();
		} catch (SchedulerException e) {
			logger.error("Could not get all schedulers...", e);
		}

		if (schedulerCollection != null) {
			for (Scheduler sched : schedulerCollection) {
				try {
					sched.shutdown();
				} catch (SchedulerException e) {
					try {
						logger.error("Could not shutdown scheduler: " + sched.getSchedulerName(), e);
					} catch (SchedulerException e1) {
						logger.error("Could not shutdown scheduler, and could not get its name... ", e);
					}
				}
			}
		}
	}

	/**
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		schedulerFactory = new StdSchedulerFactory();
		try {
			scheduler = schedulerFactory.getScheduler();
			scheduler.start();

			schedulePOPReaderJob();
			scheduleEscalateJob();
			scheduleDueDatePendingJob();
			scheduleMaxTimeEscalate();

		} catch (SchedulerException e) {
			throw new ServletException(e);
		} catch (ParseException e) {
			throw new ServletException("Cron expression is invalid [" + mailConfig.getPopCheckCronExpression() + "]", e);
		}
	}

	private void scheduleMaxTimeEscalate() throws ParseException, SchedulerException {
		JobDetail maxTimeEscalateJobDetail = new JobDetail("MaxTimeEscalateJob", Scheduler.DEFAULT_GROUP, MaxTimeEscalateJob.class);
		CronTrigger maxTimeEscalateTrigger = new CronTrigger("MaxTimeEscalateTrigger", Scheduler.DEFAULT_GROUP, "0 0 5 * * ?");
		scheduler.scheduleJob(maxTimeEscalateJobDetail, maxTimeEscalateTrigger);
	}

	private void scheduleDueDatePendingJob() throws ParseException, SchedulerException {
		JobDetail dueDatePendingJobDetail = new JobDetail("DueDatePendingJob", Scheduler.DEFAULT_GROUP, DueDatePendingJob.class);
		CronTrigger dueDatePendingTrigger = new CronTrigger("DueDatePendingTrigger", Scheduler.DEFAULT_GROUP, "0 30 4 * * ?");
		scheduler.scheduleJob(dueDatePendingJobDetail, dueDatePendingTrigger);
	}

	private void scheduleEscalateJob() throws ParseException, SchedulerException {
		JobDetail escalateJobDetail = new JobDetail("EscalateJob", Scheduler.DEFAULT_GROUP, EscalateJob.class);
		CronTrigger escalateTrigger = new CronTrigger("EscalateTrigger", Scheduler.DEFAULT_GROUP, "0 0 4 * * ?");
		scheduler.scheduleJob(escalateJobDetail, escalateTrigger);
	}

	private void schedulePOPReaderJob() throws ParseException, SchedulerException {
		JobDetail jobDetail = new JobDetail("POPReaderJob", Scheduler.DEFAULT_GROUP, POPReaderJob.class);
		CronTrigger trigger = new CronTrigger("POPReaderTrigger", Scheduler.DEFAULT_GROUP, mailConfig.getPopCheckCronExpression());
		scheduler.scheduleJob(jobDetail, trigger);
	}

}
