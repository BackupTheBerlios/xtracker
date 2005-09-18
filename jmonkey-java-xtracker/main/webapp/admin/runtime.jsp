<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax"%>

<layout:html layout="false" key="page.title.admin">
	<%@ include file="basic_header.jsp"%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="ticketlist">
	<tr>
		<th><bean:message key="view.menu.label.system.configure"/></th>
		<th><bean:message key="view.menu.label.configure"/>: <html:link page="/admin/runtime.do"><bean:message key="view.menu.label.configure.runtime" /></html:link>
		| <html:link page="/admin/displayQueue.do"><bean:message key="view.menu.label.configure.queues" /></html:link>
		| <html:link page="/admin/displayProject.do"><bean:message key="view.menu.label.configure.projects" /></html:link>
		| <html:link page="/admin/displayStatus.do"><bean:message key="view.menu.label.configure.status" /></html:link>
		| <html:link page="/admin/displaySeverity.do"><bean:message key="view.menu.label.configure.severity" /></html:link>
		| <html:link page="/admin/displayDisposition.do"><bean:message key="view.menu.label.configure.disposition" /></html:link></th>
	</tr>
	<tr>
	<td colspan="2">
	<layout:form action="/admin/saveRuntime">
		<layout:tabs styleClass="FORM" width="400">
			<layout:tab key="view.label.tab.general" width="50">
				<layout:text name="runtimeForm" property="initialTicketPriority" key="view.label.config.initial.ticket.priority"/>
				<layout:space/>
				<layout:text name="runtimeForm" property="rootXTrackerUriContext" key="view.label.config.xtracker.uri.context"/>
				<layout:text name="runtimeForm" property="attachmentRootDirectory" key="view.label.config.attachment.root.dir"/>
				<layout:space/>
				<layout:checkbox name="runtimeForm" property="maxModifyAgeEnabled" key="view.panel.label.tickets.max.age.enabled"/>
				<layout:text name="runtimeForm" property="maxModifiedAgeDays" key="view.panel.label.tickets.max.age.days.since"/>
				<layout:text name="runtimeForm" property="maxModifiedIncrement" key="view.panel.label.tickets.max.age.increment"/>
			</layout:tab>
			<layout:tab key="view.label.tab.database" width="50">
				<layout:message key="view.label.option.requires.restart" styleClass="boxred"/>
				<layout:select name="runtimeForm" property="hibernateDialect" key="view.label.config.connection.dialect">
					<layout:option value="net.sf.hibernate.dialect.DB2Dialect">DB2</layout:option>
					<layout:option value="net.sf.hibernate.dialect.DB2400Dialect">DB2 AS/400</layout:option>
					<layout:option value="net.sf.hibernate.dialect.DB2390Dialect">DB2 OS390</layout:option>
					<layout:option value="net.sf.hibernate.dialect.PostgreSQLDialect">PostgreSQL</layout:option>
					<layout:option value="net.sf.hibernate.dialect.MySQLDialect">MySQL</layout:option>
					<layout:option value="net.sf.hibernate.dialect.OracleDialect">Oracle (any version)</layout:option>
					<layout:option value="net.sf.hibernate.dialect.Oracle9Dialect">Oracle 9/10g</layout:option>
					<layout:option value="net.sf.hibernate.dialect.SybaseDialect">Sybase</layout:option>
					<layout:option value="net.sf.hibernate.dialect.SybaseAnywhereDialect">Sybase Anywhere</layout:option>
					<layout:option value="net.sf.hibernate.dialect.SQLServerDialect">Microsoft SQL Server</layout:option>
					<layout:option value="net.sf.hibernate.dialect.SAPDBDialect">SAP DB</layout:option>
					<layout:option value="net.sf.hibernate.dialect.InformixDialect">Informix</layout:option>
					<layout:option value="net.sf.hibernate.dialect.HSQLDialect">HypersonicSQL</layout:option>
					<layout:option value="net.sf.hibernate.dialect.IngresDialect">Ingres</layout:option>
					<layout:option value="net.sf.hibernate.dialect.ProgressDialect">Progress</layout:option>
					<layout:option value="net.sf.hibernate.dialect.MckoiDialect">Mckoi SQL</layout:option>
					<layout:option value="net.sf.hibernate.dialect.InterbaseDialect">Interbase</layout:option>
					<layout:option value="net.sf.hibernate.dialect.PointbaseDialect">Pointbase</layout:option>
					<layout:option value="net.sf.hibernate.dialect.FrontbaseDialect">FrontBase</layout:option>
					<layout:option value="net.sf.hibernate.dialect.FirebirdDialect">Firebird</layout:option>
				</layout:select>
				<layout:text name="runtimeForm" property="connectionUrl" key="view.label.config.connection.url"/>
				<layout:text name="runtimeForm" property="connectionDriver" key="view.label.config.connection.driver"/>
				<layout:text name="runtimeForm" property="connectionUsername" key="view.label.config.connection.username"/>
				<layout:text name="runtimeForm" property="connectionPassword" key="view.label.config.connection.password"/>
				<layout:text name="runtimeForm" property="connectionPoolMinSize" key="view.label.config.pool.min.size"/>
				<layout:text name="runtimeForm" property="connectionPoolMaxSize" key="view.label.config.pool.max.size"/>
				<layout:text name="runtimeForm" property="connectionPoolMaxStatements" key="view.label.config.pool.max.statements"/>
				<layout:text name="runtimeForm" property="connectionPoolTimeout" key="view.label.config.pool.timeout"/>
				<layout:text name="runtimeForm" property="validationQuery" key="view.label.config.validation.query"/>
				<layout:text name="runtimeForm" property="querySubstitutions" key="view.label.config.query.substitutions"/>
			</layout:tab>
			<layout:tab key="view.label.tab.mail" width="50">
				<layout:text name="runtimeForm" property="fromEmailAddress" key="view.label.config.from.address"/>
				<layout:text name="runtimeForm" property="smtpMailHost" key="view.label.config.smtp.host"/>
				<layout:checkbox name="runtimeForm" property="smtpHostRequiresPassword" key="view.label.config.smtp.login.required"/>
				<layout:text name="runtimeForm" property="smtpHostUsername" key="view.label.config.smtp.username"/>
				<layout:text name="runtimeForm" property="smtpHostPassword" key="view.label.config.smtp.password"/>
				<layout:space/>
				
				<layout:checkbox name="runtimeForm" property="popCheckingEnabled" key="view.label.config.pop3.check.enabled"/>
				<layout:text name="runtimeForm" property="popMailHost" key="view.label.config.pop3.host"/>
				<layout:text name="runtimeForm" property="popHostUsername" key="view.label.config.pop3.username"/>
				<layout:text name="runtimeForm" property="popHostPassword" key="view.label.config.pop3.password"/>
				<layout:text name="runtimeForm" property="popCheckCronExpression" key="view.label.config.pop3.cron"/>
				<layout:space/>
				<layout:checkbox name="runtimeForm" property="customQueueMailHeaderEnabled" key="view.label.mail.header.enabled"/>
				<layout:text name="runtimeForm" property="customQueueMailHeader" key="view.label.mail.header"/>
				<script type="text/javascript" src="ajaxcore.js"></script>
				<link rel="stylesheet" type="text/css" href="ajaxtags.css" />
				<ajax:autocomplete
				  fieldId="customQueueMailHeader"
				  popupId="customQueueMailHeader-popup"
				  baseUrl="${contextPath}/admin/autocomplete"
				  targetId="customQueueMailHeader"
				  paramName="view"
				  className="autocomplete"
				  progressStyle="throbbing" />
				<layout:space/>
				<layout:message key="view.label.option.requires.restart" styleClass="boxred"/>
				<layout:checkbox name="runtimeForm" property="mailInputStreamServiceEnabled" key="view.label.mail.inputstream.enabled"/>
				<layout:text name="runtimeForm" property="mailInputStreamHost" key="view.label.inputstream.host"/>
				<layout:text name="runtimeForm" property="mailInputStreamPort" key="view.label.inputstream.port"/>
				<layout:text name="runtimeForm" property="mailInputStreamBacklog" key="view.label.inputstream.backlog"/>
			</layout:tab>
			<layout:tab key="view.label.external.linking" width="50">	
				<layout:checkbox name="runtimeForm" property="xplannerEnabled" key="view.label.xplanner.enabled"/>
				<layout:text name="runtimeForm" property="xplannerContext" key="view.label.xplanner.context"/>
				<layout:space/>
				<layout:checkbox name="runtimeForm" property="jiraEnabled" key="view.label.jira.enabled"/>
				<layout:text name="runtimeForm" property="jiraContext" key="view.label.jira.context"/>
			</layout:tab>
			<html:submit>
				<bean:message key="view.label.update"/>
			</html:submit>
		</layout:tabs>
	</layout:form>
	</td>
	</tr>
	</table>
</layout:html>

