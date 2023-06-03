package Ejercicios;

public abstract class Figura {
    double base;
    double altura;
    public Figura( double Base, double Altura) {
         base=Base;
         altura=Altura;
    }
    public void mostrarInformacion(){
         System.out.println("La base y altura es: "+base+" y "+altura);
    }
}