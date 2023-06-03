package Simulación;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class RandomNum {

	static Scanner sc = new Scanner(System.in);
	static DecimalFormat formato1 = new DecimalFormat("0.000");
	
	public static void main(String[] args) {
		menu();
	}

	static void menu() {
		int option;
		boolean control = true;

		do {
			System.out.print("\tMenu\n"
					+ "\n1.- Digite la semilla."
					+ "\n2.- Genera la semilla."
					+ "\n3.- Salir."
					+ "\n\nOPCION: ");
			option = sc.nextInt();

			switch (option) {
			case 1:
				int seed1 = getSeed();
				process(seed1);
				break;
			case 2:  
				int seed2 = generateSeed();
				process(seed2);
				break;
			case 3:
				control = false;
				break;
			default:
				System.out.println("ERROR, ingrese una de las opciones.");
				break;
			}

		}while(control);
	}
	
	static int getSeed() {
		System.out.println("Digite la semilla");
		int seed = sc.nextInt();
		return seed;
	}
	
	static int generateSeed() {
		return (int)((Math.random() * (100 - 999) + 999));
	}
	
	static void process(int seed) {
		String internNumInString = "";
		int internNum = 0;
		boolean finish = false;
		int cont = 0;
		int nextSeed = 0;
		int quadraticSeed = 0;
		ArrayList<Integer> results = new ArrayList<>();
		String seedInString = "";
		double media = 0;
		double standardDeviation = 0;
		
		System.out.println("n\tSemilla\t\tSemilla al cuadrado\tNumero interno\tSiguiente numero");
		
		do {
			quadraticSeed =  seed * seed;
			seedInString = Integer.toString(quadraticSeed);
			
			if (seedInString.length() == 5 ) {
				internNumInString = seedInString.substring(1,4);
				internNum = Integer.parseInt(internNumInString);
				nextSeed = internNum;
			}
			
			if (seedInString.length() == 6 ) {
				internNumInString = seedInString.substring(1,5);
				internNum = Integer.parseInt(internNumInString);
				
				internNumInString = seedInString.substring(1,4);
				nextSeed = Integer.parseInt(internNumInString);
			}
			
			System.out.println((cont + "\t") + (seed + "\t\t") + (quadraticSeed + "\t\t\t") + (internNum + "\t\t") + (nextSeed));
			
			if (nextSeed == 0) finish = true;
			
			if (nextSeed < 100) finish = true;
			
			for (int i=0; i < results.size(); i++) {
				if (nextSeed == results.get(i)) {
					finish = true;
				}
			} 
			
			seed = nextSeed;
			results.add(seed);
			cont++;
			
		} while (finish == false);
	
		media = getMedia(results);
		standardDeviation = getStandardDeviation(results, media);
		
		System.out.println();
		System.out.println("La media es: " + formato1.format(media));
		System.out.println("La desviación estandar es: " + formato1.format(standardDeviation));
		System.out.println();
	}
	
    static double getMedia (ArrayList<Integer> numbers) {
        double result = 0;
        
        for (int i = 0; i < numbers.size(); i++) {
            result = result + numbers.get(i);
        }
        
        return  result / numbers.size();
    }
    
    static double getStandardDeviation(ArrayList<Integer> numbers, double media) {
    	double auxiliar = 0;
    	double summation = 0;
    	double division = 0;

    	for (int i = 0; i < numbers.size(); i++) {
            auxiliar = numbers.get(i) - media;
            summation = summation + Math.pow(auxiliar, 2);
        }
    	
    	division = summation / (numbers.size() - 1);
    	
    	return Math.sqrt(division);
    }
}