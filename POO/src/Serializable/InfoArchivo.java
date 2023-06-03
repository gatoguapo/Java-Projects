package Serializable;

import java.io.File;

public class InfoArchivo {

	public static void main(String[] args) {

		if (args.length > 0) {
			for (int i=0;i < args.length;i++) {
				File f = new File (args[i]);
				if (f.exists()) {
					System.out.println("Fichero existente");
					System.out.println("Nombre: "+ f.getName());
					System.out.println("Camino: "+ f.getPath());
					System.out.println((f.canRead() ? "y se puede Leer" : ""));
					System.out.println((f.canWrite() ? "y se puede Escribir" : ""));
					System.out.println("La longitud del fichero son " +f.length() + "bytes");
				} else 
					System.out.println("El fichero no existe");
			} 		
		} else 
				System.out.println("Debe indicar un fichero");
	}

}