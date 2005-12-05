<%@ page language="java" import="java.util.*" %>
<%@ include file="/taglibs.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title.my" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>
</head>
<body>
	<%@ include file="basic_header.jsp"%>
	<div>
	<html:form action="/my/openTicket">
	<table width="100%" cellspacing="2" cellpadding="2" border="0">
	<tr>
	    <td colspan="2" class="contentheader">
		<stx:themeImg srcKey="File"/> #<bean:write name="openTicketForm" property="id" />: <bean:write name="openTicketForm" property="subject" />
		</td>
	</tr>
	<tr>
	    <td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxred">
					<tr>
					<th colspan="3"><html:link action="/my/details" styleClass="stickyToolTip" paramName="openTicketForm" paramProperty="id" paramId="id"><stx:themeImg srcKey="Edit" width="23" height="18" border="0"/> <bean:message key="view.panel.label.ticket.details" /></html:link></th>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.ticket.number" />:</td>
					<td><bean:write name="openTicketForm" property="id" /></td>
					<td></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.priority"  />:</td>
					<td><bean:write name="openTicketForm" property="priority" /></td>
					<td></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.hours.worked"  />:</td>
					<td><bean:write name="openTicketForm" property="worked" /></td>
					<td></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.status" />:</td>
					<td><bean:write name="openTicketForm" property="status.label" /></td>
					<td></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.severity"  />:</td>
					<td><bean:write name="openTicketForm" property="severity.label" /></td>
					<td></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.disposition"  />:</td>
					<td><bean:write name="openTicketForm" property="disposition.label" /></td>
					<td></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.queue"  />:</td>
					<td><bean:write name="openTicketForm" property="queue.name" /></td>
					<td></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.project"  />:</td>
					<td><logic:notEmpty name="openTicketForm" property="project">
							<bean:write name="openTicketForm" property="project.name" />
						</logic:notEmpty><logic:empty name="openTicketForm" property="project">None</logic:empty></td>
					<td></td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxblue">
					<tr>
					<th colspan="3"><html:link action="/my/people" styleClass="stickyToolTip" paramName="openTicketForm" paramProperty="id" paramId="id"><stx:themeImg srcKey="Edit" width="23" height="18" border="0"/> <bean:message key="view.panel.label.ticket.people" /></html:link></th>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.requestor"  />:</td>
					<td><html:link action="/my/person" paramName="openTicketForm" paramProperty="requestor.id" paramId="id"><bean:write name="openTicketForm" property="requestor.realname"  /></html:link></td>
					<td></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.owners"  />:</td>
					<td><logic:iterate name="openTicketForm" property="owners" id="owner">
						<html:link action="/my/person" paramName="owner" paramProperty="id" paramId="id"><bean:write name="owner" property="initials"/></html:link>&nbsp; 
					</logic:iterate></td>
					<td></td>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.watchers"  />:</td>
					<td><logic:iterate name="openTicketForm" property="watchers" id="watcher">
						<html:link action="/my/person" paramName="watcher" paramProperty="id" paramId="id"><bean:write name="watcher" property="initials"/></html:link>&nbsp; 
					</logic:iterate></td>
					<td></td>
					</tr>
				</table>
		</td>
		<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxgreen">
					<tr>
					<th colspan="3"><html:link action="/my/relationships" styleClass="stickyToolTip" paramName="openTicketForm" paramProperty="id" paramId="id"><stx:themeImg srcKey="Edit" width="23" height="18" border="0"/> <bean:message key="view.panel.label.ticket.relationships" /></html:link></th>
					</tr>
					<tr>
					<td width="50%" nowrap><bean:message key="view.label.depends.on"  />: <logic:iterate name="openTicketForm" property="dependsOn" id="tid">
						<html:link action="/my/openTicket" paramName="tid" paramId="id" ><bean:write name="tid" /></html:link>&nbsp;
					</logic:iterate></td>
					<td width="50%" nowrap><bean:message key="view.label.depended.on.by"  />: <logic:iterate name="openTicketForm" property="dependedOnBy" id="tid">
						<html:link action="/my/openTicket" paramName="tid" paramId="id" ><bean:write name="tid" /></html:link>&nbsp;
					</logic:iterate></td>
					<td></td>
					</tr>
					<tr>
					<td width="50%" nowrap><bean:message key="view.label.parents"  />: <logic:iterate name="openTicketForm" property="parents" id="tid">
						<html:link action="/my/openTicket" paramName="tid" paramId="id" ><bean:write name="tid" /></html:link>&nbsp;
					</logic:iterate></td>
					<td width="50%" nowrap><bean:message key="view.label.children"  />: <logic:iterate name="openTicketForm" property="children" id="tid">
						<html:link action="/my/openTicket" paramName="tid" paramId="id" ><bean:write name="tid" /></html:link>&nbsp;
					</logic:iterate></td>
					<td></td>
					</tr>
					<tr>
					<td width="50%" nowrap><bean:message key="view.label.refers.to"  />: <logic:iterate name="openTicketForm" property="refersTo" id="tid">
						<html:link action="/my/openTicket" paramName="tid" paramId="id" ><bean:write name="tid" /></html:link>&nbsp;
					</logic:iterate></td>
					<td width="50%" nowrap><bean:message key="view.label.refered.to.by"  />: <logic:iterate name="openTicketForm" property="referredToBy" id="tid">
						<html:link action="/my/openTicket" paramName="tid" paramId="id" ><bean:write name="tid" /></html:link>&nbsp;
					</logic:iterate></td>
					<td></td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxpurple">
					<tr>
					<th colspan="5"><html:link action="/my/dates" styleClass="stickyToolTip" paramName="openTicketForm" paramProperty="id" paramId="id"><stx:themeImg srcKey="Edit" width="23" height="18" border="0"/> <bean:message key="view.panel.label.ticket.dates" /></html:link></th>
					</tr>
					<tr>
					<td width="100" nowrap><bean:message key="view.label.create.date"  />:</td>
					<td><bean:write name="openTicketForm" property="createDate" /></td>
					<td width="100" nowrap><bean:message key="view.label.modify.date"  />:</td>
					<td><bean:write name="openTicketForm" property="modifyDate" /></td>
					<td></td>
					</tr>
					<td width="100" nowrap><bean:message key="view.label.due.date"  />:</td>
					<td><logic:notEmpty name="openTicketForm" property="dueDate"><bean:write name="openTicketForm" property="dueDate" /></logic:notEmpty></td>
					<td width="100" nowrap><bean:message key="view.label.closed.date"  />:</td>
					<td><logic:notEmpty name="openTicketForm" property="closedDate"><bean:write name="openTicketForm" property="closedDate" /></logic:notEmpty></td>
					<td></td>
					</tr>
				</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxorange">
					<tr>
					<th colspan="3"><bean:message key="view.label.external.linking" /></th>
					</tr>
					<tr>
					<td colspan="2" nowrap>
					<table width="100%" cellspacing="0" cellpadding="2" border="0">
					<logic:equal name="openTicketForm" property="xplannerEnabled" value="true">
					<tr>
					    <td valign="top">
						<logic:equal name="openTicketForm" property="xplannerLinkInfo" value=""><bean:message key="view.label.xplanner.story"  />: <html:link action="/my/editXplannerLink" paramName="openTicketForm" paramProperty="id" paramId="ticketId"><bean:message key="view.label.xplanner.create.link" /></html:link></logic:equal>
						<logic:notEqual name="openTicketForm" property="xplannerLinkInfo" value=""><bean:message key="view.label.xplanner.story"  />: <a href="<bean:write name="openTicketForm" property="xplannerLinkInfo.uri" />" target="_blank"><bean:write name="openTicketForm" property="xplannerLinkInfo.label" /></a></logic:notEqual>
						</td>
					</tr>
					</logic:equal>
					<logic:equal name="openTicketForm" property="jiraEnabled" value="true">
					<tr>
					    <td valign="top">
						<logic:equal name="openTicketForm" property="jiraLinkInfo" value=""><bean:message key="view.label.jira.issue"  />: <html:link action="/my/editJiraLink" paramName="openTicketForm" paramProperty="id" paramId="ticketId"><bean:message key="view.label.jira.create.link" /></html:link></logic:equal>
						<logic:notEqual name="openTicketForm" property="jiraLinkInfo" value=""><bean:message key="view.label.jira.issue"  />: <a href="<bean:write name="openTicketForm" property="jiraLinkInfo.uri" />" target="_blank"><bean:write name="openTicketForm" property="jiraLinkInfo.label" /></a></logic:notEqual>
						</td>
					</tr>
					</logic:equal>
					</table>
					</td>
					<td></td>
					</tr>
				</table>
		</td>
	</tr>
	<tr>
	    <td colspan="2" valign="top">
				<div style="border: 1px dashed Olive; margin-top: 10px;">
				<div style="background-color: #F0E68C; width: 100%; font-weight: bold;"><bean:message key="view.panel.label.ticket.messages" /></div>
				<logic:iterate name="openTicketForm" property="history" id="hist" indexId="idx">
						
								<logic:equal name="hist" property="system" value="false">
								<!-- table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxhistory" -->
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td nowrap>
									            <table cellspacing="1" style="border-bottom: 1px dashed Black; margin-top: 5px; border-top-color: Black; border-top-style: solid; border-top-width: 1px;"><tr>
													<th><a href="javascript:toggleLayer('ticketsHistoryBlock<bean:write name="idx" />');" title="Open/Close"><html:img page="/images/down.gif" imageName="toggle" border="0"/></a>
				                					<b><bean:message key="view.label.subject" />: </b> <bean:write name="hist" property="subject" /></a></th>
													<logic:notEmpty name="hist" property="author">
				                					<th><b><bean:message key="view.label.author" />: </b><bean:write name="hist" property="author.realname" /></th>
													</logic:notEmpty>
				                					<th><b><bean:message key="view.label.date" />: </b><bean:write name="hist" property="createDate" /></th>
				            					</table>
									</td>
									<td align="right" nowrap>
										<logic:notEmpty name="hist" property="messageReferences">
											[<html:link action="/my/mailReferences" target="_blank" paramName="hist" paramProperty="id" paramId="historyId"><bean:message key="view.label.mail.references" /></html:link>]
										</logic:notEmpty>
										[<xtracker:link action="/my/reply" paramName="openTicketForm" paramProperty="id" paramId="id" param1Name="hist" param1Property="id" param1Id="historyId"><bean:message key="view.label.reply" /></xtracker:link>] [<html:link action="/my/comment" paramName="openTicketForm" paramProperty="id" paramId="id"><bean:message key="view.label.comment" /></html:link>]
									</td>
								</tr>
								<logic:notEmpty name="hist" property="content">
								<tr>
									<td colspan="3">
										<div id="ticketsHistoryBlock<bean:write name="idx" />" style="margin: 0px 20px 0px 20px; display: block;">
										<bean:write filter="false" name="hist" property="renderedContent" />
										
										<xtracker:attachments name="hist" listName="attachments">
										<logic:notEmpty name="attachments">
											<p>
											<table border="0" cellspacing="0" cellpadding="2" align="right">
											<logic:iterate name="attachments" id="histAttach" indexId="idx">
											<tr>
												<!-- need a tag for this -->
												<td valign="top" nowrap><a href="/xtracker/download/<bean:write filter="true" name="histAttach" property="path" />"><bean:write filter="true" name="histAttach" property="name" /></a></td>
											    <td valign="top" nowrap><bean:write filter="false" name="histAttach" property="size" /></td>
											</tr>
											</logic:iterate>
											</table>
										</logic:notEmpty>
										</xtracker:attachments>
										
										
										</div>
										
									</td>
								</tr>
								</logic:notEmpty>
								</table>
								</logic:equal>
								</logic:iterate>
				</div>
					
					<div style="border: 1px dashed Olive; margin-top: 10px;">
					<div style="background-color: Silver; width: 100%; font-weight: bold;"><bean:message key="view.panel.label.ticket.history" /></div>
						<ul>
     						<logic:iterate name="openTicketForm" property="history" id="hist" indexId="idx">
								<logic:equal name="hist" property="system" value="true">
									<li><bean:write name="hist" property="createDate" /> - <bean:write name="hist" property="subject" /></li>
								</logic:equal>
							</logic:iterate>
						</ul>
					</div>
					<!-- /tr>
				</table -->
		</td>
	</tr>
	</table>
	</html:form>
	</div>
	<!-- baseUrl="${contextPath}/tooltip" -->
	<ajax:callout
  		baseUrl="/xtracker/tooltip"
 		sourceClass="stickyToolTip"
		parameters="q={ajaxParameter}"
		useTitleBar="false" 
  		classNamePrefix="callout"
  		boxPosition="bottom right"
  		title="Definition"
  		timeout="5000" />
		
<script> 
	new Rico.Accordion( 'accordionExample', {panelHeight:227} );
</script>

  
	<%@ include file="footer.jsp"%>
</body>
</html:html>

