package Estructuras;


public class Main {

	public static void main(String[] args) {
		ArbolAVL arbolito = new ArbolAVL();
		arbolito.insertar("Hola",4);
		arbolito.insertar("Bola",1);
		arbolito.insertar("Casa",3);
		arbolito.insertar("Estuvo",3);
		arbolito.inOrden(arbolito.obtenerRaiz());
		System.out.println("");
	//	arbolito.buscar("Estuvo", arbolito.obtenerRaiz());

		//if (elimina == true)
		//	javax.swing.JOptionPane.showMessageDialog(null, "Se elimino el nodo");
		//else {
		//	javax.swing.JOptionPane.showMessageDialog(null, "No se encontro el nodo");
	//	}
		
	//	System.out.println("");
	//	arbolito.inOrden(arbolito.obtenerRaiz());
	}

}
