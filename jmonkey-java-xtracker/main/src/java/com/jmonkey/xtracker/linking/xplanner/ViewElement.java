package com.jmonkey.xtracker.linking.xplanner;

public class ViewElement {
	private String	lable	= null;
	private Integer	value	= null;

	public ViewElement(String lable, Integer value) {
		super();
		this.lable = lable;
		this.value = value;
	}

	public String getLable() {
		return lable;
	}

	public void setLable(String lable) {
		this.lable = lable;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

}
