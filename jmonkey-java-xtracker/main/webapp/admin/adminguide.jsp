<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>

<layout:html layout="false" key="page.title.admin">
	<%@ include file="basic_header.jsp"%>
	<h2>XPTracker Administrators Guide</h2>
	
	<h3>General Configuration</h3>
	<strong>Initial Ticket Priority</strong><br/>
			This is the default priority new tickets will get when they are created.
			<p/>
	<strong>XTracker Context</strong><br/>
			Set this to the location of XTracker e.g. http://www.example.com/xtracker. The value is used to create links in email.
			<p/>
	<strong>Store Attachments in</strong><br/>
 			Currently, XTracker stores email/history attachments <em>(as well as configuration)</em> in a directory on the file system. Use this to tell XTracker where to store this information.
	<p/>
	<h3>Database Settings</h3>
	<em>Most database settings will have been set up during your installation. Those settings which are obvious are not documented.</em><br/>
	<strong>Hibernate Dialect</strong><br/>
			XTracker uses Hibernate for it's database access. It has been developed on MySQL but should work with any "dialect" that Hibernate supports.
			<p/>
	<strong>Connection URL</strong><br/>
			This is a standard JDBC connection URL. Set this to point at the database you have set up for XTracker.
			<p/>
	<strong>JDBC Driver</strong><br/>
			This is the driver class for the JDBC library you are using.
			<p/>
		
		<h3>Mail Settings</h3>
	<strong>Setting up your mail server</strong><br/>
			XTracker uses a single POP3 mail account to get incoming mail. Set up an account for extracker, and provide aliases for the Queues that you have set up.<br/>
			The Queue <em>Email Alias</em> is the user portion of the address e.g. If you wnated to set up a queue "Helpdesk", set up and account xtracker@example.com that xtracker will use to send and receive mail, then add an alias helpdesk@example.com. You queue should have the <em>Email Alias</em> "helpdesk" set in the queue properties.
			<p/>
			
	<strong>Default XTracker Email</strong><br/>
			This is teh default address XTracker uses, it is the address of the real account that mail will be downlaoded from and it's domain is used to determin various other attributes, including the email address of a queue <em>(which you have aliased to this address, as in helpdesk@example.com)</em>.
			<p/>
	<strong>SMTP: Login Required</strong><br/>
			Check this option, and add a username and password if your SMTP server requires the user to login.
			<p/>
	<strong>POP Check Enabled</strong><br/>
			Check this option if XTracker should look for new mail. If this is set, the username and password should also be set.
			<p/>
	<strong>POP3 Check Cron</strong><br/>
			This defines how often XTracker should check for mail. THe Cron syntax is a bit different from the standard cron syntax. To find out more about the cron syntax used, see <a href="http://www.opensymphony.com/quartz/">Quartz</a> site.
</layout:html>


