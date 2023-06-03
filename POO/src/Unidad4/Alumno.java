package Unidad4;

public class Alumno {
	public static final int TAMANIO = 304;
	private String nombre;
	private String licenciatura;
	private int edad;
	private String matricula;

	public Alumno() {
		this(null, null, 0, null);
	}

	public Alumno(String nombre, String licenciatura, int edad, String matricula) {
		this.nombre = nombre;
		this.licenciatura = licenciatura;
		this.edad = edad;
		this.matricula = matricula;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLicenciatura() {
		return licenciatura;
	}

	public void setLicenciatura(String licenciatura) {
		this.licenciatura = licenciatura;
	}

	@Override
	public String toString() {
		String mensaje = "";
		mensaje = this.nombre + "\n" + this.licenciatura + "\n" + this.matricula + "\n" + this.edad;
		return mensaje;
	}
}