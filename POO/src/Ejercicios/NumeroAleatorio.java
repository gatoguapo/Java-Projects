package Ejercicios;

public class NumeroAleatorio {

	public static void main(String[] args) throws Exception {
		
		int RandomNum=0;	
		
		for (int i=0;i<10;i++)
		{try {
			RandomNum=(int) (Math.random()*100);
			if (RandomNum % 2 == 0) 
			throw new Exception("Es un n�mero par");
			if (RandomNum % 2 != 0) 
			throw new Exception("Es un n�mero impar");	
		} 
		catch (Exception e) {
		System.out.println("El n�mero aleatorio es: "+RandomNum);
		System.out.println(e.getMessage());
		}
		}
		
		
	}

}
