package com.jmonkey.xtracker.my.tickets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.HistoryLoader;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.mail.TokenManipulator;

public class AddTicketMessageAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(AddTicketMessageAction.class);

	public AddTicketMessageAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		logger.debug("Add called...");
		TicketMessageForm ticketMessageForm = (TicketMessageForm) form;

		Long ticketId = ticketMessageForm.getId();
		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);
		String subject = ticket.getSubject();

		ticketMessageForm.setImportance(new Integer(2));
		String historyId = ticketMessageForm.getHistoryId();
		if (historyId != null) {
			HistoryLoader historyLoader = new HistoryLoader();
			History history = historyLoader.loadHistory(historyId);

			String content = history.getContent();
			ReplyStringFormatter formatter = new ReplyStringFormatter();
			formatter.setLeadingLines(3);
			formatter.setLineTerminator("\r\n");
//			formatter.setLineLength(79);
//			formatter.setPrefixString("> ");
			String replyText = formatter.format(content);

			ticketMessageForm.setContent(replyText);
			subject = history.getSubject();
		}
		setStrippedSubject(ticketMessageForm, subject);

		request.getSession().setAttribute("ticketMessageForm", ticketMessageForm);
		return mapping.findForward("input");
	}

	private void setStrippedSubject(TicketMessageForm ticketMessageForm, String subject) {
		TokenManipulator tokenMaipulator = new TokenManipulator();
		// if (tokenMaipulator.hasTicketToken(subject)) {
		ticketMessageForm.setSubject(tokenMaipulator.stripToken(subject));
		// }
	}
}
