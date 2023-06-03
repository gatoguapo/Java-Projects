package Ejercicios;
import java.util.Scanner;

public class MCongruencias_Main {
	static Scanner leer = new Scanner (System.in);
	static MCongruencias MC = new MCongruencias();
	
	public static void main(String[] args) {
		int opcion;
		boolean control = false;
		do {
			System.out.println("Programa Metodo de las congruencias");
			System.out.println("\tMenu\n"
					+ "\n1.-Introducir los datos."
					+ "\n2.-Metodo de las congruencias."
					+ "\n3.-Salir."
					+ "\n Opciones: ");
			opcion = leer.nextInt();
			switch (opcion) {
			case 1:
				MC.getA();
				MC.getX();
				MC.getC();
				MC.getM();
			break;
			case 2:
				MC.TablaDeMetodos();
			break;
			case 3:
			control = true;
			break;
			}
		} while (control!=true);
	}

}