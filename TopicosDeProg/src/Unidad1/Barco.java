package Unidad1;

import java.awt.*;
import javax.swing.*;

public class Barco {

	private JPanel panel_barcos, panel_puertos;
	private JButton[] barcos;
	private ImageIcon[] barcos_imgns;
	private int n;
	static int[] capacidad, redes;
	private JLabel[][] puertos;

	public JPanel HazBarcos() {
		panel_barcos = new JPanel();
		panel_barcos.setSize(600, 200);
		panel_barcos.setLayout(new GridLayout(0, 1));

		barcos = new JButton[setN()];
		barcos_imgns = new ImageIcon[barcos.length];

		for (int i = 0; i < barcos.length; i++) {
			barcos[i] = new JButton();
			barcos_imgns[i] = new ImageIcon(i + 1 + ".jpg");
			panel_barcos.add(barcos[i]);
		}
		return panel_barcos;
	}

	public JButton[] getBarcoButton() {
		return barcos;
	}

	public void BarcosImgns() {
		for (int i = 0; i < barcos.length; i++) {
			ImageIcon ajustar_barcos = new ImageIcon(
					barcos_imgns[i].getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH));
			barcos[i].setIcon(ajustar_barcos);
			barcos[i].setText(i+"");
		}
	}

	public JPanel HazPuertos() {
		puertos = new JLabel[barcos.length][8];
		panel_puertos = new JPanel();
		panel_puertos.setLayout(new GridLayout(0, 8));

		for (int i = 0; i < puertos.length; i++) {
			for (int j = 0; j < puertos[0].length; j++) {
				puertos[i][j] = new JLabel("0", JLabel.CENTER);
				panel_puertos.add(puertos[i][j]);

			}
		}
		return panel_puertos;
	}

	public int setN() {
		return n = (int) (Math.random() * (10 - 5) + 5);
	}

	public int[] setCapacidad() {
		capacidad = new int[barcos.length];
		for (int i = 0; i < capacidad.length; i++) {
			capacidad[i] = (int) (Math.random() * (90 - 60) + 60);
		}
		return capacidad;
	}

	public int[] setRedes() {
		redes = new int[barcos.length];
		for (int i = 0; i < redes.length; i++) {
			redes[i] = (int) (Math.random() * (30 - 20) + 20);
		}
		return redes;
	}

	public void primeraVuelta(int barco_num) {
		for (int i = 0; i < puertos.length; i++) {
			for (int j = 0; j < puertos[0].length; j++) {
				puertos[barco_num][j].setText("1");
			}
		}
	}
}
