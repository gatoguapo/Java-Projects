package Recursion;

public class Recursiva 
{
	public long factorial(long n)
	{
		long result=1;
		if (n<=1) {
			result=1;}
		else {
			result = n*factorial(n-1);}
		return result;
	}
	
	public boolean esPar (int n)
	{
		if (n==0)	
			return true;
		else 
			return esImpar(n-1);
	}
	
	public boolean esImpar (int n)
	{
		if (n==0)	
			return false;
		else 
			return esPar(n-1);
	}

}
