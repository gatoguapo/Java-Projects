package PracticaTopicos;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

public class MouseEscucha extends JFrame implements MouseListener{
	private JLabel btn1, btn2, btn3;
	private Color original;
	public MouseEscucha () {
		
		btn1 = new JLabel();
		
		btn1.setBounds(0,0,50,50);
		btn1.setBackground(Color.BLUE);
		btn1.setOpaque(true);
		btn1.addMouseListener(this);
		
		add(btn1);
	}
	 
	public static void main(String[] args) {
		MouseEscucha obj1 = new MouseEscucha();
		obj1.setSize(300,300);
		obj1.setLocationRelativeTo(null);
		obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj1.setVisible(true);
		obj1.setResizable(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == btn1) {
			btn1.setBackground(Color.GREEN);
		}
		if (e.getSource() == btn2) {
			btn2.setBackground(Color.GREEN);
		}
		if (e.getSource() == btn3) {
			btn3.setBackground(Color.GREEN);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == btn1) {
			btn1.setBackground(Color.PINK);
		}
		if (e.getSource() == btn2) {
			btn2.setBackground(Color.PINK);
		}
		if (e.getSource() == btn3) {
			btn3.setBackground(Color.PINK);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btn1) {
			btn1.setBackground(Color.BLUE);
		}
		if (e.getSource() == btn2) {
			btn2.setBackground(Color.RED);
		}
		if (e.getSource() == btn3) {
			btn3.setBackground(Color.YELLOW);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() == btn1) {
			btn1.setBackground(original);
		}
		if (e.getSource() == btn2) {
			btn2.setBackground(original);
		}
		if (e.getSource() == btn3) {
			btn3.setBackground(original);
		}
		
	}

}
