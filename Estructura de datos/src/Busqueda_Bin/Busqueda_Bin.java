package Busqueda_Bin;

import java.util.Scanner;

public class Busqueda_Bin 
{
	public static void main(String args[])
	{
		Scanner teclado = new Scanner (System.in);
		int tam;
		Lista_Bin L1=new Lista_Bin();
		
		System.out.println("Indica el tamaño de la lista: ");
		L1.Lista_Bin(tam = teclado.nextInt());
		L1.llenado();
		System.out.println("Qué dato deseas buscar?");
		int dato=teclado.nextInt();
		L1.Busq_Bin(L1.Lista, 0,L1.Lista.length,dato);
	}
}
