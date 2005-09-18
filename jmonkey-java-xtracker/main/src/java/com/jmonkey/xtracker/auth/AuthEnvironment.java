package com.jmonkey.xtracker.auth;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import com.jmonkey.xtracker.auth.realm.UserPrincipal;

public class AuthEnvironment {
	private HttpServletRequest	request	= null;

	public AuthEnvironment(HttpServletRequest request) {
		super();
		this.request = request;
	}

	public Principal getPrincipal() {
		Principal principal = (UserPrincipal) request.getSession().getAttribute(UserPrincipal.class.getName());
		if (principal == null) {
			principal = request.getUserPrincipal();
		}
		return principal;
	}

	public void setPrincipal(Principal principal) {
		request.getSession().setAttribute(UserPrincipal.class.getName(), principal);
	}

	public boolean isUserInRole(String string) {
		boolean result = false;
		Principal requestPrincipal = request.getUserPrincipal();
		UserPrincipal sessionPrincipal = (UserPrincipal) request.getSession().getAttribute(UserPrincipal.class.getName());
		if (sessionPrincipal != null) {
			result = sessionPrincipal.isUserInRole(string);
		} else if (requestPrincipal != null) {
			result = request.isUserInRole(string);
		}
		return result;
	}

	public String getRequestLocation() {
		// XXX This is going to produce an absolute URL,
		// it might be better to use a forward factory and
		// forward to the actual action, appending the query string.
		return request.getRequestURL() + "?" + request.getQueryString();
	}

	public boolean removePrincipal() {
		// XXX This needs some thinking...
		// it's a bit smelly at the moment.
		boolean result = false;
		Principal requestPrincipal = request.getUserPrincipal();
		UserPrincipal sessionPrincipal = (UserPrincipal) request.getSession().getAttribute(UserPrincipal.class.getName());
		if (sessionPrincipal != null) {
			request.getSession().removeAttribute(UserPrincipal.class.getName());
			result = true;
		}
		if (requestPrincipal != null && result) {
			result = false;
		}
		return result;
	}
}
