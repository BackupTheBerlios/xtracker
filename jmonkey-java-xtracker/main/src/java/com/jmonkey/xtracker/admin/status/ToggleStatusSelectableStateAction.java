package com.jmonkey.xtracker.admin.status;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.loader.StatusLoader;
import com.jmonkey.xtracker.issue.persistor.StatusPersistor;

public class ToggleStatusSelectableStateAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(ToggleStatusSelectableStateAction.class);

	public ToggleStatusSelectableStateAction() {
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
		StatusForm statusForm = (StatusForm) form;
		long id = statusForm.getId();

		StatusLoader statusLoader = new StatusLoader();
		Status status = statusLoader.loadStatus(id);

		if (!status.isImmutable()) {
			status.setSelectable(!status.isSelectable());
			StatusPersistor statusPersistor = new StatusPersistor();
			statusPersistor.updateStatus(status);
		}

		return mapping.findForward("display");
	}
}
