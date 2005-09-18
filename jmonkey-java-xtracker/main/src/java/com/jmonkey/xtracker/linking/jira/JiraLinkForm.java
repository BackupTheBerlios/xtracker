package com.jmonkey.xtracker.linking.jira;

import org.apache.struts.action.ActionForm;

import com.atlassian.jira.rpc.soap.beans.RemoteIssueType;
import com.atlassian.jira.rpc.soap.beans.RemotePriority;
import com.atlassian.jira.rpc.soap.beans.RemoteProject;
import com.atlassian.jira.rpc.soap.beans.RemoteStatus;

public class JiraLinkForm extends ActionForm {
	private Long				ticketId		= null;
	private String				subject			= null;
	private String				content			= null;

	private RemoteProject[]		projectList		= null;
	private String				projectId		= null;

	private RemoteIssueType[]	issueTypeList	= null;
	private String				issueTypeId		= null;

	private RemotePriority[]	priorityList	= null;
	private String				priorityId		= null;

	private RemoteStatus[]		statusList		= null;
	private String				statusId		= null;

	public JiraLinkForm() {
		super();
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIssueTypeId() {
		return issueTypeId;
	}

	public void setIssueTypeId(String issueTypeId) {
		this.issueTypeId = issueTypeId;
	}

	public RemoteIssueType[] getIssueTypeList() {
		return issueTypeList;
	}

	public void setIssueTypeList(RemoteIssueType[] issueTypes) {
		this.issueTypeList = issueTypes;
	}

	public String getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(String priorityId) {
		this.priorityId = priorityId;
	}

	public RemotePriority[] getPriorityList() {
		return priorityList;
	}

	public void setPriorityList(RemotePriority[] priorityList) {
		this.priorityList = priorityList;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public RemoteStatus[] getStatusList() {
		return statusList;
	}

	public void setStatusList(RemoteStatus[] statusList) {
		this.statusList = statusList;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public RemoteProject[] getProjectList() {
		return projectList;
	}

	public void setProjectList(RemoteProject[] projectList) {
		this.projectList = projectList;
	}

}
