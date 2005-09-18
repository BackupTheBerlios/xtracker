package com.jmonkey.xtracker.linking.xplanner;


import com.jmonkey.xtracker.linking.BaseLink;

public class XPlannerLink extends BaseLink{
	private Integer	oid		= null;
	private String	name	= null;
	public XPlannerLink() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

}
