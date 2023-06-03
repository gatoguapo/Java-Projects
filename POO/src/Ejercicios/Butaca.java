package Ejercicios;

public class Butaca {

	private boolean Ocupada;
	private Espectador espec;

	public Butaca(Espectador espec) {
		Ocupada = true;
		this.espec = espec;
	}

	public boolean isOcupada() {
		return Ocupada;
	}

	public void setOcupada(boolean ocupada) {
		Ocupada = ocupada;
	}

	public Espectador getEspec() {
		return espec;
	}

	public void setEspec(Espectador espec) {
		this.espec = espec;
	}

	@Override
	public String toString() {
		return "Butaca [Ocupada=" + Ocupada + ", espec=" + espec + "]";
	}

}
