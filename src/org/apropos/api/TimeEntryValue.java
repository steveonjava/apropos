/**
 * TimeEntryValue.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.apropos.api;

public class TimeEntryValue  extends org.apropos.api.WorkspaceDomainObject  implements java.io.Serializable {
    private java.util.Calendar dateVal;

    private java.lang.Double hours;

    private java.util.Calendar lastUpdated;

    private org.apropos.api.RevisionHistory revisionHistory;

    private org.apropos.api.TimeEntryItem timeEntryItem;

    public TimeEntryValue() {
    }

    public TimeEntryValue(
           java.lang.String ref,
           long objectVersion,
           java.lang.String type,
           java.lang.String refObjectName,
           long rallyAPIMajor,
           long rallyAPIMinor,
           java.util.Calendar creationDate,
           java.lang.Long objectID,
           org.apropos.api.Subscription subscription,
           org.apropos.api.Workspace workspace,
           java.util.Calendar dateVal,
           java.lang.Double hours,
           java.util.Calendar lastUpdated,
           org.apropos.api.RevisionHistory revisionHistory,
           org.apropos.api.TimeEntryItem timeEntryItem) {
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
        this.dateVal = dateVal;
        this.hours = hours;
        this.lastUpdated = lastUpdated;
        this.revisionHistory = revisionHistory;
        this.timeEntryItem = timeEntryItem;
    }


    /**
     * Gets the dateVal value for this TimeEntryValue.
     * 
     * @return dateVal
     */
    public java.util.Calendar getDateVal() {
        return dateVal;
    }


    /**
     * Sets the dateVal value for this TimeEntryValue.
     * 
     * @param dateVal
     */
    public void setDateVal(java.util.Calendar dateVal) {
        this.dateVal = dateVal;
    }


    /**
     * Gets the hours value for this TimeEntryValue.
     * 
     * @return hours
     */
    public java.lang.Double getHours() {
        return hours;
    }


    /**
     * Sets the hours value for this TimeEntryValue.
     * 
     * @param hours
     */
    public void setHours(java.lang.Double hours) {
        this.hours = hours;
    }


    /**
     * Gets the lastUpdated value for this TimeEntryValue.
     * 
     * @return lastUpdated
     */
    public java.util.Calendar getLastUpdated() {
        return lastUpdated;
    }


    /**
     * Sets the lastUpdated value for this TimeEntryValue.
     * 
     * @param lastUpdated
     */
    public void setLastUpdated(java.util.Calendar lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


    /**
     * Gets the revisionHistory value for this TimeEntryValue.
     * 
     * @return revisionHistory
     */
    public org.apropos.api.RevisionHistory getRevisionHistory() {
        return revisionHistory;
    }


    /**
     * Sets the revisionHistory value for this TimeEntryValue.
     * 
     * @param revisionHistory
     */
    public void setRevisionHistory(org.apropos.api.RevisionHistory revisionHistory) {
        this.revisionHistory = revisionHistory;
    }


    /**
     * Gets the timeEntryItem value for this TimeEntryValue.
     * 
     * @return timeEntryItem
     */
    public org.apropos.api.TimeEntryItem getTimeEntryItem() {
        return timeEntryItem;
    }


    /**
     * Sets the timeEntryItem value for this TimeEntryValue.
     * 
     * @param timeEntryItem
     */
    public void setTimeEntryItem(org.apropos.api.TimeEntryItem timeEntryItem) {
        this.timeEntryItem = timeEntryItem;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TimeEntryValue)) return false;
        TimeEntryValue other = (TimeEntryValue) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dateVal==null && other.getDateVal()==null) || 
             (this.dateVal!=null &&
              this.dateVal.equals(other.getDateVal()))) &&
            ((this.hours==null && other.getHours()==null) || 
             (this.hours!=null &&
              this.hours.equals(other.getHours()))) &&
            ((this.lastUpdated==null && other.getLastUpdated()==null) || 
             (this.lastUpdated!=null &&
              this.lastUpdated.equals(other.getLastUpdated()))) &&
            ((this.revisionHistory==null && other.getRevisionHistory()==null) || 
             (this.revisionHistory!=null &&
              this.revisionHistory.equals(other.getRevisionHistory()))) &&
            ((this.timeEntryItem==null && other.getTimeEntryItem()==null) || 
             (this.timeEntryItem!=null &&
              this.timeEntryItem.equals(other.getTimeEntryItem())));
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
        if (getDateVal() != null) {
            _hashCode += getDateVal().hashCode();
        }
        if (getHours() != null) {
            _hashCode += getHours().hashCode();
        }
        if (getLastUpdated() != null) {
            _hashCode += getLastUpdated().hashCode();
        }
        if (getRevisionHistory() != null) {
            _hashCode += getRevisionHistory().hashCode();
        }
        if (getTimeEntryItem() != null) {
            _hashCode += getTimeEntryItem().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TimeEntryValue.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TimeEntryValue"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateVal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DateVal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hours");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Hours"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastUpdated");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LastUpdated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisionHistory");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RevisionHistory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "RevisionHistory"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timeEntryItem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TimeEntryItem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TimeEntryItem"));
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
