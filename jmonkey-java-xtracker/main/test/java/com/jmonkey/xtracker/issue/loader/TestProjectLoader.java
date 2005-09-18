package com.jmonkey.xtracker.issue.loader;

import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseHibernateTestCase;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.test.ObjectMother;

public class TestProjectLoader extends BaseHibernateTestCase {
	private Project			testProject	= null;
	private ProjectLoader	loader		= null;

	public void testShouldLoadProjectById() throws HibernateException {
		Project project = loader.loadProject(testProject.getId());
		assertNotNull(project);
		assertEquals(testProject.getId(), project.getId());
	}

	public void testShouldLoadProjectListSelectableOnly() throws HibernateException {
		List<Project> projectList = loader.loadProjectList(true, false);
		assertNotNull(projectList);
		assertEquals(2, projectList.size());
	}

	public void testShouldLoadProjectListActiveOnly() throws HibernateException {
		List<Project> projectList = loader.loadProjectList(false, true);
		assertNotNull(projectList);
		assertEquals(2, projectList.size());
	}

	public void testShouldLoadProjectListActiveAndSelectableOnly() throws HibernateException {
		List<Project> projectList = loader.loadProjectList(false, false);
		assertNotNull(projectList);
		assertEquals(1, projectList.size());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		loader = new ProjectLoader();

		testProject = ObjectMother.birthProject();
		hibernate.insertTestData(testProject);

		Project selectableProject = ObjectMother.birthProject();
		selectableProject.setName("Not Selectable");
		selectableProject.setSelectable(false);
		hibernate.insertTestData(selectableProject);

		Project activeProject = ObjectMother.birthProject();
		activeProject.setName("Not Active");
		activeProject.setActive(false);
		hibernate.insertTestData(activeProject);
	}

	@Override
	protected void tearDown() throws Exception {
		loader = null;
		hibernate.cleanUpDatabase(Project.class);
		super.tearDown();
	}

}
