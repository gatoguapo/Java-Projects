package Actv11;

import java.util.ArrayList;

public class Actividad_11_Burbuja
{
	public ArrayList<Integer> sort(ArrayList<Integer> data) 
	{
		int cont=0;
		ArrayList<Integer> result =data; 
		boolean swaped=false;
		
		for (int i = 0; i < result.size()-1; i++) 
		{
			swaped=false;
			for(int j=0; j<result.size()-i-1;j++)
			{                         
				Integer pos = result.get(j);
				Integer next = result.get(j+1);
				if(pos>next)
				{
					result.set(j, next);
					result.set(j+1,pos);
					swaped=true;
				}
				System.out.println(result);
				cont          ++;
			}
			if(!swaped)
			{
			break;
			}                       
		}
		System.out.println("El metodo burbuja realizo "+cont+" intentos.");
		return data;
		
	}
	
}
