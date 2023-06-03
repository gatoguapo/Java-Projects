package Ejercicios;

public class Espectador {

		private String nombre;
		private byte edad;
		private float dinero;

		public Espectador(String nombre, byte edad, float dinero) {
			this.nombre = nombre;
			this.edad = edad;
			this.dinero = dinero;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public byte getEdad() {
			return edad;
		}

		public void setEdad(byte edad) {
			this.edad = edad;
		}

		public float getDinero() {
			return dinero;
		}

		public void setDinero(float dinero) {
			this.dinero = dinero;
		}

		@Override
		public String toString() {
			return "Espectador [nombre=\" + nombre + \", edad=\" + edad + \", dinero=\" + dinero + \"]\";";
}
}
