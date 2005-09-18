package com.jmonkey.xtracker.issue;

import java.util.Date;

public class MailReference {
	private String	id			= null;
	private String	messageId	= null;
	private Date	messageDate	= null;

	public MailReference() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String mailId) {
		this.messageId = mailId;
	}

	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

}
