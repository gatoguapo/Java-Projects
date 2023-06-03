package Unidad1EjemplosDeClase;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
public class COMPONENTES extends JFrame implements ActionListener{
	JMenuBar barra;
	JMenu autos,paises,continentes, restoAutos;
	JMenuItem deportivos, trabajo, paseo;
	
	
	JMenuItem mexico, usa, canada;
	public COMPONENTES() {
		super("MENEJO DE COMPONENTES");
		HazInterfaz();
		HazEscuchas();
	}
	public void HazInterfaz() {
		setSize(400,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2,5,5));
		
		// Agregar Etiquteas
		
		add(new JLabel("Etiqueta",JLabel.CENTER));
		add(new JLabel("Etiqueta",JLabel.CENTER));
		
		
		add(new JLabel("Etiqueta con imagen",JLabel.CENTER));
		JLabel etiqueta=new JLabel(new ImageIcon(Rutinas.AjustarImagen("avion.jpg", 50, 50).getImage()));
		add(etiqueta);
		
		add(new JLabel("Etiqueta con texto  e imagen",JLabel.CENTER));
		etiqueta=new JLabel("mi avión",new ImageIcon("avion.jpg"),JLabel.CENTER);
		add(etiqueta);
		
		// cajas de texto
		
		add(new JLabel("Caja de texto",JLabel.CENTER));
		JTextField txt=new JTextField();
		txt.setText( Rutinas.nextNombre(2));
		add(txt);

		add(new JLabel("Caja de texto con valor",JLabel.CENTER));
		txt=new JTextField("ESTE ES EL VALOR ASIGNADO POR SIEMPRE");
		add(txt);

		add(new JLabel("Caja de texto con valor NUMÉRICO",JLabel.CENTER));
		txt=new JTextField(20);
		add(txt);	
		// AGREGAR BOTONES
		
		JButton btn=new JButton();
		add(new JLabel("botón tradicional",JLabel.CENTER));
		add(btn);
		
		btn=new JButton("Grabar");
		add(new JLabel("botón con texto",JLabel.CENTER));
		add(btn);
		
		ImageIcon imagen=new ImageIcon(Rutinas.AjustarImagen("caballo.png", 50, 50).getImage());
		btn=new JButton(imagen);
		JButton btnAux=btn;
		
		add(new JLabel("botón con imagen",JLabel.CENTER));
		add(btn);
		
		btn=new JButton("Caballo",new ImageIcon("caballo.png"));
		add(new JLabel("botón con imagen-texto",JLabel.CENTER));
		add(btn);
		
	// COMBOS
		
		JComboBox cmb=new JComboBox();
		add(new JLabel("combo vacio",JLabel.CENTER));
		add(cmb);
		
		String [] estaciones= {"seleccione","Primavera","Verano","Otoño","Invierno"};
		cmb=new JComboBox(estaciones);
		add(new JLabel("combo información",JLabel.CENTER));
		add(cmb);
		
		// Botones de tipo RADIO
		
		JRadioButton radio=new JRadioButton();
		add(new JLabel("radio button",JLabel.CENTER));
		add(radio);
		
		radio=new JRadioButton("Mascúlino");
		add(new JLabel("radio button con texto",JLabel.CENTER));
		add(radio);	
		setVisible(true);
		System.out.println(btn.getWidth()+" altura "+btn.getHeight());
		
		imagen=new ImageIcon(Rutinas.AjustarImagen("caballo.png", btnAux.getWidth(), btnAux.getHeight()).getImage());
		btnAux.setIcon(imagen);
		
		// menu
		barra=new JMenuBar();
	     setJMenuBar(barra);
	     barra.setBackground(Color.cyan);
		
	     autos=new JMenu("Autos");
	     paises=new JMenu("Paises");
	     continentes=new JMenu("Continentes");
	     
	     barra.add(autos);
	     barra.add(paises);
	     barra.add(continentes);

	     deportivos=new JMenuItem("Deportivos");
	     trabajo= new JMenuItem("Trabajo");
	     paseo=new JMenuItem("Paseo");
	     restoAutos=new JMenu("Resto");
	     autos.add(deportivos);
	     autos.add(trabajo);
	     autos.add(paseo);
	     autos.add(restoAutos);
		
		mexico=new JMenuItem("México");
		usa=new JMenuItem("USA");
		canada=new JMenuItem("Canada");
		paises.add(mexico);
		paises.add(usa);
		paises.add(canada);
		
		
		
	}
	public void HazEscuchas() {
		mexico.addActionListener(this);
	}
	public static void main(String[] args) {
		new COMPONENTES();

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		mexico.setEnabled(false);
		Rutinas.Mensaje("SE PULSÓ LA OPCIÓN MÉXICO");
		
	}

}
