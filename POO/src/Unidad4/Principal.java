package Unidad4;

import java.io.IOException;

public class Principal {
	
/**
 * @param args
 * @throws IOException
 */
/*
public static void main(String[] args) throws IOException {
insertarAlumno(30);
borrarAlumno(30);
recuperarAlumno(30);
Alumno nuevo = nuevoAlumno();
actualizarAlumno(nuevo,30);
recuperarAlumno(30);
}
/*
 */

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
            System.out.print("Seguro que quieres salir (S/N)? ");
            char r = leer.next().toUpperCase().charAt(0);
            if (r != 'S')
                op = 10;
            // System.exit(0); //Instruccion para terminar la ejecucion del programa
            break;
        default:
            System.out.println("Opcion no valida");
        }
    } while (op != 0);
    System.out.println("Bye...");
    leer.close();
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
    return leer.nextInt();
}
	
/*
 * Método que manda a insertar un alumno
 */
public static void insertarAlumno(int posicion) throws IOException{
OperacionesArchivo operaciones = new OperacionesArchivo();
Alumno alumno = leerAlumno();
operaciones.abrirArchivo("alumnosDirecto.txt");
operaciones.nuevoRegistro(posicion, alumno);
operaciones.cerrarArchivo();
}

/*
 * Método que manda a recuperar un alumno
 */
public static void recuperarAlumno(int posicion) throws IOException{
OperacionesArchivo operaciones = new OperacionesArchivo();
Alumno alumno;
operaciones.abrirArchivo("alumnosDirecto.txt");
alumno = operaciones.obtenerRegistro(posicion);
operaciones.cerrarArchivo();
System.out.println(alumno.toString());
}

/*
 * Método que manda a actualizar un alumno
 */
public static void actualizarAlumno(Alumno nuevoAlumno, int posicion)throws
IOException{
OperacionesArchivo operaciones = new OperacionesArchivo();
operaciones.abrirArchivo("alumnosDirecto.txt");
operaciones.actualizarRegistro(posicion,nuevoAlumno);
operaciones.cerrarArchivo();
}

/*
 * Método que manda a borrar un alumno dada una posición
 */
public static void borrarAlumno(int posicion)throws IOException{
OperacionesArchivo operaciones = new OperacionesArchivo();
operaciones.abrirArchivo("alumnosDirecto.txt");
operaciones.eliminarRegistro(posicion);
operaciones.cerrarArchivo();
}

/*
 * Método que llena un alumno
 */
public static Alumno leerAlumno(){
Alumno alumno = new Alumno();
alumno.setNombre("Josue Figueroa González");
alumno.setLicenciatura("Ing. en electrónica");
alumno.setMatricula("matricula");
alumno.setEdad(34);
return alumno;
}

/*
 * Método que llena un alumno para
 * actualizarlo
 */
public static Alumno nuevoAlumno(){
Alumno alumno = new Alumno();
alumno.setNombre("Ivonne Figueroa González");
alumno.setLicenciatura("Ing. bioquimica");
alumno.setMatricula("matricula");
alumno.setEdad(34);
return alumno;
}
}