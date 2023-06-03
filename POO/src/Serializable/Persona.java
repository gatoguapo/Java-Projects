package Serializable;

import java.io.Serializable;

public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
    private String clave;
    private String nombre;
    private int edad;
 
    public Persona() {
    }
 
    public Persona(String clave, String nombre, int edad) {
        this.clave = clave;
        this.nombre = nombre;
        this.edad = edad;
    }
 
    public int getEdad() {
        return edad;
    }
 
    public void setEdad(int edad) {
        this.edad = edad;
    }
 
    public String getClave() {
        return clave;
    }
 
    public void setClave(String clave) {
        this.clave = clave;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
