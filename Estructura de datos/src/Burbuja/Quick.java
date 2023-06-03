package Burbuja;

import java.util.ArrayList;

public class Quick 
{
	 public ArrayList<Integer> sort(ArrayList<Integer> data, int l1, int l2) {
	        ArrayList<Integer> result =data; //Resultado
	        int l1aux=l1, l2aux=l2;
	        if (l1>=l2){
	            result =data;
	        }else {
	            int delta =-1;
	            do{//repite el ciclo
	                //En caso de que se tenga que cambiar.
	                //Se multiplica por delta para saber el sentido de la
	                //comparación
	                if (data.get(l1aux)*delta<delta*data.get(l2aux)){
	                    Integer aux = data.get(l1aux); //intercambia
	                    data.set(l1aux, data.get(l2aux));
	                    data.set(l2aux, aux);
	                    aux = l1aux;//intercambia
	                    l1aux= l2aux;
	                    l2aux= aux;
	                    delta *=-1;//cambia el sentido
	                }
	                l2aux +=delta;
	            }while(l1aux!=l2aux);
	            System.out.println(result);
	            result = sort(data,l1,l1aux-1);//Ordena la parte menor.
	            result = sort(data,l1aux+1,l2);//Ordena la parte mayor.
	        }
	        System.out.println(result);
	        return result;
	    }
}
