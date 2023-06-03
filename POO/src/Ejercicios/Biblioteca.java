package Ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca<Autor> {
	
	public static Scanner Leer = new Scanner(System.in);
	
	public static String BiblioNom = "Biblioteca Tec";
	public static String Archivo = "C:\\Users\\victo\\OneDrive\\Desktop\\Biblioteca";

	public static void ValidaBiblio() throws IOException {
        File F = new File(Archivo);
        boolean ValidaBiblio = false;
        if (F.exists()) {
            FileReader FR;
            FR = new FileReader(F);
            BufferedReader BR = new BufferedReader(FR);
            String linea = BR.readLine();
            if (!linea.equals(BiblioNom))
            	ValidaBiblio = true;
            FR.close();
        } else
        	ValidaBiblio = true;
        if (ValidaBiblio) {
            FileWriter FW;
            PrintWriter PW;
            FW = new FileWriter(F);
            PW = new PrintWriter(FW);
            PW.println("Biblioteca Tec");
            FW.close();
        }
    }
	
	private static void ConsultaLibro() throws IOException {
        System.out.println("Consulta Libro");
        System.out.print("Titulo: ");
        String nom = Leer.next();
        try {
            System.out.println(Biblioteca.Lee(nom));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public ContactaLibro Lee (int clave) throws IOException {
		int cve;
        File f = new File(Archivo); // f -carga el archivo
        FileReader fr;
        fr = new FileReader(f); // fr -crea el flujo hacia f
        BufferedReader br = new BufferedReader(fr); // br -permite la lectura
        String linea = br.readLine(); // -linea toma el valor de la primera linea
        while (linea != null) // mientras haya datos en el archivo
        {
            try {
                cve = Integer.parseInt(linea.substring(0, linea.indexOf('|')));
                if (cve == clave) {
                    return creaLibro(linea);
                }
            } catch (StringIndexOutOfBoundsException e) {
            }
            linea = br.readLine();
        }
        fr.close();
        return null;
	}
	
	public static Libro Lee(String Nombre) throws IOException, StringIndexOutOfBoundsException, NumberFormatException {
        String nom;
        File f = new File(Archivo); // f -carga el archivo
        FileReader fr;
        fr = new FileReader(f); // fr -crea el flujo hacia f
        BufferedReader br = new BufferedReader(fr); // br -permite la lectura
        String linea = br.readLine(); // -linea toma el valor de la primera linea
        while (linea != null) // mientras haya datos en el archivo
        {
            try {
                int Pipe2 = linea.indexOf('|', linea.indexOf('|') + 0);
                nom = linea.substring(linea.indexOf('|') + 0, Pipe2);
                if (nom.equals(Nombre)) {
                    return creaLibro(linea);
                }
            } catch (StringIndexOutOfBoundsException e) {
            }
            linea = br.readLine();
        }
        fr.close();
        return null;
    }

 

    private static Autor creaLibro(String linea) throws StringIndexOutOfBoundsException, NumberFormatException {
        int Libro1 = linea.indexOf('|');
        int Libro2 = linea.indexOf('|', Libro1 + 1);
        int Libro3 = linea.indexOf('|', Libro2 + 1);
        int Libro4 = linea.indexOf('|', Libro3 + 1);// linea.lastIndex('|');
        int cve = Integer.parseInt(linea.substring(0, Libro1));
        String Autor = linea.substring(Libro1 + 1, Libro2);
        String Libro = linea.substring(Libro2 + 1, Libro3);
        String Genero = linea.substring(Libro3 + 1, Libro4);
        String Fecha = linea.substring(Libro4 + 1);
        return new ContactaLibro(cve, Autor, Libro, Genero, Fecha);
    }
	
    public static void Actualiza(ContactaLibro dato) throws IOException, NumberFormatException {
        File f = new File(Archivo); // f -carga el archivo
        FileReader fr;
        ArrayList<ContactaLibro> listado = new ArrayList<>();
        try {
            fr = new FileReader(f); // fr -crea el flujo hacia f
            BufferedReader br = new BufferedReader(fr); // br -permite la lectura
            String linea = br.readLine(); // -linea toma el valor de la primera linea
            linea = br.readLine();
            while (linea != null) // mientras haya datos en el archivo
            {
                listado.add(creaLibro(linea));
                linea = br.readLine();
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage()); // si no se pudo accede al archivo
        }
        FileWriter fw;
        PrintWriter pw;
        fw = new FileWriter(f); // fw -crea el flujo hacia f
        pw = new PrintWriter(fw); // pw -permite la escritura en el archivo
        pw.println(BiblioNom);
        for (int i = 0; i < listado.size(); i++) {
            pw.println(dato.getClave() == listado.get(i).getClave() ? dato : listado.get(i));
        }
        fw.close(); // se cierra el flujo del archivo
    }
	
    public static void Elimina(int Clave) throws IOException, NumberFormatException {
        File f = new File(Archivo); // f -carga el archivo
        FileReader fr;
        ArrayList<ContactaLibro> listado = new ArrayList<>();
        try {
            fr = new FileReader(f); // fr -crea el flujo hacia f
            BufferedReader br = new BufferedReader(fr); // br -permite la lectura
            String linea = br.readLine(); // -linea toma el valor de la primera linea
            linea = br.readLine();
            while (linea != null) // mientras haya datos en el archivo
            {
                listado.add(creaLibro(linea));
                linea = br.readLine();
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage()); // si no se pudo accede al archivo
        }
        FileWriter fw;
        PrintWriter pw;
        fw = new FileWriter(f); // fw -crea el flujo hacia f
        pw = new PrintWriter(fw); // pw -permite la escritura en el archivo
        pw.println(BiblioNom);
        for (int i = 0; i < listado.size(); i++) {
            if (Clave != listado.get(i).getClave())
                pw.println(listado.get(i));
        }
        fw.close(); // se cierra el flujo del archivo
    }
	
	public static boolean Agrega(ContactaLibro datos) throws IOException {
        File F = new File(Archivo);
        FileWriter FW;
        PrintWriter PW;
        FW = new FileWriter(F, true);
        PW = new PrintWriter(FW);
        PW.println(datos);
        FW.close();
        return true;
    }

	private static void Listado() {
        // Agenda.MuestraListado();
        ArrayList<ContactaLibro> listado = Biblioteca.RegresaListado();
        ContactaLibro datos;
        System.out.println("Clave\tNombre\t\tCelular\tCorreo\t\t\tDireccion");
        for (int i = 0; i < listado.size(); i++) {
            datos = listado.get(i);
            if (datos != null) {
                System.out.print(datos.getClave() + "\t");
                System.out.print(datos.getNombre() + "\t\t");
                System.out.print(datos.getTelefono() + "\t");
                System.out.print(datos.getCorreo() + "\t\t");
                System.out.println(datos.getDireccion());
            }
        }
    }
	
	public static void Listar() {
		
	}
	
    
    public static ArrayList<ContactaLibro> RegresaListado() {
        File f = new File(Archivo); // f -carga el archivo
        FileReader fr;
        ArrayList<ContactaLibro> listado = new ArrayList<>();
        try {
            fr = new FileReader(f); // fr -crea el flujo hacia f
            BufferedReader br = new BufferedReader(fr); // br -permite la lectura
            String linea = br.readLine(); // -linea toma el valor de la primera linea
            linea = br.readLine();
            while (linea != null) // mientras haya datos en el archivo
            {
                listado.add(creaLibro(linea));
                linea = br.readLine();
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage()); // si no se pudo accede al archivo
        }
        return listado;
    }
}
