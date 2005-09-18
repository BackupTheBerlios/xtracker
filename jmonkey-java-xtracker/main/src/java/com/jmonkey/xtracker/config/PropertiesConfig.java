/*
 * Copyright 2005 Brill Pappin
 */
package com.jmonkey.xtracker.config;

import java.io.File;
import java.util.Iterator;
import java.util.prefs.BackingStoreException;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author brill
 * @version $Revision: 1.1 $
 */
public abstract class PropertiesConfig implements Config {

	private Logger					logger			= LogManager.getLogger(PropertiesConfig.class);
	private File					root			= null;
	private String					name			= null;
	private boolean					transientConfig	= false;
	private FileReloadingStrategy	stategy			= null;
	private PropertiesConfiguration	configuration	= null;
	protected JdkPrefsConfig		prefs			= null;

	public PropertiesConfig(String name) {
		this(null, name, true);
	}

	public PropertiesConfig(String name, boolean autoReload) {
		this(null, name, autoReload);
	}

	public PropertiesConfig(File rootDir, String name, boolean autoReload) {
		super();

		if (name == null) {
			throw new IllegalArgumentException("name must not be null");
		}

		this.name = name;

		try {
			initConfig(rootDir, autoReload);
		} catch (ConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	private void initConfig(File rootDir, boolean autoReload) throws ConfigurationException {
		try {
			prefs = JdkPrefsConfig.loadedInstance();
		} catch (BackingStoreException e) {
			throw new ConfigurationException(e);
		}
		if (rootDir == null) {
			root = new File(prefs.getConfigRoot());
		}

		if (root == null) {
			throw new IllegalArgumentException("root must not be null");
		}

		// configuration.setReloadingStrategy(null)
		logger.debug("ensuring root directory exists...");
		root.mkdirs();

		configuration = new PropertiesConfiguration();
		File configFile = configFile();
		if (!configFile.exists()) {
			// Properties defaults = getNewConfigDefaults();
			try {
				writeNewConfigDefaults(configFile);
			} catch (Exception e) {
				logger.warn("Couldn't write default config", e);
			}
		}
		logger.debug("Setting file to: " + configFile.getAbsolutePath());
		configuration.setFile(configFile);

		logger.debug("Setting reload stategy to: Reloading check every 1 second");
		stategy = new FileReloadingStrategy();
		stategy.setReloadEnabled(autoReload);
		stategy.setRefreshDelay(1000L);
		configuration.setReloadingStrategy(stategy);

		// XXX Autosave doesn't seem to work very well.
		// configuration.setAutoSave(true);
		// try {
		// configuration.save();
		// } catch (ConfigurationException e) {
		// e.printStackTrace();
		// }

		configuration.load();
	}

	public boolean isReloadEnabled() {
		return stategy.isReloadEnabled();
	}

	public void setReloadEnabled(boolean reloadEnabled) {
		stategy.setReloadEnabled(reloadEnabled);
	}

	private File configFile() {
		File configFile = new File(root, name + ".properties");
		return configFile;
	}

	public File getRoot() {
		return root;
	}

	/**
	 * @see com.jmonkey.jameson.config.Config#store()
	 */
	public void store() throws ConfigException {
		try {
			logger.debug("Attempting save...");
			configuration.save();
		} catch (ConfigurationException e) {
			throw new ConfigException(e);
		} finally {
			setTransient(false);
		}
	}

	/**
	 * @see com.jmonkey.jameson.config.Config#load()
	 */
	public void load() throws ConfigException {
		try {
			logger.debug("Attempting load...");
			configuration.load();
			setTransient(false);
		} catch (ConfigurationException e) {
			throw new ConfigException(e);
		}
	}

	/**
	 * @see com.jmonkey.jameson.config.Config#getKeys()
	 */
	@SuppressWarnings("unusedThrown")
	public Iterator getKeys() throws ConfigException {
		Iterator iterator = configuration.getKeys();
		return iterator;
	}

	/**
	 * @see com.jmonkey.jameson.config.Config#isTransient()
	 */
	public boolean isTransient() {
		return false;
	}

	public void setTransient(boolean trans) {
		logger.warn("Transient checking disabled for auto-save properties...");
		// logger.debug("Setting config to transient: " + trans);
		// transientConfig = trans;
	}

	public Configuration getConfiguration() {
		return configuration;
	}
}
