package com.jmonkey.xtracker.admin.profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.loader.QueueLoader;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;
import com.jmonkey.xtracker.profile.persistor.PersonPersistor;

public class UpdateProfileAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(UpdateProfileAction.class);

	public UpdateProfileAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws HibernateException {
		logger.debug("Add called...");
		ProfileForm profileForm = (ProfileForm) form;

		String id = profileForm.getId();

		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.loadPerson(id);

		updatePerson(profileForm, person);

		PersonPersistor personPersistor = new PersonPersistor();
		personPersistor.updatePerson(person);

		return mapping.findForward("display");
	}

	private void updatePerson(ProfileForm profileForm, Person person) throws HibernateException {
		if (profileForm.getUserName() != null) {
			person.setUsername(profileForm.getUserName());
		}
		String pwd = profileForm.getPassword();
		String vpwd = profileForm.getVerifyPassword();
		if ((pwd != null && pwd.length() > 0) && (vpwd != null && vpwd.length() > 0)) {
			if (pwd.equals(vpwd)) {
				person.setPlainPassword(pwd);
			}
		}
		if (profileForm.getRealName() != null) {
			person.setRealname(profileForm.getRealName());
		}
		if (profileForm.getInitials() != null) {
			person.setInitials(profileForm.getInitials());
		}
		if (profileForm.getSignature() != null) {
			person.setSignature(profileForm.getSignature());
		}
		if (profileForm.getEmailAddress() != null) {
			person.setEmailAddress(profileForm.getEmailAddress());
		}
		if (profileForm.getPhoneNumber() != null) {
			person.setPhoneNumber(profileForm.getPhoneNumber());
		}
		String defaultQueueId = profileForm.getDefaultQueueId();
		if (defaultQueueId != null && defaultQueueId.trim().length() > 0) {
			QueueLoader queueLoader = new QueueLoader();
			Queue queue = queueLoader.loadQueue(defaultQueueId);
			person.setDefaultQueue(queue);
		}

		person.setActive(profileForm.isActive());
		person.setSelectable(profileForm.isSelectable());
		person.setAnonymous(profileForm.isAnonymous());
		person.setAdministrator(profileForm.isAdministrator());
	}

}
