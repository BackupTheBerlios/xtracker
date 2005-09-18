package com.jmonkey.xtracker.allotrope;

import java.util.prefs.BackingStoreException;

import com.jmonkey.xtracker.config.JdkPrefsConfig;

public class ResetConfig {

	public ResetConfig() {
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ResetConfig reset = new ResetConfig();
		try {
			reset.doReset();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
	}

	private void doReset() throws BackingStoreException {
		JdkPrefsConfig config = JdkPrefsConfig.instance();
		config.load();
		System.out.println("XTracker is configured: " + config.isConfigured());
		System.out.println("Config root is: " + config.getConfigRoot());
		System.out.println("Resetting config flag...");
		config.setConfigured(false);
		config.store();
		System.out.println("XTracker is configured: " + config.isConfigured());
		System.out.println("Config root is: " + config.getConfigRoot());
	}

}
