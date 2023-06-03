package Serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AppSerialEscribe {
	public static void main (String[] args) {
	FileOutputStream fos = null;
	ObjectOutputStream salida = null;
	Persona p;
	
	try {
		fos = new FileOutputStream ("Persona.dat");
		salida = new ObjectOutputStream (fos);
		p = new Persona ("103", "Teo Gonzalez", 45);
		salida.writeObject(p);
		p = new Persona ("99", "Chenchito", 18);
		salida.writeObject(p);
		p = new Persona ("150", "Jorge Falcon", 50);
		salida.writeObject(p);
	} catch (FileNotFoundException e) {
		System.out.println("Archivo no encontrado " + e.getMessage());
	} catch (IOException e) {
		System.out.println("Error: " + e.getMessage());
	} finally {
		try {
			if (fos != null)
				fos.close();
			if (salida !=null)
				salida.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el archivo: " +e.getMessage());
		}
	}
}
}
