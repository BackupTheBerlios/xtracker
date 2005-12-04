package com.jmonkey.xtracker.ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajaxtags.helpers.AjaxXmlBuilder;
import org.ajaxtags.servlets.BaseAjaxServlet;
import org.apache.struts.util.MessageResources;

public class ToolTipsCalloutServlet extends BaseAjaxServlet {

	public ToolTipsCalloutServlet() {
		super();
	}

	@Override
	public String getXmlContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestAccessor accessor = new RequestAccessor(request);
		// ResourceBundle messages =
		// ResourceBundle.getBundle("com/jmonkey/xtracker/Messages",
		// request.getLocale());
		MessageResources messageResource = accessor.getStrutsMessageResource();

		String param = request.getParameter("q");
		String result = messageResource.getMessage("view.help.action.details");

		AjaxXmlBuilder builder = new AjaxXmlBuilder();
		builder.addItemAsCData("Callout Header", "<p>" + result + "</p><p>You asked about:<br/><b>" + param + "</b>.</p>");
		return builder.toString();

	}
}
