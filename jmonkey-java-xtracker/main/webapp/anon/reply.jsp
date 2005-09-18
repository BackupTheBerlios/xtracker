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
	<html:form action="/anon/saveReply">
			<html:hidden name="anonTicketMessageForm" property="id"/>
			<bean:message key="view.panel.label.ticket.add.reply"/> #<bean:write name="anonTicketMessageForm" property="id" />
			<table cellspacing="0" cellpadding="0" border="0" class="boxyello">
			<tr>
			    <th valign="top" nowrap><bean:message key="view.label.subject"/></th>
				<th valign="top" nowrap><bean:message key="view.label.priority"/></th>
			</tr>
			<tr>
			    <td valign="top" nowrap><html:text name="anonTicketMessageForm" property="subject" size="60" maxlength="255" accesskey="S"/></td>
				<td valign="top" nowrap><html:select name="anonTicketMessageForm" property="importance">
					<html:option value="1"><bean:message key="view.label.level.high"/></html:option>
					<html:option value="2"><bean:message key="view.label.level.normal"/></html:option>
					<html:option value="3"><bean:message key="view.label.level.low"/></html:option>
				</html:select></td>
				
			</tr>
			<tr>
			    <th colspan="2" valign="top" nowrap><bean:message key="view.label.content"/></th>
			</tr>
			<tr>
			    <td colspan="2" valign="top" nowrap><html:textarea name="anonTicketMessageForm" property="content" cols="55" rows="20" accesskey="M"/></td>
			</tr>
			<tr>
			    <td colspan="2" align="right" nowrap><html:submit>
				<bean:message key="view.label.add"/>
			</html:submit></td>
			</tr>
			</table>
	</html:form>
</layout:html>

