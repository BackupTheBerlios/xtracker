<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="left">
		<html:img page="/images/xtracker.gif" width="196" height="42" border="0" align="left" />
		</td>
	</tr>
</table>
<table bgcolor='#CCCCCC' width='100%' class='navbar' border='0' cellpadding='0'>
<tr>
	<td>
	<html:link forward="mytickets"><bean:message key="view.menu.label.mytickets.link" /></html:link> 
	| <html:link page="/admin/index.jsp"><bean:message key="view.menu.label.admin.home" /></html:link> 
	| <html:link page="/admin/displayProfile.do"><bean:message key="view.menu.label.users" /></html:link>
	| <html:link page="/admin/runtime.do"><bean:message key="view.menu.label.configure" /></html:link>
	| <html:link page="/admin/adminguide.jsp"><bean:message key="view.menu.label.help" /></html:link>
	</td>
	<td align="right" nowrap>
	<html:form action="/my/openTicket">
		<bean:message key="view.label.new.view.ticket" /> <html:text property="id" size="5"/>
	</html:form>
	</td>
</tr>
</table>

