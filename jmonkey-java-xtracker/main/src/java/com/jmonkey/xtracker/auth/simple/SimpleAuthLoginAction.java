package com.jmonkey.xtracker.auth.simple;

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
import com.jmonkey.xtracker.auth.PathForwardFactory;
import com.jmonkey.xtracker.auth.realm.RolePrincipal;
import com.jmonkey.xtracker.auth.realm.UserPrincipal;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class SimpleAuthLoginAction extends Action {
	private Logger	logger	= LogManager.getLogger(SimpleAuthLoginAction.class);

	public SimpleAuthLoginAction() {
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
		String username = simpleAuthLoginForm.getUsername();
		String password = simpleAuthLoginForm.getPassword();
		logger.debug("Authenticating user: " + username);

		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.authenticatePerson(username, password.toCharArray());

		ActionForward forward = null;
		if (person != null) {
			logger.debug("Setting user principal in session...");
			AuthEnvironment authEnv = new AuthEnvironment(request);
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

			authEnv.setPrincipal(userPrincipal);
			if (redirectTo != null && redirectTo.length() > 0) {
				PathForwardFactory forwardFactory = new PathForwardFactory();
				forward = forwardFactory.getRedirectForward(redirectTo);
			} else {
				forward = mapping.findForward("principalPath");
			}
		} else {
			logger.debug("No person with the name [" + username + "] was found...");
			forward = mapping.getInputForward();
		}

		return forward;
	}

}
