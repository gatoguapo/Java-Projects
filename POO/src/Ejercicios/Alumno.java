package Ejercicios;

public class Alumno {

	public String NC;
	public String Nombre;
	public String Carrera;
	public Float Promedio;
	
	public Alumno () {

	}
	
	public Alumno(String NC, String Nombre, String Carrera) {
	this.NC=NC;
	this.Nombre=Nombre;
	this.Carrera=Carrera;
	Promedio=(float) 0;
	}
	
	public void ActualizaPromedio (Float P) {
		if (P>0)
		Promedio=P;
	}
	
	public String toString() {
		return "Nombre del alumno: "+Nombre+" Promedio del alumno: "+Promedio;
		}
}
