package Evidencia3;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuEv3 {

	public static void main(String[] args) 
	{
		ArrayList<Integer> lista = new ArrayList<Integer>();

        Scanner teclado=new Scanner(System.in);
       int op1=0;
		Burbuja A = new Burbuja ();
		Selection B = new Selection ();
		Shell C = new Shell ();
		Merge D = new Merge ();
		Quick E = new Quick ();
		Insertion F = new Insertion ();
		
		for (int i=0;i<100-1;i++)
		{
		int data = (int)(Math. random()*100+1);
		lista.add(data);
		}		
		
		do {

	        System.out.println("1 - 100 datos aleatorios.");
	        System.out.println("2 - 100 elementos ordenados en orden inverso.");
	        System.out.println("3 - 100 elementos ordenados.");
	        System.out.println("4 - 100 elementos del 1 al 5.");
	        System.out.println("5 - Salir");

	        op1=Integer.parseInt(teclado.next());


	        switch (op1)
	        {
	            case 1:
	            	A.sort(lista);
	            	B.sort(lista);
	            	C.sort(lista,4);
	            	D.sort(lista);
	            	E.sort(lista,0,4);
	            	F.sort(lista);

	            		break;
	        }
	        } while (op1!=7);

}
}