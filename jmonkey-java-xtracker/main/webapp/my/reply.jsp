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
	<html:form action="/my/saveReply">
			<html:hidden name="ticketMessageForm" property="id"/>
			<bean:message key="view.panel.label.ticket.add.reply"/> #<bean:write name="ticketMessageForm" property="id" />
			<table cellspacing="0" cellpadding="0" border="0" class="boxyello">
			<tr>
			    <th valign="top" nowrap><bean:message key="view.label.subject"/></th>
				<th valign="top" nowrap><bean:message key="view.label.priority"/></th>
			</tr>
			<tr>
			    <td valign="top" nowrap><html:text name="ticketMessageForm" property="subject" size="60" maxlength="255" accesskey="S"/></td>
				<td valign="top" nowrap><html:select name="ticketMessageForm" property="importance">
					<html:option value="1"><bean:message key="view.label.level.high"/></html:option>
					<html:option value="2"><bean:message key="view.label.level.normal"/></html:option>
					<html:option value="3"><bean:message key="view.label.level.low"/></html:option>
				</html:select></td>
				
			</tr>
			<tr>
			    <th colspan="2" valign="top" nowrap><bean:message key="view.label.content"/></th>
			</tr>
			<tr>
			    <td colspan="2" valign="top" nowrap><html:textarea name="ticketMessageForm" property="content" cols="55" rows="20" accesskey="M"/></td>
			</tr>
			<tr>
			    <td colspan="2" align="right" nowrap><html:submit>
				<bean:message key="view.label.add"/>
			</html:submit></td>
			</tr>
			</table>
	</html:form>
	<%@ include file="footer.jsp"%>
</body>
</html:html>
