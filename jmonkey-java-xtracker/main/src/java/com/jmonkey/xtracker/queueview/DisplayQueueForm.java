package com.jmonkey.xtracker.queueview;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.jmonkey.xtracker.issue.Project;
import com.jmonkey.xtracker.issue.Queue;
import com.jmonkey.xtracker.issue.Ticket;

public class DisplayQueueForm extends ActionForm {
	private String			id			= null;
	private List<Ticket>	ticketList	= null;
	private List<Queue>		queueList	= null;
	private List<Project>	projectList	= null;

	public DisplayQueueForm() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
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

}
