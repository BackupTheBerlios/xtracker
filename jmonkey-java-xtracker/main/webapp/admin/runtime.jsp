<%@ page language="java" import="java.util.*" %>
<%@ include file="/taglibs.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title.admin" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>

</head>
<body>
	<%@ include file="basic_header.jsp"%>
	<!-- bean:message key="view.menu.label.system.configure"/ -->
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ticketlist">
	<tr>
		<th colspan="2"><%@ include file="subnav.jsp"%></th>
	</tr>
	<tr>
	<td colspan="2">
	<html:form action="/admin/saveRuntime">
		
		<div id="tabpane0" class="tabcontainer">
			<div class="tabcontainer">
			<ul class="tablist">
				<li id="tabpane0tabs0tab0" onClick="switchTab(4, 0)"><a><bean:message key="view.label.tab.general"/></a></li>
				<li id="tabpane0tabs0tab1" onClick="switchTab(4, 1)"><a><bean:message key="view.label.tab.database"/></a></li>
				<li id="tabpane0tabs0tab2" onClick="switchTab(4, 2)"><a><bean:message key="view.label.tab.mail"/></a></li>
				<li id="tabpane0tabs0tab3" onClick="switchTab(4, 3)"><a><bean:message key="view.label.external.linking"/></a></li>
			</ul>
			</div>
			<div id="tabpane0panels0" class="tabpanel">
				<div id="tabpane0panels0view0" style=""display: block;>
				<div class="groupbox">
						<div class="title"><bean:message key="view.label.config.runtime.defaults.title"/></div>
						<div class="panel">
							<table>
							<tr>
							<td><bean:message key="view.label.config.initial.ticket.priority"/></td><td><html:text name="runtimeForm" property="initialTicketPriority" size="5"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.xtracker.uri.context"/></td><td><html:text name="runtimeForm" property="rootXTrackerUriContext" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.attachment.root.dir"/></td><td><html:text name="runtimeForm" property="attachmentRootDirectory" size="40"/></td>
							</tr>
							</table>
						</div>
					</div>
					<div class="groupbox">
						<div class="title"><bean:message key="view.label.config.runtime.escalation.title"/></div>
						<div class="panel">
							<table>
							<tr>
							<td><html:checkbox name="runtimeForm" property="maxModifyAgeEnabled"/></td><td><bean:message key="view.panel.label.tickets.max.age.enabled"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.panel.label.tickets.max.age.days.since"/></td><td><html:text name="runtimeForm" property="maxModifiedAgeDays" size="5"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.panel.label.tickets.max.age.increment"/></td><td><html:text name="runtimeForm" property="maxModifiedIncrement" size="5"/></td>
							</tr>
							</table>
						</div>
					</div>
				</div>
				<div id="tabpane0panels0view1" style="display: none;">
				<div class="groupbox">
					<div class="title"><bean:message key="view.label.config.runtime.database.title"/></div>
					<div class="panel">
						<table>
							<tr>
							<td colspan="2"><div class="warningbox"><stx:themeImg srcKey="WarningIconSmall" width="15" height="15" border="0"/> <bean:message key="view.label.option.requires.restart"/></div></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.connection.dialect"/></td><td><html:select name="runtimeForm" property="hibernateDialect">
								<html:option value="net.sf.hibernate.dialect.DB2Dialect">DB2</html:option>
								<html:option value="net.sf.hibernate.dialect.DB2400Dialect">DB2 AS/400</html:option>
								<html:option value="net.sf.hibernate.dialect.DB2390Dialect">DB2 OS390</html:option>
								<html:option value="net.sf.hibernate.dialect.PostgreSQLDialect">PostgreSQL</html:option>
								<html:option value="net.sf.hibernate.dialect.MySQLDialect">MySQL</html:option>
								<html:option value="net.sf.hibernate.dialect.OracleDialect">Oracle (any version)</html:option>
								<html:option value="net.sf.hibernate.dialect.Oracle9Dialect">Oracle 9/10g</html:option>
								<html:option value="net.sf.hibernate.dialect.SybaseDialect">Sybase</html:option>
								<html:option value="net.sf.hibernate.dialect.SybaseAnywhereDialect">Sybase Anywhere</html:option>
								<html:option value="net.sf.hibernate.dialect.SQLServerDialect">Microsoft SQL Server</html:option>
								<html:option value="net.sf.hibernate.dialect.SAPDBDialect">SAP DB</html:option>
								<html:option value="net.sf.hibernate.dialect.InformixDialect">Informix</html:option>
								<html:option value="net.sf.hibernate.dialect.HSQLDialect">HypersonicSQL</html:option>
								<html:option value="net.sf.hibernate.dialect.IngresDialect">Ingres</html:option>
								<html:option value="net.sf.hibernate.dialect.ProgressDialect">Progress</html:option>
								<html:option value="net.sf.hibernate.dialect.MckoiDialect">Mckoi SQL</html:option>
								<html:option value="net.sf.hibernate.dialect.InterbaseDialect">Interbase</html:option>
								<html:option value="net.sf.hibernate.dialect.PointbaseDialect">Pointbase</html:option>
								<html:option value="net.sf.hibernate.dialect.FrontbaseDialect">FrontBase</html:option>
								<html:option value="net.sf.hibernate.dialect.FirebirdDialect">Firebird</html:option>
							</html:select></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.connection.url"/></td><td><html:text name="runtimeForm" property="connectionUrl" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.connection.driver"/></td><td><html:text name="runtimeForm" property="connectionDriver" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.connection.username"/></td><td><html:text name="runtimeForm" property="connectionUsername" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.connection.password"/></td><td><html:text name="runtimeForm" property="connectionPassword" size="40"/></td>
							</tr>
							</table>
						</div>
					</div>
					<div class="groupbox">
						<div class="title"><bean:message key="view.label.config.runtime.dbtuning.title"/></div>
						<div class="panel">
							<table>
							<tr>
							<td><bean:message key="view.label.config.pool.min.size"/></td><td><html:text name="runtimeForm" property="connectionPoolMinSize" size="5"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.pool.max.size"/></td><td><html:text name="runtimeForm" property="connectionPoolMaxSize" size="5"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.pool.max.statements"/></td><td><html:text name="runtimeForm" property="connectionPoolMaxStatements" size="5"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.pool.timeout"/></td><td><html:text name="runtimeForm" property="connectionPoolTimeout" size="5"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.validation.query"/></td><td><html:text name="runtimeForm" property="validationQuery" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.query.substitutions"/></td><td><html:text name="runtimeForm" property="querySubstitutions" size="40"/></td>
							</tr>
							</table>
						</div>	
					</div>
				</div>
				<div id="tabpane0panels0view2" style="display: none;">
					<div class="groupbox">
						<div class="title"><bean:message key="view.label.config.runtime.smtp.title"/></div>
						<div class="panel">
							<table>
							<tr>
							<td><bean:message key="view.label.config.from.address"/></td><td><html:text name="runtimeForm" property="fromEmailAddress" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.smtp.host"/></td><td><html:text name="runtimeForm" property="smtpMailHost" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.smtp.login.required"/></td><td><html:checkbox name="runtimeForm" property="smtpHostRequiresPassword"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.smtp.username"/></td><td><html:text name="runtimeForm" property="smtpHostUsername" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.smtp.password"/></td><td><html:text name="runtimeForm" property="smtpHostPassword" size="40"/></td>
							</tr>
							</table>
						</div>
					</div>
					<div class="groupbox">
						<div class="title"><bean:message key="view.label.config.runtime.pop3.title"/></div>
						<div class="panel">
							<table>
							<tr>
							<td><bean:message key="view.label.config.pop3.check.enabled"/></td><td><html:checkbox name="runtimeForm" property="popCheckingEnabled"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.pop3.ssl.enabled"/></td><td><html:checkbox name="runtimeForm" property="popUsingSslEnabled"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.pop3.host"/></td><td><html:text name="runtimeForm" property="popMailHost" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.pop3.username"/></td><td><html:text name="runtimeForm" property="popHostUsername" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.pop3.password"/></td><td><html:text name="runtimeForm" property="popHostPassword" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.config.pop3.check.interval"/></td><td><html:text name="runtimeForm" property="popCheckIntervalMinutes" size="40"/></td>
							</tr>
							</table>
						</div>
					</div>
					<div class="groupbox">
						<div class="title"><bean:message key="view.label.config.runtime.mailheader.title"/></div>
						<div class="panel">
							<table>
							<tr>
							<td><bean:message key="view.label.mail.header.enabled"/></td><td><html:checkbox name="runtimeForm" property="customQueueMailHeaderEnabled"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.mail.header"/></td><td><html:text name="runtimeForm" property="customQueueMailHeader" size="40"/></td>
							</tr>
							</table>
						</div>
					</div>
					<div class="groupbox">
						<div class="title"><bean:message key="view.label.config.runtime.rms.title"/></div>
						<div class="panel">
							<table>
							<tr>
							<td colspan="2"><div class="warningbox"><stx:themeImg srcKey="WarningIconSmall" width="15" height="15" border="0"/> <bean:message key="view.label.option.requires.restart"/></div></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.mail.inputstream.enabled"/></td><td><html:checkbox name="runtimeForm" property="mailInputStreamServiceEnabled"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.inputstream.host"/></td><td><html:text name="runtimeForm" property="mailInputStreamHost" size="40"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.inputstream.port"/></td><td><html:text name="runtimeForm" property="mailInputStreamPort" size="5"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.inputstream.backlog"/></td><td><html:text name="runtimeForm" property="mailInputStreamBacklog" size="5"/></td>
							</tr>
							</table>
						</div>
					</div>
				</div>
				<div id="tabpane0panels0view3" style="display: none;">
					<div class="groupbox">
						<div class="title"><bean:message key="view.label.config.runtime.xplanner.title"/></div>
						<div class="panel">
							<table>
							<tr>
							<td><bean:message key="view.label.xplanner.enabled"/></td><td><html:checkbox name="runtimeForm" property="xplannerEnabled"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.xplanner.context"/></td><td><html:text name="runtimeForm" property="xplannerContext" size="40"/></td>
							</tr>
							</table>
						</div>
					</div>
					<div class="groupbox">
						<div class="title"><bean:message key="view.label.config.runtime.jira.title"/></div>
						<div class="panel">
							<table>
							<tr>
							<td><bean:message key="view.label.jira.enabled"/></td><td><html:checkbox name="runtimeForm" property="jiraEnabled"/></td>
							</tr>
							<tr>
							<td><bean:message key="view.label.jira.context"/></td><td><html:text name="runtimeForm" property="jiraContext" size="40"/></td>
							</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<html:submit>
				<bean:message key="view.label.update"/>
			</html:submit>
		</div>
	</html:form>
	


				<!-- ajax:autocomplete
				  fieldId="customQueueMailHeader"
				  popupId="customQueueMailHeader-popup"
				  baseUrl="${contextPath}/admin/autocomplete"
				  targetId="customQueueMailHeader"
				  paramName="view"
				  className="autocomplete"
				  progressStyle="throbbing" / -->
	</td>
	</tr>
	</table>
	
	<%@ include file="/footer.jsp"%>
</body>
</html:html>

