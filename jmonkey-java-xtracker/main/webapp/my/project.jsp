<%@ page language="java"%>
<%@ include file="/taglibs.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title.my" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>
</head>
<body>
	<%@ include file="basic_header.jsp"%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="left" valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ticketlist">
				<tr>
					<th width="20">#</td>
					<th width="3">!</td>
					<th width="50%">Subject</td>
					<th>Requester</td>
					<th>Severity</td>
					<th>Status</td>
					<th align="right" nowrap>&nbsp;</td>
				</tr>
				<logic:iterate name="displayProjectForm" property="ticketList" id="ticket" indexId="idx">
				<tr class="row<%= idx.intValue() % 2 %>">
					<td bgcolor="<bean:write name="ticket" property="severity.colour" />"><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="id"  /></html:link></td>
					<td bgcolor="<bean:write name="ticket" property="severity.colour" />"><bean:write name="ticket" property="priority"  /></td>
					<td><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="subject"  /></html:link></td>
					<td><html:link action="/my/person" paramName="ticket" paramProperty="requestor.id" paramId="id"><bean:write name="ticket" property="requestor.realname" /></html:link></td>
					<td bgcolor="<bean:write name="ticket" property="severity.colour" />"><bean:write name="ticket" property="severity.label" /></td>
					<td bgcolor="<bean:write name="ticket" property="status.colour" />"><bean:write name="ticket" property="status.label" /></td>
					<td><logic:equal name="ticket" property="status.immutable" value="true"><xtracker:img page="/images/status" border="0" alt="Status" dynamicPrefix="_" dynamicSuffix=".gif" dynamicName="ticket" dynamicProperty="status.id"/></logic:equal><logic:equal name="ticket" property="severity.immutable" value="true"><xtracker:img page="/images/severity" border="0" alt="Severity" dynamicPrefix="_" dynamicSuffix=".gif" dynamicName="ticket" dynamicProperty="severity.id"/></logic:equal></td>
				</tr>
				</logic:iterate>
				</table>
			</td>
			<td width="200" align="right" valign="top">
				<%@ include file="queueList.jsp"%>
				
				<%@ include file="projectList.jsp"%>
			</td>
		</tr>
	</table>
	<!-- =================== -->
	<%@ include file="footer.jsp"%>
</body>
</html:html>
