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

public class DisplayStatusAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(DisplayStatusAction.class);

	public DisplayStatusAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Display called...");
		StatusForm statusForm = (StatusForm) form;

		StatusLoader statusLoader = new StatusLoader();
		List<Status> statusList = statusLoader.loadStatusList();
		statusForm.setStatusList(statusList);
		request.getSession().setAttribute("statusForm", statusForm);
		return mapping.findForward("input");
	}
}
