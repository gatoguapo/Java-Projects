package PracticaTopicos;

import javax.swing.*;
import javax.swing.event.*;

public class CheckBox extends JFrame implements ChangeListener {
	private JCheckBox check1, check2, check3;

	public CheckBox() {
		HazInterfaz();
		this.HazEscucha();
	}

	public void HazInterfaz() {
		setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);

				check1 = new JCheckBox("Ingles");
		check1.setBounds(10, 10, 150, 30);
		add(check1);

		check2 = new JCheckBox("Frances");
		check2.setBounds(10, 50, 150, 30);
		add(check2);

		check3 = new JCheckBox("Aleman");
		check3.setBounds(10, 90, 150, 30);
		add(check3);
	}

	public void HazEscucha() {
		check1.addChangeListener(this);
		check2.addChangeListener(this);
		check3.addChangeListener(this);
	}

	public static void main(String[] args) {
		new CheckBox();

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		String cad = "";
		if (check1.isSelected() == true) {
			cad = cad + "Ingles-";
		}
		if (check2.isSelected() == true) {
			cad = cad + "Frances-";
		}
		if (check3.isSelected() == true) {
			cad = cad + "Aleman-";
		}
		setTitle(cad);
	}

}
