package com.jmonkey.xtracker.admin.queue;

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

public class EditQueueAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(EditQueueAction.class);

	public EditQueueAction() {
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
		QueueForm queueForm = (QueueForm) form;

		String id = queueForm.getId();
		QueueLoader queueLoader = new QueueLoader();
		Queue queue = queueLoader.loadQueue(id);

		queueForm.setId(queue.getId());
		queueForm.setName(queue.getName());
		queueForm.setEmailAlias(queue.getEmailAlias());
		queueForm.setActive(queue.isActive());
		queueForm.setSelectable(queue.isSelectable());
		Person manager = queue.getManager();
		if (manager != null) {
			queueForm.setManagerId(manager.getId());
		}

		PersonLoader personLoader = new PersonLoader();
		List<Person> personList = personLoader.loadPersonList(true);
		queueForm.setPersonList(personList);
		
		List<Queue> queueList = queueLoader.loadQueueList(true, true);
		queueForm.setQueueList(queueList);

		request.getSession().setAttribute("queueForm", queueForm);

		return mapping.findForward("input");
	}
}
