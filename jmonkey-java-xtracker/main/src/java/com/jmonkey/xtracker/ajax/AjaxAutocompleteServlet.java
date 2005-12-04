package com.jmonkey.xtracker.ajax;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.ajaxtags.servlets.BaseAjaxServlet;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;

public class AjaxAutocompleteServlet extends BaseAjaxServlet {
	private Logger	logger	= LogManager.getLogger(AjaxAutocompleteServlet.class);

	@Override
	public String getXmlContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StringBuffer xmlBuffer = new StringBuffer().append("<?xml version=\"1.0\"?>");
		xmlBuffer.append("<list>");

		String view = request.getParameter("view");
		if ((view != null) && view.toLowerCase().startsWith("Envelope-To".toLowerCase())) {
			xmlBuffer.append("<item value=\"Envelope-To\">Envelope-To</item>");
		}
		String ticketId = request.getParameter("ticket");
		if ((ticketId != null) && (ticketId.length() > 0)) {
			TicketLoader ticketLoader = new TicketLoader();
			try {
				List<Ticket> ticketList = ticketLoader.loadTicketListPartialId(Long.parseLong(ticketId), 11);
				for (Ticket ticket : ticketList) {
					xmlBuffer.append("<item value=\"" + ticket.getId() + "\">[" + ticket.getId() + "] " + ticket.getSubject() + "</item>");
				}
			} catch (NumberFormatException e) {
				logger.error("Entry \"" + ticketId + "\" is not a valid ticket id", e);
			} catch (HibernateException e) {
				logger.error("Could not load ticket ids", e);
			}

		}
		xmlBuffer.append("</list>");

		return xmlBuffer.toString();
	}

}
