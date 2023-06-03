package Unidad1;
import java.util.List;
public class Hash_Table
{
    public int M=23; //Tamaño de la lista
    List[] data= new List[M];
    
    public Hash_Table()
    {
    	
    }    

 

   /*
    Definición de la funcion Hash
    @param value y es el valor a encontrar la funcion hash
    @return   este regresa la llave
    */    
    public int hashfunction(int value)
    {
      int result=0;
      result= ((Integer)value% this.M);
      System.out.println((Integer)value% this.M);
      return result;
    }      
    
    
}
