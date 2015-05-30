package Estructuras;


import Parseo.Peso;
import Parseo.Separar;
import Parseo.TikaParser;
import Parseo.XMLParser;



public class Main {

	public static void main(String[] args) {
		ArbolHeap nueva = new ArbolHeap();
		nueva.insertar(14, "www.google.com1");
		nueva.insertar(20, "www.google.com2");
		nueva.insertar(18, "www.google.com3");
		nueva.insertar(78, "www.google.com4");
		nueva.insertar(7, "www.google.com5");
		nueva.insertar(16, "www.google.com6");
		nueva.insertar(5154786, "www.google.com7");
	//	nueva.revisaMayores(nueva.cola);	
	//	System.out.println(nueva.cabeza.peso);
	//	System.out.println(nueva.cola.peso);
		nueva.imprimir();
		System.out.println(nueva.obtenerenPos(5).peso);
		
	}

}
