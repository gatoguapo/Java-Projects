package Ejercicios;

import java.util.Scanner;

public class ChiCuadradaMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduzca la longitud de la serie:");
		int N = sc.nextInt();
		ChiCuadrada cc = new ChiCuadrada (N);
		cc.tablas();
	}

}
