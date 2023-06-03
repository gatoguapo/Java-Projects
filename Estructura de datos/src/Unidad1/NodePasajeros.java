package Unidad1;

public class NodePasajeros 
{
	
	String info;
	NodePasajeros next;
	
	
	public NodePasajeros(String info,NodePasajeros next) 
	{
		this.info = info;
		this.next = next;
	}
	
	public NodePasajeros(String info) 
	{
		this.info = info;
	}
	
}
