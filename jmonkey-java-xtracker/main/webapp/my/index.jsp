<%@ page language="java"%>
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
	<%@ include file="/my/nav.jsp"%>
	
	<div class="bodycontainer">
			
			<div style="display:block;margin-top: 12px; margin-bottom: 12px;">
			<table style="width:100%;">
			<tr>
				<td style="vertical-align: top;">
					<fieldset id="ticketsOwnedGroup">
						 <legend style="cursor: pointer;" onclick="rollupFieldset('ticketsOwnedGroup', 'ticketsOwnedTable')"><bean:message key="view.panel.label.tickets.owned"/></legend>
						 <div id="ticketsOwnedTable">
						<table style="width:100%" class="ticketlist">
						 <thead>
						 	 <colgroup span="6">
								<col width="20"></col>
								<col width="3"></col>
								<col width="65%"></col>
								<col></col>
								<col></col>
								<col></col>
							</colgroup>
							<tr>
								<th width="20">#</td>
								<th width="3">!</td>
								<th width="65%">Subject</td>
								<th>Queue</td>
								<th>Status</td>
								<th align="right" nowrap>&nbsp;</td>
							</tr>
						</thead>
						
						<tbody>
							<logic:iterate name="myTicketsForm" property="ticketList" id="ticket" indexId="idx">
							<tr class="row<%= idx.intValue() % 2 %>">
								<td style="background-color:<bean:write name="ticket" property="severity.colour" />;"><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="id"  /></html:link></td>
								<td style="background-color:<bean:write name="ticket" property="severity.colour" />;"><bean:write name="ticket" property="priority"  /></td>
								<td><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="subject"  /></html:link></td>
								<td><html:link action="/my/queue" paramName="ticket" paramProperty="queue.id" paramId="id"><bean:write name="ticket" property="queue.name" /></html:link></td>
								<td style="background-color:<bean:write name="ticket" property="status.colour" />;"><bean:write name="ticket" property="status.label" /></td>
								<td><logic:equal name="ticket" property="status.immutable" value="true"><xtracker:img page="/images/status" border="0" alt="Status" dynamicPrefix="_" dynamicSuffix=".gif" dynamicName="ticket" dynamicProperty="status.id"/></logic:equal><logic:equal name="ticket" property="severity.immutable" value="true"><xtracker:img page="/images/severity" border="0" alt="Severity" dynamicPrefix="_" dynamicSuffix=".gif" dynamicName="ticket" dynamicProperty="severity.id"/></logic:equal></td>
							</tr>
							</logic:iterate>
						</tbody>
						</table>
						</div>
					</fieldset>
					
					<fieldset id="ticketsWatchedGroup">
						 <legend style="cursor: pointer;" onclick="rollupFieldset('ticketsWatchedGroup', 'ticketsWatchedTable')"><bean:message key="view.panel.label.tickets.watching"/></legend>
						 <div id="ticketsWatchedTable">
						<table style="width:100%" class="ticketlist">
						 <thead>
						 	 <colgroup span="6">
								<col width="20"></col>
								<col width="3"></col>
								<col width="65%"></col>
								<col></col>
								<col></col>
								<col></col>
							</colgroup>
							<tr>
								<th width="20">#</td>
								<th width="3">!</td>
								<th width="65%">Subject</td>
								<th>Queue</td>
								<th>Status</td>
								<th align="right" nowrap>&nbsp;</td>
							</tr>
						</thead>
						
						<tbody>
							<logic:iterate name="myTicketsForm" property="watchedTicketList" id="ticket" indexId="idx">
							<tr class="row<%= idx.intValue() % 2 %>">
								<td style="background-color:<bean:write name="ticket" property="severity.colour" />;"><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="id"  /></html:link></td>
								<td style="background-color:<bean:write name="ticket" property="severity.colour" />;"><bean:write name="ticket" property="priority"  /></td>
								<td><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="subject"  /></html:link></td>
								<td><html:link action="/my/queue" paramName="ticket" paramProperty="queue.id" paramId="id"><bean:write name="ticket" property="queue.name" /></html:link></td>
								<td style="background-color:<bean:write name="ticket" property="status.colour" />;"><bean:write name="ticket" property="status.label" /></td>
								<td><logic:equal name="ticket" property="status.immutable" value="true"><xtracker:img page="/images/status" border="0" alt="Status" dynamicPrefix="_" dynamicSuffix=".gif" dynamicName="ticket" dynamicProperty="status.id"/></logic:equal><logic:equal name="ticket" property="severity.immutable" value="true"><xtracker:img page="/images/severity" border="0" alt="Severity" dynamicPrefix="_" dynamicSuffix=".gif" dynamicName="ticket" dynamicProperty="severity.id"/></logic:equal></td>
							</tr>
							</logic:iterate>
						</tbody>
						</table>
						</div>
					</fieldset>
					
					<fieldset id="ticketsRequestedGroup">
						 <legend style="cursor: pointer;" onclick="rollupFieldset('ticketsRequestedGroup', 'ticketsRequestedTable')"><bean:message key="view.panel.label.tickets.requested"/></legend>
						 <div id="ticketsRequestedTable">
						 <table style="width:100%" class="ticketlist">
						 <thead>
						 	 <colgroup span="6">
								<col width="20"></col>
								<col width="3"></col>
								<col width="65%"></col>
								<col></col>
								<col></col>
								<col></col>
							</colgroup>
							<tr>
								<th width="20">#</td>
								<th width="3">!</td>
								<th width="65%">Subject</td>
								<th>Queue</td>
								<th>Status</td>
								<th align="right" nowrap>&nbsp;</td>
							</tr>
						</thead>
						
						<tbody>
							<logic:iterate name="myTicketsForm" property="requestedTicketList" id="ticket" indexId="idx">
							<tr class="row<%= idx.intValue() % 2 %>">
								<td style="background-color:<bean:write name="ticket" property="severity.colour" />;"><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="id"  /></html:link></td>
								<td style="background-color:<bean:write name="ticket" property="severity.colour" />;"><bean:write name="ticket" property="priority"  /></td>
								<td><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="subject"  /></html:link></td>
								<td><html:link action="/my/queue" paramName="ticket" paramProperty="queue.id" paramId="id"><bean:write name="ticket" property="queue.name" /></html:link></td>
								<td style="background-color:<bean:write name="ticket" property="status.colour" />;"><bean:write name="ticket" property="status.label" /></td>
								<td><logic:equal name="ticket" property="status.immutable" value="true"><xtracker:img page="/images/status" border="0" alt="Status" dynamicPrefix="_" dynamicSuffix=".gif" dynamicName="ticket" dynamicProperty="status.id"/></logic:equal><logic:equal name="ticket" property="severity.immutable" value="true"><xtracker:img page="/images/severity" border="0" alt="Severity" dynamicPrefix="_" dynamicSuffix=".gif" dynamicName="ticket" dynamicProperty="severity.id"/></logic:equal></td>
							</tr>
							</logic:iterate>
						</tbody>
						</table>
						</div>
					</fieldset>
					
					<fieldset id="ticketsInQueueGroup">
						 <legend style="cursor: pointer;" onclick="rollupFieldset('ticketsInQueueGroup', 'ticketsInQueueTable')"><bean:message key="view.panel.label.tickets.in.queue"/></legend>
						 <div id="ticketsInQueueTable">
						<table style="width:100%" class="ticketlist">
						 <thead>
						 	 <colgroup span="6">
								<col width="20"></col>
								<col width="3"></col>
								<col width="65%"></col>
								<col></col>
								<col></col>
								<col></col>
							</colgroup>
							<tr>
								<th width="20">#</td>
								<th width="3">!</td>
								<th width="65%">Subject</td>
								<th>Queue</td>
								<th>Status</td>
								<th align="right" nowrap>&nbsp;</td>
							</tr>
						</thead>
						
						<tbody>
							<logic:iterate name="myTicketsForm" property="unassignedTicketList" id="ticket" indexId="idx">
							<tr class="row<%= idx.intValue() % 2 %>">
								<td style="background-color:<bean:write name="ticket" property="severity.colour" />;"><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="id"  /></html:link></td>
								<td style="background-color:<bean:write name="ticket" property="severity.colour" />;"><bean:write name="ticket" property="priority"  /></td>
								<td><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="subject"  /></html:link></td>
								<td><html:link action="/my/queue" paramName="ticket" paramProperty="queue.id" paramId="id"><bean:write name="ticket" property="queue.name" /></html:link></td>
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
	</div>
	
	<%@ include file="/footer.jsp"%>
</body>
</html:html>
