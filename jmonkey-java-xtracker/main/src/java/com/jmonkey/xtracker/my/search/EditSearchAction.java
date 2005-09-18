package com.jmonkey.xtracker.my.search;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EditSearchAction extends BaseSearchAction {
	private Logger	logger	= LogManager.getLogger(EditSearchAction.class);

	public EditSearchAction() {
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
		logger.debug("Search called...");
		SearchForm searchForm = (SearchForm) form;

		loadOptionLists(searchForm);
		setCurrentYearMonthDay(searchForm);

		request.getSession().setAttribute("searchForm", searchForm);

		return mapping.findForward("input");
	}
}
