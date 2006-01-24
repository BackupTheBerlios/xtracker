<%@ page language="java" import="java.util.*" %>
<%@ include file="/taglibs.jsp"%>
<%@ include file="/preamble.jsp"%>
<html:html>
<head>
<!-- <%
 Object searchForm = request.getAttribute("searchForm");
 if(searchForm != null){
  	java.util.Map props = org.apache.commons.beanutils.BeanUtils.describe(searchForm);
  	Set keys = props.keySet();
  	for (Object key : keys) {
  		Object value = props.get(key);
		out.println(key.toString() + "=" + (value != null?value.toString():null) );
  	}
  }else{
  	out.println("searchForm is null!");
  }
 %> -->
<title><bean:message key="page.title.search" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<!-- %@ include file="/theme.jsp"% -->

</head>
<body>
	<%@ include file="/logo.jsp"%>
	<%@ include file="/my/nav.jsp"%>
	
	<div>
	<table>
	<tr>
	<td>
	<html:form action="/my/search" onsubmit="return (validateDate('searchForm','createDate') && validateDate('searchForm','modifyDate') && validateDate('searchForm','dueDate') && validateDate('searchForm','closedDate'));">
		<div>
		<ul>
			<li><html:reset><bean:message key="view.label.reset"/></html:reset></li>
			<li><html:submit><bean:message key="view.label.search"/></html:submit></li>
		</ul>
		<fieldset id="propertiesGroup">
			<legend style="cursor: pointer;" onclick="rollupFieldset('propertiesGroup', 'propertiesGroupContent')">Properties</legend>
			<div id="propertiesGroupContent">
			<ul>
				<li><label for="subject"><bean:message key="view.label.subject"/></label></li>
				<li><html:select name="searchForm" property="subjectOp">
						<html:option value="is">Is</html:option>
						<html:option value="like">Contains</html:option>
					</html:select></li>
				<li><html:text name="searchForm" property="subject"  styleId="subject" size="25" maxlength="255"/></li>
			</ul>
			
			<ul>
				<li><label for="priority"><bean:message key="view.label.priority"/></label></li>
				<li><html:select name="searchForm" property="priorityOp">
						<html:option value="is">Is</html:option>
						<html:option value="gt">Greater</html:option>
						<html:option value="lt">Less</html:option>
					</html:select></li>
				<li><html:text name="searchForm" property="priority" styleId="priority" size="3" maxlength="3"/></li>
			</ul>
			
			<ul>
				<li><label for="worked"><bean:message key="view.label.hours.worked"/></label></li>
				<li><html:select name="searchForm" property="workedOp">
						<html:option value="is">Is</html:option>
						<html:option value="gt">Greater</html:option>
						<html:option value="lt">Less</html:option>
					</html:select></li>
				<li><html:text name="searchForm" property="worked" styleId="worked" size="5" maxlength="10"/></li>
			</ul>
			
			<ul>
				<li><label for="queue"><bean:message key="view.label.queue"/></label></li>
				<li><html:select name="searchForm" property="queueOp">
						<html:option value="is">Is</html:option>
						<html:option value="not">Is Not</html:option>
					</html:select></li>
				
				<li><html:select name="searchForm" property="queueId" styleId="queue">
						<html:option value="">Any</html:option>
						<html:optionsCollection name="searchForm" property="queueList" value="id" label="name" />
					</html:select></li>
			</ul>
			
			<ul>
				<li><label for="project"><bean:message key="view.label.project"/></label></li>
				<li><html:select name="searchForm" property="projectOp">
						<html:option value="is">Is</html:option>
						<html:option value="not">Is Not</html:option>
					</html:select></li>
				<li><html:select name="searchForm" property="projectId" styleId="project">
						<html:option value="">Any</html:option>
						<html:optionsCollection name="searchForm" property="projectList" value="id" label="name" />
					</html:select></li>
			</ul>
			
			<ul>
				<li><label for="status"><bean:message key="view.label.status"/></label></li>
				<li><html:select name="searchForm" property="statusOp">
						<html:option value="is">Is</html:option>
						<html:option value="not">Is Not</html:option>
					</html:select></li>
				<li><html:select name="searchForm" property="statusId" styleId="status">
						<html:option value="">Any</html:option>
						<html:optionsCollection name="searchForm" property="statusList" value="id" label="label" />
					</html:select></li>
			</ul>
			
			<ul>
				<li><label for="severity"><bean:message key="view.label.severity"/></label></li>
				<li><html:select name="searchForm" property="severityOp">
						<html:option value="is">Is</html:option>
						<html:option value="not">Is Not</html:option>
					</html:select></li>
				<li><html:select name="searchForm" property="severityId" styleId="severity">
						<html:option value="">Any</html:option>
						<html:optionsCollection name="searchForm" property="severityList" value="id" label="label" />
					</html:select></li>
			</ul>
			
			<ul>
				<li><label for="disposition"><bean:message key="view.label.disposition"/></label></li>
				<li><html:select name="searchForm" property="dispositionOp">
						<html:option value="is">Is</html:option>
						<html:option value="not">Is Not</html:option>
					</html:select></li>
				<li><html:select name="searchForm" property="dispositionId" styleId="disposition">
						<html:option value="">Any</html:option>
						<html:optionsCollection name="searchForm" property="dispositionList" value="id" label="label" />
					</html:select></li>
			</ul>
			</div>
		</fieldset>
		
		<fieldset id="peopleGroup">
			<legend style="cursor: pointer;" onclick="rollupFieldset('peopleGroup', 'peopleGroupContent')">People</legend>
			<div id="peopleGroupContent">
			<ul>
				<li><label for="requestor"><bean:message key="view.label.requestor"/></label></li>
				<li><html:select name="searchForm" property="requestorOp">
						<html:option value="is">Is</html:option>
						<html:option value="not">Is Not</html:option>
					</html:select></li>
				<li><html:select name="searchForm" property="requestorId" styleId="requestor">
						<html:option value="">Any</html:option>
						<html:optionsCollection name="searchForm" property="personList" value="id" label="realname" />
					</html:select></li>
			</ul>
			
			<ul>
				<li><label for="owner"><bean:message key="view.label.owner"/></label></li>
				<li><html:select name="searchForm" property="ownerOp">
						<html:option value="is">Is</html:option>
						<html:option value="not">Is Not</html:option>
					</html:select></li>
				<li><html:select name="searchForm" property="ownerId" styleId="owner">
						<html:option value="">Any</html:option>
						<html:optionsCollection name="searchForm" property="personList" value="id" label="realname" />
					</html:select></li>
			</ul>
			
			<ul>
				<li><label for="watcher"><bean:message key="view.label.watcher"/></label></li>
				<li><html:select name="searchForm" property="watcherOp">
						<html:option value="is">Is</html:option>
						<html:option value="not">Is Not</html:option>
					</html:select></li>
				<li><html:select name="searchForm" property="watcherId" styleId="watcher">
						<html:option value="">Any</html:option>
						<html:optionsCollection name="searchForm" property="personList" value="id" label="realname" />
					</html:select></li>
			</ul>

			</div>
		</fieldset>
		
		<fieldset id="datesGroup">
			<legend style="cursor: pointer;" onclick="rollupFieldset('datesGroup', 'datesGroupContent')">Dates</legend>
			<div id="datesGroupContent">
			<ul>
				<li><label for="createDate"><bean:message key="view.label.create.date"/></label></li>
				<li><html:select name="searchForm" property="createDateOp">
						<html:option value="is">On</html:option>
						<html:option value="gt">After</html:option>
						<html:option value="lt">Before</html:option>
					</html:select></li>
				<li><html:text name="searchForm" property="createDate" styleId="createDate" /><stx:themeImg srcKey="CalendarButton" styleId="createDateTrigger" width="15" height="18" border="0"/></li>
			</ul>
			
			<ul>
				<li><label for="modifyDate"><bean:message key="view.label.modify.date"/></label></li>
				<li><html:select name="searchForm" property="modifyDateOp">
						<html:option value="is">On</html:option>
						<html:option value="gt">After</html:option>
						<html:option value="lt">Before</html:option>
					</html:select></li>
				<li><html:text name="searchForm" property="modifyDate" styleId="modifyDate" /><stx:themeImg srcKey="CalendarButton" styleId="modifyDateTrigger" width="15" height="18" border="0"/></li>
			</ul>
			
			<ul>
				<li><label for="dueDate"><bean:message key="view.label.due.date"/></label></li>
				<li><html:select name="searchForm" property="dueDateOp">
						<html:option value="is">On</html:option>
						<html:option value="gt">After</html:option>
						<html:option value="lt">Before</html:option>
					</html:select></li>
				<li><html:text name="searchForm" property="dueDate" styleId="dueDate" /><stx:themeImg srcKey="CalendarButton" styleId="dueDateTrigger" width="15" height="18" border="0"/></li>
			</ul>
			
			<ul>
				<li><label for="closedDate"><bean:message key="view.label.closed.date"/></label></li>
				<li><html:select name="searchForm" property="closedDateOp">
						<html:option value="is">On</html:option>
						<html:option value="gt">After</html:option>
						<html:option value="lt">Before</html:option>
					</html:select></li>
				<li><html:text name="searchForm" property="closedDate" styleId="closedDate" /><stx:themeImg srcKey="CalendarButton" styleId="closedDateTrigger" width="15" height="18" border="0"/></li>
			</ul>
			</div>
		</fieldset>
		</div>
	</html:form>
	<script type="text/javascript">
  		Calendar.setup( {
		      inputField  : "createDate",
		      ifFormat    : "%Y-%m-%d",
		      daFormat    : "%Y-%m-%d",
		      button      : "createDateTrigger",
		      showOthers  : "true"
	    });
	    
	    Calendar.setup( {
		      inputField  : "modifyDate",
		      ifFormat    : "%Y-%m-%d",
		      daFormat    : "%Y-%m-%d",
		      button      : "modifyDateTrigger",
		      showOthers  : "true"
	    });
	    
	    Calendar.setup( {
		      inputField  : "dueDate",
		      ifFormat    : "%Y-%m-%d",
		      daFormat    : "%Y-%m-%d",
		      button      : "dueDateTrigger",
		      showOthers  : "true"
	    });
	    
	    Calendar.setup( {
		      inputField  : "closedDate",
		      ifFormat    : "%Y-%m-%d",
		      daFormat    : "%Y-%m-%d",
		      button      : "closedDateTrigger",
		      showOthers  : "true"
	    });
	</script>
	</td>
	<td>
		<fieldset>
			<legend>Search Results</legend>
			
			<table style="width:100%" class="ticketlist">
				<logic:empty name="searchForm" property="searchResults">
				<tbody>
					<tr>
						<th><bean:message key="view.message.nosearchresults"/></td>
					</tr>
				</tbody>
				</logic:empty>
				<logic:notEmpty name="searchForm" property="searchResults">
				<thead>
					<colgroup span="5">
						<col width="20"></col>
						<col width="3"></col>
						<col width="50%"></col>
						<col></col>
						<col></col>
					</colgroup>
					<tr>
						<th width="20">#</td>
						<th width="3">!</td>
						<th width="65%">Subject</td>
						<th>Requester</td>
						<th>Status</td>
					</tr>
				</thead>
						
				<tbody>
					<logic:iterate name="searchForm" property="searchResults" id="ticket" indexId="idx">
					<tr class="row<%= idx.intValue() % 2 %>">
						<td valign="top" style="background-color:<bean:write name="ticket" property="severity.colour" />;"><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="id"  /></html:link></td>
						<td valign="top" style="background-color:<bean:write name="ticket" property="severity.colour" />;"><bean:write name="ticket" property="priority"  /></td>
						<td valign="top"><html:link action="/my/openTicket" paramName="ticket" paramId="id" paramProperty="id"><bean:write name="ticket" property="subject"  /></html:link></td>
						<td valign="top">
							<logic:notEmpty name="ticket" property="requestor">
								<html:link action="/my/person" paramName="ticket" paramProperty="requestor.id" paramId="id">
								<bean:write name="ticket" property="requestor.realname" /></html:link>
							</logic:notEmpty>
						</td>
						<td valign="top"  style="background-color:<bean:write name="ticket" property="status.colour" />;"><bean:write name="ticket" property="status.label" /></td>
					</tr>
					</logic:iterate>
				</tbody>
				</logic:notEmpty>
			</table>
		</fieldset>
	</td>
	</tr>
	</table>
	</div>

	<%@ include file="/footer.jsp"%>
</body>
</html:html>

