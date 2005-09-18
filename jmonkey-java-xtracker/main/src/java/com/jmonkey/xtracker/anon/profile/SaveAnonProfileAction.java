package com.jmonkey.xtracker.anon.profile;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.auth.realm.RolePrincipal;
import com.jmonkey.xtracker.auth.realm.UserPrincipal;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;
import com.jmonkey.xtracker.profile.persistor.PersonPersistor;

public class SaveAnonProfileAction extends Action {
	private Logger	logger	= LogManager.getLogger(SaveAnonProfileAction.class);

	public SaveAnonProfileAction() {
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
		logger.debug("Save called...");
		AnonProfileForm anonProfileForm = (AnonProfileForm) form;

		AuthEnvironment authEnvironment = new AuthEnvironment(request);
		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.loadPersonForPrincipal(authEnvironment.getPrincipal());

		boolean canShowTickets = false;
		String formUsername = anonProfileForm.getUserName();
		String personUsername = person.getUsername();
		if (!personUsername.equals(formUsername)) {
			person.setUsername(anonProfileForm.getUserName());
			canShowTickets = authEnvironment.removePrincipal();

			// XXX This is duplicated in the simple auth action and
			// the my.profile save action. it should be refatored
			// to remove duplicate code...
			logger.debug("Setting user principal in session...");
			UserPrincipal userPrincipal = new UserPrincipal(person.getUsername());

			List<RolePrincipal> roles = new ArrayList<RolePrincipal>();
			if (person.isActive()) {
				if (person.isAnonymous()) {
					roles.add(new RolePrincipal(RolePrincipal.ROLE_ANONYMUS));
				} else {
					roles.add(new RolePrincipal(RolePrincipal.ROLE_MEMBER));
					// XXX Only members can be administrators
					if (person.isAdministrator()) {
						roles.add(new RolePrincipal(RolePrincipal.ROLE_ADMINISTRATOR));
					}
				}
			}
			userPrincipal.setRoles(roles);

			authEnvironment.setPrincipal(userPrincipal);
		}

		person.setRealname(anonProfileForm.getRealName());
		person.setInitials(anonProfileForm.getInitials());
		person.setSignature(anonProfileForm.getSignature());
		person.setEmailAddress(anonProfileForm.getEmailAddress());
		person.setPhoneNumber(anonProfileForm.getPhoneNumber());

		String pwd = anonProfileForm.getPassword();
		String vpwd = anonProfileForm.getVerifyPassword();
		if ((pwd != null && pwd.length() > 0) && (vpwd != null && vpwd.length() > 0)) {
			if (pwd.equals(vpwd)) {
				person.setPlainPassword(pwd);
			}
		}

		PersonPersistor personPersistor = new PersonPersistor();
		personPersistor.updatePerson(person);

		// request.getSession().setAttribute("myProfileForm", myProfileForm);

		ActionForward forward = null;
		if (canShowTickets) {
			forward = mapping.findForward("anontickets");
		} else {
			forward = mapping.findForward("warnrestart");
		}
		return forward;
	}
}
