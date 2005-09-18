package com.jmonkey.xtracker.anon.tickets;

import org.apache.struts.action.ActionForward;

public class AnonForwardFactory {

	public AnonForwardFactory() {
		super();
	}

	public ActionForward getOpenTicketForward(Long id) {
		ActionForward openTicketForward = new ActionForward();
		openTicketForward.setRedirect(true);
		openTicketForward.setPath("/anon/open.do?id=" + id.toString());
		return openTicketForward;
	}
}
