package Serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AppSerialLee {
	public static void main (String[] args) {
		FileInputStream fis = null;
		ObjectInputStream entrada = null;
		Persona p;
		try {
			fis = new FileInputStream("Persona.dat");
			entrada = new ObjectInputStream (fis);
			p = (Persona) entrada.readObject();
			System.out.println(p.getClave() + " " + p.getNombre() + " " + p.getEdad());
			p = (Persona) entrada.readObject();
			System.out.println(p.getClave() + " " + p.getNombre() + " " + p.getEdad());
			p = (Persona) entrada.readObject();
			System.out.println(p.getClave() + " " + p.getNombre() + " " + p.getEdad());
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Clase de objeto no compatible " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (entrada !=null)
					entrada.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el archivo: " +e.getMessage());
			}
		}
}
}
