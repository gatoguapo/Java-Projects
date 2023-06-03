package Ejercicios;

import java.util.Scanner;

public class AppPassword {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		System.out.print("Cuantas contraseñas desea generar: ");
		int nc = leer.nextInt();
		Password[] vecPass = new Password[nc];
		boolean[] seguridad = new boolean[nc];
		System.out.print("Longitud de las contraseñas: ");
		int lon = leer.nextInt();
		for (int i = 0; i < nc; i++) {
			vecPass[i] = new Password((byte) lon);
			seguridad[i] = vecPass[i].EsFuerte();
		}
		for (int i = 0; i < vecPass.length; i++)
			System.out.println("Pass: " + vecPass[i].getPass() + " - " + (seguridad[i] ? "Es fuerte" : "No es fuerte"));

		leer.close();
	}

}
