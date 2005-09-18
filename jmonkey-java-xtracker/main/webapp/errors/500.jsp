<%@ page language="java" import="java.util.*,java.io.*,javax.servlet.jsp.*,com.jmonkey.xtracker.error.*" isErrorPage="true"%>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>

<html>
<head>
<title>XTracker Error</title>
</head>
<body>
<table width="50%" border="0" cellspacing="0" cellpadding="2">
<html:form action="/report.do">
<html:hidden name="reportErrorForm" property="reportContent"/>
<tr>
    <th colspan="2">Unhandled XTracker Error</th>
</tr>
<tr>
    <td colspan="2" valign="top">
	XTracker had an error it doesn't know how to deal with. The error is likely caused by a bug in the software or possibly a user did something perfectly logical but that wasn't anticipated during development.
	<p>
	If you would like to report this error, the following information is what will be submitted. I you don't want to report it, simply click the "Do Not Report" button below.
	</p>
	&nbsp;
	</td>
</tr>
<tr>
    <td align="right" valign="top" nowrap><strong>Report To:</strong></td>
    <td><html:text name="reportErrorForm" property="reportTo" size="52" maxlength="255"/><br/>
	<em>(Default is xtracker@pappin.ca)</em></td>
</tr>
<tr>
    <td align="right" valign="top" nowrap><strong>Report From:</strong></td>
    <td><html:text name="reportErrorForm" property="reportFrom" size="52" maxlength="255"/><br/>
	<em>(Default is the logged on user)</em></td>
</tr>
<tr>
    <td align="right" valign="top" nowrap><strong>Return To:</strong></td>
    <td><html:select name="reportErrorForm" property="returnTo">
		<html:option value="mytickets">My Tickets</html:option>
		<html:option value="login">Login</html:option>
	</html:select></td>
</tr>
<tr>
    <td colspan="2" align="right" valign="top" nowrap><html:submit property="command">
		<bean:message key="view.label.dontreporterror"/>
	</html:submit><html:submit property="command">
		<bean:message key="view.label.reporterror"/>
	</html:submit></td>
</tr>
</html:form>
</table>
<pre><bean:write name="reportErrorForm" property="reportContent"/></pre>
</body>
</html>


