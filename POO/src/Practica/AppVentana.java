package Practica;

public class AppVentana {

	public static void main(String[] args) {
		System.out.println("Este programa toma las medidas para una ventana");
		Ventana vent = new Ventana();
		vent.moverVentana();
		vent.moverVentana(10,5);

	}

} 
