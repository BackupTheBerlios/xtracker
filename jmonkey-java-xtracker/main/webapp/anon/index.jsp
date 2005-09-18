<%@ page language="java"%>
<%@ taglib uri="http://struts.application-servers.com/layout"	prefix="layout"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"	prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"	prefix="logic"%>

<layout:html layout="false" key="page.title.anon">
	<%@ include file="header.jsp"%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td align="left" valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ticketlist">
				<tr>
					<th colspan="5"><bean:message key="view.panel.label.tickets.requested"/></th>
				</tr>
				<tr>
					<th width="20">#</td>
					<th width="3">!</td>
					<th width="65%">Subject</td>
					<th>Project</td>
					<th>Status</td>
				</tr>
				<logic:iterate name="anonTicketsForm" property="ticketList" id="ticket" indexId="idx">
				<tr class="row<%= idx.intValue() % 2 %>">
					<td><html:link action="/anon/open" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="id"  /></html:link></td>
					<td><bean:write name="ticket" property="priority"  /></td>
					<td><html:link action="/anon/open" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="subject"  /></html:link></td>
					<td><logic:notEmpty name="ticket" property="project"><bean:write name="ticket" property="project.name" /></logic:notEmpty><logic:empty name="ticket" property="project"><bean:message key="view.label.unspecified"/></logic:empty></td>
					<td><bean:write name="ticket" property="status.label" /></td>
				</tr>
				</logic:iterate>
				</table>
			</td>
		</tr>
	</table>
	<!-- =================== -->
</layout:html>
