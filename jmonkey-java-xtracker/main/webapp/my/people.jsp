<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>


<bean:define id="sourcePeople" name="ticketPeopleForm" property="allPeopleList"/>

<layout:html layout="false" key="page.title.my">
	<%@ include file="basic_header.jsp"%>
	<html:form action="/my/savePeople">
			<html:hidden property="id"/>
			<bean:message key="view.panel.label.ticket.people"/> #<bean:write name="ticketPeopleForm" property="id" />
			
			<table border="0" cellspacing="0" cellpadding="0" class="boxblue">
					<tr>
					<td width="100" nowrap><bean:message key="view.label.requestor"  />:</td>
					<td><bean:write name="ticketPeopleForm" property="requestor.realname" /></td>
					</tr>
					<tr>
					<td width="100" colspan="2" nowrap>&nbsp;</td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.add.owner" />:</td>
					<td><html:select name="ticketPeopleForm" property="newOwnerId">
							<html:option value=""></html:option>
							<html:optionsCollection name="ticketPeopleForm" property="allPeopleList" value="id" label="realname" />
						</html:select></td>
					</tr>
					<tr>
					<td width="50" nowrap><bean:message key="view.label.delete"  />:</td>
					<td nowrap><bean:message key="view.label.owners"  /></td>
					</tr>
					<tr>
					<logic:iterate name="ticketPeopleForm" property="ownerList" id="owner">
					<tr>
					<td width="100" nowrap><html:multibox name="ticketPeopleForm" property="deletedOwners"><bean:write name="owner" property="id" /></html:multibox></td>
					<td><bean:write name="owner" property="realname" /></td>
					</tr>
					</logic:iterate>
					<tr>
					<td width="100" colspan="2" nowrap>&nbsp;</td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.add.watcher" />:</td>
					<td><html:select name="ticketPeopleForm" property="newWatcherId">
							<html:option value=""></html:option>
							<html:optionsCollection name="ticketPeopleForm" property="allPeopleList" value="id" label="realname" />
						</html:select></td>
					</tr>
					<tr>
					<td width="50" nowrap><bean:message key="view.label.delete"  />:</td>
					<td nowrap><bean:message key="view.label.watchers"  /></td>
					</tr>
					<tr>
					<logic:iterate name="ticketPeopleForm" property="watcherList" id="watcher">
					<tr>
					<td width="100" nowrap><html:multibox name="ticketPeopleForm" property="deletedWatchers"><bean:write name="watcher" property="id" /></html:multibox></td>
					<td><bean:write name="watcher" property="realname" /></td>
					</tr>
					</logic:iterate>
					<tr>
						<td colspan="2"><html:submit>
								<bean:message key="view.label.update"/>
							</html:submit></td>
					</tr>
				</table>
	</html:form>
	<%@ include file="footer.jsp"%>
</layout:html>

