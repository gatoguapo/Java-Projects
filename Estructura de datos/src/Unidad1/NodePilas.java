package Unidad1;

public class NodePilas 
{
	
	NodePilas Ant;
	int data;
	
	public void NodePilas ()
	{
		this.Ant=null;
		this.data=0;
	}
	
	public void NodePilas (int valor)
	{
		this.Ant=null;
		this.data=valor;
	}	

	public int Get ()
	{
		return this.data;
	}
}
