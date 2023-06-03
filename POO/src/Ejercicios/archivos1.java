package Ejercicios;
import java.io.*;
public class archivos1 {
	public static void main(String[] args) {
		File f =new File("C:/Users/victo/Desktop/archivos1.txt");//f carga el archivo
		FileReader fr; 
		try
		{
			fr = new FileReader(f);//  fr crea el flujo hacia f
			BufferedReader br = new BufferedReader(fr);// br permite la lectura
			String linea=br.readLine();// linea toma el valor de la primera linea
			while(linea!=null)// mientras haya datos en el archivo
			{
				linea = br.readLine();
				System.out.println(linea);
			}
			fr.close();//cierra el archivo
		}
		catch(IOException e)
		{
			System.out.println("error" + e.getMessage());//  si no se pudo accede al archivo
		}
		}
	
	public static void Lectura() {
		File f=new File("C:/Users/victo/Desktop/archivos1"); // f  carga el archivo
		FileWriter fw;
		PrintWriter pw;
		try
		{
		fw=new FileWriter(f); // fw  crea el flujo hacia f
		pw=new PrintWriter(fw); // pw  permite la escritura en el archivo
		for(int i=1;i<=20;i++)
		{
		pw.println(i); // se introduce el valor de i en el archivo
		}
		fw.close(); // se cierra el flujo del archivo
		}
		catch(IOException e)
		{
		System.out.println("error");
		}
		}

}
