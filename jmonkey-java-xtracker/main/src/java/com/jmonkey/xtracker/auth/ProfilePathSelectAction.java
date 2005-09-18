package com.jmonkey.xtracker.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.HibernateSessionFactory;
import com.jmonkey.xtracker.config.JdkPrefsConfig;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class ProfilePathSelectAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(ProfilePathSelectAction.class);

	public ProfilePathSelectAction() {
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
		logger.debug("Principal Path Select called...");

		ActionForward forward = null;
		JdkPrefsConfig config = JdkPrefsConfig.instance();
		config.load();
		logger.debug("XTracker Configured: " + config.isConfigured());
		if (!config.isConfigured()) {
			forward = mapping.findForward("init");
		} else {
			try {
				AuthEnvironment authEnv = new AuthEnvironment(request);
				PersonLoader personLoader = new PersonLoader();
				Person person = personLoader.loadPersonForPrincipal(authEnv.getPrincipal());

				logger.debug("Found person: " + person.getRealname());

				if (person.isAnonymous() == true) {
					logger.debug("Person is anonymous...");
					forward = mapping.findForward("anontickets");
				} else {
					logger.debug("Person is an operator...");
					forward = mapping.findForward("mytickets");
				}
			} catch (ExceptionInInitializerError e) {
				HibernateSessionFactory.closeSession();
				PathForwardFactory factory = new PathForwardFactory();
				forward = factory.getRuntimeConfigForward();
			}
		}
		logger.debug("Forwarding to: " + forward.getName() + " [" + forward.getPath() + "]");

		return forward;
	}
}
