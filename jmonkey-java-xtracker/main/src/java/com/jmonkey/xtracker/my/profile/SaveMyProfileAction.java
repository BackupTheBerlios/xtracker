package com.jmonkey.xtracker.my.profile;

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
import com.jmonkey.xtracker.cipher.PersonCipher;
import com.jmonkey.xtracker.linking.LinkingConfig;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;
import com.jmonkey.xtracker.profile.persistor.PersonPersistor;

public class SaveMyProfileAction extends Action {
	private Logger	logger	= LogManager.getLogger(SaveMyProfileAction.class);

	public SaveMyProfileAction() {
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
		MyProfileForm myProfileForm = (MyProfileForm) form;

		AuthEnvironment authEnvironment = new AuthEnvironment(request);
		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.loadPersonForPrincipal(authEnvironment.getPrincipal());

		boolean canShowTickets = false;
		String formUsername = myProfileForm.getUserName();
		String personUsername = person.getUsername();
		if (!personUsername.equals(formUsername)) {
			person.setUsername(myProfileForm.getUserName());
			canShowTickets = authEnvironment.removePrincipal();

			// XXX This is duplicated in the simple auth action and
			// the anon.profile save action. it should be refatored
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

		person.setRealname(myProfileForm.getRealName());
		person.setInitials(myProfileForm.getInitials());
		person.setSignature(myProfileForm.getSignature());
		person.setEmailAddress(myProfileForm.getEmailAddress());
		person.setPhoneNumber(myProfileForm.getPhoneNumber());

		String pwd = myProfileForm.getPassword();
		String vpwd = myProfileForm.getVerifyPassword();
		if ((pwd != null && pwd.length() > 0) && (vpwd != null && vpwd.length() > 0)) {
			if (pwd.equals(vpwd)) {
				person.setPlainPassword(pwd);
			}
		}

		LinkingConfig linkingConfig = new LinkingConfig();
		storeXplannerInfo(myProfileForm, person, linkingConfig);
		storeJiraInfo(myProfileForm, person, linkingConfig);

		PersonPersistor personPersistor = new PersonPersistor();
		personPersistor.updatePerson(person);

		// request.getSession().setAttribute("myProfileForm", myProfileForm);

		ActionForward forward = null;
		if (canShowTickets) {
			forward = mapping.findForward("mytickets");
		} else {
			forward = mapping.findForward("warnrestart");
		}
		return forward;
	}

	private void storeJiraInfo(MyProfileForm myProfileForm, Person person, LinkingConfig linkingConfig) throws Exception {
		if (linkingConfig.isJiraEnabled()) {
			String formNewUsername = myProfileForm.getJiraUsername();
			String linkUsername = person.getJiraUsername();
			if ((linkUsername == null) || !linkUsername.equals(formNewUsername)) {
				person.setJiraUsername(formNewUsername);
			}

			PersonCipher personCipher = new PersonCipher();
			personCipher.setUsername(person.getUsername());
			personCipher.setPassword(person.getPassword());
			String formNewPassword = myProfileForm.getJiraPassword();
			String linkPassword = person.getJiraPassword();
			if (linkPassword != null) {
				linkPassword = personCipher.decrypt(linkPassword);
			}
			if (linkPassword == null || !linkPassword.equals(formNewPassword)) {
				person.setJiraPassword(personCipher.encrypt(formNewPassword));
			}
		}
	}

	private void storeXplannerInfo(MyProfileForm myProfileForm, Person person, LinkingConfig linkingConfig) throws Exception {
		if (linkingConfig.isXplannerEnabled()) {
			String formXPUserName = myProfileForm.getXplannerUsername();
			String xpuname = person.getXplannerUsername();
			if ((xpuname == null) || !xpuname.equals(formXPUserName)) {
				person.setXplannerUsername(formXPUserName);
			}

			PersonCipher personCipher = new PersonCipher();
			personCipher.setUsername(person.getUsername());
			personCipher.setPassword(person.getPassword());
			String formXppasswd = myProfileForm.getXplannerPassword();
			String xppasswd = person.getXplannerPassword();
			if (xppasswd != null) {
				xppasswd = personCipher.decrypt(xppasswd);
			}
			if (xppasswd == null || !xppasswd.equals(formXppasswd)) {
				person.setXplannerPassword(personCipher.encrypt(formXppasswd));
			}
		}
	}
}
