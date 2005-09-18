package com.jmonkey.xtracker.my.tickets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Ticket;

public class TicketSorter {
	private List<Ticket>	tickets	= null;

	public TicketSorter() {
		super();
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Map<Project, List<Ticket>> getTicketsWithProject() {
		Map<Project, List<Ticket>> result = new HashMap<Project, List<Ticket>>();
		Project currentProject = null;
		List<Ticket> currentList = null;
		for (int i = 0; i < tickets.size(); i++) {
			Ticket ticket = tickets.get(i);
			Project ticketProject = ticket.getProject();
			if (ticketProject != null) {
				if (currentProject == null || !currentProject.equals(ticketProject)) {
					currentProject = ticketProject;
					currentList = new ArrayList<Ticket>();
					result.put(ticketProject, currentList);
				}
				currentList.add(ticket);
			}

		}
		return result;
	}

	public List<Ticket> getTicketsWithoutProject() {
		List<Ticket> result = new ArrayList<Ticket>();
		for (int i = 0; i < tickets.size(); i++) {
			Ticket ticket = tickets.get(i);
			Project ticketProject = ticket.getProject();
			if (ticketProject == null) {
				result.add(ticket);
			}
		}
		return result;
	}
}
