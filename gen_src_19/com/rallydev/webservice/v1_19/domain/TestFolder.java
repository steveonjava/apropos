/**
 * TestFolder.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.rallydev.webservice.v1_19.domain;

public class TestFolder  extends com.rallydev.webservice.v1_19.domain.WorkspaceDomainObject  implements java.io.Serializable {
    private com.rallydev.webservice.v1_19.domain.TestFolder[] children;

    private java.lang.String formattedID;

    private java.lang.String name;

    private com.rallydev.webservice.v1_19.domain.TestFolder parent;

    private com.rallydev.webservice.v1_19.domain.Project project;

    private com.rallydev.webservice.v1_19.domain.TestCase[] testCases;

    public TestFolder() {
    }

    public TestFolder(
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
           com.rallydev.webservice.v1_19.domain.TestFolder[] children,
           java.lang.String formattedID,
           java.lang.String name,
           com.rallydev.webservice.v1_19.domain.TestFolder parent,
           com.rallydev.webservice.v1_19.domain.Project project,
           com.rallydev.webservice.v1_19.domain.TestCase[] testCases) {
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
        this.children = children;
        this.formattedID = formattedID;
        this.name = name;
        this.parent = parent;
        this.project = project;
        this.testCases = testCases;
    }


    /**
     * Gets the children value for this TestFolder.
     * 
     * @return children
     */
    public com.rallydev.webservice.v1_19.domain.TestFolder[] getChildren() {
        return children;
    }


    /**
     * Sets the children value for this TestFolder.
     * 
     * @param children
     */
    public void setChildren(com.rallydev.webservice.v1_19.domain.TestFolder[] children) {
        this.children = children;
    }


    /**
     * Gets the formattedID value for this TestFolder.
     * 
     * @return formattedID
     */
    public java.lang.String getFormattedID() {
        return formattedID;
    }


    /**
     * Sets the formattedID value for this TestFolder.
     * 
     * @param formattedID
     */
    public void setFormattedID(java.lang.String formattedID) {
        this.formattedID = formattedID;
    }


    /**
     * Gets the name value for this TestFolder.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this TestFolder.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the parent value for this TestFolder.
     * 
     * @return parent
     */
    public com.rallydev.webservice.v1_19.domain.TestFolder getParent() {
        return parent;
    }


    /**
     * Sets the parent value for this TestFolder.
     * 
     * @param parent
     */
    public void setParent(com.rallydev.webservice.v1_19.domain.TestFolder parent) {
        this.parent = parent;
    }


    /**
     * Gets the project value for this TestFolder.
     * 
     * @return project
     */
    public com.rallydev.webservice.v1_19.domain.Project getProject() {
        return project;
    }


    /**
     * Sets the project value for this TestFolder.
     * 
     * @param project
     */
    public void setProject(com.rallydev.webservice.v1_19.domain.Project project) {
        this.project = project;
    }


    /**
     * Gets the testCases value for this TestFolder.
     * 
     * @return testCases
     */
    public com.rallydev.webservice.v1_19.domain.TestCase[] getTestCases() {
        return testCases;
    }


    /**
     * Sets the testCases value for this TestFolder.
     * 
     * @param testCases
     */
    public void setTestCases(com.rallydev.webservice.v1_19.domain.TestCase[] testCases) {
        this.testCases = testCases;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TestFolder)) return false;
        TestFolder other = (TestFolder) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.children==null && other.getChildren()==null) || 
             (this.children!=null &&
              java.util.Arrays.equals(this.children, other.getChildren()))) &&
            ((this.formattedID==null && other.getFormattedID()==null) || 
             (this.formattedID!=null &&
              this.formattedID.equals(other.getFormattedID()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.parent==null && other.getParent()==null) || 
             (this.parent!=null &&
              this.parent.equals(other.getParent()))) &&
            ((this.project==null && other.getProject()==null) || 
             (this.project!=null &&
              this.project.equals(other.getProject()))) &&
            ((this.testCases==null && other.getTestCases()==null) || 
             (this.testCases!=null &&
              java.util.Arrays.equals(this.testCases, other.getTestCases())));
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
        if (getChildren() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getChildren());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getChildren(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFormattedID() != null) {
            _hashCode += getFormattedID().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getParent() != null) {
            _hashCode += getParent().hashCode();
        }
        if (getProject() != null) {
            _hashCode += getProject().hashCode();
        }
        if (getTestCases() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTestCases());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTestCases(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TestFolder.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "TestFolder"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("children");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Children"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "TestFolder"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "TestFolder"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("formattedID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "FormattedID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parent");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Parent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "TestFolder"));
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
        elemField.setFieldName("testCases");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TestCases"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "TestCase"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "TestCase"));
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
