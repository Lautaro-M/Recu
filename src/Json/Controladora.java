package Json;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Clases.Cliente;
import Generica.Fila_Espera;

public class Controladora {

	public static void escrituraJson(ArrayList<Fila_Espera<Cliente>> cajas) {

		JSONArray primero = new JSONArray();	// array para contener el objetos
		
		// general es el objeto que contiene los tipos de cliente
		
		JSONObject general = new JSONObject();
		
		// Hice un jsonArray para los distintos tipos de cliente
		
		JSONArray comun = new JSONArray();	
		JSONArray jubilado = new JSONArray();
		JSONArray embarazada = new JSONArray();

		try {

			for (Fila_Espera fila : cajas) {

				for (int i = 0; i < fila.cantidad(); i++) {

					JSONObject obj = new JSONObject();
					
					if(fila.recuperar(i).getTipo() == 10) {		// Segun el tipo de cliente

						obj.put("Tipo de cliente", fila.recuperar(i).getTipo());
						obj.put("Tipo de pago", fila.recuperar(i).getTipoDePago());
						obj.put("Cantidad de articulos", fila.recuperar(i).getCantArticulos());						
					
						comun.put(obj);
					}
					else if(fila.recuperar(i).getTipo() == 25) {
						
						obj.put("Tipo de cliente", fila.recuperar(i).getTipo());
						obj.put("Tipo de pago", fila.recuperar(i).getTipoDePago());
						obj.put("Cantidad de articulos", fila.recuperar(i).getCantArticulos());
					
						jubilado.put(obj);
					}
					else {
						
						obj.put("Tipo de cliente", fila.recuperar(i).getTipo());
						obj.put("Tipo de pago", fila.recuperar(i).getTipoDePago());
						obj.put("Cantidad de articulos", fila.recuperar(i).getCantArticulos());
					
						embarazada.put(obj);
					}
				}			
			}
			
			general.put("Cliente comun", comun);
			general.put("Cliente jubilado", jubilado);
			general.put("Cliente embarazada", embarazada);
		
			primero.put(general);
			
			JsonUtiles.grabar(primero);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

}
