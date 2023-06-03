package Fibonacci;

public class Fibonacci 
{
	public static long fibonacci(long n){
        long result=1; //Contador
        if (n <= 1){ //Caso de salida
            result = 1;
        }else {
            //caso recursivo
            result = fibonacci(n-1) + fibonacci(n-2); 
        }
        return result;
    }

}
