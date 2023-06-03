package Recursion;

import java.util.Scanner;

public class Act7 
{	 
	public static class MCD 
	{
		  static Scanner sn = new Scanner(System.in);

		public static void main(String[] args) {		 
			int valor1, valor2;
		  
		  System.out.println("Dame el primer numero");
		  valor1 = sn.nextInt();
		 
		  System.out.println("Dame el segundo numero");
		  valor2 = sn.nextInt();
		 		     
		  System.out.println("MCD: " + mcd(valor1, valor2));
		  
		}
		public static int mcd(int valor1, int valor2) 
		{	
			int mayor = Math.max(valor1, valor2);
			int menor = Math.min(valor1, valor2);
 
			int resultado = 0;
			do {
				resultado = menor;
				menor = mayor % menor;
				mayor = resultado;
			} while (menor != 0);
 
			return resultado;
         
		}
	}
	public static class DivisionRecursiva 
	{    
	    static Scanner entrada = new Scanner(System.in);
	     
	    public static void main(String[] args) {
	        int dividendo, divisor;
	        System.out.print("Introduce el dividendo: ");
	        dividendo = entrada.nextInt();
	        System.out.print("Introduce el divisor: ");
	        divisor = entrada.nextInt();
	        System.out.printf("%nLa división entre los dos números es: %d", divisionRecursiva(dividendo, divisor));
	    }
	     
	    private static int divisionRecursiva(int dividendo, int divisor){
	        if(divisor>dividendo){
	            return 0;
	        } else {
	            return 1 + divisionRecursiva(dividendo-divisor, divisor);
	        }
	    }
	 
	}
	
}
