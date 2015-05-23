package Estructuras;



public class ArbolRN {
	NodoArbolRN raiz = null;
	NodoArbolRN x, y, z;
	private static final boolean Negro = false;
	private static final boolean Rojo = true;
	private static final NodoArbolRN NULO;
	static{
		NULO = new NodoArbolRN();
		NULO.n = null;
		NULO.padre = null;
		NULO.hijoIzquierdo = null;
		NULO.hijoDerecho = null;
		NULO.color = Negro;
	}
	public boolean estaVacio(NodoArbolRN r){
		if(r == null)
			return true;
		else 
			return false;
	}
	public NodoArbolRN getRaiz(){
		return raiz;
	}
	
	//public void insertar(String direccion, int cantidad){
	public void insertar(NodoArbolRN z){
		//ObjetoNodoRN nuevoObject = new ObjetoNodoRN(direccion, cantidad);	
		//NodoArbolRN z= new NodoArbolRN();
		NodoArbolRN y = NULO;
		NodoArbolRN x = raiz;
		while (x != NULO){
			y = x;
			if(z.n.cantidad < x.n.cantidad)
				x = x.hijoIzquierdo;
			else 
				x = x.hijoDerecho;			
		}
		z.padre = y;
		if (y == NULO)
			raiz = z;
		else if(z.n.cantidad < y.n.cantidad)
			y.hijoIzquierdo = z;
		else 
			y.hijoDerecho = z;
		z.hijoIzquierdo = z.hijoDerecho = NULO;
		z.color = Rojo;
		corregirInsercion(z);						
	}
	
	public void corregirInsercion(NodoArbolRN z){
		while (z.padre.color == Rojo){
			if (z.padre == z.padre.padre.hijoIzquierdo) {
				y = z.padre.padre.hijoDerecho;
				if (y.color == Rojo){
					z.padre.color = Negro;
					y.color = Negro;
					z.padre.padre.color = Rojo;
					z = z.padre.padre;							
				} else {
					if (x == z.padre.hijoDerecho) {
						z = z.padre;
						rotarIzquierda(z);
					}
					z.padre.color = Negro;
					z.padre.padre.color = Rojo;
					rotarDerecha(z.padre.padre);
				}
			} else {
				y = z.padre.padre.hijoIzquierdo;
				if (y.color == Rojo) {
					z.padre.color = Negro;
					y.color = Negro;
					z.padre.padre.color = Rojo;
					z = z.padre.padre;
				} else {
					if (z == z.padre.hijoIzquierdo) {
						z = z.padre;
						rotarDerecha(z);						
					}
					z.padre.color = Negro;
					z.padre.padre.color = Rojo;
					rotarIzquierda(z.padre.padre);
					
				}
			}
		}
		raiz.color = Negro;
	}
	
	public void rotarIzquierda(NodoArbolRN x){
		NodoArbolRN y = x.hijoDerecho;
		x.hijoDerecho = y.hijoIzquierdo;
		y.hijoIzquierdo.padre = x;
		y.padre = x.padre;
		if (x.padre==NULO)
			raiz = y;
		else if (x==x.padre.hijoIzquierdo)
			x.padre.hijoIzquierdo = y;
		else
			x.padre.hijoDerecho = y;
		y.hijoIzquierdo = x;
		x.padre = y;
		
	}
	
	public void rotarDerecha(NodoArbolRN y){
		x = y.hijoIzquierdo;
		y.hijoIzquierdo = x.hijoDerecho;
		x.hijoDerecho.padre = y;
		x.padre = y.padre;
		if (y.padre==NULO)
			raiz = x;
		else if (y==y.padre.hijoIzquierdo)
			y.padre.hijoIzquierdo = x;
		else
			y.padre.hijoDerecho = x;
		x.hijoDerecho = y;
		y.padre = x;
		
	}
	
	public NodoArbolRN eliminar(NodoArbolRN z){
		NodoArbolRN x, y;
		if (z.hijoIzquierdo != NULO && z.hijoDerecho != NULO)
			y = bucarMAX(z.hijoIzquierdo);
		else 
			y = z;
		if (y.hijoIzquierdo != NULO)
			x = y.hijoIzquierdo;
		else 
			x = y.hijoDerecho;
		x.padre  = y.padre;
		if (y.padre == NULO)
			raiz = x;
		else if (y == y.padre.hijoIzquierdo)
			y.padre.hijoIzquierdo = x;
		else 
			y.padre.hijoDerecho = x;
		if (y != z)
			z.n.cantidad = y.n.cantidad;
		if (y.color == Negro)
			corregirEliminar(x);
		return y;
	}
	
	public void corregirEliminar(NodoArbolRN x){
		NodoArbolRN w;
		while (x != raiz && x.color == Negro) {
			if (x == x.padre.hijoIzquierdo) {
				w = x.padre.hijoDerecho;
				if (w.color == Rojo) {
					w.color = Negro;
					x.padre.color = Rojo;
					rotarIzquierda(x.padre);
					w = x.padre.hijoDerecho;
				}
				if (w.hijoIzquierdo.color == Negro && w.hijoDerecho.color == Negro){
					w.color = Rojo;
					x = x.padre;
				} else {
					if (w.hijoDerecho.color == Negro){
						w.hijoIzquierdo.color = Negro;
						w.color = Rojo;
						rotarDerecha(w);
						w = x.padre.hijoDerecho;
					}
					w.color = x.padre.color;
					x.padre.color = Negro;
					w.hijoDerecho.color = Negro;
					rotarIzquierda(x.padre);
					x = raiz;
				}
			} else {
				w = x.padre.hijoIzquierdo;
				if (w.color == Rojo) {
					w.color = Negro;
					x.padre.color = Rojo;
					rotarDerecha(x.padre);
					w = x.padre.hijoIzquierdo;
				}
				if (w.hijoDerecho.color == Negro && w.hijoIzquierdo.color == Negro){
					w.color = Rojo;
					x = x.padre;
				} else {
					if (w.hijoDerecho.color == Negro){
						w.hijoDerecho.color = Negro;
						w.color = Rojo;
						rotarIzquierda(w);
						w = x.padre.hijoIzquierdo;
					}
					w.color = x.padre.color;
					x.padre.color = Negro;
					w.hijoIzquierdo.color = Negro;
					rotarDerecha(x.padre);
					x = raiz;
				}
			}
		}	
		x.color = Negro;
	}
	
	public NodoArbolRN bucarMAX(NodoArbolRN x){
		if (Math.max(x.hijoIzquierdo.n.cantidad, x.hijoDerecho.n.cantidad) == x.hijoIzquierdo.n.cantidad)
			return x.hijoIzquierdo;
		else
			return x.hijoDerecho;
	}
	
	public NodoArbolRN buscar(NodoArbolRN r){
	return raiz;	
	
	}

}