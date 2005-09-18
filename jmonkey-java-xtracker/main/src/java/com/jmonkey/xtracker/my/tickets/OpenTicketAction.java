package com.jmonkey.xtracker.my.tickets;

import java.util.Date;
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
import com.jmonkey.xtracker.linking.LinkingConfig;
import com.jmonkey.xtracker.linking.jira.JiraLink;
import com.jmonkey.xtracker.linking.xplanner.XPlannerLink;
import com.jmonkey.xtracker.util.DateFormatter;
import com.jmonkey.xtracker.util.TicketUtil;

public class OpenTicketAction extends BaseAction {
	private Logger	logger	= LogManager.getLogger(OpenTicketAction.class);

	public OpenTicketAction() {
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
		OpenTicketForm openTicketForm = (OpenTicketForm) form;

		Long ticketId = openTicketForm.getId();

		TicketLoader ticketLoader = new TicketLoader();
		Ticket ticket = ticketLoader.loadTicket(ticketId);

		BeanUtils.copyProperties(openTicketForm, ticket);

		DateFormatter formatter = new DateFormatter();
		openTicketForm.setCreateDate(formatter.formatStandardDateTime(ticket.getCreateDate()));
		openTicketForm.setModifyDate(formatter.formatStandardDateTime(ticket.getModifyDate()));

		LinkingConfig linkingConfig = new LinkingConfig();
		populateXPlannerLink(openTicketForm, ticket, linkingConfig);
		populateJiraLink(openTicketForm, ticket, linkingConfig);

		Date closeDate = ticket.getClosedDate();
		if (closeDate != null) {
			String date = formatter.formatStandardDateTime(closeDate);
			openTicketForm.setClosedDate(date);
		}
		Date dueDate = ticket.getDueDate();
		if (dueDate != null) {
			String date = formatter.formatStandardDate(dueDate);
			openTicketForm.setDueDate(date);
		}

		List<Ticket> dependsOn = ticket.getDependsOn();
		openTicketForm.setDependsOn(TicketUtil.getTicketIdList(dependsOn));

		List<Ticket> dependedOnBy = ticket.getDependedOnBy();
		openTicketForm.setDependedOnBy(TicketUtil.getTicketIdList(dependedOnBy));

		List<Ticket> parents = ticket.getParents();
		openTicketForm.setParents(TicketUtil.getTicketIdList(parents));

		List<Ticket> children = ticket.getChildren();
		openTicketForm.setChildren(TicketUtil.getTicketIdList(children));

		List<Ticket> refersTo = ticket.getRefersTo();
		openTicketForm.setRefersTo(TicketUtil.getTicketIdList(refersTo));

		List<Ticket> referredToBy = ticket.getReferredToBy();
		openTicketForm.setReferredToBy(TicketUtil.getTicketIdList(referredToBy));

		QueueLoader queueLoader = new QueueLoader();
		List<Queue> queueList = queueLoader.loadQueueList(false, false);
		MyTicketsForm myTicketsForm = new MyTicketsForm();
		myTicketsForm.setQueueList(queueList);

		request.getSession().setAttribute("openTicketForm", openTicketForm);
		request.getSession().setAttribute("myTicketsForm", myTicketsForm);
		return mapping.findForward("input");
	}

	private void populateJiraLink(OpenTicketForm openTicketForm, Ticket ticket, LinkingConfig linkingConfig) {
		JiraLink jiraLink = ticket.getJiraLink();
		openTicketForm.setJiraEnabled(linkingConfig.isJiraEnabled());
		if (linkingConfig.isJiraEnabled() && (jiraLink != null)) {
			String jiraContext = linkingConfig.getJiraContext();
			String key = jiraLink.getKey();
			ExteranlLinkInfo info = new ExteranlLinkInfo();
			info.setUri(jiraContext + "/browse/" + key);
			info.setLabel(jiraLink.getName());
			openTicketForm.setJiraLinkInfo(info);
		}
	}

	private void populateXPlannerLink(OpenTicketForm openTicketForm, Ticket ticket, LinkingConfig linkingConfig) {
		XPlannerLink xplannerLink = ticket.getXplannerLink();
		openTicketForm.setXplannerEnabled(linkingConfig.isXplannerEnabled());
		if (linkingConfig.isXplannerEnabled() && (xplannerLink != null)) {
			String xpContext = linkingConfig.getXplannerContext();
			Integer oid = xplannerLink.getOid();
			// openTicketForm.setXplannerLinkUri(xpContext +
			// "/do/search/id?searchedId=" + oid.toString());
			ExteranlLinkInfo info = new ExteranlLinkInfo();
			info.setUri(xpContext + "/do/search/id?searchedId=" + oid.toString());
			info.setLabel(xplannerLink.getName());
			openTicketForm.setXplannerLinkInfo(info);
		}
	}
}
