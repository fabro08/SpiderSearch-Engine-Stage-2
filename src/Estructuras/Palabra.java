package Estructuras;

public class Palabra {
	String dato;
	int cantidad;
	
	public Palabra(String dato, int cantidad) {
		this.dato = dato;
		this.cantidad = cantidad;	
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
