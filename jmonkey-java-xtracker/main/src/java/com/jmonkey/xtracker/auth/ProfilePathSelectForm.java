package com.jmonkey.xtracker.auth;

import org.apache.struts.action.ActionForm;

public class ProfilePathSelectForm extends ActionForm {
	private Long	id	= null;

	public ProfilePathSelectForm() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
