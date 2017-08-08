package cl.cntv.tvdigital.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

import cl.cntv.tvdigital.Utils.OracleDBUtils;

public class Comunas {

	public static JSONObject getListadoComunas() {
		JSONObject comunas = new JSONObject();
		JSONObject comunas_region = new JSONObject();
		String query_comunas = "SELECT c.COD_COMUNA, CAST (c.REG_COD_REGION AS INT) AS reg, c.COMUNA FROM COMUNA c,"
				+ " VIEW_STI_DPA3_COMUNAS vc where c.cod_comuna = vc.COD_COMUNA GROUP BY c.COD_COMUNA, c.REG_COD_REGION, "
				+ "c.COMUNA order by reg";
		
		Connection connection = null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			connection = OracleDBUtils.connect();
			stmt = connection.createStatement();
			res = stmt.executeQuery(query_comunas);
			
			int region_idx = 1;
			while(res.next()) {
				int region_actual = res.getInt("reg");
				
				if(region_idx == region_actual) {
					comunas_region.put(res.getString("cod_comuna"), res.getString("comuna"));
				} else {
					comunas.put(String.valueOf(region_idx), comunas_region);

					comunas_region = new JSONObject();
					comunas_region.put(res.getString("cod_comuna"), res.getString("comuna"));
					region_idx = region_actual;
					
				}
			}
			comunas.put(String.valueOf(region_idx), comunas_region);
		} catch (SQLException err) {
			err.printStackTrace();
		}

		return comunas;
	}
}
