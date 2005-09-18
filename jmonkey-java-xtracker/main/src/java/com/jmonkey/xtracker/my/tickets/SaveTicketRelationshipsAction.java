package com.jmonkey.xtracker.my.tickets;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.ObjectNotFoundException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.auth.AuthEnvironment;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.issue.persistor.TicketPersistor;
import com.jmonkey.xtracker.profile.Person;
import com.jmonkey.xtracker.profile.loader.PersonLoader;
import com.jmonkey.xtracker.util.StringList;

public class SaveTicketRelationshipsAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(SaveTicketRelationshipsAction.class);

	public SaveTicketRelationshipsAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 * @todo See ticket #12 http://dev.pappin.ca/xtracker/open.do?id=12
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse reponse) throws Exception {
		logger.debug("Save called...");
		TicketRelationshipsForm ticketRelationshipsForm = (TicketRelationshipsForm) form;

		String dependsOn = ticketRelationshipsForm.getDependsOn();
		String parent = ticketRelationshipsForm.getParents();
		String refersTo = ticketRelationshipsForm.getRefersTo();
		// String dependedOnBy = ticketRelationshipsForm.getDependedOnBy();
		// String children = ticketRelationshipsForm.getChildren();
		// String referredToBy = ticketRelationshipsForm.getReferredToBy();

		Long ticketId = ticketRelationshipsForm.getId();
		TicketLoader ticketLoader = new TicketLoader();
		ticketLoader.open();
		Ticket ticket = ticketLoader.loadTicket(ticketId);

		determinDependsOnRefs(dependsOn, ticketLoader, ticket);
		determinParentRefs(parent, ticketLoader, ticket);
		determinRefersToRefs(refersTo, ticketLoader, ticket);

		AuthEnvironment authEnv = new AuthEnvironment(request);
		PersonLoader personLoader = new PersonLoader();
		Person principal = personLoader.loadPersonForPrincipal(authEnv.getPrincipal());
		String historySubject = principal.getRealname() + " changed Relationships";
		addHistoryToTicket(ticket, new Date(), historySubject, null, new Integer(3));

		TicketPersistor ticketPersistor = new TicketPersistor();
		ticketPersistor.updateTicket(ticket);
		ticketPersistor.close();
		ActionForwardFactory forwardFactory = new ActionForwardFactory();
		return forwardFactory.getOpenTicketForward(ticketId);
	}

	private void determinDependsOnRefs(String dependsOn, TicketLoader ticketLoader, Ticket ticket) throws HibernateException {
		StringList stringList = new StringList();
		stringList.setBuffer(dependsOn);
		long[] dependsOnArray = stringList.getLongArray();
		removeUnreferencedDepends(ticket, dependsOnArray);
		addReferencedDepends(ticketLoader, ticket, dependsOnArray);
	}

	private void addReferencedDepends(TicketLoader ticketLoader, Ticket ticket, long[] dependsOnArray) throws HibernateException {
		List<Ticket> dependsOnTickets = ticket.getDependsOn();
		for (long id : dependsOnArray) {
			boolean ticketNotInArray = true;
			for (Ticket t : dependsOnTickets) {
				long tid = t.getId();
				if (id == tid) {
					ticketNotInArray = false;
					break;
				}
			}
			if (ticketNotInArray) {
				try {
					Ticket refTicket = ticketLoader.loadTicket(id);
					dependsOnTickets.add(refTicket);
					refTicket.getDependedOnBy().add(ticket);
				} catch (ObjectNotFoundException e) {
					// XXX This should send the user back to the ticket
					// relationships dialog with the error indicated.
					logger.warn("Ignored add reference for non existant ticket: " + id);
				}
			}
		}
	}

	private void removeUnreferencedDepends(Ticket ticket, long[] dependsOnArray) {
		List<Ticket> dependsOnTickets = ticket.getDependsOn();
		if (dependsOnArray.length == 0) {
			for (Ticket childTicket : dependsOnTickets) {
				childTicket.getDependedOnBy().remove(ticket);
			}
			dependsOnTickets.clear();
		} else {
			List<Ticket> idsToRemove = new ArrayList<Ticket>();
			for (int i = 0; i < dependsOnTickets.size(); i++) {
				Ticket t = dependsOnTickets.get(i);
				long id = t.getId();
				boolean ticketInArray = false;
				for (long did : dependsOnArray) {
					if (id == did) {
						ticketInArray = true;
						break;
					}
				}
				if (!ticketInArray) {
					idsToRemove.add(t);
				}
			}
			for (Ticket rt : idsToRemove) {
				rt.getDependedOnBy().remove(ticket);
				dependsOnTickets.remove(rt);
			}
		}
	}

	private void determinParentRefs(String parent, TicketLoader ticketLoader, Ticket ticket) throws HibernateException {
		StringList stringList = new StringList();
		stringList.setBuffer(parent);
		long[] parentArray = stringList.getLongArray();

		removeUnreferencedSiblings(ticket, parentArray);
		addReferencedSiblings(ticketLoader, ticket, parentArray);
	}

	private void addReferencedSiblings(TicketLoader ticketLoader, Ticket ticket, long[] parentArray) throws HibernateException {
		List<Ticket> parentTickets = ticket.getParents();
		for (long id : parentArray) {
			boolean ticketNotInArray = true;
			for (Ticket t : parentTickets) {
				long tid = t.getId();
				if (id == tid) {
					ticketNotInArray = false;
					break;
				}
			}
			if (ticketNotInArray) {
				try {
					Ticket refTicket = ticketLoader.loadTicket(id);
					parentTickets.add(refTicket);
					refTicket.getChildren().add(ticket);
				} catch (ObjectNotFoundException e) {
					// XXX This should send the user back to the ticket
					// relationships dialog with the error indicated.
					logger.warn("Ignored add reference for non existant ticket: " + id);
				}
			}
		}
	}

	private void removeUnreferencedSiblings(Ticket ticket, long[] parentArray) {
		List<Ticket> parentTickets = ticket.getParents();
		if (parentArray.length == 0) {
			for (Ticket childTicket : parentTickets) {
				childTicket.getChildren().remove(ticket);
			}
			parentTickets.clear();
		} else {
			List<Ticket> ticketsToRemove = new ArrayList<Ticket>();
			for (int i = 0; i < parentTickets.size(); i++) {
				Ticket t = parentTickets.get(i);
				long id = t.getId();
				boolean ticketInArray = false;
				for (long did : parentArray) {
					if (id == did) {
						ticketInArray = true;
						break;
					}
				}
				if (!ticketInArray) {
					ticketsToRemove.add(t);
				}
			}
			for (Ticket rt : ticketsToRemove) {
				rt.getChildren().remove(ticket);
				parentTickets.remove(rt);
			}
		}
	}

	private void determinRefersToRefs(String refersTo, TicketLoader ticketLoader, Ticket ticket) throws HibernateException {
		StringList stringList = new StringList();
		stringList.setBuffer(refersTo);
		long[] refersToArray = stringList.getLongArray();
		removeUnreferencedReferrers(ticket, refersToArray);
		addReferencedReferrers(ticketLoader, ticket, refersToArray);
	}

	private void addReferencedReferrers(TicketLoader ticketLoader, Ticket ticket, long[] refersToArray) throws HibernateException {
		List<Ticket> refersToTickets = ticket.getRefersTo();
		for (long id : refersToArray) {
			boolean ticketNotInArray = true;
			for (Ticket t : refersToTickets) {
				long tid = t.getId();
				if (id == tid) {
					ticketNotInArray = false;
					break;
				}
			}
			if (ticketNotInArray) {
				try {
					Ticket refTicket = ticketLoader.loadTicket(id);
					refersToTickets.add(refTicket);
					refTicket.getReferredToBy().add(ticket);
				} catch (ObjectNotFoundException e) {
					// XXX This should send the user back to the ticket
					// relationships dialog with the error indicated.
					logger.warn("Ignored add reference for non existant ticket: " + id);
				}
			}
		}
	}

	private List<Ticket> removeUnreferencedReferrers(Ticket ticket, long[] refersToArray) {
		List<Ticket> refersToTickets = ticket.getRefersTo();
		if (refersToArray.length == 0) {
			for (Ticket childTicket : refersToTickets) {
				childTicket.getReferredToBy().remove(ticket);
			}
			refersToTickets.clear();
		} else {
			List<Ticket> ticketsToRemove = new ArrayList<Ticket>();
			for (int i = 0; i < refersToTickets.size(); i++) {
				Ticket t = refersToTickets.get(i);
				long id = t.getId();
				boolean ticketInArray = false;
				for (long did : refersToArray) {
					if (id == did) {
						ticketInArray = true;
						break;
					}
				}
				if (!ticketInArray) {
					ticketsToRemove.add(t);
				}
			}
			for (Ticket rt : ticketsToRemove) {
				rt.getReferredToBy().remove(ticket);
				refersToTickets.remove(rt);
			}
		}
		return refersToTickets;
	}
}
