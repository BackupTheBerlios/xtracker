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
	
		<html:form action="/anon/saveComment">
		<div>
			<fieldset>
				<legend><bean:message key="view.panel.label.ticket.add.comment"/> #<bean:write name="anonTicketMessageForm" property="id" /></legend>
				<html:hidden property="id"/>
				<table>
				<tbody>
				<colgroup span="2">
					<col valign="top" ></col>
					<col valign="top" ></col>
				</colgroup>
				<tr>
				    <th><bean:message key="view.label.subject"/></th>
					<th><bean:message key="view.label.priority"/></th>
				</tr>
				<tr>
				    <td><html:text name="anonTicketMessageForm" property="subject" size="60" maxlength="255" accesskey="S"/></td>
					<td><html:select name="anonTicketMessageForm" property="importance">
						<html:option value="1"><bean:message key="view.label.level.high"/></html:option>
						<html:option value="2"><bean:message key="view.label.level.normal"/></html:option>
						<html:option value="3"><bean:message key="view.label.level.low"/></html:option>
					</html:select></td>
					
				</tr>
				<colgroup span="2">
					<col valign="top" span="2"></col>
					<col valign="top" ></col>
				</colgroup>
				<tr>
				    <th><bean:message key="view.label.content"/></th>
				</tr>
				<tr>
				    <td><html:textarea name="anonTicketMessageForm" property="content" cols="55" rows="20" accesskey="M"/></td>
				</tr>
				</tbody>
				</table>
			</fieldset>
			<table>
				<tbody>
				<colgroup span="1">
					<col align="right"></col>
				</colgroup>
				<tr>
				    <td>
				    <html:submit><bean:message key="view.label.add"/></html:submit>
				    </td>
				</tr>
				</tbody>
			</table>
		</div>	
		</html:form>
	
	</div>
	<%@ include file="/footer.jsp"%>
</body>
</html:html>
