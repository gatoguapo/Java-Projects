package Ejercicios;
import java.util.Scanner;
public class AdivinaNum {

	public static void main(String[] args) throws Exception {
	int R = 0, V=0, Contador=0;

	Scanner leer = new Scanner(System.in);
	System.out.println("Intente adivinar el número de 1 a 500:");	
	V =leer.nextInt();
	
	do {
		try {
		R = (int) (Math.random()*10);
		for (int i=0;i<10;i++)
		{
		Contador+=1;
		if (V < R) 
			throw new Exception("El número a adivinar es mayor");	
		if (V > R) 
			throw new Exception("El número a adivinar es menor");
		}
		}
		catch (Exception e) {
			System.out.println("El número de veces que intento fue de : "+Contador);
			leer.next();
			}
		}while (V!=R);
	}
		}
	


