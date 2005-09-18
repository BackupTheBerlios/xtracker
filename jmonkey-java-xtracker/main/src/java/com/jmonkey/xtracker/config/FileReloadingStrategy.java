/*
 * Copyright 2005 Brill Pappin
 */
package com.jmonkey.xtracker.config;

import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 * @author brill
 * @version $Revision: 1.1 $
 */
public class FileReloadingStrategy extends FileChangedReloadingStrategy {
	private boolean	reloadEnabled	= true;

	public FileReloadingStrategy() {
		super();
	}

	@Override
	protected boolean hasChanged() {
		return reloadEnabled && super.hasChanged();
	}

	public boolean isReloadEnabled() {
		return reloadEnabled;
	}

	public void setReloadEnabled(boolean reloadEnabled) {
		this.reloadEnabled = reloadEnabled;
	}
}
