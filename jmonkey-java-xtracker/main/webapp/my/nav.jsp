<div class="navblock"  style="width: 100%; display: block; font-size: 10px; font-style: italic;">
		<div class="navcontainer">
			<ul class="navlist">
				<li><html:link forward="mytickets"><bean:message key="view.menu.label.mytickets.link" /></html:link></li>
				<li><html:link action="/my/newSearch"><bean:message key="view.label.search" /></html:link></li>
				<li><html:link action="/my/editProfile"><bean:message key="view.label.profile" /></html:link></li>
				<li><html:link page="/admin/index.jsp"><bean:message key="view.menu.label.admin.home" /></html:link></li>
			</ul>
		</div>
		<div class="navcontainer" style="float:right;">
			<ul class="navlist">
				<li><html:form action="/my/addTicket">
				<div>
					<label for="newticketin"><bean:message key="view.label.new.ticket.in" /></label>
					<html:select property="queueId" styleId="newticketin" onchange="if(document.myTicketsForm.queueId.options[document.myTicketsForm.queueId.selectedIndex].value != ''){myTicketsForm.submit();}">
						<html:option value=""/>
						<html:optionsCollection name="myTicketsForm" property="queueList" value="id" label="name" />
					</html:select>
				</div>
				</html:form></li>
				<li><html:form action="/my/openTicket">
				<div>
					<label for="viewticketid"><bean:message key="view.label.new.view.ticket" /></label>
					<html:text property="ajaxAutocompleteId" styleId="viewticketid" size="5"/>
				</div>
				</html:form></li>
			</ul>
		</div>
	</div>