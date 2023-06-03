package PracticaTopicos;

import javax.swing.*;
import java.awt.event.*;

public class Button extends JFrame implements ActionListener{
	private JButton btn1;
	public Button () {
		setLayout(null);
		btn1 = new JButton ("Cerrar");
		btn1.setBounds(250,250,100,30);
		add(btn1);
		btn1.addActionListener(this);
	}
	
	public static void main(String[] args) {
		Button button = new Button();
		button.setBounds( 0, 0, 400, 350);
		button.setVisible(true);
		button.setResizable(false);
		button.setLocationRelativeTo(null);
		button.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			System.exit(0);
		}
	}
	
}
