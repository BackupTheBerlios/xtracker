<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>
<%@ taglib uri="http://www.jmonkey.com/xtracker/tags-xtracker" prefix="xtracker"%>

<layout:html layout="false" key="page.title.admin">
	<%@ include file="colour_picker_header.jsp"%>
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
			    <th><bean:message key="view.label.label"/></th>
			    <th><bean:message key="view.label.colour"/></th>
			    <th><bean:message key="view.label.active"/></th>
			    <th><bean:message key="view.label.selectable"/></th>
			    <th>&nbsp;</td>
			</tr>
			<logic:iterate name="severityForm" property="severityList" id="severity">
			<tr bgcolor="<bean:write name="severity" property="colour" />">
			    <td><logic:equal name="severity" property="immutable" value="true"><xtracker:img page="/images/severity" border="0" alt="Severity" dynamicPrefix="_" dynamicSuffix=".gif" dynamicName="severity" dynamicProperty="id"/></logic:equal> <bean:write name="severity" property="label" /></td>
			    <td><bean:write name="severity" property="colour" /></td>
			    <td><logic:notEqual name="severity" property="immutable" value="true"><html:link action="/admin/toggle/severityActive" paramName="severity" paramProperty="id" paramId="id">
							<logic:equal name="severity" property="active" value="true">Active</logic:equal>
							<logic:equal name="severity" property="active" value="false">Inactive</logic:equal>
						</html:link></logic:notEqual></td>
				<td><logic:notEqual name="severity" property="immutable" value="true"><html:link action="/admin/toggle/severitySelectable" paramName="severity" paramProperty="id" paramId="id">
							<logic:equal name="severity" property="selectable" value="true">Visible</logic:equal>
							<logic:equal name="severity" property="selectable" value="false">Hidden</logic:equal>
						</html:link></logic:notEqual></td>
			    <td align="right"><logic:notEqual name="severity" property="immutable" value="true"><html:link action="/admin/editSeverity" paramName="severity" paramId="id" paramProperty="id"><html:img page="/images/edit.gif" border="0" alt="Edit"/></html:link></logic:notEqual></td>
			</tr>
			</logic:iterate>
			</table>
		</td>
	    <td width="100" valign="top" nowrap>
			<html:form action="/admin/addSeverity">
			<html:hidden name="severityForm" property="id"/>
			<table width="100%" cellspacing="0" cellpadding="0" border="0" class="boxred">
			<tr>
			    <th colspan="2" nowrap><bean:message key="view.panel.label.severity"/></th>
			</tr>
			<tr>
			    <td><bean:message key="view.label.label"/></td>
			    <td><html:text name="severityForm" property="label"/></td>
			</tr>
			<tr>
			    <td><bean:message key="view.label.colour"/></td>
			    <td><a href="javascript:pickColor('pick1122016759');" id="pick1122016759" style="border: 1px solid #000000; font-family:Verdana; font-size:10px; text-decoration: none;">&nbsp;...&nbsp;&nbsp;&nbsp;</a> <html:text name="severityForm" property="colour" size="7" styleId="pick1122016759field" onchange="relateColor('pick1122016759', this.value);"/>
					<script language="javascript">relateColor('pick1122016759', getObj('pick1122016759field').value);</script>
					<noscript><a href="http://www.flooble.com/scripts/colorpicker.php">javascript color picker by flooble</a></noscript>
				</td>
			</tr>
			<tr>
			    <td colspan="2">
				<bean:message key="view.label.active"/><html:checkbox name="severityForm" property="active"/>
				<bean:message key="view.label.selectable"/><html:checkbox name="severityForm" property="selectable"/>
				</td>
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

