package com.jmonkey.xtracker.anon.profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class EditAnonProfileAction extends Action {
	private Logger	logger	= LogManager.getLogger(EditAnonProfileAction.class);

	public EditAnonProfileAction() {
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
		AnonProfileForm anonProfileForm = (AnonProfileForm) form;

		AuthEnvironment authEnvironment = new AuthEnvironment(request);
		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.loadPersonForPrincipal(authEnvironment.getPrincipal());

		anonProfileForm.setUserName(person.getUsername());
		anonProfileForm.setRealName(person.getRealname());
		anonProfileForm.setInitials(person.getInitials());
		anonProfileForm.setSignature(person.getSignature());
		anonProfileForm.setEmailAddress(person.getEmailAddress());
		anonProfileForm.setPhoneNumber(person.getPhoneNumber());

		request.getSession().setAttribute("anonProfileForm", anonProfileForm);

		return mapping.getInputForward();
	}
}
