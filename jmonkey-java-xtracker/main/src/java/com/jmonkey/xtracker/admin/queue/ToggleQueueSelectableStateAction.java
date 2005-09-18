package com.jmonkey.xtracker.admin.queue;

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
import com.jmonkey.xtracker.issue.persistor.QueuePersistor;

public class ToggleQueueSelectableStateAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(ToggleQueueSelectableStateAction.class);

	public ToggleQueueSelectableStateAction() {
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
		logger.debug("Toggle Selectable State called...");
		QueueForm queueForm = (QueueForm) form;
		String id = queueForm.getId();

		QueueLoader queueLoader = new QueueLoader();
		Queue queue = queueLoader.loadQueue(id);

		queue.setSelectable(!queue.isSelectable());
		QueuePersistor queuePersistor = new QueuePersistor();
		queuePersistor.updateQueue(queue);

		return mapping.findForward("display");
	}
}
