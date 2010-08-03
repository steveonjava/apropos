/**
 * ArtifactNotification.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.rallydev.webservice.v1_19.domain;

public class ArtifactNotification  extends com.rallydev.webservice.v1_19.domain.WorkspaceDomainObject  implements java.io.Serializable {
    private java.lang.String className;

    private java.lang.String description;

    private java.lang.Long ID;

    private java.lang.String IDPrefix;

    private java.lang.String IDSuffix;

    private java.lang.String name;

    private com.rallydev.webservice.v1_19.domain.Project project;

    private java.lang.Long subjectOID;

    private com.rallydev.webservice.v1_19.domain.User user;

    public ArtifactNotification() {
    }

    public ArtifactNotification(
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
           java.lang.String className,
           java.lang.String description,
           java.lang.Long ID,
           java.lang.String IDPrefix,
           java.lang.String IDSuffix,
           java.lang.String name,
           com.rallydev.webservice.v1_19.domain.Project project,
           java.lang.Long subjectOID,
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
        this.className = className;
        this.description = description;
        this.ID = ID;
        this.IDPrefix = IDPrefix;
        this.IDSuffix = IDSuffix;
        this.name = name;
        this.project = project;
        this.subjectOID = subjectOID;
        this.user = user;
    }


    /**
     * Gets the className value for this ArtifactNotification.
     * 
     * @return className
     */
    public java.lang.String getClassName() {
        return className;
    }


    /**
     * Sets the className value for this ArtifactNotification.
     * 
     * @param className
     */
    public void setClassName(java.lang.String className) {
        this.className = className;
    }


    /**
     * Gets the description value for this ArtifactNotification.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ArtifactNotification.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the ID value for this ArtifactNotification.
     * 
     * @return ID
     */
    public java.lang.Long getID() {
        return ID;
    }


    /**
     * Sets the ID value for this ArtifactNotification.
     * 
     * @param ID
     */
    public void setID(java.lang.Long ID) {
        this.ID = ID;
    }


    /**
     * Gets the IDPrefix value for this ArtifactNotification.
     * 
     * @return IDPrefix
     */
    public java.lang.String getIDPrefix() {
        return IDPrefix;
    }


    /**
     * Sets the IDPrefix value for this ArtifactNotification.
     * 
     * @param IDPrefix
     */
    public void setIDPrefix(java.lang.String IDPrefix) {
        this.IDPrefix = IDPrefix;
    }


    /**
     * Gets the IDSuffix value for this ArtifactNotification.
     * 
     * @return IDSuffix
     */
    public java.lang.String getIDSuffix() {
        return IDSuffix;
    }


    /**
     * Sets the IDSuffix value for this ArtifactNotification.
     * 
     * @param IDSuffix
     */
    public void setIDSuffix(java.lang.String IDSuffix) {
        this.IDSuffix = IDSuffix;
    }


    /**
     * Gets the name value for this ArtifactNotification.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ArtifactNotification.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the project value for this ArtifactNotification.
     * 
     * @return project
     */
    public com.rallydev.webservice.v1_19.domain.Project getProject() {
        return project;
    }


    /**
     * Sets the project value for this ArtifactNotification.
     * 
     * @param project
     */
    public void setProject(com.rallydev.webservice.v1_19.domain.Project project) {
        this.project = project;
    }


    /**
     * Gets the subjectOID value for this ArtifactNotification.
     * 
     * @return subjectOID
     */
    public java.lang.Long getSubjectOID() {
        return subjectOID;
    }


    /**
     * Sets the subjectOID value for this ArtifactNotification.
     * 
     * @param subjectOID
     */
    public void setSubjectOID(java.lang.Long subjectOID) {
        this.subjectOID = subjectOID;
    }


    /**
     * Gets the user value for this ArtifactNotification.
     * 
     * @return user
     */
    public com.rallydev.webservice.v1_19.domain.User getUser() {
        return user;
    }


    /**
     * Sets the user value for this ArtifactNotification.
     * 
     * @param user
     */
    public void setUser(com.rallydev.webservice.v1_19.domain.User user) {
        this.user = user;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ArtifactNotification)) return false;
        ArtifactNotification other = (ArtifactNotification) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.className==null && other.getClassName()==null) || 
             (this.className!=null &&
              this.className.equals(other.getClassName()))) &&
            ((this.description==null && other.getDescription()==null) || 
             (this.description!=null &&
              this.description.equals(other.getDescription()))) &&
            ((this.ID==null && other.getID()==null) || 
             (this.ID!=null &&
              this.ID.equals(other.getID()))) &&
            ((this.IDPrefix==null && other.getIDPrefix()==null) || 
             (this.IDPrefix!=null &&
              this.IDPrefix.equals(other.getIDPrefix()))) &&
            ((this.IDSuffix==null && other.getIDSuffix()==null) || 
             (this.IDSuffix!=null &&
              this.IDSuffix.equals(other.getIDSuffix()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.project==null && other.getProject()==null) || 
             (this.project!=null &&
              this.project.equals(other.getProject()))) &&
            ((this.subjectOID==null && other.getSubjectOID()==null) || 
             (this.subjectOID!=null &&
              this.subjectOID.equals(other.getSubjectOID()))) &&
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
        if (getClassName() != null) {
            _hashCode += getClassName().hashCode();
        }
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        if (getID() != null) {
            _hashCode += getID().hashCode();
        }
        if (getIDPrefix() != null) {
            _hashCode += getIDPrefix().hashCode();
        }
        if (getIDSuffix() != null) {
            _hashCode += getIDSuffix().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getProject() != null) {
            _hashCode += getProject().hashCode();
        }
        if (getSubjectOID() != null) {
            _hashCode += getSubjectOID().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ArtifactNotification.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "ArtifactNotification"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("className");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ClassName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDPrefix");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IDPrefix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IDSuffix");
        elemField.setXmlName(new javax.xml.namespace.QName("", "IDSuffix"));
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
        elemField.setFieldName("project");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Project"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_19/domain", "Project"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subjectOID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SubjectOID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
