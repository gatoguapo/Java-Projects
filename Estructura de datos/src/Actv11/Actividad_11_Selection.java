package Actv11;

import java.util.ArrayList;

public class Actividad_11_Selection 
{
	public ArrayList<Integer> sort(ArrayList<Integer> data) 
	  {
		int cont=0;
	        ArrayList<Integer> result =data; //Resultdo
	        for(int i=0; i<result.size()-1;i++)
	        { //se hacen n-1 iteraciones
	            Integer pos = result.get(i);//se obtiene el m�nimo supuesto
	            for (int j=i+1;j<result.size();j++)
	            {//compara desde la posici�n i 
	                //hasta el fin del arreglo
	                Integer next = result.get(j);
	                if(pos>next){//en caso de ser mayor se intercambia
	                    result.set(i, next);
	                    result.set(j, pos);                   
	                    pos=next;
	                }
	                cont++;
	                System.out.println(result);
	            }
	        }
    		System.out.println("El metodo selection realizo "+cont+" intentos.");
	        return result;
	    }


}
