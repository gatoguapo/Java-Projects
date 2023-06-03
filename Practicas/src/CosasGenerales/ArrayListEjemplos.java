package CosasGenerales;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEjemplos {

	public static void main(String[] args) {

		ArrayList<Empleado> listaEmpleados = new ArrayList<>();
		
		listaEmpleados.ensureCapacity(11);
		
		listaEmpleados.add(new Empleado("Ana", 45, 2500));

		listaEmpleados.add(new Empleado("Chikis", 0, 100000));

		listaEmpleados.add(new Empleado("Polk", 21, 1500));

		listaEmpleados.add(new Empleado("Chule", 11, 1500));
		
			
		System.out.println(listaEmpleados.size());
		
		listaEmpleados.set(0, new Empleado("Ramirez", 20, 2500));
		
		listaEmpleados.trimToSize();
//		
//		Collections.shuffle(listaEmpleados);
		
		for (Empleado e : listaEmpleados) {
			System.out.println(e.getDatos());	
		}
		
		System.out.println();
		System.out.println(listaEmpleados.get(0).getDatos());
		
	}
}

class Empleado {

	private String nombre;

	private int edad;

	private double salario;

	public Empleado(String nombre, int edad, double salario) {
		this.nombre = nombre;
		this.edad = edad;
		this.salario = salario;
	}

	public String getDatos() {
		
		if (salario==1500) {
			return "El empleado " + nombre + " tiene una edad de " + edad + " anios y cuenta con un salario de " + salario + " a la semana,"
					+ " nadie los gana alv";
		} else {
			return "El empleado " + nombre + " tiene una edad de " + edad + " anios y cuenta con un salario de " + salario;
		}
	}

}