package Ejercicios;

public class Pelicula {
	
	private String titulo;
	private int duracion;
	private int edadMin;
	private String director;
	
	public Pelicula(String titulo, int duracion, int edadMin, String director) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.edadMin = edadMin;
		this.director = director;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getEdadMin() {
		return edadMin;
	}

	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	public boolean tieneEdad(Asiento a) {
		if (a.ocupado()) {
			if (a.edadEspectador()) {
				
			}
		}
	}
	
}
