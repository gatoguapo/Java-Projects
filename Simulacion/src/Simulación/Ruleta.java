package Simulación;

public class Ruleta {
	static String col, Resultado = WinLose();
	static double num;
	
	public static void Tablero () {
		String color = "";	
		for (int i = 0; i<=1000;i++) {
		double numero = (double)(Math.random());
		String str = Double.toString(numero);
		if (numero <= 0.45d) {
			color = "rojo";
			num = numero;
			col = color;
		}
		if (numero > 0.45d && numero <= 0.90d) {
			color = "negro";	
			num = numero;
			col = color;
		}
		else {
			color = "verde";
			num = numero;
			col = color;
		}
		}
	}
	
	public static String WinLose () {
		String Resultado = "";
		if (col == "rojo") {
			Resultado = "Si";
			return Resultado;
		}
		if (col == "negro") {
			Resultado = "No";
			return Resultado;
		}
		if (col == "verde") {
			Resultado = "Nulo";
			return Resultado;
		}
		return Resultado;
	}
	
	public static void Estrategias () {
		int Antes = 200, Despues = 0, Apuesta = 1;
		if (Resultado == "Si") {
			Despues = Antes + Apuesta;
			Antes = Despues;
		}
		if (Resultado == "No") {
			Despues = Antes - Apuesta;
			Antes = Despues;
		}
		if (Resultado == "Nulo") {
			Tablero();
		}
	}
	
	public static void Tabla () {
		int iteracion = 1, Antes = 200, Despues = 0, Apuesta = 1;
		
		System.out.println("iteracion " +  " $ antes de girar " +  " #alea " + " color " + " gano? " +" $ despues de girar ");
		do {
		
		if (Resultado == "Si") {
			Despues = Antes + Apuesta;
			Antes = Despues;
		}
		if (Resultado == "No") {
			Despues = Antes - Apuesta;
			Antes = Despues;
		}
		if (Resultado == "Nulo") {
			Tablero();
		}
		System.out.println( iteracion + "\t\t" +  Antes + "\t\t" +  num + "\t" + col + "\t" + Resultado + "\t" + Despues );
		
		iteracion ++;
		} while (Despues <=1000);
	}
}
