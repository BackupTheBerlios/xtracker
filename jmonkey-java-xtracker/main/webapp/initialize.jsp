<%@ page language="java"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"	prefix="html"%>
<%@ taglib uri="http://struts.application-servers.com/layout"	prefix="layout"%>

<layout:html layout="false" key="page.title.my">

<logic:empty name="configInitForm">
<strong><font color="#FF0000">XTracker has already been configured.</font></strong>
	<p><em><font color="#800000">Please use the administration console to make changes.</font></em></p>
</logic:empty>
<logic:notEmpty name="configInitForm">
	<logic:equal name="configInitForm" property="configured" value="true">
		<strong><font color="#FF0000">XTracker has already been configured.</font></strong>
		<p><em><font color="#800000">Please use the administration console to make changes.</font></em></p>
	</logic:equal>
	<logic:equal name="configInitForm" property="configured" value="false">


<html:form action="/init">

	<table width="50%" border="0" cellspacing="0" cellpadding="0">
	
	<tr>
	    <td>
		
		<table width="100%" cellspacing="0" cellpadding="0" border="0" class="boxyello">
		<tr>
			<th colspan="2">Root Directory Configuration</th>
		</tr>
		<tr>
		    <td colspan="2">XPlanner needs to know where you want to store your configuration files and attachments.<br>
			The directory must be read/write by the user running the application container.
			<p>
			A default value has been selected for you.<br>
			You may leave it as is or change it to something that better suits your system.<br>
			You will only be asked this once and the system will attempt to create it if it doesn't already exist.
			</p></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
		    <td colspan="2"><html:text name="configInitForm" property="path" size="60"/></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		</table>	
		
		</td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr>
	    <td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0" class="boxyello">
		<tr>
			<th colspan="2">Database Configuration</th>
		</tr>
		<tr>
		    <td colspan="2">XPlanner uses Hibernate to store its data.<br>
			Please specify the properties for the database you wish to use. Properties for MySQL have 
			been pre-populated as an example.<p>
			<strong>Note:</strong> <em>the account should have rights to create tables, indexes etc.<br>
			If you do not want XTracker to create its database for you, you can manually create it from 
			the source with the</em> hibernate:schema-export <em>Maven goal. You will have to edit the 
			file</em> etc/hibernate/hibernate.properties <em>file first however.</em></p>
			<p>Some drivers are already installed, and some you will have to install yourself after 
			initialization. If you want to use one of the drivers that are not installed, simply add 
			the proper configuration parameters here and add the drivers manually to the <em>WEB-INF/lib</em> 
			directory. A restart will be required.</p>
			The Dialect status ratings are: 
			<ul>
			<li><span class="greenbackgroup">Installed and Tested</span></li>
			<li><span class="yellobackgroup">Installed, Not Tested</span></li>  
			<li><span class="redbackgroup">Not Installed, Not Tested</span></li>
			</ul>
			</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		<tr>
		    <td><bean:message key="view.label.config.connection.dialect"/></td>
		    <td><html:select name="configInitForm" property="hibernateDialect">
				<html:option styleClass="greenbackgroup" value="net.sf.hibernate.dialect.MySQLDialect">MySQL</html:option>
				<html:option styleClass="greenbackgroup" value="net.sf.hibernate.dialect.HSQLDialect">HypersonicSQL</html:option>
				<html:option styleClass="greenbackgroup" value="net.sf.hibernate.dialect.Oracle9Dialect">Oracle 9/10g</html:option>
				<html:option styleClass="yellobackgroup" value="net.sf.hibernate.dialect.PostgreSQLDialect">PostgreSQL</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.DB2Dialect">DB2</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.DB2400Dialect">DB2 AS/400</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.DB2390Dialect">DB2 OS390</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.OracleDialect">Oracle (any version)</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.SybaseDialect">Sybase</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.SybaseAnywhereDialect">Sybase Anywhere</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.SQLServerDialect">Microsoft SQL Server</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.SAPDBDialect">SAP DB</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.InformixDialect">Informix</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.IngresDialect">Ingres</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.ProgressDialect">Progress</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.MckoiDialect">Mckoi SQL</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.InterbaseDialect">Interbase</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.PointbaseDialect">Pointbase</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.FrontbaseDialect">FrontBase</html:option>
				<html:option styleClass="redbackgroup" value="net.sf.hibernate.dialect.FirebirdDialect">Firebird</html:option>
			</html:select></td>
		</tr>
		<tr>
		    <td><bean:message key="view.label.config.connection.url"/></td>
		    <td><html:text name="configInitForm" property="connectionUrl" size="40"/></td>
		</tr>
		<tr>
		    <td><bean:message key="view.label.config.connection.driver"/></td>
		    <td><html:text name="configInitForm" property="connectionDriver" size="40"/></td>
		</tr>
		<tr>
		    <td><bean:message key="view.label.config.connection.username"/></td>
		    <td><html:text name="configInitForm" property="connectionUsername" size="40"/></td>
		</tr>
		<tr>
		    <td><bean:message key="view.label.config.connection.password"/></td>
		    <td><html:text name="configInitForm" property="connectionPassword" size="40"/></td>
		</tr>
		<tr><td>&nbsp;</td></tr>
		</table>	
		</td>
	</tr>
	<tr>
	    <td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		    <td align="right" nowrap><html:submit>
				<bean:message key="view.label.save"/>
			</html:submit></td>
		</tr>
		</table>
		</td>
	</tr>
	</table>

	
</html:form>
</logic:equal>
</logic:notEmpty>
</layout:html>
