package PooPracticas;

import java.io.*;

public class ManejoDeArchivos {
	private File archivo,ruta; 
	private String [] archivos, archivos_subcarpeta;
	public ManejoDeArchivos() {
		Metodos();
	}
	
	public static void main (String args []) {
		new ManejoDeArchivos();
	}
	
	public void Metodos() {
		archivo = new File("ejemplo_archivo");
		ruta = new File("C:"+File.separator+"Users"+File.separator+"victo"+File.separator+"OneDrive"+File.separator+"Desktop"+File.separator+"Pagina Web");
		//System.out.println(archivo.getAbsolutePath());
		
		//System.out.println(archivo.exists());
		
		System.out.println(ruta.getAbsolutePath());
		
		archivos = ruta.list();
		
		for (int i=0; i<archivos.length;i++) {
			System.out.println(archivos[i]);
			
			File f = new File (ruta.getAbsolutePath(),archivos[i]);
			
			if (f.isDirectory()) {
				archivos_subcarpeta = f.list();
				
				for (int j=0;j<archivos_subcarpeta.length;j++) {
					System.out.println(archivos_subcarpeta[j]);
				}
			}
		}
		
		System.out.println(ruta.exists());
	}
}
