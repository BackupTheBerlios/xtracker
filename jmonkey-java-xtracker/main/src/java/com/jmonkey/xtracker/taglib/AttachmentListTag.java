package com.jmonkey.xtracker.taglib;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

import org.apache.struts.taglib.TagUtils;
import org.apache.struts.taglib.html.BaseHandlerTag;

import com.jmonkey.xtracker.issue.History;
import com.jmonkey.xtracker.issue.attachment.AttachmentFile;
import com.jmonkey.xtracker.issue.attachment.AttachmentHandler;
import com.jmonkey.xtracker.mail.MailConfig;

public class AttachmentListTag extends BaseHandlerTag {
	private MailConfig	mailConfig	= new MailConfig();
	protected String	name		= null;
	protected String	property	= null;
	protected String	scope		= null;
	protected String	listName	= null;

	public AttachmentListTag() {
		super();
	}

	/**
	 * @see org.apache.struts.taglib.html.BaseHandlerTag#release()
	 */
	@Override
	public void release() {
		super.release();
		name = null;
		property = null;
		scope = null;
		listName = null;
		mailConfig = null;
	}

	/**
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doEndTag()
	 */
	@SuppressWarnings("unusedThrown")
	@Override
	public int doEndTag() throws JspException {
		return Tag.EVAL_PAGE;
	}

	/**
	 * @see javax.servlet.jsp.tagext.BodyTagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		// load the id dir element from the name:property pair.
		Object histObj = TagUtils.getInstance().lookup(pageContext, name, property, scope);
		if (!(histObj instanceof History)) {
			throw new JspException("Named property is not an instance of History");
		}

		History history = (History) histObj;

		// get the list of attachements and set them in the
		// listName attribute.
		AttachmentHandler handler = new AttachmentHandler();
		handler.setAttachmentRoot(mailConfig.getAttachmentRootDirectory());
		List<AttachmentFile> attachements = handler.listAttachements(history);

		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		request.setAttribute(listName, attachements);

		return Tag.EVAL_BODY_INCLUDE;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
