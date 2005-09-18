/*
 * Copyright 2004 Brill Pappin
 */
package com.jmonkey.xtracker.test.fake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author brill
 * @version $Revision: 1.1 $
 */
public class FakeHttpServletRequest implements HttpServletRequest {
	private FakeHttpSession	session		= null;
	private final Hashtable<String, Object>	parameters	= new Hashtable<String, Object>();
	private Principal		principal	= null;
	private boolean			userInRole	= false;

	public FakeHttpServletRequest() {
		super();
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getAuthType()
	 */
	public String getAuthType() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getCookies()
	 */
	public Cookie[] getCookies() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getDateHeader(java.lang.String)
	 */
	public long getDateHeader(String arg0) {
		return 0;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getHeader(java.lang.String)
	 */
	public String getHeader(String arg0) {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getHeaders(java.lang.String)
	 */
	public Enumeration getHeaders(String arg0) {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getHeaderNames()
	 */
	public Enumeration getHeaderNames() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getIntHeader(java.lang.String)
	 */
	public int getIntHeader(String arg0) {
		return 0;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getMethod()
	 */
	public String getMethod() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getPathInfo()
	 */
	public String getPathInfo() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getPathTranslated()
	 */
	public String getPathTranslated() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getContextPath()
	 */
	public String getContextPath() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getQueryString()
	 */
	public String getQueryString() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getRemoteUser()
	 */
	public String getRemoteUser() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#isUserInRole(java.lang.String)
	 */
	public boolean isUserInRole(String arg0) {
		return userInRole;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getUserPrincipal()
	 */
	public Principal getUserPrincipal() {
		return principal;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getRequestedSessionId()
	 */
	public String getRequestedSessionId() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getRequestURI()
	 */
	public String getRequestURI() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getRequestURL()
	 */
	public StringBuffer getRequestURL() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getServletPath()
	 */
	public String getServletPath() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getSession(boolean)
	 */
	public HttpSession getSession(boolean create) {
		if (create && session == null) {
			session = new FakeHttpSession();
		}
		return session;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getSession()
	 */
	public HttpSession getSession() {
		return getSession(true);
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdValid()
	 */
	public boolean isRequestedSessionIdValid() {
		return false;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromCookie()
	 */
	public boolean isRequestedSessionIdFromCookie() {
		return false;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromURL()
	 */
	public boolean isRequestedSessionIdFromURL() {
		return false;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromUrl()
	 */
	public boolean isRequestedSessionIdFromUrl() {
		return false;
	}

	/**
	 * @see javax.servlet.ServletRequest#getAttribute(java.lang.String)
	 */
	public Object getAttribute(String arg0) {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getAttributeNames()
	 */
	public Enumeration getAttributeNames() {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getCharacterEncoding()
	 */
	public String getCharacterEncoding() {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#setCharacterEncoding(java.lang.String)
	 */
	@SuppressWarnings("unusedThrown")
	public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
	}

	/**
	 * @see javax.servlet.ServletRequest#getContentLength()
	 */
	public int getContentLength() {
		return 0;
	}

	/**
	 * @see javax.servlet.ServletRequest#getContentType()
	 */
	public String getContentType() {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getInputStream()
	 */
	public ServletInputStream getInputStream() throws IOException {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getParameter(java.lang.String)
	 */
	public String getParameter(String arg0) {
		return (String) parameters.get(arg0);
	}

	/**
	 * @see javax.servlet.ServletRequest#getParameterNames()
	 */
	public Enumeration getParameterNames() {
		return parameters.keys();
	}

	/**
	 * @see javax.servlet.ServletRequest#getParameterValues(java.lang.String)
	 */
	public String[] getParameterValues(String arg0) {
		Object value = parameters.get(arg0);
		if (value instanceof String[]) {
			return (String[]) value;
		}
		String[] strArr = { value.toString() };
		return strArr;
	}

	/**
	 * @see javax.servlet.ServletRequest#getParameterMap()
	 */
	public Map getParameterMap() {
		return parameters;
	}

	/**
	 * @see javax.servlet.ServletRequest#getProtocol()
	 */
	public String getProtocol() {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getScheme()
	 */
	public String getScheme() {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getServerName()
	 */
	public String getServerName() {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getServerPort()
	 */
	public int getServerPort() {
		return 0;
	}

	/**
	 * @see javax.servlet.ServletRequest#getReader()
	 */
	@SuppressWarnings("unusedThrown")
	public BufferedReader getReader() throws IOException {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getRemoteAddr()
	 */
	public String getRemoteAddr() {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getRemoteHost()
	 */
	public String getRemoteHost() {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#setAttribute(java.lang.String,
	 *      java.lang.Object)
	 */
	public void setAttribute(String arg0, Object arg1) {
	}

	/**
	 * @see javax.servlet.ServletRequest#removeAttribute(java.lang.String)
	 */
	public void removeAttribute(String arg0) {
	}

	/**
	 * @see javax.servlet.ServletRequest#getLocale()
	 */
	public Locale getLocale() {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getLocales()
	 */
	public Enumeration getLocales() {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#isSecure()
	 */
	public boolean isSecure() {
		return false;
	}

	/**
	 * @see javax.servlet.ServletRequest#getRequestDispatcher(java.lang.String)
	 */
	public RequestDispatcher getRequestDispatcher(String arg0) {
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getRealPath(java.lang.String)
	 */
	public String getRealPath(String arg0) {
		return null;
	}

	public void setupParameter(String key, String value) {
		if (parameters.containsKey(key)) {
			Object o = parameters.get(key);
			if (o instanceof String[]) {
				String[] existing = (String[]) o;
				String[] newArr = new String[existing.length + 1];
				for (int i = 0; i < existing.length; i++) {
					newArr[i] = existing[i];
				}
				newArr[newArr.length - 1] = value;
				parameters.put(key, newArr);
			} else {
				String oldValue = (String) o;
				String[] newVals = { oldValue, value };
				parameters.put(key, newVals);
			}
		} else {
			parameters.put(key, value);
		}
	}
	
	public void setupParameterRemove(String key) {
		parameters.remove(key);
	}

	public void setupParameters(Hashtable table) {
		parameters.putAll(table);
	}

	public void setupPrincipal(Principal principal) {
		this.principal = principal;
	}

	public void setupSession(FakeHttpSession session) {
		this.session = session;
	}

	public void setupUserInRole(boolean userInRole) {
		this.userInRole = userInRole;
	}

	public int getRemotePort() {
		return 0;
	}

	public String getLocalName() {
		return null;
	}

	public String getLocalAddr() {
		return null;
	}

	public int getLocalPort() {
		return 0;
	}

}
