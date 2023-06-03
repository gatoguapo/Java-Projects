package Arbol_Bin;

public class AvlNode 
{
	Integer data=null;
	AvlNode izq = null;
	AvlNode der = null;
	
	public AvlNode()
	{
		
	}
	
	public AvlNode(Integer data) 
	{
		this.data = data;
	}
	
	public int getData() 
	{
		return data;
	}

	public void setData(int data) 
	{
		this.data = data;
	}

	public AvlNode getIzq() 
	{
		return izq;
	}

	public void setIzq(AvlNode izq) 
	{
		this.izq = izq;
	}

	public AvlNode getDer() 
	{
		return der;
	}

	public void setDer(AvlNode der) 
	{
		this.der = der;
	}
}
