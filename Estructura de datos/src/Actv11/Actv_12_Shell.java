package Actv11;

import java.util.ArrayList;

public class Actv_12_Shell 
{
	static int cont = 0;
	public ArrayList<Integer> sort(ArrayList<Integer> data, int n) 
	{
		ArrayList<Integer> result =data; //Resultado
		   		if (n==1)
		        {// Caso de salida
		      
		            Evidencia3.Burbuja b= new Evidencia3.Burbuja();
		            result = b.sort(data);
		        } else 
		        {
		            for (int i=0;i<n;i++)
		            {//dividimos en n segmentos 
		                 ArrayList<Integer> aux = new ArrayList<>();
		                for (int j=i;j<data.size();j=j+n)
		                {// tomamos los elementos
		                    aux.add(result.get(j));// lo guardamos en un arreglo auxiliar
		                }
		                Evidencia3.Burbuja b= new Evidencia3.Burbuja();
		                aux = b.sort(aux);//bubble de este arreglo
		                //lo regresamos a sus lugares
		                for (int j=i,index=0;j<data.size();j=j+n,index++){
		                    result.set(j, aux.get(index));
		                    cont++;
		                }
		            }  
		            result = this.sort(result, n-1); //llamada recursiva
		            System.out.println(result);

		        }
		        return result; 
	}
	
	public static void cont ()
	{
		System.out.println("El metodo shell realizo "+cont+" intentos");
	}
}
