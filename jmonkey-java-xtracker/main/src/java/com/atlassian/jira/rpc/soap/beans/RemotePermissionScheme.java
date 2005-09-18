/**
 * RemotePermissionScheme.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package com.atlassian.jira.rpc.soap.beans;

public class RemotePermissionScheme  extends com.atlassian.jira.rpc.soap.beans.RemoteScheme  implements java.io.Serializable {
    private com.atlassian.jira.rpc.soap.beans.RemotePermissionMapping[] permissionMappings;

    public RemotePermissionScheme() {
    }

    public RemotePermissionScheme(
           com.atlassian.jira.rpc.soap.beans.RemotePermissionMapping[] permissionMappings) {
           this.permissionMappings = permissionMappings;
    }


    /**
     * Gets the permissionMappings value for this RemotePermissionScheme.
     * 
     * @return permissionMappings
     */
    public com.atlassian.jira.rpc.soap.beans.RemotePermissionMapping[] getPermissionMappings() {
        return permissionMappings;
    }


    /**
     * Sets the permissionMappings value for this RemotePermissionScheme.
     * 
     * @param permissionMappings
     */
    public void setPermissionMappings(com.atlassian.jira.rpc.soap.beans.RemotePermissionMapping[] permissionMappings) {
        this.permissionMappings = permissionMappings;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RemotePermissionScheme)) return false;
        RemotePermissionScheme other = (RemotePermissionScheme) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.permissionMappings==null && other.getPermissionMappings()==null) || 
             (this.permissionMappings!=null &&
              java.util.Arrays.equals(this.permissionMappings, other.getPermissionMappings())));
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
        if (getPermissionMappings() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPermissionMappings());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPermissionMappings(), i);
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
