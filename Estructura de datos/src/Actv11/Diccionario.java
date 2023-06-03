package Actv11;

import java.util.LinkedHashMap;

public class Diccionario 
{
	 public static boolean busquedaSecuencial(LinkedHashMap<String, String> data, String number) 
	 {
		 if(data.containsKey(number))
	 {
	 
	 return true; 
	 } 
	 else
	 {
	 
	 return false; 
	 }
	 
	 }
	 
	 public static void agregar( LinkedHashMap<String, String> data, String dato, String number)
	 {
		 data.put(dato, number);
	 }
 
}
