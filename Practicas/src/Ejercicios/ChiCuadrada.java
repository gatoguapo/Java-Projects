package Ejercicios;

import java.text.DecimalFormat;

public class ChiCuadrada {
	private int N, k;
	private int cont01=0, cont02=0,cont03=0,cont04=0,cont05=0,cont06=0,cont07=0,cont08=0,cont09=0,cont10=0;
	private DecimalFormat formato1 = new DecimalFormat("0.00000");
	private DecimalFormat formato2 = new DecimalFormat("0.0");
	private double[] I = new double [] {0.1,0.2,0.3,0.4,0.5,0.6,0.7,0.8,0.9,1.0};
	private int[] O = new int [10];
	double[] OE = new double [10];
	double[] OE2 = new double [10];
	
	public ChiCuadrada (int N) {
		this.N = N;
		this.k = (int) Math.sqrt(N);
	}
	
	private double[] numAlea () {
		double[] numAlea = new double[N];
		double num = 0;
		for (int i=0;i<numAlea.length;i++)
		{
			num = (double) (Math.random());
			numAlea[i] = num;
		}
		return numAlea;
	}
	
	private void intervalos(double num) {
			if(num<=0.1) {
				cont01++;
			} else if (num>0.1 && num<=0.2) {
				cont02++;
			} else if (num>0.2 && num<=0.3) {
				cont03++;
			} else if (num>0.3 && num<=0.4) {
				cont04++;
			} else if (num>0.4 && num<=0.5) {
				cont05++;
			} else if (num>0.5 && num<=0.6) {
				cont06++;
			} else if (num>0.6 && num<=0.7) {
				cont07++;
			} else if (num>0.7 && num<=0.8) {
				cont08++;
			} else if (num>0.8 && num<=0.9) {
				cont09++;
			} else if (num>0.9 && num<=1.0) {
				cont10++;
			} 
	}
	
	public void operaciones () {
		double E=(double)N/k;
		
		for (int i = 0; i<O.length;i++) {	
			O[0]=cont01;
			O[1]=cont02;
			O[2]=cont03;
			O[3]=cont04;
			O[4]=cont05;
			O[5]=cont06;
			O[6]=cont07;
			O[7]=cont08;
			O[8]=cont09;
			O[9]=cont10;

			OE[0]=O[0]-E;
			OE[1]=O[1]-E;
			OE[2]=O[2]-E;
			OE[3]=O[3]-E;
			OE[4]=O[4]-E;
			OE[5]=O[5]-E;
			OE[6]=O[6]-E;
			OE[7]=O[7]-E;
			OE[8]=O[8]-E;
			OE[9]=O[9]-E;
			
			OE2[0]=Math.pow(OE[0], 2)/E;
			OE2[1]=Math.pow(OE[1], 2)/E;
			OE2[2]=Math.pow(OE[2], 2)/E;
			OE2[3]=Math.pow(OE[3], 2)/E;
			OE2[4]=Math.pow(OE[4], 2)/E;
			OE2[5]=Math.pow(OE[5], 2)/E;
			OE2[6]=Math.pow(OE[6], 2)/E;
			OE2[7]=Math.pow(OE[7], 2)/E;
			OE2[8]=Math.pow(OE[8], 2)/E;
			OE2[9]=Math.pow(OE[9], 2)/E;
		}
	}
	
	
	public void tablas () {
		int n=0;
		double E=(double)N/k;
		double[]numAlea = numAlea();
		System.out.println("N    Numeros");
		for (int i=0;i<numAlea.length;i++) {
			n++;
			System.out.println(n+"    "+formato1.format(numAlea[i]));
			intervalos(numAlea[i]);
		}
		System.out.println();
		System.out.println("i     O    E       O-E    (O-E)^2/E");
		for (int i=0;i<I.length;i++) {
			operaciones();
			System.out.println(I[i]+"   "+O[i]+"    "+E+"    "+formato2.format(OE[i])+"      "+formato2.format(OE2[i]));

		}
	}
}
