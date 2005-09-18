package com.jmonkey.xtracker.auth;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;

public class OpenTicketPathSelectAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(OpenTicketPathSelectAction.class);

	public OpenTicketPathSelectAction() {
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
		logger.debug("Open Ticket Path Select called...");
		ProfilePathSelectForm profilePathSelectForm = (ProfilePathSelectForm) form;

		ActionForward forward = null;
		AuthEnvironment authEnv = new AuthEnvironment(request);
		Principal principal = authEnv.getPrincipal();

		PathForwardFactory forwardFactory = new PathForwardFactory();
		if (principal == null) {
//			String redirUrl = request.getRequestURI();
			String redirUrl = authEnv.getRequestLocation();
			logger.debug("Requesting login and redir to: " + redirUrl);
			forward = forwardFactory.getRedirectingLoginForward(redirUrl);
		} else {
			PersonLoader personLoader = new PersonLoader();
			Person person = personLoader.loadPersonForPrincipal(principal);

			logger.debug("Found person: " + person.getRealname());

			if (person.isAnonymous() == true) {
				logger.debug("Person is anonymous...");
				forward = forwardFactory.getAnonOpenTicketForward(profilePathSelectForm.getId());
			} else {
				logger.debug("Person is an operator...");
				forward = forwardFactory.getMyOpenTicketForward(profilePathSelectForm.getId());
			}
			logger.debug("Forwarding to: " + forward.getName() + " [" + forward.getPath() + "]");
		}
		return forward;
	}
}
