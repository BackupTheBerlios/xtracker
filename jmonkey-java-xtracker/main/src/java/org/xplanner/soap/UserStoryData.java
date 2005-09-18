/**
 * UserStoryData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2RC2 Nov 16, 2004 (12:19:44 EST) WSDL2Java emitter.
 */

package org.xplanner.soap;

public class UserStoryData  extends com.technoetic.xplanner.soap.domain.DomainData  implements java.io.Serializable {
    private double actualHours;
    private double adjustedEstimatedHours;
    private boolean completed;
    private int customerId;
    private java.lang.String description;
    private java.lang.String dispositionName;
    private double estimatedHours;
    private int iterationId;
    private java.lang.String name;
    private double originalEstimatedHours;
    private double postponedHours;
    private int priority;
    private double remainingHours;
    private int trackerId;

    public UserStoryData() {
    }

    public UserStoryData(
           double actualHours,
           double adjustedEstimatedHours,
           boolean completed,
           int customerId,
           java.lang.String description,
           java.lang.String dispositionName,
           double estimatedHours,
           int iterationId,
           java.lang.String name,
           double originalEstimatedHours,
           double postponedHours,
           int priority,
           double remainingHours,
           int trackerId) {
           this.actualHours = actualHours;
           this.adjustedEstimatedHours = adjustedEstimatedHours;
           this.completed = completed;
           this.customerId = customerId;
           this.description = description;
           this.dispositionName = dispositionName;
           this.estimatedHours = estimatedHours;
           this.iterationId = iterationId;
           this.name = name;
           this.originalEstimatedHours = originalEstimatedHours;
           this.postponedHours = postponedHours;
           this.priority = priority;
           this.remainingHours = remainingHours;
           this.trackerId = trackerId;
    }


    /**
     * Gets the actualHours value for this UserStoryData.
     * 
     * @return actualHours
     */
    public double getActualHours() {
        return actualHours;
    }


    /**
     * Sets the actualHours value for this UserStoryData.
     * 
     * @param actualHours
     */
    public void setActualHours(double actualHours) {
        this.actualHours = actualHours;
    }


    /**
     * Gets the adjustedEstimatedHours value for this UserStoryData.
     * 
     * @return adjustedEstimatedHours
     */
    public double getAdjustedEstimatedHours() {
        return adjustedEstimatedHours;
    }


    /**
     * Sets the adjustedEstimatedHours value for this UserStoryData.
     * 
     * @param adjustedEstimatedHours
     */
    public void setAdjustedEstimatedHours(double adjustedEstimatedHours) {
        this.adjustedEstimatedHours = adjustedEstimatedHours;
    }


    /**
     * Gets the completed value for this UserStoryData.
     * 
     * @return completed
     */
    public boolean isCompleted() {
        return completed;
    }


    /**
     * Sets the completed value for this UserStoryData.
     * 
     * @param completed
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


    /**
     * Gets the customerId value for this UserStoryData.
     * 
     * @return customerId
     */
    public int getCustomerId() {
        return customerId;
    }


    /**
     * Sets the customerId value for this UserStoryData.
     * 
     * @param customerId
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    /**
     * Gets the description value for this UserStoryData.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this UserStoryData.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the dispositionName value for this UserStoryData.
     * 
     * @return dispositionName
     */
    public java.lang.String getDispositionName() {
        return dispositionName;
    }


    /**
     * Sets the dispositionName value for this UserStoryData.
     * 
     * @param dispositionName
     */
    public void setDispositionName(java.lang.String dispositionName) {
        this.dispositionName = dispositionName;
    }


    /**
     * Gets the estimatedHours value for this UserStoryData.
     * 
     * @return estimatedHours
     */
    public double getEstimatedHours() {
        return estimatedHours;
    }


    /**
     * Sets the estimatedHours value for this UserStoryData.
     * 
     * @param estimatedHours
     */
    public void setEstimatedHours(double estimatedHours) {
        this.estimatedHours = estimatedHours;
    }


    /**
     * Gets the iterationId value for this UserStoryData.
     * 
     * @return iterationId
     */
    public int getIterationId() {
        return iterationId;
    }


    /**
     * Sets the iterationId value for this UserStoryData.
     * 
     * @param iterationId
     */
    public void setIterationId(int iterationId) {
        this.iterationId = iterationId;
    }


    /**
     * Gets the name value for this UserStoryData.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this UserStoryData.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the originalEstimatedHours value for this UserStoryData.
     * 
     * @return originalEstimatedHours
     */
    public double getOriginalEstimatedHours() {
        return originalEstimatedHours;
    }


    /**
     * Sets the originalEstimatedHours value for this UserStoryData.
     * 
     * @param originalEstimatedHours
     */
    public void setOriginalEstimatedHours(double originalEstimatedHours) {
        this.originalEstimatedHours = originalEstimatedHours;
    }


    /**
     * Gets the postponedHours value for this UserStoryData.
     * 
     * @return postponedHours
     */
    public double getPostponedHours() {
        return postponedHours;
    }


    /**
     * Sets the postponedHours value for this UserStoryData.
     * 
     * @param postponedHours
     */
    public void setPostponedHours(double postponedHours) {
        this.postponedHours = postponedHours;
    }


    /**
     * Gets the priority value for this UserStoryData.
     * 
     * @return priority
     */
    public int getPriority() {
        return priority;
    }


    /**
     * Sets the priority value for this UserStoryData.
     * 
     * @param priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }


    /**
     * Gets the remainingHours value for this UserStoryData.
     * 
     * @return remainingHours
     */
    public double getRemainingHours() {
        return remainingHours;
    }


    /**
     * Sets the remainingHours value for this UserStoryData.
     * 
     * @param remainingHours
     */
    public void setRemainingHours(double remainingHours) {
        this.remainingHours = remainingHours;
    }


    /**
     * Gets the trackerId value for this UserStoryData.
     * 
     * @return trackerId
     */
    public int getTrackerId() {
        return trackerId;
    }


    /**
     * Sets the trackerId value for this UserStoryData.
     * 
     * @param trackerId
     */
    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserStoryData)) return false;
        UserStoryData other = (UserStoryData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.actualHours == other.getActualHours() &&
            this.adjustedEstimatedHours == other.getAdjustedEstimatedHours() &&
            this.completed == other.isCompleted() &&
            this.customerId == other.getCustomerId() &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.dispositionName==null && other.getDispositionName()==null) || 
             (this.dispositionName!=null &&
              this.dispositionName.equals(other.getDispositionName()))) &&
            this.estimatedHours == other.getEstimatedHours() &&
            this.iterationId == other.getIterationId() &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            this.originalEstimatedHours == other.getOriginalEstimatedHours() &&
            this.postponedHours == other.getPostponedHours() &&
            this.priority == other.getPriority() &&
            this.remainingHours == other.getRemainingHours() &&
            this.trackerId == other.getTrackerId();
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
        _hashCode += new Double(getActualHours()).hashCode();
        _hashCode += new Double(getAdjustedEstimatedHours()).hashCode();
        _hashCode += (isCompleted() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getCustomerId();
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getDispositionName() != null) {
            _hashCode += getDispositionName().hashCode();
        }
        _hashCode += new Double(getEstimatedHours()).hashCode();
        _hashCode += getIterationId();
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        _hashCode += new Double(getOriginalEstimatedHours()).hashCode();
        _hashCode += new Double(getPostponedHours()).hashCode();
        _hashCode += getPriority();
        _hashCode += new Double(getRemainingHours()).hashCode();
        _hashCode += getTrackerId();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
