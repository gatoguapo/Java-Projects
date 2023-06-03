package TopicosKaty;

public class MetodoYield implements Runnable {

	private String mensaje,nombre;
	
	public MetodoYield(String nombre) {
		this.nombre = nombre;
	}

	public void run() {
		mensaje = "Hola, soy " + nombre + " y este es mi mensaje numero: ";
		
		for (int i = 1; i < 6; i++) {
			String msj = mensaje + i;
			System.out.println(msj);
		}

	}
}
