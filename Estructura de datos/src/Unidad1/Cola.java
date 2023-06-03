package Unidad1;


public class Cola 
{
	NodeCola ini, fin;
	int Capacidad, cont;
	
	public Cola ()
	{
		this.ini=null;
		this.fin=null;
		this.Capacidad=0;
		this.cont=0;
	}
	
	public void Set_Cap (int valor)
	{
		this.Capacidad=valor;
	}
	
	public boolean Esta_Vacio()
	{
		if (this.fin==null && this.ini==null)
			return true;
		else
			return false;
	}
	
	public boolean Esta_Lleno ()
	{
		if (Capacidad==cont)
			return true;
		else
			return false;
	}
	
	public void Insertar (int valor)
	{	
		NodeCola Nodo = new NodeCola ();
		Nodo.NodeCola(valor);
		
		if (Esta_Vacio())
		{
			fin.Ant = Nodo;
			fin = Nodo;
		}
		else
		{
			ini=Nodo;
			fin=Nodo;
			cont++;
		}
	}
	
	public void Retirar (int valor)
	{
		if (!Esta_Lleno())
		{
			if (!Esta_Vacio())
			{
				if (cont==1)
				{
					ini=null;
					fin=null;
					cont--;
				}
				if (cont>1)
				{
					ini=ini.Ant;
					cont--;
				}
			}
		}
		else
			System.out.println("La cola esta llena");
	}
	
	public void Show (Cola Pila)
	{
		NodeCola Nodo = new NodeCola();
		while (!Esta_Vacio())
		{
			for (int i=0;i<cont;i++)
			{
				ini=Nodo;
				System.out.println(Nodo);
			}
		}
		if (Esta_Vacio()==true)
		{
			System.out.println("La cola esta vacia, inserte valores primero.");
		}
	}
	
	public void Inverse ()
	{
		Cola ColaInversa = new Cola ();
		while (!Esta_Vacio())
		{	
			fin = ColaInversa.ini;
			fin = fin.Ant;
		}
		
	}
	
	
	
}
