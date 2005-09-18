package com.jmonkey.xtracker.my.tickets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.PreferencesConfig;
import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.loader.DispositionLoader;
import com.jmonkey.xtracker.issue.loader.ProjectLoader;
import com.jmonkey.xtracker.issue.loader.QueueLoader;
import com.jmonkey.xtracker.issue.loader.SeverityLoader;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class AddTicketAction extends BaseAction {
	private Logger					logger	= LogManager.getLogger(AddTicketAction.class);
	private PreferencesConfig preferencesConfig = new PreferencesConfig();
//	private static JdkPrefsConfig	config	= null;

	public AddTicketAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		logger.debug("Add called...");
//		synchronized (this) {
//			if (config == null) {
//				config = JdkPrefsConfig.instance();
//				config.load();
//			}
//		}
		MyTicketsForm myTicketsForm = (MyTicketsForm) form;

		// Person person = loadPersonForPrincipal(request);
		// String queueId = myTicketsForm.getQueueId();

		ProjectLoader projectLoader = new ProjectLoader();
		List<Project> projectList = projectLoader.loadProjectList(false,false);
		myTicketsForm.setProjectList(projectList);

//		StatusLoader statusLoader = new StatusLoader();
//		List<Status> statusList = statusLoader.loadStatusListNotClosed();
//		myTicketsForm.setStatusList(statusList);

		SeverityLoader severityLoader = new SeverityLoader();
		List<Severity> severityList = severityLoader.loadSeverityList();
		myTicketsForm.setSeverityList(severityList);

		DispositionLoader dispositionLoader = new DispositionLoader();
		List<Disposition> dispositionList = dispositionLoader.loadDispositionList(true, true);
		myTicketsForm.setDispositionList(dispositionList);
		
		PersonLoader personLoader = new PersonLoader();
		List<Person> personList = personLoader.loadPersonList(true);
		myTicketsForm.setPersonList(personList);

		myTicketsForm.setPriority(preferencesConfig.getInitialTicketPriority());

		QueueLoader queueLoader = new QueueLoader();
		List<Queue> queueList = queueLoader.loadQueueList(false,false);
		myTicketsForm.setQueueList(queueList);

		request.getSession().setAttribute("myTicketsForm", myTicketsForm);

		return mapping.findForward("input");
	}

}
