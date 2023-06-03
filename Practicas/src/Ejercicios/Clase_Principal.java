package Ejercicios;
import java.util.Scanner;
public class Clase_Principal {
	public static void main (String[] args) {
		Scanner leer = new Scanner (System.in);
		Recursividad recursividad = new Recursividad();
		System.out.println("Introduce el numero para calcular su factorial: ");
		int numero = leer.nextInt();
		int factorial = recursividad.Factorial(numero);
		System.out.println("El factorial de "+numero+ " es "+factorial);
	}
}
