<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>

<layout:html layout="false" key="page.title.search">
	<%@ include file="basic_header.jsp"%>
	
	<table width="100%" cellspacing="0" cellpadding="2" border="0">
	<tr>
	    <td valign="top" nowrap>
		<html:form action="/my/search" onsubmit="return (validateDate('searchForm','createDate') && validateDate('searchForm','modifyDate') && validateDate('searchForm','dueDate') && validateDate('searchForm','closedDate'));">
		<table width="100%" cellspacing="0" cellpadding="2" border="0" class="boxblue">
		<tr>
		    <td nowrap>&nbsp;</td>
			<td nowrap>&nbsp;</td>
			<td nowrap><html:reset><bean:message key="view.label.reset"/></html:reset> <html:submit><bean:message key="view.label.search"/></html:submit></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.subject"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="subjectOp">
					<html:option value="is">Is</html:option>
					<html:option value="like">Contains</html:option>
				</html:select></td>
		    <td valign="top"><html:text name="searchForm" property="subject" size="25" maxlength="255"/></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.priority"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="priorityOp">
					<html:option value="is">Is</html:option>
					<html:option value="gt">Greater</html:option>
					<html:option value="lt">Less</html:option>
				</html:select></td>
		    <td valign="top"><html:text name="searchForm" property="priority" size="3" maxlength="3"/></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.queue"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="queueOp">
					<html:option value="is">Is</html:option>
					<html:option value="not">Is Not</html:option>
				</html:select></td>
		    <td valign="top"><html:select name="searchForm" property="queueId">
					<html:option value="">Any</html:option>
					<html:optionsCollection name="searchForm" property="queueList" value="id" label="name" />
				</html:select></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.project"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="projectOp">
					<html:option value="is">Is</html:option>
					<html:option value="not">Is Not</html:option>
				</html:select></td>
		    <td valign="top"><html:select name="searchForm" property="projectId">
					<html:option value="">Any</html:option>
					<html:optionsCollection name="searchForm" property="projectList" value="id" label="name" />
				</html:select></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.status"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="statusOp">
					<html:option value="is">Is</html:option>
					<html:option value="not">Is Not</html:option>
				</html:select></td>
		    <td valign="top"><html:select name="searchForm" property="statusId">
					<html:option value="">Any</html:option>
					<html:optionsCollection name="searchForm" property="statusList" value="id" label="label" />
				</html:select></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.severity"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="severityOp">
					<html:option value="is">Is</html:option>
					<html:option value="not">Is Not</html:option>
				</html:select></td>
		    <td valign="top"><html:select name="searchForm" property="severityId">
					<html:option value="">Any</html:option>
					<html:optionsCollection name="searchForm" property="severityList" value="id" label="label" />
				</html:select></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.disposition"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="dispositionOp">
					<html:option value="is">Is</html:option>
					<html:option value="not">Is Not</html:option>
				</html:select></td>
		    <td valign="top"><html:select name="searchForm" property="dispositionId">
					<html:option value="">Any</html:option>
					<html:optionsCollection name="searchForm" property="dispositionList" value="id" label="label" />
				</html:select></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.requestor"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="requestorOp">
					<html:option value="is">Is</html:option>
					<html:option value="not">Is Not</html:option>
				</html:select></td>
		    <td valign="top"><html:select name="searchForm" property="requestorId">
					<html:option value="">Any</html:option>
					<html:optionsCollection name="searchForm" property="personList" value="id" label="realname" />
				</html:select></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.owner"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="ownerOp">
					<html:option value="is">Is</html:option>
					<html:option value="not">Is Not</html:option>
				</html:select></td>
		    <td valign="top"><html:select name="searchForm" property="ownerId">
					<html:option value="">Any</html:option>
					<html:optionsCollection name="searchForm" property="personList" value="id" label="realname" />
				</html:select></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.watcher"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="watcherOp">
					<html:option value="is">Is</html:option>
					<html:option value="not">Is Not</html:option>
				</html:select></td>
		    <td valign="top"><html:select name="searchForm" property="watcherId">
					<html:option value="">Any</html:option>
					<html:optionsCollection name="searchForm" property="personList" value="id" label="realname" />
				</html:select></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.hours.worked"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="workedOp">
					<html:option value="is">Is</html:option>
					<html:option value="gt">Greater</html:option>
					<html:option value="lt">Less</html:option>
				</html:select></td>
		    <td valign="top"><html:text name="searchForm" property="worked" size="5" maxlength="10"/></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.create.date"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="createDateOp">
					<html:option value="is">On</html:option>
					<html:option value="gt">After</html:option>
					<html:option value="lt">Before</html:option>
				</html:select></td>
		    <td valign="top"><html:text name="searchForm" property="createDate" /><a href="javascript://" onclick="showCalendar(<bean:write name="searchForm" property="yearMonthDayString"/>,'yyyy-MM-dd','searchForm','createDate',event,2005,2007);"><img border="0" src="/xtracker/config/calendar.gif"></a><div id="slcalcod" style="position:absolute; left:100px; top:100px; z-index:10; visibility:hidden;"><script>printCalendar("Sun","Mon","Tue","Wed","Thu","Fri","Sat",1,"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec",<bean:write name="searchForm" property="yearMonthDayString"/>);</script></div></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.modify.date"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="modifyDateOp">
					<html:option value="is">On</html:option>
					<html:option value="gt">After</html:option>
					<html:option value="lt">Before</html:option>
				</html:select></td>
		    <td valign="top"><html:text name="searchForm" property="modifyDate" /><a href="javascript://" onclick="showCalendar(<bean:write name="searchForm" property="yearMonthDayString"/>,'yyyy-MM-dd','searchForm','modifyDate',event,2005,2007);"><img border="0" src="/xtracker/config/calendar.gif"></a><div id="slcalcod" style="position:absolute; left:100px; top:100px; z-index:10; visibility:hidden;"><script>printCalendar("Sun","Mon","Tue","Wed","Thu","Fri","Sat",1,"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec",<bean:write name="searchForm" property="yearMonthDayString"/>);</script></div></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.due.date"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="dueDateOp">
					<html:option value="is">On</html:option>
					<html:option value="gt">After</html:option>
					<html:option value="lt">Before</html:option>
				</html:select></td>
		    <td valign="top"><html:text name="searchForm" property="dueDate" /><a href="javascript://" onclick="showCalendar(<bean:write name="searchForm" property="yearMonthDayString"/>,'yyyy-MM-dd','searchForm','dueDate',event,2005,2007);"><img border="0" src="/xtracker/config/calendar.gif"></a><div id="slcalcod" style="position:absolute; left:100px; top:100px; z-index:10; visibility:hidden;"><script>printCalendar("Sun","Mon","Tue","Wed","Thu","Fri","Sat",1,"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec",<bean:write name="searchForm" property="yearMonthDayString"/>);</script></div></td>
		</tr>
		<tr>
		    <td align="right" valign="top"><strong><bean:message key="view.label.closed.date"/></strong></td>
		    <td align="right" valign="top"><html:select name="searchForm" property="closedDateOp">
					<html:option value="is">On</html:option>
					<html:option value="gt">After</html:option>
					<html:option value="lt">Before</html:option>
				</html:select></td>
		    <td valign="top"><html:text name="searchForm" property="closedDate" /><a href="javascript://" onclick="showCalendar(<bean:write name="searchForm" property="yearMonthDayString"/>,'yyyy-MM-dd','searchForm','closedDate',event,2005,2007);"><img border="0" src="/xtracker/config/calendar.gif"></a><div id="slcalcod" style="position:absolute; left:100px; top:100px; z-index:10; visibility:hidden;"><script>printCalendar("Sun","Mon","Tue","Wed","Thu","Fri","Sat",1,"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec",<bean:write name="searchForm" property="yearMonthDayString"/>);</script></div></td>
		</tr>
		
		</table>
		</html:form>

	</td>
    <td width="60%" align="left" valign="top" nowrap>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ticketlist">
		<logic:empty name="searchForm" property="searchResults">
		<tr>
			<th><bean:message key="view.message.nosearchresults"/></td>
		</tr>
		</logic:empty>
		<logic:notEmpty name="searchForm" property="searchResults">
		<tr>
			<th width="20">#</td>
			<th width="3">!</td>
			<th width="50%">Subject</td>
			<th>Requester</td>
			<th>Status</td>
		</tr>
		<logic:iterate name="searchForm" property="searchResults" id="ticket" indexId="idx">
		<tr class="row<%= idx.intValue() % 2 %>">
			<td valign="top" bgcolor="<bean:write name="ticket" property="severity.colour" />"><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="id"  /></html:link></td>
			<td valign="top" bgcolor="<bean:write name="ticket" property="severity.colour" />"><bean:write name="ticket" property="priority"  /></td>
			<td valign="top"><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="subject"  /></html:link></td>
			
				<td valign="top">
				<logic:notEmpty name="ticket" property="requestor">
					<html:link action="/my/person" paramName="ticket" paramProperty="requestor.id" paramId="id">
					<bean:write name="ticket" property="requestor.realname" /></html:link>
				</logic:notEmpty>
				</td>

			<td valign="top" bgcolor="<bean:write name="ticket" property="status.colour" />"><bean:write name="ticket" property="status.label" /></td>
			

		</tr>
		</logic:iterate>
		</logic:notEmpty>
		</table>		
		</td>
	</tr>
	</table>
	
	<%@ include file="footer.jsp"%>
</layout:html>

