package Ejercicios;

public class Alumno extends Persona{

	private int nota;
	
	public Alumno () {
		super();
		
		nota = Metodos_Sueltos.generaNumeroAleatorio(0, 10);	
		
		super.setEdad(Metodos_Sueltos.generaNumeroAleatorio(12, 15));
		
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	public void disponibilidad () {
		
		int prob = Metodos_Sueltos.generaNumeroAleatorio(0, 100);
		
		if (prob<50) {
			super.setAsistencia(false);
		} else {
			super.setAsistencia(true);
		}
	}
	
	public String toString () {
		return "Nombre: " +super.getNombre()+ " ,sexo: "+super.getSexo()+" ,nota: "+nota;
	}
	
}
