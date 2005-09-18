package com.jmonkey.xtracker.linking;

import java.io.InputStream;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.AxisClient;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;
import org.apache.axis.wsdl.gen.Parser;

public class BaseAxisServiceLocator extends Service {

	protected String	username	= null;
	protected String	password	= null;
	protected String	serviceAddress	= null;

	public BaseAxisServiceLocator() {
		super();
	}

	public BaseAxisServiceLocator(EngineConfiguration arg0, AxisClient arg1) {
		super(arg0, arg1);
	}

	public BaseAxisServiceLocator(EngineConfiguration arg0) {
		super(arg0);
	}

	public BaseAxisServiceLocator(InputStream arg0, QName arg1) throws ServiceException {
		super(arg0, arg1);
	}

	public BaseAxisServiceLocator(Parser arg0, QName arg1) throws ServiceException {
		super(arg0, arg1);
	}

	public BaseAxisServiceLocator(QName arg0) {
		super(arg0);
	}

	public BaseAxisServiceLocator(String arg0, QName arg1) throws ServiceException {
		super(arg0, arg1);
	}

	public BaseAxisServiceLocator(URL arg0, QName arg1) throws ServiceException {
		super(arg0, arg1);
	}

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String address) {
		this.serviceAddress = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	protected void setupAuthentication(Stub stub) {
		if (username != null) {
			stub.setUsername(username);
			stub.setPassword(password);
		}
	}

}
