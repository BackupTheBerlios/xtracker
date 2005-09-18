package com.jmonkey.xtracker.my.tickets;

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

public class DisplayPersonAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(DisplayPersonAction.class);

	public DisplayPersonAction() {
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
		DisplayPersonForm displayPersonForm = (DisplayPersonForm) form;

		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.loadPerson(displayPersonForm.getId());
		displayPersonForm.setPerson(person);

		request.getSession().setAttribute("displayPersonForm", displayPersonForm);

		return mapping.findForward("input");
	}
}
