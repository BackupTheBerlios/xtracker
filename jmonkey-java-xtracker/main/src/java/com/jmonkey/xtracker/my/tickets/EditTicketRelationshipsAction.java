package com.jmonkey.xtracker.my.tickets;

import java.util.List;

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
import com.jmonkey.xtracker.util.StringList;

public class EditTicketRelationshipsAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(EditTicketRelationshipsAction.class);

	public EditTicketRelationshipsAction() {
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
		TicketRelationshipsForm ticketRelationshipsForm = (TicketRelationshipsForm) form;
		Long ticketId = ticketRelationshipsForm.getId();

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);

		joinDependsOn(ticketRelationshipsForm, ticket);
		joinDependedOnBy(ticketRelationshipsForm, ticket);
		joinParents(ticketRelationshipsForm, ticket);
		joinChildren(ticketRelationshipsForm, ticket);
		joinRefersTo(ticketRelationshipsForm, ticket);
		joinReferredToBy(ticketRelationshipsForm, ticket);

		request.getSession().setAttribute("ticketRelationshipsForm", ticketRelationshipsForm);
		return mapping.findForward("input");
	}

	private void joinReferredToBy(TicketRelationshipsForm ticketRelationshipsForm, Ticket ticket) {
		List<Ticket> referredToBy = ticket.getReferredToBy();
		StringList stringList = new StringList();
		for (Ticket t : referredToBy) {
			stringList.join(t.getId());
		}
		ticketRelationshipsForm.setReferredToBy(stringList.getBuffer());
	}

	private void joinRefersTo(TicketRelationshipsForm ticketRelationshipsForm, Ticket ticket) {
		List<Ticket> refersTo = ticket.getRefersTo();
		StringList stringList = new StringList();
		for (Ticket t : refersTo) {
			stringList.join(t.getId());
		}
		ticketRelationshipsForm.setRefersTo(stringList.getBuffer());
	}

	private void joinChildren(TicketRelationshipsForm ticketRelationshipsForm, Ticket ticket) {
		List<Ticket> children = ticket.getChildren();
		StringList stringList = new StringList();
		for (Ticket t : children) {
			stringList.join(t.getId());
		}
		ticketRelationshipsForm.setChildren(stringList.getBuffer());
	}

	private void joinParents(TicketRelationshipsForm ticketRelationshipsForm, Ticket ticket) {
		List<Ticket> parents = ticket.getParents();
		StringList stringList = new StringList();
		for (Ticket t : parents) {
			stringList.join(t.getId());
		}
		ticketRelationshipsForm.setParents(stringList.getBuffer());
	}

	private void joinDependedOnBy(TicketRelationshipsForm ticketRelationshipsForm, Ticket ticket) {
		List<Ticket> dependedOnBy = ticket.getDependedOnBy();
		StringList stringList = new StringList();
		for (Ticket t : dependedOnBy) {
			stringList.join(t.getId());
		}
		ticketRelationshipsForm.setDependedOnBy(stringList.getBuffer());
	}

	private void joinDependsOn(TicketRelationshipsForm ticketRelationshipsForm, Ticket ticket) {
		StringList stringList = new StringList();
		List<Ticket> dependsOn = ticket.getDependsOn();
		for (Ticket t : dependsOn) {
			stringList.join(t.getId());
		}
		ticketRelationshipsForm.setDependsOn(stringList.getBuffer());
	}
}
