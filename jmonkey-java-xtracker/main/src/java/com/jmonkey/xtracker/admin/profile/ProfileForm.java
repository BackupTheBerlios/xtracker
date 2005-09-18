package com.jmonkey.xtracker.admin.profile;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class ProfileForm extends ActionForm {
	private List	personList			= new ArrayList();
	private List	queueList			= new ArrayList();
	private String	defaultQueueId		= null;

	private String	id					= null;

	private String	userName			= null;
	private String	realName			= null;
	private String	initials			= null;
	private String	password			= null;
	private String	verifyPassword		= null;
	private String	signature			= null;

	private boolean	active				= true;
	private boolean	selectable			= true;
	private boolean	anonymous			= false;
	private boolean	administrator		= false;

//	private String	addressLocation		= null;
//	private String	address1			= null;
//	private String	address2			= null;
//	private String	city				= null;
//	private String	region				= null;
//	private String	country				= null;
//	private String	postalCode			= null;

	private String	phoneNumber			= null;
//	private String	phoneNumberLocation	= null;

//	private String	emailLocation		= null;
	private String	emailAddress		= null;

	public ProfileForm() {
		super();
	}

	public String getDefaultQueueId() {
		return defaultQueueId;
	}

	public void setDefaultQueueId(String defaultQueueId) {
		this.defaultQueueId = defaultQueueId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public String getAddress1() {
//		return address1;
//	}
//
//	public void setAddress1(String address1) {
//		this.address1 = address1;
//	}
//
//	public String getAddress2() {
//		return address2;
//	}

//	public void setAddress2(String address2) {
//		this.address2 = address2;
//	}
//
//	public String getAddressLocation() {
//		return addressLocation;
//	}
//
//	public void setAddressLocation(String addressLocation) {
//		this.addressLocation = addressLocation;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

//	public String getEmailLocation() {
//		return emailLocation;
//	}
//
//	public void setEmailLocation(String emailLocation) {
//		this.emailLocation = emailLocation;
//	}

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

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

//	public String getPhoneNumberLocation() {
//		return phoneNumberLocation;
//	}
//
//	public void setPhoneNumberLocation(String phoneNumberLocation) {
//		this.phoneNumberLocation = phoneNumberLocation;
//	}

//	public String getPostalCode() {
//		return postalCode;
//	}
//
//	public void setPostalCode(String postalCode) {
//		this.postalCode = postalCode;
//	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

//	public String getRegion() {
//		return region;
//	}
//
//	public void setRegion(String region) {
//		this.region = region;
//	}

	public List getPersonList() {
		return personList;
	}

	public void setPersonList(List list) {
		this.personList = list;
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

	public List getQueueList() {
		return queueList;
	}

	public void setQueueList(List queueList) {
		this.queueList = queueList;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

	public boolean isSelectable() {
		return selectable;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}
}
