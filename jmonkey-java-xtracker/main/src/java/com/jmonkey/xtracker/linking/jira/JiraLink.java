package com.jmonkey.xtracker.linking.jira;

import com.jmonkey.xtracker.linking.BaseLink;

public class JiraLink extends BaseLink {
	private String	key		= null;
	private String	name	= null;

	public JiraLink() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
