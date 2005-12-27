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
	<html:form action="/anon/saveTicket">
		<div>
			<fieldset>
				<legend><bean:message key="view.panel.label.new.ticket"/></legend>
				<table>
				<tbody>
				<colgroup span="4">
					<col align="right"></col>
					<col span="3"></col>
					<col></col>
					<col></col>
				</colgroup>
				<tr>
				    <td><strong><bean:message key="view.label.subject"/></strong>: </td>
				    <td><html:text name="addAnonTicketForm" property="subject" size="52" maxlength="255"/></td>
				</tr>
				<colgroup span="4">
					<col align="right"></col>
					<col></col>
					<col align="right"></col>
					<col></col>
				</colgroup>
				<tr>
				    <td><strong><bean:message key="view.label.priority"/></strong>: </td>
				    <td><html:text name="addAnonTicketForm" property="priority" size="3" maxlength="2"/></td>
					<td><strong><bean:message key="view.label.project"/></strong>: </td>
				    <td><html:select name="addAnonTicketForm" property="projectId">
							<html:option value="">None</html:option>
							<html:optionsCollection name="addAnonTicketForm" property="projectList" value="id" label="name" />
						</html:select>
					</td>
				</tr>
				<tr>
				    <td><strong><bean:message key="view.label.severity"/></strong>: </td>
				    <td><html:select name="addAnonTicketForm" property="severityId">
							<html:optionsCollection name="addAnonTicketForm" property="severityList" value="id" label="label" />
						</html:select>
					</td>
					<td><strong><bean:message key="view.label.disposition"/></strong>: </td>
				    <td><html:select name="addAnonTicketForm" property="dispositionId">
							<html:optionsCollection name="addAnonTicketForm" property="dispositionList" value="id" label="label" />
						</html:select>
					</td>
				</tr>
				<colgroup span="4">
					<col align="right"></col>
					<col span="3"></col>
					<col></col>
					<col></col>
				</colgroup>
				<tr>
				    <td align="right" valign="top"><strong><bean:message key="view.label.content"/></strong>: </td>
				    <td colspan="3"><html:textarea name="addAnonTicketForm" property="content" cols="40" rows="20"/></td>
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



