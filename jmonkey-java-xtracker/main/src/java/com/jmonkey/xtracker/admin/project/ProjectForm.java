package com.jmonkey.xtracker.admin.project;

import java.util.List;

import org.apache.struts.action.ActionForm;

import com.jmonkey.xtracker.issue.Project;

public class ProjectForm extends ActionForm {
	private List<Project>	projectList	= null;
	private String			id			= null;
	private String			name		= null;
	private boolean			active		= false;
	private boolean			selectable	= false;

	public ProjectForm() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

}
