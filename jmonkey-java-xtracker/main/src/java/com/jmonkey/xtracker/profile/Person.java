package com.jmonkey.xtracker.profile;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.jmonkey.xtracker.auth.Digest;
import com.jmonkey.xtracker.issue.Queue;

public class Person implements Serializable {
	private String				id;
	private String				username;
	private String				realname;
	private String				initials;
	private String				password;
	private String				signature;
	private String				emailAddress		= null;
	private String				phoneNumber			= null;
	private Date				createDate			= new Date();
	private Queue				defaultQueue		= null;
	private boolean				active				= true;
	private boolean				selectable			= true;
	private boolean				anonymous			= false;
	private boolean				administrator		= false;
	private boolean				immutable			= false;
	private List<PersonRole>	roles				= new ArrayList<PersonRole>();

	private String				xplannerUsername	= null;
	private String				xplannerPassword	= null;
	
	private String				jiraUsername	= null;
	private String				jiraPassword	= null;

	public Person() {
		super();
	}

	public Person(String username, String realname, String initials, String password, String signature, Date createDate) {
		this.username = username;
		this.realname = realname;
		this.initials = initials;
		this.password = password;
		this.signature = signature;
		this.createDate = createDate;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getInitials() {
		return this.initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean checkPlainPassword(String plain) {
		// String salt = getSalt();
		Digest digest = new Digest();
		try {
			return password.equals(digest.digest(plain));
		} catch (UnsupportedEncodingException e) {
			// e.printStackTrace();
			return false;
		} catch (NoSuchAlgorithmException e) {
			// e.printStackTrace();
			return false;
		}
	}

	public void setPlainPassword(String plain) {
		// String salt = getSalt();
		Digest digest = new Digest();
		try {
			password = digest.digest(plain);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public Queue getDefaultQueue() {
		return defaultQueue;
	}

	public void setDefaultQueue(Queue defaultQueue) {
		this.defaultQueue = defaultQueue;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public boolean isAnonymous() {
		return anonymous;
	}

	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	public boolean isAdministrator() {
		return administrator;
	}

	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}

	public boolean isImmutable() {
		return immutable;
	}

	public void setImmutable(boolean immutable) {
		this.immutable = immutable;
	}

	public List<PersonRole> getRoles() {
		return roles;
	}

	public void setRoles(List<PersonRole> roles) {
		this.roles = roles;
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

	public void setXplannerPassword(String passwd) {
		this.xplannerPassword = passwd;
	}

	public String getXplannerUsername() {
		return xplannerUsername;
	}

	public void setXplannerUsername(String xplannerUsername) {
		this.xplannerUsername = xplannerUsername;
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
