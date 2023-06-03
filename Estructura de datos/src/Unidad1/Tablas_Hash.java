package Unidad1;

import java.util.Hashtable;

public class Tablas_Hash 
{
    public static void main(String[] args)
    {
       Hashtable<String,Integer> numeros = new Hashtable<String,Integer>();
       numeros.put("one", 1);
       numeros.put("numero dos",2);
       numeros.put("tres",3);
       System.out.println("La tabla esta vacia? "+ numeros.isEmpty());
       System.out.println("El tamaño de la tabla es: "+ numeros.size());
       System.out.println("Tabla : "+ numeros );

       
       //* Hash_Table otrosnumeros=new Hash_Table(); System.out.println("El valor de retorno es? "+ otrosnumeros.hashfunction(3)); //*
    }
    
}
