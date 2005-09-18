package com.jmonkey.xtracker.admin.severity;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.loader.SeverityLoader;

public class EditSeverityAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(EditSeverityAction.class);

	public EditSeverityAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Edit called...");
		SeverityForm severityForm = (SeverityForm) form;
		
		long id = severityForm.getId();

		SeverityLoader severityLoader = new SeverityLoader();
		Severity severity = severityLoader.loadSeverity(id);
		severityForm.setLabel(severity.getLabel());
		severityForm.setColour(severity.getColour());
		severityForm.setActive(severity.isActive());
		severityForm.setSelectable(severity.isSelectable());
		
		List<Severity> severityList = severityLoader.loadSeverityList();
		severityForm.setSeverityList(severityList);
		
		request.getSession().setAttribute("severityForm", severityForm);
		return mapping.findForward("input");
	}
}
