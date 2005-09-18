package com.jmonkey.xtracker.auth.realm;

import java.io.Serializable;
import java.security.Principal;

public final class RolePrincipal implements Principal, Serializable {
	public static final String	ROLE_ANONYMUS		= "anonymous";
	public static final String	ROLE_MEMBER			= "member";
	public static final String	ROLE_ADMINISTRATOR	= "administrator";

	private String				name				= null;

	public RolePrincipal(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof RolePrincipal)) {
			return false;
		}
		return name.equals(((RolePrincipal) o).name);
	}

	@Override
	public String toString() {
		return name;
	}

}
