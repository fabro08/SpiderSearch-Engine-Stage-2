package Estructuras;

public class Main {

	public static void main(String[] args) {
		ArbolAVL arbolito = new ArbolAVL();
		arbolito.insertar(5);
		arbolito.insertar(8);
		arbolito.insertar(9);
		arbolito.inOrden(arbolito.obtenerRaiz());
	}

}
