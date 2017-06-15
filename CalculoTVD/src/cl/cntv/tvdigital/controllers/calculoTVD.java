package cl.cntv.tvdigital.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.IntHolder;
import javax.xml.rpc.holders.StringHolder;
import org.apache.axis.AxisFault;
import org.json.JSONObject;
import cl.cntv.tvdigital.Utils.CntvUtils;
import cl.cntv.tvdigital.webservice.CntvServiceBindingStub;
import cl.cntv.tvdigital.webservice.CntvServiceLocator;
import cl.cntv.tvdigital.webservice.ListaArchivos;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Path("calculoTVD")
public class calculoTVD {

	@GET
	@Path("validate_token")
	@Produces(MediaType.APPLICATION_JSON)
	public static Response validateUser() {
		CntvServiceLocator locator = new CntvServiceLocator();
		CntvServiceBindingStub stub;
		String resp = "";
		try {
			stub = new CntvServiceBindingStub(new URL(locator.getcntvServicePortAddress()), locator);
			resp = stub.valida_token(1, 34643, "token");
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject response = new JSONObject();
		response.put("resp", resp);
		return Response.status(200).entity(response.toString()).build();
	}

	@Path("send_file")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public static String sendFile(@FormParam("usuario_id") int usuario_id,
			@FormParam("codigo_postulacion") String codigo_postulacion, @FormParam("kml") String kml_data,
			@FormParam("pdf") String pdf_data) {

		String resp = "";
		JSONObject json_kml = null, json_pdf = null;

		try {
			json_kml = new JSONObject(kml_data);
			json_pdf = new JSONObject(pdf_data);
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}

		ListaArchivos lista = CntvUtils.getListaArchivos(json_kml, json_pdf);

		IntHolder codigo = new IntHolder();
		StringHolder descripcion = new StringHolder();
		CntvServiceLocator locator = new CntvServiceLocator();
		CntvServiceBindingStub stub;
		try {
			stub = new CntvServiceBindingStub(new URL(locator.getcntvServicePortAddress()), locator);
			stub.obtener_documentos_tecnicos(usuario_id, codigo_postulacion, lista, codigo, descripcion);
			resp = "OK";
		} catch (AxisFault e) {
			e.printStackTrace();
			resp = e.getMessage();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			resp = e.getMessage();
		} catch (RemoteException e) {
			e.printStackTrace();
			resp = e.getMessage();
		}

		return resp;
	}

	@Path("tvdpage")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public static String tvdpage(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@FormParam("token") String token, @FormParam("usuario_id") int usuario_id,
			@FormParam("codigo") int codigo_postulacion) throws IOException {
		CntvServiceLocator locator = new CntvServiceLocator();
		CntvServiceBindingStub stub;
		String resp = "/subtelv2/tvdigital/error_page.jsp";
		System.out.println(token);
		try {
			stub = new CntvServiceBindingStub(new URL(locator.getcntvServicePortAddress()), locator);
			resp = stub.valida_token(usuario_id, codigo_postulacion, token);
		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resp;
	}
}
