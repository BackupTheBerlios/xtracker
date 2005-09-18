<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>


<layout:html layout="false" key="page.title.anon">
	<%@ include file="header.jsp"%>
	<html:form action="/anon/open">
	<table width="100%" cellspacing="2" cellpadding="2" border="0">
	<tr>
	    <td colspan="2" class="contentheader">
		#<bean:write name="openAnonTicketForm" property="id" />: <bean:write name="openAnonTicketForm" property="subject" />
		</td>
	</tr>
	<tr>
	    <td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxred">
					<tr>
					<th colspan="2"><bean:message key="view.panel.label.ticket.details" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.id" />:</td>
					<td><bean:write name="openAnonTicketForm" property="id" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.priority"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="priority" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.hours.worked"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="worked" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.status" />:</td>
					<td><bean:write name="openAnonTicketForm" property="status.label" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.severity"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="severity.label" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.disposition"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="disposition.label" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.queue"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="queue.name" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.project"  />:</td>
					<td><logic:notEmpty name="openAnonTicketForm" property="project">
							<bean:write name="openAnonTicketForm" property="project.name" />
						</logic:notEmpty><logic:empty name="openAnonTicketForm" property="project"><bean:message key="view.label.unspecified"  /></logic:empty></td>
					</tr>
				</table>
				<table width="100%" border="0" class="boxblue">
					<tr>
					<th colspan="2"><bean:message key="view.panel.label.ticket.people" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.requestor"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="requestor.realname"  /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.owners"  />:</td>
					<td><logic:iterate name="openAnonTicketForm" property="owners" id="owner">
						<bean:write name="owner" property="initials"/>, 
					</logic:iterate></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.watchers"  />:</td>
					<td><logic:iterate name="openAnonTicketForm" property="watchers" id="watcher">
						<bean:write name="watcher" property="initials"/>, 
					</logic:iterate></td>
					</tr>
				</table>
		</td>
		<td valign="top">
				<table width="100%" border="0" class="boxgreen">
					<tr>
					<th colspan="2"><bean:message key="view.panel.label.ticket.relationships" /></th>
					</tr>
					<tr>
					<td width="50%" nowrap><bean:message key="view.label.depends.on"  />: <logic:iterate name="openAnonTicketForm" property="dependsOn" id="tid">
						<html:link action="/anon/open" paramName="tid" paramId="id" ><bean:write name="tid"/></html:link>&nbsp;
					</logic:iterate></td>
					<td width="50%" nowrap><bean:message key="view.label.depended.on.by"  />: <logic:iterate name="openAnonTicketForm" property="dependedOnBy" id="tid">
						<html:link action="/anon/open" paramName="tid" paramId="id" ><bean:write name="tid"/></html:link>&nbsp;
					</logic:iterate></td>
					</tr>
					<tr>
					<td width="50%" nowrap><bean:message key="view.label.parents"  />: <logic:iterate name="openAnonTicketForm" property="parents" id="tid">
						<html:link action="/anon/open" paramName="tid" paramId="id" ><bean:write name="tid" /></html:link>&nbsp;
					</logic:iterate></td>
					<td width="50%" nowrap><bean:message key="view.label.children"  />: <logic:iterate name="openAnonTicketForm" property="children" id="tid">
						<html:link action="/anon/open" paramName="tid" paramId="id" ><bean:write name="tid" /></html:link>&nbsp;
					</logic:iterate></td>
					</tr>
					<tr>
					<td width="50%" nowrap><bean:message key="view.label.refers.to"  />: <logic:iterate name="openAnonTicketForm" property="refersTo" id="tid">
						<html:link action="/anon/open" paramName="tid" paramId="id" ><bean:write name="tid" /></html:link>&nbsp;
					</logic:iterate></td>
					<td width="50%" nowrap><bean:message key="view.label.refered.to.by"  />: <logic:iterate name="openAnonTicketForm" property="referredToBy" id="tid">
						<html:link action="/anon/open" paramName="tid" paramId="id" ><bean:write name="tid" /></html:link>&nbsp;
					</logic:iterate></td>
					</tr>
				</table>
				<table width="100%" border="0" class="boxpurple">
					<tr>
					<th colspan="2"><bean:message key="view.panel.label.ticket.dates" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.create.date"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="createDate" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.modify.date"  />:</td>
					<td><bean:write name="openAnonTicketForm" property="modifyDate" /></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.due.date"  />:</td>
					<td><logic:notEmpty name="openAnonTicketForm" property="dueDate"><bean:write name="openAnonTicketForm" property="dueDate" /></logic:notEmpty></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.closed.date"  />:</td>
					<td><logic:notEmpty name="openAnonTicketForm" property="closedDate"><bean:write name="openAnonTicketForm" property="closedDate" /></logic:notEmpty></td>
					</tr>
				</table>
		</td>
	</tr>
	<tr>
	    <td colspan="2" valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxyello">
					<tr>
						<th width="85%"><bean:message key="view.panel.label.ticket.history" /></th>
						<th align="right">[<html:link action="/anon/comment" paramName="openAnonTicketForm" paramProperty="id" paramId="id"><bean:message key="view.label.comment" /></html:link>]</th>
					</tr>
					<logic:iterate name="openAnonTicketForm" property="history" id="hist" indexId="idx">
					<logic:equal name="hist" property="system" value="true">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxred">
					<tr>
					<td nowrap>
						<bean:write name="hist" property="createDate" />, <bean:write name="hist" property="subject" />
					</td>
					</table>
					</logic:equal>
					<logic:equal name="hist" property="system" value="false">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxhistory">
					<tr>
					<td nowrap>
					            <table cellspacing="1" ><tr>
									<th width="5"><a href="javascript:toggleLayer('ticketsHistoryBlock<bean:write name="idx" />');" title="Open/Close"><html:img page="/images/down.gif" imageName="toggle" border="0"/>
                					<b><bean:message key="view.label.subject" />: </b> <bean:write name="hist" property="subject" /></a></th>
									<logic:notEmpty name="hist" property="author">
                					<th><b><bean:message key="view.label.author" />: </b><bean:write name="hist" property="author.realname" /></th>
									</logic:notEmpty>
                					<th><b><bean:message key="view.label.date" />: </b><bean:write name="hist" property="createDate" /></th>
            					</table>
					</td>
					<td align="right" nowrap> 
						[<xtracker:link action="/anon/reply" paramName="openAnonTicketForm" paramProperty="id" paramId="id" param1Name="hist" param1Property="id" param1Id="historyId"><bean:message key="view.label.reply" /></xtracker:link>] [<html:link action="/anon/comment" paramName="openAnonTicketForm" paramProperty="id" paramId="id"><bean:message key="view.label.comment" /></html:link>]
					</td>
					</tr>
					<logic:notEmpty name="hist" property="content">
					<tr>
					<td colspan="3">
						<div id="ticketsHistoryBlock<bean:write name="idx" />" style="margin: 0px 20px 0px 20px; display: block;">
						<bean:write filter="false" name="hist" property="renderedContent" />
						</div>
					</td>
					</tr>
					</logic:notEmpty>
					</table>
					</logic:equal>
				</logic:iterate>
				</table>
		</td>
	</tr>
	</table>
	</html:form>
</layout:html>

