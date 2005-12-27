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
		<fieldset>
			<legend><bean:message key="view.panel.label.ticket.details" /></legend>
			<table>
			<tbody>
				<colgroup span="2">
					<col width="100"></col>
					<col></col>
				</colgroup>
				<tr>
					<td><bean:message key="view.label.ticket.number" />:</td>
					<td><bean:write name="openAnonTicketForm" property="id" /></td>
				</tr>
				<tr>
					<td><bean:message key="view.label.subject"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="subject" /></td>
				</tr>
				<tr>
					<td><bean:message key="view.label.priority"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="priority" /></td>
				</tr>
				<tr>
					<td><bean:message key="view.label.status" />:</td>
					<td><bean:write name="openAnonTicketForm" property="status.label" /></td>
				</tr>
				<tr>
					<td><bean:message key="view.label.severity"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="severity.label" /></td>
				</tr>
				<tr>
					<td><bean:message key="view.label.disposition"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="disposition.label" /></td>
				</tr>
				<tr>
					<td><bean:message key="view.label.project"  />:</td>
					<td>
						<logic:notEmpty name="openAnonTicketForm" property="project"><bean:write name="openAnonTicketForm" property="project.name" /></logic:notEmpty><logic:empty name="openAnonTicketForm" property="project"><bean:message key="view.label.unspecified"  /></logic:empty>
					</td>
				</tr>
				<tr>
					<td><bean:message key="view.label.requestor"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="requestor.realname" /></td>
				</tr>
				<tr>
					<td><bean:message key="view.label.owners" />:</td>
					<td><logic:iterate name="openAnonTicketForm" property="owners" id="owner"><bean:write name="owner" property="initials"/> </logic:iterate>
					</td>
				</tr>
				<tr>
					<td><bean:message key="view.label.create.date"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="createDate" /></td>
				</tr>
				<tr>
					<td><bean:message key="view.label.modify.date"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="modifyDate" /></td>
				</tr>
				<tr>
					<td><bean:message key="view.label.due.date"  />:</td>
					<td><logic:notEmpty name="openAnonTicketForm" property="dueDate"><bean:write name="openAnonTicketForm" property="dueDate" /></logic:notEmpty></td>
				</tr>
				<tr>
					<td><bean:message key="view.label.closed.date"  />:</td>
					<td><logic:notEmpty name="openAnonTicketForm" property="closedDate"><bean:write name="openAnonTicketForm" property="closedDate" /></logic:notEmpty></td>
				</tr>
			<tbody>
			</table>
		</fieldset>
		
		<fieldset>
			<legend><bean:message key="view.panel.label.ticket.history" /></legend>
			<table>
				<logic:iterate name="openAnonTicketForm" property="history" id="hist" indexId="idx">
					<logic:equal name="hist" property="system" value="true">
						<table>
						<tr>
							<td>
								<bean:write name="hist" property="createDate" />, <bean:write name="hist" property="subject" />
							</td>
						</table>
					</logic:equal>
					<logic:equal name="hist" property="system" value="false">
						<table>
						<tr>
							<td>
								<ul>
									<li class="subject"><bean:write name="hist" property="subject" /></li>
									<li class="author"><bean:write name="hist" property="author.realname" /></li>
									<li class="date"><bean:write name="hist" property="createDate" /></li>
								</ul>
							</td>
						</tr>
						<logic:notEmpty name="hist" property="content">
						<tr>
							<td> 
								[<xtracker:link action="/anon/reply" paramName="openAnonTicketForm" paramProperty="id" paramId="id" param1Name="hist" param1Property="id" param1Id="historyId"><bean:message key="view.label.reply" /></xtracker:link>] [<html:link action="/anon/comment" paramName="openAnonTicketForm" paramProperty="id" paramId="id"><bean:message key="view.label.comment" /></html:link>]
							</td>
						</tr>
						<tr>
							<td>
								<div id="ticketsHistoryBlock<bean:write name="idx" />" style="margin: 0px 20px 0px 20px; display: block;">
									<bean:write filter="false" name="hist" property="renderedContent" />
								</div>
							</td>
						</tr>
						</logic:notEmpty>
						</table>
					</logic:equal>
				</logic:iterate>
			</table>
		</fieldset>
	
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html:html>
