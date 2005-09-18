package com.jmonkey.xtracker.issue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.wiki.BasicWikiRenderer;

public class History implements Serializable {
	private String				id;
	private Integer				importance		= new Integer(5);
	private String				encoding		= "UTF-8";
	private String				subject;
	private String				content;
	private Date				createDate		= new Date();
	private Person				author			= null;
	private boolean				system			= false;
	private String				messageId			= null;
	private List<MailReference>	messageReferences	= new ArrayList<MailReference>();

	public History() {
		super();
	}

	public History(Integer importance, String encoding, String subject, String content, Date createDate) {
		this.importance = importance;
		this.encoding = encoding;
		this.subject = subject;
		this.content = content;
		this.createDate = createDate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getImportance() {
		return this.importance;
	}

	public void setImportance(Integer importance) {
		this.importance = importance;
	}

	public String getEncoding() {
		return this.encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRenderedContent() {
		BasicWikiRenderer renderer = new BasicWikiRenderer();
		return renderer.renderXTracker(content);
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	public boolean isSystem() {
		return system;
	}

	public void setSystem(boolean system) {
		this.system = system;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String mailId) {
		this.messageId = mailId;
	}

	public List<MailReference> getMessageReferences() {
		return messageReferences;
	}

	public void setMessageReferences(List<MailReference> mailReferences) {
		this.messageReferences = mailReferences;
	}

}
