package Actv11;

import java.util.ArrayList;

public class Menu11 
{
	public static void main(String[] args) 
	{
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for (int i=0;i<25-1;i++)
		{
		int data = (int)(Math. random()*100+1);
		lista.add(data);
		}
		Actividad_11_Burbuja B = new Actividad_11_Burbuja();
		B.sort(lista);
	}

}
