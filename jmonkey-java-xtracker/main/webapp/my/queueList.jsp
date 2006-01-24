<fieldset>
	<legend><bean:message key="view.panel.label.queue.list" /></legend>
	<ul>
		<logic:iterate name="myTicketsForm" property="queueList" id="queue">
		<li><html:link action="/my/queue" paramName="queue" paramProperty="id" paramId="id"><bean:write name="queue" property="name" /></html:link></li>
		</logic:iterate>
	</ul>
</fieldset>
