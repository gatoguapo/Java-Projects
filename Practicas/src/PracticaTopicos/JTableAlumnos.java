package PracticaTopicos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class JTableAlumnos extends JFrame implements ActionListener {

	private JTable tbl;
	private DefaultTableModel modelo;
	private JPanel opciones;
	private JTextField nombre, edad, calificaciones;
	private ArrayList<Alumno> datosAlum;
	private Object[] datos;
	private JButton inicio;
	int id;

	public JTableAlumnos() {
		super("TABLA DE ALUMNOS");
		HazInterfaz();
		HazEscuchas();
	}

	public static void main(String[] args) {
		new JTableAlumnos();
	}

	public void HazInterfaz() {
		setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		datosAlum = new ArrayList<>();

		inicio = new JButton("Inicio");
		opciones = new JPanel();
		nombre = new JTextField("Introduzca su nombre", 10);
		edad = new JTextField();
		calificaciones = new JTextField();

		opciones.setLayout(new GridLayout(0, 2));

		opciones.add(new JLabel("Nombre del alumno:"));
		opciones.add(nombre);

		opciones.add(new JLabel("Edad del alumno:"));
		opciones.add(edad);

		opciones.add(new JLabel("Calificaciones:"));
		opciones.add(calificaciones);

		opciones.add(inicio);

		tbl = new JTable();

		add(opciones, BorderLayout.NORTH);
		String[] colmns = new String[] { "ID", "NombreAlumno", "Edad", "Calificaciones" };
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(colmns);
		tbl.setModel(modelo);

		JScrollPane sp = new JScrollPane(tbl);
		add(sp, BorderLayout.CENTER);

		setVisible(true);

	}

	public void HazEscuchas() {
		inicio.addActionListener(this);
	}

	public void InsertarAlumnos() {

		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}

		datos = new Object[10];

		id = 1;

		for (Alumno e : datosAlum) {

			datos[0] = id++;
			datos[1] = e.getNom();
			datos[2] = e.getEdad();
			datos[3] = e.getCalif();
			modelo.addRow(datos);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == inicio) {
			Alumno alumno = new Alumno();
			alumno.setAlumnoID(id);
			alumno.setEdad(Integer.parseInt(edad.getText().toString()));
			alumno.setCalif(Integer.parseInt(calificaciones.getText().toString()));
			alumno.setNom(nombre.getText().toString());
			datosAlum.add(alumno);
			InsertarAlumnos();
		}
	}
}

class Alumno {

	private int alumnoID, edad, calif;

	private String nom;

	public Alumno(int alumnoID, int edad, int calif, String nom) {
		this.alumnoID = alumnoID;
		this.edad = edad;
		this.calif = calif;
		this.nom = nom;
	}

	public void setAlumnoID(int alumnoID) {
		this.alumnoID = alumnoID;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void setCalif(int calif) {
		this.calif = calif;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public int getAlumnoID() {
		return alumnoID;
	}

	public int getEdad() {
		return edad;
	}

	public int getCalif() {
		return calif;
	}

	public String getNom() {
		return nom;
	}

}