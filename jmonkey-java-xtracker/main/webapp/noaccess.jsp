<%@ page language="java"%>
<%@ include file="/taglibs.jsp"%>
<%@ include file="/preamble.jsp"%>

<html:html xhtml="true" lang="true">
<head>
	<title><bean:message key="label.xtracker"/> <bean:message key="label.no.access"/></title>
	<%@ include file="/styles.jsp"%>
	<%@ include file="/scripts.jsp"%>
	<%@ include file="/theme.jsp"%>
</head>
<body>

<div class="dialogbox">
	<div class="title"><bean:message key="label.no.access"/></div>
	<bean:message key="message.no.access"/>
</div>

</body>
</html:html>
