package com.jmonkey.xtracker.admin.status;

import java.util.Date;

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

public class AddStatusAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(AddStatusAction.class);

	public AddStatusAction() {
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
		StatusForm statusForm = (StatusForm) form;
		long id = statusForm.getId();
		String colour = statusForm.getColour();
		String label = statusForm.getLabel();
		boolean active = statusForm.isActive();
		boolean selectable = statusForm.isSelectable();

		if (colour == null || colour.length() == 0) {
			colour = "#EEEEEE";
		}
		if (label != null && label.length() > 0) {
			StatusPersistor statusPersistor = new StatusPersistor();
			if (id >= 0) {
				StatusLoader statusLoader = new StatusLoader();
				Status status = statusLoader.loadStatus(id);
				status.setLabel(label);
				status.setColour(colour);
				status.setActive(active);
				status.setSelectable(selectable);
				statusPersistor.updateStatus(status);
			} else {
				Status status = new Status(label, colour, new Date());
				status.setActive(active);
				status.setSelectable(selectable);
				statusPersistor.saveStatus(status);
			}
		}

		return mapping.findForward("display");
	}
}
