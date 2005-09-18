package com.jmonkey.xtracker.my.mailrefs;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.jmonkey.xtracker.issue.History;

public class MailReferencesForm extends ActionForm {
	private String			historyId		= null;
	private History			rootHistory		= null;
	private List<History>	referenceList	= null;

	public MailReferencesForm() {
		super();
	}

	public String getHistoryId() {
		return historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	public List<History> getReferenceList() {
		return referenceList;
	}

	public void setReferenceList(List<History> referenceList) {
		this.referenceList = referenceList;
	}

	public History getRootHistory() {
		return rootHistory;
	}

	public void setRootHistory(History rootHistory) {
		this.rootHistory = rootHistory;
	}

}
