/**
 * NoteData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package org.xplanner.soap;

public class NoteData  extends com.technoetic.xplanner.soap.domain.DomainData  implements java.io.Serializable {
    private int attachedToId;
    private int attachmentId;
    private int authorId;
    private java.lang.String body;
    private java.lang.String subject;
    private java.util.Calendar submissionTime;

    public NoteData() {
    }

    public NoteData(
           int attachedToId,
           int attachmentId,
           int authorId,
           java.lang.String body,
           java.lang.String subject,
           java.util.Calendar submissionTime) {
           this.attachedToId = attachedToId;
           this.attachmentId = attachmentId;
           this.authorId = authorId;
           this.body = body;
           this.subject = subject;
           this.submissionTime = submissionTime;
    }


    /**
     * Gets the attachedToId value for this NoteData.
     * 
     * @return attachedToId
     */
    public int getAttachedToId() {
        return attachedToId;
    }


    /**
     * Sets the attachedToId value for this NoteData.
     * 
     * @param attachedToId
     */
    public void setAttachedToId(int attachedToId) {
        this.attachedToId = attachedToId;
    }


    /**
     * Gets the attachmentId value for this NoteData.
     * 
     * @return attachmentId
     */
    public int getAttachmentId() {
        return attachmentId;
    }


    /**
     * Sets the attachmentId value for this NoteData.
     * 
     * @param attachmentId
     */
    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }


    /**
     * Gets the authorId value for this NoteData.
     * 
     * @return authorId
     */
    public int getAuthorId() {
        return authorId;
    }


    /**
     * Sets the authorId value for this NoteData.
     * 
     * @param authorId
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }


    /**
     * Gets the body value for this NoteData.
     * 
     * @return body
     */
    public java.lang.String getBody() {
        return body;
    }


    /**
     * Sets the body value for this NoteData.
     * 
     * @param body
     */
    public void setBody(java.lang.String body) {
        this.body = body;
    }


    /**
     * Gets the subject value for this NoteData.
     * 
     * @return subject
     */
    public java.lang.String getSubject() {
        return subject;
    }


    /**
     * Sets the subject value for this NoteData.
     * 
     * @param subject
     */
    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }


    /**
     * Gets the submissionTime value for this NoteData.
     * 
     * @return submissionTime
     */
    public java.util.Calendar getSubmissionTime() {
        return submissionTime;
    }


    /**
     * Sets the submissionTime value for this NoteData.
     * 
     * @param submissionTime
     */
    public void setSubmissionTime(java.util.Calendar submissionTime) {
        this.submissionTime = submissionTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NoteData)) return false;
        NoteData other = (NoteData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.attachedToId == other.getAttachedToId() &&
            this.attachmentId == other.getAttachmentId() &&
            this.authorId == other.getAuthorId() &&
            ((this.body==null && other.getBody()==null) || 
             (this.body!=null &&
              this.body.equals(other.getBody()))) &&
            ((this.subject==null && other.getSubject()==null) || 
             (this.subject!=null &&
              this.subject.equals(other.getSubject()))) &&
            ((this.submissionTime==null && other.getSubmissionTime()==null) || 
             (this.submissionTime!=null &&
              this.submissionTime.equals(other.getSubmissionTime())));
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
        _hashCode += getAttachedToId();
        _hashCode += getAttachmentId();
        _hashCode += getAuthorId();
        if (getBody() != null) {
            _hashCode += getBody().hashCode();
        }
        if (getSubject() != null) {
            _hashCode += getSubject().hashCode();
        }
        if (getSubmissionTime() != null) {
            _hashCode += getSubmissionTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
