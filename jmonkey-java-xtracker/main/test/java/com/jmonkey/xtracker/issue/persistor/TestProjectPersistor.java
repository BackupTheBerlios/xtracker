package com.jmonkey.xtracker.issue.persistor;

import java.util.Date;
import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Project;

public class TestProjectPersistor extends BaseHibernateTestCase {
	private Project				testProject	= null;
	private ProjectPersistor	persistor	= null;

	@SuppressWarnings("unchecked")
	public void testProjectGetsSaved() throws HibernateException {
		persistor.saveProject(testProject);

		List<Project> loadedList = hibernate.loadAllObjects(Project.class);
		assertNotNull(loadedList);
		assertEquals(1, loadedList.size());
		Project loaded = loadedList.get(0);
		assertEquals("test", loaded.getName());
		assertNotNull(loaded.getId());
	}

	@SuppressWarnings("unchecked")
	public void testProjectGetsUpdated() throws HibernateException {

		hibernate.insertTestData(testProject);
		assertNotNull(testProject.getId());
		testProject.setName("test test");
		persistor.updateProject(testProject);

		List<Project> loadedList = hibernate.loadAllObjects(Project.class);
		assertNotNull(loadedList);
		assertEquals(1, loadedList.size());
		Project loaded = loadedList.get(0);
		assertEquals("test test", loaded.getName());
		assertNotNull(loaded.getId());
	}

	@SuppressWarnings("unchecked")
	public void testProjectGetsDeleted() throws HibernateException {
		hibernate.insertTestData(testProject);

		persistor.deleteProject(testProject);

		List<Project> loadedList = hibernate.loadAllObjects(Project.class);
		assertNotNull(loadedList);
		assertEquals(0, loadedList.size());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testProject = new Project();
		testProject.setActive(true);
		testProject.setCreateDate(new Date());
		testProject.setName("test");

		persistor = new ProjectPersistor();
	}

	@Override
	protected void tearDown() throws Exception {
		hibernate.cleanUpDatabase(Project.class);
		super.tearDown();
	}

}
