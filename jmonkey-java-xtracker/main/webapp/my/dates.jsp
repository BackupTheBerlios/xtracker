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
					<html:text name="ticketDatesForm" property="dueDate" /><a href="javascript://" onclick="showCalendar(2005,6,30,'yyyy-MM-dd','ticketDatesForm','dueDate',event,2005,2007);"><img alt="Set Due Date..." border="0" src="/xtracker/config/calendar.gif"></a><div id="slcalcod" style="position:absolute; left:100px; top:100px; z-index:10; visibility:hidden;"><script>printCalendar("Sun","Mon","Tue","Wed","Thu","Fri","Sat",1,"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec",30,6,2005);</script></div>
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
	<%@ include file="footer.jsp"%>
</body>
</html:html>

