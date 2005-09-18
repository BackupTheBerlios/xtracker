package com.jmonkey.xtracker.auth.realm;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public final class UserPrincipal implements Principal, Serializable {
	private String				name	= null;
	private List<RolePrincipal>	roles	= new ArrayList<RolePrincipal>();

	public UserPrincipal(String name) {
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
		if (!(o instanceof UserPrincipal)) {
			return false;
		}
		return name.equals(((UserPrincipal) o).name);
	}

	@Override
	public String toString() {
		return name;
	}

	public boolean isUserInRole(String string) {
		boolean result = false;
		ListIterator<RolePrincipal> roleIterator = roles.listIterator();
		while (roleIterator.hasNext()) {
			RolePrincipal role = roleIterator.next();
			result = role.getName().equals(string);
			if (result) {
				break;
			}
		}
		return result;
	}

	public List<RolePrincipal> getRoles() {
		return roles;
	}

	public void setRoles(List<RolePrincipal> roles) {
		this.roles = roles;
	}
	
}
