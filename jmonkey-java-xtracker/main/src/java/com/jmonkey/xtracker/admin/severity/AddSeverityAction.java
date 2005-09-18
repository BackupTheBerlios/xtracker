package com.jmonkey.xtracker.admin.severity;

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
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.loader.SeverityLoader;
import com.jmonkey.xtracker.issue.persistor.SeverityPersistor;

public class AddSeverityAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(AddSeverityAction.class);

	public AddSeverityAction() {
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
		SeverityForm severityForm = (SeverityForm) form;
		long id = severityForm.getId();
		String colour = severityForm.getColour();
		String label = severityForm.getLabel();
		boolean active = severityForm.isActive();
		boolean selectable = severityForm.isSelectable();

		if (colour == null || colour.length() == 0) {
			colour = "#EEEEEE";
		}

		if (label != null && label.length() > 0) {
			SeverityPersistor severityPersistor = new SeverityPersistor();
			if (id >= 0) {
				SeverityLoader severityLoader = new SeverityLoader();
				Severity severity = severityLoader.loadSeverity(id);
				severity.setLabel(label);
				severity.setColour(colour);
				severity.setActive(active);
				severity.setSelectable(selectable);
				severityPersistor.updateSeverity(severity);
			} else {
				Severity severity = new Severity(label, colour, new Date());
				severity.setActive(active);
				severity.setSelectable(selectable);
				severityPersistor.saveSeverity(severity);
			}
		}

		return mapping.findForward("display");
	}
}
