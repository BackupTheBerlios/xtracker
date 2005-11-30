package com.jmonkey.xtracker.admin.runtime;

import org.apache.struts.action.ActionForm;

public class RuntimeForm extends ActionForm {
	private Integer	initialTicketPriority			= null;
	private String	hibernateDialect				= null;
	private String	connectionUrl					= null;
	private String	connectionDriver				= null;
	private String	connectionUsername				= null;
	private String	connectionPassword				= null;
	private Integer	connectionPoolMinSize			= null;
	private Integer	connectionPoolMaxSize			= null;
	private Integer	connectionPoolMaxStatements		= null;
	private Integer	connectionPoolTimeout			= null;
	private String	validationQuery					= null;
	private String	querySubstitutions				= null;
	private String	smtpMailHost					= null;
	private boolean	smtpHostRequiresPassword		= false;
	private String	smtpHostUsername				= null;
	private String	smtpHostPassword				= null;
	private String	fromEmailAddress				= null;
	private String	popCheckCronExpression			= null;
	private String	popMailHost						= null;
	private String	popHostUsername					= null;
	private String	popHostPassword					= null;
	private boolean	popUsingSslEnabled				= false;
	private boolean	popCheckingEnabled				= false;
	private String	attachmentRootDirectory			= null;
	private String	rootXTrackerUriContext			= null;
	private boolean	maxModifyAgeEnabled				= false;
	private int		maxModifiedAgeDays				= 0;
	private int		maxModifiedIncrement			= 0;

	private boolean	customQueueMailHeaderEnabled	= false;
	private String	customQueueMailHeader			= null;

	private String	xplannerContext					= null;
	private boolean	xplannerEnabled					= false;

	private String	jiraContext						= null;
	private boolean	jiraEnabled						= false;

	private String	mailInputStreamHost				= null;
	private int		mailInputStreamPort				= -1;
	private int		mailInputStreamBacklog			= -1;
	private boolean	mailInputStreamServiceEnabled	= false;

	public RuntimeForm() {
		super();
	}

	public Integer getInitialTicketPriority() {
		return initialTicketPriority;
	}

	public void setInitialTicketPriority(Integer initialTicketPriority) {
		this.initialTicketPriority = initialTicketPriority;
	}

	public String getConnectionDriver() {
		return connectionDriver;
	}

	public void setConnectionDriver(String connectionDriver) {
		this.connectionDriver = connectionDriver;
	}

	public String getConnectionPassword() {
		return connectionPassword;
	}

	public void setConnectionPassword(String connectionPassword) {
		this.connectionPassword = connectionPassword;
	}

	public Integer getConnectionPoolMaxSize() {
		return connectionPoolMaxSize;
	}

	public void setConnectionPoolMaxSize(Integer connectionPoolMaxSize) {
		this.connectionPoolMaxSize = connectionPoolMaxSize;
	}

	public Integer getConnectionPoolMaxStatements() {
		return connectionPoolMaxStatements;
	}

	public void setConnectionPoolMaxStatements(Integer connectionPoolMaxStatements) {
		this.connectionPoolMaxStatements = connectionPoolMaxStatements;
	}

	public Integer getConnectionPoolMinSize() {
		return connectionPoolMinSize;
	}

	public void setConnectionPoolMinSize(Integer connectionPoolMinSize) {
		this.connectionPoolMinSize = connectionPoolMinSize;
	}

	public Integer getConnectionPoolTimeout() {
		return connectionPoolTimeout;
	}

	public void setConnectionPoolTimeout(Integer connectionPoolTimeout) {
		this.connectionPoolTimeout = connectionPoolTimeout;
	}

	public String getConnectionUrl() {
		return connectionUrl;
	}

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

	public String getConnectionUsername() {
		return connectionUsername;
	}

	public void setConnectionUsername(String connectionUsername) {
		this.connectionUsername = connectionUsername;
	}

	public String getHibernateDialect() {
		return hibernateDialect;
	}

	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	public String getQuerySubstitutions() {
		return querySubstitutions;
	}

	public void setQuerySubstitutions(String querySubstitutions) {
		this.querySubstitutions = querySubstitutions;
	}

	public String getValidationQuery() {
		return validationQuery;
	}

	public void setValidationQuery(String validationQuery) {
		this.validationQuery = validationQuery;
	}

	public String getFromEmailAddress() {
		return fromEmailAddress;
	}

	public void setFromEmailAddress(String fromEmailAddress) {
		this.fromEmailAddress = fromEmailAddress;
	}

	public String getSmtpHostPassword() {
		return smtpHostPassword;
	}

	public void setSmtpHostPassword(String smtpHostPassword) {
		this.smtpHostPassword = smtpHostPassword;
	}

	public boolean isSmtpHostRequiresPassword() {
		return smtpHostRequiresPassword;
	}

	public void setSmtpHostRequiresPassword(boolean smtpHostRequiresPassword) {
		this.smtpHostRequiresPassword = smtpHostRequiresPassword;
	}

	public String getSmtpHostUsername() {
		return smtpHostUsername;
	}

	public void setSmtpHostUsername(String smtpHostUsername) {
		this.smtpHostUsername = smtpHostUsername;
	}

	public String getSmtpMailHost() {
		return smtpMailHost;
	}

	public void setSmtpMailHost(String smtpMailHost) {
		this.smtpMailHost = smtpMailHost;
	}

	public String getAttachmentRootDirectory() {
		return attachmentRootDirectory;
	}

	public void setAttachmentRootDirectory(String attachmentRootDirectory) {
		this.attachmentRootDirectory = attachmentRootDirectory;
	}

	public String getPopCheckCronExpression() {
		return popCheckCronExpression;
	}

	public void setPopCheckCronExpression(String popCheckCronExpression) {
		this.popCheckCronExpression = popCheckCronExpression;
	}

	public String getPopHostPassword() {
		return popHostPassword;
	}

	public void setPopHostPassword(String popHostPassword) {
		this.popHostPassword = popHostPassword;
	}

	public String getPopHostUsername() {
		return popHostUsername;
	}

	public void setPopHostUsername(String popHostUsername) {
		this.popHostUsername = popHostUsername;
	}

	public String getPopMailHost() {
		return popMailHost;
	}

	public void setPopMailHost(String popMailHost) {
		this.popMailHost = popMailHost;
	}

	public boolean isPopUsingSslEnabled() {
		return popUsingSslEnabled;
	}

	public void setPopUsingSslEnabled(boolean popUsingSsl) {
		this.popUsingSslEnabled = popUsingSsl;
	}

	public boolean isPopCheckingEnabled() {
		return popCheckingEnabled;
	}

	public void setPopCheckingEnabled(boolean popCheckingEnabled) {
		this.popCheckingEnabled = popCheckingEnabled;
	}

	public String getRootXTrackerUriContext() {
		return rootXTrackerUriContext;
	}

	public void setRootXTrackerUriContext(String rootXTrackerUriContext) {
		this.rootXTrackerUriContext = rootXTrackerUriContext;
	}

	public int getMaxModifiedAgeDays() {
		return maxModifiedAgeDays;
	}

	public void setMaxModifiedAgeDays(int maxModifiedAgeDays) {
		this.maxModifiedAgeDays = maxModifiedAgeDays;
	}

	public int getMaxModifiedIncrement() {
		return maxModifiedIncrement;
	}

	public void setMaxModifiedIncrement(int maxModifiedIncrement) {
		this.maxModifiedIncrement = maxModifiedIncrement;
	}

	public boolean isMaxModifyAgeEnabled() {
		return maxModifyAgeEnabled;
	}

	public void setMaxModifyAgeEnabled(boolean maxModifyAgeEnabled) {
		this.maxModifyAgeEnabled = maxModifyAgeEnabled;
	}

	public String getCustomQueueMailHeader() {
		return customQueueMailHeader;
	}

	public void setCustomQueueMailHeader(String customQueueMailHeader) {
		this.customQueueMailHeader = customQueueMailHeader;
	}

	public boolean isCustomQueueMailHeaderEnabled() {
		return customQueueMailHeaderEnabled;
	}

	public void setCustomQueueMailHeaderEnabled(boolean customQueueMailHeaderEnabled) {
		this.customQueueMailHeaderEnabled = customQueueMailHeaderEnabled;
	}

	public boolean isXplannerEnabled() {
		return xplannerEnabled;
	}

	public void setXplannerEnabled(boolean xplannerEnabled) {
		this.xplannerEnabled = xplannerEnabled;
	}

	public String getXplannerContext() {
		return xplannerContext;
	}

	public void setXplannerContext(String xplannerUri) {
		this.xplannerContext = xplannerUri;
	}

	public String getJiraContext() {
		return jiraContext;
	}

	public void setJiraContext(String jiraContext) {
		this.jiraContext = jiraContext;
	}

	public boolean isJiraEnabled() {
		return jiraEnabled;
	}

	public void setJiraEnabled(boolean jiraEnabled) {
		this.jiraEnabled = jiraEnabled;
	}

	public int getMailInputStreamBacklog() {
		return mailInputStreamBacklog;
	}

	public void setMailInputStreamBacklog(int mailInputStreamBacklog) {
		this.mailInputStreamBacklog = mailInputStreamBacklog;
	}

	public String getMailInputStreamHost() {
		return mailInputStreamHost;
	}

	public void setMailInputStreamHost(String mailInputStreamHost) {
		this.mailInputStreamHost = mailInputStreamHost;
	}

	public int getMailInputStreamPort() {
		return mailInputStreamPort;
	}

	public void setMailInputStreamPort(int mailInputStreamPort) {
		this.mailInputStreamPort = mailInputStreamPort;
	}

	public boolean isMailInputStreamServiceEnabled() {
		return mailInputStreamServiceEnabled;
	}

	public void setMailInputStreamServiceEnabled(boolean mailInputStreamServiceEnabled) {
		this.mailInputStreamServiceEnabled = mailInputStreamServiceEnabled;
	}

}
