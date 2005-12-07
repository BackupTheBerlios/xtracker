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
	<%@ include file="colour_picker_header.jsp"%>
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
	
	
	<%@ include file="/footer.jsp"%>
</body>
</html:html>

