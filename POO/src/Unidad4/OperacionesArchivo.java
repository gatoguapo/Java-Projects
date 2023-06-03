package Unidad4;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class OperacionesArchivo {

	public RandomAccessFile archivo;

	/*
	 * Se abre el archivo recibiendo un nombre
	 */
	public void abrirArchivo(String nombreArchivo) throws IOException {
		archivo = new RandomAccessFile(nombreArchivo, "rw");
	}

	/*
	 * Se cierra el archivo
	 */
	public void cerrarArchivo() throws IOException {
		if (archivo != null)
			archivo.close();
	}

	/*
	 * Se lee un registro para llenar un objeto alumno a partir de una posición dada
	 */
	public Alumno obtenerRegistro(int posicion) throws IllegalArgumentException, NumberFormatException, IOException {
		Alumno alumno = new Alumno();
		if (posicion < 0 || posicion > 100)
			throw new IllegalArgumentException("Fuera de rango");
		// buscar registro apropiado en el archivo
		archivo.seek((posicion) * Alumno.TAMANIO);
		if (archivo.getFilePointer() < archivo.length()) {
			alumno.setNombre(leerCadena(archivo));
			alumno.setLicenciatura(leerCadena(archivo));
			alumno.setEdad(archivo.readInt());
			alumno.setMatricula(leerCadena(archivo));
			return alumno;
		} else
			return null;
	}

	/*
	 * Almacena un alumno en la posición dada
	 */
	public void nuevoRegistro(int posicion, Alumno alumno) throws IllegalArgumentException, IOException {
		// buscar registro apropiado en el archivo
		archivo.seek((posicion) * Alumno.TAMANIO);
		escribirCadena(archivo, alumno.getNombre());
		escribirCadena(archivo, alumno.getLicenciatura());
		archivo.writeInt(alumno.getEdad());
		escribirCadena(archivo, alumno.getMatricula());
	}

	/*
	 * asegurarse que la cadena sea de la longitud apropiada remplazando los
	 * caracteres que falten de la longitud con espacios en blanco
	 */
	private String leerCadena(RandomAccessFile archivo) throws IOException {
		char nombre[] = new char[50], temp;
		for (int cuenta = 0; cuenta < nombre.length; cuenta++) {
			temp = archivo.readChar();
			nombre[cuenta] = temp;
		}
		return new String(nombre).replace('\0', ' ');
	}

	/*
	 * Elimina un registro del archivo
	 */
	public void eliminarRegistro(int posicion) throws IllegalArgumentException, IOException {
		// crear un registro en blanco para escribir en el archivo
		Alumno alumno = new Alumno();
		// buscar registro apropiado en el archivo
		archivo.seek((posicion) * Alumno.TAMANIO);
		escribirCadena(archivo, alumno.getNombre());
		escribirCadena(archivo, alumno.getLicenciatura());
		archivo.writeInt(alumno.getEdad());
		escribirCadena(archivo, alumno.getMatricula());
	}

	/*
	 * Actualiza un registro
	 */
	public void actualizarRegistro(int posicion, Alumno alumno) throws IllegalArgumentException, IOException {
		// buscar registro apropiado en el archivo
		archivo.seek((posicion) * Alumno.TAMANIO);
		escribirCadena(archivo, alumno.getNombre());
		escribirCadena(archivo, alumno.getLicenciatura());
		archivo.writeInt(alumno.getEdad());
		escribirCadena(archivo, alumno.getMatricula());
	}

	/*
	 * Escribe una cadena de caracteres de máximo 50 caracteres
	 */
	private void escribirCadena(RandomAccessFile archivo, String cadena) throws IOException {
		StringBuffer bufer = null;
		if (cadena != null)
			bufer = new StringBuffer(cadena);
		else
			bufer = new StringBuffer(50);
		bufer.setLength(50);
		archivo.writeChars(bufer.toString());
	}

	// metodo para regresar el numero de registro buscando por nombre
	public int RegresaPos(String nombre) throws IOException, RAFException {
		char nom[];
		int reg = 0;
		archivo.seek(0);
		while (archivo.getFilePointer() < archivo.length()) {
			nom = new char[50];
			for (int cuenta = 0; cuenta < nom.length; cuenta++) {
				nom[cuenta] = archivo.readChar();
			}
			if (new String(nom).replace('\0', ' ').trim().equals(nombre.trim())) {
				return reg;
			}
			reg++;
			archivo.seek(reg * Alumno.TAMANIO);
		}
		throw new RAFException("Nombre no encontrado");
	}

	// metodo para regresar el siguiente registro disponible
	public int SigDisponible() throws IOException {
		char nom[];
		int reg = 0;
		archivo.seek(0);
		while (archivo.getFilePointer() < archivo.length()) {
			nom = new char[50];
			for (int cuenta = 0; cuenta < nom.length; cuenta++) {
				nom[cuenta] = archivo.readChar();
			}
			if (new String(nom).replace('\0', ' ').trim().isEmpty()) {
				return reg;
			}
			reg++;
			archivo.seek(reg * Alumno.TAMANIO);
		}
		return reg;
	}

	public int RegresaListado() throws IOException {
		char nom[];
		int reg = 0;
		archivo.seek(0);
		while (archivo.getFilePointer() < archivo.length()) {
			nom = new char[50];
			for (int cuenta = 0; cuenta < nom.length; cuenta++) {
				nom[cuenta] = archivo.readChar();
			}
			if (new String(nom).replace('\0', ' ').trim().isEmpty()) {
				return reg;
			}
			reg++;
			archivo.seek(reg * Alumno.TAMANIO);
		}
		return reg;
	}
}