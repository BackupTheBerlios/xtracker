package com.jmonkey.xtracker.linking.xplanner;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class XPlannerLinkForm extends ActionForm {
	private Long				ticketId			= null;
	private String				subject				= null;
	private String				content				= null;
	private List<ViewElement>	iterationList		= new ArrayList<ViewElement>();
	private Long				iterationOid		= null;
	private String				xplannerDisposition	= null;

	public XPlannerLinkForm() {
		super();
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getIterationOid() {
		return iterationOid;
	}

	public void setIterationOid(Long iterationOid) {
		this.iterationOid = iterationOid;
	}

	public List<ViewElement> getIterationList() {
		return iterationList;
	}

	public void setIterationList(List<ViewElement> elements) {
		this.iterationList = elements;
	}

	public String getXplannerDisposition() {
		return xplannerDisposition;
	}

	public void setXplannerDisposition(String plannerDisposition) {
		xplannerDisposition = plannerDisposition;
	}

}
