package Unidad1;

public class NodeEcuacion {
	
	NodeEcuacion Ant;
	String Operador;
	int Operando;
	
	public void NodeEcuacion ()
	{
		this.Ant=null;
		this.Operador="";
		this.Operando = 0;
	}
	
	public void NodeEcuacion (String valor)
	{
		this.Ant=null;
		this.Operador=valor;
		this.Operando = 0;
	}
	
	public void NodeEcuacion (int Operando)
	{
		this.Ant=null;
		this.Operador= "";
		this.Operando = Operando;
	}
	
	public String Get()
	{
		return this.Operador;
	}
}
