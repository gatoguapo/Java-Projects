package Ejercicios;
public class Ejericicios
{
	public String ChecaSigno(int num) 
	{			
		if (num > 0)return "Positivo";
		if (num < 0)return "Negativo";
		return "Cero";
	}
	public String ChecaMayor(int num)
	{
		int May=0;
		if (num>May) return "Es Mayor";
		return "Es Menor";
	}
	public int MayorTres(int num[])
	{
		int May=0, GuardaMay=0;
		for (int i=0;i<num.length;i++)
		{
		if (num[i]>May) GuardaMay=num[i];
		}
		return GuardaMay;
	}	
	public double CostoVehiculo(int V)
	{
		double CostoTotal=0;
		CostoTotal+=CostoTotal*0.12;
		CostoTotal+=CostoTotal*0.06;	
		return CostoTotal;
	}
	public int NumeroReal (int N)
	{
		int NumeroReal=0;
		for (int i=0;i<N;i++)
		{
			NumeroReal+=i;			
		}
		return NumeroReal;
	}
	public int NumeroFactorial (int N)
	{
		int Factorial=0;
		for (int i=N;i>N;i--)
		{
			Factorial += Factorial *i;
		}
		return Factorial;
	}
	public static float SueldoAumentado (float sueldo)
	{
		float SueldoFinal=0;
		if(sueldo<9000) {SueldoFinal=(float) (sueldo*1.20);}
		if(sueldo>9000 && sueldo<=13000) {SueldoFinal=(float) (sueldo*1.17);}
		if(sueldo>13000 && sueldo<=18000) {SueldoFinal=(float) (sueldo*1.12);}
		if(sueldo>18000) {SueldoFinal=(float) (sueldo*1.06);}
		return SueldoFinal;
	}
}
