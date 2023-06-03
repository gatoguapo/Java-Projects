package Unidad2;

import java.awt.*;
import javax.swing.*;

public class InterfazCombosDep extends JFrame {
	
	ComponenteCombosDep componente_combo;
	
	public static void main(String[] args) {
		new	InterfazCombosDep();
	}

	public InterfazCombosDep() {
		super ("Combos Dependienes");
		HazInterfaz();
		
	}
	
	public void HazInterfaz() {
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(0,1));
		
		componente_combo = new ComponenteCombosDep();
		add(componente_combo);
		this.setVisible(true);
	}
}
