/**
 * WorkspaceConfiguration.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.rallydev.webservice.v1_19.domain;

public class WorkspaceConfiguration  extends com.rallydev.webservice.v1_19.domain.WorkspaceDomainObject  implements java.io.Serializable {
    private java.lang.String dateFormat;

    private java.lang.String dateTimeFormat;

    private java.lang.String iterationEstimateUnitName;

    private java.lang.String releaseEstimateUnitName;

    private java.lang.String taskUnitName;

    private java.lang.Boolean timeTrackerEnabled;

    private java.lang.String timeZone;

    private java.lang.String workDays;

    public WorkspaceConfiguration() {
    }

    public WorkspaceConfiguration(
           java.lang.String ref,
           long objectVersion,
           java.lang.String type,
           java.lang.String refObjectName,
           long rallyAPIMajor,
           long rallyAPIMinor,
           java.util.Calendar creationDate,
           java.lang.Long objectID,
           com.rallydev.webservice.v1_19.domain.Subscription subscription,
           com.rallydev.webservice.v1_19.domain.Workspace workspace,
           java.lang.String dateFormat,
           java.lang.String dateTimeFormat,
           java.lang.String iterationEstimateUnitName,
           java.lang.String releaseEstimateUnitName,
           java.lang.String taskUnitName,
           java.lang.Boolean timeTrackerEnabled,
           java.lang.String timeZone,
           java.lang.String workDays) {
        super(
            ref,
            objectVersion,
            type,
            refObjectName,
            rallyAPIMajor,
            rallyAPIMinor,
            creationDate,
            objectID,
            subscription,
            workspace);
        this.dateFormat = dateFormat;
        this.dateTimeFormat = dateTimeFormat;
        this.iterationEstimateUnitName = iterationEstimateUnitName;
        this.releaseEstimateUnitName = releaseEstimateUnitName;
        this.taskUnitName = taskUnitName;
        this.timeTrackerEnabled = timeTrackerEnabled;
        this.timeZone = timeZone;
        this.workDays = workDays;
    }


    /**
     * Gets the dateFormat value for this WorkspaceConfiguration.
     * 
     * @return dateFormat
     */
    public java.lang.String getDateFormat() {
        return dateFormat;
    }


    /**
     * Sets the dateFormat value for this WorkspaceConfiguration.
     * 
     * @param dateFormat
     */
    public void setDateFormat(java.lang.String dateFormat) {
        this.dateFormat = dateFormat;
    }


    /**
     * Gets the dateTimeFormat value for this WorkspaceConfiguration.
     * 
     * @return dateTimeFormat
     */
    public java.lang.String getDateTimeFormat() {
        return dateTimeFormat;
    }


    /**
     * Sets the dateTimeFormat value for this WorkspaceConfiguration.
     * 
     * @param dateTimeFormat
     */
    public void setDateTimeFormat(java.lang.String dateTimeFormat) {
        this.dateTimeFormat = dateTimeFormat;
    }


    /**
     * Gets the iterationEstimateUnitName value for this WorkspaceConfiguration.
     * 
     * @return iterationEstimateUnitName
     */
    public java.lang.String getIterationEstimateUnitName() {
        return iterationEstimateUnitName;
    }


    /**
     * Sets the iterationEstimateUnitName value for this WorkspaceConfiguration.
     * 
     * @param iterationEstimateUnitName
     */
    public void setIterationEstimateUnitName(java.lang.String iterationEstimateUnitName) {
        this.iterationEstimateUnitName = iterationEstimateUnitName;
    }


    /**
     * Gets the releaseEstimateUnitName value for this WorkspaceConfiguration.
     * 
     * @return releaseEstimateUnitName
     */
    public java.lang.String getReleaseEstimateUnitName() {
        return releaseEstimateUnitName;
    }


    /**
     * Sets the releaseEstimateUnitName value for this WorkspaceConfiguration.
     * 
     * @param releaseEstimateUnitName
     */
    public void setReleaseEstimateUnitName(java.lang.String releaseEstimateUnitName) {
        this.releaseEstimateUnitName = releaseEstimateUnitName;
    }


    /**
     * Gets the taskUnitName value for this WorkspaceConfiguration.
     * 
     * @return taskUnitName
     */
    public java.lang.String getTaskUnitName() {
        return taskUnitName;
    }


    /**
     * Sets the taskUnitName value for this WorkspaceConfiguration.
     * 
     * @param taskUnitName
     */
    public void setTaskUnitName(java.lang.String taskUnitName) {
        this.taskUnitName = taskUnitName;
    }


    /**
     * Gets the timeTrackerEnabled value for this WorkspaceConfiguration.
     * 
     * @return timeTrackerEnabled
     */
    public java.lang.Boolean getTimeTrackerEnabled() {
        return timeTrackerEnabled;
    }


    /**
     * Sets the timeTrackerEnabled value for this WorkspaceConfiguration.
     * 
     * @param timeTrackerEnabled
     */
    public void setTimeTrackerEnabled(java.lang.Boolean timeTrackerEnabled) {
        this.timeTrackerEnabled = timeTrackerEnabled;
    }


    /**
     * Gets the timeZone value for this WorkspaceConfiguration.
     * 
     * @return timeZone
     */
    public java.lang.String getTimeZone() {
        return timeZone;
    }


    /**
     * Sets the timeZone value for this WorkspaceConfiguration.
     * 
     * @param timeZone
     */
    public void setTimeZone(java.lang.String timeZone) {
        this.timeZone = timeZone;
    }


    /**
     * Gets the workDays value for this WorkspaceConfiguration.
     * 
     * @return workDays
     */
    public java.lang.String getWorkDays() {
        return workDays;
    }


    /**
     * Sets the workDays value for this WorkspaceConfiguration.
     * 
     * @param workDays
     */
    public void setWorkDays(java.lang.String workDays) {
        this.workDays = workDays;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WorkspaceConfiguration)) return false;
        WorkspaceConfiguration other = (WorkspaceConfiguration) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dateFormat==null && other.getDateFormat()==null) || 
             (this.dateFormat!=null &&
              this.dateFormat.equals(other.getDateFormat()))) &&
            ((this.dateTimeFormat==null && other.getDateTimeFormat()==null) || 
             (this.dateTimeFormat!=null &&
              this.dateTimeFormat.equals(other.getDateTimeFormat()))) &&
            ((this.iterationEstimateUnitName==null && other.getIterationEstimateUnitName()==null) || 
             (this.iterationEstimateUnitName!=null &&
              this.iterationEstimateUnitName.equals(other.getIterationEstimateUnitName()))) &&
            ((this.releaseEstimateUnitName==null && other.getReleaseEstimateUnitName()==null) || 
             (this.releaseEstimateUnitName!=null &&
              this.releaseEstimateUnitName.equals(other.getReleaseEstimateUnitName()))) &&
            ((this.taskUnitName==null && other.getTaskUnitName()==null) || 
             (this.taskUnitName!=null &&
              this.taskUnitName.equals(other.getTaskUnitName()))) &&
            ((this.timeTrackerEnabled==null && other.getTimeTrackerEnabled()==null) || 
             (this.timeTrackerEnabled!=null &&
              this.timeTrackerEnabled.equals(other.getTimeTrackerEnabled()))) &&
            ((this.timeZone==null && other.getTimeZone()==null) || 
             (this.timeZone!=null &&
              this.timeZone.equals(other.getTimeZone()))) &&
            ((this.workDays==null && other.getWorkDays()==null) || 
             (this.workDays!=null &&
              this.workDays.equals(other.getWorkDays())));
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
        if (getDateFormat() != null) {
            _hashCode += getDateFormat().hashCode();
        }
        if (getDateTimeFormat() != null) {
            _hashCode += getDateTimeFormat().hashCode();
        }
        if (getIterationEstimateUnitName() != null) {
            _hashCode += getIterationEstimateUnitName().hashCode();
        }
        if (getReleaseEstimateUnitName() != null) {
            _hashCode += getReleaseEstimateUnitName().hashCode();
        }
        if (getTaskUnitName() != null) {
            _hashCode += getTaskUnitName().hashCode();
        }
        if (getTimeTrackerEnabled() != null) {
            _hashCode += getTimeTrackerEnabled().hashCode();
        }
        if (getTimeZone() != null) {
            _hashCode += getTimeZone().hashCode();
        }
        if (getWorkDays() != null) {
            _hashCode += getWorkDays().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WorkspaceConfiguration.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "WorkspaceConfiguration"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DateFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateTimeFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DateTimeFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iterationEstimateUnitName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IterationEstimateUnitName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("releaseEstimateUnitName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ReleaseEstimateUnitName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskUnitName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TaskUnitName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeTrackerEnabled");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TimeTrackerEnabled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeZone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TimeZone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workDays");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WorkDays"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
