package Evidencia3;

import java.util.ArrayList;

import Evidencia3.Burbuja;

public class Shell 
{
	public ArrayList<Integer> sort(ArrayList<Integer> data, int n) 
	{
		int cont=0;
		ArrayList<Integer> result =data; //Resultado
		   		if (n==1)
		        {// Caso de salida
		      
		            Burbuja b= new Burbuja();
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
		                Burbuja b= new Burbuja();
		                aux = b.sort(aux);//bubble de este arreglo
		                //lo regresamos a sus lugares
		                for (int j=i,index=0;j<data.size();j=j+n,index++){
		                    result.set(j, aux.get(index));                   
		                }
		            }  
		            result = this.sort(result, n-1); //llamada recursiva
		        }
		         System.out.println(result);
		         cont++;
			 		System.out.println("El metodo Shell realizo "+cont+" intentos.");

		        return result; 

		    }
}
