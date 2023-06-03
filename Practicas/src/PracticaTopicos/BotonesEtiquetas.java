package PracticaTopicos;

import javax.swing.*;
import java.awt.event.*;

public class BotonesEtiquetas extends JFrame implements ActionListener {
	private JButton btn1, btn2, btn3;
	private JLabel etiqueta1;

	public BotonesEtiquetas() {
		setLayout(null);
		btn1 = new JButton("1");
		btn1.setBounds(10,100,90,30);
		add(btn1);
		btn1.addActionListener(this);
		
		btn2 = new JButton("2");
		btn2.setBounds(110,100,90,30);
		add(btn2);
		btn2.addActionListener(this); 
		
		btn3 = new JButton ("3");
		btn3.setBounds(210,100,90,30);
		add(btn3);
		btn3.addActionListener(this);
		
		etiqueta1 = new JLabel ("En espera...");
		etiqueta1.setBounds(10,10,300,30);
		add(etiqueta1);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			etiqueta1.setText("Has presionado el boton 1");
		}
		if (e.getSource() == btn2) {
			etiqueta1.setText("Has presionado el boton 2");
		}
		if (e.getSource() == btn3) {
			etiqueta1.setText("Has presionado el boton 3");
		}
	}

	public static void main(String[] args) {
		BotonesEtiquetas obj1 = new BotonesEtiquetas();
		obj1.setSize(350,200);
		obj1.setLocationRelativeTo(null);
		obj1.setVisible(true);
		obj1.setResizable(false);
		obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
