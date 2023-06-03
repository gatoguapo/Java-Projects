package Unidad4;

import java.io.Serializable;

public class Persona implements Serializable {
	 
    private static final long serialVersionUID = 1L;
 
    /**
     * Rellena los campos a�adiendo i a unos nombres por defecto
     * 
     * @param i
     *            Un valor para a�adir al final de los nombres
     */
    public Persona(int i) {
        setPersona(i);
    }
 
    public String nombre;
    public String apellido;
    public Mascota mascota = new Mascota();
    public int edad;
 
    /**
     * M�todo para que al meter esta clase en un System.out.println() salga algo
     * legible.
     */
    @Override
    public String toString() {
        return nombre + " " + apellido + " de " + edad + " a�os tiene como mascota a " + mascota.nombre + " de "
                + mascota.numeroPatas + " patas.";
    }
 
    /**
     * Rellena todos los campos de la clase con nombres por defecto a los que
     * a�ade el n�mero i.
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
