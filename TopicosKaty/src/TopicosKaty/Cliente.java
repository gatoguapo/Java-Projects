package TopicosKaty;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private ArrayList<Integer> carroCompra = new ArrayList<>();
	private int edad;
	
	Cliente(String nombre, ArrayList<Integer> carroCompra,int edad) {
		this.nombre = nombre;
		this.carroCompra = carroCompra;
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Integer> getCarroCompra() {
		return carroCompra;
	}
	
	public int getEdad() {
		return edad;
	}
	

}
