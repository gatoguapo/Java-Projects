package Ejercicios;

public class Libro1Main {

	public static void main(String[] args) {
		Libro1 obj1 = new Libro1 ();
		Libro1 obj2 = new Libro1 ();
		
		obj1.setISBN(1111);
		obj1.setTitulo("El senor de los anillos");
		obj1.setAutor("Tolkien");
		obj1.setNpag(1130);
		
		obj2.setISBN(1112);
		obj2.setTitulo("El Extranjero");
		obj2.setAutor("Albert Camus");
		obj2.setNpag(320);
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());

	}

}
