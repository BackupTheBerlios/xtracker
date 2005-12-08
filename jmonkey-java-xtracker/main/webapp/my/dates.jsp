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
	<html:form action="/my/saveDates" onsubmit="return validateDate('ticketDatesForm','dueDate');">
			<html:hidden property="id"/>
			
			
			<table border="0" cellspacing="0" cellpadding="0" class="boxpurple">
					<tr>
					<th colspan="2" nowrap><bean:message key="view.panel.label.ticket.dates"/> #<bean:write name="ticketDatesForm" property="id" /></th>
					</tr>
					<tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.create.date"  />:</td>
					<td><bean:write name="ticketDatesForm" property="createDate" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.modify.date"  />:</td>
					<td><bean:write name="ticketDatesForm" property="modifyDate" /></td>
					</tr>
					<tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.due.date"  />:</td>
					<td>
					<html:text name="ticketDatesForm" property="dueDate" styleId="dueDate" /><stx:themeImg srcKey="CalendarButton" styleId="dueDateTrigger" width="15" height="18" border="0"/>
					</td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.closed.date"  />:</td>
					<td><bean:write name="ticketDatesForm" property="closedDate" /></td>
					</tr>
					<tr>
						<td colspan="2"><html:submit>
								<bean:message key="view.label.update"/>
							</html:submit></td>
					</tr>
				</table>
	</html:form>
	<script type="text/javascript">
  		Calendar.setup( {
		      inputField  : "dueDate",
		      ifFormat    : "%Y-%m-%d",
		      daFormat    : "%Y-%m-%d",
		      button      : "dueDateTrigger",
		      showOthers  : "true"
	    });
	</script>
	<%@ include file="footer.jsp"%>
</body>
</html:html>

