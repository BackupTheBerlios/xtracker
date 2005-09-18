package com.jmonkey.xtracker.issue.persistor;

import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Disposition;

public class TestDispositionPersistor extends BaseHibernateTestCase {

	private Disposition				testDisposition	= null;
	private DispositionPersistor	persistor		= null;

	@SuppressWarnings("unchecked")
	public void testDispositionGetsSaved() throws HibernateException {
		persistor.saveDisposition(testDisposition);

		List<Disposition> loadedList = hibernate.loadAllObjects(Disposition.class);
		assertNotNull(loadedList);
		assertEquals(1, loadedList.size());
		Disposition loaded = loadedList.get(0);
		assertEquals("test", loaded.getLabel());
		assertNotNull(loaded.getId());
	}

	@SuppressWarnings("unchecked")
	public void testDispositionGetsUpdated() throws HibernateException {

		hibernate.insertTestData(testDisposition);
		assertNotNull(testDisposition.getId());
		testDisposition.setLabel("test test");
		persistor.updateDisposition(testDisposition);

		List<Disposition> loadedList = hibernate.loadAllObjects(Disposition.class);
		assertNotNull(loadedList);
		assertEquals(1, loadedList.size());
		Disposition loaded = loadedList.get(0);
		assertEquals("test test", loaded.getLabel());
		assertNotNull(loaded.getId());
	}

	@SuppressWarnings("unchecked")
	public void testDispositionGetsDeleted() throws HibernateException {
		hibernate.insertTestData(testDisposition);

		persistor.deleteDisposition(testDisposition);

		List<Disposition> loadedList = hibernate.loadAllObjects(Disposition.class);
		assertNotNull(loadedList);
		assertEquals(0, loadedList.size());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testDisposition = new Disposition();
		testDisposition.setColour("#000000");
		testDisposition.setImmutable(false);
		testDisposition.setLabel("test");

		persistor = new DispositionPersistor();
	}

	@Override
	protected void tearDown() throws Exception {
		hibernate.cleanUpDatabase(Disposition.class);
		super.tearDown();
	}

}
