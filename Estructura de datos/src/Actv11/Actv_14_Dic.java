package Actv11;

import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
public class Actv_14_Dic 
{
 
 public static void main(String[] args)
 {
 // TODO code application logic here
 LinkedHashMap<String,String> prueba = new LinkedHashMap();
 ArrayList<String> prueba2 = new ArrayList();
 Scanner entrada = new Scanner(System.in);
 String palabraBuscada = "", definicionAgregada = "", respuesta = "";
 
 Diccionario.agregar(prueba, "Pizza", "preparación culinaria que consiste en un pan plano, "
 		+ "habitualmente de forma circular, elaborado con harina de trigo, levadura, agua y "
 		+ "sal que tradicionalmente se cubre con salsa de tomate y queso y se hornea a alta "
 		+ "temperatura en un horno de leña."); 
 Diccionario.agregar(prueba, "HotDog", "es un alimento en forma de bocadillo que se genera con"
 		+ " la combinación de una salchicha del tipo salchicha de Frankfurt o vienesa hervida "
 		+ "o frita, servida en un pan con forma alargada que suele acompañarse con algún "
 		+ "aderezo, como salsa de tomate, mostaza, jalapeño, cebolla, y chucrut. ");
 Diccionario.agregar(prueba, "PolloFrito", "es un plato que consiste en trozos de pollo que se "
 		+ "han recubierto con harina o rebozado condimentados y se fríen, se fríen, se fríen a "
 		+ "presión o se fríen al aire.");
 Diccionario.agregar(prueba, "Sushi", "es un plato típico de origen japonés basado en arroz "
 		+ "aderezado con vinagre de arroz, azúcar y sal y combinado con otros ingredientes como "
 		+ "pescados crudos, mariscos, verduras, etc.​​​ Este plato es uno de los más reconocidos de "
 		+ "la gastronomía japonesa y uno de los más populares internacionalmente.");
 Diccionario.agregar(prueba, "PapasFritas", "son las papas que se preparan cortándose en rodajas o "
 		+ "en forma de bastones y friéndolas en aceite caliente hasta que queden doradas, "
 		+ "retirándolas del aceite y luego sazonándolas con sal.");
 Diccionario.agregar(prueba, "Boneless", "trocitos de pechuga de pollo, sin hueso, empanizados y"
 		+ " bañados en una salsa, mientras que las alitas de pollo regulares, conservan el "
 		+ "hueso para su preparación");
 
 Objeto1 pObj = Objeto1.retrieve();
 if (pObj == null) 
 {
	 // Manejar el caso cuando el archivo no existe y se debe
	 // crear por primera vez.
	 System.out
	 .println("El objeto persistente será creado por primera vez");
	 pObj = new Objeto1();
 
 }
 Objeto2 pObj2 = Objeto2.retrieve();
 if (pObj2 == null) 
 {
	 // Manejar el caso cuando el archivo no existe y se debe
	 // crear por primera vez.
	 System.out
	 .println("El objeto persistente será creado por primera vez");
	 pObj2 = new Objeto2();
	 
 }
 //prueba.put();
 Diccionario.agregar(prueba, pObj.regresarPrimero(), pObj2.regresarPrimero());
 // busqueda de la palabra
 do
 {
	 System.out.println("Que palabra desea buscar en el diccionario");
	 palabraBuscada = entrada.nextLine();
	 if(Diccionario.busquedaSecuencial(prueba, palabraBuscada))
 {
 System.out.println("La definicion de " + palabraBuscada + " es: " + 
 prueba.get(palabraBuscada));
 }
 
 } while(Diccionario.busquedaSecuencial(prueba, palabraBuscada)); 
 
 System.out.println("Esa palabra no se encuentra te gustaria agregarla? SI/NO");
 respuesta = entrada.nextLine();
 respuesta = respuesta.toUpperCase();
 if (respuesta.equals("SI"))
 {
	 //agregar la palabra
	 System.out.println("Escribe su definicion");
	 definicionAgregada = entrada.nextLine(); 
 }
 
 pObj.set(palabraBuscada);
 pObj.persist();
 pObj2.set(definicionAgregada);
 pObj2.persist2();
 
 }
 


 
 }
