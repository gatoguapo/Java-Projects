package Ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivos {
	public static void main (String[] args) {
		File in= new File ("/home/victo/Entrada.txt");
		File out = new File("/home/victo/Salida.txt");
		FileReader fr;// fr flujo de lectura
		FileWriter fw;// fwflujo de escritura
		
		BufferedReader br;// brlector
		PrintWriter pr;// pr escritor
		
		try
		{
			fr = new FileReader(in);
			fw=new FileWriter(out);
			br=new BufferedReader(fr);
			pr=newPrintWriter(fw);
			
			String linea=br.readLine();//lee la primera linea de entrada
			
			while(linea!=null) {
				int num=Integer.parseInt(linea);//convierte de string a int 
				int fac=factorial(num);//calcula el factorial
				pr.println(fac);//escribe en el archivode salida 
				linea=br.readLine();//lee una linea de la entrada}
				} 
			
			fr.close();
			fw.close();
			
		}catch(IOException e) {
			System.out.print("error");}
		}
		private static PrintWriter newPrintWriter(FileWriter fw) {
		// TODO Auto-generated method stub
		return null;
	}
		// funcion que devuelve el factorial de un numero 
		static int factorial(int n)
		{
			int f=1;
			for(int i=1;i<=n;i++) 
				f=f*i;
			return f;
			
		}
}
