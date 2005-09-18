package com.jmonkey.xtracker.config;

import org.apache.struts.action.ActionForm;

public class ConfigInitForm extends ActionForm {
	private String	path				= null;
	private boolean	configured			= true;
	
	private String	hibernateDialect	= null;
	private String	connectionUrl		= null;
	private String	connectionDriver	= null;
	private String	connectionUsername	= null;
	private String	connectionPassword	= null;

	public ConfigInitForm() {
		super();
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isConfigured() {
		return configured;
	}

	public void setConfigured(boolean configured) {
		this.configured = configured;
	}

	public String getConnectionDriver() {
		return connectionDriver;
	}

	public void setConnectionDriver(String connectionDriver) {
		this.connectionDriver = connectionDriver;
	}

	public String getConnectionPassword() {
		return connectionPassword;
	}

	public void setConnectionPassword(String connectionPassword) {
		this.connectionPassword = connectionPassword;
	}

	public String getConnectionUrl() {
		return connectionUrl;
	}

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public String getConnectionUsername() {
		return connectionUsername;
	}

	public void setConnectionUsername(String connectionUsername) {
		this.connectionUsername = connectionUsername;
	}

	public String getHibernateDialect() {
		return hibernateDialect;
	}

	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}
}
