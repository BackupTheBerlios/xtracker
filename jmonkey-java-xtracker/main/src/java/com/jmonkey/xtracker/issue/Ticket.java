package com.jmonkey.xtracker.issue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.jmonkey.xtracker.linking.jira.JiraLink;
import com.jmonkey.xtracker.linking.xplanner.XPlannerLink;
import com.jmonkey.xtracker.profile.Person;

public class Ticket implements Serializable {
	private Long			id				= null;
	private String			subject			= null;
	private Integer			priority		= new Integer(50);
	private Double			worked			= new Double(0);
	private Date			createDate		= new Date();
	private Date			modifyDate		= new Date();
	private Date			closedDate		= null;
	private Date			dueDate			= null;
	private Queue			queue			= null;
	private Status			status			= null;
	private Severity		severity		= null;
	private Disposition		disposition		= null;
	private Person			requestor		= null;
	private Project			project			= null;
	private List<History>	history			= new ArrayList<History>();
	private List<Person>	owners			= new ArrayList<Person>();
	private List<Person>	watchers		= new ArrayList<Person>();

	private List<Ticket>	dependsOn		= new ArrayList<Ticket>();
	private List<Ticket>	dependedOnBy	= new ArrayList<Ticket>();

	private List<Ticket>	parents			= new ArrayList<Ticket>();
	private List<Ticket>	children		= new ArrayList<Ticket>();

	private List<Ticket>	refersTo		= new ArrayList<Ticket>();
	private List<Ticket>	referredToBy	= new ArrayList<Ticket>();

	private XPlannerLink	xplannerLink	= null;
	private JiraLink		jiraLink		= null;

	public Ticket() {
		super();
	}

	public Ticket(String subject, Integer priority, Date createDate, Date modifyDate, Queue queue, Status status, Severity severity, Person requestor, Project project,
			List<History> history, List<Person> owners) {
		this.subject = subject;
		this.priority = priority;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.queue = queue;
		this.status = status;
		this.severity = severity;
		this.requestor = requestor;
		this.project = project;
		this.history = history;
		this.owners = owners;
	}

	public Ticket(String subject, Integer priority, Date createDate, Date modifyDate, List<History> history, List<Person> owners) {
		this.subject = subject;
		this.priority = priority;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.history = history;
		this.owners = owners;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Queue getQueue() {
		return this.queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Severity getSeverity() {
		return this.severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Person getRequestor() {
		return this.requestor;
	}

	public void setRequestor(Person requestor) {
		this.requestor = requestor;
	}

	public List<History> getHistory() {
		return this.history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	public List<Person> getOwners() {
		return this.owners;
	}

	public void setOwners(List<Person> owners) {
		this.owners = owners;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Disposition getDisposition() {
		return disposition;
	}

	public void setDisposition(Disposition disposition) {
		this.disposition = disposition;
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

	public Double getWorked() {
		return worked;
	}

	public void setWorked(Double worked) {
		this.worked = worked;
	}

	public List<Person> getWatchers() {
		return watchers;
	}

	public void setWatchers(List<Person> watchers) {
		this.watchers = watchers;
	}

	public List<Ticket> getChildren() {
		return children;
	}

	public void setChildren(List<Ticket> children) {
		this.children = children;
	}

	public List<Ticket> getDependedOnBy() {
		return dependedOnBy;
	}

	public void setDependedOnBy(List<Ticket> dependedOnBy) {
		this.dependedOnBy = dependedOnBy;
	}

	public List<Ticket> getDependsOn() {
		return dependsOn;
	}

	public void setDependsOn(List<Ticket> dependsOn) {
		this.dependsOn = dependsOn;
	}

	public List<Ticket> getParents() {
		return parents;
	}

	public void setParents(List<Ticket> parents) {
		this.parents = parents;
	}

	public List<Ticket> getReferredToBy() {
		return referredToBy;
	}

	public void setReferredToBy(List<Ticket> referredToBy) {
		this.referredToBy = referredToBy;
	}

	public List<Ticket> getRefersTo() {
		return refersTo;
	}

	public void setRefersTo(List<Ticket> refersTo) {
		this.refersTo = refersTo;
	}

	public XPlannerLink getXplannerLink() {
		return xplannerLink;
	}

	public void setXplannerLink(XPlannerLink xplannerLink) {
		this.xplannerLink = xplannerLink;
	}

	public JiraLink getJiraLink() {
		return jiraLink;
	}

	public void setJiraLink(JiraLink jiraLink) {
		this.jiraLink = jiraLink;
	}

}
