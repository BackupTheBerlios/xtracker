package com.jmonkey.xtracker.auth.simple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class SimpleRedirectingAuthLoginAction extends Action {
	private Logger	logger	= LogManager.getLogger(SimpleRedirectingAuthLoginAction.class);

	public SimpleRedirectingAuthLoginAction() {
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
		SimpleAuthLoginForm simpleAuthLoginForm = (SimpleAuthLoginForm) form;

		String redirectTo = simpleAuthLoginForm.getRedirectTo();
		logger.debug("Login and redirect to: " + redirectTo);

		request.getSession().setAttribute("simpleAuthLoginForm", simpleAuthLoginForm);

		return mapping.getInputForward();
	}

}
