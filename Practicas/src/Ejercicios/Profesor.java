package Ejercicios;

public class Profesor extends Persona{
	
	private String materia;
	
	public Profesor () {
		super();
		
		super.setEdad(Metodos_Sueltos.generaNumeroAleatorio(25, 40));
		
		materia = Constantes.MATERIAS[Metodos_Sueltos.generaNumeroAleatorio(0, 2)];
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}
	
public void disponibilidad () {
		
		int prob = Metodos_Sueltos.generaNumeroAleatorio(0, 100);
		
		if (prob<20) {
			super.setAsistencia(false);
		} else {
			super.setAsistencia(true);
		}
	}
}
