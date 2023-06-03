package Burbuja;

import java.util.ArrayList;

public class Merge 
{
	public ArrayList<Integer> sort(ArrayList<Integer> data) {
        ArrayList<Integer> result =data; //Resultado
        //caso de salida
        if (result.size()==1){ 
            result =data;
        } else {//caso recursivo
            ArrayList<Integer> parcial1= new ArrayList<Integer>(),
            parcial2= new ArrayList<Integer>();
             int j=0;
            //Separar el arreglo en 2 iguales
            for (int i=0;i<(int)(result.size()/2);i++){
                parcial1.add(result.get(i));
                j++;
            }
            for(int i=j;i<(result.size());i++){
                parcial2.add(result.get(i));
            }
            //Unir el ordenamiento de los 2 parciales
            result  = this.union(this.sort(parcial1), this.sort(parcial2));
        }
        System.out.println(result);
        return result;
    }

	public ArrayList<Integer> union(ArrayList<Integer> p1,ArrayList<Integer> p2) 
	{
		ArrayList<Integer> result = new ArrayList<>();
		int index1=0,index2=0;
		int maxIndex1=p1!=null?p1.size():0,maxIndex2=p2!=null?p2.size():0;
		        while(index1<maxIndex1 ||index2<maxIndex2 )
		        {
		            //si ya no hay en el arreglo 1
		           if (index1==maxIndex1)
		           {
		                //agrego en el resultado del arreglo2
		                result.add(p2.get(index2++));
		           } else if (index2==maxIndex2)
		           {
		                //ya no hay en el arreglo 2 pero si en el 1
		                result.add(p1.get(index1++));
		           } else 
		           {
		                //hay en los 2 agrego el más pequeño
		               result.add( (p1.get(index1)<p2.get(index2))?
		                                     p1.get(index1++):p2.get(index2++)); 
		           }
		        }
		        return result;
	}	
}

