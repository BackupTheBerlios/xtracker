package com.jmonkey.xtracker.issue.persistor;

import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Status;

public class TestStatusPersistor extends BaseHibernateTestCase {
	private Status				testStatus	= null;
	private StatusPersistor		persistor	= null;

	public void testStatusGetsSaved() throws HibernateException {
		persistor.saveStatus(testStatus);

		@SuppressWarnings("unchecked") 
		List<Status> loadedStatus = hibernate.loadAllObjects(Status.class);
		assertNotNull(loadedStatus);
		assertEquals(1, loadedStatus.size());
		Status loaded = loadedStatus.get(0);
		assertEquals("#000000", loaded.getColour());
		assertEquals("test", loaded.getLabel());
		assertNotNull(loaded.getId());
	}

	public void testStatusGetsUpdated() throws HibernateException {

		hibernate.insertTestData(testStatus);
		
		assertNotNull(testStatus.getId());
		testStatus.setColour("#FFFFFF");
		persistor.updateStatus(testStatus);

		@SuppressWarnings("unchecked") 
		List<Status> loadedStatus = hibernate.loadAllObjects(Status.class);
		assertNotNull(loadedStatus);
		assertEquals(1, loadedStatus.size());
		Status loaded = loadedStatus.get(0);
		assertEquals("#FFFFFF", loaded.getColour());
		assertNotNull(loaded.getId());
	}

	public void testStatusGetsDeleted() throws HibernateException {
		hibernate.insertTestData(testStatus);

		persistor.deleteStatus(testStatus);

		@SuppressWarnings("unchecked")
		List<Status> loadedStatus = hibernate.loadAllObjects(Status.class);
		assertNotNull(loadedStatus);
		assertEquals(0, loadedStatus.size());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testStatus = new Status();
		testStatus.setColour("#000000");
		testStatus.setImmutable(true);
		testStatus.setLabel("test");

		persistor = new StatusPersistor();
	}

	@Override
	protected void tearDown() throws Exception {
		hibernate.cleanUpDatabase(Status.class);
		super.tearDown();
	}

}
