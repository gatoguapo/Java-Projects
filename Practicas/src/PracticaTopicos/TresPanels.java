package PracticaTopicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TresPanels extends JFrame implements ActionListener{
	
	JPanel redPanel = new JPanel();
	JPanel bluePanel = new JPanel();
	JFrame interfaz = new JFrame();
	public TresPanels () {
		HazInterfaz();
	}
	
	public void HazInterfaz () {
		interfaz.setLayout(null);
		interfaz.setSize(750,750);
		interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		interfaz.setLocationRelativeTo(null);
		interfaz.setVisible(true);
		
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0,0,250,250);
		
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(200,0,250,250);
		
		interfaz.add(redPanel);
		interfaz.add(bluePanel);
	}
	
	public static void main(String[] args) {
		new TresPanels();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
