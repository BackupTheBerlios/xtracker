package com.jmonkey.xtracker.admin.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.loader.ProjectLoader;
import com.jmonkey.xtracker.issue.persistor.ProjectPersistor;

public class ToggleProjectActiveStateAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(ToggleProjectActiveStateAction.class);

	public ToggleProjectActiveStateAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws HibernateException {
		logger.debug("Toggle Active State called...");
		ProjectForm projectForm = (ProjectForm) form;
		String id = projectForm.getId();

		ProjectLoader projectLoader = new ProjectLoader();
		Project project = projectLoader.loadProject(id);

		project.setActive(!project.isActive());
		ProjectPersistor projectPersistor = new ProjectPersistor();
		projectPersistor.updateProject(project);

		return mapping.findForward("display");
	}
}
