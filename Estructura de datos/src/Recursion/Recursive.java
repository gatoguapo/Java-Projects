package Recursion;

import Fibonacci.Fibonacci;

public class Recursive 
{
	public static void main(String[] args)
	{
	Recursiva a1 = new Recursiva ();
	
	System.out.println("El numero factorial de 5 es " +a1.factorial(5));
	Fibonacci obj_fibo;
	obj_fibo=new Fibonacci();	
	System.out.println("El numero fibonacci de 3 es " +obj_fibo.fibonacci(3));
	System.out.println("Quiero saber si el 3 es par " + a1.esPar(3));
	}
}
