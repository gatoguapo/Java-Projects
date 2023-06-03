package Ejercicios;

public class Triangulo extends Figura{

	public Triangulo(double Base, double Altura) {
		super(base, altura);
	}
	
	public void mostrarInformacion(){
        System.out.println("La base y altura del triangulo es: "+base+" y "+altura);
   }

}
