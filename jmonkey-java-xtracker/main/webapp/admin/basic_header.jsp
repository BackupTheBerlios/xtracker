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
	<%@ include file="nav.jsp"%>
	</td>
	<td align="right" nowrap>
	<html:form action="/my/openTicket">
		<bean:message key="view.label.new.view.ticket" /> <html:text property="id" size="5"/>
	</html:form>
	</td>
</tr>
</table>

