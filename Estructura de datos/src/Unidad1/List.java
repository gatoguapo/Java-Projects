package Unidad1;

public class List
{
	
	Node firstNode;
	
	public List() 
	{
		this.firstNode = null;
	}
	
	public List(Node firstNode)
	{
		this.firstNode = firstNode;
	}
	
	public Node getFirstNode()
	{
		return this.firstNode;
	}
	
	public void insertAtFirstPosition (int value)
	{
		Node nodeToInsert = new Node (value);
		nodeToInsert.next = firstNode;
		firstNode = nodeToInsert;
	}
	
	public void show ()
	{
		Node currentNode = this.firstNode;
		
		while (currentNode!=null)
		{
			System.out.println(currentNode.data+" ");
			currentNode = currentNode.next;
		}
	}
	
	public boolean isEmpty()
	{
		return (this.firstNode==null);
	}
	
	public Node find (int value)
	{
		Node result=null;
		Node currentNode=this.firstNode;
		
		while (currentNode!=null)
		{
			if (currentNode.data==value);
			result = currentNode;
			currentNode=currentNode.next;
		}
		return result;
	}
	 public void Delete(int position) throws Exception
	 {
	        
	        Node currentNode = null;//Nodo que recorre la lista
	         
	        if(this.isEmpty())
	        { //Si la lista está vacía lanza un error.

	            throw new Exception("La lista está vacía");
	        }
	        
	        if (position==1)
	        { //si la posición es 1 entonces reacomodamos el 
	                            //primer nodo de la lista
	            firstNode= firstNode.next;
	        } else 
	        {
	            currentNode = firstNode;
	            //Nos movemos hasta la posición anterior al nodo a borrar
	            for (int i=1;i<position-1;i++)
	            {

	                if (currentNode.next != null)
	                {

	                   throw new Exception("La posición es mayor al tamaño "

	                           + "de la lista");
	                }
	                currentNode=currentNode.next;//avanzamos el nodo
	            }
	            
	         //Igualaremos el next del nodo anterior al next del nodo a borrar
	            currentNode.next = (currentNode.next).next;           
	        }
	 }
	 
	 public boolean Exist (int value)
	 {
		 Boolean result=false;
		 Node currentNode=this.firstNode;
		 
		 while (currentNode!=null)
		 {
			 if (currentNode.data==value)
				 result=true;
			 currentNode=currentNode.next;
		 }
		 return result;
	 }
	 
	 public Node Insert(int position, int valor) throws Exception
     {
         Node NodeAux=null;
         Node currentNode = null;//Nodo que recorre la lista
          Node nodeToInsert = new Node(valor);
         if(this.isEmpty())
         { //Si la lista está vacía lanza un error.
             throw new Exception("La lista está vacía");
         }

         if (position==1)
         { 
             nodeToInsert.next = firstNode;
             firstNode = nodeToInsert;
         } else
         {
             currentNode = firstNode;
             //Nos movemos hasta la posición anterior al nodo a borrar
             for (int i=1;i<position-1;i++)
             {

                 if (currentNode.next != null)
                 {
                    throw new Exception("La posición es mayor al tamaño "
                            + "de la lista");
                 }

                 currentNode=currentNode.next;//avanzamos el nodo
             }
             NodeAux=currentNode.next;
             currentNode.next=nodeToInsert;
             nodeToInsert.next=NodeAux;
         }     
         return currentNode; 
     }
	 
	 public void Update(int position,int valor) throws Exception
	 {
	        Node nodeToUpdate = null;
	        Node currentNode = null;//Nodo que recorre la lista
	         
	        if(this.isEmpty())
	        { //Si la lista está vacía lanza un error.

	            throw new Exception("La lista está vacía");
	        }
	        
	        if (position==1)
	        { //si la posición es 1 entonces reacomodamos el //primer nodo de la lista
	            nodeToUpdate.next = firstNode;
	            firstNode= nodeToUpdate;
	        } else 
	        {
	            currentNode = firstNode;
	            //Nos movemos hasta la posición anterior al nodo a borrar
	            for (int i=1;i<position-1;i++)
	            {

	                if (currentNode.next == null)
	                {

	                   throw new Exception("La posición es mayor al tamaño "

	                           + "de la lista");
	                }
	                nodeToUpdate=currentNode;//avanzamos el nodo
	            }
	            
	         //Igualaremos el next del nodo anterior al next del nodo a borrar
	            currentNode.next = nodeToUpdate;           
	        }
	 }
}