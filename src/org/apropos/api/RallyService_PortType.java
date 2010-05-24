/**
 * RallyService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.apropos.api;

public interface RallyService_PortType extends java.rmi.Remote {
    public org.apropos.api.CreateResult create(org.apropos.api.PersistableObject artifact) throws java.rmi.RemoteException;
    public org.apropos.api.OperationResult update(org.apropos.api.PersistableObject artifact) throws java.rmi.RemoteException;
    public org.apropos.api.WSObject read(org.apropos.api.PersistableObject reference) throws java.rmi.RemoteException;
    public org.apropos.api.WSObject read(org.apropos.api.PersistableObject reference, org.apropos.api.Workspace workspace) throws java.rmi.RemoteException;
    public org.apropos.api.QueryResult query(org.apropos.api.Workspace workspace, java.lang.String artifactType, java.lang.String query, java.lang.String order, boolean fetch, long start, long pagesize) throws java.rmi.RemoteException;
    public org.apropos.api.QueryResult query(org.apropos.api.Workspace workspace, org.apropos.api.Project project, boolean projectScopeUp, boolean projectScopeDown, java.lang.String artifactType, java.lang.String query, java.lang.String order, boolean fetch, long start, long pagesize) throws java.rmi.RemoteException;
    public org.apropos.api.OperationResult delete(org.apropos.api.PersistableObject reference) throws java.rmi.RemoteException;
    public org.apropos.api.WSObject getCurrentSubscription() throws java.rmi.RemoteException;
    public org.apropos.api.WSObject getCurrentUser() throws java.rmi.RemoteException;
}
