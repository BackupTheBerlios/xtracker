package com.jmonkey.xtracker.template;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.jmonkey.xtracker.util.Parser;

/** @author Hibernate CodeGenerator */
public class TemplateData implements Serializable {
	private String	id;
	private String	name;
	private Parser	parser;
	private boolean	required;
	private String	content;
	private String	resourceKey	= null;

	/** full constructor */
	public TemplateData(String name, String key, Parser parser, boolean required, String content) {
		this.name = name;
		this.resourceKey = key;
		this.parser = parser;
		this.required = required;
		this.content = content;
	}

	public TemplateData() {
		super();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Parser getParser() {
		return this.parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}

	public boolean isRequired() {
		return this.required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResourceKey() {
		return resourceKey;
	}

	public void setResourceKey(String resourceKey) {
		this.resourceKey = resourceKey;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

}
