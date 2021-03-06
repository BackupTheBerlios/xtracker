<%@ page language="java" import="java.util.*" %>
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
	<html:form action="/my/saveDetails">
			<html:hidden property="id"/>
			<bean:message key="view.panel.label.ticket.details"/> #<bean:write name="ticketDetailsForm" property="id" />
			
			<table border="0" cellspacing="0" cellpadding="0" class="boxred">
					<tr>
					<td width="100" nowrap><bean:message key="view.label.id" />:</td>
					<td><bean:write name="ticketDetailsForm" property="id" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.subject"  />:</td>
					<td><html:text name="ticketDetailsForm" property="subject"/></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.priority"  />:</td>
					<td><html:text name="ticketDetailsForm" property="priority"/></td>
					</tr>
					<tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.hours.worked"  />:</td>
					<td><html:text name="ticketDetailsForm" property="worked"/></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.status" />:</td>
					<td><html:select name="ticketDetailsForm" property="statusId">
							<html:optionsCollection name="ticketDetailsForm" property="statusList" value="id" label="label" />
						</html:select></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.severity"  />:</td>
					<td><html:select name="ticketDetailsForm" property="severityId">
							<html:optionsCollection name="ticketDetailsForm" property="severityList" value="id" label="label" />
						</html:select></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.disposition"  />:</td>
					<td><html:select name="ticketDetailsForm" property="dispositionId">
							<html:optionsCollection name="ticketDetailsForm" property="dispositionList" value="id" label="label" />
						</html:select></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.queue"  />:</td>
					<td><html:select name="ticketDetailsForm" property="queueId">
							<html:optionsCollection name="ticketDetailsForm" property="queueList" value="id" label="name" />
						</html:select></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.project"  />:</td>
					<td><html:select name="ticketDetailsForm" property="projectId">
							<html:option value="">None</html:option>
							<html:optionsCollection name="ticketDetailsForm" property="projectList" value="id" label="name" />
						</html:select></td>
					</tr>
					<tr>
						<td colspan="2"><html:submit>
								<bean:message key="view.label.update"/>
							</html:submit></td>
					</tr>
				</table>
	</html:form>
	<%@ include file="footer.jsp"%>
</body>
</html:html>

