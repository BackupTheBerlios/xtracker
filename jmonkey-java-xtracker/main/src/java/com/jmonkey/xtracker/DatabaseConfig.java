package com.jmonkey.xtracker;

import java.io.File;
import java.io.IOException;

import com.jmonkey.xtracker.config.ConfigException;
import com.jmonkey.xtracker.config.PropertiesConfig;

public class DatabaseConfig extends PropertiesConfig {

	private static final String	CONFIG_NAME	= "database";

	public DatabaseConfig() {
		this(false);
	}

	public DatabaseConfig(boolean autoReload) {
		super(CONFIG_NAME, autoReload);
	}

	public DatabaseConfig(File rootDir, boolean autoReload) {
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

	public String getHibernateDialect() {
		String value = getConfiguration().getString("hibernate.dialect", "net.sf.hibernate.dialect.MySQLDialect");
		return value;
	}

	public void setHibernateDialect(String value) {
		getConfiguration().setProperty("hibernate.dialect", value);
	}

	public String getConnectionUrl() {
		String value = getConfiguration().getString("hibernate.connection.url", "jdbc:mysql://localhost:3306/xtracker?autoReconnect=true");
		return value;
	}

	public void setConnectionUrl(String value) {
		getConfiguration().setProperty("hibernate.connection.url", value);
	}

	public String getConnectionDriver() {
		String value = getConfiguration().getString("hibernate.connection.driver", "com.mysql.jdbc.Driver");
		return value;
	}

	public void setConnectionDriver(String value) {
		getConfiguration().setProperty("hibernate.connection.driver", value);
	}

	public String getConnectionUsername() {
		String value = getConfiguration().getString("hibernate.connection.username", "uXTracker");
		return value;
	}

	public void setConnectionUsername(String value) {
		getConfiguration().setProperty("hibernate.connection.username", value);
	}

	public String getConnectionPassword() {
		String value = getConfiguration().getString("hibernate.connection.password", "xtracker");
		return value;
	}

	public void setConnectionPassword(String value) {
		getConfiguration().setProperty("hibernate.connection.password", value);
	}

	public Integer getConnectionPoolMinSize() {
		Integer value = getConfiguration().getInt("hibernate.connection.pool.min_size", new Integer(5));
		return value;
	}

	public void setConnectionPoolMinSize(Integer value) {
		getConfiguration().setProperty("hibernate.connection.pool.min_size", value.toString());
	}

	public Integer getConnectionPoolMaxSize() {
		Integer value = getConfiguration().getInt("hibernate.connection.pool.max_size", new Integer(20));
		return value;
	}

	public void setConnectionPoolMaxSize(Integer value) {
		getConfiguration().setProperty("hibernate.connection.pool.max_size", value.toString());
	}

	public Integer getConnectionPoolMaxStatements() {
		Integer value = getConfiguration().getInt("hibernate.connection.pool.max_statements", new Integer(50));
		return value;
	}

	public void setConnectionPoolMaxStatements(Integer value) {
		getConfiguration().setProperty("hibernate.connection.pool.max_statements", value.toString());
	}

	public Integer getConnectionPoolTimeout() {
		Integer value = getConfiguration().getInt("hibernate.connection.pool.timeout", new Integer(1800));
		return value;
	}

	public void setConnectionPoolTimeout(Integer value) {
		getConfiguration().setProperty("hibernate.connection.pool.timeout", value.toString());
	}

	public String getValidationQuery() {
		String value = getConfiguration().getString("hibernate.connection.validation.query", "select 1");
		return value;
	}

	public void setValidationQuery(String value) {
		getConfiguration().setProperty("hibernate.connection.validation.query", value);
	}

	public String getQuerySubstitutions() {
		String value = getConfiguration().getString("hibernate.query.substitutions", "true=1, false=0, yes=1, no=0");
		return value;
	}

	public void setQuerySubstitutions(String value) {
		getConfiguration().setProperty("hibernate.query.substitutions", value);
	}

}
