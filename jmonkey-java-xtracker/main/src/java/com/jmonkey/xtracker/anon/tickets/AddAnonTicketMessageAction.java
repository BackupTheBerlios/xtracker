package com.jmonkey.xtracker.anon.tickets;

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
import com.jmonkey.xtracker.my.tickets.ReplyStringFormatter;

public class AddAnonTicketMessageAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(AddAnonTicketMessageAction.class);

	public AddAnonTicketMessageAction() {
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
		AnonTicketMessageForm anonTicketMessageForm = (AnonTicketMessageForm) form;
		anonTicketMessageForm.setImportance(new Integer(2));

		Long ticketId = anonTicketMessageForm.getId();
		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);
		String subject = ticket.getSubject();

		anonTicketMessageForm.setImportance(new Integer(2));
		String historyId = anonTicketMessageForm.getHistoryId();
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

			anonTicketMessageForm.setContent(replyText);
			subject = history.getSubject();
		}
		setStrippedSubject(anonTicketMessageForm, subject);

		request.getSession().setAttribute("anonTicketMessageForm", anonTicketMessageForm);
		return mapping.findForward("input");
	}

	private void setStrippedSubject(AnonTicketMessageForm form, String subject) {
		TokenManipulator tokenMaipulator = new TokenManipulator();
		if (tokenMaipulator.hasTicketToken(subject)) {
			form.setSubject(tokenMaipulator.stripToken(subject));
		}
	}
}
