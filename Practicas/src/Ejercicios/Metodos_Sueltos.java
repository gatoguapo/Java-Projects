package Ejercicios;

public class Metodos_Sueltos {
	
	public static int generaNumeroAleatorio (int minimo, int maximo) {
		
		int num=(int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
		return num;
	}
}
