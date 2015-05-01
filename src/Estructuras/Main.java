package Estructuras;

import Parseo.TikaParser;

public class Main {

	public static void main(String[] args) {
		ArbolAVL arbolito = new ArbolAVL();
		arbolito.insertar(5);
		arbolito.insertar(8);
		arbolito.insertar(9);
		arbolito.insertar(7);
		arbolito.inOrden(arbolito.obtenerRaiz());
		boolean elimina = arbolito.eliminar(5);
		boolean elimina = arbolito.eliminar(8);
		if (elimina == true)
			javax.swing.JOptionPane.showMessageDialog(null, "Se elimino el nodo");
		else {
			javax.swing.JOptionPane.showMessageDialog(null, "No se encontro el nodo");

		}
		
		System.out.println("");
		arbolito.inOrden(arbolito.obtenerRaiz());
		TikaParser  aParser = new TikaParser();
		String a= String.valueOf(aParser.GetHandler());
       
		Separar fghSeparar = new Separar(a);
	fghSeparar.CicloToken();
	}

}
