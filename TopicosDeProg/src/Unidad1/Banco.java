package Unidad1;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Banco extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panel_centro, panel_derecha, panel_derecha_tbl, panel_importe_cpts, panel_titulo,
			panel_derecha_titulo, panel_importe_tbl, panel_inventario_btns;
	private JButton btn_cambiar, btn_ocultar, btn_agrega;
	private JTextField cuadro_importe;
	private JTable tabla_distribucion, tabla_inventario;
	private DefaultTableModel columna_distribucion, columna_inventario;
	static int monto;
	boolean cambio = false;
	static Billetes distrbill = new Billetes();

	public static void main(String[] args) {
		new Banco();
	}

	public Banco() {
		super("Banco del cambio");
		HazInterfaz();
		HazEscuchas();
	}

	public void HazInterfaz() {
		setSize(840, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		panel_centro = new JPanel();
		panel_derecha = new JPanel();
		panel_titulo = new JPanel();
		panel_derecha_titulo = new JPanel();

		panel_centro.setLayout(new BorderLayout());
		panel_derecha.setLayout(new BorderLayout());

		panel_centro.setBackground(new Color(249, 231, 215));
		panel_derecha.setBackground(new Color(249, 231, 215));
		panel_derecha_titulo.setBackground(new Color(249, 231, 215));
		panel_titulo.setBackground(new Color(250, 215, 160));

		panel_derecha_titulo.add(new JLabel("Inventario de billetes"));
		panel_derecha.add(panel_derecha_titulo, BorderLayout.NORTH);

		panel_titulo.add(new JLabel("BANCO DEL CAMBIO"));
		panel_titulo.add(new JLabel("Caja #1"));

		add(panel_titulo, BorderLayout.NORTH);

		PanelDistribucion();
		PanelInventario();

		add(panel_centro);
		add(panel_derecha, BorderLayout.EAST);
		this.setVisible(true);
	}

	public void PanelDistribucion() {
		btn_cambiar = new JButton("Cambiar");
		cuadro_importe = new JTextField("Ingrese Importe");

		panel_importe_cpts = new JPanel();
		panel_importe_cpts.setLayout(new FlowLayout());
		panel_importe_tbl = new JPanel();

		tabla_distribucion = new JTable();
		tabla_distribucion.setPreferredScrollableViewportSize(new Dimension(400, 400));

		String[] colmsdistrinucion = new String[] { "Denominacion", "Numero Billetes" };

		columna_distribucion = new DefaultTableModel();
		columna_distribucion.setColumnIdentifiers(colmsdistrinucion);
		tabla_distribucion.setModel(columna_distribucion);

		JScrollPane sc_distribucion = new JScrollPane(tabla_distribucion);

		panel_importe_cpts.setBackground(new Color(249, 231, 215));
		panel_importe_tbl.setBackground(new Color(249, 231, 215));

		panel_importe_cpts.add(new JLabel("IMPORTE"), BorderLayout.NORTH);
		panel_importe_cpts.add(cuadro_importe, BorderLayout.NORTH);
		panel_importe_cpts.add(btn_cambiar, BorderLayout.NORTH);

		panel_importe_tbl.add(sc_distribucion, BorderLayout.CENTER);

		panel_centro.add(panel_importe_cpts, BorderLayout.NORTH);
		panel_centro.add(panel_importe_tbl, BorderLayout.CENTER);
		
		btn_cambiar.addActionListener(this);
	}

	public void PanelInventario() {
		tabla_inventario = new JTable();
		panel_inventario_btns = new JPanel();
		panel_derecha_tbl = new JPanel();
		columna_inventario = new DefaultTableModel();

		tabla_inventario.setPreferredScrollableViewportSize(new Dimension(380, 300));

		panel_inventario_btns.setLayout(new FlowLayout());
		panel_inventario_btns.setBackground(new Color(249, 231, 215));
		panel_derecha_tbl.setBackground(new Color(249, 231, 215));

		btn_ocultar = new JButton("Ocultar");
		btn_agrega = new JButton("Agrega billetes");

		String[] colmsinventario = new String[] { "Denominacion", "Cantidad" };

		columna_inventario.setColumnIdentifiers(colmsinventario);
		tabla_inventario.setModel(columna_inventario);

		TablaInventario();

		JScrollPane sc_inventario = new JScrollPane(tabla_inventario);

		panel_derecha_tbl.add(sc_inventario);

		panel_derecha.add(panel_derecha_tbl, BorderLayout.CENTER);
		panel_derecha.add(panel_inventario_btns, BorderLayout.SOUTH);
		panel_inventario_btns.add(btn_ocultar, BorderLayout.SOUTH);
		panel_inventario_btns.add(btn_agrega, BorderLayout.SOUTH);
	}

	public void TablaDistribucion() {
		ArrayList<Denominacion> distribucion = new ArrayList<>();

		distrbill.setMonto(monto);
		distrbill.Cambiador(distribucion);

		Object[] distribuciondatos = new Object[distribucion.size()];

		while (columna_distribucion.getRowCount() > 0) {
			columna_distribucion.removeRow(0);
		}

		for (Denominacion e : distribucion) {
			distribuciondatos[0] = e.getDenominacion();
			distribuciondatos[1] = e.getNumbilletes();
			columna_distribucion.addRow(distribuciondatos);
		}
	}

	public void TablaInventario() {
		ArrayList<Inventario> inventario = new ArrayList<>();
		while (columna_inventario.getRowCount() > 0) {
			columna_inventario.removeRow(0);
		}

		try {
			distrbill.Abrir();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		distrbill.Cambia(inventario);

		Object[] inventario_datos = new Object[inventario.size()];

		for (Inventario e : inventario) {
			inventario_datos[0] = e.getDenominacion();
			inventario_datos[1] = e.getCantidad();
			columna_inventario.addRow(inventario_datos);
		}
	}

	public void HazEscuchas() {
		btn_ocultar.addActionListener(this);
		btn_agrega.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_ocultar) {
			if (!cambio) {
				panel_derecha_tbl.setVisible(false);
				btn_ocultar.setText("Mostrar");
				cambio = true;
				return;
			}
			if (cambio) {
				panel_derecha_tbl.setVisible(true);
				btn_ocultar.setText("Ocultar");
				cambio = false;
				return;
			}
		}

		if (e.getSource() == btn_cambiar) {
			try {
				monto = Integer.parseInt(cuadro_importe.getText().toString());
				if (monto < 0) {
					JOptionPane.showMessageDialog(null, "No puede ingresar una cantidad negativa", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				TablaDistribucion();
				TablaInventario();
			} catch (ArrayIndexOutOfBoundsException i) {
				JOptionPane.showMessageDialog(null, "Ingresa un importe valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (NumberFormatException i) {
				JOptionPane.showMessageDialog(null, "Ingresa un importe valido.", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (e.getSource() == btn_agrega) {
			try {
				distrbill.Agrega();
				TablaInventario();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}

class Denominacion {
	private int denominacion, numbilletes;

	public Denominacion() {

	}

	public Denominacion(int denominacion, int numbilletes) {
		this.denominacion = denominacion;
		this.numbilletes = numbilletes;
	}

	public int getDenominacion() {
		return denominacion;
	}

	public int getNumbilletes() {
		return numbilletes;
	}

}