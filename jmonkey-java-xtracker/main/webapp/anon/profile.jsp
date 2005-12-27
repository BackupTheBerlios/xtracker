<%@ page language="java"%>
<%@ include file="/taglibs.jsp"%>
<%@ include file="/preamble.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title.anon" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/anon/theme.jsp"%>
</head>
<body>

	<%@ include file="/anon/logo.jsp"%>
	<%@ include file="/anon/nav.jsp"%>
	
	<div class="bodycontainer">
		<html:form action="/anon/saveProfile">
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
						    <td><html:text name="anonProfileForm" property="userName" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.realname"/></th>
						    <td><html:text name="anonProfileForm" property="realName" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.initials"/></th>
						    <td><html:text name="anonProfileForm" property="initials" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.password"/></th>
						    <td><html:password name="anonProfileForm" property="password" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.verifypassword"/></th>
						    <td><html:password name="anonProfileForm" property="verifyPassword" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.emailaddress"/></th>
						    <td><html:text name="anonProfileForm" property="emailAddress" size="52" maxlength="255"/></td>
						</tr>
						<tr>
						    <td><bean:message key="view.label.phone"/></th>
						    <td><html:text name="anonProfileForm" property="phoneNumber" size="52" maxlength="255"/></td>
						</tr>
					</tbody>
					</table>
				</fieldset>
				
				
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

