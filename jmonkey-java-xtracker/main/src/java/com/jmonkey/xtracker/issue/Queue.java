package com.jmonkey.xtracker.issue;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.jmonkey.xtracker.profile.Person;

public class Queue implements Serializable {
	private String	id;
	private String	name;
	private boolean	active		= true;
	private boolean	selectable	= true;
	private Date	createDate	= new Date();
	private Person	manager;
	private String	emailAlias	= null;

	public Queue() {
		super();
	}

	public Queue(String name, Boolean active, Date createDate, Person manager) {
		this.name = name;
		this.active = active;
		this.createDate = createDate;
		this.manager = manager;
	}

	public Queue(String name, Boolean active, Date createDate) {
		this.name = name;
		this.active = active;
		this.createDate = createDate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Person getManager() {
		return this.manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	// public List getProjects() {
	// return this.projects;
	// }
	//
	// public void setProjects(List projects) {
	// this.projects = projects;
	// }

	public String getEmailAlias() {
		return emailAlias;
	}

	public void setEmailAlias(String emailAlias) {
		this.emailAlias = emailAlias;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
