package Unidad1;

import java.util.Scanner;

public class Ecuacion 
{
	NodeEcuacion Tope = new NodeEcuacion();
	int operando;
	String operador;
	
	public Ecuacion ()
	{
		this.Tope=null;
	}
	
	public Boolean Esta_Vacio()
	{
		if (this.Tope==null)
			return true;
		else
			return false;
	}
	
	public int InsertarOperando (int Operando) throws Exception
	{

		NodeEcuacion NodoOperando = new NodeEcuacion ();
		NodoOperando.NodeEcuacion(Operando);
		if (Esta_Vacio())
		{				
		this.Tope=NodoOperando;
		}
		
		if (!Esta_Vacio())
		{		
		this.Tope=NodoOperando;
		this.Tope=this.Tope.Ant;
		
		}
		else 
		{
			throw new Exception("Inserte un Operando valido");
		}
		
		NodoOperando.Operando = operando;		
		return operando;
	}
	
	public String InsertarOperador (String Operador) throws Exception
	{
		
		NodeEcuacion NodoOperador = new NodeEcuacion ();	
		NodoOperador.NodeEcuacion(Operador);
		
		if (Esta_Vacio())
		{			
		this.Tope=NodoOperador;		
		}	
		
		if (!Esta_Vacio())
		{		
		this.Tope=NodoOperador;
		this.Tope=this.Tope.Ant;
		}	
		
		else 
		{
			throw new Exception("Inserte un Operador valido");
		}
		
		NodoOperador.Operador = operador;
		return operador;
	}
	
	public void Postfija () throws Exception
	{		
		System.out.println(operador);
		System.out.println(operando);
		
	}
}
