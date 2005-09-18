package com.jmonkey.xtracker.admin.profile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class DisplayProfileAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(DisplayProfileAction.class);

	public DisplayProfileAction() {
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
		ProfileForm profileForm = (ProfileForm) form;

		PersonLoader personLoader = new PersonLoader();
		List<Person> list = personLoader.loadPersonList(false);
		profileForm.setPersonList(list);
		request.getSession().setAttribute("profileForm", profileForm);
		return mapping.findForward("input");
	}
}
