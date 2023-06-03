package Unidad1;

public class NodoPrioridad
{
	public int prioridad;
	public String dato;
	
	public NodoPrioridad ()
	{
		this.prioridad = 0;
		this.dato = "";
	}
	
	public NodoPrioridad (int prio,String valor)
	{
		this.prioridad = prio;
		this.dato = valor;
	}
	
	public int getPrioridad()
	{
		return prioridad;
	}
	
	public void setPrioridad(int prio)
	{
		prioridad=prio;
	}
}
