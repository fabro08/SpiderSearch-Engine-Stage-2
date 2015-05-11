package Estructuras;

/**
 * Clase que crea instancias de tipo palabra que almacena un objeto de tipo string y otro de tipo entero
 * indicando la cantidad de veces que aparecio una palabra en un documento
 * @author arturo
 */
public class Palabra {
	//Campos de la clase
	String dato;
	int cantidad;
	
	/**
	 * Constructor de la Clase Palabra
	 * @param dato - String a ser almacenado
	 * @param cantidad - cantidad de veces que aparecio la palabra
	 */
	public Palabra(String dato, int cantidad) {
		this.dato = dato;
		this.cantidad = cantidad;	
	}
	
	/**
	 * Funcion que retorna el Dato(String almacenado) en la instanca
	 * @return - String almacenado
	 */
	public String getDato() {
		return dato;
	}
	
	/**
	 * Metodo que asigna un Strig al Nodo para que sea almacenado
	 * @param dato - String a asignar
	 */
	public void setDato(String dato) {
		this.dato = dato;
	}

	/**
	 * Funcion que retorna la cantidad(entero almacenado) en la instanca
	 * @return - int que indica la cantidad de veces que aparecio la palabra
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Metodo que asigna un Entero al Nodo para que sea almacenado
	 * @param cantidad - int a asignar
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
