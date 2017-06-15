/**
 * CntvServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.cntv.tvdigital.webservice;

public class CntvServiceLocator extends org.apache.axis.client.Service implements cl.cntv.tvdigital.webservice.CntvService {

    public CntvServiceLocator() {
    }


    public CntvServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CntvServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for cntvServicePort
    private java.lang.String cntvServicePort_address = "http://tvdigital.cntv.cl/index.php/webservice";

    public java.lang.String getcntvServicePortAddress() {
        return cntvServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String cntvServicePortWSDDServiceName = "cntvServicePort";

    public java.lang.String getcntvServicePortWSDDServiceName() {
        return cntvServicePortWSDDServiceName;
    }

    public void setcntvServicePortWSDDServiceName(java.lang.String name) {
        cntvServicePortWSDDServiceName = name;
    }

    public cl.cntv.tvdigital.webservice.CntvServicePortType getcntvServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(cntvServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getcntvServicePort(endpoint);
    }

    public cl.cntv.tvdigital.webservice.CntvServicePortType getcntvServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cl.cntv.tvdigital.webservice.CntvServiceBindingStub _stub = new cl.cntv.tvdigital.webservice.CntvServiceBindingStub(portAddress, this);
            _stub.setPortName(getcntvServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setcntvServicePortEndpointAddress(java.lang.String address) {
        cntvServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cl.cntv.tvdigital.webservice.CntvServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cl.cntv.tvdigital.webservice.CntvServiceBindingStub _stub = new cl.cntv.tvdigital.webservice.CntvServiceBindingStub(new java.net.URL(cntvServicePort_address), this);
                _stub.setPortName(getcntvServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("cntvServicePort".equals(inputPortName)) {
            return getcntvServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tvdigital.cntv.cl/webservice/", "cntvService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tvdigital.cntv.cl/webservice/", "cntvServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("cntvServicePort".equals(portName)) {
            setcntvServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
