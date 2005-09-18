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
</layout:html>


