package com.jmonkey.xtracker.anon.tickets;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;

public class AddAnonTicketForm extends ActionForm {
	private List<Queue>			queueList			= null;
	private List<Project>		projectList			= null;
	private List<Severity>		severityList		= null;
	private List<Disposition>	dispositionList		= null;

	private long				severityId			= -1;
	private long				dispositionId		= -1;
	private String				queueId				= null;
	private String				projectId			= null;


	private String				subject				= null;
	private Integer				priority			= null;
	private String				content				= null;
	

	public AddAnonTicketForm() {
		super();
	}
	
	public List<Queue> getQueueList() {
		return queueList;
	}

	public void setQueueList(List<Queue> queueList) {
		this.queueList = queueList;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public List<Disposition> getDispositionList() {
		return dispositionList;
	}

	public void setDispositionList(List<Disposition> dispositionList) {
		this.dispositionList = dispositionList;
	}

	public List<Severity> getSeverityList() {
		return severityList;
	}

	public void setSeverityList(List<Severity> severityList) {
		this.severityList = severityList;
	}

	public long getDispositionId() {
		return dispositionId;
	}

	public void setDispositionId(long dispositionId) {
		this.dispositionId = dispositionId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public long getSeverityId() {
		return severityId;
	}

	public void setSeverityId(long severityId) {
		this.severityId = severityId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQueueId() {
		return queueId;
	}

	public void setQueueId(String queueId) {
		this.queueId = queueId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
}
