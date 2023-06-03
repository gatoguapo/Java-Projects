package Unidad1EjemplosDeClase;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
public class JTableModel extends JFrame implements ActionListener{

	JTable tbl;
	DefaultTableModel modelo;
	JButton btnMostrar,btnBorrar,btnModificar;
	
	public JTableModel() {
		super("Manejo de tabla y modelo");
		HazInterfaz();
		HazEscuchas();
	}
	public void HazInterfaz() {
		setSize(600,500);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		String [] cols= {"ID","Nombre","Edad (años)","Estatura (cm)"};
		tbl=new JTable();
		modelo=new DefaultTableModel() ;
		modelo.setColumnIdentifiers(cols);
		tbl.setModel(modelo);
		
		Agrega();
		JScrollPane sp =new JScrollPane(tbl);
		add(sp);
		
		JPanel panel=new JPanel();
		//panel.setLayout(new GridLayout(0,3));
		btnMostrar=new JButton("Mostrar");
		btnBorrar = new JButton("Borrar");
		btnModificar=new JButton("Modificar");
		panel.add(btnMostrar);
		panel.add(btnBorrar);
		panel.add(btnModificar);
		add(panel,BorderLayout.SOUTH);
		setVisible(true);
	}
	public void HazEscuchas() {
		btnMostrar.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnModificar.addActionListener(this);
	}
	private void Agrega() {
		Vector fila;
		for(int i=0 ; i<300; i++) {
			fila=new Vector();

			fila.addElement(i+1);
			fila.addElement(Rutinas.nextNombre(2));
			fila.addElement(Rutinas.nextInt(18,60));
			fila.addElement(Rutinas.nextInt(160, 190));
			modelo.addRow(fila);
		}
	}
	public static void main(String[] args) {
		new JTableModel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource()==btnMostrar) {
			
			return;
		}
		if( e.getSource()==btnBorrar) {
			
			return;
		}
		if( e.getSource()==btnModificar) {
			
			return;
		}
	}

}