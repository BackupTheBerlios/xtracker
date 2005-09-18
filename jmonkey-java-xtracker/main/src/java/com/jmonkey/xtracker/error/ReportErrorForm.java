package com.jmonkey.xtracker.error;

import org.apache.struts.action.ActionForm;

public class ReportErrorForm extends ActionForm {
	private String	reportTo		= null;
	private String	reportFrom		= null;
	private String	reportContent	= null;
	private String	returnTo		= null;
	private String	command			= null;

	public ReportErrorForm() {
		super();
	}

	public String getReportFrom() {
		return reportFrom;
	}

	public void setReportFrom(String reportFrom) {
		this.reportFrom = reportFrom;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public String getReportTo() {
		return reportTo;
	}

	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public String getReturnTo() {
		return returnTo;
	}

	public void setReturnTo(String returnTo) {
		this.returnTo = returnTo;
	}

}
