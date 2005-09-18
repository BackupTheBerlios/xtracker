/*
 * Copyright 2005 Brill Pappin
 */
package com.jmonkey.xtracker.config;

/**
 * @author brill
 * @version $Revision: 1.1 $
 */
public class ConfigException extends Exception {

	public ConfigException() {
		super();
	}

	public ConfigException(String message) {
		super(message);
	}

	public ConfigException(Throwable cause) {
		super(cause);
	}

	public ConfigException(String message, Throwable cause) {
		super(message, cause);
	}

}
