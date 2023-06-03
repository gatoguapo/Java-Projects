package Arbol_Bin;

public class Avl_Tree 
{
	AvlNode Root;
	int Cant_Nodos;
	
	public void Avl_Tree()
	{
		
	}
	
	//metodo para borrar todos los nodos del arbol
	public void vaciar ()
	{
	Root=null;
	}
	
	//metodo para determinar si un arbol esta vacio
	public Boolean estaVacio()
	{
		return Root==null; 
	}
	
	//metodo para conocer el tamaño del arbol
	public int getTam () 
	{
	return this.Cant_Nodos;
	}
	
	//metodo para imprimir el contenido de un arbol recorrido inorden
	public void Imprimir_InOrden ()
	{
		if (this.estaVacio())
			System.out.println("El arból esta vacio");
		else 
			Imprimir_InOrden(Root);
	}
	
	//metodo auxiliar para el recorrido inorden
	public void Imprimir_InOrden(AvlNode nodo)
	{
		if (nodo!=null)
			Imprimir_InOrden (nodo.izq);
			System.out.println(nodo.data);
	}
}
