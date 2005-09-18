package com.jmonkey.xtracker.admin.disposition;

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
import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.loader.DispositionLoader;
import com.jmonkey.xtracker.issue.persistor.DispositionPersistor;

public class AddDispositionAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(AddDispositionAction.class);

	public AddDispositionAction() {
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
		DispositionForm dispositionForm = (DispositionForm) form;

		long id = dispositionForm.getId();
		String colour = dispositionForm.getColour();
		String label = dispositionForm.getLabel();
		boolean active = dispositionForm.isActive();
		boolean selectable = dispositionForm.isSelectable();

		if (colour == null || colour.length() == 0) {
			colour = "#EEEEEE";
		}
		if (label != null && label.length() > 0) {
			DispositionPersistor dispositionPersistor = new DispositionPersistor();
			if (id >= 0) {
				DispositionLoader dispositionLoader = new DispositionLoader();
				Disposition disposition = dispositionLoader.loadDisposition(id);
				disposition.setActive(active);
				disposition.setSelectable(selectable);
				disposition.setColour(colour);
				disposition.setLabel(label);
				dispositionPersistor.updateDisposition(disposition);
			} else {
				Disposition disposition = new Disposition(label, colour, new Date());
				disposition.setActive(active);
				disposition.setSelectable(selectable);
				dispositionPersistor.saveDisposition(disposition);
			}
		}

		return mapping.findForward("display");
	}
}
