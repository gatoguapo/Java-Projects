package Unidad1;

public class Stack 
{
	NodePilas Tope;
	int Capacidad;
	int Contador;
	int dato; 
	
	public Stack ()
	{
		this.Tope=null;
		this.Capacidad=0;
		this.Contador=0;
		this.dato=0;
	}
	
	public Stack (int valor)
	{
		NodePilas NodoInsertar = new NodePilas();
		NodoInsertar.NodePilas(valor);
		this.Tope=NodoInsertar;
		this.Contador++;
	}
	
	public void Set_Capacidad(int valor)
	{
		this.Capacidad=valor;
	}
	
	public Boolean Esta_Vacia ()
	{
		if (this.Tope==null)
			return true;
		else 
			return false;
	}
	
	public Boolean Esta_Llena ()
	{
		if (Contador==Capacidad)
			return true;
		else
			return false;
	}
	
	public void Insertar (int valor) throws Exception
	{
		NodePilas NodoInsertar = new NodePilas();
		NodoInsertar.NodePilas(valor);
		
		if (this.Tope==null)
		{
		this.Tope=NodoInsertar;
		this.Contador++;
		}
		else
		if (!this.Esta_Llena())
		{
			NodoInsertar.Ant=this.Tope;
			this.Tope=NodoInsertar;
			this.Contador++;
		}
		else
		{
			throw new Exception("La pila esta llena");
		}
	}
	
	 public int Retirar()
	    {
	        int dato=0;
	        NodePilas Nodo_retirado=null;
	        if (!this.Esta_Vacia())
	        {
	         Nodo_retirado=this.Tope;
	          if (Contador>1)
	          {   
	           Tope=this.Tope.Ant;
	           this.Contador--;
	          }
	          else
	          {
	           Tope=null;
	           Contador--;
	          }
	        dato=Nodo_retirado.Get();
	        }
	        return dato;

	    }  
	
	// Metodo para visualizar los elementos de la pila
    public void Mostrar(Stack Pila)throws Exception
    {
      Stack Pila_Aux=new Stack();
      int dato_retirado;
      while (!Pila.Esta_Vacia())
      {
          dato_retirado=Pila.Retirar();
          System.out.println("El valor es :"+ dato_retirado);
          Pila_Aux.Insertar(dato_retirado);
      }   

      while (!Pila_Aux.Esta_Vacia())
      {
       Pila.Insertar(Pila_Aux.Retirar());
      }

    }
   
    
}

