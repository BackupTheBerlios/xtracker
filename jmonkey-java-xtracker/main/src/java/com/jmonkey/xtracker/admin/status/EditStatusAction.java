package com.jmonkey.xtracker.admin.status;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.loader.StatusLoader;

public class EditStatusAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(EditStatusAction.class);

	public EditStatusAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Edit called...");
		StatusForm statusForm = (StatusForm) form;
		
		long id = statusForm.getId();

		StatusLoader statusLoader = new StatusLoader();
		Status status = statusLoader.loadStatus(id);
		
		statusForm.setLabel(status.getLabel());
		statusForm.setColour(status.getColour());
		statusForm.setActive(status.isActive());
		statusForm.setSelectable(status.isSelectable());
		
		List<Status> statusList = statusLoader.loadStatusList();
		statusForm.setStatusList(statusList);
		
		request.getSession().setAttribute("statusForm", statusForm);
		return mapping.findForward("input");
	}
}
