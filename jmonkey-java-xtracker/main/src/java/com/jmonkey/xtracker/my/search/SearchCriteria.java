package com.jmonkey.xtracker.my.search;

public class SearchCriteria {
	public static final String	WATCHER		= "watcher";
	public static final String	OWNER		= "owner";
	public static final String	REQUESTOR	= "requestor";
	public static final String	DISPOSITION	= "disposition";
	public static final String	SEVERITY	= "severity";
	public static final String	STATUS		= "status";
	public static final String	PROJECT		= "project";
	public static final String	QUEUE		= "queue";
	public static final String	PRIORITY	= "priority";
	public static final String	SUBJECT		= "subject";
	public static final String	WORKED		= "worked";
	public static final String	CREATE_DATE	= "created";
	public static final String	MODIFY_DATE	= "modified";
	public static final String	CLOSED_DATE	= "closed";
	public static final String	DUE_DATE	= "due";

	private String				operation	= null;
	private Object				value		= null;

	public SearchCriteria(Object value, String operation) {
		super();
		this.operation = operation;
		this.value = value;
	}

	public String getOperation() {
		return operation;
	}

	public Object getValue() {
		return value;
	}

	public String getPrintableString() {
		return "SearchCriteria[operation=" + operation + ", value=" + value + "]@" + hashCode();
	}
}
