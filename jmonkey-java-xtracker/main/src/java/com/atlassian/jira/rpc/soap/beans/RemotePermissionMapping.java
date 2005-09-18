/**
 * RemotePermissionMapping.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package com.atlassian.jira.rpc.soap.beans;

public class RemotePermissionMapping  implements java.io.Serializable {
    private com.atlassian.jira.rpc.soap.beans.RemotePermission permission;
    private com.atlassian.jira.rpc.soap.beans.RemoteEntity[] remoteEntities;

    public RemotePermissionMapping() {
    }

    public RemotePermissionMapping(
           com.atlassian.jira.rpc.soap.beans.RemotePermission permission,
           com.atlassian.jira.rpc.soap.beans.RemoteEntity[] remoteEntities) {
           this.permission = permission;
           this.remoteEntities = remoteEntities;
    }


    /**
     * Gets the permission value for this RemotePermissionMapping.
     * 
     * @return permission
     */
    public com.atlassian.jira.rpc.soap.beans.RemotePermission getPermission() {
        return permission;
    }


    /**
     * Sets the permission value for this RemotePermissionMapping.
     * 
     * @param permission
     */
    public void setPermission(com.atlassian.jira.rpc.soap.beans.RemotePermission permission) {
        this.permission = permission;
    }


    /**
     * Gets the remoteEntities value for this RemotePermissionMapping.
     * 
     * @return remoteEntities
     */
    public com.atlassian.jira.rpc.soap.beans.RemoteEntity[] getRemoteEntities() {
        return remoteEntities;
    }


    /**
     * Sets the remoteEntities value for this RemotePermissionMapping.
     * 
     * @param remoteEntities
     */
    public void setRemoteEntities(com.atlassian.jira.rpc.soap.beans.RemoteEntity[] remoteEntities) {
        this.remoteEntities = remoteEntities;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RemotePermissionMapping)) return false;
        RemotePermissionMapping other = (RemotePermissionMapping) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.permission==null && other.getPermission()==null) || 
             (this.permission!=null &&
              this.permission.equals(other.getPermission()))) &&
            ((this.remoteEntities==null && other.getRemoteEntities()==null) || 
             (this.remoteEntities!=null &&
              java.util.Arrays.equals(this.remoteEntities, other.getRemoteEntities())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getPermission() != null) {
            _hashCode += getPermission().hashCode();
        }
        if (getRemoteEntities() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRemoteEntities());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRemoteEntities(), i);
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
