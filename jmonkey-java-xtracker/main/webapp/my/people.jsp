<%@ page language="java" import="java.util.*" %>
<%@ include file="/taglibs.jsp"%>


<bean:define id="sourcePeople" name="ticketPeopleForm" property="allPeopleList"/>
<html:html>
<head>
<title><bean:message key="page.title.my" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>
</head>
<body>
	<%@ include file="basic_header.jsp"%>
	
	<html:form action="/my/savePeople">
	<html:hidden property="id"/>
	<table cellspacing="0" cellpadding="0" border="0">
	<tr>
	    <td colspan="2" nowrap><bean:message key="view.label.owners"  /></td>
	</tr>
	<tr>
	    <td><html:select styleId="selectedOwnerList"  style="width: 200px" size="4" multiple="true" name="ticketPeopleForm" property="selectedOwners">
					<html:optionsCollection name="ticketPeopleForm" property="ownerList" value="id" label="realname" />
					</html:select></td>
	    <td><ul style="list-style-type: none; list-style-position: inside;">
						<li><stx:themeImg srcKey="UserGroupRemoveSmall" onclick="transferSelectItem('selectedOwnerList','personList')" width="30" height="15" border="0" align="left"/></li>
					</ul></td>
	</tr>
	<tr>
	    <td colspan="2" nowrap><bean:message key="view.panel.label.ticket.people" /></td>
	</tr>
	<tr>
	    <td><html:select styleId="personList" style="width: 200px" size="6" name="ticketPeopleForm" property="newOwnerId">
					<html:optionsCollection name="ticketPeopleForm" property="allPeopleList" value="id" label="realname" />
					</html:select></td>
	    <td><ul style="list-style-type: none; list-style-position: inside;">
						<li><stx:themeImg srcKey="UserGroupUpSmall" onclick="transferSelectItem('personList', 'selectedOwnerList')" width="30" height="15" border="0"/></li>
						<li><stx:themeImg srcKey="UserGroupDownSmall" onclick="transferSelectItem('personList', 'selectedWatcherList')" width="30" height="15" border="0"/></li>
					</ul></td>
	</tr>
	<tr>
	    <td colspan="2" nowrap><bean:message key="view.label.watchers" /></td>
	</tr>
	<tr>
	    <td><html:select styleId="selectedWatcherList"  style="width: 200px" size="4" multiple="true" name="ticketPeopleForm" property="selectedWatchers">
					<html:optionsCollection name="ticketPeopleForm" property="watcherList" value="id" label="realname" />
					</html:select></td>
	    <td><ul style="list-style-type: none; list-style-position: inside;">
						<li><stx:themeImg srcKey="UserGroupRemoveSmall" onclick="transferSelectItem('selectedWatcherList','personList')" width="30" height="15" border="0" align="left"/></li>
					</ul></td>
	</tr>
	<tr>
	    <td colspan="2" align="right" nowrap><html:submit onclick="selectAll('selectedOwnerList');selectAll('selectedWatcherList');"><bean:message key="view.label.update"/></html:submit></td>
	</tr>
	</table>
	</html:form>
		
		<%@ include file="footer.jsp"%>

</body>
</html:html>

