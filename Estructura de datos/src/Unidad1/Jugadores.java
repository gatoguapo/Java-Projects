package Unidad1;

import java.util.Scanner;

public class Jugadores 
{
	Scanner Leer=new Scanner(System.in);
	NodeJugadores firstNode;
	NodeJugadores aux;
	public Jugadores() 
	{
		this.firstNode = null;
	}
	
	public Jugadores(NodeJugadores firstNode)
	{
		this.firstNode = firstNode;
	}
	
	public NodeJugadores getFirstNode()
	{
		return this.firstNode;
	}
	
	public void Capitan1 (String value)
	{
		NodeJugadores nodeToInsert = new NodeJugadores (value);
		nodeToInsert.next = firstNode;
		firstNode = nodeToInsert;
	}
	
	public void Capitan2 (String value)
	{
		NodeJugadores nodeToInsert = new NodeJugadores (value);
		nodeToInsert.next = aux;
		aux = nodeToInsert;
	}
	
	public boolean isEmpty()
	{
		return (this.firstNode==null);
	}
	
	public void Todos () throws Exception
    {
        NodeJugadores nodeToInsert = new NodeJugadores(null);
        String [] jugadores = new String [22];
        for (int i=0;i<22;i++)
        {   
        	
        	int n=0;
        	n++;
        	System.out.println("Inserte el nombre del jugador "+(n)+": ");
        	jugadores [i] = Leer.next(nodeToInsert.info);	
        	nodeToInsert.next = firstNode;
    		firstNode = nodeToInsert;
        }
        
        for (int i=0;i<21;i++)
        {
        	System.out.println(jugadores [i] = nodeToInsert.info+" ");
        	nodeToInsert=nodeToInsert.next;
        }
    }
	
	
}
