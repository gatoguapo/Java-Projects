package Busqueda_Bin;

import java.util.List;

public class Lista_Bin 
{
	int Lista [];
	
	public void Lista_Bin(int tam)
	{
		Lista = new int[tam];
	}
	
	public void llenado()
	{
		for (int i=0;i<Lista.length;i++)
		{
			Lista[i]=i;
		}
	}
	public boolean Busq_Bin(int [] L, int ini,int fin,int dato)
	{
		if (L.length==1)
		{
			if (L[ini-1]==dato)
				return true;	
			else
				return false;
		}
		else if (dato>=L[(ini+fin)/2])
		{
			Busq_Bin(L,(ini+fin/2)+1,fin,dato);}
		else if (dato<=(ini+fin)/2)
		{
			Busq_Bin(L,0,(ini+fin/2),dato);}
				return false;
	}
}
