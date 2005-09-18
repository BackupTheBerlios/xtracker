package com.jmonkey.xtracker.issue.persistor;

import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Severity;

public class TestSeverityPersistor extends BaseHibernateTestCase {
	private Severity			testSeverity	= null;
	private SeverityPersistor	persistor		= null;

	public void testSeverityGetsSaved() throws HibernateException {
		persistor.saveSeverity(testSeverity);

		@SuppressWarnings("unchecked") 
		List<Severity> loadedList = hibernate.loadAllObjects(Severity.class);
		assertNotNull(loadedList);
		assertEquals(1, loadedList.size());
		Severity loaded = loadedList.get(0);
		assertEquals("#000000", loaded.getColour());
		assertEquals("test", loaded.getLabel());
		assertNotNull(loaded.getId());
	}

	public void testSeverityGetsUpdated() throws HibernateException {

		hibernate.insertTestData(testSeverity);
		assertNotNull(testSeverity.getId());
		testSeverity.setColour("#FFFFFF");
		persistor.updateSeverity(testSeverity);

		@SuppressWarnings("unchecked") 
		List<Severity> loadedStatus = hibernate.loadAllObjects(Severity.class);
		assertNotNull(loadedStatus);
		assertEquals(1, loadedStatus.size());
		Severity loaded = loadedStatus.get(0);
		assertEquals("#FFFFFF", loaded.getColour());
		assertNotNull(loaded.getId());
	}

	public void testSeverityGetsDeleted() throws HibernateException {
		hibernate.insertTestData(testSeverity);

		persistor.deleteSeverity(testSeverity);

		@SuppressWarnings("unchecked") 
		List<Severity> loadedStatus = hibernate.loadAllObjects(Severity.class);
		assertNotNull(loadedStatus);
		assertEquals(0, loadedStatus.size());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testSeverity = new Severity();
		testSeverity.setColour("#000000");
		testSeverity.setImmutable(false);
		testSeverity.setLabel("test");

		persistor = new SeverityPersistor();
	}

	@Override
	protected void tearDown() throws Exception {
		hibernate.cleanUpDatabase(Severity.class);
		super.tearDown();
	}

}
