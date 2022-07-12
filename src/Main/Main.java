package Main;

import Clases.*;
import Json.*;

public class Main {

	public static void main(String[] args) {
		
		Supermercado supermercado = new Supermercado();		// inicializo el supermercado
		
		// carga de datos
		
		supermercado.agregarClienteFilaEspera(new Comun(15));	// 10, 15, 50
		supermercado.agregarClienteFilaEspera(new Embarazada(15));	
		supermercado.agregarClienteFilaEspera(new Jubilado(50));	
		supermercado.agregarClienteFilaEspera(new Jubilado(50));	
		supermercado.agregarClienteFilaEspera(new Embarazada(10));	
		supermercado.agregarClienteFilaEspera(new Comun(15));	
		supermercado.agregarClienteFilaEspera(new Comun(50));	
		supermercado.agregarClienteFilaEspera(new Comun(50));	
		supermercado.agregarClienteFilaEspera(new Jubilado(50));	
		supermercado.agregarClienteFilaEspera(new Embarazada(150));	
		supermercado.agregarClienteFilaEspera(new Embarazada(10));	
		supermercado.agregarClienteFilaEspera(new Comun(15));	
		
		supermercado.pasaDatosAJson();	// Exporto el json
		
		System.out.println(supermercado.atender());	// pruebo el metodo atender
		
		
		
	}

}
