package com.jmonkey.xtracker.system;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.local.MailInputStreamService;

public class SystemServlet extends HttpServlet {
	private MailInputStreamService	mailInputStreamService	= null;

	public SystemServlet() {
		super();
	}

	/**
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		if (mailInputStreamService != null) {
			mailInputStreamService.setRunning(false);
			mailInputStreamService.interrupt();
		}

		// XXX This may not actually be needed,
		// / it's here so that the webapp can be stopped
		// and allow hibernate to release its resources.
		// This was prompted by the PermGen out of memory
		// error that Java 1.5 is prone to throw while using
		// hibernate and I'm not sure it will work.
		HibernateSessionFactory.resetSessionFactory();
		super.destroy();
	}

	/**
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		MailConfig mailConfig = new MailConfig();
		if (mailConfig.isMailInputStreamServiceEnabled()) {
			mailInputStreamService = new MailInputStreamService();
			mailInputStreamService.start();
		}
	}

}
