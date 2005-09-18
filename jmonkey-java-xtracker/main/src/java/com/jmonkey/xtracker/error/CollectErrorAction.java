package com.jmonkey.xtracker.error;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class CollectErrorAction extends BaseAction {
	private Logger			logger					= LogManager.getLogger(CollectErrorAction.class);
	private static String[]	requestAttributeKeys	= { "javax.servlet.error.status_code", "javax.servlet.error.exception_type", "javax.servlet.error.request_uri", "javax.servlet.error.message", "javax.servlet.error.exception" };

	public CollectErrorAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Report Error called...");
		ReportErrorForm reportErrorForm = (ReportErrorForm) form;

		String command = reportErrorForm.getCommand();
		if (command == null || command.length() == 0) {
			
			// XXX This should be from config.
			reportErrorForm.setReportTo("xtracker@pappin.ca");

			AuthEnvironment authEnvironment = new AuthEnvironment(request);
			Principal principal = authEnvironment.getPrincipal();
			if (principal != null) {
				try {
					PersonLoader personLoader = new PersonLoader();
					Person reporter = personLoader.loadPersonForPrincipal(principal);
					reportErrorForm.setReportFrom(reporter.getEmailAddress());
				} catch (Throwable t) {
					logger.error("can't load logged in user...");
				}
			}

			if (reportErrorForm.getReportFrom() == null) {
				reportErrorForm.setReportFrom("{Your Email Address Here]");
			}

			reportErrorForm.setReturnTo("mytickets");

			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < requestAttributeKeys.length; i++) {
				buffer.append(requestAttributeKeys[i]);
				buffer.append("=");
				Object o = request.getAttribute(requestAttributeKeys[i]);
				if (o != null && o instanceof Throwable) {
					Throwable t = (Throwable) request.getAttribute(requestAttributeKeys[i]);
					concatStackTrace(buffer, t);

					Throwable cause = t.getCause();
					while (cause != null) {
						buffer.append("\n");
						concatStackTrace(buffer, cause);
						cause = cause.getCause();
					}
				} else {
					buffer.append(o);
				}
				buffer.append("\n");
			}

			reportErrorForm.setReportContent(buffer.toString());

		}

		request.getSession().setAttribute("reportErrorForm", reportErrorForm);

		return mapping.getInputForward();
	}

	private void concatStackTrace(StringBuffer buffer, Throwable t) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		t.printStackTrace(printWriter);
		String stackTrace = stringWriter.toString();
		buffer.append(stackTrace);
	}
}
