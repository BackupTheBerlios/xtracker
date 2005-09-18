package com.jmonkey.xtracker.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import junit.framework.TestCase;
import oracle.jdbc.OracleDriver;


public class PTestOracleJDBC extends TestCase {

	public void testConnection() throws SQLException {
		Properties properties = new Properties();
		properties.setProperty("user", "username");
		properties.setProperty("password", "password");
		properties.setProperty("database", "xtracker");
		properties.setProperty("server", "10.1.1.152");

		Driver driver = new OracleDriver();
		Connection connection = driver.connect("jdbc:oracle:thin:@//10.1.1.152:1521/xtracker", properties);
		DatabaseMetaData dbmd = connection.getMetaData();
		System.out.println(dbmd.getURL());
	}
}
