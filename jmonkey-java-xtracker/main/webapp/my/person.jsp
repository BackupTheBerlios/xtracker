<%@ page language="java" import="java.util.*" %>
<%@ include file="/taglibs.jsp"%>

<html:html>
<head>
<title><bean:message key="page.title" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>
</head>
<body>
	<%@ include file="basic_header.jsp"%>
	<html:form action="/my/person">
			<html:hidden property="id"/>
			
			<table border="0" cellspacing="0" cellpadding="0" class="boxblue">
					<tr>
					<td width="100" nowrap><bean:message key="view.label.active"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.active" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.selectable"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.selectable" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.username"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.username" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.realname"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.realname" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.initials"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.initials" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.signature"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.signature" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.create.date"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.createDate" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.emailaddress"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.emailAddress" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.phonenumber"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.phoneNumber" /></td>
					</tr>
				</table>
	</html:form>
	<%@ include file="footer.jsp"%>
</body>
</html:html>

