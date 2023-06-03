package Unidad1EjemplosDeClase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ComboCajaTexto extends JFrame implements ActionListener, FocusListener, ItemListener, KeyListener{
	
	JTextField txtNombre,txtEdad;
	JComboBox  cmbNivel, cmbGenero, cmbEstados, cmbCiudades;
	JButton btn;
	Color bgTxt;
	String []ve=new String [] {"Seleccione","Aguas calientes","BC",
			"BCS","SONORA","SINALOA","NAYARIT"};
	String [][] mc = { {},{"Aguas Calientes","Calvillo","Tesala"},{"Tijuana","Mexicali","Ensenada"},{"La Paz","Los Cabos"},
			{"Hermosillo","Cd.Obregon","Nogales","Navojoa"},{"Culiacan","Mazatlán","Gasave"},{"Tepic","Ixtlan","Acaponeta"}   };
	
	public ComboCajaTexto() {
		super("Manejo de combo y caja de texto");
		HazInterfaz();
		HazEscuchas();
		
	}
	private void HazInterfaz() {
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2,5,5));
		
		txtNombre=new JTextField();
		txtEdad=new JTextField();
		bgTxt=txtNombre.getBackground();
		
		String [] nivel= {"Seleccione","Basico","Medio","Experto"};
		cmbNivel=new JComboBox(nivel);
		
		cmbGenero= new JComboBox( new String [] {"Seleccione","Masculino","Femenino"});
		
		add(new JLabel("Nombre",JLabel.RIGHT));
		add(txtNombre);
		
		add(new JLabel("Edad",JLabel.RIGHT));
		add(txtEdad);
		
		add(new JLabel("Nivel",JLabel.RIGHT));
		add(cmbNivel);
		
		add(new JLabel("Genero",JLabel.RIGHT));
		add(cmbGenero);
		

		cmbEstados=new JComboBox( ve);
		cmbCiudades=new JComboBox();
		add(new JLabel("Estados",JLabel.RIGHT));
		add(cmbEstados);
		
		add(new JLabel("Ciudades",JLabel.RIGHT));
		add(cmbCiudades);
		
		btn=new JButton("imprime contenido");
		add(btn);
		
		
		setVisible(true);
		
	}
	private void HazEscuchas() {
		txtNombre.addKeyListener(this);
		txtEdad.addKeyListener(this);
		txtNombre.addActionListener(this);
		txtEdad.addActionListener(this);
		
		txtNombre.addFocusListener(this);
		txtEdad.addFocusListener(this);
		
		cmbNivel.addActionListener(this);
		cmbGenero.addActionListener(this);
		
		cmbNivel.addItemListener(this);
		cmbGenero.addItemListener(this);
		
		cmbEstados.addItemListener(this);
		
		
		
	}
	public static void main(String[] args) {
		new ComboCajaTexto();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==txtNombre) {
			if(txtNombre.getText().length()==0) {
				Rutinas.Mensaje("debe de escribir nombre");
				return;
			}
			if( !Valida(txtNombre.getText())) {
				Rutinas.Mensaje("el nombre debe de llevar solo letras y blancos");
				return;
			}
			txtEdad.requestFocus();
			return;
		}
		if(e.getSource()==txtEdad) {
			int edad=0;
			try {
			   edad=Integer.parseInt(txtEdad.getText());
			} catch(Exception ex) {
				Rutinas.Mensaje("Lo escrito es edad no representa un valor numéricos");
				return;
			}
			if(edad<18 || edad>60) {
				Rutinas.Mensaje("Edad incorrecta, raqngo válido 18-60");
				return;
			}
			cmbNivel.requestFocus();
			return;
		}	
		if(e.getSource()==cmbNivel) {
			System.out.println("combo nivel: INDICE "+cmbNivel.getSelectedIndex());
			System.out.println("combo nivel: INDICE "+cmbNivel.getSelectedItem());
			return;
		}
		if( e.getSource()==cmbGenero) {
			System.out.println("combo nivel: INDICE "+cmbGenero.getSelectedIndex());
			System.out.println("combo nivel: INDICE "+cmbGenero.getSelectedItem());
			
			return;
		}
	}
	private boolean Valida(String nombre) {
		char car;
		nombre=nombre.toUpperCase();
		for(int i=0 ; i<nombre.length(); i++) {
			car=nombre.charAt(i);
			
			if( car !=' ' && car<'A' || car>'Z' )
				return false;
		}
		return true;
	}
	@Override
	public void focusGained(FocusEvent e) {
		JTextField aux=(JTextField) e.getSource();
		
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		JTextField aux=(JTextField) e.getSource();
		
		aux.setBackground(bgTxt);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange() != ItemEvent.SELECTED ) {
			return;	
		}
		
		if(e.getSource()==cmbNivel) {
			System.out.println("***combo nivel: INDICE "+cmbNivel.getSelectedIndex());
			System.out.println("combo nivel: INDICE "+cmbNivel.getSelectedItem());
			return;
		}
		if( e.getSource()==cmbGenero) {
			System.out.println("***combo genero: INDICE "+cmbGenero.getSelectedIndex());
			System.out.println("combo genero: INDICE "+cmbGenero.getSelectedItem());
			
			return;
		}
		
		if(e.getSource()==cmbEstados) {
			System.out.println("***combo genero: INDICE ");
			System.out.println("combo genero: INDICE "+cmbEstados.getSelectedItem());
			int estado=cmbEstados.getSelectedIndex();
			cmbCiudades.removeAllItems();
			cmbCiudades.addItem("Seleccione");
			for(int i=0 ; i < mc[estado].length ; i++) {
				cmbCiudades.addItem(mc[estado][i]);
			}
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(txtNombre.getText());
		System.out.println(txtEdad.getText());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}