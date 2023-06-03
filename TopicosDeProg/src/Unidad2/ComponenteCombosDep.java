package Unidad2;

import java.awt.event.*;
import javax.swing.*;

public class ComponenteCombosDep extends JPanel implements ComponentListener, ItemListener {

	private JComboBox combo_estados, combo_municipios, combo_ciudades;
	private CombosDependientes obj_combodep;
	private JLabel lbl_estados, lbl_municipios, lbl_ciudades;
	private String[] estados, municipios, ciudades;
	private static int id_estado, id_municipio;
	private static boolean selected_municipio = false;

	public ComponenteCombosDep() {
		HazInterfaz();
		HazEscuchas();
	}

	public ComponenteCombosDep(String estado) {
		HazInterfaz();
		id_estado = obj_combodep.getEstadosConstructor(estado);
		if (id_estado==0) {
			JOptionPane.showMessageDialog(null, "Ingrese un estado o municipio valido en el constructor" , "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		combo_estados.setSelectedIndex(id_estado);
		HazEscuchas();
	}
	
	public ComponenteCombosDep(String estado, String municipio) {
		try {
			HazInterfaz();
			id_estado = obj_combodep.getEstadosConstructor(estado);
			id_municipio = obj_combodep.getMunicipiosConstructor(id_estado, municipio);
			HazEscuchas();
			combo_estados.setSelectedIndex(id_estado);
			combo_municipios.setSelectedIndex(id_municipio);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese un municipio valido en el constructor" , "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void HazInterfaz() {
		setLayout(null);
		setSize(500, 600);

		obj_combodep = new CombosDependientes();

		lbl_estados = new JLabel("Estados");
		lbl_municipios = new JLabel("Municipios");
		lbl_ciudades = new JLabel("Ciudades");

		estados = obj_combodep.getEstados();

		combo_estados = new JComboBox();
		combo_estados.addItem("Selecciones");
		for (int i = 0; i < estados.length; i++) {
			combo_estados.addItem(estados[i]);
		}

		combo_municipios = new JComboBox();
		combo_municipios.setEnabled(false);

		combo_ciudades = new JComboBox();
		combo_ciudades.setEnabled(false);
	}

	public void HazEscuchas() {
		this.addComponentListener(this);
		combo_estados.addItemListener(this);

		combo_municipios.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() != ItemEvent.SELECTED) {
			return;
		}

		if (e.getSource() == combo_estados) {
			combo_municipios.setEnabled(true);

			id_estado = combo_estados.getSelectedIndex();

			combo_municipios.removeAllItems();
			combo_municipios.addItem("Seleccione");
			municipios = obj_combodep.getMunicipios(id_estado);
			for (int i = 0; i < municipios.length; i++) {
				combo_municipios.addItem(municipios[i]);
			}
			selected_municipio = true;
			return;
		}

		if (e.getSource() == combo_municipios && selected_municipio) {
			combo_ciudades.setEnabled(true);
			id_municipio = combo_municipios.getSelectedIndex();
			combo_ciudades.removeAllItems();
			combo_ciudades.addItem("Seleccione");
			ciudades = obj_combodep.getCiudades(id_estado, id_municipio);
			for (int i = 0; i < ciudades.length; i++) {
				combo_ciudades.addItem(ciudades[i]);
			}
			selected_municipio = false;
			return;
		}
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		int w = getWidth();
		int h = getHeight();

		lbl_estados.setBounds((int) (w * 0.03), (int) (h * 0.02), (int) (w * 0.10), (int) (h * 0.04));
		combo_estados.setBounds((int) (w * 0.14), (int) (h * 0.015), (int) (w * 0.18), (int) (h * 0.05));
		lbl_municipios.setBounds((int) (w * 0.33), (int) (h * 0.02), (int) (w * 0.16), (int) (h * 0.04));
		combo_municipios.setBounds((int) (w * 0.46), (int) (h * 0.015), (int) (w * 0.18), (int) (h * 0.05));
		lbl_ciudades.setBounds((int) (w * 0.65), (int) (h * 0.02), (int) (w * 0.16), (int) (h * 0.04));
		combo_ciudades.setBounds((int) (w * 0.77), (int) (h * 0.015), (int) (w * 0.18), (int) (h * 0.05));

		add(lbl_estados);
		add(combo_estados);
		add(lbl_municipios);
		add(combo_municipios);
		add(lbl_ciudades);
		add(combo_ciudades);
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub

	}

}
