package com.jmonkey.xtracker.my.mailrefs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.loader.HistoryLoader;

public class MailReferencesAction extends Action {
	private Logger	logger	= LogManager.getLogger(MailReferencesAction.class);

	public MailReferencesAction() {
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
		logger.debug("Load called...");
		MailReferencesForm mailReferencesForm = (MailReferencesForm) form;

		String historyId = mailReferencesForm.getHistoryId();

		HistoryLoader historyLoader = new HistoryLoader();
		historyLoader.open();
		
		History rootHistory = historyLoader.loadHistory(historyId);
		mailReferencesForm.setRootHistory(rootHistory);

		List<History> referenceList = historyLoader.loadHistoryListByReferences(rootHistory);
		mailReferencesForm.setReferenceList(referenceList);
		
		historyLoader.close();
		request.getSession().setAttribute("mailReferencesForm", mailReferencesForm);

		return mapping.getInputForward();
	}
}
