package PracticaTopicos;

import javax.swing.*;
import java.awt.event.*;

public class TextField extends JFrame implements ActionListener {
	private JTextField textfield1;
	private JLabel label1;
	private JButton btn1;

	public TextField() {
		setLayout(null);
		label1 = new JLabel ("Usuario:");
		label1.setBounds(10,10,100,30);
		add(label1);
		
		textfield1 = new JTextField();
		textfield1.setBounds(120, 17, 150, 20);
		add(textfield1);
		
		btn1 = new JButton("Aceptar");
		btn1.setBounds(10,70,100,30);
		add(btn1);
		btn1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			String texto = textfield1.getText();
			setTitle(texto);
		}
	}
	
	public static void main (String [] args) {
		TextField obj1 = new TextField ();
		obj1.setSize(300,150);
		obj1.setLocationRelativeTo(null);
		obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj1.setResizable(false);
		obj1.setVisible(true);
	}

}
