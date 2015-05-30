/**
 * 
 */
package Estructuras;

import org.apache.poi.util.SystemOutLogger;

import com.coremedia.iso.boxes.StaticChunkOffsetBox;

/**
 * Clase ArbolAVL que crea y controla un arbol de tipo AVL con Nodos
 * @author arturo
 *
 */

public class ArbolAVL {
	//Campos de la clase
	private NodoArbolAVL raiz;
	boolean esta;
	private int tamanio;
	
	/**
	 * Constructor de la clase ArbolAVL
	 */
	public ArbolAVL(){
		esta = false;
		tamanio = 0;
		raiz = null;
	}
	
	/**
	 * Clase que retorna el nodo raíz del arbol
	 * @return - NodoArbolAVL con el nodo raiz del Arbol
	 */
	public NodoArbolAVL obtenerRaiz(){
		return raiz;
	}
	
	/**
	 * Funcion que busca una palabra en los nodos del arbol y devuelve el nodo en cuestión
	 * @param d - palabra a buscar
	 * @param r - raiz del arbol al que se le aplica la busqueda
	 * @return NodoArbol con el nodo buscado
	 */
	public boolean buscar(String d, NodoArbolAVL r){  
		ComparaString comparador = new ComparaString(r.palabra.dato, d);
		while (r != null){
			if(comparador.comparar() == 0) {
				System.out.println(r.palabra.dato);	
				esta = true;
				break;
				
			}
			if (obtenerFE(r.hijoIzquierdo) >= 0) {
				buscar(d, r.hijoIzquierdo);
			}
			if (obtenerFE(r.hijoDerecho) >= 0){
				buscar(d, r.hijoDerecho);
			}
			break;
			
		}
		//System.out.println("Nodo no encontrado");	
		return esta;
	}
	/**
	 * Funcion para Obtener el Factor de Equilibrio
	 * @param x - Nodo al que se le calculara el FE
	 * @return int con el FE
	 */
	public int obtenerFE(NodoArbolAVL x){
		if(x == null)
			return -1;
		else
			return x.fe;
	}
	/**
	 * Funcion que hace la Rotacion Simple Izquierda
	 * @param c - Nodo con conflictos de FE
	 * @return NodoArbolAVL con la raiz del nuevo subarbol
	 */	
	public NodoArbolAVL rotacionIzquierda(NodoArbolAVL c){
		NodoArbolAVL auxiliar = c.hijoIzquierdo;
		c.hijoIzquierdo = auxiliar.hijoDerecho;
		auxiliar.hijoDerecho = c;
		c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
		auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
		return auxiliar;
	}
	/**
	 * Funcion que hace la Rotacion Simple Derecha
	 * @param c - Nodo con conflictos de FE
	 * @return NodoArbolAVL con la raiz del nuevo subarbol
	 */
	public NodoArbolAVL rotacionDerecha(NodoArbolAVL c){
		NodoArbolAVL auxiliar = c.hijoDerecho;
		c.hijoDerecho = auxiliar.hijoIzquierdo;
		auxiliar.hijoIzquierdo = c;
		c.fe = Math.max(obtenerFE(c.hijoIzquierdo), obtenerFE(c.hijoDerecho))+1;
		auxiliar.fe = Math.max(obtenerFE(auxiliar.hijoIzquierdo), obtenerFE(auxiliar.hijoDerecho))+1;
		return auxiliar;
	}
	
	/**
	 * Funcion que hace la Rotacion Doble a la Izquierda
	 * @param c - Nodo con conflictos de FE
	 * @return NodoArbolAVL con la raiz del nuevo subarbol
	 */
	public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL c){
		NodoArbolAVL temporal;
		c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
		temporal = rotacionIzquierda(c);
		return temporal;
	}	
	
	/**
	 * Funcion que hace la Rotacion Doble a la Derecha
	 * @param c - Nodo con conflictos de FE
	 * @return NodoArbolAVL con la raiz del nuevo subarbol
	 */
	public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL c){
		NodoArbolAVL temporal;
		c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
		temporal = rotacionDerecha(c);
		return temporal;	
	}
	/**
	 * Funcion que inserta un nodo de forma valanceada
	 * @param nuevo - nuevo NodoArbolAVL a ser insertado
	 * @param subAr - raiz del arbol, solo en caso de no estar vacio
	 * @return NodoArbolAVL con la raiz del nuevo subarbol donde se hicieron las rotaciones
	 */
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
	/**
	 * Metodo para insertar un nuevo NodoArbolAVL, en el caso de que no este vacio llama a la
	 * funcion insertarAVL
	 * @param palabra - String con la palabra a ser almacenada en el Nodo
	 * @param cantidad - Cantidad de veces que ha aparecido la palabra
	 */
	public void insertar(String palabra, int cantidad){
		tamanio = tamanio+1;
		Palabra nueva = new Palabra(palabra, cantidad);
		NodoArbolAVL nuevo = new NodoArbolAVL(nueva);
		if(raiz == null)
			raiz = nuevo;
		else
			raiz = insertarAVL(nuevo, raiz);
	}
	//Recorridos
	/**
	 * Metodo para recorrer el Arbol InOrden
	 * @param r - NodoArbolAVL con la raiz del arbol
	 */
	public void inOrden(NodoArbolAVL r){
		if (r != null){
			inOrden(r.hijoIzquierdo);
			System.out.print(r.palabra.dato+ ", ");
			inOrden(r.hijoDerecho);
		}
	}
	
	/**
	 * Metodo para recorrer el Arbol PreOrden
	 * @param r - NodoArbolAVL con la raiz del arbol
	 */
	public void preOrden(NodoArbolAVL r){
		if (r != null){
			System.out.print(r.palabra.dato + ", ");
			preOrden(r.hijoIzquierdo);
			preOrden(r.hijoDerecho);
		}
	}
	
	/**
	 * Metodo para recorrer el Arbol PostOrden
	 * @param r - NodoArbolAVL con la raiz del arbol
	 */
	public void postOrden(NodoArbolAVL r){
		if (r != null){
			postOrden(r.hijoIzquierdo);
			postOrden(r.hijoDerecho);
			System.out.print(r.palabra.dato + ", ");
		}
	}
	
	/**
	 * Funcion encargada de devolvernos el nodo reemplazo de un nodo eliminado
	 * @param nodoReemp - NodoArbolAVL a ser reemplazado(Nodo a ser eliminado)
	 * @return - NodoArbolAVL que tomara su lugar
	 */
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
