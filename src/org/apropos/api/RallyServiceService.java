/**
 * RallyServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.apropos.api;

public interface RallyServiceService extends javax.xml.rpc.Service {
    public java.lang.String getRallyServiceAddress();

    public org.apropos.api.RallyService_PortType getRallyService() throws javax.xml.rpc.ServiceException;

    public org.apropos.api.RallyService_PortType getRallyService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
