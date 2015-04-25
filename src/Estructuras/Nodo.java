package Estructuras;

public class Nodo {
	int dato;
	Nodo nodoDer = null;
	Nodo nodoIzq = null;


	public Nodo (int dato){

		this.dato = dato;
		
	}
	
	public void setnodoIzq(Nodo nodo){
		nodoIzq = nodo;
		
	}
	public void setnodoDer(Nodo nodo){
		nodoDer = nodo;
		
	}
	public Nodo getnodoIzq(){
		return nodoIzq;
	}
	
	public Nodo getnodoDer(){
		return nodoDer;
	}
	public int getDato(){
		return dato;
	}
	
	public boolean isComplete(){
		if(nodoDer != null & nodoIzq != null)
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	

}
