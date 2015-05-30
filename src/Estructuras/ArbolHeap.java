package Estructuras;

public class ArbolHeap {
	NodoHeap cabeza, cola;
	int size;
	
	public ArbolHeap() {
		this.cabeza = this.cola = null;
		this.size = 0;
	}
	
	public boolean estaVacia(){
		return (cabeza == null);
	}
	
	public NodoHeap obtenerenPos(int indice){
		int contador = 1;
		NodoHeap temp = cabeza;
		while (contador <= indice) {
			temp = temp.siguiente;	
			contador++;
		}
		return temp;
	}

	public void imprimir(){
		int contador = 0;
		NodoHeap temp = cabeza;
		while (contador < size){
			System.out.println(temp.peso + " - " + temp.direccion);
			temp = temp.siguiente;
			contador++;		
		}
	}
	
	public void insertar(int peso, String direccion){
		NodoHeap nuevo = new NodoHeap(peso, direccion);
		if (estaVacia()){
			cabeza = nuevo;
			cola = cabeza;
		}else{
			if (cabeza.peso < nuevo.peso){
				nuevo.siguiente = cabeza;
				cabeza.anterior = nuevo;
				cabeza = nuevo;
			}
			else if(cola.peso >= nuevo.peso){
				cola.siguiente = nuevo;
				nuevo.anterior = cola;
				cola = nuevo;			
			}else{
				NodoHeap temp = cabeza;
				while(temp.peso >= nuevo.peso){
					temp = temp.siguiente;
				}
				temp = temp.anterior;
				nuevo.siguiente = temp.siguiente;
				nuevo.siguiente.anterior = nuevo;
				temp.siguiente = nuevo;
				nuevo.anterior = temp;				
			}
		}
		size++;
	}
}
