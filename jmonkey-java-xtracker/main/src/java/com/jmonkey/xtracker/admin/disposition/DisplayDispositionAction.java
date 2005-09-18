package com.jmonkey.xtracker.admin.disposition;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.loader.DispositionLoader;

public class DisplayDispositionAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(DisplayDispositionAction.class);

	public DisplayDispositionAction() {
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
		logger.debug("Display called...");
		DispositionForm dispositionForm = (DispositionForm) form;

		DispositionLoader dispositionLoader = new DispositionLoader();
		List dispositionList = dispositionLoader.loadDispositionList(false, false);
		dispositionForm.setDispositionList(dispositionList);
		request.getSession().setAttribute("dispositionForm", dispositionForm);
		return mapping.findForward("input");
	}

}
