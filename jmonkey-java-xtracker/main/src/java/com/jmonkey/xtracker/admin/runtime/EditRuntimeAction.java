package com.jmonkey.xtracker.admin.runtime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.DatabaseConfig;
import com.jmonkey.xtracker.PreferencesConfig;
import com.jmonkey.xtracker.config.JdkPrefsConfig;
import com.jmonkey.xtracker.linking.LinkingConfig;
import com.jmonkey.xtracker.mail.MailConfig;

public class EditRuntimeAction extends BaseAction {
	private Logger					logger	= LogManager.getLogger(EditRuntimeAction.class);
	private static JdkPrefsConfig	config	= null;

	public EditRuntimeAction() {
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
		logger.debug("Edit called...");
		synchronized (this) {
			if (config == null) {
				config = JdkPrefsConfig.loadedInstance();
			}
		}
		
		PreferencesConfig preferencesConfig = new PreferencesConfig();
		MailConfig mailConfig = new MailConfig();
		DatabaseConfig databaseConfig = new DatabaseConfig();
		LinkingConfig linkingConfig = new LinkingConfig();
		
		RuntimeForm runtimeForm = (RuntimeForm) form;
		BeanUtils.copyProperties(runtimeForm, config);
		BeanUtils.copyProperties(runtimeForm, preferencesConfig);
		BeanUtils.copyProperties(runtimeForm, mailConfig);
		BeanUtils.copyProperties(runtimeForm, databaseConfig);
		BeanUtils.copyProperties(runtimeForm, linkingConfig);
		
		// FIXME This is a quick hack, the config returns a file object 
		// and the form is expecting a String, so BeanUtils ignores the property
		runtimeForm.setAttachmentRootDirectory(mailConfig.getAttachmentRootDirectory().getAbsolutePath());

		request.getSession().setAttribute("runtimeForm", runtimeForm);

		return mapping.findForward("input");
	}
}
