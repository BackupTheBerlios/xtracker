<%@ page language="java"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"	prefix="html"%>

<html:html>
<head>
	<title>XTracker <bean:message key="view.panel.label.login"/></title>
</head>
<body>

<html:form action="/simpleLogin">
<html:hidden name="simpleAuthLoginForm" property="redirectTo"/>
<table align="center" width="100%" height="100%" cellspacing="0" cellpadding="2" border="0">
<tr>
    <td align="center" nowrap>
	
	<table border="0" cellspacing="0" cellpadding="1" frame="box">
	<tr>
	    <td align="center" nowrap><%@ include file="header.jsp"%></td>
	</tr>
	<tr>
	    <td align="center" nowrap>
		
		<table border="0" cellspacing="0" cellpadding="5">
		<tr bgcolor="#8080C0">
		    <th colspan="2"><bean:message key="view.panel.label.login"/></th>
		</tr>
		<tr bgcolor="#8080FF" >
		    <td><bean:message key="view.label.username"/>:</td>
		    <td><html:text name="simpleAuthLoginForm" property="username"/></td>
		</tr>
		<tr bgcolor="#8080FF">
		    <td><bean:message key="view.label.password"/></td>
		    <td><html:password name="simpleAuthLoginForm" property="password"/></td>
		</tr>
		<tr>
		    <td colspan="2" align="right" nowrap><html:submit>
				<bean:message key="view.label.login"/>
			</html:submit></td>
		</tr>
		</table>	
		
		</td>
	</tr>
	</table>
	</td>
</tr>
</table>


	
	
</html:form>
</body>
</html:html>
