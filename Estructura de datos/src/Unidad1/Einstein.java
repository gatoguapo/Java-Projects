package Unidad1;

public class Einstein {
	NodeEinstein Tope;
	int Meses;
	
	public void Einstein ()
	{
		this.Tope=null;
		this.Meses=0;
	}
	
	public void Einstein (String valor, int meses)
	{
		NodeEinstein NodoInsertar = new NodeEinstein();
		NodoInsertar.NodeEinstein(valor);
		this.Tope=NodoInsertar;
		Meses = meses;
	}
	
	
}
