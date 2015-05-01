/**
 * 
 */
package Estructuras;

/**
 * @author arturo
 *
 */
public class NodoArbolAVL {
	Palabra palabra;;
	int fe;
	NodoArbolAVL hijoIzquierdo, hijoDerecho;
	public NodoArbolAVL(Palabra p){
		this.palabra = p;
		this.fe = 0;
		this.hijoIzquierdo = null;
		this.hijoDerecho = null;
		
	}	
}
