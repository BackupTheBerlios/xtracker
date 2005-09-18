<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>

<layout:html layout="false" key="page.title.admin">
	<%@ include file="basic_header.jsp"%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ticketlist">
	<tr>
		<th><bean:message key="view.menu.label.system.configure"/></th>
		<th><bean:message key="view.menu.label.configure"/>: <html:link page="/admin/runtime.do"><bean:message key="view.menu.label.configure.runtime" /></html:link>
		| <html:link page="/admin/displayQueue.do"><bean:message key="view.menu.label.configure.queues" /></html:link>
		| <html:link page="/admin/displayProject.do"><bean:message key="view.menu.label.configure.projects" /></html:link>
		| <html:link page="/admin/displayStatus.do"><bean:message key="view.menu.label.configure.status" /></html:link>
		| <html:link page="/admin/displaySeverity.do"><bean:message key="view.menu.label.configure.severity" /></html:link>
		| <html:link page="/admin/displayDisposition.do"><bean:message key="view.menu.label.configure.disposition" /></html:link></th>
	</tr>
	</table>
	
	<table width="100%" cellspacing="0" cellpadding="0" border="0">
	<tr>
	    <td valign="top" nowrap>
			<table width="100%" cellspacing="0" cellpadding="0" border="0" class="ticketlist">
			<tr>
			    <th><bean:message key="view.label.name"/></th>
				<th><bean:message key="view.label.alias"/></th>
			    <th><bean:message key="view.label.active"/></th>
				<th><bean:message key="view.label.selectable"/></th>
				<th><bean:message key="view.label.manager"/></th>
			    <th>&nbsp;</th>
			</tr>
			<logic:iterate name="queueForm" property="queueList" id="queue">
			<tr>
			    <td><bean:write name="queue" property="name" /></td>
				<td><bean:write name="queue" property="emailAlias" /></td>
			    <td><html:link action="/admin/toggle/queueActive" paramName="queue" paramProperty="id" paramId="id">
							<logic:equal name="queue" property="active" value="true">Active</logic:equal>
							<logic:equal name="queue" property="active" value="false">Inactive</logic:equal>
						</html:link></td>
				<td><html:link action="/admin/toggle/queueSelectable" paramName="queue" paramProperty="id" paramId="id">
							<logic:equal name="queue" property="selectable" value="true">Visible</logic:equal>
							<logic:equal name="queue" property="selectable" value="false">Hidden</logic:equal>
						</html:link></td>
				<td><logic:notEmpty name="queue" property="manager"><bean:write name="queue" property="manager.username" /></logic:notEmpty></td>
				<td><html:link action="/admin/editQueue" paramName="queue" paramId="id" paramProperty="id"><html:img page="/images/edit.gif" border="0" alt="Edit"/></html:link></td>
			</tr>
			</logic:iterate>
			</table>
		</td>
	    <td width="100" valign="top" nowrap>
			<html:form action="/admin/addQueue">
				<html:hidden name="queueForm" property="id"/>
			<table width="100%" cellspacing="0" cellpadding="0" border="0" class="boxred">
			<tr>
			    <th colspan="2" nowrap><bean:message key="view.panel.label.queue"/></th>
			</tr>
			<tr>
			    <td><bean:message key="view.label.name"/></td>
			    <td><html:text name="queueForm" property="name"/></td>
			</tr>
			<tr>
			    <td><bean:message key="view.label.alias"/></td>
			    <td><html:text name="queueForm" property="emailAlias"/></td>
			</tr>
			<tr>
			    <td colspan="2">
					<bean:message key="view.label.selectable"/> <html:checkbox name="queueForm" property="selectable"/>
					<bean:message key="view.label.active"/> <html:checkbox name="queueForm" property="active"/>
				</td>
			</tr>
			<tr>
			    <td><bean:message key="view.label.manager"/></td>
			    <td><html:select name="queueForm" property="managerId">
						<html:optionsCollection name="queueForm" property="personList" value="id" label="realname" />
					</html:select></td>
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

	
</layout:html>



