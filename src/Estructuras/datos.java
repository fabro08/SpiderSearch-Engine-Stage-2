package Estructuras;

public class datos {
	int cantidad;
	String direccion;
	public datos(int cantidad, String direccion){
		this.cantidad = cantidad;
		this.direccion = direccion;	
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}