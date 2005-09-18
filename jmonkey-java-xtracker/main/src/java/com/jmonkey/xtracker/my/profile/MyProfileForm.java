package com.jmonkey.xtracker.my.profile;

import org.apache.struts.action.ActionForm;

public class MyProfileForm extends ActionForm {
	private String	userName			= null;
	private String	realName			= null;
	private String	initials			= null;
	private String	password			= null;
	private String	verifyPassword		= null;
	private String	signature			= null;
	private String	phoneNumber			= null;
	private String	emailAddress		= null;

	private boolean	xplannerEnabled		= false;
	private String	xplannerUsername	= null;
	private String	xplannerPassword		= null;
	
	private boolean	jiraEnabled		= false;
	private String	jiraUsername	= null;
	private String	jiraPassword		= null;

	public MyProfileForm() {
		super();
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getXplannerPassword() {
		return xplannerPassword;
	}

	public void setXplannerPassword(String xplanerPassword) {
		this.xplannerPassword = xplanerPassword;
	}

	public boolean isXplannerEnabled() {
		return xplannerEnabled;
	}

	public void setXplannerEnabled(boolean xplannerEnabled) {
		this.xplannerEnabled = xplannerEnabled;
	}

	public String getXplannerUsername() {
		return xplannerUsername;
	}

	public void setXplannerUsername(String xplannerUsername) {
		this.xplannerUsername = xplannerUsername;
	}

	public boolean isJiraEnabled() {
		return jiraEnabled;
	}

	public void setJiraEnabled(boolean jiraEnabled) {
		this.jiraEnabled = jiraEnabled;
	}

	public String getJiraPassword() {
		return jiraPassword;
	}

	public void setJiraPassword(String jiraPassword) {
		this.jiraPassword = jiraPassword;
	}

	public String getJiraUsername() {
		return jiraUsername;
	}

	public void setJiraUsername(String jiraUsername) {
		this.jiraUsername = jiraUsername;
	}

}
