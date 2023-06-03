package Unidad1;

public class NodeJugadores 
{	
		String info;
		NodeJugadores next;
		
		
		public NodeJugadores(String info,NodeJugadores next) 
		{
			this.info = info;
			this.next = next;
		}
		
		public NodeJugadores(String info) 
		{
			this.info = info;
		}
		
}
