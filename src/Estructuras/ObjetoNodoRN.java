package Estructuras;

public class ObjetoNodoRN {
	//Argumentos de la clase
	String direccion;
	int cantidad;
	
	/**
	 * Constructor de la clase ObjetoNodoRN
	 */
	public ObjetoNodoRN(String direccion, int cantidad) {
		this.direccion = direccion;
		this.cantidad = cantidad;
	}
	
	/**
	 * Retorna del argumento direccion
	 * @return tipo String con la direccion del documento
	 */
	public String getDireccion() {
		return direccion;
	}
	
	/**
	 * Asigna un String al argumento direccion
	 * @param direccion - String a ser asignado al argumento
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Retorna del argumento cantidad
	 * @return tipo int con la cantidad de palabras que tiene el documento
	 */
	public int getCantidad() {
		return cantidad;
	}
	
	/**
	 * Asigna un int al argumento cantidad
	 * @param cantidad - int a ser asignado al argumento
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	

}
