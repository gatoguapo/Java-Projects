package Unidad1;
import java.util.Scanner;

public class EcuacionMenu 
{	
	public static void main(String[] args) throws Exception 
	{
		Scanner Leer = new Scanner(System.in);
		int opc;
		boolean Salir=false;
		Ecuacion EcuacionA = new Ecuacion ();
		
		while (!Salir)
		{
		System.out.println("1.-Agregar una ecuaci�n infija");
		System.out.println("2.-Mostrar Ecuaci�n postfija");
		System.out.println("3.-Salir");
		System.out.println("Elija una opcion: ");
		opc = Leer.nextInt();
				
		switch (opc) {
		case 1:
			System.out.println("Agrega el primer n�mero: ");
			EcuacionA.InsertarOperando(Leer.nextInt());	
			System.out.println("Agrega el operador: ");
			EcuacionA.InsertarOperador(Leer.next());
			System.out.println("Agrega el segundo n�mero: ");
			EcuacionA.InsertarOperando(Leer.nextInt());	
		break;
		case 2:
			System.out.println("La operaci�n en postfijo es: ");
			EcuacionA.Postfija();
			System.out.println();
		break;
		case 3:
			Salir = true;
		break;
			default:
				System.out.println("N�mero invalido, intentelo otra vez: ");
		break;
			
		}
		}
		
	}

}
