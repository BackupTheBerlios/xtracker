package com.jmonkey.xtracker.auth;

import org.apache.struts.action.ActionForward;

public class PathForwardFactory {

	public PathForwardFactory() {
		super();
	}

	public ActionForward getRuntimeConfigForward() {
		ActionForward openTicketForward = new ActionForward();
		openTicketForward.setRedirect(true);
		openTicketForward.setPath("/admin/runtime.do");
		return openTicketForward;
	}

	public ActionForward getAnonOpenTicketForward(Long id) {
		ActionForward openTicketForward = new ActionForward();
		openTicketForward.setRedirect(true);
		openTicketForward.setPath("/anon/open.do?id=" + id.toString());
		return openTicketForward;
	}

	public ActionForward getMyOpenTicketForward(Long id) {
		ActionForward openTicketForward = new ActionForward();
		openTicketForward.setRedirect(true);
		openTicketForward.setPath("/my/openTicket.do?id=" + id.toString());
		return openTicketForward;
	}

	public ActionForward getRedirectingLoginForward(String redirTo) {
		ActionForward loginForward = new ActionForward();
		loginForward.setRedirect(true);
		loginForward.setPath("/redirLogin.do?redirectTo=" + redirTo);
		return loginForward;
	}
	public ActionForward getRedirectForward(String redirTo) {
		ActionForward loginForward = new ActionForward();
		loginForward.setRedirect(true);
		loginForward.setPath(redirTo);
		return loginForward;
	}
}
