package Unidad2EjemplosDeClase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplLienzos extends JFrame {

	MyLienzo l1,l2,l3,l4;
	
	public AplLienzos() {
		super("Manejo de multiples lienzos");
		HazInterfaz();
		HazEscuchas();
	}
	public void HazInterfaz() {
		setSize(500,500);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		l1=new MyLienzo("Caballo.png");
		l2=new MyLienzo("avion.jpg");
		l3=new MyLienzo("1.jpg");
		l4=new MyLienzo("4.jpg");
		
		setLayout(new GridLayout(0,2));
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		
		String [] arreglo=new String [] {"1.jpg","2.jpg","3.jpg"};
		LienzoMultiplesImagenes l5=new LienzoMultiplesImagenes(arreglo);
		add(l5);
		
		setVisible(true);
	}
	public void HazEscuchas() {
		
	}
	public static void main(String[] args) {
		new AplLienzos();

	}

}
