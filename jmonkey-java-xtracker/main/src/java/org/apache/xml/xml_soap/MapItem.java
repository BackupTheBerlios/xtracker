/**
 * MapItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package org.apache.xml.xml_soap;

public class MapItem  implements java.io.Serializable {
    private java.lang.Object key;
    private java.lang.Object value;

    public MapItem() {
    }

    public MapItem(
           java.lang.Object key,
           java.lang.Object value) {
           this.key = key;
           this.value = value;
    }


    /**
     * Gets the key value for this MapItem.
     * 
     * @return key
     */
    public java.lang.Object getKey() {
        return key;
    }


    /**
     * Sets the key value for this MapItem.
     * 
     * @param key
     */
    public void setKey(java.lang.Object key) {
        this.key = key;
    }


    /**
     * Gets the value value for this MapItem.
     * 
     * @return value
     */
    public java.lang.Object getValue() {
        return value;
    }


    /**
     * Sets the value value for this MapItem.
     * 
     * @param value
     */
    public void setValue(java.lang.Object value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MapItem)) return false;
        MapItem other = (MapItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.key==null && other.getKey()==null) || 
             (this.key!=null &&
              this.key.equals(other.getKey()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue())));
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
        if (getKey() != null) {
            _hashCode += getKey().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
