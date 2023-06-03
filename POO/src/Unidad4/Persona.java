package Unidad4;

import java.io.Serializable;

public class Persona implements Serializable {
	 
    private static final long serialVersionUID = 1L;
 
    /**
     * Rellena los campos añadiendo i a unos nombres por defecto
     * 
     * @param i
     *            Un valor para añadir al final de los nombres
     */
    public Persona(int i) {
        setPersona(i);
    }
 
    public String nombre;
    public String apellido;
    public Mascota mascota = new Mascota();
    public int edad;
 
    /**
     * Método para que al meter esta clase en un System.out.println() salga algo
     * legible.
     */
    @Override
    public String toString() {
        return nombre + " " + apellido + " de " + edad + " años tiene como mascota a " + mascota.nombre + " de "
                + mascota.numeroPatas + " patas.";
    }
 
    /**
     * Rellena todos los campos de la clase con nombres por defecto a los que
     * añade el número i.
     * 
     * @param i
     */
    public void setPersona(int i) {
        nombre = "nombre" + i;
        apellido = "apellido" + i;
        mascota.nombre = "Fido" + i;
        mascota.numeroPatas = i;
        edad = i;
 
    }
}
