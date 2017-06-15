package cl.cntv.tvdigital.webservice;

public class CntvServicePortTypeProxy implements cl.cntv.tvdigital.webservice.CntvServicePortType {
  private String _endpoint = null;
  private cl.cntv.tvdigital.webservice.CntvServicePortType cntvServicePortType = null;
  
  public CntvServicePortTypeProxy() {
    _initCntvServicePortTypeProxy();
  }
  
  public CntvServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initCntvServicePortTypeProxy();
  }
  
  private void _initCntvServicePortTypeProxy() {
    try {
      cntvServicePortType = (new cl.cntv.tvdigital.webservice.CntvServiceLocator()).getcntvServicePort();
      if (cntvServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cntvServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cntvServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cntvServicePortType != null)
      ((javax.xml.rpc.Stub)cntvServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cl.cntv.tvdigital.webservice.CntvServicePortType getCntvServicePortType() {
    if (cntvServicePortType == null)
      _initCntvServicePortTypeProxy();
    return cntvServicePortType;
  }
  
  public void obtener_documentos_tecnicos(int usuario_id, java.lang.String codigo_postulacion, cl.cntv.tvdigital.webservice.ListaArchivos lista_archivos, javax.xml.rpc.holders.IntHolder codigo, javax.xml.rpc.holders.StringHolder descripcion) throws java.rmi.RemoteException{
    if (cntvServicePortType == null)
      _initCntvServicePortTypeProxy();
    cntvServicePortType.obtener_documentos_tecnicos(usuario_id, codigo_postulacion, lista_archivos, codigo, descripcion);
  }
  
  public java.lang.String valida_token(int usuario_id, int postulacion_id, java.lang.String token) throws java.rmi.RemoteException{
    if (cntvServicePortType == null)
      _initCntvServicePortTypeProxy();
    return cntvServicePortType.valida_token(usuario_id, postulacion_id, token);
  }
  
  
}