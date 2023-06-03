package Proyecto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
    public static Scanner sc = new Scanner(System.in);
    static OperacionesContraseñas operacionesContraseñas;
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

    private static void contraseñasAplicacion() {
        operacionesContraseñas = new OperacionesContraseñas();
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
        operacionesContraseñas.Guarda();
        System.out.println("Bye...");

        sc.close();
    }

    private static int Menu() {
        try {
            System.out.println("\n* * * M E N U * * *\n");
            System.out.println("1.-Agregar contraseñas");
            System.out.println("2.-Leer contraseña");
            System.out.println("3.-Eliminar contraseñas");
            System.out.println("4.-Modificar contraseñas");
            System.out.println("5.-Listar contraseñas");
            System.out.println("0.-Salir\n");
            System.out.print("Opcion: ");
            return sc.nextInt();
        } catch (Exception e) {
            sc.next();

            return 10;
        }
    }

    private static void Altas() {
        System.out.println("Agrega contraseña");
        System.out.println("Introduzca el identificador");
        sc.nextLine();
        String identificador = sc.nextLine();
        System.out.println("Introduzca el correo principal");
        String correoPrincipal = sc.next();
        System.out.println("Introduzca el correo alternativo");
        String correoAlternativo = sc.next();
        System.out.println("Introduzca el usuario");
        String usuario = sc.next();
        System.out.println("Introduzca la contraseña");
        sc.nextLine();
        String contraseña = sc.nextLine();
        System.out.println("Introduzca el url");
        String url = sc.next();
        System.out.println("Introduzca el nota");
        sc.nextLine();
        String nota =  sc.nextLine();

        Contraseña nuevaContraseña = new Contraseña(identificador, correoPrincipal, correoAlternativo, usuario, contraseña, url, nota);
        operacionesContraseñas.AgregarContraseña(nuevaContraseña);
        System.out.println("Contraseña agregada correctamente");
    }

    private static void Bajas() {
        System.out.println("Eliminar Contraseña");
        char op = 'n';
        Contraseña dato = null;
        sc.nextLine();
        do {
            System.out.print("Identificador: ");
            String identificador = sc.nextLine();
            try {
                dato = operacionesContraseñas.lee(identificador);
                if (dato != null) {
                    System.out.println(dato.toString());
                    System.out.println();
                    System.out.print("Esta es la que deseas eliminar (s/n) (c para cancelar)? ");
                    op = sc.next().toLowerCase().charAt(0);
                    sc.nextLine();
                } else {
                    System.out.println("Contraseña no encontrado");
                    System.out.println();
                    op = 'n';
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (op == 'n');
        if (op == 's') {
            try {
                operacionesContraseñas.EliminarContraseña(dato.getIdentificador());
                System.out.println("Contraseña eliminada exitosamente");
            } catch (NumberFormatException e) {
                System.out.println("Archivo corrupto");
            }
        }
    }

    private static void Cambios() {
        System.out.println("Actualiza Contraseña");
        char op = 'n';
        Contraseña dato = null;
        sc.nextLine();
        do {
            System.out.print("Identificador: ");
            String identificador = sc.nextLine();
            try {
                dato = operacionesContraseñas.lee(identificador);
                if (dato != null) {
                    System.out.println(dato.toString());
                    System.out.println();
                    System.out.print("Esta es la que deseas Actualizar (s/n) (c para cancelar)? ");
                    op = sc.next().toLowerCase().charAt(0);
                    sc.nextLine();
                } else {
                    System.out.println("Contraseña no encontrada");
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
                System.out.println("Introduzca la nueva contraseña");
                sc.nextLine();
                String contraseña = sc.nextLine();
                System.out.println("Introduzca el url");
                String url = sc.next();
                System.out.println("Introduzca el nota");
                sc.nextLine();
                String nota =  sc.nextLine();

                Contraseña nuevaContraseña = new Contraseña(identificador, correoPrincipal, correoAlternativo, usuario, contraseña, url, nota);
                operacionesContraseñas.ActualizaContraseña(nuevaContraseña, dato.getIdentificador());
            } catch (NumberFormatException e) {
                System.out.println("Archivo corrupto");
            }
        }

    }

    private static void Consultas() {
        System.out.println("Dijite el identificador");
        String identificador = sc.next();
        Contraseña contraseña = operacionesContraseñas.lee(identificador);

        if (contraseña == null) {
            System.out.println("No existe la contraseña");
        } else {
            System.out.println(contraseña.toString());
        }
    }

    private static void Listado() {
            ArrayList<Contraseña> contraseñas = operacionesContraseñas.listarContraseñas();

            if (contraseñas.size() == 0) {
                System.out.println("No hay contraseñas");
            } else {
                for(int i=0; i<contraseñas.size(); i++) {
                    System.out.println(contraseñas.get(i).toString());
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

            System.out.println("introduzca su contraseña");
            String usuarioPassword = sc.next();

            if (!usuarioNombre.equals(usuario.getUsuario())) {
                System.out.println("El nombre de usuario es incorrecto");
                return;
            }

            if (!usuarioPassword.equals(usuario.getContraseña())){
                System.out.println("La contraseña es incorrecta");
                return;
            }

            contraseñasAplicacion();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
