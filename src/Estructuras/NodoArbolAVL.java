/**
 * 
 */
package Estructuras;

/**
 * Clase NodoArbolAVL destinada a almacenar los datos dentro de un arbol de tipo AVL
 * @author arturo
 *
 */
public class NodoArbolAVL {
	//Campos de la clase
	Palabra palabra;;
	int fe;
	NodoArbolAVL hijoIzquierdo, hijoDerecho;
	
	/**
	 * Constructor de la clase
	 * @param p - Instancia de la Clase Palabra a ser almacenado dentro del NodoArbolAVL
	 */
	public NodoArbolAVL(Palabra p){
		this.palabra = p;
		this.fe = 0;
		this.hijoIzquierdo = null;
		this.hijoDerecho = null;
		
	}	
}
