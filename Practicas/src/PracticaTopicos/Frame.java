package PracticaTopicos;

import javax.swing.JFrame;

public class Frame extends JFrame {
	
	public Frame() {
		setLayout(null);
	}
	
	
	public static void main(String[] args) {
		Frame frame1 = new Frame();
		frame1.setBounds(350, 100, 800, 550);
		frame1.setVisible(true);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setResizable(false);
	}

}
