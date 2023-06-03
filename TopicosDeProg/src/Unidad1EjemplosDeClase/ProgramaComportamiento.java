package Unidad1EjemplosDeClase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ProgramaComportamiento extends JFrame implements ActionListener, MouseListener {
	private JButton btn, btnNorte,btnSur;
	Color original;
	public ProgramaComportamiento() {
		HazInterfaz();
		HazEscuchas();
	}
	public void HazInterfaz() {
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn=new JButton();
		btnNorte=new JButton("Norte");	
		btnSur=new JButton("Sur");
		add(btn);
		add(btnNorte,BorderLayout.NORTH);
		add(btnSur,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	public void HazEscuchas() {
		btn.addActionListener(this);
		btnNorte.addActionListener(this);
		btnSur.addActionListener(this);
		
		btn.addMouseListener(this);
		btnNorte.addMouseListener(this);
		btnSur.addMouseListener(this);
	}
	
	
	
	public static void main(String[] args) {
		new ProgramaComportamiento();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	 
		if(e.getSource() == btn) {
		     btn.setBackground(Color.red);
		     return;
		}
		if(e.getSource() == btnNorte) {
		     btnNorte.setBackground(Color.green);
		     return;
		}	
		if(e.getSource() == btnSur) {
		     btnSur.setBackground(Color.ORANGE);
		     return;
		}
		
		JButton aux = (JButton) e.getSource();
		aux.setBackground(Color.RED);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		original=btn.getBackground();
		if (arg0.getSource() == btn) {
			btn.setBackground(Color.BLUE);
		}
		if (arg0.getSource() == btnNorte) {
			btnNorte.setBackground(Color.BLUE);
		}
		if (arg0.getSource() == btnSur) {
			btnSur.setBackground(Color.BLUE);
		}
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		btn.setBackground(original);
		btnNorte.setBackground(original);
		btnSur.setBackground(original);
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource() == btn) {
			btn.setBackground(Color.black);
		}
		if (arg0.getSource() == btnNorte) {
			btnNorte.setBackground(Color.black);
		}
		if (arg0.getSource() == btnSur) {
			btnSur.setBackground(Color.black);
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
			
	}

}
