/**
 * 
 */
package Estructuras;

/**
 * @author arturo
 *
 */
public class ArbolAVL {
	private NodoArbolAVL raiz;
	
	public ArbolAVL(){
		raiz = null;
	}
	//Obtener raiz
	public NodoArbolAVL obtenerRaiz(){
		return raiz;
	}
	
	//Buscar
	public NodoArbolAVL buscar(String d, NodoArbolAVL r){ 
		if (Esta(d, r) == true) {
			if(r.palabra.dato == d) {
				System.out.println(r.palabra.dato);			}
			else {
				buscar(d, r.hijoIzquierdo);
				buscar(d, r.hijoDerecho);
			}
		}else {
			System.out.println("Nodo no encontrado");
		}
		return r;
	}
	public boolean Esta(String d, NodoArbolAVL r) {
		boolean esta = false;
		if(raiz != null) {
			
			if(r.palabra.dato == d) {
				esta = true;
			}
			else {
				Esta(d, r.hijoIzquierdo);
				Esta(d, r.hijoDerecho);
			}
		}
		return esta;
			
		
	
	}
	//Obtener Factor de Equilibrio
	public int obtenerFE(NodoArbolAVL x){
		if(x == null)
			return -1;
		else
			return x.fe;
	}
	
	//Rotacion Simple Izquierda
	public NodoArbolAVL rotacionIzquierda(NodoArbolAVL c){
		NodoArbolAVL auxiliar = c.hijoIzquierdo;
		c.hijoIzquierdo = auxiliar.hijoDerecho;
		auxiliar.hijoDerecho = c;
		c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
		auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
		return auxiliar;
	}
	
	//Rotacion Simple Derecha
	public NodoArbolAVL rotacionDerecha(NodoArbolAVL c){
		NodoArbolAVL auxiliar = c.hijoDerecho;
		c.hijoDerecho = auxiliar.hijoIzquierdo;
		auxiliar.hijoIzquierdo = c;
		c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
		auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
		return auxiliar;
	}
	
	//Rotacion Doble a la Izquierda
	public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL c){
		NodoArbolAVL temporal;
		c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
		temporal = rotacionIzquierda(c);
		return temporal;
	}	
	
	//Rotacion Doble a la Derecha
	public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL c){
		NodoArbolAVL temporal;
		c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
		temporal = rotacionDerecha(c);
		return temporal;	
	}
	
	//Metodo para insertar AVL (De forma balanceada)
	public NodoArbolAVL insertarAVL(NodoArbolAVL nuevo, NodoArbolAVL subAr){
		NodoArbolAVL nuevoPadre = subAr;
		if(nuevo.palabra.cantidad < subAr.palabra.cantidad){
			if(subAr.hijoIzquierdo == null)
				subAr.hijoIzquierdo = nuevo;
			else{
				subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
				if((obtenerFE(subAr.hijoIzquierdo) - obtenerFE(subAr.hijoDerecho) == 2)){
					if(nuevo.palabra.cantidad < subAr.hijoIzquierdo.palabra.cantidad)
						nuevoPadre = rotacionIzquierda(subAr);
					else
						nuevoPadre = rotacionDobleIzquierda(subAr);
				}
			}
		}
		else if(nuevo.palabra.cantidad > subAr.palabra.cantidad){
			if(subAr.hijoDerecho == null)
				subAr.hijoDerecho = nuevo;
			else{
				subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
				if((obtenerFE(subAr.hijoDerecho) - obtenerFE(subAr.hijoIzquierdo) == 2)){
					if(nuevo.palabra.cantidad > subAr.hijoDerecho.palabra.cantidad)
						nuevoPadre = rotacionDerecha(subAr);
					else
						nuevoPadre = rotacionDobleDerecha(subAr);
				}
			}
		}
		else{
			System.out.println("Nodo Duplicado");
		}
		//Actualizando el FE
		if((subAr.hijoIzquierdo == null) && (subAr.hijoDerecho != null))
			subAr.fe = subAr.hijoDerecho.fe + 1;
		else if((subAr.hijoDerecho == null) && (subAr.hijoIzquierdo != null))
			subAr.fe = subAr.hijoIzquierdo.fe + 1;
		else
			subAr.fe = Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho))+1;
		return nuevoPadre;
	}
	//Metodo para Insertar
	public void insertar(String palabra, int cantidad){
		Palabra nueva = new Palabra(palabra, cantidad);
		NodoArbolAVL nuevo = new NodoArbolAVL(nueva);
		if(raiz == null)
			raiz = nuevo;
		else
			raiz = insertarAVL(nuevo, raiz);
	}
	//Recorridos
	//Metodo para recorrer el Arbol InOrden
	public void inOrden(NodoArbolAVL r){
		if (r != null){
			inOrden(r.hijoIzquierdo);
			System.out.print(r.palabra.dato+ ", ");
			inOrden(r.hijoDerecho);
		}
	}
	
	//Metodo para recorrer el Arbol PreOrden
	public void preOrden(NodoArbolAVL r){
		if (r != null){
			System.out.print(r.palabra.dato + ", ");
			preOrden(r.hijoIzquierdo);
			preOrden(r.hijoDerecho);
		}
	}
	
	//Metodo para recorrer el Arbol PostOrden
	public void postOrden(NodoArbolAVL r){
		if (r != null){
			postOrden(r.hijoIzquierdo);
			postOrden(r.hijoDerecho);
			System.out.print(r.palabra.dato + ", ");
		}
	}
	
	//Metodo para eliminar un nodo
	public boolean eliminar(String d){
		NodoArbolAVL auxiliar = raiz;
		NodoArbolAVL padre = raiz;
		boolean esHijoizq = true;
		while(auxiliar.palabra.dato != d){
			padre = auxiliar;
			if(d < auxiliar.dato){
				esHijoizq = true;
				auxiliar = auxiliar.hijoIzquierdo;
			}else{
				esHijoizq = false;
				auxiliar = auxiliar.hijoDerecho;
			}
			if(auxiliar == null){
				return false;
			}
		}//Fin del while
		if(auxiliar.hijoIzquierdo == null && auxiliar.hijoDerecho == null) {
			if(auxiliar == raiz)
				raiz = null;
			else if (esHijoizq)
				padre.hijoIzquierdo = null;
			else
				padre.hijoDerecho = null;
		}else if (auxiliar.hijoDerecho == null) {
			if(auxiliar == raiz)
				raiz = auxiliar.hijoIzquierdo;
			else if (esHijoizq)
				padre.hijoIzquierdo = auxiliar.hijoIzquierdo;
			else
				padre.hijoDerecho = auxiliar.hijoIzquierdo;
		}else if (auxiliar.hijoIzquierdo == null) {
			if(auxiliar == raiz)
				raiz = auxiliar.hijoDerecho;
			else if (esHijoizq)
				padre.hijoIzquierdo = auxiliar.hijoDerecho;
			else
				padre.hijoDerecho = auxiliar.hijoIzquierdo;
		}else {
			NodoArbolAVL reemplazo = obtenerNodoReemplazo(auxiliar);
			if(auxiliar == raiz)
				raiz = reemplazo;
			else if (esHijoizq) 	
				padre.hijoIzquierdo = reemplazo;
			else
				padre.hijoDerecho = reemplazo;
			
			reemplazo.hijoIzquierdo = auxiliar.hijoIzquierdo;	
		}
		return true;
	}
	//Metodo encargado de devolvernos el nodo reemplazo
	public NodoArbolAVL obtenerNodoReemplazo(NodoArbolAVL nodoReemp) {
		NodoArbolAVL reemplazarPadre = nodoReemp;
		NodoArbolAVL reemplazo = nodoReemp;
		NodoArbolAVL auxiliar = nodoReemp.hijoDerecho;
		while (auxiliar != null) {
			reemplazarPadre = reemplazo;
			reemplazo = auxiliar;
			auxiliar = auxiliar.hijoIzquierdo;		
		}
		if(reemplazo != nodoReemp.hijoDerecho) {
			reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
			reemplazo.hijoDerecho = nodoReemp.hijoDerecho;
		}
		return reemplazo;
	}
}
