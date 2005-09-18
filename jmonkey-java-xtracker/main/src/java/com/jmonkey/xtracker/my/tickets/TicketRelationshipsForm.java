package com.jmonkey.xtracker.my.tickets;

import org.apache.struts.action.ActionForm;

// import com.jmonkey.xtracker.issue.Relationship;

public class TicketRelationshipsForm extends ActionForm {
	private Long	id				= null;
	private String	dependsOn		= null;
	private String	dependedOnBy	= null;
	private String	parents			= null;
	private String	children		= null;
	private String	refersTo		= null;
	private String	referredToBy	= null;

	// private List<Relationship> relationships = null;

	public TicketRelationshipsForm() {
		super();
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getDependedOnBy() {
		return dependedOnBy;
	}

	public void setDependedOnBy(String dependedOnBy) {
		this.dependedOnBy = dependedOnBy;
	}

	public String getDependsOn() {
		return dependsOn;
	}

	public void setDependsOn(String dependsOn) {
		this.dependsOn = dependsOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getParents() {
		return parents;
	}

	public void setParents(String parents) {
		this.parents = parents;
	}

	public String getReferredToBy() {
		return referredToBy;
	}

	public void setReferredToBy(String referredToBy) {
		this.referredToBy = referredToBy;
	}

	public String getRefersTo() {
		return refersTo;
	}

	public void setRefersTo(String refersTo) {
		this.refersTo = refersTo;
	}

	// public List<Relationship> getRelationships() {
	// return relationships;
	// }
	//
	// public void setRelationships(List<Relationship> relationships) {
	// this.relationships = relationships;
	// }

}
