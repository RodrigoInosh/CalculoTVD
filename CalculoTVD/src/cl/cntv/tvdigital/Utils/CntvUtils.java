package cl.cntv.tvdigital.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import org.json.JSONObject;
import cl.cntv.tvdigital.webservice.Archivo;
import cl.cntv.tvdigital.webservice.ListaArchivos;

public class CntvUtils {

	public static Archivo getArchivo(JSONObject data_json) {
		String descripcion = "";
		String nombre = "";
		String checksum = "";
		String base64 = "";
		System.out.println("Descripcion");
		System.out.println(data_json.get("descripcion"));
		descripcion = data_json.get("descripcion").toString();
		nombre = data_json.getString("nombre");
		checksum = data_json.getString("checksum");
		base64 = data_json.getString("binario");
		byte[] b = base64.getBytes(StandardCharsets.UTF_8);

		Archivo archivo_datos = new Archivo(descripcion, nombre, checksum, b);
		return archivo_datos;
	}

	public static ListaArchivos getListaArchivos(JSONObject json_kml, JSONObject json_pdf) {

		Archivo kml_archivo = getArchivo(json_kml);
		Archivo pdf_archivo = getArchivo(json_pdf);
		ListaArchivos lista_archivos = new ListaArchivos(pdf_archivo, kml_archivo);
		getFile(json_pdf.getString("binario"));
		return lista_archivos;
	}
	
	public static String decodedChecksum(String base, String enconde_type) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance(enconde_type);
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	
	public static FileOutputStream getFile(String base64) {
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] decodedBytes;
		FileOutputStream fop = null;
		try {
			decodedBytes = decoder.decodeBuffer(base64);
			File file = new File("newfile.pdf");;
			fop = new FileOutputStream(file);

			fop.write(decodedBytes);
			fop.flush();
			fop.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fop;
	}
}
