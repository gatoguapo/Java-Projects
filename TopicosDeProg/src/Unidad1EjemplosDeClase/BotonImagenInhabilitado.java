package Unidad1EjemplosDeClase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BotonImagenInhabilitado extends JFrame implements ActionListener{
	JButton btn1,btn2;
	
	
	public BotonImagenInhabilitado() {
		super("Botón inhabilitado con imagen visible");
		HazInterfaz();
		HazEscuchas();
		
	}
	private void HazInterfaz() {
		setSize(150,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,1));
		
		btn1=new JButton("Poner imagen");
		btn2=new JButton("deshabilitar");
		
		add(btn1);
		add(btn2);
		
		setVisible(true);
	}
	private void HazEscuchas() {
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	public static void main(String[] args) {
		new BotonImagenInhabilitado();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			ImageIcon caballo = new ImageIcon("caballo.png");
			ImageIcon imagen=new ImageIcon(caballo.getImage().getScaledInstance(btn1.getWidth(),btn1.getHeight(),Image.SCALE_SMOOTH));
			btn1.setIcon(imagen);
			imagen=new ImageIcon(Rutinas.AjustarImagen("avion.jpg", btn1.getWidth(), btn1.getHeight()).getImage());
			btn2.setIcon(imagen);
			return;
		}
		if(e.getSource()==btn2) {
			btn2.setEnabled(false);
			btn1.setEnabled(false);
			ImageIcon caballo = new ImageIcon("caballo.png");
			ImageIcon imagen=new ImageIcon(caballo.getImage().getScaledInstance(btn1.getWidth(),btn1.getHeight(),Image.SCALE_SMOOTH));
			btn1.setDisabledIcon(imagen);
			imagen=new ImageIcon(Rutinas.AjustarImagen("avion.jpg", btn1.getWidth(), btn1.getHeight()).getImage());
			btn2.setDisabledIcon(imagen);

			
			return;
		}
	}

}