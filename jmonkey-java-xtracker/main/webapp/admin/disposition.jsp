<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>

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
				<th>&nbsp;</th>
			</tr>
			<logic:iterate name="dispositionForm" property="dispositionList" id="disposition">
			<tr bgcolor="<bean:write name="disposition" property="colour" />">
			    <td><bean:write name="disposition" property="label" /></td>
			    <td><bean:write name="disposition" property="colour" /></td>
			    <td><logic:notEqual name="disposition" property="immutable" value="true"><html:link action="/admin/toggle/dispositionActive" paramName="disposition" paramProperty="id" paramId="id">
							<logic:equal name="disposition" property="active" value="true">Active</logic:equal>
							<logic:equal name="disposition" property="active" value="false">Inactive</logic:equal>
						</html:link></logic:notEqual></td>
				<td><logic:notEqual name="disposition" property="immutable" value="true"><html:link action="/admin/toggle/dispositionSelectable" paramName="disposition" paramProperty="id" paramId="id">
							<logic:equal name="disposition" property="selectable" value="true">Visible</logic:equal>
							<logic:equal name="disposition" property="selectable" value="false">Hidden</logic:equal>
						</html:link></logic:notEqual></td>
				<td align="right"><logic:notEqual name="disposition" property="immutable" value="true"><html:link action="/admin/editDisposition" paramName="disposition" paramId="id" paramProperty="id"><html:img page="/images/edit.gif" border="0" alt="Edit"/></html:link></logic:notEqual></td>
			</tr>
			</logic:iterate>
			</table>
		</td>
	    <td width="100" valign="top" nowrap>
			<html:form action="/admin/addDisposition">
			<html:hidden name="dispositionForm" property="id"/>
			<table width="100%" cellspacing="0" cellpadding="0" border="0" class="boxred">
			<tr>
			    <th colspan="2" nowrap><bean:message key="view.panel.label.disposition"/></th>
			</tr>
			<tr>
			    <td><bean:message key="view.label.label"/></td>
			    <td><html:text name="dispositionForm" property="label"/></td>
			</tr>
			<tr>
			    <td><bean:message key="view.label.colour"/></td>
			    <td><a href="javascript:pickColor('pick1122016759');" id="pick1122016759" style="border: 1px solid #000000; font-family:Verdana; font-size:10px; text-decoration: none;">&nbsp;...&nbsp;&nbsp;&nbsp;</a> <html:text name="dispositionForm" property="colour" size="7" styleId="pick1122016759field" onchange="relateColor('pick1122016759', this.value);"/>
					<script language="javascript">relateColor('pick1122016759', getObj('pick1122016759field').value);</script>
					<noscript><a href="http://www.flooble.com/scripts/colorpicker.php">javascript color picker by flooble</a> | Read free <a href="http://perplexus.info/category/2/">logic puzzles</a></noscript>
				</td>
			</tr>
			<tr>
			    <td colspan="2">
				<bean:message key="view.label.active"/><html:checkbox name="dispositionForm" property="active"/>
				<bean:message key="view.label.selectable"/><html:checkbox name="dispositionForm" property="selectable"/>
				</td>
			</tr>
			<tr>
			    <td colspan="2" align="right" nowrap>
					<html:submit><bean:message key="view.label.commit"/></html:submit>
				</td>
			</tr>
			</table>
			</html:form>
		</td>
	</tr>
	</table>
</layout:html>

