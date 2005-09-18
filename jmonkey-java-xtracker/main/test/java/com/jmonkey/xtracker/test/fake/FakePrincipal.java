package com.jmonkey.xtracker.test.fake;

import java.security.Principal;

public class FakePrincipal implements Principal {
	private String	name	= null;

	public FakePrincipal() {
		super();
	}

	public FakePrincipal(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
