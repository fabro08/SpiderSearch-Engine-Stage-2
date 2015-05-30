package Estructuras;

public class NodoHeap {
	int peso, posicion;
	String direccion;
	NodoHeap siguiente, anterior;
	
	public NodoHeap(int peso, String direccion) {
		
		this.peso = peso;
		this.direccion = direccion;
		this.siguiente = this.anterior  = null;				
	}

}
