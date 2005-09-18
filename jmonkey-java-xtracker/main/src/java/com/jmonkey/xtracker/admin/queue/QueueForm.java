package com.jmonkey.xtracker.admin.queue;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class QueueForm extends ActionForm {
	private List	queueList	= new ArrayList();
	private List	personList	= new ArrayList();
	private String	id			= null;
	private String	name		= null;
	private String	emailAlias	= null;
	private boolean	active		= false;
	private boolean	selectable	= false;
	private String	managerId	= null;

	public QueueForm() {
		super();
	}

	public List getQueueList() {
		return queueList;
	}

	public void setQueueList(List queueList) {
		this.queueList = queueList;
	}

	public List getPersonList() {
		return personList;
	}

	public void setPersonList(List queueList) {
		this.personList = queueList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
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

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAlias() {
		return emailAlias;
	}

	public void setEmailAlias(String emailAlias) {
		this.emailAlias = emailAlias;
	}

}
