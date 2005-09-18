package com.jmonkey.xtracker.linking.xplanner.soap;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.util.HashSet;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.AxisFault;
import org.apache.axis.EngineConfiguration;
import org.apache.axis.client.Stub;

import com.jmonkey.xtracker.linking.BaseAxisServiceLocator;

public class XPlannerServiceLocator extends BaseAxisServiceLocator implements com.jmonkey.xtracker.linking.xplanner.soap.XPlannerService {
	private HashSet<QName>	ports	= null;

	public XPlannerServiceLocator() {
		super();
	}

	public XPlannerServiceLocator(EngineConfiguration config) {
		super(config);
	}

	// Use to get a proxy class for XPlanner
	public String getXPlannerAddress() {
		return getServiceAddress();
	}

	public void setXPlannerAddress(String planner_address) {
		setServiceAddress(planner_address);
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String	XPlannerWSDDServiceName	= "XPlanner";

	public java.lang.String getXPlannerWSDDServiceName() {
		return XPlannerWSDDServiceName;
	}

	public void setXPlannerWSDDServiceName(java.lang.String name) {
		XPlannerWSDDServiceName = name;
	}

	public XPlanner getXPlanner() throws ServiceException {
		URL endpoint;
		try {
			endpoint = new URL(serviceAddress);
		} catch (MalformedURLException e) {
			throw new ServiceException(e);
		}
		return getXPlanner(endpoint);
	}

	public XPlanner getXPlanner(java.net.URL portAddress) throws ServiceException {
		try {
			XPlannerSoapBindingStub stub = new XPlannerSoapBindingStub(portAddress, this);
			setupAuthentication(stub);
			stub.setPortName(getXPlannerWSDDServiceName());
			return stub;
		} catch (AxisFault e) {
			return null;
		}
	}

	public void setXPlannerEndpointAddress(java.lang.String address) {
		serviceAddress = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	@Override
	public Remote getPort(Class serviceEndpointInterface) throws ServiceException {
		try {
			if (XPlanner.class.isAssignableFrom(serviceEndpointInterface)) {
				XPlannerSoapBindingStub _stub = new XPlannerSoapBindingStub(new URL(serviceAddress), this);
				setupAuthentication(_stub);
				_stub.setPortName(getXPlannerWSDDServiceName());
				return _stub;
			}
		} catch (Throwable t) {
			throw new ServiceException(t);
		}
		throw new ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	@Override
	public Remote getPort(QName portName, Class serviceEndpointInterface) throws ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		String inputPortName = portName.getLocalPart();
		if ("XPlanner".equals(inputPortName)) {
			return getXPlanner();
		}

		java.rmi.Remote _stub = getPort(serviceEndpointInterface);
		((Stub) _stub).setPortName(portName);
		return _stub;

	}

	@Override
	public QName getServiceName() {
		return new QName(serviceAddress, "XPlannerService");
	}

	@Override
	public Iterator getPorts() {
		if (ports == null) {
			ports = new HashSet<QName>();
			// "http://dev.pappin.ca/xplanner-dev/soap/XPlanner"
			ports.add(new QName(serviceAddress, "XPlanner"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(String portName, String address) throws ServiceException {
		if ("XPlanner".equals(portName)) {
			setXPlannerEndpointAddress(address);
		} else { // Unknown Port Name
			throw new ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(QName portName, String address) throws ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
