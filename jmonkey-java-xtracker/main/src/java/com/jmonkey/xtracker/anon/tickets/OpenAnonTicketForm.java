package com.jmonkey.xtracker.anon.tickets;

import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.jmonkey.xtracker.issue.Disposition;
import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Severity;
import com.jmonkey.xtracker.issue.Status;
import com.jmonkey.xtracker.profile.Person;

public class OpenAnonTicketForm extends ActionForm {
	private Long				id				= null;
	private String				subject			= null;
	private Integer				priority		= null;
	private Double				worked			= null;
	private Date				createDate		= null;
	private Date				modifyDate		= null;
	private Date				closedDate		= null;
	private Date				dueDate			= null;
	private Queue				queue			= null;
	private Status				status			= null;
	private Severity			severity		= null;
	private Disposition			disposition		= null;
	private Person				requestor		= null;
	private Project				project			= null;
	private List<History>		history			= null;
	private List<Person>		owners			= null;
	private List<Person>		watchers		= null;
//	private List<Relationship>	relationships	= null;
	private List<Long>		dependsOn		= null;
	private List<Long>		dependedOnBy	= null;
	private List<Long>		parents			= null;
	private List<Long>		children		= null;
	private List<Long>		refersTo		= null;
	private List<Long>		referredToBy	= null;

	public OpenAnonTicketForm() {
		super();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Disposition getDisposition() {
		return disposition;
	}

	public void setDisposition(Disposition disposition) {
		this.disposition = disposition;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public List<Person> getOwners() {
		return owners;
	}

	public void setOwners(List<Person> owners) {
		this.owners = owners;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Queue getQueue() {
		return queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}

//	public List<Relationship> getRelationships() {
//		return relationships;
//	}
//
//	public void setRelationships(List<Relationship> relationships) {
//		this.relationships = relationships;
//	}

	public Person getRequestor() {
		return requestor;
	}

	public void setRequestor(Person requestor) {
		this.requestor = requestor;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Double getWorked() {
		return worked;
	}

	public void setWorked(Double worked) {
		this.worked = worked;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<Person> getWatchers() {
		return watchers;
	}

	public void setWatchers(List<Person> watchers) {
		this.watchers = watchers;
	}

	public List<Long> getChildren() {
		return children;
	}

	public void setChildren(List<Long> children) {
		this.children = children;
	}

	public List<Long> getDependedOnBy() {
		return dependedOnBy;
	}

	public void setDependedOnBy(List<Long> dependedOnBy) {
		this.dependedOnBy = dependedOnBy;
	}

	public List<Long> getDependsOn() {
		return dependsOn;
	}

	public void setDependsOn(List<Long> dependsOn) {
		this.dependsOn = dependsOn;
	}

	public List<Long> getParents() {
		return parents;
	}

	public void setParents(List<Long> parents) {
		this.parents = parents;
	}

	public List<Long> getReferredToBy() {
		return referredToBy;
	}

	public void setReferredToBy(List<Long> referredToBy) {
		this.referredToBy = referredToBy;
	}

	public List<Long> getRefersTo() {
		return refersTo;
	}

	public void setRefersTo(List<Long> refersTo) {
		this.refersTo = refersTo;
	}

}
