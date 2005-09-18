<%@ page language="java"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"	prefix="html"%>

<html:html>
<head>
	<title>XTracker</title>
</head>
<body>

<table align="center" width="100%" height="100%" cellspacing="0" cellpadding="2" border="0">
<tr>
    <td align="center" nowrap>
	
	<table border="0" cellspacing="0" cellpadding="1" frame="boxred">
	<tr>
	    <td align="center" nowrap><%@ include file="header.jsp"%></td>
	</tr>
	<tr>
	    <td align="center" nowrap>
		
		<table border="0" cellspacing="0" cellpadding="5">
		<tr bgcolor="#8080C0">
		    <th><bean:message key="view.message.warnrestart.label"/></th>
		</tr>
		<tr bgcolor="#8080FF" >
		    <td><bean:message key="view.message.warnrestart"/></td>
		</tr>
		</table>	
		
		</td>
	</tr>
	</table>
	</td>
</tr>
</table>

</body>
</html:html>
