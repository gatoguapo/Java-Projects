package PracticaTopicos;

import javax.swing.*;

public class Label extends JFrame{
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	
	public Label () {
		setLayout(null);
		etiqueta1 = new JLabel ("Interfaz grafica");
		etiqueta1.setBounds(10, 20, 300, 30);
		add(etiqueta1);
		etiqueta2 = new JLabel ("Version 1.0");
		etiqueta2.setBounds(10, 100, 100, 30);
		add(etiqueta2);
		
	}
	
	public static void main (String [] args) {
		Label label = new Label();
		label.setSize(300,200);
		label.setLocationRelativeTo(null);
		label.setResizable(false);
		label.setVisible(true);
		label.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
