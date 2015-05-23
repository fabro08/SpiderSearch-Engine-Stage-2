
package Estructuras;

/**
 * Clase NodoArbolAVL destinada a almacenar los datos dentro de un arbol de tipo AVL
 * @author arturo
 *
 */
public class NodoArbolRN {
	//Campos de la clase
	ObjetoNodoRN n;
	boolean color;
	NodoArbolRN padre, hijoIzquierdo, hijoDerecho;
	
	/**
	 * Constructor de la clase
	 * @param n - Dato de tipo int que a ser almacenado en el nodo
	 */
	public NodoArbolRN(){
		this.n = null;
		this.hijoIzquierdo = null;
		this.hijoDerecho = null;
		
	}

	public ObjetoNodoRN getN() {
		return n;
	}

	public void setN(ObjetoNodoRN n) {
		this.n = n;
	}

	public NodoArbolRN getHijoIzquierdo() {
		return hijoIzquierdo;
	}

	public void setHijoIzquierdo(NodoArbolRN hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}

	public NodoArbolRN getHijoDerecho() {
		return hijoDerecho;
	}

	public void setHijoDerecho(NodoArbolRN hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public NodoArbolRN getPadre() {
		return padre;
	}

	public void setPadre(NodoArbolRN padre) {
		this.padre = padre;
	}	
}
