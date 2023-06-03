package PracticaTopicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubMenus extends JFrame implements ActionListener {

	private JMenuBar menubar;
	private JMenu menu1, menu2, menu3;
	private JMenuItem menuitem1, menuitem2, menuitem3, menuitem4;

	public SubMenus() {
		Hazinterfaz();
		HazEscucha();
	}

	public void Hazinterfaz() {
		setBounds(0,0,300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);

		menubar = new JMenuBar();
		setJMenuBar(menubar);

		menu1 = new JMenu("Opciones");
		menubar.add(menu1);

		menu2 = new JMenu("Tamano de la ventana");
		menu1.add(menu2);

		menu3 = new JMenu("Color de fondo");
		menu1.add(menu3);

		menuitem1 = new JMenuItem("300*200");
		menu2.add(menuitem1);

		menuitem2 = new JMenuItem("640*480");
		menu2.add(menuitem2);

		menuitem3 = new JMenuItem("Rojo");
		menu3.add(menuitem3);

		menuitem4 = new JMenuItem("Verde");
		menu3.add(menuitem4);

	}

	public void HazEscucha() {
		menuitem1.addActionListener(this);
		menuitem2.addActionListener(this);
		menuitem3.addActionListener(this);
		menuitem4.addActionListener(this);
	}

	public static void main(String[] args) {
		SubMenus obj1 = new SubMenus();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuitem1) {
			setSize(300,200);
		}
		if (e.getSource() == menuitem2) {
			setSize(640,480);
		}
		if (e.getSource() == menuitem3) {
			getContentPane().setBackground(Color.red);;
		}
		if (e.getSource() == menuitem4) {
			getContentPane().setBackground(Color.green);;
		}
	}

}
