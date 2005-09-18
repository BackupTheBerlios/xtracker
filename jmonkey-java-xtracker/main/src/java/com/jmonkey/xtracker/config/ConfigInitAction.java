package com.jmonkey.xtracker.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.DatabaseConfig;
import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.allotrope.Installer;
import com.jmonkey.xtracker.auth.PathForwardFactory;

public class ConfigInitAction extends Action {
	private Logger	logger	= LogManager.getLogger(ConfigInitAction.class);

	public ConfigInitAction() {
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
		ConfigInitForm configInitForm = (ConfigInitForm) form;

		ActionForward forward = mapping.findForward("principalPath");
		JdkPrefsConfig config = JdkPrefsConfig.loadedInstance();
		logger.debug("Checking config: path=" + configInitForm.getPath() + ", configured=" + config.isConfigured());

		if (configInitForm.getPath() == null && !config.isConfigured()) {
			configInitForm.setPath(config.getConfigRoot());
			configInitForm.setConfigured(config.isConfigured());

			configInitForm.setHibernateDialect("net.sf.hibernate.dialect.MySQLDialect");
			configInitForm.setConnectionDriver("com.mysql.jdbc.Driver");
			configInitForm.setConnectionUrl("jdbc:mysql://localhost:3306/xtracker?autoReconnect=true");

			request.getSession().setAttribute("configInitForm", configInitForm);
			forward = mapping.getInputForward();
		} else if (configInitForm.getPath() != null && !config.isConfigured()) {
			String path = configInitForm.getPath();
			config.setConfigRoot(path);
			config.setConfigured(true);
			config.store();
			
			DatabaseConfig databaseConfig = new DatabaseConfig();
			BeanUtils.copyProperties(databaseConfig, configInitForm);
			databaseConfig.store();
			databaseConfig.load();

			Session session = HibernateSessionFactory.currentSession(true);
			Transaction transaction = session.beginTransaction();
			Installer installer = new Installer();
			installer.setupStatus(session);
			installer.setupSeverity(session);
			installer.setupDisposition(session);
			installer.setupPerson(session);
			installer.setupQueue(session);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			
			PathForwardFactory factory = new PathForwardFactory();
			forward = factory.getRuntimeConfigForward();

		}
		return forward;
	}

}
