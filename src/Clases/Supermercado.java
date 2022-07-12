package Clases;

import java.util.ArrayList;

import Excepciones.MuchasTarjetasException;
import Generica.Fila_Espera;
import Json.Controladora;
import Generica.*;

public class Supermercado {

	private ArrayList<Fila_Espera<Cliente>> cajas;	// Si no entendi mal, ArrayList de cajas que dentro contiene la fila de clientes (clase generica)

	public Supermercado() {
		cajas = new ArrayList<Fila_Espera<Cliente>>();
		inicializoTresCajas();
	}

	// metodos
	
	public void inicializoTresCajas() {		// Puse un limite de cajas, tambien se lo podria enviar por parametro

		for (int i = 0; i < 3; i++) {
			cajas.add(new Fila_Espera<Cliente>());
		}
	}

	public void agregarClienteFilaEspera(Cliente cliente) {		// Lo que hace es recorrer las cajas, y si una fila tiene mas de 3 tarjetas con problemas
																// lanzo una excepcion
		for (int i = 0; i < cajas.size(); i++) {

			try {

				if (tarjetasPorCaja(cajas.get(i)) > 3) {

					throw new MuchasTarjetasException("Hay mas de 3 tarjetas con problemas");

				}
				else if(cajas.get(i).cantidad() < 5 && calculaTiempoEsperaCaja(cajas.get(i)) < 300) {	// Aca intente contemplar el equilibrio que habia que hacer

					cajas.get(i).agregar(cliente);		// si la cantidad de gente que hay en caja es menor de 5 y el tiempo de espera por cada cliente dentro de la fila es menor a 300 
				}										// lo agrego, sino se fija en la proxima caja

			}
			catch (MuchasTarjetasException e) {
				System.out.println(e.getMessage());
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	public int tarjetasPorCaja(Fila_Espera caja) {	// Calcula cuantas tarjetas con problemas hay en cada caja

		int totalTarjetas = 0;

		for (int i = 0; i < caja.cantidad(); i++) {

			if (caja.recuperar(i).getTipoDePago() == 50) {
				totalTarjetas++;
			}
		}

		return totalTarjetas;
	}

	public int calculaTiempoEsperaCaja(Fila_Espera caja) {	// Calcula el tiempo de espera de todos los clientes en cada caja

		int total = 0;

		for (int i = 0; i < caja.cantidad(); i++) {
			total += caja.recuperar(i).getCantArticulos() * 30 * caja.recuperar(i).getTipo() + caja.recuperar(i).getTipoDePago();
		}

		return total;
	}

	public String atender() {	// En un stringBuilder paso los tiempos de espera de cada caja, y saco los clientes de las filas

		int a = 0;

		StringBuilder datosDeCaja = new StringBuilder();

		for (Fila_Espera fila : cajas) {

			int tiempo = 0;

			for (int i = 0; i < fila.cantidad(); i++) {

				tiempo += calculaTiempoEsperaCaja(fila);
				fila.sacar();
			}

			datosDeCaja.append("Caja " + a + " Tiempo " + tiempo + " ");

			a++;
		}

		return datosDeCaja.toString();
	}

	public void pasaDatosAJson() {		// Llamo a la clase controladora que es donde hago la escritura del json
		Controladora.escrituraJson(cajas);
	}
	
}
