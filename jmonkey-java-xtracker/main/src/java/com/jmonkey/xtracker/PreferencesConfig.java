package com.jmonkey.xtracker;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.BooleanUtils;

import com.jmonkey.xtracker.config.ConfigException;
import com.jmonkey.xtracker.config.PropertiesConfig;

public class PreferencesConfig extends PropertiesConfig {

	public static final String	CONFIG_NAME	= "preferences";

	public PreferencesConfig() {
		this(false);
	}

	public PreferencesConfig(boolean autoReload) {
		super(CONFIG_NAME, autoReload);
	}

	public PreferencesConfig(File rootDir, boolean autoReload) {
		super(rootDir, CONFIG_NAME, autoReload);
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

	public Integer getInitialTicketPriority() {
		int priority = getConfiguration().getInt("initial.ticket.priority", 50);
		return new Integer(priority);
	}

	public void setInitialTicketPriority(Integer priority) {
		getConfiguration().setProperty("initial.ticket.priority", priority.toString());
	}

	public String getRootXTrackerUriContext() {
		String value = getConfiguration().getString("root.xtracker.context", "http://localhost/xtracker");
		return value;
	}

	public void setRootXTrackerUriContext(String context) {
		getConfiguration().setProperty("root.xtracker.context", context);
	}

	public boolean isMaxModifyAgeEnabled() {
		boolean value = getConfiguration().getBoolean("ticket.max.modified.enabled", false);
		return value;
	}

	public void setMaxModifyAgeEnabled(boolean enabled) {
		getConfiguration().setProperty("ticket.max.modified.enabled", BooleanUtils.toStringTrueFalse(enabled));
	}

	public int getMaxModifiedAgeDays() {
		int age = getConfiguration().getInt("ticket.max.modified.age", 15);
		return age;
	}

	public void setMaxModifiedAge(int age) {
		getConfiguration().setProperty("ticket.max.modified.age", Integer.toString(age));
	}

	public int getMaxModifiedIncrement() {
		int inc = getConfiguration().getInt("ticket.max.modified.increment", 10);
		return inc;
	}

	public void setMaxModifiedIncrement(int inc) {
		getConfiguration().setProperty("ticket.max.modified.increment", Integer.toString(inc));
	}
}
