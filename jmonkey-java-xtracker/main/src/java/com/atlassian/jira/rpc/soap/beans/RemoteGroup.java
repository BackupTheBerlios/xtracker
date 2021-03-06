/**
 * RemoteGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package com.atlassian.jira.rpc.soap.beans;

public class RemoteGroup  extends com.atlassian.jira.rpc.soap.beans.RemoteEntity  implements java.io.Serializable {
    private java.lang.String name;
    private com.atlassian.jira.rpc.soap.beans.RemoteUser[] users;

    public RemoteGroup() {
    }

    public RemoteGroup(
           java.lang.String name,
           com.atlassian.jira.rpc.soap.beans.RemoteUser[] users) {
           this.name = name;
           this.users = users;
    }


    /**
     * Gets the name value for this RemoteGroup.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this RemoteGroup.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the users value for this RemoteGroup.
     * 
     * @return users
     */
    public com.atlassian.jira.rpc.soap.beans.RemoteUser[] getUsers() {
        return users;
    }


    /**
     * Sets the users value for this RemoteGroup.
     * 
     * @param users
     */
    public void setUsers(com.atlassian.jira.rpc.soap.beans.RemoteUser[] users) {
        this.users = users;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RemoteGroup)) return false;
        RemoteGroup other = (RemoteGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.users==null && other.getUsers()==null) || 
             (this.users!=null &&
              java.util.Arrays.equals(this.users, other.getUsers())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getUsers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUsers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUsers(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
