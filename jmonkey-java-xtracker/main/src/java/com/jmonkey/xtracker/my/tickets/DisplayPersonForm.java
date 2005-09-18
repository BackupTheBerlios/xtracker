package com.jmonkey.xtracker.my.tickets;

import org.apache.struts.action.ActionForm;

import com.jmonkey.xtracker.profile.Person;

public class DisplayPersonForm extends ActionForm {
	private String	id		= null;
	private Person	person	= null;

	public DisplayPersonForm() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
