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
	<html:form action="/admin/saveProfile">
	
	<tr>
	<td colspan="6">
		<layout:tabs>
			<table width="100%" cellspacing="0" cellpadding="0" border="0">
			<tr>
			    <td valign="top" nowrap><bean:message key="view.label.default.queue"/>: <html:select name="profileForm" property="defaultQueueId">
					<html:option value="">None</html:option>
					<html:optionsCollection name="profileForm" property="queueList" value="id" label="name" />
				</html:select> <bean:message key="view.label.active"/><html:checkbox name="profileForm" property="active"/>
				<bean:message key="view.label.selectable"/><html:checkbox name="profileForm" property="selectable"/>
				<bean:message key="view.label.anonymous"/><html:checkbox name="profileForm" property="anonymous"/>
				<bean:message key="view.label.administrator"/><html:checkbox name="profileForm" property="administrator"/>
				</td>
				<tr>
			   		<td valign="top" nowrap>&nbsp;</td>
				</tr>
			</tr>
			</table>
			<layout:tab key="view.label.tab.user.identity">
						
			<table width="100%" cellspacing="0" cellpadding="0" border="0">
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.username"/></th>
			    <td valign="top"><html:text name="profileForm" property="userName" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.realname"/></th>
			    <td valign="top"><html:text name="profileForm" property="realName" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.initials"/></th>
			    <td valign="top"><html:text name="profileForm" property="initials" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.password"/></th>
			    <td valign="top"><html:password name="profileForm" property="password" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.verifypassword"/></th>
			    <td valign="top"><html:password name="profileForm" property="verifyPassword" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.emailaddress"/></th>
			    <td valign="top"><html:text name="profileForm" property="emailAddress" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap colspan="2"><bean:message key="view.label.signature"/><br>
				<html:textarea name="profileForm" property="signature"/></th>
			</tr>
			</table>
	
			</layout:tab>
			<html:submit>
				<bean:message key="view.label.save"/>
			</html:submit>
		</layout:tabs>
	
	</td>
	</tr>
	</html:form>
	</table>
	
	<%@ include file="/footer.jsp"%>
</body>
</html:html>