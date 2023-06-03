package Unidad1;

public class MetodosAct3 {
	NodePilas Tope;
	int Capacidad;
	int Contador;
	String dato = null;
	
	public void MetodosAct3 ()
	{
		this.Tope=null;
	}
	
	public void MetodosAct3 (String valor)
	{
		NodePilas NodoInsertar = new NodePilas();
		NodoInsertar.NodePilas(valor);
		this.Tope=NodoInsertar;
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
	
	public void Inverse() throws Exception
    {
    	Stack PilaAux = new Stack ();
    	
    	if (!Esta_Llena())
    	{
    		PilaAux.Insertar(dato);
    		for (int i=0;i<Contador;i++)
    		{
    			System.out.println(PilaAux.Insertar(dato));
    		}
    	}
    	else
		{
			throw new Exception("La pila esta llena");
		}
    }
    
    public void Alternate () throws Exception
    {
    	NodePilas Pila2 = new NodePilas ();
    	Stack Pila3 = new Stack();
    	Pila2.NodePilas("1","2","3");
    	Stack Pila2Datos = new Stack();
    	Pila2Datos.Stack(Pila2.data);
    	if (!Esta_Llena() && Pila2!=null)
    	{
    		Pila3.Insertar(dato);
    		Pila2Datos = Pila3;
    		for (int i=0;i<Contador;i++)
    		{
    			System.out.println(Pila3);
    		}
    	}
    	else 
    	{
    		throw new Exception("Una de las dos pilas esta vacia");
    	}
    }
	
	
}
