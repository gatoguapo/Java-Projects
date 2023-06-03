package Actv11;

import java.util.ArrayList;

public class MenuEvi3 
{
	public static void main(String[] args) 
	{
	ArrayList<Integer> lista = new ArrayList<Integer>();
	for (int i=0;i<100-1;i++)
	{
	int data_normal = (int)(Math. random()*100+1);
	lista.add(data_normal);
	}
	Actividad_11_Burbuja A1 = new Actividad_11_Burbuja();
	A1.sort(lista);
	Actividad_11_Selection A2 = new Actividad_11_Selection();
	A2.sort(lista);
	Actv_12_Insertion A3 = new Actv_12_Insertion();
	A3.sort(lista);
	Actv_12_Shell A4 = new Actv_12_Shell();
	A4.sort(lista,4);
	A4.cont();
	Actv_13_Merge A5 = new Actv_13_Merge();
	A5.sort(lista);
	A5.contador();
	Actv_13_Quick A6 = new Actv_13_Quick();
	A6.sort(lista,0,98);
	A6.contador();
	
	ArrayList<Integer> lista1 = new ArrayList<Integer>();
	for (int i=100-1;i>0;i--)
	{
	int data_INVERTIDA = (int)(Math. random()*100+1);
	lista1.add(data_INVERTIDA);
	}
	Actividad_11_Burbuja B1 = new Actividad_11_Burbuja();
	B1.sort(lista1);
	Actividad_11_Selection B2 = new Actividad_11_Selection();
	B2.sort(lista1);
	Actv_12_Insertion B3 = new Actv_12_Insertion();
	B3.sort(lista1);
	Actv_12_Shell B4 = new Actv_12_Shell();
	B4.sort(lista1,4);
	B4.cont();
	Actv_13_Merge B5 = new Actv_13_Merge();
	B5.sort(lista1);
	B5.contador();
	Actv_13_Quick B6 = new Actv_13_Quick();
	B6.sort(lista1,0,98);
	B6.contador();
	
	ArrayList<Integer> lista2 = new ArrayList<Integer>();
	for (int i=0-1;i<100-1;i++)
	{
	lista2.add(i);
	}
	Actividad_11_Burbuja C1 = new Actividad_11_Burbuja();
	C1.sort(lista2);
	Actividad_11_Selection C2 = new Actividad_11_Selection();
	C2.sort(lista2);
	Actv_12_Insertion C3 = new Actv_12_Insertion();
	C3.sort(lista2);
	Actv_12_Shell C4 = new Actv_12_Shell();
	C4.sort(lista2,4);
	C4.cont();
	Actv_13_Merge C5 = new Actv_13_Merge();
	C5.sort(lista2);
	C5.contador();
	Actv_13_Quick C6 = new Actv_13_Quick();
	C6.sort(lista2,0,98);
	C6.contador();
	
	ArrayList<Integer> lista3 = new ArrayList<Integer>();
	for (int i=100-1;i>0;i--)
	{
	int data_1a5 = (int)(Math. random()*5+1);
	lista3.add(data_1a5);
	}
	Actividad_11_Burbuja D1 = new Actividad_11_Burbuja();
	D1.sort(lista3);
	Actividad_11_Selection D2 = new Actividad_11_Selection();
	D2.sort(lista3);
	Actv_12_Insertion D3 = new Actv_12_Insertion();
	D3.sort(lista3);
	Actv_12_Shell D4 = new Actv_12_Shell();
	D4.sort(lista3,4);
	D4.cont();
	Actv_13_Merge D5 = new Actv_13_Merge();
	D5.sort(lista3);
	D5.contador();
	Actv_13_Quick D6 = new Actv_13_Quick();
	D6.sort(lista3,0,98);
	D6.contador();

	} 
} 
