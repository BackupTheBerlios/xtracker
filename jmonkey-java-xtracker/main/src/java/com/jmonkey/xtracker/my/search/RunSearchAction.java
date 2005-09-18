package com.jmonkey.xtracker.my.search;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.issue.loader.TicketLoader;

public class RunSearchAction extends BaseSearchAction {

	private Logger	logger	= LogManager.getLogger(RunSearchAction.class);

	public RunSearchAction() {
		super();
	}

	/**
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug("Running search...");
		SearchForm searchForm = (SearchForm) form;

		Map<String, SearchCriteria> criteriaMap = new TreeMap<String, SearchCriteria>();

		if (isSpecified(searchForm.getSubject())) {
			criteriaMap.put(SearchCriteria.SUBJECT, new SearchCriteria(searchForm.getSubject(), searchForm.getSubjectOp()));
		}
		if (isSpecified(searchForm.getPriority())) {
			criteriaMap.put(SearchCriteria.PRIORITY, new SearchCriteria(searchForm.getPriority(), searchForm.getPriorityOp()));
		}
		if (isSpecified(searchForm.getQueueId())) {
			criteriaMap.put(SearchCriteria.QUEUE, new SearchCriteria(searchForm.getQueueId(), searchForm.getQueueOp()));
		}
		if (isSpecified(searchForm.getProjectId())) {
			criteriaMap.put(SearchCriteria.PROJECT, new SearchCriteria(searchForm.getProjectId(), searchForm.getProjectOp()));
		}
		if (isSpecified(searchForm.getStatusId())) {
			criteriaMap.put(SearchCriteria.STATUS, new SearchCriteria(searchForm.getStatusId(), searchForm.getStatusOp()));
		}
		if (isSpecified(searchForm.getSeverityId())) {
			criteriaMap.put(SearchCriteria.SEVERITY, new SearchCriteria(searchForm.getSeverityId(), searchForm.getSeverityOp()));
		}
		if (isSpecified(searchForm.getDispositionId())) {
			criteriaMap.put(SearchCriteria.DISPOSITION, new SearchCriteria(searchForm.getDispositionId(), searchForm.getDispositionOp()));
		}
		if (isSpecified(searchForm.getRequestorId())) {
			criteriaMap.put(SearchCriteria.REQUESTOR, new SearchCriteria(searchForm.getRequestorId(), searchForm.getRequestorOp()));
		}
		if (isSpecified(searchForm.getOwnerId())) {
			criteriaMap.put(SearchCriteria.OWNER, new SearchCriteria(searchForm.getOwnerId(), searchForm.getOwnerOp()));
		}
		if (isSpecified(searchForm.getWatcherId())) {
			criteriaMap.put(SearchCriteria.WATCHER, new SearchCriteria(searchForm.getWatcherId(), searchForm.getWatcherOp()));
		}
		if (isSpecified(searchForm.getWorked())) {
			criteriaMap.put(SearchCriteria.WORKED, new SearchCriteria(searchForm.getWorked(), searchForm.getWorkedOp()));
		}
		if (isSpecified(searchForm.getCreateDate())) {
			criteriaMap.put(SearchCriteria.CREATE_DATE, new SearchCriteria(searchForm.getCreateDate(), searchForm.getCreateDateOp()));
		}
		if (isSpecified(searchForm.getModifyDate())) {
			criteriaMap.put(SearchCriteria.MODIFY_DATE, new SearchCriteria(searchForm.getModifyDate(), searchForm.getModifyDateOp()));
		}
		if (isSpecified(searchForm.getClosedDate())) {
			criteriaMap.put(SearchCriteria.CLOSED_DATE, new SearchCriteria(searchForm.getClosedDate(), searchForm.getClosedDateOp()));
		}
		if (isSpecified(searchForm.getDueDate())) {
			criteriaMap.put(SearchCriteria.DUE_DATE, new SearchCriteria(searchForm.getDueDate(), searchForm.getDueDateOp()));
		}

		TicketLoader ticketLoader = new TicketLoader();
		List<Ticket> searchResults = ticketLoader.searchForTickets(criteriaMap);
		logger.debug("Found " + searchResults.size() + " items in search...");
		searchForm.setSearchResults(searchResults);

		loadOptionLists(searchForm);
		setCurrentYearMonthDay(searchForm);

		request.getSession().setAttribute("searchForm", searchForm);

		return mapping.findForward("input");
	}

	private boolean isSpecified(Object value) {
		boolean specified = false;
		if (value instanceof String) {
			specified = ((value != null) && (((String) value).length() > 0));
		}
		return specified;
	}
}
