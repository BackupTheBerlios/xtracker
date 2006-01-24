<fieldset>
	<legend><bean:message key="view.panel.label.project.list" /></legend>
	<ul>
		<logic:iterate name="myTicketsForm" property="projectList" id="project">
			<li><html:link action="/my/project" paramName="project" paramProperty="id" paramId="id"><bean:write name="project" property="name" /></html:link></li>
		</logic:iterate>
	</ul>
</fieldset>
