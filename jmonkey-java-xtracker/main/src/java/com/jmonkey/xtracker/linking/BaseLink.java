package com.jmonkey.xtracker.linking;

import java.util.Date;

import com.jmonkey.xtracker.profile.Person;

public class BaseLink {
	private String	id		= null;
	private Date	created	= new Date();
	private Date	updated	= new Date();
	private Person	creator	= null;

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Person getCreator() {
		return creator;
	}

	public void setCreator(Person creator) {
		this.creator = creator;
	}

}
