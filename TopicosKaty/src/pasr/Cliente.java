package pasr;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private int[] carroCompra;
	private int edad;
	
	Cliente(String nombre, int[] carroCompra) {
		this.nombre = nombre;
		this.carroCompra = carroCompra;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int[] getCarroCompra() {
		return carroCompra;
	}
	
	public int getEdad() {
		return edad;
	}
}