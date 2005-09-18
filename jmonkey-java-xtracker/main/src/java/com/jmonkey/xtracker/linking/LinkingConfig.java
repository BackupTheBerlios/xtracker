package com.jmonkey.xtracker.linking;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.BooleanUtils;

import com.jmonkey.xtracker.config.ConfigException;
import com.jmonkey.xtracker.config.PropertiesConfig;

public class LinkingConfig extends PropertiesConfig {
	public static final String	CONFIG_NAME	= "linking";

	public LinkingConfig(boolean autoReload) {
		super(CONFIG_NAME, autoReload);
	}

	public LinkingConfig() {
		this(false);
	}

	public void writeNewConfigDefaults(File file) throws ConfigException {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			throw new ConfigException(e);
		}
	}

	public boolean isXplannerEnabled() {
		boolean value = getConfiguration().getBoolean("xplanner.enabled", false);
		return value;
	}

	public void setXplannerEnabled(boolean enabled) {
		getConfiguration().setProperty("xplanner.enabled", BooleanUtils.toStringTrueFalse(enabled));
	}

	public String getXplannerContext() {
		String value = getConfiguration().getString("xplanner.context", "http://localhost/xplanner");
		return value;
	}

	public void setXplannerContext(String uri) {
		getConfiguration().setProperty("xplanner.context", uri);
	}

	public boolean isJiraEnabled() {
		boolean value = getConfiguration().getBoolean("jira.enabled", false);
		return value;
	}

	public void setJiraEnabled(boolean enabled) {
		getConfiguration().setProperty("jira.enabled", BooleanUtils.toStringTrueFalse(enabled));
	}

	public String getJiraContext() {
		String value = getConfiguration().getString("jira.context", "http://localhost/jira");
		return value;
	}

	public void setJiraContext(String uri) {
		getConfiguration().setProperty("jira.context", uri);
	}
}
