package Unidad1;

public class Listas_de_prueba 
{
	
	public static void main(String[]args) 
	{
		List ListaA = new List();
		ListaA.insertAtFirstPosition(45);
		ListaA.show();
		Node Buscar;
		Buscar=ListaA.find(45);
		System.out.println(Buscar.data);
	}
	
}
