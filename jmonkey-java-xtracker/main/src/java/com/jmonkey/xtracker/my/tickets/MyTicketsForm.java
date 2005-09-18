package com.jmonkey.xtracker.my.tickets;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.profile.Person;

public class MyTicketsForm extends ActionForm {
	private List<Ticket>		ticketList				= null;
	private List<Ticket>		watchedTicketList		= null;
	private List<Ticket>		requestedTicketList		= null;
	private List<Ticket>		unassignedTicketList	= null;
	private List<Queue>			queueList				= null;
	private List<Project>		projectList				= null;
	private List<Status>		statusList				= null;
	private List<Severity>		severityList			= null;
	private List<Disposition>	dispositionList			= null;
	private List<Person>		personList				= null;

	private long				statusId				= -1;
	private long				severityId				= -1;
	private long				dispositionId			= -1;
	private String				projectId				= null;
	private String				ownerId					= null;

	private String				subject					= null;
	private Integer				priority				= null;

	private String				content					= null;
	private String				queueId					= null;

	public MyTicketsForm() {
		super();
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public List<Ticket> getWatchedTicketList() {
		return watchedTicketList;
	}

	public void setWatchedTicketList(List<Ticket> watchedTicketList) {
		this.watchedTicketList = watchedTicketList;
	}

	public List<Ticket> getUnassignedTicketList() {
		return unassignedTicketList;
	}

	public void setUnassignedTicketList(List<Ticket> unassignedTicketList) {
		this.unassignedTicketList = unassignedTicketList;
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

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
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

	public long getDispositionId() {
		return dispositionId;
	}

	public void setDispositionId(long dispositionId) {
		this.dispositionId = dispositionId;
	}

	// public String getHistory() {
	// return history;
	// }
	//
	// public void setHistory(String history) {
	// this.history = history;
	// }

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
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

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
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

	public List<Ticket> getRequestedTicketList() {
		return requestedTicketList;
	}

	public void setRequestedTicketList(List<Ticket> requestedTicketList) {
		this.requestedTicketList = requestedTicketList;
	}

}
