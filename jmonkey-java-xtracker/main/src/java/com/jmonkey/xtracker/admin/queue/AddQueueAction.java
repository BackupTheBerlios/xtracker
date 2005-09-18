package com.jmonkey.xtracker.admin.queue;

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
import com.jmonkey.xtracker.issue.persistor.QueuePersistor;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class AddQueueAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(AddQueueAction.class);

	public AddQueueAction() {
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

		String queueId = queueForm.getId();
		String queueName = queueForm.getName();

		if (queueName != null && queueName.length() > 0) {
			if (queueId != null && queueId.length() > 0) {
				String id = queueForm.getId();
				QueueLoader queueLoader = new QueueLoader();
				Queue queue = queueLoader.loadQueue(id);

				queue.setName(queueName);

				setQueueAlias(queueForm, queue);

				queue.setActive(queueForm.isActive());
				queue.setSelectable(queueForm.isSelectable());
				String managerId = queueForm.getManagerId();
				if (managerId != null && managerId.length() > 0) {
					PersonLoader personLoader = new PersonLoader();
					Person manager = personLoader.loadPerson(managerId);
					queue.setManager(manager);
				}

				QueuePersistor queuePersistor = new QueuePersistor();
				queuePersistor.updateQueue(queue);

			} else {

				Queue queue = new Queue();
				queue.setName(queueName);
				queue.setActive(queueForm.isActive());
				queue.setSelectable(queueForm.isSelectable());

				setQueueAlias(queueForm, queue);

				String managerId = queueForm.getManagerId();

				PersonLoader personLoader = new PersonLoader();
				Person manager = personLoader.loadPerson(managerId);
				queue.setManager(manager);

				QueuePersistor queuePersistor = new QueuePersistor();
				queuePersistor.saveQueue(queue);
			}
		}

		return mapping.findForward("display");
	}

	private void setQueueAlias(QueueForm queueForm, Queue queue) {
		String emailAlias = queueForm.getEmailAlias();
		if (emailAlias == null || emailAlias.length() == 0) {
			String qname = queue.getName();
			if (qname.indexOf(' ') > -1) {
				emailAlias = concatQueueName(qname);
			} else {
				emailAlias = qname;
			}
		}
		queue.setEmailAlias(emailAlias);
	}

	private String concatQueueName(String qname) {
		String emailAlias;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < qname.length(); i++) {
			char nextChar = qname.charAt(i);
			if (nextChar != ' ') {
				buffer.append(nextChar);
			}
		}
		emailAlias = buffer.toString();
		return emailAlias;
	}
}
