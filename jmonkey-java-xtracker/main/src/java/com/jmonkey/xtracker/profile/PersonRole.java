package com.jmonkey.xtracker.profile;

public class PersonRole {
	private String	id			= null;
	private String	name		= null;
	private String	description	= null;

	public PersonRole() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
