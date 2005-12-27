<%@ page language="java"%>
<%@ include file="/taglibs.jsp"%>
<%@ include file="/preamble.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title.anon" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/anon/theme.jsp"%>
</head>
<body>

	<%@ include file="/anon/logo.jsp"%>
	<%@ include file="/anon/nav.jsp"%>
	
	<div class="bodycontainer">
		<div style="display:block;margin-top: 12px; margin-bottom: 12px;">
			<fieldset id="ticketsOwnedGroup">
				<legend><bean:message key="view.panel.label.tickets.requested"/></legend>
				<div id="ticketsOwnedTable">
				<table style="width:100%" class="ticketlist">
				<thead>
					<colgroup span="5">
						<col width="20"></col>
						<col width="3"></col>
						<col width="65%"></col>
						<col></col>
						<col></col>
					</colgroup>
					<tr>
						<th width="20">#</td>
						<th width="3">!</td>
						<th width="65%">Subject</td>
						<th>Project</td>
						<th>Status</td>
					</tr>
				</thead>
						
				<tbody>
					<logic:iterate name="anonTicketsForm" property="ticketList" id="ticket" indexId="idx">
					<tr class="row<%= idx.intValue() % 2 %>">
						<td><html:link action="/anon/open" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="id" /></html:link></td>
						<td><bean:write name="ticket" property="priority" /></td>
						<td><html:link action="/anon/open" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="subject" /></html:link></td>
						<td><logic:notEmpty name="ticket" property="project"><bean:write name="ticket" property="project.name" /></logic:notEmpty><logic:empty name="ticket" property="project"><bean:message key="view.label.unspecified"/></logic:empty></td>
						<td><bean:write name="ticket" property="status.label" /></td>
					</tr>
					</logic:iterate>
				</tbody>
				</table>
			</div>
		</fieldset>
		</div>
	</div>
	
	<%@ include file="/anon/footer.jsp"%>
</body>
</html:html>

