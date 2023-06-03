package Unidad4;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import capaDeDatos.AccesoDatos;
import capaDeDatos.Contacto;

public class Agenda {

	public static Scanner leer = new Scanner(System.in);

	public static void main(String[] args) {
		int op;
		do {
			op = Menu();
			switch (op) {
			case 1:
				Agrega();
				break;
			case 2:
				Borra();
				break;
			case 3:
				Consulta();
				break;
			case 4:
				Modifica();
				break;
			case 5:
				Listado();
				break;
			case 0:
				System.out.print("Seguro que quieres salir (S/N)? ");
				char r = leer.next().toUpperCase().charAt(0);
				if (r != 'S')
					op = 10;
				// System.exit(0); //Instruccion para terminar la ejecucion del programa
				break;
			default:
				System.out.println("Opcion no valida");
			}
		} while (op != 0);
		System.out.println("Bye...");
		leer.close();
	}

	private static int Menu() {
		System.out.println("* * * M E N U * * *\n");
		System.out.println("1.-Agregar contacto");
		System.out.println("2.-Borrar contacto");
		System.out.println("3.-Consultar contacto");
		System.out.println("4.-Modificar contacto");
		System.out.println("5.-Listado completo");
		System.out.println("0.-Salir\n");
		System.out.print("Opcion: ");
		return leer.nextInt();
	}

	private static void Listado() {
		// Agenda.MuestraListado();
		ArrayList<Contacto> listado = AccesoDatos.RegresaListado();
		Contacto datos;
		System.out.println("Clave\tNombre\t\tCelular\tCorreo\t\t\tDireccion");
		for (int i = 0; i < listado.size(); i++) {
			datos = listado.get(i);
			if (datos != null) {
				System.out.print(datos.getClave() + "\t");
				System.out.print(datos.getNombre() + "\t\t");
				System.out.print(datos.getCel() + "\t");
				System.out.print(datos.getCorreo() + "\t\t");
				System.out.println(datos.getDomicilio());
			}
		}
	}

	private static void Modifica() {
		System.out.println("Modificar contacto");
		char op = 'n';
		Contacto datos = null;
		leer.nextLine();
		do {

			System.out.print("Nombre: ");
			String nom = leer.nextLine();
			try {
				datos = AccesoDatos.Lee(nom);
				if (datos != null) {
					System.out.println("Clave: " + datos.getClave());
					System.out.println("Nombre: " + datos.getNombre());
					System.out.println("Celular: " + datos.getCel());
					System.out.println("Correo: " + datos.getCorreo());
					System.out.println("Direccion: " + datos.getDomicilio());
					System.out.println();
					System.out.print("Este es el que deseas modificar (s/n) (c para cancelar)? ");
					op = leer.next().toLowerCase().charAt(0);
					leer.nextLine();
				} else {
					System.out.println("Contacto no encontrado");
					System.out.println();
					op = 'n';
				}
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} while (op == 'n');
		if (op == 's') {
			System.out.print("Nombre: ");
			String nom = leer.nextLine();
			datos.setNombre(nom);
			System.out.print("Celular: ");
			String cel = leer.next();
			datos.setCel(cel);
			System.out.print("Correo: ");
			String mail = leer.next();
			datos.setCorreo(mail);
			leer.nextLine();
			System.out.print("Domicilio: ");
			String dir = leer.nextLine();
			datos.setDomicilio(dir);
			try {
				AccesoDatos.Actualiza(datos);
				System.out.println("Contacto actualizado exitosamente");
			} catch (NumberFormatException e) {
				System.out.println("Archivo corrupto");
			} catch (IOException e) {
				System.out.println("Error al agregar: " + e.getMessage());
			}
		}
	}

	private static void Consulta() {
		System.out.println("Consulta contacto");
		leer.nextLine();
		System.out.print("Nombre: ");
		String nom = leer.nextLine();
		try {
			Contacto datos = AccesoDatos.Lee(nom);
			if (datos != null) {
				System.out.println("Clave: " + datos.getClave());
				System.out.println("Nombre: " + datos.getNombre());
				System.out.println("Celular: " + datos.getCel());
				System.out.println("Correo: " + datos.getCorreo());
				System.out.println("Direccion: " + datos.getDomicilio());
			} else
				System.out.println("Contacto no encontrado");
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}

	private static void Borra() {
		System.out.println("Eliminar contacto");
		char op = 'n';
		Contacto datos = null;
		leer.nextLine();
		do {

			System.out.print("Nombre: ");
			String nom = leer.nextLine();
			try {
				datos = AccesoDatos.Lee(nom);
				if (datos != null) {
					System.out.println("Clave: " + datos.getClave());
					System.out.println("Nombre: " + datos.getNombre());
					System.out.println("Celular: " + datos.getCel());
					System.out.println("Correo: " + datos.getCorreo());
					System.out.println("Direccion: " + datos.getDomicilio());
					System.out.println();
					System.out.print("Este es el que deseas eliminar (s/n) (c para cancelar)? ");
					op = leer.next().toLowerCase().charAt(0);
					leer.nextLine();
				} else {
					System.out.println("Contacto no encontrado");
					System.out.println();
					op = 'n';
				}
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} while (op == 'n');
		if (op == 's') {
			try {
				AccesoDatos.Elimina(datos.getClave());
				System.out.println("Contacto eliminado exitosamente");
			} catch (NumberFormatException e) {
				System.out.println("Archivo corrupto");
			} catch (IOException e) {
				System.out.println("Error al agregar: " + e.getMessage());
			}
		}
	}

	private static void Agrega() {
		System.out.println("Agregar nuevo contacto");
		leer.nextLine();
		System.out.print("Nombre: ");
		String nom = leer.nextLine();
		System.out.print("Celular: ");
		String cel = leer.next();
		System.out.print("Correo: ");
		String mail = leer.next();
		leer.nextLine();
		System.out.print("Domicilio: ");
		String dir = leer.nextLine();
		try {
			AccesoDatos.Agrega(new Contacto(AccesoDatos.SigClave(), nom, cel, mail, dir));
			System.out.println("Contacto agregado exitosamente");
		} catch (NumberFormatException e) {
			System.out.println("Archivo corrupto");
		} catch (IOException e) {
			System.out.println("Error al agregar: " + e.getMessage());
		}
	}

}