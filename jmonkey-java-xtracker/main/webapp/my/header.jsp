
<div class="navcontainer">
<ul class="navlist">
<li><html:link forward="mytickets"><bean:message key="view.menu.label.mytickets.link" /></html:link></li>
<li><html:link action="/my/newSearch"><bean:message key="view.label.search" /></html:link></li>
<li><html:link action="/my/editProfile"><bean:message key="view.label.profile" /></html:link></li>
<li><html:link page="/admin/index.jsp"><bean:message key="view.menu.label.admin.home" /></html:link></li>
<li><html:form action="/my/addTicket">
		<div>
		<bean:message key="view.label.new.ticket.in" /> <html:select property="queueId" onchange="if(document.myTicketsForm.queueId.options[document.myTicketsForm.queueId.selectedIndex].value != ''){myTicketsForm.submit();}">
			<html:option value=""/>
			<html:optionsCollection name="myTicketsForm" property="queueList" value="id" label="name" />
		</html:select>
		</div>
	</html:form></li>
<li><html:form action="/my/openTicket"><div><bean:message key="view.label.new.view.ticket" /> <html:text property="ajaxAutocompleteId" size="5"/></div></html:form></li>
</ul>
</div>
