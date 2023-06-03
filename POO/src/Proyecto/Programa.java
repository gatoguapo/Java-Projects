package Proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
    public static Scanner sc = new Scanner(System.in);
    static OperacionesContrase�as operacionesContrase�as;
    private static String archivo = "usuarios.dat";

    public static void main(String[] args) {
        int op;
        do {
            op = menuDeInicioDeSecion();
            switch (op) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    Registrarse();
                    break;
                case 0:
                    System.out.print("Seguro que quieres salir (S/N)? ");
                    char r = sc.next().toUpperCase().charAt(0);
                    if (r != 'S')
                        op = 10;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (op != 0);
        System.out.println("Bye...");
        sc.close();
    }

    private static int menuDeInicioDeSecion() {
        System.out.println("\n* * * M E N U * * *\n");
        System.out.println("1.-Iniciar sesion");
        System.out.println("2.-Registrarse");
        return sc.nextInt();
    }

    private static void contrase�asAplicacion() {
        operacionesContrase�as = new OperacionesContrase�as();
        int op;
        do {
            op = Menu();
            switch (op) {
                case 1:
                    Altas();
                    break;
                case 2:
                    Consultas();
                    break;
                case 3:
                    Bajas();
                    break;
                case 4:
                    Cambios();
                    break;
                case 5:
                    Listado();
                    break;
                case 10:
                    break;
                case 0:
                    System.out.print("Seguro que quieres salir (S/N)? ");
                    char r = sc.next().toUpperCase().charAt(0);
                    if (r != 'S')
                        op = 10;
                    // System.exit(0); //Instruccion para terminar la ejecucion del programa
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (op != 0);
        operacionesContrase�as.Guarda();
        System.out.println("Bye...");

        sc.close();
    }

    private static int Menu() {
        try {
            System.out.println("\n* * * M E N U * * *\n");
            System.out.println("1.-Agregar contrase�as");
            System.out.println("2.-Leer contrase�a");
            System.out.println("3.-Eliminar contrase�as");
            System.out.println("4.-Modificar contrase�as");
            System.out.println("5.-Listar contrase�as");
            System.out.println("0.-Salir\n");
            System.out.print("Opcion: ");
            return sc.nextInt();
        } catch (Exception e) {
            sc.next();

            return 10;
        }
    }

    private static void Altas() {
        System.out.println("Agrega contrase�a");
        System.out.println("Introduzca el identificador");
        sc.nextLine();
        String identificador = sc.nextLine();
        System.out.println("Introduzca el correo principal");
        String correoPrincipal = sc.next();
        System.out.println("Introduzca el correo alternativo");
        String correoAlternativo = sc.next();
        System.out.println("Introduzca el usuario");
        String usuario = sc.next();
        System.out.println("Introduzca la contrase�a");
        sc.nextLine();
        String contrase�a = sc.nextLine();
        System.out.println("Introduzca el url");
        String url = sc.next();
        System.out.println("Introduzca el nota");
        sc.nextLine();
        String nota =  sc.nextLine();

        Contrase�a nuevaContrase�a = new Contrase�a(identificador, correoPrincipal, correoAlternativo, usuario, contrase�a, url, nota);
        operacionesContrase�as.AgregarContrase�a(nuevaContrase�a);
        System.out.println("Contrase�a agregada correctamente");
    }

    private static void Bajas() {
        System.out.println("Eliminar Contrase�a");
        char op = 'n';
        Contrase�a dato = null;
        sc.nextLine();
        do {
            System.out.print("Identificador: ");
            String identificador = sc.nextLine();
            try {
                dato = operacionesContrase�as.lee(identificador);
                if (dato != null) {
                    System.out.println(dato.toString());
                    System.out.println();
                    System.out.print("Esta es la que deseas eliminar (s/n) (c para cancelar)? ");
                    op = sc.next().toLowerCase().charAt(0);
                    sc.nextLine();
                } else {
                    System.out.println("Contrase�a no encontrado");
                    System.out.println();
                    op = 'n';
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (op == 'n');
        if (op == 's') {
            try {
                operacionesContrase�as.EliminarContrase�a(dato.getIdentificador());
                System.out.println("Contrase�a eliminada exitosamente");
            } catch (NumberFormatException e) {
                System.out.println("Archivo corrupto");
            }
        }
    }

    private static void Cambios() {
        System.out.println("Actualiza Contrase�a");
        char op = 'n';
        Contrase�a dato = null;
        sc.nextLine();
        do {
            System.out.print("Identificador: ");
            String identificador = sc.nextLine();
            try {
                dato = operacionesContrase�as.lee(identificador);
                if (dato != null) {
                    System.out.println(dato.toString());
                    System.out.println();
                    System.out.print("Esta es la que deseas Actualizar (s/n) (c para cancelar)? ");
                    op = sc.next().toLowerCase().charAt(0);
                    sc.nextLine();
                } else {
                    System.out.println("Contrase�a no encontrada");
                    System.out.println();
                    op = 'n';
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (op == 'n');
        if (op == 's') {
            try {
                System.out.println("Introduzca el identificador");
                sc.nextLine();
                String identificador = sc.nextLine();
                System.out.println("Introduzca el correo principal");
                String correoPrincipal = sc.next();
                System.out.println("Introduzca el correo alternativo");
                String correoAlternativo = sc.next();
                System.out.println("Introduzca el usuario");
                String usuario = sc.next();
                System.out.println("Introduzca la nueva contrase�a");
                sc.nextLine();
                String contrase�a = sc.nextLine();
                System.out.println("Introduzca el url");
                String url = sc.next();
                System.out.println("Introduzca el nota");
                sc.nextLine();
                String nota =  sc.nextLine();

                Contrase�a nuevaContrase�a = new Contrase�a(identificador, correoPrincipal, correoAlternativo, usuario, contrase�a, url, nota);
                operacionesContrase�as.ActualizaContrase�a(nuevaContrase�a, dato.getIdentificador());
            } catch (NumberFormatException e) {
                System.out.println("Archivo corrupto");
            }
        }

    }

    private static void Consultas() {
        System.out.println("Dijite el identificador");
        String identificador = sc.next();
        Contrase�a contrase�a = operacionesContrase�as.lee(identificador);

        if (contrase�a == null) {
            System.out.println("No existe la contrase�a");
        } else {
            System.out.println(contrase�a.toString());
        }
    }

    private static void Listado() {
            ArrayList<Contrase�a> contrase�as = operacionesContrase�as.listarContrase�as();

            if (contrase�as.size() == 0) {
                System.out.println("No hay contrase�as");
            } else {
                for(int i=0; i<contrase�as.size(); i++) {
                    System.out.println(contrase�as.get(i).toString());
                }
            }
    }

    public static void Registrarse() {
        try {
            OperacionesUsuario op = new OperacionesUsuario();
            op.abrirArchivo(archivo);
            ArrayList<Usuario> listado = op.listado();

            if (listado.size() == 0) {
                System.out.println("Agregar nuevo");
                System.out.println("Digite su usuario");
                String usuarioNombre = sc.next();

                System.out.println("Digite su password");
                String usuarioPassword = sc.next();

                op.nuevoRegistro(op.SigDisponible(), new Usuario(usuarioNombre, usuarioPassword));
                op.cerrarArchivo();
                System.out.println("Usuario agregado exitosamente");
            } else {
                System.out.println("Ya hay una cuenta existente");
            }

        } catch (NumberFormatException e) {
            System.out.println("Edad no valida");
        } catch (IOException e) {
            System.out.println("Error al agregar: " + e.getMessage());
        }
    }

    private static void iniciarSesion() {
        try {
            OperacionesUsuario op = new OperacionesUsuario();
            op.abrirArchivo(archivo);

            ArrayList<Proyecto.Usuario> listado = op.listado();
            Usuario usuario = listado.get(0);

            System.out.println("Introduzca su usuario");
            String usuarioNombre = sc.next();

            System.out.println("introduzca su contrase�a");
            String usuarioPassword = sc.next();

            if (!usuarioNombre.equals(usuario.getUsuario())) {
                System.out.println("El nombre de usuario es incorrecto");
                return;
            }

            if (!usuarioPassword.equals(usuario.getContrase�a())){
                System.out.println("La contrase�a es incorrecta");
                return;
            }

            contrase�asAplicacion();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
