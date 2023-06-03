package Ejercicios;

import java.util.Scanner;

public class AppPersona {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		System.out.print("Cuantas personas se van a capturar: ");
		int num = leer.nextInt();
		Persona[] grupo = new Persona[num];

		for (int i = 0; i < num; i++) {
			System.out.println("Datos de la persona " + (i + 1));
			System.out.print("Nombre: ");
			String nom = leer.next();
			System.out.print("Edad: ");
			byte edad = leer.nextByte();
			System.out.print("Sexo: ");
			char sexo = leer.next().charAt(0);
			System.out.print("Peso: ");
			float peso = leer.nextFloat();
			System.out.print("Altura: ");
			float altura = leer.nextFloat();

			grupo[i] = new Persona(nom, edad, sexo, peso, altura);
		}

		for (int i = 0; i < num; i++) {
			System.out.println(ChecaPeso(grupo[i]));
		}

		for (int i = 0; i < num; i++) {
			System.out.println(grupo[i]);
			if (grupo[i].esMayorDeEdad())
				System.out.println(grupo[i].getNombre() + " es mayor de edad");
		}

		leer.close();
	}

	public static String ChecaPeso(Persona p) {
		switch (p.calcularIMC()) {
		case Persona.BAJOPESO:
			return p.getNombre() + " esta por abajo de su peso ideal.";
		case Persona.ENPESO:
			return p.getNombre() + " esta en su peso ideal.";
		case Persona.SOBREPESO:
			return p.getNombre() + " esta por arriba de su peso ideal.";
		}
		return "Dato invalido";
	}

}
