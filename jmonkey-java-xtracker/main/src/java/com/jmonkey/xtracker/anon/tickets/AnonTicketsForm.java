package com.jmonkey.xtracker.anon.tickets;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.jmonkey.xtracker.issue.Ticket;

public class AnonTicketsForm extends ActionForm {
	private List<Ticket>	ticketList	= null;

	public AnonTicketsForm() {
		super();
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}
}
