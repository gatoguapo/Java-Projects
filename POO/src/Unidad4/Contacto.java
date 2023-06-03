package Unidad4;

import java.io.Serializable;

public class Contacto implements Serializable{

	private int Clave;
	private String Nombre;
	private String Telefono;
	private String Correo;
	private String Direccion;
	
	public Contacto() {
		this(0, null, null, null, null);
	}

	public Contacto(int clave, String nombre, String telefono, String correo, String direccion) {
		super();
		Clave = clave;
		Nombre = nombre;
		Telefono = telefono;
		Correo = correo;
		Direccion = direccion;
	}
	
	public int getClave() {
		return Clave;
	}
	public String getNombre() {
		return Nombre;
	}
	public String getTelefono() {
		return Telefono;
	}
	public String getCorreo() {
		return Correo;
	}
	public String getDireccion() {
		return Direccion;
	}
	
	public void setClave(int clave) {
		Clave = clave;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	@Override
	public String toString() {
		return Clave + " | " + Nombre + " | " + Telefono + " | " + Correo + " | " + Direccion;
	}
}

