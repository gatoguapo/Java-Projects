package Unidad1;

public class Colas_Evidencia 
{
	NodoPrioridad[] data;
	int tam;
	int tope;
	int tiempomin;
	int tiempomax;
	
	public Colas_Evidencia ()
	{
		this.data= new NodoPrioridad[tope];
		this.tam=0;
		this.tope=0;
		this.tiempomin=0;
		this.tiempomax=0;
		
	}
	
	
	
	public Colas_Evidencia (int valor)
	{	
		this.data= null;
		this.tam=0;
		this.tiempomin=0;
		this.tiempomax=0;
		this.tope=valor;
	}
	
	public Colas_Evidencia (int tmin,int tmax)
	{	
		this.data=null;
		this.tam=0;
		this.tiempomin=tmin;
		this.tiempomax=tmax;
	}
	
	public Boolean isEmpty ()
	{
		return tam==1;
	}
	
	public void ColaTope (int valor)
	{
		tope=valor;
	}
	
	public boolean TopeAlcanzado ()
	{
		if (tam==tope)
				return true;
		else
				return false;
	}
	
	public void Rango (int tmin, int tmax)
	{
		if (tmin>tmax)
		{
			System.out.println("El tiempo minimo debe ser menor al maximo.");
		}
		else
		{
		tiempomin=tmin;
		tiempomax=tmax;
		}
	}
	
	public void Push (int prio, String valor)
	{
		NodoPrioridad NodoNuevo = new NodoPrioridad (prio,valor);
		tam++;
		int random = (int)(Math.random()*10);
		
		while (!TopeAlcanzado())
		{
		if (this.isEmpty())
		{
			if (random <= 5)
				System.out.println("El usuario esperara un tiempo de "+tiempomin+" minutos");
			else
				System.out.println("El usuario esperara un tiempo de "+tiempomax+" minutos");
			NodoNuevo=data[tam];
				System.out.println("Se ha insertado un elemento");
		} else
		{
			if (random <= 5)
				System.out.println("El usuario esperara un tiempo de "+tiempomin+" minutos");
			else
				System.out.println("El usuario esperara un tiempo de "+tiempomax+" minutos");
			NodoNuevo=data[tam];
			System.out.println("Se ha insertado un elemento");
			
			int PosiciondelPadre = (int)(tam/2);
			NodoPrioridad Padre = data[PosiciondelPadre];
			while (tam!=1 && Padre.getPrioridad()>NodoNuevo.getPrioridad())
			{
				data[tam]= Padre;
				data[PosiciondelPadre] = NodoNuevo;
				
				tam=PosiciondelPadre;
				PosiciondelPadre = (int)(tam/2);
				Padre=data[PosiciondelPadre];				
			}
		}
		}		
	}
	
	public NodoPrioridad Pop ()
		{
			int random = (int)(Math.random()*10);
			int n=1;
			NodoPrioridad Nodo_Resp;
			Nodo_Resp=data[1];
			
			
			data[1]=data[tam];
			
			NodoPrioridad Hijo_Izq;
			NodoPrioridad Hijo_Der;
			int PosicionHijoIzq=2*n;
			int PosicionHijoDer=2*n+1;
			
			Hijo_Izq=data[PosicionHijoIzq];
			Hijo_Der=data[PosicionHijoDer];
			
			NodoPrioridad nodo_respaldo=data[1];
			if (this.isEmpty())
			{
				System.out.println("La cola esta vacia");
			} else
			{
				while (PosicionHijoIzq<=tam)
				{
				if(Hijo_Izq.getPrioridad()<Hijo_Der.getPrioridad())
				{
					if (random <= 5)
					{System.out.println("El usuario esperara un tiempo de "+tiempomin);}
					else
					{System.out.println("El usuario esperara un tiempo de "+tiempomax);}
				
				nodo_respaldo=data[n];
				data[n]=data[PosicionHijoIzq];
				data[PosicionHijoIzq]=nodo_respaldo;
				n=PosicionHijoIzq;
				
				tam--;
				System.out.println("Se ha retirado un elemento");			
				}
				else
				{
					if (random <= 5)
					{System.out.println("El usuario esperara un tiempo de "+tiempomin);}
					else
					{System.out.println("El usuario esperara un tiempo de "+tiempomax);}
				
				nodo_respaldo=data[n];
				data[n]=data[PosicionHijoDer];
				data[PosicionHijoDer]=nodo_respaldo;
				n=PosicionHijoIzq;
				
				tam--;
				System.out.println("Se ha retirado un elemento");
				}
			}
			
		}
			return Nodo_Resp;
		}
}