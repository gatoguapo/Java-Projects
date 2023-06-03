package Unidad1;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings("serial")
public class Espiral extends JFrame implements ActionListener {
	int n = 0;
	private JPanel panelespiral, panelopciones;
	private JButton[][] btns;
	private JButton inicio;
	private JTextField longitud;
	private JLabel etiqueta;

	public Espiral() {
		super("ESPIRAL");
		HazInterfaz();
		HazEscuchas();
	}

	private void HazEspiral() {
		panelespiral = new JPanel();
		
		panelespiral.setLayout(new GridLayout(0, n));

		btns = new JButton[n][n];

		for (int j = 0; j < btns.length; j++) {
			for (int i = 0; i < btns.length; i++) {
				btns[i][j] = new JButton();
				panelespiral.add(btns[i][j]);
			}
		}
		add(panelespiral, BorderLayout.CENTER);
		
		
		
		setVisible(true);
	}

	private void HazInterfaz() {

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		panelopciones = new JPanel();
		panelopciones.setLayout(new GridLayout(0, 3, 15, 0));
		add(panelopciones, BorderLayout.NORTH);
		
		longitud = new JTextField();
		inicio = new JButton("Inicio");
		etiqueta = new JLabel("Introduzca la longitud: ");
		
		panelopciones.add(inicio);
		panelopciones.add(etiqueta);
		panelopciones.add(longitud);
		
		setVisible(true);
	}

	private void HazEscuchas() {
		inicio.addActionListener(this);
		longitud.addActionListener(this);
	}

	public static void main(String[] args) {
		new Espiral();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Random random = new Random();
		try {
			if (Integer.parseInt(longitud.getText()) != 0) {
				n = Integer.parseInt(longitud.getText());
				HazEspiral();
				inicio.setEnabled(false);
				longitud.setEnabled(false);
			}
		} catch (Exception a) {
			JOptionPane.showMessageDialog(null, "Ingresa un valor a la longitud.",
					"ERROR",JOptionPane.ERROR_MESSAGE);
			return;
		}

		int a = 0;
		int b = n - 1;
		int c = n * n;
		Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));

		while (c != 0) {
			// primera fila de izq a der
			for (int i = a; i <= b; i++) {
				btns[i][a].setBackground(color);
				btns[i][a].update(btns[i][a].getGraphics());
				c--;
				try {
					Thread.sleep(25);
				} catch (Exception ee) {

				}
			}
			// ultima columna arriba a abajo
			for (int i = a + 1; i <= b; i++) {
				btns[b][i].setBackground(color);
				btns[b][i].update(btns[b][i].getGraphics());
				c--;
				try {
					Thread.sleep(25);
				} catch (Exception ee) {

				}
			}
			// ultima fila de der a izq
			for (int i = b - 1; i >= a; i--) {
				btns[i][b].setBackground(color);
				btns[i][b].update(btns[i][b].getGraphics());
				c--;
				try {
					Thread.sleep(25);
				} catch (Exception ee) {

				}
			}
			// primer columna abajo a arriba
			for (int i = b - 1; i >= a + 1; i--) {
				btns[a][i].setBackground(color);
				btns[a][i].update(btns[a][i].getGraphics());
				c--;
				try {
					Thread.sleep(25);
				} catch (Exception ee) {

				}
			}
			b--;
			a++;
			color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
		}
	}
}