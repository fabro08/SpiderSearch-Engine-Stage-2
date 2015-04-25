package Estructuras;

public class ArbolBinario {
	
	public ArbolBinario(){
		
	}
	Nodo root = null;
	
	public boolean isEmpty(){
		if(root == null)
			return true;
		else
			return false;
	}
	
	public void insertar(int dato){
		if(isEmpty())
			root = new Nodo(dato);
		else{
			if(dato < root.getDato()){
				Nodo temp = new Nodo(dato);
				root.setnodoDer(temp);
			}
			else{
				Nodo temp = new Nodo(dato);
				root.setnodoIzq(temp);
			}
		}
			
			
			
		
	}
}
