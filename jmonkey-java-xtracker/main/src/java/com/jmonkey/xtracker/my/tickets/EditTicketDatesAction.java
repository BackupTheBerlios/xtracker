package com.jmonkey.xtracker.my.tickets;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.util.DateFormatter;

public class EditTicketDatesAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(EditTicketDatesAction.class);

	public EditTicketDatesAction() {
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
		logger.debug("Edit called...");
		TicketDatesForm ticketDatesForm = (TicketDatesForm) form;
		Long ticketId = ticketDatesForm.getId();

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);

		DateFormatter formatter = new DateFormatter();
		ticketDatesForm.setCreateDate(formatter.formatStandardDateTime(ticket.getCreateDate()));
		ticketDatesForm.setModifyDate(formatter.formatStandardDateTime(ticket.getModifyDate()));

		Date closeDate = ticket.getClosedDate();
		if (closeDate != null) {
			String date = formatter.formatStandardDateTime(closeDate);
			ticketDatesForm.setClosedDate(date);
		}
		Date dueDate = ticket.getDueDate();
		if (dueDate != null) {
			String date = formatter.formatStandardDate(dueDate);
			ticketDatesForm.setDueDate(date);
		}

		request.getSession().setAttribute("ticketDatesForm", ticketDatesForm);
		return mapping.findForward("input");
	}
}
