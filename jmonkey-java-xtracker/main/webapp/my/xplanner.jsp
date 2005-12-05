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
	
	<html:form action="/my/saveXplannerLink">
			<html:hidden name="xPlannerLinkForm" property="ticketId"/>
			 <strong><bean:message key="view.label.add.ticket"  /> #<bean:write name="xPlannerLinkForm" property="ticketId" /> <bean:message key="view.label.to.xplanner"  /></strong>
			
			<table border="0" class="boxgreen">
				<tr>
					<td nowrap><bean:message key="view.label.xplanner.iteration"  />:</td>
					<td><html:select name="xPlannerLinkForm" property="iterationOid">
							<html:optionsCollection name="xPlannerLinkForm" property="iterationList" value="value" label="lable" />
					</html:select></td>
					<td>
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.xplanner.iteration" />
      				</ui:info>
					</td>
					</tr>
					<tr>
					<td nowrap><bean:message key="view.label.xplanner.disposition"  />:</td>
					<td><html:select name="xPlannerLinkForm" property="xplannerDisposition">
							<html:option value="added"><bean:message key="view.label.xplanner.disposition.added" /></html:option>
							<html:option value="planned"><bean:message key="view.label.xplanner.disposition.planned" /></html:option>
							<html:option value="carriedOver"><bean:message key="view.label.xplanner.disposition.carriedover" /></html:option>
					</html:select></td>
					<td>
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.xplanner.disposition" />
      				</ui:info>
					</td>
					</tr>
					<tr>
					<td nowrap><bean:message key="view.label.xplanner.subject"  />:</td>
					<td><html:text name="xPlannerLinkForm" property="subject" size="45"/></td>
					<td>
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.xplanner.subject" />
      				</ui:info>
					</td>
					</tr>
					<tr>
					<td valign="top" nowrap><bean:message key="view.label.xplanner.description"  />:<br\></td>
					<td valign="top" align="right" nowrap><html:link page="/my/twikihelp.jsp" target="_blank"><bean:message key="view.help.twiki.formatting" /></html:link></td>
					<td valign="top">&nbsp;</td>
					</tr>
					<tr>
					<td colspan="2"><html:textarea name="xPlannerLinkForm" property="content" rows="10" cols="65"/></td>
					<td valign="top">
					<ui:info image="/images/tips.png" alwaysVisible="true" panelClass="uiInfo_panel_custom">
						<bean:message key="view.help.input.xplanner.description" />
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
</body>
</html:html>

