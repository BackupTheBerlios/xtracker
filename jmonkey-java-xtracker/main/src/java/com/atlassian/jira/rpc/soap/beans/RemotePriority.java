/**
 * RemotePriority.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package com.atlassian.jira.rpc.soap.beans;

public class RemotePriority  extends com.atlassian.jira.rpc.soap.beans.AbstractRemoteConstant  implements java.io.Serializable {
    private java.lang.String color;

    public RemotePriority() {
    }

    public RemotePriority(
           java.lang.String color) {
           this.color = color;
    }


    /**
     * Gets the color value for this RemotePriority.
     * 
     * @return color
     */
    public java.lang.String getColor() {
        return color;
    }


    /**
     * Sets the color value for this RemotePriority.
     * 
     * @param color
     */
    public void setColor(java.lang.String color) {
        this.color = color;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RemotePriority)) return false;
        RemotePriority other = (RemotePriority) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.color==null && other.getColor()==null) || 
             (this.color!=null &&
              this.color.equals(other.getColor())));
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
        if (getColor() != null) {
            _hashCode += getColor().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
