package Ejercicios;

public class videojuego {

	public class Videojuego {
		String titulo, genero, compa�ia;
		int horasjuego;
		boolean entregado;

		public Videojuego(String titulo, int horasjuego, String genero, String compa�ia) {
		this.titulo = titulo;
		this.horasjuego = horasjuego;
		this.genero = genero;
		this.compa�ia = compa�ia;
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



		public String getCompa�ia() {
		return compa�ia;
		}



		public void setCompa�ia(String compa�ia) {
		this.compa�ia = compa�ia;
		}



		public int getHorasjuego() {
		return horasjuego;
		}



		public void setHorasjuego(int horasjuego) {
		this.horasjuego = horasjuego;
		}


		public String toString() {
		return "Videojuego [titulo=" + titulo + ", genero=" + genero + ", compa�ia=" + compa�ia + ", horasjuego="
		+ horasjuego + "]";
		}
		}
	
}
