package Unidad1;

public class Actv4 
{
		NodeCola ini, fin;
		int Capacidad, cont, cont1, cont2, random1,random2;
		int [] procesos = new int [60];
			
		public Actv4 ()
		{
			this.ini=null;
			this.fin=null;
			this.Capacidad=0;
			this.cont=0;
			this.cont1=0;
			this.cont2=0;
			this.random1=(int) (Math.random()*10);
			this.random2=(int) (Math.random()*10);
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
		
		public void Servidores ()
		{
			NodeCola UnGhz = new NodeCola ();
			NodeCola DosGhz = new NodeCola ();
			
			do 
			{
			if (random1 < random2)
			{
				ini = UnGhz;
				cont1++;
			}
			if (random2 < random1)
			{
				ini = DosGhz;
				cont2++;
			}
			if (cont1 < cont2)
			{
				ini =UnGhz;
				fin = UnGhz;
				cont1++;
			}
			if (cont2 < cont1)
			{
				ini =DosGhz;
				fin = DosGhz;
				cont2++;
			}
			} while ( (cont1+cont2) != procesos[60]);
		}
}
