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

			<table cellspacing="0" cellpadding="2" border="0">
			<html:form action="/anon/saveProfile">
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.username"/></th>
			    <td valign="top"><html:text name="anonProfileForm" property="userName" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.realname"/></th>
			    <td valign="top"><html:text name="anonProfileForm" property="realName" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.initials"/></th>
			    <td valign="top"><html:text name="anonProfileForm" property="initials" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.password"/></th>
			    <td valign="top"><html:password name="anonProfileForm" property="password" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.verifypassword"/></th>
			    <td valign="top"><html:password name="anonProfileForm" property="verifyPassword" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.emailaddress"/></th>
			    <td valign="top"><html:text name="anonProfileForm" property="emailAddress" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap><bean:message key="view.label.phone"/></th>
			    <td valign="top"><html:text name="anonProfileForm" property="phoneNumber" size="52" maxlength="255"/></td>
			</tr>
			<tr>
			    <th align="right" nowrap colspan="2"><bean:message key="view.label.signature"/><br>
				<html:textarea name="anonProfileForm" property="signature"/></th>
			</tr>
			<tr>
			    <th align="right" nowrap colspan="2"><html:submit>
				<bean:message key="view.label.update"/>
			</html:submit></th>
			</tr>
			</html:form>
			</table>
</layout:html>