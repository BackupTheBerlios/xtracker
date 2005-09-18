package com.jmonkey.xtracker.admin.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.loader.ProjectLoader;
import com.jmonkey.xtracker.issue.persistor.ProjectPersistor;

public class AddProjectAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(AddProjectAction.class);

	public AddProjectAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Add called...");
		ProjectForm projectForm = (ProjectForm) form;
		String projectId = projectForm.getId();
		String projectName = projectForm.getName();

		if (projectName != null && projectName.length() > 0) {
			if (projectId != null && projectId.length() > 0) {
				String id = projectForm.getId();
				ProjectLoader projectLoader = new ProjectLoader();
				Project project = projectLoader.loadProject(id);

				project.setName(projectName);
				project.setActive(projectForm.isActive());
				project.setSelectable(projectForm.isSelectable());

				ProjectPersistor projectPersistor = new ProjectPersistor();
				projectPersistor.updateProject(project);

			} else {
				Project project = new Project();
				project.setName(projectName);
				project.setActive(projectForm.isActive());
				project.setSelectable(projectForm.isSelectable());

				ProjectPersistor projectPersistor = new ProjectPersistor();
				projectPersistor.saveProject(project);
			}
		}

		return mapping.findForward("display");
	}

}
