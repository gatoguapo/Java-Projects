package Simulación;

import java.util.Scanner;

public class Examen2 {
	static Scanner sc = new Scanner(System.in);
	static int meta = 0, apuesta = 10, cantini = 30,cont = 0, ganancia = 10;
	public static void main(String[] args) {
		menu();
	}

	static void menu() {
		int option;
		boolean control = true;

		do {
			System.out.print("\tMenu\n"
					+ "\n1.- Digite la cantidad que desea ganar."
					+ "\n2.- Salir."
					+ "\n\nOPCION: ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				getGanancia(meta);
				sumaGanancias();
				break;
			case 2:  
				control = false;
				break;
			default:
				System.out.println("ERROR, ingrese una de las opciones.");
				break;
			}

		}while(control);
	}
	
	public static int getGanancia (int n) {
		System.out.println("Cuanto dinero desea ganar?");
		return n = sc.nextInt();
		
	}
	
	public static void sumaGanancias () {
		boolean wl = false;
		System.out.println("antes del volado\tapuesta\t\tdespues del volado");
		do {
			wl = evento();
			ganancia=cantini;
			if (wl=true) {
				apuesta=10;
				ganancia=cantini+apuesta;
				cont++;
			}
			if (wl=false) {
				apuesta= apuesta * 2;
				ganancia=cantini-apuesta;
				cont++;
			}
			if (apuesta>cantini) {
				apuesta=apuesta-cantini;
				cont++;
			}
			System.out.println((cantini + "\t\t\t") + (apuesta + "\t\t") + (ganancia + "\t\t\t"));
		} while (ganancia!= getGanancia(meta) || ganancia!=0);
	}
	
	
	public static boolean evento () {
		boolean wl = false;
		double rand = 0;
		rand = (double)((Math.random() * 0.10));
		if (rand<=0.49) {
			wl = true;
		}
		if (rand>=0.50) {
			wl = false;
		}
		return wl;
	}
}
