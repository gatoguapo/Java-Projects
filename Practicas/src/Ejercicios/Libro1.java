package Ejercicios;

public class Libro1 {
	
	private int ISBN = 0;
	private String titulo = " ";
	private String autor = "";
	private int Npag = 0;
	
	public Libro1 (int ISBN, String titulo, String autor, int Npag) {
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.autor = autor;
		this.Npag = Npag;
	}
	
	public Libro1 () {
	
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNpag() {
		return Npag;
	}

	public void setNpag(int npag) {
		Npag = npag;
	}
	
	public String toString () {
		return "El libro "+getTitulo()+" con ISBN "+getISBN()+" creado por el autor "+getAutor()+" tiene "+getNpag()+" páginas";
	}
}
