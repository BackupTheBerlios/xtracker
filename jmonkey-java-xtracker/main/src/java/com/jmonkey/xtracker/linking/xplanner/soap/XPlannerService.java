/**
 * XPlannerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package com.jmonkey.xtracker.linking.xplanner.soap;

public interface XPlannerService extends javax.xml.rpc.Service {
    public java.lang.String getXPlannerAddress();

    public com.jmonkey.xtracker.linking.xplanner.soap.XPlanner getXPlanner() throws javax.xml.rpc.ServiceException;

    public com.jmonkey.xtracker.linking.xplanner.soap.XPlanner getXPlanner(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
