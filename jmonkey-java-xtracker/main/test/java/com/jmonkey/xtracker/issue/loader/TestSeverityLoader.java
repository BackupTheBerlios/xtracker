package com.jmonkey.xtracker.issue.loader;

import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.test.ObjectMother;

public class TestSeverityLoader extends BaseHibernateTestCase {
	private Severity		testSeverity	= null;
	private SeverityLoader	loader			= null;

	public void testShouldLoadSeverityOne() throws HibernateException {
		Severity severity = loader.loadUnspecifiedSeverity();
		assertNotNull(severity);
		assertEquals(1, severity.getId());
	}

	public void testShouldLoadSeverityById() throws HibernateException {
		Severity severity = loader.loadSeverity(testSeverity.getId());
		assertNotNull(severity);
		assertEquals(ObjectMother.TEST_LABEL_UNSPECIFIED, severity.getLabel());
	}

	public void testShouldLoadSeverityList() throws HibernateException {
		List<Severity> severityList = loader.loadSeverityList();
		assertNotNull(severityList);
		assertEquals(1, severityList.size());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		loader = new SeverityLoader();
		testSeverity = ObjectMother.birthSeverity();
		hibernate.insertTestData(testSeverity);

	}

	@Override
	protected void tearDown() throws Exception {
		loader = null;
		hibernate.cleanUpDatabase(Severity.class);
		super.tearDown();
	}

}
