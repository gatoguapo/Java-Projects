 package Unidad4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AppAlumno {

	/*
	 * public static void main(String[] args) throws IOException {
	 * insertarAlumno(30); borrarAlumno(30); recuperarAlumno(30); Alumno nuevo =
	 * nuevoAlumno(); actualizarAlumno(nuevo, 30); recuperarAlumno(30); }
	 */

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
		System.out.println("1.-Agregar");
		System.out.println("2.-Borrar");
		System.out.println("3.-Consultar");
		System.out.println("4.-Modificar");
		System.out.println("5.-Listado completo");
		System.out.println("0.-Salir\n");
		System.out.print("Opcion: ");
		return leer.nextInt();
	}
	
	public int SigDisponible () throws IOException {
		char [] nom;
		int reg = 0;
		archivo.seek(0);
		while (archivo.getFilePointer()<archivo.length()) {
			nom = new char [50];
			for (int cuenta = 0; cuenta < nom.length;cuenta++) {
				nom[cuenta] = archivo.readChar();
			}
			if (new String(nom).replace('\0',' ').trim().isEmpty()) {
				return reg;
			}
			reg++;
			archivo.seek(reg*Alumno.TAMANIO);
		}
		return reg;
	}

	private static void Listado() {
		try {
			OperacionesArchivo operaciones = new OperacionesArchivo();
			operaciones.abrirArchivo("alumnosDirecto.dat");
			ArrayList<Alumno> listado = operaciones.RegresaListado();
			operaciones.cerrarArchivo();
			Alumno datos;
			System.out.println("Nombre\t\tLicenciatura\t\tEdad\tMatricula");
			for (int i = 0; i < listado.size(); i++) {
				datos = listado.get(i);
				if (datos != null) {
					System.out.print(datos.getNombre() + "\t\t");
					System.out.print(datos.getLicenciatura() + "\t\t");
					System.out.print(datos.getEdad() + "\t");
					System.out.print(datos.getMatricula());
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Alumno> RegresaListado() throws IOException {
		ArrayList<Alumno> listado = new ArrayList<>();
		Alumno alumno;
		archivo.seek(0);
		while (archivo.getFilePointer()<archivo.length()) {
			alumno = new Alumno ();
			alumno.setNombre(leerCadena(archivo).trim());
			alumno.setLicenciatura(leerCadena(archivo).trim());
			alumno.setEdad(archivo.readInt());
			alumno.setMatricula(leerCadena(archivo).trim()):
				if (!alumno.getNombre().trim().isEmpty())
					listado.add(alumno);
		}
		return listado;
	}

	private static void Modifica() {
		System.out.println("Modificar contacto");
		char op = 'n';
		Alumno datos = null;
		int pos = -1;
		leer.nextLine();
		do {

			System.out.print("Nombre: ");
			String nom = leer.nextLine();
			try {
				OperacionesArchivo operaciones = new OperacionesArchivo();
				operaciones.abrirArchivo("alumnosDirecto.dat");
				pos = operaciones.RegresaPos(nom);
				datos = operaciones.obtenerRegistro(pos);
				operaciones.cerrarArchivo();
				if (datos != null) {
					System.out.println("Nombre: " + datos.getNombre());
					System.out.println("Licenciatura: " + datos.getLicenciatura());
					System.out.println("Edad: " + datos.getEdad());
					System.out.println("Matricula: " + datos.getMatricula());
					System.out.println();
					System.out.print("Este es el que deseas modificar (s/n) (c para cancelar)? ");
					op = leer.next().toLowerCase().charAt(0);
					leer.nextLine();
				} else {
					System.out.println("Alumno no encontrado");
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
			System.out.print("Licenciatura: ");
			String lic = leer.next();
			System.out.print("Edad: ");
			int edad = leer.nextInt();
			System.out.print("Matricula: ");
			String mat = leer.nextLine();
			try {
				OperacionesArchivo operaciones = new OperacionesArchivo();
				operaciones.abrirArchivo("alumnosDirecto.dat");
				operaciones.actualizarRegistro(pos, new Alumno(nom, lic, edad, mat));
				operaciones.cerrarArchivo();
				System.out.println("Alumno actualizado exitosamente");
			} catch (NumberFormatException e) {
				System.out.println("Archivo corrupto");
			} catch (IOException e) {
				System.out.println("Error al agregar: " + e.getMessage());
			}
		}
	}

	private static void Consulta() {
		System.out.println("Consulta");
		leer.nextLine();
		System.out.print("Nombre: ");
		String nom = leer.nextLine();
		try {
			OperacionesArchivo operaciones = new OperacionesArchivo();
			operaciones.abrirArchivo("alumnosDirecto.dat");
			// System.out.println("Pos= " + operaciones.RegresaPos(nom));
			Alumno datos = operaciones.obtenerRegistro(operaciones.RegresaPos(nom));
			operaciones.cerrarArchivo();
			if (datos != null) {
				System.out.println("Nombre: " + datos.getNombre());
				System.out.println("Licenciatura: " + datos.getLicenciatura());
				System.out.println("Edad: " + datos.getEdad());
				System.out.println("Matricula: " + datos.getMatricula());
			} else
				System.out.println("Registro no encontrado");
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (RAFException e) {
			System.out.println(e.getMessage());
		}
		System.out.println();
	}

	private static void Borra() {
		System.out.println("Eliminar");
		char op = 'n';
		Alumno datos = null;
		leer.nextLine();
		do {

			System.out.print("Nombre: ");
			String nom = leer.nextLine();
			try {
				OperacionesArchivo operaciones = new OperacionesArchivo();
				operaciones.abrirArchivo("alumnosDirecto.dat");
				datos = operaciones.obtenerRegistro(operaciones.RegresaPos(nom));
				operaciones.cerrarArchivo();
				if (datos != null) {
					System.out.println("Nombre: " + datos.getNombre());
					System.out.println("Licenciatura: " + datos.getLicenciatura());
					System.out.println("Edad: " + datos.getEdad());
					System.out.println("Matricula: " + datos.getMatricula());
					System.out.println();
					System.out.print("Este es el que deseas eliminar (s/n) (c para cancelar)? ");
					op = leer.next().toLowerCase().charAt(0);
					leer.nextLine();
				} else {
					System.out.println("Alumno no encontrado");
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
				OperacionesArchivo operaciones = new OperacionesArchivo();
				operaciones.abrirArchivo("alumnosDirecto.dat");
				operaciones.eliminarRegistro(operaciones.RegresaPos(datos.getNombre()));
				operaciones.cerrarArchivo();
				System.out.println("Registro eliminado exitosamente");
			} catch (NumberFormatException e) {
				System.out.println("Archivo corrupto");
			} catch (IOException e) {
				System.out.println("Error al agregar: " + e.getMessage());
			}
		}
	}

	private static void Agrega() {
		System.out.println("Agregar nuevo");
		leer.nextLine();
		System.out.print("Nombre: ");
		String nom = leer.nextLine();
		System.out.print("Licenciatura: ");
		String lic = leer.nextLine();
		System.out.print("Edad: ");
		int edad = leer.nextInt();
		leer.nextLine();
		System.out.print("Matricula: ");
		String mat = leer.next();
		try {
			OperacionesArchivo operaciones = new OperacionesArchivo();
			operaciones.abrirArchivo("alumnosDirecto.dat");
			operaciones.nuevoRegistro(operaciones.SigDisponible(), new Alumno(nom, lic, edad, mat));
			operaciones.cerrarArchivo();
			System.out.println("Contacto agregado exitosamente");
		} catch (NumberFormatException e) {
			System.out.println("Edad no valida");
		} catch (IOException e) {
			System.out.println("Error al agregar: " + e.getMessage());
		}
	}

	/*
	 * Método que manda a recuperar un alumno
	 */
	public static void recuperarAlumno(int posicion) throws IOException {
		OperacionesArchivo operaciones = new OperacionesArchivo();
		Alumno alumno;
		operaciones.abrirArchivo("alumnosDirecto.txt");
		alumno = operaciones.obtenerRegistro(posicion);
		operaciones.cerrarArchivo();
		System.out.println(alumno.toString());
	}

	/*
	 * Método que manda a actualizar un alumno
	 */
	public static void actualizarAlumno(Alumno nuevoAlumno, int posicion) throws IOException {
		OperacionesArchivo operaciones = new OperacionesArchivo();
		operaciones.abrirArchivo("alumnosDirecto.txt");
		operaciones.actualizarRegistro(posicion, nuevoAlumno);
		operaciones.cerrarArchivo();
	}

	/*
	 * Método que manda a borrar un alumno dada una posición
	 */
	public static void borrarAlumno(int posicion) throws IOException {
		OperacionesArchivo operaciones = new OperacionesArchivo();
		operaciones.abrirArchivo("alumnosDirecto.txt");
		operaciones.eliminarRegistro(posicion);
		operaciones.cerrarArchivo();
	}

	/*
	 * Método que llena un alumno
	 */
	public static Alumno leerAlumno() {
		Alumno alumno = new Alumno();
		alumno.setNombre("Josue Figueroa González");
		alumno.setLicenciatura("Ing. en electrónica");
		alumno.setMatricula("matricula");
		alumno.setEdad(34);
		return alumno;
	}

	/*
	 * Método que llena un alumno para actualizarlo
	 */
	public static Alumno nuevoAlumno() {
		Alumno alumno = new Alumno();
		alumno.setNombre("Ivonne Figueroa González");
		alumno.setLicenciatura("Ing. bioquimica");
		alumno.setMatricula("matricula");
		alumno.setEdad(34);
		return alumno;
	}

}

