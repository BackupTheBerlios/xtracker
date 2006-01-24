<%@ page language="java" import="java.util.*" %>
<%@ include file="/taglibs.jsp"%>
<%@ include file="/preamble.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title.my" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>

</head>
<body>
	<%@ include file="/logo.jsp"%>
	<%@ include file="/my/navlight.jsp"%>
	
	<div class="bodycontainer">
		<html:form action="/my/saveProfile">
			<div>
				<fieldset>
					<legend><bean:message key="view.panel.label.myprofile"/></legend>
					<table>
					<tbody>
						<colgroup span="2">
							<col valign="top" align="right"></col>
							<col valign="top"></col>
						</colgroup>
						<tr>
						    <td><bean:message key="view.label.username"/></th>
						    <td><html:text name="myProfileForm" property="userName" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.realname"/></th>
						    <td><html:text name="myProfileForm" property="realName" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.initials"/></th>
						    <td><html:text name="myProfileForm" property="initials" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.password"/></th>
						    <td><html:password name="myProfileForm" property="password" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.verifypassword"/></th>
						    <td><html:password name="myProfileForm" property="verifyPassword" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.emailaddress"/></th>
						    <td><html:text name="myProfileForm" property="emailAddress" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.phone"/></th>
						    <td><html:text name="myProfileForm" property="phoneNumber" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.signature"/></th>
							<td><html:textarea name="myProfileForm" property="signature"/></td>
						</tr>
					</tbody>
					</table>
				</fieldset>
				
				<logic:equal name="myProfileForm" property="xplannerEnabled" value="true">
				<fieldset>
					<legend><bean:message key="view.panel.label.xplanner"/></legend>
					<table>
						<tbody>
						<tr>
						    <td><bean:message key="view.label.xplanner.username"/></th>
						    <td><html:text name="myProfileForm" property="xplannerUsername" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.xplanner.password"/></th>
						    <td><html:password name="myProfileForm" property="xplannerPassword" size="52" maxlength="255"/></td>
						</tr>
						</tbody>
					</table>
				</fieldset>
				</logic:equal>
				
				<logic:equal name="myProfileForm" property="jiraEnabled" value="true">
				<fieldset>
					<legend><bean:message key="view.panel.label.jira"/></legend>
					<table>
						<tbody>
							<tr>
							    <td><bean:message key="view.label.jira.username"/></th>
							    <td><html:text name="myProfileForm" property="jiraUsername" size="52" maxlength="255"/></td>
							</tr>
							<tr>
							    <td><bean:message key="view.label.jira.password"/></th>
							    <td><html:password name="myProfileForm" property="jiraPassword" size="52" maxlength="255"/></td>
							</tr>
						</tbody>
					</table>
				</fieldset>
				</logic:equal>
				
				<table>
				<tbody>
				<colgroup span="2">
					<col span="2" align="right"></col>
					<col></col>
				</colgroup>
				<tr>
				    <td>
				    <html:submit><bean:message key="view.label.update"/></html:submit>
				    </td>
				</tr>
				</tbody>
				</table>
			</div>
		</html:form>
			
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html:html>