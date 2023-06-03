package Recursion;

import java.util.Scanner;

public class xd {
	public static void main(String[] args) 
	{		 
		int valor1, valor2;
	  Scanner sn = new Scanner(System.in);
	  
	  System.out.println("Dame el primer numero");
	  valor1 = sn.nextInt();
	 
	  System.out.println("Dame el segundo numero");
	  valor2 = sn.nextInt();
	 
	  int res = mcd(valor1, valor2);
	     
	  System.out.println("MCD: " + res);
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

}
