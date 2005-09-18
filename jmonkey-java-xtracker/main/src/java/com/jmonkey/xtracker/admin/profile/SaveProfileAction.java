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
import com.jmonkey.xtracker.profile.persistor.PersonPersistor;

public class SaveProfileAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(SaveProfileAction.class);

	public SaveProfileAction() {
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
		logger.debug("Save called...");
		ProfileForm profileForm = (ProfileForm) form;

		Person person = extractPerson(profileForm);

		String queueId = profileForm.getDefaultQueueId();
		if (queueId != null && queueId.trim().length() > 0) {
			QueueLoader queueLoader = new QueueLoader();
			Queue queue = queueLoader.loadQueue(queueId);
			person.setDefaultQueue(queue);
		}

		PersonPersistor personPersistor = new PersonPersistor();
		personPersistor.savePerson(person);

		return mapping.findForward("display");
	}

	private Person extractPerson(ProfileForm form) {
		Person person = new Person();
		person.setUsername(form.getUserName());
		person.setPlainPassword(form.getPassword());
		person.setRealname(form.getRealName());
		person.setInitials(form.getInitials());
		person.setSignature(form.getSignature());
		person.setActive(form.isActive());
		person.setSelectable(form.isSelectable());
		person.setAnonymous(form.isAnonymous());
		person.setAdministrator(form.isAdministrator());
		person.setEmailAddress(form.getEmailAddress());
		person.setPhoneNumber(form.getPhoneNumber());
		return person;
	}

}
