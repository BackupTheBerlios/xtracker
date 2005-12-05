<%@ page language="java" import="java.util.*" %>
<%@ include file="/taglibs.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title.my" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>
</head>
<body>
	<%@ include file="basic_header.jsp"%>
	<bean:message key="view.panel.label.userguide"/>
		<layout:tabs styleClass="FORM" width="400">
			<layout:tab key="view.menu.label.help.about" width="50">
				<tr><td>About...</td></tr>
			</layout:tab>
			<layout:tab key="view.menu.label.documentation" width="50">
				<tr><td>Documentation...</td></tr>
				<layout:tabs styleClass="FORM" width="400">
					<layout:tab key="view.menu.label.mytickets.link" width="50">
						<tr><td>My Tickets...</td></tr>
					</layout:tab>
					<layout:tab key="view.menu.label.entities" width="50">
						<tr><td>Entity Editor...</td></tr>
					</layout:tab>
				</layout:tabs>
			</layout:tab>
			<layout:tab key="view.menu.label.help.licenses" width="50">
				<tr><td>Licenses...</td></tr>
			</layout:tab>
		</layout:tabs>
		<%@ include file="footer.jsp"%>
</body>
</html:html>


