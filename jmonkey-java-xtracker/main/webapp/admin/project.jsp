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
<!-- bean:message key="view.menu.label.system.configure"/ -->
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ticketlist">
	<tr>
		<th colspan="2"><%@ include file="subnav.jsp"%></th>
	</tr>
	</table>
	
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
	<tr>
	    <td valign="top" nowrap>
			<table width="100%" cellspacing="0" cellpadding="0" border="0" class="ticketlist">
			<tr>
			    <th><bean:message key="view.label.name"/></th>
			    <th><bean:message key="view.label.active"/></th>
			    <th><bean:message key="view.label.selectable"/></th>
			    <th><bean:message key="view.label.create.date"/></th>
				<th>&nbsp;</th>
			</tr>
			<logic:iterate name="projectForm" property="projectList" id="project">
			<tr>
			    <td><bean:write name="project" property="name" /></td>
			    <td><html:link action="/admin/toggle/projectActive" paramName="project" paramProperty="id" paramId="id">
							<logic:equal name="project" property="active" value="true">Active</logic:equal>
							<logic:equal name="project" property="active" value="false">Inactive</logic:equal>
						</html:link></td>
				<td><html:link action="/admin/toggle/projectSelectable" paramName="project" paramProperty="id" paramId="id">
							<logic:equal name="project" property="selectable" value="true">Visible</logic:equal>
							<logic:equal name="project" property="selectable" value="false">Hidden</logic:equal>
						</html:link></td>
			    <td><bean:write name="project" property="createDate" /></td>
				<td><html:link action="/admin/editProject" paramName="project" paramId="id" paramProperty="id"><html:img page="/images/edit.gif" border="0" alt="Edit"/></html:link></td>
			</tr>
			</logic:iterate>
			</table>
		</td>
	    <td width="100" valign="top" nowrap>
			<html:form action="/admin/addProject">
				<html:hidden name="projectForm" property="id"/>
			<table width="100%" cellspacing="0" cellpadding="0" border="0" class="boxred">
			<tr>
			    <th colspan="2" nowrap><bean:message key="view.panel.label.project"/></th>
			</tr>
			<tr>
			    <td><bean:message key="view.label.name"/></td>
			    <td><html:text name="projectForm" property="name"/></td>
			</tr>
			<tr>
			    <td colspan="2">
				<bean:message key="view.label.selectable"/> <html:checkbox name="projectForm" property="selectable"/>
				<bean:message key="view.label.active"/> <html:checkbox name="projectForm" property="active"/></td>
			</tr>
			<tr>
			    <td colspan="2" align="right" nowrap>
					<html:submit>
						<bean:message key="view.label.commit"/>
					</html:submit>
				</td>
			</tr>
			</table>
			</html:form>
		</td>
	</tr>
	</table>
	
	<%@ include file="/footer.jsp"%>
</body>
</html:html>

