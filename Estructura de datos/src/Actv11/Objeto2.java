package Actv11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
public class Objeto2 implements Serializable 
{
	 private static final long serialVersionUID = 1;
	 private static final String FILE_NAME = "PRUEBA2.bin";
	 
	 public String a;
	 public String b; 
	 // ------------------------------------------------------------------------
	 public void set(String a) 
	 {
		 this.a = a;
	 }
	 
	 // ------------------------------------------------------------------------
	 public String toString() 
	 {
		 return "(" + a + ")";
	 }
	 
	 public String regresarPrimero()
	 {
		 return a;
	 }
	 
	 public String regresarSegundo()
	 {
		 return b;
	 }
	 
	 // ------------------------------------------------------------------------
	 public void persist2() 
	 {
		 try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
		 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
		 oos.writeObject(this);
	 } 
		catch (Exception e) 
		{
		 // Atrapar todas las excepciones y terminar programa.
		 e.printStackTrace();
		 System.exit(1);
		}
	 }
	 
	 // ------------------------------------------------------------------------
	 public static Objeto2 retrieve() 
	 {
		 if (new File(FILE_NAME).exists()) 
		 {
			 try (FileInputStream fis = new FileInputStream(FILE_NAME);
			 ObjectInputStream ois = new ObjectInputStream(fis)) 
		 {
		return (Objeto2) ois.readObject();
		 } 
		 catch (Exception e)
		 {
			 // Atrapar todas las excepciones y terminar programa.
			 e.printStackTrace();
			 System.exit(1);
		 }
	 }
	 	return null;
	 }
}