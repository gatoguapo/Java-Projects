package Unidad4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class AppSerializable {

	public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int op = 0;
        do {
            System.out.println(" Menu ");
            System.out.println("1.- Leer archivo");
            System.out.println("2.- Grabar en el archivo");
            System.out.println("3.- Añadir en el archivo");
            System.out.println("0.- Salir");
            System.out.print("Opcion: ");
            op = leer.nextInt();
            switch (op) {
            case 0:
                break;
            case 1:
                System.out.println("El contenido almacenado es:");
                try {
                	leeFichero(fichero);        	
                } catch (FileNotFoundException e) {
                	System.out.println("El archivo no existe");
                } catch (IOException e) {
                	System.out.println();
                }
                break;
            case 2:
                escribeFichero(fichero);
                break;
            case 3:
            	añadeFichero(fichero);
            }
        } while (op != 0);
        System.out.println("Programa terminado");
        leer.close();
    }
 
    /**
     * Escribe en el fichero que se le pasa y empezandolo desde cero, 5 objetos
     * de la clase Persona.
     * 
     * @param fichero
     *            Path completo del fichero que se quiere escribir
     */
    public void escribeFichero(String fichero) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
            for (int i = 0; i < 5; i++) {
                // ojo, se hace un new por cada Persona. El new dentro
                // del bucle.
                Persona p = new Persona(i);
                oos.writeObject(p);
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Añade al final del fichero que se le pasa 5 objetos de la clase Persona.
     * 
     * @param fichero
     *            Path completo del fichero
     */
    public void anhadeFichero(String fichero) {
        try {
            // Se usa un ObjectOutputStream que no escriba una cabecera en
            // el stream.
            MiObjectOutputStream oos = new MiObjectOutputStream(new FileOutputStream(fichero, true));
            // Se hace el new fuera del bucle, sólo hay una instancia de
            // persona.
            // Se debe usar entonces writeUnshared().
            // Persona p = new Persona(5);
            for (int i = 5; i < 10; i++) {
                // p.setPersona(i); // Se rellenan los datos de Persona.
                Persona p = new Persona(i);
                oos.writeUnshared(p);
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
    /**
     * Se leen todas las Persona en el fichero y se escriben por pantalla.
     * 
     * @param fichero
     *            El path completo del fichero que contiene las Persona.
     */
    public void leeFichero(String fichero) {
        try {
            // Se crea un ObjectInputStream
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
 
            // Se lee el primer objeto
            Object aux = ois.readObject();
 
            // Mientras haya objetos
            while (aux != null) {
                if (aux instanceof Persona)
                    System.out.println(aux);
                aux = ois.readObject();
            }
            ois.close();
        } catch (EOFException e1) {
            System.out.println("Fin de fichero");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    
