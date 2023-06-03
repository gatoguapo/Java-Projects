package Ejercicios;

import java.util.Scanner;

public class ClasePadre_Abstracta {
	 
	protected int transacciones, retiro, deposito;
	private int saldo;
	Scanner Leer = new Scanner (System.in);
		
	public void Operaciones() {
		int bandera = 0;
		int seleccion = 0;
		
		do {
			do {
				System.out.println("Seleccione una opcion:");
				System.out.println("	1.-Consulta de saldo.");
				System.out.println("    2.-Retiro de efectivo.");
				System.out.println("    3.-Deposito de efectivo.");
				System.out.println("    4.-Salir.");
				seleccion = Leer.nextInt();
			
				if (seleccion >= 1 && seleccion <=4) {
					bandera = 1;
				} else {
					System.out.println("------------------------------------------");
					System.out.println("Opcion no disponible, vuelva a intentarlo.");
					System.out.println("------------------------------------------");
				}
			} while (bandera == 0);
			
			if (seleccion == 1) {
				
			} else if (seleccion == 2) {
				
			} else if (seleccion == 3) {
				
			} else if (seleccion == 4) {
				System.out.println("--------------------");
				System.out.println("Programa finalizado");
				System.out.println("--------------------");
				bandera = 2;
			}
			
		} while (bandera != 2);
	
	}
	
	
}
