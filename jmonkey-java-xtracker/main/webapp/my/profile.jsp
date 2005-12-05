<%@ page language="java" import="java.util.*" %>
<%@ include file="/taglibs.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title.my" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>
</head>
<body>
	<%@ include file="basic_header.jsp"%>

			<table cellspacing="0" cellpadding="2" border="0">
			<html:form action="/my/saveProfile">
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.username"/></th>
			    <td valign="top"><html:text name="myProfileForm" property="userName" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.realname"/></th>
			    <td valign="top"><html:text name="myProfileForm" property="realName" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.initials"/></th>
			    <td valign="top"><html:text name="myProfileForm" property="initials" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.password"/></th>
			    <td valign="top"><html:password name="myProfileForm" property="password" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.verifypassword"/></th>
			    <td valign="top"><html:password name="myProfileForm" property="verifyPassword" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.emailaddress"/></th>
			    <td valign="top"><html:text name="myProfileForm" property="emailAddress" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.phone"/></th>
			    <td valign="top"><html:text name="myProfileForm" property="phoneNumber" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap colspan="2"><bean:message key="view.label.signature"/><br>
				<html:textarea name="myProfileForm" property="signature"/></th>
			</tr>
			<logic:equal name="myProfileForm" property="xplannerEnabled" value="true">
			<tr>
			    <th align="right" nowrap colspan="2"><bean:message key="view.panel.label.xplanner"/></th>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.xplanner.username"/></th>
			    <td valign="top"><html:text name="myProfileForm" property="xplannerUsername" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.xplanner.password"/></th>
			    <td valign="top"><html:password name="myProfileForm" property="xplannerPassword" size="52" maxlength="255"/></td>
			</tr>
			</logic:equal>
			<logic:equal name="myProfileForm" property="jiraEnabled" value="true">
			<tr>
			    <th align="right" nowrap colspan="2"><bean:message key="view.panel.label.jira"/></th>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.jira.username"/></th>
			    <td valign="top"><html:text name="myProfileForm" property="jiraUsername" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.jira.password"/></th>
			    <td valign="top"><html:password name="myProfileForm" property="jiraPassword" size="52" maxlength="255"/></td>
			</tr>
			</logic:equal>
			
			
			<tr>
			    <th align="right" nowrap colspan="2"><html:submit>
				<bean:message key="view.label.update"/>
			</html:submit></th>
			</tr>
			</html:form>
			</table>
</body>
</html:html>