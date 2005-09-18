<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>

<layout:html layout="false" key="page.title.anon">
	<%@ include file="header.jsp"%>
	<html:form action="/anon/saveTicket">
	<table border="0" cellspacing="0" cellpadding="0" class="boxblue">
	<tr>
	    <th colspan="4" nowrap><bean:message key="view.panel.label.new.ticket"/></th>
	</tr>
	<tr>
	    <td align="right"><strong><bean:message key="view.label.subject"/></strong>: </td>
	    <td colspan="3"><html:text name="addAnonTicketForm" property="subject" size="52" maxlength="255"/></td>
	</tr>
	<tr>
	    <td align="right"><strong><bean:message key="view.label.priority"/></strong>: </td>
	    <td><html:text name="addAnonTicketForm" property="priority" size="3" maxlength="2"/></td>
		<td align="right"><strong><bean:message key="view.label.project"/></strong>: </td>
	    <td><html:select name="addAnonTicketForm" property="projectId">
				<html:option value="">None</html:option>
				<html:optionsCollection name="addAnonTicketForm" property="projectList" value="id" label="name" />
			</html:select></td>
	</tr>
	<tr>
	    <td align="right"><strong><bean:message key="view.label.severity"/></strong>: </td>
	    <td><html:select name="addAnonTicketForm" property="severityId">
				<html:optionsCollection name="addAnonTicketForm" property="severityList" value="id" label="label" />
			</html:select></td>
		<td align="right"><strong><bean:message key="view.label.disposition"/></strong>: </td>
	    <td><html:select name="addAnonTicketForm" property="dispositionId">
				<html:optionsCollection name="addAnonTicketForm" property="dispositionList" value="id" label="label" />
			</html:select></td>
	</tr>
	<tr>
	    <td align="right" valign="top"><strong><bean:message key="view.label.content"/></strong>: </td>
	    <td colspan="3"><html:textarea name="addAnonTicketForm" property="content" cols="40" rows="20"/></td>
	</tr>
	<tr>
	    <td colspan="4" align="right" nowrap>
			<html:submit>
				<bean:message key="view.label.add"/>
			</html:submit></td>
	</tr>
	</table>
	</html:form>
</layout:html>

