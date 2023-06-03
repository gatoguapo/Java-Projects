package Unidad1EjemplosDeClase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class segundoPrograma extends JFrame{
	public segundoPrograma() {
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz() {
		setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*setLayout(new FlowLayout(FlowLayout.LEFT));
		for(int i=0 ; i <100 ; i++) {
			add(new JButton("btn"+i));
		}*/
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(6,5,5,5));
		for(int i=0 ; i <100 ; i++) 
			p.add(new JButton("btn"+i));
		JScrollPane s=new JScrollPane(p);	
		add(s);	
		setVisible(true);
	}
	private void HazEscuchas() {
		
	}
	
	public static void main(String [] args) {
		
		new segundoPrograma();
		
	}
	

}
