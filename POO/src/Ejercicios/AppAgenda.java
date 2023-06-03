package Ejercicios;

public static void main(String[] args) {
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



private static void Listado() {
    // TODO Auto-generated method stub



}



private static void Modifica() {
    // TODO Auto-generated method stub



}



private static void Consulta() {
    // TODO Auto-generated method stub



}



private static void Borra() {
    // TODO Auto-generated method stub



}



private static void Agrega() {
    System.out.println("Agregar nuevo contacto");
    System.out.print("Nombre: ");
    String nom = leer.nextLine();
    System.out.print("Celular: ");
    String cel = leer.next();
    System.out.print("Correo: ");
    String mail = leer.next();
    System.out.print("Domicilio: ");
    String dir = leer.nextLine();
    if (Agenda.Agrega(new Contacto(Agenda.SigClave(), nom, cel, mail, dir)))
        System.out.println("Contacto agregado exitosamente");
    else
        System.out.println("Error al agregar");
}
