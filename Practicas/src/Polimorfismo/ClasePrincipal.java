package Polimorfismo;

public class ClasePrincipal {

	public static void main(String args[]) {
		Polimorfismo_Padre mensajero_suma = new Suma();
		mensajero_suma.PedirDatos();
		mensajero_suma.Operaciones();
		mensajero_suma.MostrarResultado();
		
		Polimorfismo_Padre mensajero_resta = new Resta();
		mensajero_resta.PedirDatos();
		mensajero_resta.Operaciones();
		mensajero_resta.MostrarResultado();
	}
}
