package Actv11;

import java.util.ArrayList;

public class Menu12 
{
	public static void main(String[] args) 
	{
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for (int i=0;i<590-1;i++)
		{
		int data = (int)(Math. random()*590+1);
		lista.add(data);
		}
		Actv_12_Insertion B = new Actv_12_Insertion();
		B.sort(lista);
		Actv_12_Shell I = new Actv_12_Shell();
		I.sort(lista, 4);
	}

}
