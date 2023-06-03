package PracticaTopicos;

import javax.swing.*;

public class Swing extends JFrame {
	private JLabel label1;
	
	public Swing() {
		setLayout(null);
		label1 = new JLabel("Hola");
		label1.setBounds(10, 20, 200, 300);
		add(label1);
	}

	public static void main(String[] args) {
		Swing swing1 = new Swing ();
		swing1.setBounds(0, 0, 400, 300);
		swing1.setVisible(true);
		swing1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		swing1.setLocationRelativeTo(null);
	}

}
