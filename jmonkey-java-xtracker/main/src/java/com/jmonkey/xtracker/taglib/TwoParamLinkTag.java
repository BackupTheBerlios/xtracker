package com.jmonkey.xtracker.taglib;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.LinkTag;
import org.apache.struts.taglib.logic.IterateTag;

public class TwoParamLinkTag extends LinkTag {
	protected String	param1Id		= null;
	protected String	param1Name		= null;
	protected String	param1Property	= null;
	protected String	param1Scope		= null;

	@Override
	public void release() {
		super.release();
		param1Id = null;
		param1Name = null;
		param1Property = null;
		param1Scope = null;

	}

	@SuppressWarnings("unchecked")
	@Override
	protected String calculateURL() throws JspException {

		// Identify the parameters we will add to the completed URL
		Map params = TagUtils.getInstance().computeParameters(pageContext, paramId, paramName, paramProperty, paramScope, name, property, scope, transaction);
		Map params1 = TagUtils.getInstance().computeParameters(pageContext, param1Id, param1Name, param1Property, param1Scope, null, null, null, false);
		if (params != null && params1 != null) {
			params.putAll(params1);
		} else if (params == null && params1 != null) {
			params = params1;
		}

		// if "indexed=true", add "index=x" parameter to query string
		// * @since Struts 1.1
		if (indexed) {
			// look for outer iterate tag
			IterateTag iterateTag = (IterateTag) findAncestorWithClass(this, IterateTag.class);
			if (iterateTag == null) {
				// This tag should only be nested in an iterate tag
				// If it's not, throw exception
				JspException e = new JspException(messages.getMessage("indexed.noEnclosingIterate"));
				TagUtils.getInstance().saveException(pageContext, e);
				throw e;
			}

			// calculate index, and add as a parameter
			if (params == null) {
				params = new HashMap(); // create new HashMap if no other params
			}
			if (indexId != null) {
				params.put(indexId, Integer.toString(iterateTag.getIndex()));
			} else {
				params.put("index", Integer.toString(iterateTag.getIndex()));
			}
		}

		String url = null;
		try {
			url = TagUtils.getInstance().computeURLWithCharEncoding(pageContext, getForward(), getHref(), getPage(), getAction(), module, params, getAnchor(), false, isUseLocalEncoding());
		} catch (MalformedURLException e) {
			TagUtils.getInstance().saveException(pageContext, e);
			throw new JspException(messages.getMessage("rewrite.url", e.toString()));
		}
		return (url);

	}

	public String getParam1Id() {
		return param1Id;
	}

	public void setParam1Id(String param1Id) {
		this.param1Id = param1Id;
	}

	public String getParam1Name() {
		return param1Name;
	}

	public void setParam1Name(String param1Name) {
		this.param1Name = param1Name;
	}

	public String getParam1Property() {
		return param1Property;
	}

	public void setParam1Property(String param1Property) {
		this.param1Property = param1Property;
	}

	public String getParam1Scope() {
		return param1Scope;
	}

	public void setParam1Scope(String param1Scope) {
		this.param1Scope = param1Scope;
	}

}
