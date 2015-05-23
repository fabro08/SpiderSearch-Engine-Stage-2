package Estructuras;

import Parseo.Peso;
import Parseo.Separar;
import Parseo.TikaParser;
import Parseo.XMLParser;


public class Main {

	public static void main(String[] args) {
		ArbolAVL arbolito = new ArbolAVL();
		arbolito.insertar("Hola", 10);
		arbolito.insertar("como", 7);
		arbolito.insertar("estas", 15);
		arbolito.insertar("soy", 6);
		arbolito.insertar("Arturo", 8);
		
		//ComparaString compa = new ComparaString("Hóla", "hola");
		
		boolean busqueda = arbolito.buscar("ArtUrO", arbolito.obtenerRaiz());
		System.out.println(busqueda);
		
	
	}

}
