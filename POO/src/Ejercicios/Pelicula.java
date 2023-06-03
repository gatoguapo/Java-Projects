package Ejercicios;

public class Pelicula {

	private String titulo, director;
	private int duracion;
	private byte edadMin;

	public Pelicula(String titulo, String director, int duracion, byte edadMin) {
		this.titulo = titulo;
		this.director = director;
		this.duracion = duracion;
		this.edadMin = edadMin;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public byte getEdadMin() {
		return edadMin;
	}

	public void setEdadMin(byte edadMin) {
		this.edadMin = edadMin;
	}

	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", director=" + director + ", duracion=" + duracion + ", edadMin="
				+ edadMin + "]";
	}
}
