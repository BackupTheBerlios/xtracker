package com.jmonkey.xtracker.issue.loader;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.test.ObjectMother;

public class TestStatusLoader extends BaseHibernateTestCase {
	private StatusLoader	loader	= null;

	public void testCanLoadStatusById() throws HibernateException {
		Status status = loader.loadStatus(1);
		assertNotNull(status);
		assertEquals("New", status.getLabel());
	}

	public void testCanLoadStatusByNextId() throws HibernateException {
		Status newStatus = loader.loadNewStatus();
		Status status = loader.loadStatusWithNextId(newStatus);
		assertNotNull(status);
		assertEquals("Open", status.getLabel());
		assertEquals(2, status.getId());
	}

	public void testCanLoadNewStatus() throws HibernateException {
		Status status = loader.loadNewStatus();
		assertNotNull(status);
		assertEquals(1, status.getId());
	}

	public void testCanLoadOpenStatus() throws HibernateException {
		Status status = loader.loadOpenStatus();
		assertNotNull(status);
		assertEquals(2, status.getId());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		loader = new StatusLoader();

		Status newStatus = ObjectMother.birthStatus();
		hibernate.insertTestData(newStatus);
		Status openStatus = ObjectMother.birthStatus();
		openStatus.setLabel("Open");
		openStatus.setId(2);
		hibernate.insertTestData(openStatus);
	}

	@Override
	protected void tearDown() throws Exception {
		loader = null;
		hibernate.cleanUpDatabase(Status.class);
		super.tearDown();
	}

}
