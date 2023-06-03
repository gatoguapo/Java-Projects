package Unidad1;

import java.util.Scanner;

public class EvidenciaMenu 
{
	public static void main(String[] args) throws Exception 
	{
		Scanner Leer = new Scanner(System.in);
		int opc;
		boolean Salir=false;
		Colas_Evidencia si = new Colas_Evidencia ();
		
		while (!Salir)
		{
		System.out.println("1.-Agregar un elemento");
		System.out.println("2.-Eliminar un elemento");
		System.out.println("3.-Salir");
		System.out.println("Elija una opcion: ");
		opc = Leer.nextInt();
				
		switch (opc) {
		case 1:
			System.out.println("Ingrese el tiempo minimo y tiempo maximo de espera: ");
			si.Rango(Leer.nextInt(), Leer.nextInt());
			System.out.println("Agrega la prioridad y dato del elemento: ");
			si.Push(Leer.nextInt(), Leer.next());	
		break;
		case 2:
			si.Pop();
			System.out.println();
		break;
		case 3:
			Salir = true;
		break;
			default:
				System.out.println("Número invalido, intentelo otra vez: ");
		break;
			
		}
		}
		
	}

}
