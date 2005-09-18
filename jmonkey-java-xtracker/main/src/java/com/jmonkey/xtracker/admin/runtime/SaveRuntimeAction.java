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
import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.PreferencesConfig;
import com.jmonkey.xtracker.config.JdkPrefsConfig;
import com.jmonkey.xtracker.linking.LinkingConfig;
import com.jmonkey.xtracker.mail.MailConfig;

public class SaveRuntimeAction extends BaseAction {
	private Logger					logger	= LogManager.getLogger(SaveRuntimeAction.class);
	private static JdkPrefsConfig	config	= null;

	public SaveRuntimeAction() {
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
		RuntimeForm runtimeForm = (RuntimeForm) form;

		PreferencesConfig preferencesConfig = new PreferencesConfig();
		MailConfig mailConfig = new MailConfig();
		DatabaseConfig databaseConfig = new DatabaseConfig();
		LinkingConfig linkingConfig = new LinkingConfig();
		
		BeanUtils.copyProperties(config, runtimeForm);
		BeanUtils.copyProperties(preferencesConfig, runtimeForm);
		BeanUtils.copyProperties(mailConfig, runtimeForm);
		BeanUtils.copyProperties(databaseConfig, runtimeForm);
		BeanUtils.copyProperties(linkingConfig, runtimeForm);

		config.store();
		config.load();

		preferencesConfig.store();
		preferencesConfig.load();

		mailConfig.store();
		mailConfig.load();

		databaseConfig.store();
		databaseConfig.load();
		
		linkingConfig.store();
		linkingConfig.load();

		HibernateSessionFactory.resetSessionFactory();

		return mapping.findForward("home");
	}
}
