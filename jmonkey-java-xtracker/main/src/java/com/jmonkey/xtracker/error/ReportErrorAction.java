package com.jmonkey.xtracker.error;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.mail.MailConfig;
import com.jmonkey.xtracker.mail.smtp.SMTPMailSender;

public class ReportErrorAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(ReportErrorAction.class);

	public ReportErrorAction() {
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
		
		// ActionMessages messages =
		// (ActionMessages)request.getAttribute(Globals.MESSAGE_KEY);

		Locale locale = (Locale) request.getSession().getAttribute(Globals.LOCALE_KEY);
		MessageResources messages = (MessageResources) request.getAttribute(Globals.MESSAGES_KEY);
		
		String expectedCommand = messages.getMessage(locale, "view.label.reporterror");
		String command = reportErrorForm.getCommand();
		
		if (command != null && expectedCommand.equals(command)) {
			MailConfig mailConfig = new MailConfig();
			SMTPMailSender mailSender = new SMTPMailSender();
			mailSender.setHostName(mailConfig.getSmtpMailHost());
			mailSender.setUsername(mailConfig.getSmtpHostUsername());
			mailSender.setPassword(mailConfig.getSmtpHostPassword());

			String to = reportErrorForm.getReportTo();
			String from = reportErrorForm.getReportFrom();
			String content = reportErrorForm.getReportContent();
			mailSender.sendErrorReport(to, from, content);
		}
		// System.out.println(reportErrorForm.getCommand());

		// request.getSession().setAttribute("reportErrorForm",
		// reportErrorForm);

		return mapping.findForward("mytickets");
	}
}
