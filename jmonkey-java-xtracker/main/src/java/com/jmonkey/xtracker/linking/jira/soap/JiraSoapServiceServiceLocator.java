/**
 * JiraSoapServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package com.jmonkey.xtracker.linking.jira.soap;


import com.jmonkey.xtracker.linking.BaseAxisServiceLocator;

public class JiraSoapServiceServiceLocator extends BaseAxisServiceLocator implements com.jmonkey.xtracker.linking.jira.soap.JiraSoapServiceService {
	public JiraSoapServiceServiceLocator() {
		super();
	}

	public JiraSoapServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	// Use to get a proxy class for JirasoapserviceV2

	public java.lang.String getJirasoapserviceV2Address() {
		return getServiceAddress();
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String	JirasoapserviceV2WSDDServiceName	= "jirasoapservice-v2";

	public java.lang.String getJirasoapserviceV2WSDDServiceName() {
		return JirasoapserviceV2WSDDServiceName;
	}

	public void setJirasoapserviceV2WSDDServiceName(java.lang.String name) {
		JirasoapserviceV2WSDDServiceName = name;
	}

	public com.jmonkey.xtracker.linking.jira.soap.JiraSoapService getJirasoapserviceV2() throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(getServiceAddress());
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getJirasoapserviceV2(endpoint);
	}

	public com.jmonkey.xtracker.linking.jira.soap.JiraSoapService getJirasoapserviceV2(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			com.jmonkey.xtracker.linking.jira.soap.JirasoapserviceV2SoapBindingStub _stub = new com.jmonkey.xtracker.linking.jira.soap.JirasoapserviceV2SoapBindingStub(
					portAddress, this);
			_stub.setPortName(getJirasoapserviceV2WSDDServiceName());
			setupAuthentication(_stub);
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setJirasoapserviceV2EndpointAddress(java.lang.String address) {
		setServiceAddress(address);
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		try {
			if (com.jmonkey.xtracker.linking.jira.soap.JiraSoapService.class.isAssignableFrom(serviceEndpointInterface)) {
				com.jmonkey.xtracker.linking.jira.soap.JirasoapserviceV2SoapBindingStub _stub = new com.jmonkey.xtracker.linking.jira.soap.JirasoapserviceV2SoapBindingStub(
						new java.net.URL(getServiceAddress()), this);
				setupAuthentication(_stub);
				_stub.setPortName(getJirasoapserviceV2WSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  "
				+ (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("jirasoapservice-v2".equals(inputPortName)) {
			return getJirasoapserviceV2();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "JiraSoapServiceService");
	}

	private java.util.HashSet	ports	= null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "jirasoapservice-v2"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
		if ("JirasoapserviceV2".equals(portName)) {
			setJirasoapserviceV2EndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
