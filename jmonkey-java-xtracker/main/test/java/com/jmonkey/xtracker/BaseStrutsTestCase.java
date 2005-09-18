package com.jmonkey.xtracker;

import java.io.File;
import java.util.Date;

import net.sf.hibernate.HibernateException;
import servletunit.struts.MockStrutsTestCase;

import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.profile.Person;

public class BaseStrutsTestCase extends MockStrutsTestCase {
	protected final HibernateTestHelper	hibernate				= new HibernateTestHelper();
	protected final File				testContextDirectory	= new File("main/webapp");
	protected Queue						testQueue				= null;
	protected Person					testPerson				= null;
	protected Ticket					testTicket				= null;
	protected Disposition				testDisposition			= null;
	protected Severity					testSeverity			= null;
	protected Status					testStatus				= null;

	public BaseStrutsTestCase() {
		super();
	}

	public BaseStrutsTestCase(String name) {
		super(name);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		HibernateSessionFactory.setConfigFileLocation("/test-hibernate.cfg.xml");
		HibernateSessionFactory.resetSessionFactory();

	}

	@Override
	public void tearDown() throws Exception {
		HibernateSessionFactory.resetSessionFactory();
		// HibernateSessionFactory.setConfigFileLocation(HibernateSessionFactory.DEFAULT_CONFIG_FILE_LOCATION);
		super.tearDown();
	}

	protected void initStrutsContext() {
		setContextDirectory(testContextDirectory);
	}

	protected void setupTestTicket() throws HibernateException {
		testTicket = new Ticket();
		testTicket.setQueue(testQueue);
		testTicket.setRequestor(testPerson);
		testTicket.setSubject("test");
		testTicket.setPriority(new Integer(50));
		testTicket.setCreateDate(new Date());
		hibernate.insertTestData(testTicket);
	}

	protected void setupTestQueue() throws HibernateException {
		testQueue = new Queue();
		testQueue.setName("test");
		testQueue.setManager(testPerson);
		hibernate.insertTestData(testQueue);
	}

	protected void setupTestPerson() throws HibernateException {
		testPerson = new Person();
		testPerson.setUsername("test");
		testPerson.setPlainPassword("test");
		testPerson.setInitials("TU");
		testPerson.setRealname("test");
		testPerson.setSignature("test");
		hibernate.insertTestData(testPerson);
	}

	protected void setupTestDisposition() throws HibernateException {
		testDisposition = new Disposition();
		testDisposition.setId(1L);
		testDisposition.setLabel("test");
		testDisposition.setColour("#000000");
		hibernate.insertTestData(testDisposition);
	}

	protected void setupTestSeverity() throws HibernateException {
		testSeverity = new Severity();
		testSeverity.setId(1L);
		testSeverity.setLabel("test");
		testSeverity.setColour("#000000");
		hibernate.insertTestData(testSeverity);
	}

	protected void setupTestStatus() throws HibernateException {
		testStatus = new Status();
		testStatus.setId(1L);
		testStatus.setLabel("test");
		testStatus.setColour("#000000");
		hibernate.insertTestData(testStatus);
	}

}
