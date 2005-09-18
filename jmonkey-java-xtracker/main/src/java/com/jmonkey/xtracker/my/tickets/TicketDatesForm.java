package com.jmonkey.xtracker.my.tickets;

import org.apache.struts.action.ActionForm;

public class TicketDatesForm extends ActionForm {
	private Long	id			= null;
	private String	createDate	= null;
	private String	modifyDate	= null;
	private String	closedDate	= null;
	private String	dueDate		= null;

	public TicketDatesForm() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

}
