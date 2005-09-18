<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>
<%@ taglib uri="http://uitags.sf.net/uitags" prefix="ui"%>

<layout:html layout="false" key="page.title.my">
	<%@ include file="basic_header.jsp"%>
	<html:form action="/my/saveRelationships">
			<html:hidden name="ticketRelationshipsForm" property="id"/>
			<bean:message key="view.panel.label.ticket.relationships"/> #<bean:write name="ticketRelationshipsForm" property="id" />
			
			<table border="0" class="boxgreen">
					<tr>
					<td width="100" nowrap><bean:message key="view.label.depends.on"  />:</td>
					<td><html:text name="ticketRelationshipsForm" property="dependsOn"/></td>
					<td>
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.dependsOn"  />
      				</ui:info>
					</td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.depended.on.by"  />:</td>
					<td><bean:write name="ticketRelationshipsForm" property="dependedOnBy" /></td>
					<td>
					</td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.parents"  />:</td>
					<td><html:text name="ticketRelationshipsForm" property="parents"/></td>
					<td>
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.parents" />
      				</ui:info>
					</td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.children"  />:</td>
					<td><bean:write name="ticketRelationshipsForm" property="children" /></td>
					<td>
					</td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.refers.to"  />:</td>
					<td><html:text name="ticketRelationshipsForm" property="refersTo"/></td>
					<td>
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.refersTo" />
      				</ui:info>
					</td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.refered.to.by"  />:</td>
					<td><bean:write name="ticketRelationshipsForm" property="referredToBy" /></td>
					<td>
					</td>
					</tr>
					<tr>
						<td colspan="2"><html:submit>
								<bean:message key="view.label.update"/>
							</html:submit></td>
					</tr>
				</table>
	</html:form>
	<%@ include file="footer.jsp"%>
</layout:html>

