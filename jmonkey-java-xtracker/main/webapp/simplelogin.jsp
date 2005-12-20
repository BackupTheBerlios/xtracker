<%@ page language="java"%>
<%@ include file="/taglibs.jsp"%>
<%@ include file="/preamble.jsp"%>

<html:html xhtml="true" lang="true">
<head>
	<title>XTracker <bean:message key="view.panel.label.login"/></title>
	<%@ include file="/styles.jsp"%>
	<%@ include file="/scripts.jsp"%>
	<%@ include file="/theme.jsp"%>
</head>
<body>



<div class="dialogbox">
	
	<div><stx:themeImg srcKey="HeaderLogo" alt="XTracker"/></div>
		<html:form action="/simpleLogin">
		<div>
		<fieldset>
		<legend><bean:message key="view.panel.label.login"/></legend>
		<html:hidden name="simpleAuthLoginForm" property="redirectTo"/>
		<ul>
			<li><label for="username"><bean:message key="view.label.username"/></label> <html:text name="simpleAuthLoginForm" property="username" styleId="username"/></li>
			<li><label for="password"><bean:message key="view.label.password"/></label> <html:password name="simpleAuthLoginForm" property="password" styleId="password"/></li>
		</ul>
		</fieldset>
		<html:submit><bean:message key="view.label.login"/></html:submit>
		</div>
		</html:form>

</div>

</body>
</html:html>
