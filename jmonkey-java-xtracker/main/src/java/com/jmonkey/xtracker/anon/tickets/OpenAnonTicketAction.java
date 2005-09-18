package com.jmonkey.xtracker.anon.tickets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.BaseAction;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.QueueLoader;
import com.jmonkey.xtracker.issue.loader.TicketLoader;
import com.jmonkey.xtracker.util.TicketUtil;

public class OpenAnonTicketAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(OpenAnonTicketAction.class);

	public OpenAnonTicketAction() {
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
		logger.debug("Open called...");
		OpenAnonTicketForm openAnonTicketForm = (OpenAnonTicketForm) form;

		Long ticketId = openAnonTicketForm.getId();

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);

		BeanUtils.copyProperties(openAnonTicketForm, ticket);
		
		List<Ticket> dependsOn = ticket.getDependsOn();
		openAnonTicketForm.setDependsOn(TicketUtil.getTicketIdList(dependsOn));

		List<Ticket> dependedOnBy = ticket.getDependedOnBy();
		openAnonTicketForm.setDependedOnBy(TicketUtil.getTicketIdList(dependedOnBy));

		List<Ticket> parents = ticket.getParents();
		openAnonTicketForm.setParents(TicketUtil.getTicketIdList(parents));

		List<Ticket> children = ticket.getChildren();
		openAnonTicketForm.setChildren(TicketUtil.getTicketIdList(children));

		List<Ticket> refersTo = ticket.getRefersTo();
		openAnonTicketForm.setRefersTo(TicketUtil.getTicketIdList(refersTo));

		List<Ticket> referredToBy = ticket.getReferredToBy();
		openAnonTicketForm.setReferredToBy(TicketUtil.getTicketIdList(referredToBy));

		QueueLoader queueLoader = new QueueLoader();
		List<Queue> queueList = queueLoader.loadQueueList(false,false);
		AddAnonTicketForm myTicketsForm = new AddAnonTicketForm();
		myTicketsForm.setQueueList(queueList);

		request.getSession().setAttribute("openAnonTicketForm", openAnonTicketForm);
		return mapping.findForward("input");
	}

}
