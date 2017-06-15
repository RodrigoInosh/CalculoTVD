/**
 * ListaArchivos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.cntv.tvdigital.webservice;

public class ListaArchivos  implements java.io.Serializable {
    private cl.cntv.tvdigital.webservice.Archivo archivo_pdf;

    private cl.cntv.tvdigital.webservice.Archivo archivo_kml;

    public ListaArchivos() {
    }

    public ListaArchivos(
           cl.cntv.tvdigital.webservice.Archivo archivo_pdf,
           cl.cntv.tvdigital.webservice.Archivo archivo_kml) {
           this.archivo_pdf = archivo_pdf;
           this.archivo_kml = archivo_kml;
    }


    /**
     * Gets the archivo_pdf value for this ListaArchivos.
     * 
     * @return archivo_pdf
     */
    public cl.cntv.tvdigital.webservice.Archivo getArchivo_pdf() {
        return archivo_pdf;
    }


    /**
     * Sets the archivo_pdf value for this ListaArchivos.
     * 
     * @param archivo_pdf
     */
    public void setArchivo_pdf(cl.cntv.tvdigital.webservice.Archivo archivo_pdf) {
        this.archivo_pdf = archivo_pdf;
    }


    /**
     * Gets the archivo_kml value for this ListaArchivos.
     * 
     * @return archivo_kml
     */
    public cl.cntv.tvdigital.webservice.Archivo getArchivo_kml() {
        return archivo_kml;
    }


    /**
     * Sets the archivo_kml value for this ListaArchivos.
     * 
     * @param archivo_kml
     */
    public void setArchivo_kml(cl.cntv.tvdigital.webservice.Archivo archivo_kml) {
        this.archivo_kml = archivo_kml;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ListaArchivos)) return false;
        ListaArchivos other = (ListaArchivos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.archivo_pdf==null && other.getArchivo_pdf()==null) || 
             (this.archivo_pdf!=null &&
              this.archivo_pdf.equals(other.getArchivo_pdf()))) &&
            ((this.archivo_kml==null && other.getArchivo_kml()==null) || 
             (this.archivo_kml!=null &&
              this.archivo_kml.equals(other.getArchivo_kml())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getArchivo_pdf() != null) {
            _hashCode += getArchivo_pdf().hashCode();
        }
        if (getArchivo_kml() != null) {
            _hashCode += getArchivo_kml().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ListaArchivos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tvdigital.cntv.cl/webservice/", "listaArchivos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archivo_pdf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "archivo_pdf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tvdigital.cntv.cl/webservice/", "archivo"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("archivo_kml");
        elemField.setXmlName(new javax.xml.namespace.QName("", "archivo_kml"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tvdigital.cntv.cl/webservice/", "archivo"));
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
