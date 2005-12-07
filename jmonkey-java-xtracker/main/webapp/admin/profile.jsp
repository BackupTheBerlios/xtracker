<%@ page language="java" import="java.util.*" %>
<%@ include file="/taglibs.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title.admin" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>
</head>
<body>
	<%@ include file="basic_header.jsp"%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ticketlist">
	<tr>
		<th colspan="3"><bean:message key="view.panel.label.profile"/></th>
		<th align="right" colspan="2"><html:link page="/admin/addProfile.do"><html:img page="/images/person.gif" border="0" alt="Add Person"/> <bean:message key="view.menu.label.users.add" /></html:link></th>
	</tr>
	<tr>
		<th><bean:message key="view.label.username"/></th>
		<th><bean:message key="view.label.initials"/></th>
		<th><bean:message key="view.label.realname"/></th>
		<th><bean:message key="view.label.created"/></th>
		<th>&nbsp;</th>
	</tr>
	<logic:iterate name="profileForm" property="personList" id="person">
	<tr>
		<td><bean:write name="person" property="username" /></td>
		<td><bean:write name="person" property="initials" /></td>
		<td><bean:write name="person" property="realname" /></td>
		<td><bean:write name="person" property="createDate" /></td>
		<td>
			<html:link action="/admin/editProfile" paramName="person" paramId="id" paramProperty="id"><html:img page="/images/edit.gif" border="0" alt="Edit"/></html:link>
		</th>
	</tr>
	</logic:iterate>
	</table>
	
	<%@ include file="/footer.jsp"%>
</body>
</html:html>