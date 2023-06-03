package Unidad1;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

public class Pares extends JFrame implements ActionListener, ItemListener, MouseListener {

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private JComboBox dificultad;
	private JButton inicio;
	private JPanel opciones, panelpares;
	private JButton[] cartas;
	private int n = 0;
	private ImageIcon ajustar_interrogacion;
	private ArrayList<ImageIcon> imgns;
	private String catchitem = "";
	private String first_card = null;
	private ImageIcon[] cartas_imgn;
	private JButton aux_primera = new JButton();

	public static void main(String[] args) {
		new Pares();
	}

	public Pares() {
		HazInterfaz();

	}

	public void HazInterfaz() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		opciones = new JPanel();
		panelpares = new JPanel();

		add(opciones, BorderLayout.NORTH);
		opciones.setLayout(new FlowLayout(3, 10, 10));

		String[] dif = new String[] { "Seleccione", "Basico", "Medio", "Experto", };
		dificultad = new JComboBox<Object>(dif);
		JLabel nivel = new JLabel("Nivel");
		inicio = new JButton("Inicio");

		opciones.add(nivel);
		opciones.add(dificultad);
		opciones.add(inicio);

		HazEscuchas();

		setVisible(true);
	}

	public void HazEscuchas() {
		dificultad.addItemListener(this);
		dificultad.addActionListener(this);
		inicio.addActionListener(this);

		setVisible(true);
	}

	public void Juego() {
		ImageIcon imgninterrogacion = new ImageIcon("0.jpg");
		cartas = new JButton[n];

		for (int i = 0; i < cartas.length; i++) {
			cartas[i] = new JButton();
		}

		for (int i = 0; i < cartas.length; i++) {
			panelpares.add(cartas[i]);
		}
		add(panelpares, BorderLayout.CENTER);

		setVisible(true);

		Mezcla();
		for (int i = 0; i < cartas.length; i++) {
			ajustar_interrogacion = new ImageIcon(imgninterrogacion.getImage().getScaledInstance(cartas[0].getWidth(),
					cartas[0].getHeight(), Image.SCALE_SMOOTH));
			cartas[i].setIcon(ajustar_interrogacion);
			cartas[i].addMouseListener(this);
		}
	}

	public void Mezcla() {
		imgns = new ArrayList<>();
		cartas_imgn = new ImageIcon[imgns.size()];

		for (int i = 0; i < cartas.length / 2; i++) {
			imgns.add(new ImageIcon(i + 1 + ".jpg"));
			imgns.add(new ImageIcon(i + 1 + ".jpg"));
		}

		Collections.shuffle(imgns);

		cartas_imgn = imgns.toArray(cartas_imgn);

		for (int i = 0; i < cartas.length; i++) {
			cartas[i].setText(imgns.get(i).toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == inicio && catchitem == "Seleccione") {
			JOptionPane.showMessageDialog(null, "Selecciona una de las opciones.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		if (e.getSource() == inicio && catchitem == "Basico") {
			panelpares.setLayout(new GridLayout(2, 4));
			n = 8;
			dificultad.setEnabled(false);
			inicio.setEnabled(false);
			Juego();
		}
		if (e.getSource() == inicio && catchitem == "Medio") {
			panelpares.setLayout(new GridLayout(3, 4));
			n = 12;
			dificultad.setEnabled(false);
			inicio.setEnabled(false);
			Juego();
		}
		if (e.getSource() == inicio && catchitem == "Experto") {
			panelpares.setLayout(new GridLayout(4, 4));
			n = 24;
			dificultad.setEnabled(false);
			inicio.setEnabled(false);
			Juego();
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getItem() == "Seleccione") {
			catchitem = e.getItem().toString();
		}

		if (e.getItem() == "Basico") {
			catchitem = e.getItem().toString();
		}

		if (e.getItem() == "Medio") {
			catchitem = e.getItem().toString();
		}

		if (e.getItem() == "Experto") {
			catchitem = e.getItem().toString();
		}

	}

	public void mouseClicked(MouseEvent e) {
		String second_card = new String();

		for (int i = 0; i < cartas.length; i++) {

			if (e.getSource() == cartas[i]) {
				ImageIcon ajustar_imgns = new ImageIcon(cartas_imgn[i].getImage()
						.getScaledInstance(cartas[0].getWidth(), cartas[0].getHeight(), Image.SCALE_SMOOTH));
				if (first_card != null) {
					second_card = cartas[i].getText();

					cartas[i].setIcon(ajustar_imgns);

					cartas[i].update(cartas[i].getGraphics());
					for (int j = 0; j < 1; j++) {
						try {
							Thread.sleep(1000);
						} catch (Exception a) {
							System.out.println(a);
						}
						if (first_card.equals(second_card)) {
							cartas[i].setEnabled(false);
							aux_primera.setEnabled(false);

							aux_primera = null;
							first_card = null;
						} else {

							cartas[i].setIcon(ajustar_interrogacion);
							aux_primera.setIcon(ajustar_interrogacion);

							aux_primera = null;
							first_card = null;

						}
					}
					first_card = null;
					return;
				}

				first_card = cartas[i].getText();
				aux_primera = cartas[i];

				cartas[i].setIcon(ajustar_imgns);
				return;
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}