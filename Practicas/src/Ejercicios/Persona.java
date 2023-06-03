package Ejercicios;

public abstract class Persona {

	private String nombre;
	private char sexo;
	private int edad;
	private boolean asistencia;
	
	private final String[] NOMBRES_CHICOS = {"Pepe", "Fernando",  "Alberto", "Nacho", "Eustaquio"};
	private final String[] NOMBRES_CHICAS = {"Maria", "Sofia",  "Fernanda", "Jimena", "Sara"};
	
	public Persona () {
		
		int determinar_sexo=Metodos_Sueltos.generaNumeroAleatorio(0,1);
		
		if (determinar_sexo == 0) {
			nombre = NOMBRES_CHICOS [Metodos_Sueltos.generaNumeroAleatorio(0, 4)];
			sexo = 'H';
		} else {
			nombre = NOMBRES_CHICAS [Metodos_Sueltos.generaNumeroAleatorio(0, 4)];
			sexo = 'M';
		}
		disponibilidad();
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public abstract void disponibilidad ();

	public boolean isAsistencia() {
		return asistencia;
	}

	public void setAsistencia(boolean asistencia) {
		this.asistencia = asistencia;
	}
		
	
}
