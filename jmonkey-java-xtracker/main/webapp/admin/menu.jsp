
<layout:dynMenu config="com.jmonkey.xtracker.strutslayout.AdminMenu" left="0" top="90">
	<layout:menuItem key="view.menu.label.mytickets.link" forward="mytickets"/>
	<layout:menuItem key="view.menu.label.admin.home" page="/admin/index.jsp"/>
	<layout:menuItem key="view.menu.label.users">
		<layout:menuItem key="view.menu.label.users.manage" page="/admin/displayProfile.do"/>
		<layout:menuItem key="view.menu.label.users.add" page="/admin/addProfile.do"/>
	</layout:menuItem>
	<layout:menuItem key="view.menu.label.configure">
		<layout:menuItem key="view.menu.label.configure.queues" page="/admin/displayQueue.do"/>
		<layout:menuItem key="view.menu.label.configure.projects" page="/admin/displayProject.do"/>
		<layout:menuItem key="view.menu.label.configure.status" page="/admin/displayStatus.do"/>
		<layout:menuItem key="view.menu.label.configure.severity" page="/admin/displaySeverity.do"/>
		<layout:menuItem key="view.menu.label.configure.runtime" page="/admin/runtime.do"/>
	</layout:menuItem>
	<layout:menuItem key="view.menu.label.help">
		<layout:menuItem key="view.menu.label.help.about" page="/about.jsp"/>
		<layout:menuItem key="view.menu.label.help.licenses" page="/licenses.jsp"/>
		<layout:menuItem key="view.menu.label.help.adminguide" page="/admin/adminguide.jsp"/>
		<layout:menuItem key="view.menu.label.help.userguide" page="/userguide.jsp"/>
		<layout:menuItem key="view.menu.label.help.updatecheck" page="/admin/checkForUpdates.do"/>
	</layout:menuItem>
	<layout:menuItem key="view.label.logout" page="/logout"/>
</layout:dynMenu>
