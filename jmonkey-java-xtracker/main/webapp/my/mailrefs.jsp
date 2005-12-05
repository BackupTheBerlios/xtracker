<%@ page language="java"%>
<%@ include file="/taglibs.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title.my" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>
</head>
<body>
	
	<strong>Original Message</strong><p/>
	Date: <bean:write name="mailReferencesForm" property="rootHistory.createDate" /><br/>
	Author: <bean:write name="mailReferencesForm" property="rootHistory.author.realname" /><br/>
	Subject: <bean:write name="mailReferencesForm" property="rootHistory.subject" />
	<logic:notEmpty name="mailReferencesForm" property="rootHistory.content">
	Content: <pre><bean:write name="mailReferencesForm" property="rootHistory.content" /></pre><br/>
	</logic:notEmpty>
	
	<hr size="1" noshade>
	<strong>Referenced Messages</strong><p/>
	<logic:iterate name="mailReferencesForm" property="referenceList" id="history" indexId="idx">
		<blockquote>
		Date: <bean:write name="history" property="createDate" /><br/>
		Author: <bean:write name="history" property="author.realname" /><br/>
		Subject: <bean:write name="history" property="subject" />
		<logic:notEmpty name="history" property="content">
		Content: <pre><bean:write name="history" property="content" /></pre><br/>
		</logic:notEmpty>
		</blockquote>
	</logic:iterate>
				
	<!-- =================== -->
	<%@ include file="footer.jsp"%>
</body>
</html:html>
