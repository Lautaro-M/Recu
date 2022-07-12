package Clases;

import java.util.Random;

public class Cliente {
	
	private int tipoDePago;
	private int cantArticulos;
	private int tipo;
	
	public Cliente() {
		
		tipoDePago = 0;
		cantArticulos = 0;
		tipo = 0;
	}
	
	public Cliente(int tipoDePago, int tipo) {
		this.tipoDePago = tipoDePago;
		cantArticulos = (int) (Math.random() * ( 30 - 1 ));	// Random
		this.tipo = tipo;
	}
	
	public int getTipoDePago() {
		return tipoDePago;
	}
	
	public int getCantArticulos() {
		return cantArticulos;
	}

	public int getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		return "Cliente [tipoDePago=" + tipoDePago + ", cantArticulos=" + cantArticulos + "]";
	}
	
	
	
}
