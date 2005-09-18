/*
 * Copyright 2004 Brill Pappin
 */
package com.jmonkey.xtracker.config;

import java.io.File;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.apache.commons.lang.BooleanUtils;

/**
 * @author brill
 * @version $Revision: 1.1 $
 */
public class JdkPrefsConfig {
	public static final File		DEFAULT_ROOT	= new File("/var/xtracker");
	private static JdkPrefsConfig	instance		= null;
	protected Preferences			preferences		= null;
//	private boolean					dirty			= false;
	private boolean					loaded			= false;

	protected JdkPrefsConfig() {
		super();
	}

	public static JdkPrefsConfig instance() {
		if (JdkPrefsConfig.instance == null) {
			JdkPrefsConfig.instance = new JdkPrefsConfig();
			JdkPrefsConfig.instance.preferences = Preferences.userNodeForPackage(JdkPrefsConfig.class);
		}
		return JdkPrefsConfig.instance;
	}

	public static JdkPrefsConfig loadedInstance() throws BackingStoreException {
		JdkPrefsConfig config = JdkPrefsConfig.instance();
		config.loadIfNeeded();
		return config;
	}

	public void store() throws BackingStoreException {
		// if(loaded && dirty) {
		preferences.flush();
		// }
	}

	public void load() throws BackingStoreException {
		preferences.sync();
		loaded = true;
	}

	public void loadIfNeeded() throws BackingStoreException {
		if (!loaded) {
			load();
		}
	}

	public boolean isLoaded() {
		return loaded;
	}

	public String[] getKeys() throws BackingStoreException {
		return preferences.keys();
	}

	public String getConfigRoot() {
		String value = preferences.get("xtracker.disk.root", DEFAULT_ROOT.getAbsolutePath());
		return value;
	}

	public void setConfigRoot(String value) {
		preferences.put("xtracker.disk.root", value);
	}

	public boolean isConfigured() {
		boolean value = preferences.getBoolean("xtracker.has.been.configured", false);
		return value;
	}

	public void setConfigured(boolean configed) {
		preferences.put("xtracker.has.been.configured", BooleanUtils.toStringTrueFalse(configed));
	}

}
