package com.jmonkey.xtracker.my.tickets;

import org.apache.struts.action.ActionForward;

public class ActionForwardFactory {

	public ActionForwardFactory() {
		super();
	}

	public ActionForward getOpenTicketForward(Long id) {
		ActionForward openTicketForward = new ActionForward();
		openTicketForward.setRedirect(true);
		openTicketForward.setPath("/my/openTicket.do?id=" + id.toString());
		return openTicketForward;
	}
}
