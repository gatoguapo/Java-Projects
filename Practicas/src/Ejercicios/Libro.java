package Ejercicios;

public class Libro {
	
	private int ISBN, numPaginas;
	private String titulo, autor;
	
	public Libro (int pISBN, int pNumPaginas, String pTitulo, String pAutor) {
		this.ISBN = pISBN;
		this.numPaginas = pNumPaginas;
		this.titulo = pTitulo;
		this.autor = pAutor;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int ISBN) {
		this.ISBN = ISBN;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
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
	
	public String toString () {
		return  "El libro "+titulo+" con ISBN "+ISBN+" creado por el autor "+autor+" tiene "+numPaginas+" páginas";
	}
	
}
