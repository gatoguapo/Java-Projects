package Ejercicios;
import java.util.Scanner;
public class Tarea1 
{
	public static void main (String[] args) 
	{
	Ejericicios ej = new Ejericicios();
	Scanner leer = new Scanner (System.in);
	System.out.println("Introduzca el número que desea pasar a factorial: ");
	int numero = leer.nextInt();
	int Factorial=1;
	for (int i=1;i<numero;i++)
	{
		Factorial += Factorial *i;
	}
    System.out.println("El número factorial de "+numero+" es "+Factorial);
	leer.close();
	}
}
