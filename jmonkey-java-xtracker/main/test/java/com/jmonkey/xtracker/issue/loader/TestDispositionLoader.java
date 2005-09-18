package com.jmonkey.xtracker.issue.loader;

import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.test.ObjectMother;

public class TestDispositionLoader extends BaseHibernateTestCase {
	private Disposition			testDisposition	= null;
	private DispositionLoader	loader			= null;

	public void testShouldLoadDispositionOne() throws HibernateException {
		Disposition disposition = loader.loadUnspecifiedDisposition();
		assertNotNull(disposition);
		assertEquals(1, disposition.getId());
	}

	public void testShouldLoadDispositionById() throws HibernateException {
		Disposition disposition = loader.loadDisposition(testDisposition.getId());
		assertNotNull(disposition);
		assertEquals(ObjectMother.TEST_LABEL_UNSPECIFIED, disposition.getLabel());
	}

	public void testShouldLoadDispositionList() throws HibernateException {
		List<Disposition> dispositionList = loader.loadDispositionList(true, false);
		assertNotNull(dispositionList);
		assertEquals(1, dispositionList.size());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		loader = new DispositionLoader();

		testDisposition = ObjectMother.birthDisposition();
		hibernate.insertTestData(testDisposition);
	}

	@Override
	protected void tearDown() throws Exception {
		loader = null;
		hibernate.cleanUpDatabase(Disposition.class);
		super.tearDown();
	}

}
