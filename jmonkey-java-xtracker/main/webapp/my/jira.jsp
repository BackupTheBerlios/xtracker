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
	
	<html:form action="/my/saveJiraLink">
			<html:hidden name="jiraLinkForm" property="ticketId"/>
			 <strong><bean:message key="view.label.add.ticket"  /> #<bean:write name="jiraLinkForm" property="ticketId" /> <bean:message key="view.label.to.jira"  /></strong>
			
			<table border="0" class="boxgreen">
					<tr>
					<td nowrap><bean:message key="view.label.jira.project"  />:</td>
					<td><html:select name="jiraLinkForm" property="projectId">
							<html:optionsCollection name="jiraLinkForm" property="projectList" value="key" label="name" />
					</html:select></td>
					<td>
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.jira.project" />
      				</ui:info>
					</td>
					</tr>
					<tr>
					<td nowrap><bean:message key="view.label.jira.issuetype"  />:</td>
					<td><html:select name="jiraLinkForm" property="issueTypeId">
							<html:optionsCollection name="jiraLinkForm" property="issueTypeList" value="id" label="name" />
					</html:select></td>
					<td>
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.jira.issuetype" />
      				</ui:info>
					</td>
					</tr>
					<tr>
					<td nowrap><bean:message key="view.label.jira.priority"  />:</td>
					<td><html:select name="jiraLinkForm" property="priorityId">
							<html:optionsCollection name="jiraLinkForm" property="priorityList" value="id" label="name" />
					</html:select></td>
					<td>
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.jira.priority" />
      				</ui:info>
					</td>
					</tr>
					<tr>
					<td nowrap><bean:message key="view.label.jira.status"  />:</td>
					<td><html:select name="jiraLinkForm" property="statusId">
							<html:optionsCollection name="jiraLinkForm" property="statusList" value="id" label="name" />
					</html:select></td>
					<td>
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.jira.status" />
      				</ui:info>
					</td>
					</tr>

					<tr>
					<td nowrap><bean:message key="view.label.jira.summary"  />:</td>
					<td><html:text name="jiraLinkForm" property="subject" size="45"/></td>
					<td>
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.jira.summary" />
      				</ui:info>
					</td>
					</tr>
					<tr>
					<td valign="top" nowrap><bean:message key="view.label.jira.description"  />:<br\></td>
					<td valign="top" align="right" nowrap>&nbsp;</td>
					<td valign="top">&nbsp;</td>
					</tr>
					<tr>
					<td colspan="2"><html:textarea name="jiraLinkForm" property="content" rows="10" cols="65"/></td>
					<td valign="top">
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.jira.description" />
      				</ui:info>
					</td>
					</tr>
					
					<tr>
						<td colspan="3" align="right"><html:submit>
								<bean:message key="view.label.update"/>
							</html:submit></td>
					</tr>
				</table>
	</html:form>
	<%@ include file="footer.jsp"%>
</layout:html>

