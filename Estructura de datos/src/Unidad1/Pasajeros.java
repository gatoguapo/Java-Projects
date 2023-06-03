package Unidad1;

public class Pasajeros {
	
	NodePasajeros firstNode;
	char pasajero;
	public Pasajeros() 
	{
		this.firstNode = null;
	}
	
	public Pasajeros(NodePasajeros firstNode)
	{
		this.firstNode = firstNode;
	}
	
	public NodePasajeros getFirstNode()
	{
		return this.firstNode;
	}
	
	public void AgregaPasajero (String info)
	{
		NodePasajeros nodeToInsert = new NodePasajeros (info);
		while (firstNode != null)
		{
		firstNode.next = nodeToInsert;
		nodeToInsert = firstNode;
		}
	}
	
	public boolean isEmpty()
	{
		return (this.firstNode==null);
	}
	
	public void BorrarPasajero(String position) throws Exception
	 {
	        
	        NodePasajeros currentNode = null;//Nodo que recorre la lista
	         
	        if(this.isEmpty())
	        { //Si la lista est� vac�a lanza un error.

	            throw new Exception("La lista est� vac�a");
	        }
	        
	        if (position==char info)
	        { //si la posici�n es 1 entonces reacomodamos el 
	                            //primer nodo de la lista
	            firstNode= firstNode.next;
	        } else 
	        {
	            currentNode = firstNode;
	            //Nos movemos hasta la posici�n anterior al nodo a borrar
	            for (int i=1;i<position-1;i++)
	            {

	                if (currentNode.next != null)
	                {

	                   throw new Exception("La posici�n es mayor al tama�o "

	                           + "de la lista");
	                }
	                currentNode=currentNode.next;//avanzamos el nodo
	            }
	            
	         //Igualaremos el next del nodo anterior al next del nodo a borrar
	            currentNode.next = (currentNode.next).next;           
	        }
	 }
	
	public void MostrarPasajeros ()
	{
		NodePasajeros nodeToInsert = this.firstNode;
		
		while (nodeToInsert!=null)
		{
			System.out.println(nodeToInsert.info+" ");
			nodeToInsert = nodeToInsert.next;
		}
	}
}
