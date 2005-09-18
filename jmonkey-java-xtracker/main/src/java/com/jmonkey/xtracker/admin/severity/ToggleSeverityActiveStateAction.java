package com.jmonkey.xtracker.admin.severity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.loader.SeverityLoader;
import com.jmonkey.xtracker.issue.persistor.SeverityPersistor;

public class ToggleSeverityActiveStateAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(ToggleSeverityActiveStateAction.class);

	public ToggleSeverityActiveStateAction() {
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
		logger.debug("Toggle Active State called...");
		SeverityForm severityForm = (SeverityForm) form;
		long id = severityForm.getId();

		SeverityLoader severityLoader = new SeverityLoader();
		Severity severity = severityLoader.loadSeverity(id);

		if (!severity.isImmutable()) {
			severity.setActive(!severity.isActive());
			SeverityPersistor severityPersistor = new SeverityPersistor();
			severityPersistor.updateSeverity(severity);
		}

		return mapping.findForward("display");
	}
}
