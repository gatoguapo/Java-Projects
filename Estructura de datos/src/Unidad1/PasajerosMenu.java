package Unidad1;

import java.util.Scanner;

public class PasajerosMenu {
	public static void main(String[] args) throws Exception 
	{
		Scanner Leer=new Scanner(System.in);
		
		boolean Salir=false;
		Pasajeros PasajeroA = new Pasajeros();
		int opc;
		
		while(!Salir) {
		System.out.println("1.- Agregar Pasajero");
		System.out.println("2.- Eliminar Pasajero");
		System.out.println("3.- Mostrar los datos de un pasajero");
		System.out.println("4.- Salir \n");
		
		System.out.print("Elija una opcion: ");
		opc=Leer.nextInt();
		System.out.println();
		
			switch(opc) {
				case 1:
					System.out.println("-----------Agregar pasajero----------- \n");
					System.out.print("Porfavor ponga el nombre del pasajero: ");
					PasajeroA.AgregaPasajero(Leer.next());
					System.out.println();
					break;
				case 2:
					System.out.println("------Eliminar Pasajero------\n");
					System.out.print("Dime a quien deseas eliminar");
					PasajeroA.BorrarPasajero(Leer.next());
					System.out.println();
					break;
				case 3:
					System.out.print("----Introuduzca el nombre del pasajero---- \n");
					PasajeroA.MostrarPasajeros();
					System.out.println("\n");
					
					break;
				case 4:
					Salir=true;
					break;
					
					default:
						System.out.println("Numero invalido");
			
			}
			
		}
		
	}
}
