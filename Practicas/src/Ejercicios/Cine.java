package Ejercicios;

public class Cine {
	
	private Asiento asientos[][];
	private double precio;
	private Pelicula pelicula;
	
	public Cine (int filas, int columnas, double precio, Pelicula pelicula) {
		asientos = new Asiento[filas][columnas];
		this.precio = precio;
		this.pelicula = pelicula;
		rellenaButacas();
	}

	public Asiento[][] getAsientos() {
		return asientos;
	}

	public void setAsientos(Asiento[][] asientos) {
		this.asientos = asientos;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	public void rellenaButacas () {
		
		int fila = asientos.length;
		
		for (int i=0;i<asientos.length;i++) {
			for (int j=0;j<asientos.length;j++) {
				
				asientos [i][j] = new Asiento((char) ('A'+j),fila);
			}
			
			fila--;
			
		}
	}
	
	public boolean haySitio () {
		
		boolean haySitio = false;
		for (int i=0;i<asientos.length && !haySitio;i++) {
			for (int j=0;j<asientos.length && !haySitio;j++) {
				
				if (!asientos[i][j].ocupado()) {
					haySitio=true;
				}
				
			}
			
		}
		return haySitio;
	}
	
	public boolean haySitioButaca (int fila, char columna) {
		return asientos[asientos.length-fila][columna-'A'].ocupado();
	}
	
	public boolean tieneEdad (Asiento asiento) {
		if (asiento.ocupado()) {
			if (pelicula.getEdadMin() asiento.)
		}
	}
}
