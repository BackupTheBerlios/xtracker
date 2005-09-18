package com.jmonkey.xtracker.admin.disposition;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class DispositionForm extends ActionForm {
	private List	dispositionList	= new ArrayList();
	private long	id				= -1;
	private String	label			= null;
	private String	colour			= null;
	private boolean	selectable		= true;
	private boolean	active			= true;

	public DispositionForm() {
		super();
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

	public List getDispositionList() {
		return dispositionList;
	}

	public void setDispositionList(List dispositionList) {
		this.dispositionList = dispositionList;
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
