package com.jmonkey.xtracker.anon.tickets;

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

public class AddAnonTicketAction extends BaseAction {
	private PreferencesConfig preferencesConfig = new PreferencesConfig();
	private Logger					logger	= LogManager.getLogger(AddAnonTicketAction.class);
//	private static JdkPrefsConfig	config	= null;

	public AddAnonTicketAction() {
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
		AddAnonTicketForm addAnonTicketForm = (AddAnonTicketForm) form;

		// Person person = loadPersonForPrincipal(request);
		// String queueId = myTicketsForm.getQueueId();

		ProjectLoader projectLoader = new ProjectLoader();
		List<Project> projectList = projectLoader.loadProjectList(false,false);
		addAnonTicketForm.setProjectList(projectList);

		SeverityLoader severityLoader = new SeverityLoader();
		List<Severity> severityList = severityLoader.loadSeverityList();
		addAnonTicketForm.setSeverityList(severityList);

		DispositionLoader dispositionLoader = new DispositionLoader();
		List<Disposition> dispositionList = dispositionLoader.loadDispositionList(true, true);
		addAnonTicketForm.setDispositionList(dispositionList);

		addAnonTicketForm.setPriority(preferencesConfig.getInitialTicketPriority());

		QueueLoader queueLoader = new QueueLoader();
		List<Queue> queueList = queueLoader.loadQueueList(false,false);
		addAnonTicketForm.setQueueList(queueList);

		request.getSession().setAttribute("addAnonTicketForm", addAnonTicketForm);

		return mapping.findForward("input");
	}

}
