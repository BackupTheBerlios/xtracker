package com.jmonkey.xtracker.ajax;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.util.MessageResources;

public class RequestAccessor {
	private static final String	ORG_APACHE_STRUTS_ACTION_MESSAGE	= "org.apache.struts.action.MESSAGE";
	private HttpServletRequest	request								= null;

	public RequestAccessor(HttpServletRequest request) {
		super();
		this.request = request;
	}

	public MessageResources getStrutsMessageResource() {
		return ((MessageResources) request.getSession().getServletContext().getAttribute(ORG_APACHE_STRUTS_ACTION_MESSAGE));
	}

}
