package Unidad1;

public class NodeEinstein 
{		
		NodeEinstein Ant;
		String data;
		
		public void NodeEinstein ()
		{
			this.Ant=null;
			this.data="";
		}
		
		public void NodeEinstein (String valor)
		{
			this.Ant=null;
			this.data=valor;
		}
		
		public String Get()
		{
			return this.data;
		}
	
}
