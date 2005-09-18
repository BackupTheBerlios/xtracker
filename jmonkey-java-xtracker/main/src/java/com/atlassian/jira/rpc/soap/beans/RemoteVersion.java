/**
 * RemoteVersion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package com.atlassian.jira.rpc.soap.beans;

public class RemoteVersion  extends com.atlassian.jira.rpc.soap.beans.AbstractNamedRemoteEntity  implements java.io.Serializable {
    private boolean archived;
    private java.util.Calendar releaseDate;
    private boolean released;
    private java.lang.Long sequence;

    public RemoteVersion() {
    }

    public RemoteVersion(
           boolean archived,
           java.util.Calendar releaseDate,
           boolean released,
           java.lang.Long sequence) {
           this.archived = archived;
           this.releaseDate = releaseDate;
           this.released = released;
           this.sequence = sequence;
    }


    /**
     * Gets the archived value for this RemoteVersion.
     * 
     * @return archived
     */
    public boolean isArchived() {
        return archived;
    }


    /**
     * Sets the archived value for this RemoteVersion.
     * 
     * @param archived
     */
    public void setArchived(boolean archived) {
        this.archived = archived;
    }


    /**
     * Gets the releaseDate value for this RemoteVersion.
     * 
     * @return releaseDate
     */
    public java.util.Calendar getReleaseDate() {
        return releaseDate;
    }


    /**
     * Sets the releaseDate value for this RemoteVersion.
     * 
     * @param releaseDate
     */
    public void setReleaseDate(java.util.Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }


    /**
     * Gets the released value for this RemoteVersion.
     * 
     * @return released
     */
    public boolean isReleased() {
        return released;
    }


    /**
     * Sets the released value for this RemoteVersion.
     * 
     * @param released
     */
    public void setReleased(boolean released) {
        this.released = released;
    }


    /**
     * Gets the sequence value for this RemoteVersion.
     * 
     * @return sequence
     */
    public java.lang.Long getSequence() {
        return sequence;
    }


    /**
     * Sets the sequence value for this RemoteVersion.
     * 
     * @param sequence
     */
    public void setSequence(java.lang.Long sequence) {
        this.sequence = sequence;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RemoteVersion)) return false;
        RemoteVersion other = (RemoteVersion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.archived == other.isArchived() &&
            ((this.releaseDate==null && other.getReleaseDate()==null) || 
             (this.releaseDate!=null &&
              this.releaseDate.equals(other.getReleaseDate()))) &&
            this.released == other.isReleased() &&
            ((this.sequence==null && other.getSequence()==null) || 
             (this.sequence!=null &&
              this.sequence.equals(other.getSequence())));
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
        _hashCode += (isArchived() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getReleaseDate() != null) {
            _hashCode += getReleaseDate().hashCode();
        }
        _hashCode += (isReleased() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSequence() != null) {
            _hashCode += getSequence().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
