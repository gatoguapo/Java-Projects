package Ejercicios;
import java.util.Scanner;
public class ExcepcionesFecha {
	public static void main(String[] args) {
		
		
	}
	public static void CapturaFecha (String F)
		{
		try {
			Scanner leer = new Scanner(System.in);
			String fecha;
			int dd, mm, aaaa,CapturaFecha;
			System.out.println("Este programa captura la fecha que el usuario desea mandar siempre y cuando el dia sea un número entre 1-31, el mes sea un número del 1-12 y el año sea un número del 1930-2029");
			System.out.println("Introduzca el dia:");
			dd=leer.nextInt();
			if (dd < 1 || dd > 31) throw new Exception ("Ingrese un día valido");
			System.out.println("Introduzca el mes:");
			mm=leer.nextInt();
			if (mm < 1 || mm > 12) throw new Exception ("Ingrese un mes valido");
			System.out.println("Introduzca el año:");
			aaaa=leer.nextInt();
			if (aaaa < 1930 || aaaa > 2029) throw new Exception ("Ingrese un año valido");
			CapturaFecha=dd/mm/aaaa;
			fecha=CapturaFecha;
		}catch (Exception e) {
			System.out.println("La fecha que ingreso es: "+fecha);
			System.out.println(e.getMessage());
			}
		}
}
