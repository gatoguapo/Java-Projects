package Ejercicios;

public class Cine {

	private Pelicula peli;
	private float precio;
	private Butaca butacas[][];

	public Cine(Pelicula peli, float precio) {
		this.peli = peli;
		this.precio = precio;
		butacas = new Butaca[8][9];
	}

	public Pelicula getPeli() {
		return peli;
	}

	public void setPeli(Pelicula peli) {
		this.peli = peli;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Cine [peli=" + peli + ", precio=" + precio + "]";
	}

	public Butaca getButaca(int fila, int col) {
		return butacas[fila][col];
	}

	public void setButaca(int fila, int col, Butaca b) {
		butacas[fila][col] = b;
	}

	public boolean isButacaOcupada(int fila, int col) {
		return butacas[fila][col].isOcupada();
	}

	public void OcupaButaca(int fila, int col) {
		butacas[fila][col].setOcupada(true);
	}

	public void DesocupaButaca(int fila, int col) {
		butacas[fila][col].setOcupada(false);
	}
}
