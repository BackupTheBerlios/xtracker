package com.jmonkey.xtracker.issue.persistor;

import java.util.Date;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.jmonkey.xtracker.PersistanceManager;
import com.jmonkey.xtracker.issue.Project;

public class ProjectPersistor extends PersistanceManager {

	public ProjectPersistor() {
		super();
	}

	public void saveProject(Project project) throws HibernateException {
		project.setCreateDate(new Date());
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.save(project);
		transaction.commit();
		checkClose();
	}

	public void updateProject(Project project) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.update(project);
		transaction.commit();
		checkClose();
	}

	public void deleteProject(Project project) throws HibernateException {
		checkOpen();
		Transaction transaction = session.beginTransaction();
		session.delete(project);
		transaction.commit();
		checkClose();
	}
}
