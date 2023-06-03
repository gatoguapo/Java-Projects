package Unidad1EjemplosDeClase;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Espiral extends JFrame implements ActionListener, MouseListener{
	
	JButton [] btns ;
	JButton btnInicio;
	Color bg;
	
	public Espiral() {
		super("ESPIRAL");
		HazInterfaz();
		HazEscuchas();
	}
	private void HazInterfaz() {
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(0,10));
		
		btns=new JButton[100];
		for(int i=0 ; i<btns.length ; i++) {
			btns[i]=new JButton("");
			panel.add(btns[i]);
		}
		add(panel);
		btnInicio=new JButton("Inicio");
		add(btnInicio,BorderLayout.SOUTH);
		setVisible(true);
	}
	private void HazEscuchas() {
		
		btnInicio.addActionListener(this);
		for(int i=0 ; i<100 ; i++) {
			btns[i].addActionListener(this);
			btns[i].addMouseListener(this);
		}
	}
	public static void main(String[] args) {
		new Espiral();

	}
	@Override
	public void actionPerformed(ActionEvent e) {

		int pos=0;
		for(int i=0 ; i<btns.length ; i++) {
			if(e.getSource()==btns[i]) {
				pos=i;
				break;
			}
		}
		btns[pos].setBackground(Color.YELLOW);

	JButton aux=(JButton) e.getSource();
	aux.setBackground(Color.cyan);
		if(e.getSource()==btnInicio) {
			for(int i=0 ; i<btns.length ; i++) {
				btns[i].setBackground(Color.yellow);
				//validate();
				//repaint();
				btns[i].update(btns[i].getGraphics());
				try {
					Thread.sleep(100);
				} catch (Exception ee) {

				}
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {

	
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}