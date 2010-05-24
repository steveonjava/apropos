/**
 * TimeEntryItem.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.apropos.api;

public class TimeEntryItem  extends org.apropos.api.WorkspaceDomainObject  implements java.io.Serializable {
    private org.apropos.api.Project project;

    private java.lang.String projectDisplayString;

    private org.apropos.api.RevisionHistory revisionHistory;

    private org.apropos.api.Task task;

    private java.lang.String taskDisplayString;

    private java.lang.String user;

    private org.apropos.api.TimeEntryValue[] values;

    private java.util.Calendar weekStartDate;

    private org.apropos.api.Artifact workProduct;

    private java.lang.String workProductDisplayString;

    public TimeEntryItem() {
    }

    public TimeEntryItem(
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
           org.apropos.api.Project project,
           java.lang.String projectDisplayString,
           org.apropos.api.RevisionHistory revisionHistory,
           org.apropos.api.Task task,
           java.lang.String taskDisplayString,
           java.lang.String user,
           org.apropos.api.TimeEntryValue[] values,
           java.util.Calendar weekStartDate,
           org.apropos.api.Artifact workProduct,
           java.lang.String workProductDisplayString) {
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
        this.project = project;
        this.projectDisplayString = projectDisplayString;
        this.revisionHistory = revisionHistory;
        this.task = task;
        this.taskDisplayString = taskDisplayString;
        this.user = user;
        this.values = values;
        this.weekStartDate = weekStartDate;
        this.workProduct = workProduct;
        this.workProductDisplayString = workProductDisplayString;
    }


    /**
     * Gets the project value for this TimeEntryItem.
     * 
     * @return project
     */
    public org.apropos.api.Project getProject() {
        return project;
    }


    /**
     * Sets the project value for this TimeEntryItem.
     * 
     * @param project
     */
    public void setProject(org.apropos.api.Project project) {
        this.project = project;
    }


    /**
     * Gets the projectDisplayString value for this TimeEntryItem.
     * 
     * @return projectDisplayString
     */
    public java.lang.String getProjectDisplayString() {
        return projectDisplayString;
    }


    /**
     * Sets the projectDisplayString value for this TimeEntryItem.
     * 
     * @param projectDisplayString
     */
    public void setProjectDisplayString(java.lang.String projectDisplayString) {
        this.projectDisplayString = projectDisplayString;
    }


    /**
     * Gets the revisionHistory value for this TimeEntryItem.
     * 
     * @return revisionHistory
     */
    public org.apropos.api.RevisionHistory getRevisionHistory() {
        return revisionHistory;
    }


    /**
     * Sets the revisionHistory value for this TimeEntryItem.
     * 
     * @param revisionHistory
     */
    public void setRevisionHistory(org.apropos.api.RevisionHistory revisionHistory) {
        this.revisionHistory = revisionHistory;
    }


    /**
     * Gets the task value for this TimeEntryItem.
     * 
     * @return task
     */
    public org.apropos.api.Task getTask() {
        return task;
    }


    /**
     * Sets the task value for this TimeEntryItem.
     * 
     * @param task
     */
    public void setTask(org.apropos.api.Task task) {
        this.task = task;
    }


    /**
     * Gets the taskDisplayString value for this TimeEntryItem.
     * 
     * @return taskDisplayString
     */
    public java.lang.String getTaskDisplayString() {
        return taskDisplayString;
    }


    /**
     * Sets the taskDisplayString value for this TimeEntryItem.
     * 
     * @param taskDisplayString
     */
    public void setTaskDisplayString(java.lang.String taskDisplayString) {
        this.taskDisplayString = taskDisplayString;
    }


    /**
     * Gets the user value for this TimeEntryItem.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this TimeEntryItem.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }


    /**
     * Gets the values value for this TimeEntryItem.
     * 
     * @return values
     */
    public org.apropos.api.TimeEntryValue[] getValues() {
        return values;
    }


    /**
     * Sets the values value for this TimeEntryItem.
     * 
     * @param values
     */
    public void setValues(org.apropos.api.TimeEntryValue[] values) {
        this.values = values;
    }


    /**
     * Gets the weekStartDate value for this TimeEntryItem.
     * 
     * @return weekStartDate
     */
    public java.util.Calendar getWeekStartDate() {
        return weekStartDate;
    }


    /**
     * Sets the weekStartDate value for this TimeEntryItem.
     * 
     * @param weekStartDate
     */
    public void setWeekStartDate(java.util.Calendar weekStartDate) {
        this.weekStartDate = weekStartDate;
    }


    /**
     * Gets the workProduct value for this TimeEntryItem.
     * 
     * @return workProduct
     */
    public org.apropos.api.Artifact getWorkProduct() {
        return workProduct;
    }


    /**
     * Sets the workProduct value for this TimeEntryItem.
     * 
     * @param workProduct
     */
    public void setWorkProduct(org.apropos.api.Artifact workProduct) {
        this.workProduct = workProduct;
    }


    /**
     * Gets the workProductDisplayString value for this TimeEntryItem.
     * 
     * @return workProductDisplayString
     */
    public java.lang.String getWorkProductDisplayString() {
        return workProductDisplayString;
    }


    /**
     * Sets the workProductDisplayString value for this TimeEntryItem.
     * 
     * @param workProductDisplayString
     */
    public void setWorkProductDisplayString(java.lang.String workProductDisplayString) {
        this.workProductDisplayString = workProductDisplayString;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TimeEntryItem)) return false;
        TimeEntryItem other = (TimeEntryItem) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.project==null && other.getProject()==null) || 
             (this.project!=null &&
              this.project.equals(other.getProject()))) &&
            ((this.projectDisplayString==null && other.getProjectDisplayString()==null) || 
             (this.projectDisplayString!=null &&
              this.projectDisplayString.equals(other.getProjectDisplayString()))) &&
            ((this.revisionHistory==null && other.getRevisionHistory()==null) || 
             (this.revisionHistory!=null &&
              this.revisionHistory.equals(other.getRevisionHistory()))) &&
            ((this.task==null && other.getTask()==null) || 
             (this.task!=null &&
              this.task.equals(other.getTask()))) &&
            ((this.taskDisplayString==null && other.getTaskDisplayString()==null) || 
             (this.taskDisplayString!=null &&
              this.taskDisplayString.equals(other.getTaskDisplayString()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.values==null && other.getValues()==null) || 
             (this.values!=null &&
              java.util.Arrays.equals(this.values, other.getValues()))) &&
            ((this.weekStartDate==null && other.getWeekStartDate()==null) || 
             (this.weekStartDate!=null &&
              this.weekStartDate.equals(other.getWeekStartDate()))) &&
            ((this.workProduct==null && other.getWorkProduct()==null) || 
             (this.workProduct!=null &&
              this.workProduct.equals(other.getWorkProduct()))) &&
            ((this.workProductDisplayString==null && other.getWorkProductDisplayString()==null) || 
             (this.workProductDisplayString!=null &&
              this.workProductDisplayString.equals(other.getWorkProductDisplayString())));
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
        if (getProject() != null) {
            _hashCode += getProject().hashCode();
        }
        if (getProjectDisplayString() != null) {
            _hashCode += getProjectDisplayString().hashCode();
        }
        if (getRevisionHistory() != null) {
            _hashCode += getRevisionHistory().hashCode();
        }
        if (getTask() != null) {
            _hashCode += getTask().hashCode();
        }
        if (getTaskDisplayString() != null) {
            _hashCode += getTaskDisplayString().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getValues() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValues());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValues(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWeekStartDate() != null) {
            _hashCode += getWeekStartDate().hashCode();
        }
        if (getWorkProduct() != null) {
            _hashCode += getWorkProduct().hashCode();
        }
        if (getWorkProductDisplayString() != null) {
            _hashCode += getWorkProductDisplayString().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TimeEntryItem.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TimeEntryItem"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("project");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Project"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Project"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("projectDisplayString");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ProjectDisplayString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("task");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Task"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Task"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskDisplayString");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TaskDisplayString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("values");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Values"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TimeEntryValue"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "TimeEntryValue"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("weekStartDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WeekStartDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workProduct");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WorkProduct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Artifact"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workProductDisplayString");
        elemField.setXmlName(new javax.xml.namespace.QName("", "WorkProductDisplayString"));
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
