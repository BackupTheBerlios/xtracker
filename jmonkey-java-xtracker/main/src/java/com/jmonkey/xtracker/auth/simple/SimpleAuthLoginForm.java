package com.jmonkey.xtracker.auth.simple;

import org.apache.struts.action.ActionForm;

public class SimpleAuthLoginForm extends ActionForm {
	private String	redirectTo	= null;
	private String	username	= null;
	private String	password	= null;

	public SimpleAuthLoginForm() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRedirectTo() {
		return redirectTo;
	}

	public void setRedirectTo(String redirectTo) {
		this.redirectTo = redirectTo;
	}

}
