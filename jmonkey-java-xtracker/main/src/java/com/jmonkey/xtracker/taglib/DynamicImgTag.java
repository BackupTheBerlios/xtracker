package com.jmonkey.xtracker.taglib;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.jsp.JspException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.taglib.html.ImgTag;

public class DynamicImgTag extends ImgTag {
	private String	dynamicPrefix	= null;
	private String	dynamicSuffix	= null;
	private String	dynamicName		= null;
	private String	dynamicProperty	= null;

	public DynamicImgTag() {
		super();
	}

	/**
	 * @see org.apache.struts.taglib.html.ImgTag#url(java.lang.String)
	 */
	@Override
	protected String url(String url) throws JspException {
		String value = getDynamicValue();
		String dynamicUrl = url + (dynamicPrefix != null ? dynamicPrefix : "") + (value != null ? value : "") + (dynamicSuffix != null ? dynamicSuffix : "");
		return super.url(dynamicUrl);
	}

	private String getDynamicValue() throws JspException {
		String dynamicPart = null;
		Object bean = pageContext.findAttribute(dynamicName);
		if (bean == null) {
			throw new JspException("Could not find bean with name " + dynamicName + " in any scope.");
		}
		if (dynamicProperty == null) {
			dynamicPart = bean.toString();
		} else {
			try {
				dynamicPart = PropertyUtils.getProperty(bean, dynamicProperty).toString();
			} catch (IllegalAccessException e) {
				throw new JspException(e);
			} catch (InvocationTargetException e) {
				throw new JspException(e);
			} catch (NoSuchMethodException e) {
				throw new JspException(e);
			}
		}
		return dynamicPart;
	}

	public String getDynamicPrefix() {
		return dynamicPrefix;
	}

	public void setDynamicPrefix(String prefix) {
		this.dynamicPrefix = prefix;
	}

	public String getDynamicName() {
		return dynamicName;
	}

	public void setDynamicName(String dynamicName) {
		this.dynamicName = dynamicName;
	}

	public String getDynamicProperty() {
		return dynamicProperty;
	}

	public void setDynamicProperty(String dynamicProperty) {
		this.dynamicProperty = dynamicProperty;
	}

	public String getDynamicSuffix() {
		return dynamicSuffix;
	}

	public void setDynamicSuffix(String suffix) {
		this.dynamicSuffix = suffix;
	}
}
