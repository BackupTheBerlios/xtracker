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
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.loader.QueueLoader;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class EditProfileAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(EditProfileAction.class);

	public EditProfileAction() {
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
		ProfileForm profileForm = (ProfileForm) form;
		String id = profileForm.getId();

		PersonLoader personLoader = new PersonLoader();
		Person person = personLoader.loadPerson(id);

		populateStrutsForm(profileForm, person);

		QueueLoader queueLoader = new QueueLoader();
		List<Queue> queueList = queueLoader.loadQueueList(false, false);
		profileForm.setQueueList(queueList);

		request.setAttribute("profileForm", profileForm);

		return mapping.findForward("edit");
	}

	private void populateStrutsForm(ProfileForm profileForm, Person person) {
		profileForm.setId(person.getId());
		profileForm.setUserName(person.getUsername());
		profileForm.setInitials(person.getInitials());
		profileForm.setRealName(person.getRealname());
		profileForm.setSignature(person.getSignature());
		profileForm.setActive(person.isActive());
		profileForm.setSelectable(person.isSelectable());
		profileForm.setAdministrator(person.isAdministrator());
		profileForm.setAnonymous(person.isAnonymous());

		Queue queue = person.getDefaultQueue();
		if (queue != null) {
			profileForm.setDefaultQueueId(queue.getId());
		}

		populatePersonEmail(profileForm, person);
		populatePersonPhoneNumber(profileForm, person);
	}

	private void populatePersonPhoneNumber(ProfileForm profileForm, Person person) {
		if (person.getPhoneNumber() != null) {
			String number = person.getPhoneNumber();
			profileForm.setPhoneNumber(number);
		}
	}

	private void populatePersonEmail(ProfileForm profileForm, Person person) {
		if (person.getEmailAddress() != null) {
			String email = person.getEmailAddress();
			profileForm.setEmailAddress(email);
		}
	}
}
