package com.jmonkey.xtracker.admin.disposition;

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

public class ToggleDispositionSelectableStateAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(ToggleDispositionSelectableStateAction.class);

	public ToggleDispositionSelectableStateAction() {
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
		DispositionForm dispositionForm = (DispositionForm) form;
		long id = dispositionForm.getId();

		DispositionLoader dispositionLoader = new DispositionLoader();
		Disposition disposition = dispositionLoader.loadDisposition(id);
		if (!disposition.isImmutable()) {
			disposition.setSelectable(!disposition.isSelectable());
			DispositionPersistor dispositionPersistor = new DispositionPersistor();
			dispositionPersistor.updateDisposition(disposition);
		}
		return mapping.findForward("display");
	}
}
