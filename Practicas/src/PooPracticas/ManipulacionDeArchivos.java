package PooPracticas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManipulacionDeArchivos {
	
	private File ruta;
	
	public static void main (String [] args) {
		new ManipulacionDeArchivos();
	}
	
	public ManipulacionDeArchivos (){
		ruta = new File("C:"+File.separator+"Users"+File.separator+"victo"+File.separator+"OneDrive"+File.separator+"Desktop"+File.separator+"carpeta ejemplo"+File.separator+"prueba_txt.txt");
		System.out.println(ruta.getAbsolutePath());
		System.out.println(ruta.exists());
		
		//ruta.mkdir();
		//ruta.delete();
		
		
		String archivo_destino = ruta.getAbsolutePath();
		
		try {
			ruta.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Escribiendo accede_es = new Escribiendo();
		accede_es.escribir(archivo_destino);
	}
}

class Escribiendo {
	
	public Escribiendo () {
		
	}
	
	public void escribir(String ruta_archivo) {
		String frase = "Esto es un ejemplo";
		
		try {
			FileWriter escritura = new FileWriter(ruta_archivo);
			
			for (int i = 0;i < frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			
			escritura.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}