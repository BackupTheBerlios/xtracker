<%@ page language="java" import="java.util.*" %>
<%@ include file="/taglibs.jsp"%>
<%@ include file="/preamble.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title.my" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>

</head>
<body>
	<%@ include file="/logo.jsp"%>
	<%@ include file="/my/navlight.jsp"%>
	
	<div class="bodycontainer">
	
	<table style="width:100%;">
		<tr>
			<td style="vertical-align: top;">
				<fieldset>
					<legend>Tickets In Queue</legend>
					<div>
					<table style="width:100%" class="ticketlist">
					 <thead>
					 	 <colgroup span="6">
							<col width="20"></col>
							<col width="3"></col>
							<col width="50%"></col>
							<col></col>
							<col></col>
							<col></col>
							<col></col>
						</colgroup>
						<tr>
							<th>#</th>
							<th>!</th>
							<th>Subject</th>
							<th>Requester</th>
							<th>Severity</th>
							<th>Status</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					
					<tbody>
						<logic:iterate name="displayQueueForm" property="ticketList" id="ticket" indexId="idx">
						<tr class="row<%= idx.intValue() % 2 %>">
							<td style="background-color:<bean:write name="ticket" property="severity.colour" />;"><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="id"  /></html:link></td>
							<td style="background-color:<bean:write name="ticket" property="severity.colour" />;"><bean:write name="ticket" property="priority"  /></td>
							<td><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="subject"  /></html:link></td>
							<td><html:link action="/my/person" paramName="ticket" paramProperty="requestor.id" paramId="id"><bean:write name="ticket" property="requestor.realname" /></html:link></td>
							<td style="background-color:<bean:write name="ticket" property="severity.colour" />;"><bean:write name="ticket" property="severity.label" /></td>
							<td style="background-color:<bean:write name="ticket" property="status.colour" />;"><bean:write name="ticket" property="status.label" /></td>
							<td><logic:equal name="ticket" property="status.immutable" value="true"><xtracker:img page="/images/status" border="0" alt="Status" dynamicPrefix="_" dynamicSuffix=".gif" dynamicName="ticket" dynamicProperty="status.id"/></logic:equal><logic:equal name="ticket" property="severity.immutable" value="true"><xtracker:img page="/images/severity" border="0" alt="Severity" dynamicPrefix="_" dynamicSuffix=".gif" dynamicName="ticket" dynamicProperty="severity.id"/></logic:equal></td>
						</tr>
						</logic:iterate>
					</tbody>
					</table>
					</div>
				</fieldset>
			</td>
			<td class="quicklisttd">
				<%@ include file="/my/quickLists.jsp"%>
			</td>
		</tr>
	</table>
	
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html:html>


