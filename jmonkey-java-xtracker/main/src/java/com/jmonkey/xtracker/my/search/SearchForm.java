package com.jmonkey.xtracker.my.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.issue.Ticket;
import com.jmonkey.xtracker.profile.Person;

public class SearchForm extends ActionForm {
	private String				subject			= null;
	private String				subjectOp		= null;
	private String				priority		= null;
	private String				priorityOp		= null;
	private String				worked			= null;
	private String				workedOp		= null;

	private String				createDate		= null;
	private String				createDateOp	= null;
	private String				modifyDate		= null;
	private String				modifyDateOp	= null;
	private String				closedDate		= null;
	private String				closedDateOp	= null;
	private String				dueDate			= null;
	private String				dueDateOp		= null;

	private String				queueId			= null;
	private String				queueOp			= null;
	private String				projectId		= null;
	private String				projectOp		= null;
	private String				statusId		= null;
	private String				statusOp		= null;
	private String				severityId		= null;
	private String				severityOp		= null;
	private String				dispositionId	= null;
	private String				dispositionOp	= null;
	private String				requestorId		= null;
	private String				requestorOp		= null;
	private String				ownerId			= null;
	private String				ownerOp			= null;
	private String				watcherId		= null;
	private String				watcherOp		= null;

	private List<Queue>			queueList		= new ArrayList<Queue>();
	private List<Status>		statusList		= new ArrayList<Status>();
	private List<Severity>		severityList	= new ArrayList<Severity>();
	private List<Disposition>	dispositionList	= new ArrayList<Disposition>();
	private List<Project>		projectList		= new ArrayList<Project>();
	private List<Person>		personList		= new ArrayList<Person>();

	private List<Ticket>		searchResults	= new ArrayList<Ticket>();

	private String				year			= null;
	private String				month			= null;
	private String				day				= null;

	public SearchForm() {
		super();
	}

	public String getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}

	public String getClosedDateOp() {
		return closedDateOp;
	}

	public void setClosedDateOp(String closedDateOp) {
		this.closedDateOp = closedDateOp;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateDateOp() {
		return createDateOp;
	}

	public void setCreateDateOp(String createDateOp) {
		this.createDateOp = createDateOp;
	}

	public String getDispositionId() {
		return dispositionId;
	}

	public void setDispositionId(String dispositionId) {
		this.dispositionId = dispositionId;
	}

	public List<Disposition> getDispositionList() {
		return dispositionList;
	}

	public void setDispositionList(List<Disposition> dispositionList) {
		this.dispositionList = dispositionList;
	}

	public String getDispositionOp() {
		return dispositionOp;
	}

	public void setDispositionOp(String dispositionOp) {
		this.dispositionOp = dispositionOp;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDueDateOp() {
		return dueDateOp;
	}

	public void setDueDateOp(String dueDateOp) {
		this.dueDateOp = dueDateOp;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyDateOp() {
		return modifyDateOp;
	}

	public void setModifyDateOp(String modifyDateOp) {
		this.modifyDateOp = modifyDateOp;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerOp() {
		return ownerOp;
	}

	public void setOwnerOp(String ownerOp) {
		this.ownerOp = ownerOp;
	}

	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getPriorityOp() {
		return priorityOp;
	}

	public void setPriorityOp(String priorityOp) {
		this.priorityOp = priorityOp;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public String getProjectOp() {
		return projectOp;
	}

	public void setProjectOp(String projectOp) {
		this.projectOp = projectOp;
	}

	public String getQueueId() {
		return queueId;
	}

	public void setQueueId(String queueId) {
		this.queueId = queueId;
	}

	public List<Queue> getQueueList() {
		return queueList;
	}

	public void setQueueList(List<Queue> queueList) {
		this.queueList = queueList;
	}

	public String getQueueOp() {
		return queueOp;
	}

	public void setQueueOp(String queueOp) {
		this.queueOp = queueOp;
	}

	public String getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(String requestorId) {
		this.requestorId = requestorId;
	}

	public String getRequestorOp() {
		return requestorOp;
	}

	public void setRequestorOp(String requestorOp) {
		this.requestorOp = requestorOp;
	}

	public String getSeverityId() {
		return severityId;
	}

	public void setSeverityId(String severityId) {
		this.severityId = severityId;
	}

	public List<Severity> getSeverityList() {
		return severityList;
	}

	public void setSeverityList(List<Severity> severityList) {
		this.severityList = severityList;
	}

	public String getSeverityOp() {
		return severityOp;
	}

	public void setSeverityOp(String severityOp) {
		this.severityOp = severityOp;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public List<Status> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Status> statusList) {
		this.statusList = statusList;
	}

	public String getStatusOp() {
		return statusOp;
	}

	public void setStatusOp(String statusOp) {
		this.statusOp = statusOp;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubjectOp() {
		return subjectOp;
	}

	public void setSubjectOp(String subjectOp) {
		this.subjectOp = subjectOp;
	}

	public String getWatcherId() {
		return watcherId;
	}

	public void setWatcherId(String watcherId) {
		this.watcherId = watcherId;
	}

	public String getWatcherOp() {
		return watcherOp;
	}

	public void setWatcherOp(String watcherOp) {
		this.watcherOp = watcherOp;
	}

	public String getWorked() {
		return worked;
	}

	public void setWorked(String worked) {
		this.worked = worked;
	}

	public String getWorkedOp() {
		return workedOp;
	}

	public void setWorkedOp(String workedOp) {
		this.workedOp = workedOp;
	}

	public List<Ticket> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<Ticket> searchResults) {
		this.searchResults = searchResults;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getYearMonthDayString() {
		return year + "," + month + "," + day;
	}

}
