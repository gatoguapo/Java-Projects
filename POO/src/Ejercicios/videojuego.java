package Ejercicios;

public class videojuego {

	public class Videojuego {
		String titulo, genero, compañia;
		int horasjuego;
		boolean entregado;

		public Videojuego(String titulo, int horasjuego, String genero, String compañia) {
		this.titulo = titulo;
		this.horasjuego = horasjuego;
		this.genero = genero;
		this.compañia = compañia;
		entregado = false;
		}

		public Videojuego(String titulo, int horasjuegoia) {
		this(titulo, 10 , null, null);
		}

		public Videojuego() {
		this(null, 10, null, null);
		}



		public String getTitulo() {
		return titulo;
		}



		public void setTitulo(String titulo) {
		this.titulo = titulo;
		}



		public String getGenero() {
		return genero;
		}



		public void setGenero(String genero) {
		this.genero = genero;
		}



		public String getCompañia() {
		return compañia;
		}



		public void setCompañia(String compañia) {
		this.compañia = compañia;
		}



		public int getHorasjuego() {
		return horasjuego;
		}



		public void setHorasjuego(int horasjuego) {
		this.horasjuego = horasjuego;
		}


		public String toString() {
		return "Videojuego [titulo=" + titulo + ", genero=" + genero + ", compañia=" + compañia + ", horasjuego="
		+ horasjuego + "]";
		}
		}
	
}
