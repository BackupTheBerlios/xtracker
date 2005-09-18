
<layout:dynMenu config="com.jmonkey.xtracker.strutslayout.AdminMenu" left="0" top="90">
	<layout:menuItem key="view.menu.label.mytickets.link" forward="mytickets"/>
	<layout:menuItem key="view.menu.label.admin.link" page="/admin/index.jsp"/>	
	<layout:menuItem key="view.menu.label.help">
		<layout:menuItem key="view.menu.label.help.about" page="/about.jsp"/>
		<layout:menuItem key="view.menu.label.help.licenses" page="/licenses.jsp"/>
		<layout:menuItem key="view.menu.label.help.userguide" page="/userguide.jsp"/>
	</layout:menuItem>
</layout:dynMenu>
