package com.jmonkey.xtracker.my.tickets;

import org.apache.struts.action.ActionForm;

public class TicketMessageForm extends ActionForm {
	private Long	id			= null;
	private String	historyId	= null;
	private Integer	importance	= null;
	private String	subject		= null;
	private String	content		= null;

	public TicketMessageForm() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHistoryId() {
		return historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getImportance() {
		return importance;
	}

	public void setImportance(Integer importance) {
		this.importance = importance;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
