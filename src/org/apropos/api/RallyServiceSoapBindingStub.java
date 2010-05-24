/**
 * RallyServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.apropos.api;

public class RallyServiceSoapBindingStub extends org.apache.axis.client.Stub implements org.apropos.api.RallyService_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[9];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("create");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "artifact"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "PersistableObject"), org.apropos.api.PersistableObject.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "CreateResult"));
        oper.setReturnClass(org.apropos.api.CreateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "createReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("update");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "artifact"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "PersistableObject"), org.apropos.api.PersistableObject.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "OperationResult"));
        oper.setReturnClass(org.apropos.api.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "updateReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("read");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "reference"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "PersistableObject"), org.apropos.api.PersistableObject.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "WSObject"));
        oper.setReturnClass(org.apropos.api.WSObject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "readOriginalReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("read");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "reference"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "PersistableObject"), org.apropos.api.PersistableObject.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "workspace"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Workspace"), org.apropos.api.Workspace.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "WSObject"));
        oper.setReturnClass(org.apropos.api.WSObject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "readWorkspaceScopedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "workspace"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Workspace"), org.apropos.api.Workspace.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "artifactType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "query"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "order"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fetch"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "start"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pagesize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "QueryResult"));
        oper.setReturnClass(org.apropos.api.QueryResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryOriginalReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "workspace"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Workspace"), org.apropos.api.Workspace.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "project"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Project"), org.apropos.api.Project.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectScopeUp"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "projectScopeDown"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "artifactType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "query"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "order"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "fetch"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "start"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "pagesize"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "QueryResult"));
        oper.setReturnClass(org.apropos.api.QueryResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "queryProjectScopedReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("delete");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "reference"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "PersistableObject"), org.apropos.api.PersistableObject.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "OperationResult"));
        oper.setReturnClass(org.apropos.api.OperationResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "deleteReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCurrentSubscription");
        oper.setReturnType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "WSObject"));
        oper.setReturnClass(org.apropos.api.WSObject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getCurrentSubscriptionReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCurrentUser");
        oper.setReturnType(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "WSObject"));
        oper.setReturnClass(org.apropos.api.WSObject.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "getCurrentUserReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

    }

    public RallyServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public RallyServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public RallyServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.1");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "AllowedAttributeValue");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.AllowedAttributeValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "AllowedQueryOperator");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.AllowedQueryOperator.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Artifact");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Artifact.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ArtifactDiscussionType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.ConversationPost[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ConversationPost");
            qName2 = new javax.xml.namespace.QName("", "ConversationPost");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ArtifactTagsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Tag[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Tag");
            qName2 = new javax.xml.namespace.QName("", "Tag");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Attachment");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Attachment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "AttachmentContent");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.AttachmentContent.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "AttributeDefinition");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.AttributeDefinition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "AttributeDefinitionAllowedQueryOperatorsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.AllowedQueryOperator[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "AllowedQueryOperator");
            qName2 = new javax.xml.namespace.QName("", "AllowedQueryOperator");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "AttributeDefinitionAllowedValuesType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.AllowedAttributeValue[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "AllowedAttributeValue");
            qName2 = new javax.xml.namespace.QName("", "AllowedAttributeValue");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Blocker");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Blocker.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Build");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Build.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "BuildDefinition");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.BuildDefinition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "BuildDefinitionBuildsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Build[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Build");
            qName2 = new javax.xml.namespace.QName("", "Build");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "BuildMetric");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.BuildMetric.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "BuildMetricDefinition");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.BuildMetricDefinition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ConversationPost");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.ConversationPost.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "CreateResult");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.CreateResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "CumulativeFlowData");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.CumulativeFlowData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Defect");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Defect.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "DefectAttachmentsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Attachment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Attachment");
            qName2 = new javax.xml.namespace.QName("", "Attachment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "DefectDuplicatesType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Defect[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Defect");
            qName2 = new javax.xml.namespace.QName("", "Defect");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "DefectSuite");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.DefectSuite.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "DefectSuiteAttachmentsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Attachment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Attachment");
            qName2 = new javax.xml.namespace.QName("", "Attachment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "DefectSuiteDefectsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Defect[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Defect");
            qName2 = new javax.xml.namespace.QName("", "Defect");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "DefectSuiteTasksType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Task[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Task");
            qName2 = new javax.xml.namespace.QName("", "Task");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "DefectTasksType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Task[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Task");
            qName2 = new javax.xml.namespace.QName("", "Task");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "DomainObject");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.DomainObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirement");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.HierarchicalRequirement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirementChildrenType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.HierarchicalRequirement[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirement");
            qName2 = new javax.xml.namespace.QName("", "HierarchicalRequirement");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirementDefectsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Defect[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Defect");
            qName2 = new javax.xml.namespace.QName("", "Defect");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirementPredecessorsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.HierarchicalRequirement[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirement");
            qName2 = new javax.xml.namespace.QName("", "HierarchicalRequirement");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirementSuccessorsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.HierarchicalRequirement[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirement");
            qName2 = new javax.xml.namespace.QName("", "HierarchicalRequirement");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirementTasksType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Task[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Task");
            qName2 = new javax.xml.namespace.QName("", "Task");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "HierarchicalRequirementTestCasesType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TestCase[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCase");
            qName2 = new javax.xml.namespace.QName("", "TestCase");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Iteration");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Iteration.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "IterationCumulativeFlowData");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.IterationCumulativeFlowData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "IterationUserIterationCapacitiesType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.UserIterationCapacity[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "UserIterationCapacity");
            qName2 = new javax.xml.namespace.QName("", "UserIterationCapacity");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "OperationResult");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.OperationResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "OperationResultErrorsType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "OperationResultError");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "OperationResultWarningsType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "OperationResultWarning");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "PersistableObject");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.PersistableObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Program");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Program.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ProgramReleasesType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Release[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Release");
            qName2 = new javax.xml.namespace.QName("", "Release");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Project");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Project.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ProjectBuildDefinitionsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.BuildDefinition[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "BuildDefinition");
            qName2 = new javax.xml.namespace.QName("", "BuildDefinition");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ProjectChildrenType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Project[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Project");
            qName2 = new javax.xml.namespace.QName("", "Project");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ProjectIterationsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Iteration[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Iteration");
            qName2 = new javax.xml.namespace.QName("", "Iteration");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ProjectPermission");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.ProjectPermission.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ProjectReleasesType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Release[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Release");
            qName2 = new javax.xml.namespace.QName("", "Release");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ProjectUsersType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.User[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "User");
            qName2 = new javax.xml.namespace.QName("", "User");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "QueryResult");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.QueryResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "QueryResultResultsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.DomainObject[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "DomainObject");
            qName2 = new javax.xml.namespace.QName("", "Object");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Release");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Release.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "ReleaseCumulativeFlowData");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.ReleaseCumulativeFlowData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Requirement");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Requirement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "RequirementAttachmentsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Attachment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Attachment");
            qName2 = new javax.xml.namespace.QName("", "Attachment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Revision");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Revision.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "RevisionHistory");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.RevisionHistory.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "RevisionHistoryRevisionsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Revision[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Revision");
            qName2 = new javax.xml.namespace.QName("", "Revision");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Subscription");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Subscription.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "SubscriptionWorkspacesType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Workspace[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Workspace");
            qName2 = new javax.xml.namespace.QName("", "Workspace");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Tag");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Tag.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Task");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Task.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TaskAttachmentsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Attachment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Attachment");
            qName2 = new javax.xml.namespace.QName("", "Attachment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCase");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TestCase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCaseAttachmentsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Attachment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Attachment");
            qName2 = new javax.xml.namespace.QName("", "Attachment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCaseResult");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TestCaseResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCaseResultAttachmentsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Attachment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Attachment");
            qName2 = new javax.xml.namespace.QName("", "Attachment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCaseResultsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TestCaseResult[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCaseResult");
            qName2 = new javax.xml.namespace.QName("", "TestCaseResult");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCaseStep");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TestCaseStep.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCaseStepsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TestCaseStep[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCaseStep");
            qName2 = new javax.xml.namespace.QName("", "TestCaseStep");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestFolder");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TestFolder.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestFolderChildrenType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TestFolder[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestFolder");
            qName2 = new javax.xml.namespace.QName("", "TestFolder");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestFolderTestCasesType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TestCase[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCase");
            qName2 = new javax.xml.namespace.QName("", "TestCase");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestSet");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TestSet.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestSetTestCasesType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TestCase[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TestCase");
            qName2 = new javax.xml.namespace.QName("", "TestCase");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TimeEntryItem");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TimeEntryItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TimeEntryItemValuesType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TimeEntryValue[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TimeEntryValue");
            qName2 = new javax.xml.namespace.QName("", "TimeEntryValue");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TimeEntryValue");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TimeEntryValue.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TypeDefinition");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TypeDefinition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TypeDefinitionAttributesType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.AttributeDefinition[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "AttributeDefinition");
            qName2 = new javax.xml.namespace.QName("", "AttributeDefinition");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "User");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.User.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "UserIterationCapacity");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.UserIterationCapacity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "UserPermission");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.UserPermission.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "UserProfile");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.UserProfile.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "UserProjectsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Project[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Project");
            qName2 = new javax.xml.namespace.QName("", "Project");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "UserUserPermissionsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.UserPermission[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "UserPermission");
            qName2 = new javax.xml.namespace.QName("", "UserPermission");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "WebLinkDefinition");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.WebLinkDefinition.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Workspace");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Workspace.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "WorkspaceConfiguration");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.WorkspaceConfiguration.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "WorkspaceDomainObject");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.WorkspaceDomainObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "WorkspacePermission");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.WorkspacePermission.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "WorkspaceProjectsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.Project[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "Project");
            qName2 = new javax.xml.namespace.QName("", "Project");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "WorkspaceTypeDefinitionsType");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.TypeDefinition[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "TypeDefinition");
            qName2 = new javax.xml.namespace.QName("", "TypeDefinition");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/domain", "WSObject");
            cachedSerQNames.add(qName);
            cls = org.apropos.api.WSObject.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public org.apropos.api.CreateResult create(org.apropos.api.PersistableObject artifact) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/service", "create"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {artifact});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.apropos.api.CreateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.apropos.api.CreateResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.apropos.api.CreateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.apropos.api.OperationResult update(org.apropos.api.PersistableObject artifact) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/service", "update"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {artifact});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.apropos.api.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.apropos.api.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.apropos.api.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.apropos.api.WSObject read(org.apropos.api.PersistableObject reference) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/service", "read"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {reference});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.apropos.api.WSObject) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.apropos.api.WSObject) org.apache.axis.utils.JavaUtils.convert(_resp, org.apropos.api.WSObject.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.apropos.api.WSObject read(org.apropos.api.PersistableObject reference, org.apropos.api.Workspace workspace) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/service", "read"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {reference, workspace});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.apropos.api.WSObject) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.apropos.api.WSObject) org.apache.axis.utils.JavaUtils.convert(_resp, org.apropos.api.WSObject.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.apropos.api.QueryResult query(org.apropos.api.Workspace workspace, java.lang.String artifactType, java.lang.String query, java.lang.String order, boolean fetch, long start, long pagesize) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/service", "query"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {workspace, artifactType, query, order, new java.lang.Boolean(fetch), new java.lang.Long(start), new java.lang.Long(pagesize)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.apropos.api.QueryResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.apropos.api.QueryResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.apropos.api.QueryResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.apropos.api.QueryResult query(org.apropos.api.Workspace workspace, org.apropos.api.Project project, boolean projectScopeUp, boolean projectScopeDown, java.lang.String artifactType, java.lang.String query, java.lang.String order, boolean fetch, long start, long pagesize) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/service", "query"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {workspace, project, new java.lang.Boolean(projectScopeUp), new java.lang.Boolean(projectScopeDown), artifactType, query, order, new java.lang.Boolean(fetch), new java.lang.Long(start), new java.lang.Long(pagesize)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.apropos.api.QueryResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.apropos.api.QueryResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.apropos.api.QueryResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.apropos.api.OperationResult delete(org.apropos.api.PersistableObject reference) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/service", "delete"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {reference});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.apropos.api.OperationResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.apropos.api.OperationResult) org.apache.axis.utils.JavaUtils.convert(_resp, org.apropos.api.OperationResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.apropos.api.WSObject getCurrentSubscription() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/service", "getCurrentSubscription"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.apropos.api.WSObject) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.apropos.api.WSObject) org.apache.axis.utils.JavaUtils.convert(_resp, org.apropos.api.WSObject.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public org.apropos.api.WSObject getCurrentUser() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://rallydev.com/webservice/v1_15/service", "getCurrentUser"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.apropos.api.WSObject) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.apropos.api.WSObject) org.apache.axis.utils.JavaUtils.convert(_resp, org.apropos.api.WSObject.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
