<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>

<layout:html layout="false" key="page.title.my">
	<%@ include file="basic_header.jsp"%>
	<html:form action="/my/saveTicket">
	<html:hidden property="queueId"/>
	<table border="0" cellspacing="0" cellpadding="0" class="boxblue">
	<tr>
	    <th colspan="4" nowrap><bean:message key="view.panel.label.new.ticket"/></th>
	</tr>
	<tr>
	    <td align="right"><strong><bean:message key="view.label.subject"/></strong>: </td>
	    <td colspan="3"><html:text name="myTicketsForm" property="subject" size="52" maxlength="255"/></td>
	</tr>
	<tr>
	    <td align="right"><strong><bean:message key="view.label.priority"/></strong>: </td>
	    <td><html:text name="myTicketsForm" property="priority" size="3" maxlength="2"/></td>
		<td align="right"><strong><bean:message key="view.label.project"/></strong>: </td>
	    <td><html:select name="myTicketsForm" property="projectId">
				<html:option value="">None</html:option>
				<html:optionsCollection name="myTicketsForm" property="projectList" value="id" label="name" />
			</html:select></td>
	</tr>
	<tr>
	    <td align="right"><strong><bean:message key="view.label.severity"/></strong>: </td>
	    <td><html:select name="myTicketsForm" property="severityId">
				<html:optionsCollection name="myTicketsForm" property="severityList" value="id" label="label" />
			</html:select></td>
		<td align="right"><strong><bean:message key="view.label.disposition"/></strong>: </td>
	    <td><html:select name="myTicketsForm" property="dispositionId">
				<html:optionsCollection name="myTicketsForm" property="dispositionList" value="id" label="label" />
			</html:select></td>
	</tr>
	<tr>
	    <td align="right" valign="top"><strong><bean:message key="view.label.content"/></strong>: </td>
	    <td colspan="3"><html:textarea name="myTicketsForm" property="content" cols="40" rows="20"/></td>
	</tr>
	<tr>
		<td align="right"><strong><bean:message key="view.label.owner"/></strong>: </td>
	    <td colspan="3"><html:select name="myTicketsForm" property="ownerId">
				<html:option value="">None</html:option>
				<html:optionsCollection name="myTicketsForm" property="personList" value="id" label="realname" />
			</html:select></td>
	</tr>
	<tr>
	    <td colspan="4" align="right" nowrap>
			<html:submit>
				<bean:message key="view.label.add"/>
			</html:submit></td>
	</tr>
	</table>
	</html:form>
	<%@ include file="footer.jsp"%>
</layout:html>

