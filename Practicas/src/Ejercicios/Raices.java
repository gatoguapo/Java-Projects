package Ejercicios;

public class Raices {
	
	private double a, b, c;
	
	public Raices (double a, double b , double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	private void obtenerRaices() {
		
		double x1 =(-b+Math.sqrt(getDiscriminante()))/(2*a); 
		double x2 =(-b-Math.sqrt(getDiscriminante()))/(2*a);
		
		System.out.println("Solucion X1");
		System.out.println(x1);
		
		System.out.println("Solucion X2");
		System.out.println(x2);
	}
	
	private void obtenerRaiz() {
		
		@SuppressWarnings("unused")
		double x = 0;
		
		System.out.println("Solucion unica");
		System.out.println(x=(-b)/(2*a));

	}
	
	private double getDiscriminante() {
		return Math.pow(b, 2) - (4*a*c);
	}
	
	private boolean tieneRaices() {
		return getDiscriminante()>0;
	}
	
	private boolean tieneRaiz() {
		return getDiscriminante()==0;
	}
	
	public void calcular() {
		if (this.tieneRaices()) {
			this.obtenerRaices();
		} else if (this.tieneRaiz()) {
			this.obtenerRaiz();
		} else	{
			System.out.println("No tiene raiz");
		}
	}
}
