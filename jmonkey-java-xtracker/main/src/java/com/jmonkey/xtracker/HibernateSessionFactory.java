package com.jmonkey.xtracker;

import java.util.Properties;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.MailReference;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.linking.jira.JiraLink;
import com.jmonkey.xtracker.linking.xplanner.XPlannerLink;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.PersonRole;

public class HibernateSessionFactory {
	private static Logger						logger				= LogManager.getLogger(HibernateSessionFactory.class);
	private static DatabaseConfig				databaseConfig		= new DatabaseConfig();
	// public static final String DEFAULT_CONFIG_FILE_LOCATION =
	// "/hibernate.cfg.xml";
	/**
	 * Location of hibernate.cfg.xml file. NOTICE: Location should be on the
	 * classpath as Hibernate uses #resourceAsStream style lookup for its
	 * configuration file. That is place the config file in a Java package - the
	 * default location is the default Java package.<br>
	 * <br>
	 * Examples: <br>
	 * <code>CONFIG_FILE_LOCATION = "/hibernate.conf.xml". 
	 * CONFIG_FILE_LOCATION = "/com/foo/bar/myhiberstuff.conf.xml".</code>
	 */
	private static String						configFileLocation	= null;
	private static final ThreadLocal<Session>	threadLocal			= new ThreadLocal<Session>();
	private static Configuration				cfg					= null;
	private static SessionFactory				sessionFactory;
	private static Properties					properties			= null;

	public static void setConfigFileLocation(String location) {
		configFileLocation = location;
		logger.debug("Hibernate config file reset: " + configFileLocation);
	}

	public static void resetSessionFactory() {
		if (sessionFactory != null) {
			try {
				closeSession();
				sessionFactory.close();
			} catch (HibernateException e) {
				logger.error("Can't close session factory", e);
			} finally {
				sessionFactory = null;
			}
		}
	}

	public static Session currentSession() throws HibernateException {
		return currentSession(false);
	}

	public static Session currentSession(boolean autoCreate) throws HibernateException {
		Session session = threadLocal.get();
		logger.debug("Hibernate Session is : " + session);
		if (session == null) {
			logger.debug("Hibernate SessionFactory is : " + sessionFactory);
			if (sessionFactory == null) {
				try {
					logger.debug("Reloading Config with auto create [" + autoCreate + "]");
					// cfg.configure(configFileLocation);
					reloadConfig(autoCreate);
					logger.debug("Building session factory...");
					sessionFactory = cfg.buildSessionFactory();
				} catch (Exception e) {
					// System.err.println("%%%% Error Creating SessionFactory
					// %%%%");
					// e.printStackTrace();
					logger.fatal("Error Creating SessionFactory", e);
				}
			}
			logger.debug("Opening session...");
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}

		return session;
	}

	public static void closeSession() throws HibernateException {
		Session session = threadLocal.get();
		threadLocal.set(null);

		if (session != null) {
			try {
				session.close();
			} finally {
				session = null;
			}

		}
	}

	private HibernateSessionFactory() {
		super();
	}

	private static void reloadConfig(boolean autoCreate) throws HibernateException {
		if (configFileLocation != null) {
			cfg = new Configuration();
			cfg.configure(configFileLocation);
		} else {
			// JdkPrefsConfig config = JdkPrefsConfig.instance();
			// config.load();
			properties = new Properties();
			properties.setProperty("hibernate.dialect", databaseConfig.getHibernateDialect()); // net.sf.hibernate.dialect.MySQLDialect</property>
			properties.setProperty("hibernate.connection.username", databaseConfig.getConnectionUsername()); // uXPTracker</property>
			properties.setProperty("hibernate.connection.url", databaseConfig.getConnectionUrl()); // jdbc:mysql://192.168.0.8:3306/xptracker</property>
			properties.setProperty("hibernate.connection.password", databaseConfig.getConnectionPassword()); // xptracker</property>
			properties.setProperty("hibernate.connection.driver_class", databaseConfig.getConnectionDriver());// com.mysql.jdbc.Driver</property>
			properties.setProperty("hibernate.connection.pool_size", databaseConfig.getConnectionPoolMinSize().toString()); // "10");
			properties.setProperty("hibernate.transaction.factory_class", "net.sf.hibernate.transaction.JDBCTransactionFactory");
			properties.setProperty("hibernate.query.substitutions", databaseConfig.getQuerySubstitutions()); // true=1,
			// no=0</property>
			properties.setProperty("hibernate.show_sql", Boolean.toString(logger.isDebugEnabled()));
			properties.setProperty("hibernate.jdbc.use_streams_for_binary", "true");
			properties.setProperty("hibernate.c3p0.min_size", databaseConfig.getConnectionPoolMinSize().toString()); // 5</property>
			properties.setProperty("hibernate.c3p0.max_size", databaseConfig.getConnectionPoolMaxSize().toString()); // 20</property>
			properties.setProperty("hibernate.c3p0.timeout", databaseConfig.getConnectionPoolTimeout().toString()); // 1800</property>
			properties.setProperty("hibernate.c3p0.max_statements", databaseConfig.getConnectionPoolMaxStatements().toString());// 50</property>

			logger.debug("Connecting to: " + properties.getProperty("hibernate.connection.url"));

			if (autoCreate) {
				properties.setProperty("hibernate.hbm2ddl.auto", "create");
			}

			cfg = new Configuration();
			cfg.addClass(Person.class);
			cfg.addClass(XPlannerLink.class);
			cfg.addClass(JiraLink.class);
//			cfg.addClass(Email.class);
			cfg.addClass(Queue.class);
			cfg.addClass(Severity.class);
			cfg.addClass(Status.class);
			cfg.addClass(Ticket.class);
			cfg.addClass(History.class);
			cfg.addClass(MailReference.class);
			cfg.addClass(Project.class);
			cfg.addClass(Disposition.class);
			cfg.addClass(PersonRole.class);
			cfg.setProperties(properties);
		}
	}

}
