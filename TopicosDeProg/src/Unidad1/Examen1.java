package Unidad1;

//Alumno:Victor Ramon Grande Espinoza
//Grupo:1:00-2:00.
//Materia:Topicos Avanzados.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Examen1 extends JFrame implements ActionListener {

	JPanel panel_puertos;
	JButton barcos_aux[];
	ImageIcon barcos_imgns[];
	JLabel puertos[], Kgs;
	String puertos_noms[];
	int[] capacidad, redes, destino;
	int n, lim_sup = 30, lim_inf = 20;
	private Barco obj_barco = new Barco();

	public static void main(String[] args) {
		new Examen1();
	}

	public Examen1() {
		HazInterfaz();
		HazEscuchas();
	}

	public void HazInterfaz() {
		setSize(1200, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel_puertos = new JPanel();
		panel_puertos.setLayout(new GridLayout(0, 9));
		puertos_noms = new String[] { "", "Ensenada", "La paz", "Guaymas", "Topolaban", "Mazatlan", "Vallarta",
				"Manzanillo", " Lazaro" };
		puertos = new JLabel[puertos_noms.length];

		for (int i = 0; i < puertos.length; i++) {
			puertos[i] = new JLabel(puertos_noms[i], JLabel.RIGHT);
			panel_puertos.add(puertos[i]);
		}
		add(panel_puertos, BorderLayout.NORTH);
		
		add(obj_barco.HazBarcos(), BorderLayout.WEST);
		add(obj_barco.HazPuertos(), BorderLayout.CENTER);
		
		obj_barco.BarcosImgns();
		
		this.setVisible(true);
	}

	public void HazEscuchas() {
		for (int i = 0; i < obj_barco.getBarcoButton().length; i++) {
			obj_barco.getBarcoButton()[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < obj_barco.getBarcoButton().length; i++) {
			if (e.getSource() == obj_barco.getBarcoButton()[i]) {
				System.out.println(obj_barco.getBarcoButton()[i].getText());
				obj_barco.primeraVuelta(Integer.parseInt(obj_barco.getBarcoButton()[i].getText()));
			}
		}
	}

}
