
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="left" colspan="2">
		<html:img page="/images/xtracker.gif" width="196" height="42" border="0" align="left" />
		</td>
	</tr>
</table>
<table bgcolor='#CCCCCC' width='100%' class='navbar' border='0' cellpadding='0'>
<tr>
	<td>
	<html:link forward="mytickets"><bean:message key="view.menu.label.mytickets.link" /></html:link> | <html:link action="/my/newSearch"><bean:message key="view.label.search" /></html:link> | <html:link action="/my/editProfile"><bean:message key="view.label.profile" /></html:link> | <html:link page="/admin/index.jsp"><bean:message key="view.menu.label.admin.home" /></html:link>
	</td>
	<td align="right" nowrap>
	<html:form action="/my/addTicket">
		<bean:message key="view.label.new.ticket.in" /> <html:select property="queueId" onchange="if(document.myTicketsForm.queueId.options[document.myTicketsForm.queueId.selectedIndex].value != ''){myTicketsForm.submit();}">
			<html:option value=""/>
			<html:optionsCollection name="myTicketsForm" property="queueList" value="id" label="name" />
		</html:select>
	</html:form>
	</td>
	<td align="right" nowrap><html:form action="/my/openTicket"><bean:message key="view.label.new.view.ticket" /> <html:text property="ajaxAutocompleteId" size="5"/></html:form></td>
</tr>
</table>