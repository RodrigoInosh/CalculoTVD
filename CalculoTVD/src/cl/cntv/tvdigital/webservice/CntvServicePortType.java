/**
 * CntvServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.cntv.tvdigital.webservice;

public interface CntvServicePortType extends java.rmi.Remote {

    /**
     * Obtener los documentos tecnicos de la Subtel
     */
    public void obtener_documentos_tecnicos(int usuario_id, java.lang.String codigo_postulacion, cl.cntv.tvdigital.webservice.ListaArchivos lista_archivos, javax.xml.rpc.holders.IntHolder codigo, javax.xml.rpc.holders.StringHolder descripcion) throws java.rmi.RemoteException;

    /**
     * Valida una sesiÃ³n
     */
    public java.lang.String valida_token(int usuario_id, int postulacion_id, java.lang.String token) throws java.rmi.RemoteException;
}
