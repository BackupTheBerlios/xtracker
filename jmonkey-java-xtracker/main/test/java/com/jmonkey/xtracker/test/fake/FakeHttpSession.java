/*
 * Copyright 2004 Brill Pappin
 */
package com.jmonkey.xtracker.test.fake;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

/**
 * @author brill
 * @version $Revision: 1.1 $
 */
public class FakeHttpSession implements HttpSession {
	private final Hashtable attributes = new Hashtable();

	public FakeHttpSession() {
		super();
	}

	/**
	 * @see javax.servlet.http.HttpSession#getCreationTime()
	 */
	public long getCreationTime() {
		return 0;
	}

	/**
	 * @see javax.servlet.http.HttpSession#getId()
	 */
	public String getId() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpSession#getLastAccessedTime()
	 */
	public long getLastAccessedTime() {
		return 0;
	}

	/**
	 * @see javax.servlet.http.HttpSession#getServletContext()
	 */
	public ServletContext getServletContext() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpSession#setMaxInactiveInterval(int)
	 */
	public void setMaxInactiveInterval(int arg0) {
	}

	/**
	 * @see javax.servlet.http.HttpSession#getMaxInactiveInterval()
	 */
	public int getMaxInactiveInterval() {
		return 0;
	}

	/**
	 * @see javax.servlet.http.HttpSession#getSessionContext()
	 */
	public HttpSessionContext getSessionContext() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpSession#getAttribute(java.lang.String)
	 */
	public Object getAttribute(String key) {
		return attributes.get(key);
	}

	/**
	 * @see javax.servlet.http.HttpSession#getValue(java.lang.String)
	 */
	public Object getValue(String arg0) {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpSession#getAttributeNames()
	 */
	public Enumeration getAttributeNames() {
		return attributes.keys();
	}

	/**
	 * @see javax.servlet.http.HttpSession#getValueNames()
	 */
	public String[] getValueNames() {
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpSession#setAttribute(java.lang.String, java.lang.Object)
	 */
	public void setAttribute(String key, Object value) {
		attributes.put(key, value);
	}

	/**
	 * @see javax.servlet.http.HttpSession#putValue(java.lang.String, java.lang.Object)
	 */
	public void putValue(String arg0, Object arg1) {
	}

	/**
	 * @see javax.servlet.http.HttpSession#removeAttribute(java.lang.String)
	 */
	public void removeAttribute(String key) {
		attributes.remove(key);
	}

	/**
	 * @see javax.servlet.http.HttpSession#removeValue(java.lang.String)
	 */
	public void removeValue(String arg0) {
	}

	/**
	 * @see javax.servlet.http.HttpSession#invalidate()
	 */
	public void invalidate() {
	}

	/**
	 * @see javax.servlet.http.HttpSession#isNew()
	 */
	public boolean isNew() {
		return false;
	}

}
