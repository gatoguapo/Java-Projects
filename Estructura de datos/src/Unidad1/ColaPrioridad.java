package Unidad1;

public class ColaPrioridad 
{
	NodoPrioridad[] data;
	int tam;
	int limite;
	
	public ColaPrioridad ()
	{
		data=null;
		tam=0;
		limite=0;
	}
	
	public Boolean isEmpty ()
	{
		return tam==1;
	}
	
	public void Push (int prio, String valor)
	{
		NodoPrioridad NodoNuevo = new NodoPrioridad (prio,valor);
		tam++;
		
		if (this.isEmpty())
		{
			data[tam]=NodoNuevo;
		} else
		{
			data[tam]=NodoNuevo;
			
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
	
	public NodoPrioridad Pop ()
	{
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
		if (this.isEmpty())
		{
			System.out.println("La cola esta vacia");
		} else
		{
		if(Hijo_Izq.getPrioridad()<Hijo_Der.getPrioridad())
		{
			data[PosicionHijoDer]=Nodo_Resp;
			
		}
		else
			data[PosicionHijoIzq]=Nodo_Resp;
		}
		return Nodo_Resp;
	}
	
	
}
