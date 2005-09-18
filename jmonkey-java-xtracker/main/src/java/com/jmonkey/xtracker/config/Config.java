/*
 * Copyright 2004 Brill Pappin
 */
package com.jmonkey.xtracker.config;

import java.io.File;
import java.util.Iterator;

/**
 * @author brill
 * @version $Revision: 1.1 $
 */
public interface Config {
	public abstract void store() throws ConfigException;

	public abstract void load() throws ConfigException;

	public abstract Iterator getKeys() throws ConfigException;

	public abstract boolean isTransient();

	public abstract void writeNewConfigDefaults(File file) throws ConfigException;
}
