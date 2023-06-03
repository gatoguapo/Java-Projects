package Ejercicios;

import java.util.Scanner;

public class RaicesMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduzca los valores de a, b y c:");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		Raices ecuacion = new Raices (a,b,c);
		ecuacion.calcular();
	}

}
