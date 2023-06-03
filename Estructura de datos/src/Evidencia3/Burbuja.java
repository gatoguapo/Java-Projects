package Evidencia3;

import java.util.ArrayList;
import java.util.Scanner;

public class Burbuja
{
	public ArrayList<Integer> sort(ArrayList<Integer> data) {
		int cont=0;
		ArrayList<Integer> result =data; //Resultado
		boolean swaped=false; //Variable en caso de que no haya intercambio

		for (int i = 0; i < result.size()-1; i++) { //desde 0 a n-1 iteraciones
		swaped=false;
		for(int j=0; j<result.size()-i-1;j++){ //desde 0 a n-iteraciones - 1                         
		//obtenemos los valores
		Integer pos = result.get(j);
		Integer next = result.get(j+1);
		//si la pos es mayor que el siguiente intercambia
		if(pos>next){

		result.set(j, next);
		result.set(j+1,pos);
		swaped=true;
		}
		System.out.println(result);
		cont++;

		}
		if(!swaped){//si no hubo intercambio se acaba el método
		break;
		}                       
		}
		return data;

		}
 }

