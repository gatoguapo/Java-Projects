package Unidad1;

import java.util.Scanner;

public class JugadoresMenu {
	public static void main(String[] args) throws Exception 
	{
		Scanner Leer=new Scanner(System.in);
		
		boolean Salir=false;
		Jugadores JugadoresA = new Jugadores();
		int opc;
		
		while(!Salir) {
		System.out.println("1.- Agregar Capitan");
		System.out.println("2.- Agregar jugadores");
		System.out.println("3.- Jugadores Equipo1");
		System.out.println("4.- Jugadores Equipo2");
		System.out.println("5.- Mostrar Equipos");
		System.out.println("6.- Salir \n");
		
		System.out.print("Elija una opcion: ");
		opc=Leer.nextInt();
		System.out.println();
		
			switch(opc) {
				case 1:
					System.out.println("-----------Agregar Capitanes----------- \n");
					System.out.print("Porfavor ingrese el nombre del Capitan 1: ");
					JugadoresA.Capitan1(Leer.next());
					System.out.print("Porfavor ingrese el nombre del Capitan 2: ");
					JugadoresA.Capitan2(Leer.next());
					System.out.println();
					break;
				case 2:
					System.out.println("------Agregar jugadores------\n");
					JugadoresA.Todos();
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