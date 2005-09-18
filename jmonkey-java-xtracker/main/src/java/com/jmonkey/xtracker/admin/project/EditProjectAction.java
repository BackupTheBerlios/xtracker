package com.jmonkey.xtracker.admin.project;

import java.util.List;

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

public class EditProjectAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(EditProjectAction.class);

	public EditProjectAction() {
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
		logger.debug("Edit called...");
		ProjectForm projectForm = (ProjectForm) form;

		String id = projectForm.getId();

		ProjectLoader projectLoader = new ProjectLoader();

		Project project = projectLoader.loadProject(id);
		projectForm.setId(project.getId());
		projectForm.setName(project.getName());
		projectForm.setActive(project.isActive());
		projectForm.setSelectable(project.isSelectable());

		List<Project> projectList = projectLoader.loadProjectList(true, true);
		projectForm.setProjectList(projectList);

		request.getSession().setAttribute("projectForm", projectForm);

		return mapping.findForward("input");
	}
}
