package com.jmonkey.xtracker.my.tickets;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;

public class TicketDetailsForm extends ActionForm {
	private Long				id				= null;
	private String				subject			= null;
	private Integer				priority		= null;
	private Double				worked			= null;
	private String				queueId			= null;
	private long				statusId		= -1;
	private long				severityId		= -1;
	private long				dispositionId	= -1;
	private String				projectId		= null;
	private List<Queue>			queueList		= null;
	private List<Project>		projectList		= null;
	private List<Status>		statusList		= null;
	private List<Severity>		severityList	= null;
	private List<Disposition>	dispositionList	= null;

	public TicketDetailsForm() {
		super();
	}

	public long getDispositionId() {
		return dispositionId;
	}

	public void setDispositionId(long id) {
		this.dispositionId = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setProjectId(String id) {
		this.projectId = id;
	}

	public String getQueueId() {
		return queueId;
	}

	public void setQueueId(String id) {
		this.queueId = id;
	}

	public long getSeverityId() {
		return severityId;
	}

	public void setSeverityId(long id) {
		this.severityId = id;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long id) {
		this.statusId = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<Disposition> getDispositionList() {
		return dispositionList;
	}

	public void setDispositionList(List<Disposition> dispositionList) {
		this.dispositionList = dispositionList;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public List<Queue> getQueueList() {
		return queueList;
	}

	public void setQueueList(List<Queue> queueList) {
		this.queueList = queueList;
	}

	public List<Severity> getSeverityList() {
		return severityList;
	}

	public void setSeverityList(List<Severity> severityList) {
		this.severityList = severityList;
	}

	public List<Status> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}

	public Double getWorked() {
		return worked;
	}

	public void setWorked(Double worked) {
		this.worked = worked;
	}

}
