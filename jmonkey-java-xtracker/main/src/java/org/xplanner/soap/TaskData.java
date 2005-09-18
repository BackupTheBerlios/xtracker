/**
 * TaskData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package org.xplanner.soap;

public class TaskData  extends com.technoetic.xplanner.soap.domain.DomainData  implements java.io.Serializable {
    private int acceptorId;
    private double actualHours;
    private double adjustedEstimatedHours;
    private boolean completed;
    private java.util.Calendar createdDate;
    private java.lang.String description;
    private java.lang.String dispositionName;
    private double estimatedHours;
    private java.lang.String name;
    private double originalEstimatedHours;
    private double remainingHours;
    private int storyId;
    private java.lang.String type;

    public TaskData() {
    }

    public TaskData(
           int acceptorId,
           double actualHours,
           double adjustedEstimatedHours,
           boolean completed,
           java.util.Calendar createdDate,
           java.lang.String description,
           java.lang.String dispositionName,
           double estimatedHours,
           java.lang.String name,
           double originalEstimatedHours,
           double remainingHours,
           int storyId,
           java.lang.String type) {
           this.acceptorId = acceptorId;
           this.actualHours = actualHours;
           this.adjustedEstimatedHours = adjustedEstimatedHours;
           this.completed = completed;
           this.createdDate = createdDate;
           this.description = description;
           this.dispositionName = dispositionName;
           this.estimatedHours = estimatedHours;
           this.name = name;
           this.originalEstimatedHours = originalEstimatedHours;
           this.remainingHours = remainingHours;
           this.storyId = storyId;
           this.type = type;
    }


    /**
     * Gets the acceptorId value for this TaskData.
     * 
     * @return acceptorId
     */
    public int getAcceptorId() {
        return acceptorId;
    }


    /**
     * Sets the acceptorId value for this TaskData.
     * 
     * @param acceptorId
     */
    public void setAcceptorId(int acceptorId) {
        this.acceptorId = acceptorId;
    }


    /**
     * Gets the actualHours value for this TaskData.
     * 
     * @return actualHours
     */
    public double getActualHours() {
        return actualHours;
    }


    /**
     * Sets the actualHours value for this TaskData.
     * 
     * @param actualHours
     */
    public void setActualHours(double actualHours) {
        this.actualHours = actualHours;
    }


    /**
     * Gets the adjustedEstimatedHours value for this TaskData.
     * 
     * @return adjustedEstimatedHours
     */
    public double getAdjustedEstimatedHours() {
        return adjustedEstimatedHours;
    }


    /**
     * Sets the adjustedEstimatedHours value for this TaskData.
     * 
     * @param adjustedEstimatedHours
     */
    public void setAdjustedEstimatedHours(double adjustedEstimatedHours) {
        this.adjustedEstimatedHours = adjustedEstimatedHours;
    }


    /**
     * Gets the completed value for this TaskData.
     * 
     * @return completed
     */
    public boolean isCompleted() {
        return completed;
    }


    /**
     * Sets the completed value for this TaskData.
     * 
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    /**
     * Gets the createdDate value for this TaskData.
     * 
     * @return createdDate
     */
    public java.util.Calendar getCreatedDate() {
        return createdDate;
    }


    /**
     * Sets the createdDate value for this TaskData.
     * 
     * @param createdDate
     */
    public void setCreatedDate(java.util.Calendar createdDate) {
        this.createdDate = createdDate;
    }


    /**
     * Gets the description value for this TaskData.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this TaskData.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the dispositionName value for this TaskData.
     * 
     * @return dispositionName
     */
    public java.lang.String getDispositionName() {
        return dispositionName;
    }


    /**
     * Sets the dispositionName value for this TaskData.
     * 
     * @param dispositionName
     */
    public void setDispositionName(java.lang.String dispositionName) {
        this.dispositionName = dispositionName;
    }


    /**
     * Gets the estimatedHours value for this TaskData.
     * 
     * @return estimatedHours
     */
    public double getEstimatedHours() {
        return estimatedHours;
    }


    /**
     * Sets the estimatedHours value for this TaskData.
     * 
     * @param estimatedHours
     */
    public void setEstimatedHours(double estimatedHours) {
        this.estimatedHours = estimatedHours;
    }


    /**
     * Gets the name value for this TaskData.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this TaskData.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the originalEstimatedHours value for this TaskData.
     * 
     * @return originalEstimatedHours
     */
    public double getOriginalEstimatedHours() {
        return originalEstimatedHours;
    }


    /**
     * Sets the originalEstimatedHours value for this TaskData.
     * 
     * @param originalEstimatedHours
     */
    public void setOriginalEstimatedHours(double originalEstimatedHours) {
        this.originalEstimatedHours = originalEstimatedHours;
    }


    /**
     * Gets the remainingHours value for this TaskData.
     * 
     * @return remainingHours
     */
    public double getRemainingHours() {
        return remainingHours;
    }


    /**
     * Sets the remainingHours value for this TaskData.
     * 
     * @param remainingHours
     */
    public void setRemainingHours(double remainingHours) {
        this.remainingHours = remainingHours;
    }


    /**
     * Gets the storyId value for this TaskData.
     * 
     * @return storyId
     */
    public int getStoryId() {
        return storyId;
    }


    /**
     * Sets the storyId value for this TaskData.
     * 
     * @param storyId
     */
    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }


    /**
     * Gets the type value for this TaskData.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this TaskData.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TaskData)) return false;
        TaskData other = (TaskData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.acceptorId == other.getAcceptorId() &&
            this.actualHours == other.getActualHours() &&
            this.adjustedEstimatedHours == other.getAdjustedEstimatedHours() &&
            this.completed == other.isCompleted() &&
            ((this.createdDate==null && other.getCreatedDate()==null) || 
             (this.createdDate!=null &&
              this.createdDate.equals(other.getCreatedDate()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.dispositionName==null && other.getDispositionName()==null) || 
             (this.dispositionName!=null &&
              this.dispositionName.equals(other.getDispositionName()))) &&
            this.estimatedHours == other.getEstimatedHours() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.originalEstimatedHours == other.getOriginalEstimatedHours() &&
            this.remainingHours == other.getRemainingHours() &&
            this.storyId == other.getStoryId() &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType())));
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
        _hashCode += getAcceptorId();
        _hashCode += new Double(getActualHours()).hashCode();
        _hashCode += new Double(getAdjustedEstimatedHours()).hashCode();
        _hashCode += (isCompleted() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCreatedDate() != null) {
            _hashCode += getCreatedDate().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getDispositionName() != null) {
            _hashCode += getDispositionName().hashCode();
        }
        _hashCode += new Double(getEstimatedHours()).hashCode();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += new Double(getOriginalEstimatedHours()).hashCode();
        _hashCode += new Double(getRemainingHours()).hashCode();
        _hashCode += getStoryId();
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
