package Unidad1;

public class NodeCola 
{
	NodeCola Ant;
	int dato;
	
	public void NodeCola ()
	{
		this.Ant=null;
		this.dato=0;
	}
	
	public void NodeCola (int valor)
	{
		this.Ant=null;
		this.dato=valor;
	}
	
	//Metodo de acceso al nodo//
	
	public int GetValor ()
	{
		return this.dato;
	}
}
