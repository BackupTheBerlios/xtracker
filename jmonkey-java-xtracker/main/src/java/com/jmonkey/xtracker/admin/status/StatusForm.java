package com.jmonkey.xtracker.admin.status;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class StatusForm extends ActionForm {
	private List	statusList	= new ArrayList();
	private long	id			= -1;
	private String	label;
	private String	colour		= null;
	private boolean	selectable	= false;
	private boolean	active		= false;

	public StatusForm() {
		super();
	}

	public List getStatusList() {
		return statusList;
	}

	public void setStatusList(List statusList) {
		this.statusList = statusList;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
