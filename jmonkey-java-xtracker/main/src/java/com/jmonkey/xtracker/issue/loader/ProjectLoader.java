package com.jmonkey.xtracker.issue.loader;

import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Project;

public class ProjectLoader extends PersistanceManager {

	public ProjectLoader() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Project> loadProjectList(boolean selectable, boolean active) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Project.class);
		if (!active) {
			criteria.add(Expression.eq("active", true));
		}
		if (!selectable) {
			criteria.add(Expression.eq("selectable", true));
		}
		List<Project> projectList = criteria.list();

		transaction.commit();
		checkClose();
		return projectList;
	}

	public Project loadProject(String id) throws HibernateException {
		Project project = null;
		if (id != null) {
			checkOpen();
			Transaction transaction = session.beginTransaction();
			project = (Project) session.load(Project.class, id);
			transaction.commit();
			checkClose();
		}
		return project;
	}
}
