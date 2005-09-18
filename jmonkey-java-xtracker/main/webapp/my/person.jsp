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
	<html:form action="/my/person">
			<html:hidden property="id"/>
			
			<table border="0" cellspacing="0" cellpadding="0" class="boxblue">
					<tr>
					<td width="100" nowrap><bean:message key="view.label.active"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.active" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.selectable"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.selectable" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.username"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.username" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.realname"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.realname" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.initials"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.initials" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.signature"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.signature" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.create.date"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.createDate" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.emailaddress"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.emailAddress" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.phonenumber"  />:</td>
					<td><bean:write name="displayPersonForm" property="person.phoneNumber" /></td>
					</tr>
				</table>
	</html:form>
	<%@ include file="footer.jsp"%>
</layout:html>

