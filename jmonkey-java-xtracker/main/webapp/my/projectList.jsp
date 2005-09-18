				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxgreen">
					<tr>
						<th><bean:message key="view.panel.label.project.list" /></th>
					</tr>
					<logic:iterate name="myTicketsForm" property="projectList" id="project">
					<tr>
						<td><html:link action="/my/project" paramName="project" paramProperty="id" paramId="id"><bean:write name="project" property="name" /></html:link></td>
					</tr>
					</logic:iterate>
				</table>