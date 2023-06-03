package Ejercicios;
import java.util.Scanner;

public class MCongruencias 
{
	static Scanner leer = new Scanner (System.in);
	int A=getA(), X=getX(), C=getC(), M=getM(), prim_pte=prim_pte(), residuo = residuo();
	
	public int getA () {
		System.out.println("OJO El valor de A debe de ser un numero entero impar, que no sea divisible entre 3 o 5.");
		System.out.println("Introduzca el valor de A:");
		int A = leer.nextInt();
		if ((A%3)==0 || (A%5)==0) {
			do {
				System.out.println("El valor de A debe de ser un numero entero impar, que no sea divisible entre 3 o 5.");
				System.out.println("Introduzca el valor de A:");
				A = leer.nextInt();
			} while ((A%3)==0 || (A%5)==0);
		}
		return A;
	}
	
	public int getX () {
		int opcion, x = 0;
		boolean control = false;
		do {
			System.out.println("Introduzca el valor de X");
			System.out.println(""
					+ "\n1.-Por teclado."
					+ "\n2.-Aleatorio.");
			opcion = leer.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Introduzca el valor de X");
				x = leer.nextInt();
				control = true;
			break;
			case 2:
				x = (int) (Math.random()*10+1);
				System.out.println("El valor de X es: " +x);
				control = true;
			break;
			}
		} while (control!=true);
		return x;
	}
	
	public int getC () {
		int c;
		System.out.println("El valor de C debe ser un numero que al dividirse entre 200 su residuo debe ser 21");
		System.out.println("Introduzca el valor de C:");
		c = leer.nextInt();
		if (c%200 != 21) {
			do {
				System.out.println("Error, introduzca un numero que al dividirse entre 200 su residuo sea 21:");
				c = leer.nextInt();
			} while (c%200 != 21);
		}
		return c;
	}
	
	public int getM () {
		int opcion, m = 0;
		boolean control = false;
		do {
			System.out.println("Introduzca el valor de M");
			System.out.println(""
					+ "\n1.-Aleatorio."
					+ "\n2.-Numero Primo por teclado.");
			opcion = leer.nextInt();
			switch (opcion) {
			case 2:
				System.out.println("El valor de M debe ser el mayor numero primo posible 2 digitos");
				System.out.println("Introduzca el valor de M:");
				m = leer.nextInt();
				if (m != 97) {
					do {
						System.out.println("Error introduzca el mayor numero posible de 2 digitos:");
						m = leer.nextInt();
					} while (m != 97);
				}
				control = true;
			break;
			case 1:
				m = (int) (Math.random()*10+1);
				System.out.println("El valor de M es: " +m);
				control = true;
			break;
			}
		} while (control!=true);
		return m;
	}
	
	public int prim_pte() {
		int A=getA(),X=getX(),C=getC();
		int prim_pte = A*X+C;
		return prim_pte;
	}
	
	public String seg_pte() {
		int M = getM();
		String seg_pte = Integer.toString(prim_pte()%M);
		return seg_pte;
	}
	
	public int residuo() {
		int M = getM();
		int seg_pte = prim_pte()%M;
		return seg_pte;
	}
	
	public void TablaDeMetodos() {
		int Comparar [] = new int [100];
			
		System.out.println("n\tx\taxn+c\t(axn+c)/m\txn+1");
			for (int i=0;i<100;i++) {
				if (Comparar [i] == X) {
					break;
				}
				Comparar [i] = X;
				System.out.println(i + "\t"+ X+ "\t" +prim_pte+ "\t " +seg_pte() + " % " + residuo + "\t ");
			}
		
	}
}
	
