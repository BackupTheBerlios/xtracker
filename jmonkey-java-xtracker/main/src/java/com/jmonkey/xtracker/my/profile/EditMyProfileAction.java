package com.jmonkey.xtracker.my.profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.cipher.PersonCipher;
import com.jmonkey.xtracker.linking.LinkingConfig;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class EditMyProfileAction extends Action {
	private Logger	logger	= LogManager.getLogger(EditMyProfileAction.class);

	public EditMyProfileAction() {
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
		MyProfileForm myProfileForm = (MyProfileForm) form;

		AuthEnvironment authEnvironment = new AuthEnvironment(request);
		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.loadPersonForPrincipal(authEnvironment.getPrincipal());

		myProfileForm.setUserName(person.getUsername());
		myProfileForm.setRealName(person.getRealname());
		myProfileForm.setInitials(person.getInitials());
		myProfileForm.setSignature(person.getSignature());
		myProfileForm.setEmailAddress(person.getEmailAddress());
		myProfileForm.setPhoneNumber(person.getPhoneNumber());

		LinkingConfig linkingConfig = new LinkingConfig();
		loadXplannerInfo(myProfileForm, person, linkingConfig);
		loadJiraInfo(myProfileForm, person, linkingConfig);

		request.getSession().setAttribute("myProfileForm", myProfileForm);

		return mapping.getInputForward();
	}

	private void loadJiraInfo(MyProfileForm myProfileForm, Person person, LinkingConfig linkingConfig) throws Exception {
		if (linkingConfig.isJiraEnabled()) {
			myProfileForm.setJiraEnabled(true);
			String linkUsername = person.getJiraUsername();
			if (linkUsername == null) {
				linkUsername = person.getUsername();
			}
			myProfileForm.setJiraUsername(linkUsername);

			String linkPassword = person.getJiraPassword();
			if (linkPassword != null) {
				PersonCipher personCipher = new PersonCipher();
				personCipher.setUsername(person.getUsername());
				personCipher.setPassword(person.getPassword());
				
				String clearPasswd = personCipher.decrypt(linkPassword);
				myProfileForm.setJiraPassword(clearPasswd);
			}
		}
	}

	private void loadXplannerInfo(MyProfileForm myProfileForm, Person person, LinkingConfig linkingConfig) throws Exception {
		if (linkingConfig.isXplannerEnabled()) {
			myProfileForm.setXplannerEnabled(true);
			String xpuname = person.getXplannerUsername();
			if (xpuname == null) {
				xpuname = person.getUsername();
			}
			myProfileForm.setXplannerUsername(xpuname);

			String xppasswd = person.getXplannerPassword();
			if (xppasswd != null) {
				PersonCipher personCipher = new PersonCipher();
				personCipher.setUsername(person.getUsername());
				personCipher.setPassword(person.getPassword());
				
				String clearPasswd = personCipher.decrypt(xppasswd);
				myProfileForm.setXplannerPassword(clearPasswd);
			}
		}
	}
}
