package Ejercicios;

import java.util.Random;

public class Persona {

	private String id, nombre;
	private byte edad;
	private char sexo;
	private float peso, altura;
	public static final char HOMBRE = 'H', MUJER = 'M';
	public static final byte BAJOPESO = -1, ENPESO = 0, SOBREPESO = 1;

	public Persona() {
		this("", (byte) 0, HOMBRE, 0, 0);
	}

	public Persona(String nombre, byte edad, char sexo) {
		this(nombre, edad, sexo, 0, 0);
	}

	public Persona(String nombre, byte edad, char sexo, float peso, float altura) {
		this.id = generaID();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		comprobarSexo(sexo);
	}

	private String generaID() {
		Random r = new Random();
		String cad = "";
		for (int i = 0; i < 9; i++)
			cad += r.nextInt(10);
		return cad;
	}

	/*
	 * calcularIMC(): calculara si la persona esta en su peso ideal (peso en
	 * kg/(altura^2 en m)), si esta fórmula devuelve un valor menor que 20, la
	 * función devuelve un -1, si devuelve un número entre 20 y 25 (incluidos),
	 * significa que esta por debajo de su peso ideal la función devuelve un 0 y si
	 * devuelve un valor mayor que 25 significa que tiene sobrepeso, la función
	 * devuelve un 1. Te recomiendo que uses constantes para devolver estos valores.
	 */
	public byte calcularIMC() {
		double imc = peso / Math.pow(altura, 2);
		if (imc < 20)
			return BAJOPESO; // -1
		if (imc > 25)
			return SOBREPESO; // 1
		return ENPESO; // 0
	}

	/*
	 * esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
	 * 
	 */
	public boolean esMayorDeEdad() {
		return edad >= 18;
	}

	/*
	 * comprobarSexo(char sexo): comprueba que el sexo introducido es correcto. Si
	 * no es correcto, sera H. No sera visible al exterior.
	 */

	private void comprobarSexo(char sexo) {
		switch (sexo) {
		case 'm':
		case 'M':
			this.sexo = MUJER; // 'M'
			break;
		default:
			this.sexo = HOMBRE; // 'H'
		}
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", sexo=" + sexo + ", peso=" + peso
				+ ", altura=" + altura + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public String getId() {
		return id;
	}
	
}
