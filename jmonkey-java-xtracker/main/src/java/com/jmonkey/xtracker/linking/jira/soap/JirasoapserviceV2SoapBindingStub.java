/**
 * JirasoapserviceV2SoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package com.jmonkey.xtracker.linking.jira.soap;

public class JirasoapserviceV2SoapBindingStub extends org.apache.axis.client.Stub implements com.jmonkey.xtracker.linking.jira.soap.JiraSoapService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[42];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
        _initOperationDesc5();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createGroup");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in2"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"), com.atlassian.jira.rpc.soap.beans.RemoteUser.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteGroup.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createGroupReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getGroup");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteGroup.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getGroupReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteUser.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("login");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "loginReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getServerInfo");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteServerInfo"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteServerInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getServerInfoReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("logout");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "logoutReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getIssue");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteIssue.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getIssueReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createUser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in2"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in3"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in4"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteUser.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createIssue");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"), com.atlassian.jira.rpc.soap.beans.RemoteIssue.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteIssue.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createIssueReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProjects");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteProject"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteProject[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getProjectsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateProject");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"), com.atlassian.jira.rpc.soap.beans.RemoteProject.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteProject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateProjectReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getComponents");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteComponent"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteComponent[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getComponentsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getIssueTypes");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteIssueType"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteIssueType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getIssueTypesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPriorities");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemotePriority"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemotePriority[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getPrioritiesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getResolutions");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteResolution"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteResolution[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getResolutionsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getStatuses");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteStatus"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteStatus[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getStatusesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSubTaskIssueTypes");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteIssueType"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteIssueType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getSubTaskIssueTypesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCustomFields");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteField"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteField[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getCustomFieldsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getComments");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteComment"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteComment[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getCommentsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getVersions");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteVersion"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteVersion[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getVersionsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createProject");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in2"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in3"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in4"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in5"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in6"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"), com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in7"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteScheme"), com.atlassian.jira.rpc.soap.beans.RemoteScheme.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in8"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteScheme"), com.atlassian.jira.rpc.soap.beans.RemoteScheme.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteProject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createProjectReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createProject");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"), com.atlassian.jira.rpc.soap.beans.RemoteProject.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteProject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createProjectReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateIssue");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in2"), new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteFieldValue"), com.atlassian.jira.rpc.soap.beans.RemoteFieldValue[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteIssue.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateIssueReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addComment");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in2"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComment"), com.atlassian.jira.rpc.soap.beans.RemoteComment.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteProject");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteIssue");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getNotificationSchemes");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteScheme"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteScheme[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getNotificationSchemesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPermissionSchemes");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemotePermissionScheme"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getPermissionSchemesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAllPermissions");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemotePermission"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemotePermission[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getAllPermissionsReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("createPermissionScheme");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in2"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createPermissionSchemeReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deletePermissionScheme");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addPermissionTo");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"), com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in2"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermission"), com.atlassian.jira.rpc.soap.beans.RemotePermission.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in3"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteEntity"), com.atlassian.jira.rpc.soap.beans.RemoteEntity.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addPermissionToReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deletePermissionFrom");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"), com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in2"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermission"), com.atlassian.jira.rpc.soap.beans.RemotePermission.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in3"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteEntity"), com.atlassian.jira.rpc.soap.beans.RemoteEntity.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deletePermissionFromReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addAttachmentToIssue");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_string"), java.lang.String[].class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in2"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue"), com.atlassian.jira.rpc.soap.beans.RemoteIssue.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addAttachmentToIssueReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFieldsForEdit");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteField"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteField[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getFieldsForEditReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteUser");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateGroup");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup"), com.atlassian.jira.rpc.soap.beans.RemoteGroup.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteGroup.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateGroupReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[36] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("deleteGroup");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in2"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteValidationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[37] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSavedFilters");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteFilter"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteFilter[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getSavedFiltersReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[38] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addVersion");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in2"), new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteVersion"), com.atlassian.jira.rpc.soap.beans.RemoteVersion.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteVersion"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteVersion.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "addVersionReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        _operations[39] = oper;

    }

    private static void _initOperationDesc5(){
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getIssuesFromFilter");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.addParameter(new javax.xml.namespace.QName("", "in1"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteIssue"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteIssue[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getIssuesFromFilterReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        _operations[40] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getSecuritySchemes");
        oper.addParameter(new javax.xml.namespace.QName("", "in0"), new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteScheme"));
        oper.setReturnClass(com.atlassian.jira.rpc.soap.beans.RemoteScheme[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getSecuritySchemesReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemotePermissionException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "fault"),
                      "com.atlassian.jira.rpc.exception.RemoteAuthenticationException",
                      new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException"), 
                      true
                     ));
        _operations[41] = oper;

    }

    public JirasoapserviceV2SoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public JirasoapserviceV2SoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public JirasoapserviceV2SoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteIssue");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteIssue[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteVersion");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteVersion.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteScheme");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteScheme[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemotePermissionException");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.exception.RemotePermissionException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_xsd_string");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteCustomFieldValue");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteCustomFieldValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteVersion");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteVersion[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComponent");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteComponent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteValidationException");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.exception.RemoteValidationException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemotePermissionScheme");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteProject");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteProject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteEntity");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteEntity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteStatus");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteStatus[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemotePermissionMapping");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemotePermissionMapping[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionMapping");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemotePermissionMapping.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteProject");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteProject[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteAuthenticationException");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.exception.RemoteAuthenticationException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteFilter");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteFilter[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteComponent");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteComponent[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemotePermission");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemotePermission[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteUser");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteUser.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "AbstractRemoteConstant");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.AbstractRemoteConstant.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermissionScheme");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "AbstractNamedRemoteEntity");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.AbstractNamedRemoteEntity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteField");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteField.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteComment");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteComment[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://exception.rpc.jira.atlassian.com", "RemoteException");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.exception.RemoteException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteFieldValue");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteFieldValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteIssueType");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteIssueType[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteCustomFieldValue");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteCustomFieldValue[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteStatus");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteFilter");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteFilter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteUser");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteUser[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssueType");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteIssueType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteFieldValue");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteFieldValue[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "AbstractRemoteEntity");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.AbstractRemoteEntity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemotePriority");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemotePriority[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteServerInfo");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteServerInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteField");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteField[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteEntity");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteEntity[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteScheme");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteScheme.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteComment");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteComment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteIssue");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteIssue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://jira.codehaus.org/rpc/soap/jirasoapservice-v2", "ArrayOf_tns1_RemoteResolution");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteResolution[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteGroup");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteGroup.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePriority");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemotePriority.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemotePermission");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemotePermission.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://beans.soap.rpc.jira.atlassian.com", "RemoteResolution");
            cachedSerQNames.add(qName);
            cls = com.atlassian.jira.rpc.soap.beans.RemoteResolution.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call =
                    (org.apache.axis.client.Call) super.service.createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                        java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                        _call.registerTypeMapping(cls, qName, sf, df, false);
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteGroup createGroup(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteUser in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "createGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteGroup) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteGroup) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteGroup.class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteGroup getGroup(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteGroup) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteGroup) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteGroup.class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteUser getUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteUser) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteUser) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteUser.class);
            }
        }
    }

    public java.lang.String login(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "login"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteServerInfo getServerInfo(java.lang.String in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getServerInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteServerInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteServerInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteServerInfo.class);
            }
        }
    }

    public boolean logout(java.lang.String in0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "logout"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteIssue getIssue(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getIssue"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssue) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssue) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteIssue.class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteUser createUser(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "createUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2, in3, in4});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteUser) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteUser) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteUser.class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteIssue createIssue(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteIssue in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "createIssue"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssue) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssue) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteIssue.class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteProject[] getProjects(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getProjects"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteProject[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteProject[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteProject[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteProject updateProject(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProject in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "updateProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteProject) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteProject) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteProject.class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteComponent[] getComponents(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getComponents"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteComponent[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteComponent[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteComponent[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteIssueType[] getIssueTypes(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getIssueTypes"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssueType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssueType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteIssueType[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemotePriority[] getPriorities(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getPriorities"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemotePriority[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemotePriority[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemotePriority[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteResolution[] getResolutions(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getResolutions"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteResolution[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteResolution[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteResolution[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteStatus[] getStatuses(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getStatuses"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteStatus[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteStatus[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteStatus[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteIssueType[] getSubTaskIssueTypes(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getSubTaskIssueTypes"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssueType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssueType[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteIssueType[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteField[] getCustomFields(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getCustomFields"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteField[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteField[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteField[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteComment[] getComments(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getComments"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteComment[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteComment[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteComment[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteVersion[] getVersions(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getVersions"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteVersion[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteVersion[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteVersion[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteProject createProject(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3, java.lang.String in4, java.lang.String in5, com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme in6, com.atlassian.jira.rpc.soap.beans.RemoteScheme in7, com.atlassian.jira.rpc.soap.beans.RemoteScheme in8) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "createProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2, in3, in4, in5, in6, in7, in8});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteProject) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteProject) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteProject.class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteProject createProject(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteProject in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "createProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteProject) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteProject) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteProject.class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteIssue updateIssue(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteFieldValue[] in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "updateIssue"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssue) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssue) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteIssue.class);
            }
        }
    }

    public void addComment(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteComment in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "addComment"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void deleteProject(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "deleteProject"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public void deleteIssue(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "deleteIssue"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteScheme[] getNotificationSchemes(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getNotificationSchemes"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteScheme[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteScheme[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteScheme[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme[] getPermissionSchemes(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getPermissionSchemes"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemotePermission[] getAllPermissions(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getAllPermissions"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemotePermission[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemotePermission[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemotePermission[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme createPermissionScheme(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "createPermissionScheme"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme.class);
            }
        }
    }

    public void deletePermissionScheme(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "deletePermissionScheme"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme addPermissionTo(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme in1, com.atlassian.jira.rpc.soap.beans.RemotePermission in2, com.atlassian.jira.rpc.soap.beans.RemoteEntity in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "addPermissionTo"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2, in3});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme.class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme deletePermissionFrom(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme in1, com.atlassian.jira.rpc.soap.beans.RemotePermission in2, com.atlassian.jira.rpc.soap.beans.RemoteEntity in3) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "deletePermissionFrom"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2, in3});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme.class);
            }
        }
    }

    public boolean addAttachmentToIssue(java.lang.String in0, java.lang.String[] in1, com.atlassian.jira.rpc.soap.beans.RemoteIssue in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "addAttachmentToIssue"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteField[] getFieldsForEdit(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getFieldsForEdit"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteField[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteField[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteField[].class);
            }
        }
    }

    public void deleteUser(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "deleteUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteGroup updateGroup(java.lang.String in0, com.atlassian.jira.rpc.soap.beans.RemoteGroup in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "updateGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteGroup) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteGroup) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteGroup.class);
            }
        }
    }

    public void deleteGroup(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteValidationException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[37]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "deleteGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteFilter[] getSavedFilters(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[38]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getSavedFilters"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteFilter[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteFilter[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteFilter[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteVersion addVersion(java.lang.String in0, java.lang.String in1, com.atlassian.jira.rpc.soap.beans.RemoteVersion in2) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[39]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "addVersion"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1, in2});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteVersion) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteVersion) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteVersion.class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteIssue[] getIssuesFromFilter(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[40]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getIssuesFromFilter"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0, in1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssue[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteIssue[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteIssue[].class);
            }
        }
    }

    public com.atlassian.jira.rpc.soap.beans.RemoteScheme[] getSecuritySchemes(java.lang.String in0) throws java.rmi.RemoteException, com.atlassian.jira.rpc.exception.RemotePermissionException, com.atlassian.jira.rpc.exception.RemoteException, com.atlassian.jira.rpc.exception.RemoteAuthenticationException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[41]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.rpc.jira.atlassian.com", "getSecuritySchemes"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.atlassian.jira.rpc.soap.beans.RemoteScheme[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.atlassian.jira.rpc.soap.beans.RemoteScheme[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.atlassian.jira.rpc.soap.beans.RemoteScheme[].class);
            }
        }
    }

}
