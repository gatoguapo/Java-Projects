package Unidad4;

import java.io.IOException;
import java.util.Scanner;

public class AppAgenda {
	
	public static Scanner Leer = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
            Agenda.ValidaAgenda();
        } catch (IOException e) {
            System.out.println("Error 001: " + e.getMessage());
        }
		
        int op;
        do {
            op = Menu();
            switch (op) {
            case 1:
                Agrega();
                break;
            case 2:
                Borra();
                break;
            case 3:
                Consulta();
                break;
            case 4:
                Modifica();
                break;
            case 5:
                Listado();
                break;
            case 0:
            	 System.out.print("¿Seguro que quieres salir? (S/N) ");
                 char r = Leer.next().toUpperCase().charAt(0);
                 if (r != 'S')
                     op = 10;
                 // System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
            }
        } while (op != 0);
        Leer.close();
        System.out.println("Vuelva pronto");
    }
	
    private static int Menu() {
        System.out.println("* * * M E N U * * *\n");
        System.out.println("1.-Agregar contacto");
        System.out.println("2.-Borrar contacto");
        System.out.println("3.-Consultar contacto");
        System.out.println("4.-Modificar contacto");
        System.out.println("5.-Listado completo");
        System.out.println("0.-Salir\n");
        System.out.print("Opcion: ");
        return Leer.nextInt();
    }

    private static void Listado() throws IOException, StringIndexOutOfBoundsException, NumberFormatException {
        try {
            Agenda.Listar();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
 
    private static void Modifica() {
        // TODO Auto-generated method stub

 
    }

    private static void Consulta() {
        System.out.println("Consulta contacto");
        Leer.nextLine();
        System.out.print("Nombre: ");
        String nom = Leer.nextLine();
        try {
            System.out.println(Agenda.Lee(nom));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Borra() {
        System.out.println("Eliminar contacto");
        char op = 'n';
        Contacto datos = null;
        Leer.nextLine();
        do {
            System.out.print("Nombre: ");
            String nom = Leer.nextLine();
            try {
                datos = Agenda.Lee(nom);
                if (datos != null) {
                    System.out.println("Clave: " + datos.getClave());
                    System.out.println("Nombre: " + datos.getNombre());
                    System.out.println("Celular: " + datos.getTelefono());
                    System.out.println("Correo: " + datos.getCorreo());
                    System.out.println("Direccion: " + datos.getDireccion());
                    System.out.println();
                    System.out.print("Este es el que deseas eliminar (S/N) (C para cancelar)? ");
                    op = Leer.next().toLowerCase().charAt(0);
                    Leer.nextLine();
                } else {
                    System.out.println("Contacto no encontrado");
                    System.out.println();
                    op = 'n';
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (op == 'n');
        if (op == 's') {
            try {
                Agenda.Elimina(datos.getClave());
                System.out.println("Contacto eliminado exitosamente");
            } catch (NumberFormatException e) {
                System.out.println("Archivo corrupto");
            } catch (IOException e) {
                System.out.println("Error al agregar: " + e.getMessage());
            }
        }
    }
 
    private static void Agrega() {
        System.out.println("Agregar nuevo contacto");
        Leer.nextLine();
        System.out.print("Nombre: ");
        String nom = Leer.next();
        System.out.print("Celular: ");
        String cel = Leer.next();
        System.out.print("Correo: ");
        String mail = Leer.next();
        Leer.nextLine();
        System.out.print("Domicilio: ");
        String dir = Leer.next();
        try {
            Agenda.Agrega(new Contacto(Agenda.SigClave(), nom, cel, mail, dir));
            System.out.println("Contacto agregado exitosamente");
        } catch (NumberFormatException e) {
            System.out.println("Archivo corrupto");
        } catch (IOException e) {
            System.out.println("Error al agregar: " + e.getMessage());
        }
    }

}