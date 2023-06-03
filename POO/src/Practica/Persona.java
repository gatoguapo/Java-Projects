package Practica;

import java.util.Random;

public class Persona {
private String DNI,Nom;
private int Edad;
private char Sexo;
private int Altura;
private int Peso;
public static final char HOMBRE = 'H', MUJER = 'M';
public static final byte BAJOPESO = -1, ENPESO = 0, SOBREPESO = 1;

public Persona () {
	this("",0,'H',0,0);
}
public Persona (String Nom,int Edad, char Sexo) {
	this(Nom,Edad,Sexo,0,0);
}

public Persona (String Nom, int Edad, char Sexo, int Altura, int Peso) {
	this.Nom = Nom;
	this.Edad = Edad;
	this.DNI = generaDNI();
	this.Sexo = Sexo;
	this.Altura = Altura;
	this.Peso = Peso;
}

public double calcularIMC () {
	double IMC = (Peso/(Math.pow(Altura,2)));
	if (IMC<20) IMC=BAJOPESO;
	if (IMC>=20 && IMC<=25) IMC=ENPESO;
	if (IMC>25) IMC = SOBREPESO;
	return IMC;
}

public boolean mayorDeEdad () {
	boolean Mayor=false;
	if (Edad>=18) Mayor=true;
	return Mayor;
}

public void comprobarSexo (char Sexo) {
	switch (Sexo) {
	case 'm':
	case 'M':
		this.Sexo = MUJER; // 'M'
		break;
	default:	
		this.Sexo = HOMBRE; // 'H'
	}
}

public String generaDNI () {
	String dni="";
	Random r = new Random();
	for(int i=0;i<9;i++)	
		dni+=r.nextInt(10);			
	return dni;
}
}
