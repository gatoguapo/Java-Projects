package Ejercicios;

public class LibroMain {
	
		public static void main (String args[]) {
			
			Libro libro1 = new Libro (111111, 230, "Harry Potter", "Jk Rowling");
			Libro libro2 = new Libro (111112, 180, "El Extranjero", "Albert Camus");
			
			System.out.println(libro1.toString());
			System.out.println(libro2.toString());
			
			System.out.println();
			
			if (libro1.getNumPaginas()>libro2.getNumPaginas()) {
				System.out.println(libro1.getTitulo() + " Tiene mayor numero de paginas");
			} else {
				System.out.println(libro2.getTitulo() + " Tiene mayor numero de paginas");

			}
		}
	
}
