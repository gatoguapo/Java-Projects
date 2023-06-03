package Unidad2;

import java.awt.GridLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class APL extends JFrame{
	
	public APL() {
		super ("Marcas");
		HazInterfaz();
	}
	
	public static void main(String[] args) {	
		new APL();
	}
	
	public void HazInterfaz() {
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,1,5,5));
		ComponenteMarcas c1 = new ComponenteMarcas();
		ComponenteCombosDep c2 = new ComponenteCombosDep();
		add(c1);
//		add(c2);
		setVisible(true);
	}
}
