package Unidad2;

import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;


@SuppressWarnings("serial")
public class ComponenteMarcas extends JPanel implements ComponentListener, KeyListener, ActionListener {

	private JCheckBox[] check_marcas;
	private JScrollPane sc_marcas;
	private Marcas marcas;
	private JPanel panel_marcas;
	private JTextField txt_buscar;
	private JLabel etiqueta_buscar;
	private JButton btn_limpiar;
	private String busqueda;
	
	public ComponenteMarcas() {
		HazInterfaz();
		HazEscuchas();
	}

	public void HazInterfaz() {
		setLayout(null);
		setSize(500,600);

		txt_buscar = new JTextField();
		panel_marcas = new JPanel();
		marcas = new Marcas();
		sc_marcas = new JScrollPane();
		btn_limpiar = new JButton("Limpiar");
		etiqueta_buscar = new JLabel("Buscar");
		
		panel_marcas.setLayout(new BoxLayout(panel_marcas, BoxLayout.Y_AXIS));
		
		busqueda = "";
		
		check_marcas = new JCheckBox [marcas.getBusqueda(busqueda).size()];
		

		for (int i = 0; i < check_marcas.length; i++) {
			check_marcas[i] = new JCheckBox();
		}

		for (int i = 0; i < check_marcas.length; i++) {
			check_marcas[i].setText(marcas.getBusqueda(busqueda).elementAt(i).toString());
			panel_marcas.add(check_marcas[i]);
			sc_marcas = new JScrollPane(panel_marcas);
		}
	}

	public void HazBusqueda() {
		panel_marcas.removeAll();

		busqueda = txt_buscar.getText();
		
		check_marcas = new JCheckBox [marcas.getBusqueda(busqueda).size()];
		
		for (int i = 0; i < check_marcas.length; i++) {
			check_marcas[i] = new JCheckBox();
		}
		
		for (int i = 0; i < check_marcas.length; i++) {
			check_marcas[i] = new JCheckBox();
			check_marcas[i].setText(marcas.getBusqueda(busqueda).elementAt(i).toString());
			panel_marcas.add(check_marcas[i]);
		}
		panel_marcas.revalidate();
		panel_marcas.update(panel_marcas.getGraphics());
	}

	public void HazEscuchas() {
		this.addComponentListener(this);
		txt_buscar.addKeyListener(this);
		btn_limpiar.addActionListener(this);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		int h = getHeight();
		int w = getWidth();

		etiqueta_buscar.setBounds((int) (w * 0.03), (int) (h * 0.02), (int) (w * 0.85), (int) (h * 0.04));
		txt_buscar.setBounds((int) (w * 0.13), (int) (h * 0.015), (int) (w * 0.85), (int) (h * 0.06));
		sc_marcas.setBounds((int) (w * 0.03), (int) (h * 0.08), (int) (w * 0.95), (int) (h * 0.80));
		btn_limpiar.setBounds((int) (w * 0.03), (int) (h * 0.90), (int) (w * 0.30), (int) (h * 0.07));

		add(btn_limpiar);
		add(sc_marcas);
		add(etiqueta_buscar);
		add(txt_buscar);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		HazBusqueda();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		txt_buscar.setText("");
		for (int i = 0; i < check_marcas.length; i++) {
			check_marcas[i].setSelected(false);
		}

		HazBusqueda();

		panel_marcas.revalidate();
		panel_marcas.update(panel_marcas.getGraphics());
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

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
