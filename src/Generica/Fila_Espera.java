package Generica;

import java.util.LinkedList;

import Clases.*;

public class Fila_Espera <T extends Cliente>{	// Clase generica, con restriccion del tipo Cliente
	
	private LinkedList<T> caja;		// linkedList para hacer la fila
	
	public Fila_Espera() {
		caja = new LinkedList<T>();
	}

	// metodos
	
	public void agregar(T dato) {
		caja.addLast(dato);
	}
	
	public void sacar() {
		caja.removeFirst();
	}
	
	public T recuperar(int pos) {
		return caja.get(pos);
	}

	public int cantidad() {
		return caja.size();
	}
	
	@Override
	public String toString() {
		return "Caja [caja=" + caja + "]";
	}
	
}
