package Estructuras;

class NodoRojiNegro{
	int Cantidad;    	// la llave del arbol
	String Direccion;
	NodoRojiNegro padre;    // el padre del nodo
	NodoRojiNegro hIzq;      // Hijo izquierdo
	NodoRojiNegro hDer;      // Hijo derecho
	int color;      		// Color
	// Constructores
	NodoRojiNegro(){
		padre=hIzq=hDer=null;
		color=0;
	}
	NodoRojiNegro (int canti,String dire){
		Cantidad= canti;
		Direccion= dire;
		padre= hIzq = hDer = null;
		color= 0;
	}
	public NodoRojiNegro(int canti,String dire, NodoRojiNegro pa){
		Cantidad= canti;
		Direccion= dire;
		hIzq= hDer=null;
		padre= pa;
		color= 0;
	}
}