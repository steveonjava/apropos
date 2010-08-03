/**
 * UserIterationCapacity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.rallydev.webservice.v1_19.domain;

public class UserIterationCapacity  extends com.rallydev.webservice.v1_19.domain.WorkspaceDomainObject  implements java.io.Serializable {
    private java.lang.Double capacity;

    private com.rallydev.webservice.v1_19.domain.Iteration iteration;

    private java.lang.Double load;

    private com.rallydev.webservice.v1_19.domain.Project project;

    private java.lang.Double taskEstimates;

    private com.rallydev.webservice.v1_19.domain.User user;

    public UserIterationCapacity() {
    }

    public UserIterationCapacity(
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
           java.lang.Double capacity,
           com.rallydev.webservice.v1_19.domain.Iteration iteration,
           java.lang.Double load,
           com.rallydev.webservice.v1_19.domain.Project project,
           java.lang.Double taskEstimates,
           com.rallydev.webservice.v1_19.domain.User user) {
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
        this.capacity = capacity;
        this.iteration = iteration;
        this.load = load;
        this.project = project;
        this.taskEstimates = taskEstimates;
        this.user = user;
    }


    /**
     * Gets the capacity value for this UserIterationCapacity.
     * 
     * @return capacity
     */
    public java.lang.Double getCapacity() {
        return capacity;
    }


    /**
     * Sets the capacity value for this UserIterationCapacity.
     * 
     * @param capacity
     */
    public void setCapacity(java.lang.Double capacity) {
        this.capacity = capacity;
    }


    /**
     * Gets the iteration value for this UserIterationCapacity.
     * 
     * @return iteration
     */
    public com.rallydev.webservice.v1_19.domain.Iteration getIteration() {
        return iteration;
    }


    /**
     * Sets the iteration value for this UserIterationCapacity.
     * 
     * @param iteration
     */
    public void setIteration(com.rallydev.webservice.v1_19.domain.Iteration iteration) {
        this.iteration = iteration;
    }


    /**
     * Gets the load value for this UserIterationCapacity.
     * 
     * @return load
     */
    public java.lang.Double getLoad() {
        return load;
    }


    /**
     * Sets the load value for this UserIterationCapacity.
     * 
     * @param load
     */
    public void setLoad(java.lang.Double load) {
        this.load = load;
    }


    /**
     * Gets the project value for this UserIterationCapacity.
     * 
     * @return project
     */
    public com.rallydev.webservice.v1_19.domain.Project getProject() {
        return project;
    }


    /**
     * Sets the project value for this UserIterationCapacity.
     * 
     * @param project
     */
    public void setProject(com.rallydev.webservice.v1_19.domain.Project project) {
        this.project = project;
    }


    /**
     * Gets the taskEstimates value for this UserIterationCapacity.
     * 
     * @return taskEstimates
     */
    public java.lang.Double getTaskEstimates() {
        return taskEstimates;
    }


    /**
     * Sets the taskEstimates value for this UserIterationCapacity.
     * 
     * @param taskEstimates
     */
    public void setTaskEstimates(java.lang.Double taskEstimates) {
        this.taskEstimates = taskEstimates;
    }


    /**
     * Gets the user value for this UserIterationCapacity.
     * 
     * @return user
     */
    public com.rallydev.webservice.v1_19.domain.User getUser() {
        return user;
    }


    /**
     * Sets the user value for this UserIterationCapacity.
     * 
     * @param user
     */
    public void setUser(com.rallydev.webservice.v1_19.domain.User user) {
        this.user = user;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserIterationCapacity)) return false;
        UserIterationCapacity other = (UserIterationCapacity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.capacity==null && other.getCapacity()==null) || 
             (this.capacity!=null &&
              this.capacity.equals(other.getCapacity()))) &&
            ((this.iteration==null && other.getIteration()==null) || 
             (this.iteration!=null &&
              this.iteration.equals(other.getIteration()))) &&
            ((this.load==null && other.getLoad()==null) || 
             (this.load!=null &&
              this.load.equals(other.getLoad()))) &&
            ((this.project==null && other.getProject()==null) || 
             (this.project!=null &&
              this.project.equals(other.getProject()))) &&
            ((this.taskEstimates==null && other.getTaskEstimates()==null) || 
             (this.taskEstimates!=null &&
              this.taskEstimates.equals(other.getTaskEstimates()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser())));
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
        if (getCapacity() != null) {
            _hashCode += getCapacity().hashCode();
        }
        if (getIteration() != null) {
            _hashCode += getIteration().hashCode();
        }
        if (getLoad() != null) {
            _hashCode += getLoad().hashCode();
        }
        if (getProject() != null) {
            _hashCode += getProject().hashCode();
        }
        if (getTaskEstimates() != null) {
            _hashCode += getTaskEstimates().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserIterationCapacity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "UserIterationCapacity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("capacity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Capacity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iteration");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Iteration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Iteration"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("load");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Load"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("project");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Project"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Project"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taskEstimates");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TaskEstimates"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "User"));
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
