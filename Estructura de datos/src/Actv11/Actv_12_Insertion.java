package Actv11;

import java.util.ArrayList;

public class Actv_12_Insertion 
{
	public ArrayList<Integer> sort(ArrayList<Integer> data) 
	{
		int cont = 0;
		ArrayList<Integer> result =new ArrayList<Integer>(); 
		result.add(0,data.get(0));
		for(int i=1;i<data.size();i++)
		{
		int index=0;
		
		while(index<result.size()&&result.get(index)<data.get(i) )
		{
		index++;
		}
		
		result.add(index,data.get(i));
		System.out.println(result);
		cont++;
		}
		System.out.println("El metodo insertion realizo "+cont+" intentos");
		return result;
	}
}
