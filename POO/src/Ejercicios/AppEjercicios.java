package Ejercicios;

import java.util.Random;

public class AppEjercicios 
{
	public static void main(String[] args) 
	{
		Random R = new Random(); 
		float SumaSueldo=0, SumaSueldoNuevo=0, Sueldo=0, SueldoNuevo=0;
		System.out.println("Nombre Empleado			Sueldo			SueldoNuevo");
		for (int i=1;i<=50;i++)
		{
			Sueldo=R.nextInt(20001)+5000;
			SueldoNuevo=Ejericicios.SueldoAumentado(Sueldo);
			System.out.println("Empleado "+i+"			"+Sueldo+"			"+SueldoNuevo);
			SumaSueldo+=Sueldo;
			SumaSueldoNuevo+=SueldoNuevo;
			
		}
		System.out.println("Total nomina actual:"+SumaSueldo);
		System.out.println("Total nomina con aumento:"+SumaSueldoNuevo);
	}
}
