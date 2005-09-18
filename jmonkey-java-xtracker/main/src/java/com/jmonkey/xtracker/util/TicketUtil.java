package com.jmonkey.xtracker.util;

import java.util.ArrayList;
import java.util.List;

import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;

public class TicketUtil {

	public TicketUtil() {
		super();
	}

	public static List<Long> getTicketIdList(List<Ticket> ticketList) {
		List<Long> idList = new ArrayList<Long>();
		for (Ticket t : ticketList) {
			idList.add(t.getId());
		}
		return idList;
	}

	public static boolean isTicketClosed(Ticket ticket) {
		long id = ticket.getStatus().getId();
		if (id == 3 || id == 4 || id == 6) {
			return true;
		}
		return false;
	}
}
