package PracticaTopicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

	private JPanel panelBtns, panelCentro;
	private JButton[] btns;

	public static void main(String args[]) {
		new Dashboard();
	}

	public Dashboard() {
		HazInterfaz();
		HazEscuchas();
	}

	public void HazInterfaz() {
		setSize(900, 900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panelBtns = new JPanel();
		panelBtns.setLayout(new GridLayout(0, 6));
		btns = new JButton[6];

		for (int i = 0; i < btns.length; i++) {
			panelBtns.add(new JLabel(" "));
		}

		btns[0] = new JButton("POR TORNEO");
		panelBtns.add(btns[0]);
		btns[1] = new JButton("POR PRIORIDAD");
		panelBtns.add(btns[1]);
		btns[2] = new JButton("MAS CORTO");
		panelBtns.add(btns[2]);
		btns[3] = new JButton("POR POLITICA");
		panelBtns.add(btns[3]);
		btns[4] = new JButton("LISTA DE ESPERA");
		panelBtns.add(btns[4]);
		btns[5] = new JButton("NIVELES");
		panelBtns.add(btns[5]);

		for (int i = 0; i < btns.length; i++) {
			panelBtns.add(new JLabel(" "));
		}

		panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(1, 0));
		panelCentro.setBackground(Color.red);

		add(panelBtns, BorderLayout.NORTH);
		add(panelCentro);

		setVisible(true);
	}

	public void HazEscuchas() {
		for (int i = 0; i < btns.length; i++) {
			btns[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btns[0]) {
			JPanel panelBtn1 = new JPanel();
			panelBtn1.setBackground(Color.black);
			panelCentro.removeAll();
			panelCentro.add(panelBtn1);
			revalidate();
			repaint();
			update(getGraphics());
		}
		if (e.getSource() == btns[1]) {

			JPanel panelBtn2 = new JPanel();
			panelBtn2.setBackground(Color.blue);
			panelCentro.removeAll();
			panelCentro.add(panelBtn2);
			revalidate();
			repaint();
			update(getGraphics());
		}
		if (e.getSource() == btns[2]) {

		}
		if (e.getSource() == btns[3]) {

		}
	}

}
