package com.jmonkey.xtracker.my.search;

import java.util.Calendar;
import java.util.List;

import net.sf.hibernate.HibernateException;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.loader.DispositionLoader;
import com.jmonkey.xtracker.issue.loader.ProjectLoader;
import com.jmonkey.xtracker.issue.loader.QueueLoader;
import com.jmonkey.xtracker.issue.loader.SeverityLoader;
import com.jmonkey.xtracker.issue.loader.StatusLoader;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class BaseSearchAction extends BaseAction {

	public BaseSearchAction() {
		super();
	}

	protected void loadOptionLists(SearchForm searchForm) throws HibernateException {
		ProjectLoader projectLoader = new ProjectLoader();
		List<Project> projectList = projectLoader.loadProjectList(false, false);
		searchForm.setProjectList(projectList);

		StatusLoader statusLoader = new StatusLoader();
		List<Status> statusList = statusLoader.loadStatusList();
		searchForm.setStatusList(statusList);

		SeverityLoader severityLoader = new SeverityLoader();
		List<Severity> severityList = severityLoader.loadSeverityList();
		searchForm.setSeverityList(severityList);

		DispositionLoader dispositionLoader = new DispositionLoader();
		List<Disposition> dispositionList = dispositionLoader.loadDispositionList(true, true);
		searchForm.setDispositionList(dispositionList);

		PersonLoader personLoader = new PersonLoader();
		List<Person> personList = personLoader.loadPersonList(true);
		searchForm.setPersonList(personList);

		QueueLoader queueLoader = new QueueLoader();
		List<Queue> queueList = queueLoader.loadQueueList(false, false);
		searchForm.setQueueList(queueList);
	}

	protected void setCurrentYearMonthDay(SearchForm searchForm) {
		Calendar calendar = Calendar.getInstance();
		searchForm.setYear(Integer.toString(calendar.get(Calendar.YEAR)));
		searchForm.setMonth(Integer.toString(calendar.get(Calendar.MONTH) + 1));
		searchForm.setDay(Integer.toString(calendar.get(Calendar.DAY_OF_MONTH)));
	}

}
