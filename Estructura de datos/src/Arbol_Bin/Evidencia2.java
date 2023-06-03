package Arbol_Bin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Evidencia2 
{		 
	public static void main(String[] args) 
	{
	new Evidencia2();
	}
	
	public Evidencia2() 
	{
	Scanner sc = new Scanner(System.in);
	AnimalNode n = load();
		if (n == null) 
		{
			n = new AnimalNode("Tu animal tiene cuernos?");
			n.y = new AnimalNode("Vaca");
			n.n = new AnimalNode("Perro");
		}
		AnimalNode root = n;
		boolean playing = true;
		while (playing) 
		{
			System.out.println("Bienvenido al juego piensa en un animal");
			while (n.data.endsWith("?")) 
		{
				System.out.print(n.data + " ");
				n = sc.nextLine().equals("y") ? n.y : n.n;
		}
			System.out.print("Tu animal es: " + n.data + ". estoy correcto? ");
			String correct = sc.nextLine();
			if (correct.equals("y"))
				System.out.println("Gane haha!!");
			else 
			{
				System.out.println("No tengo idea, dame una idea");
				System.out.print("Cual es el nombre de tu animal? ");
				String animal = sc.nextLine().toLowerCase();
				System.out.println("Cual es una pregunta a la que responderias si a tu animal " + animal + "? ");
				String question = sc.nextLine();
				String t = n.data;
				n.data = question;
				n.y = new AnimalNode(animal);
				n.n = new AnimalNode(t);
			}
				System.out.print("Quieres jugar de nuevo? ");
				playing = sc.nextLine().equals("y");
				if (playing)
				n = root;
				else
				save(root);
			}
	}
	public void save(AnimalNode n) {
	ObjectOutputStream oos = null;
	FileOutputStream fout = null;
	try {
	fout = new FileOutputStream("Arbol.ser");
	oos = new ObjectOutputStream(fout);
	oos.writeObject(n);
	} catch (Exception e) {
	e.printStackTrace();
	} 
		finally {
			if(oos != null)
			{
				try {
					oos.close();
				} catch (Exception ex){
			ex.printStackTrace();}
			}
		}
	}
	
	public AnimalNode load() 
	{
		FileInputStream streamIn = null;
		ObjectInputStream ois = null;
		AnimalNode n = null;
		try {
			streamIn = new FileInputStream("Arbol.ser");
			ois = new ObjectInputStream(streamIn);
			n = (AnimalNode)ois.readObject();
			} catch (Exception e) {
			} finally {
				if (ois != null) {
					try {
						ois.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} 
			}
		return n;
	}
}

