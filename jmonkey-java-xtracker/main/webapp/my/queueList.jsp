				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxred">
					<tr>
						<th><bean:message key="view.panel.label.queue.list" /></th>
					</tr>
					<logic:iterate name="myTicketsForm" property="queueList" id="queue">
					<tr>
						<td><html:link action="/my/queue" paramName="queue" paramProperty="id" paramId="id"><bean:write name="queue" property="name" /></html:link></td>
					</tr>
					</logic:iterate>
				</table>