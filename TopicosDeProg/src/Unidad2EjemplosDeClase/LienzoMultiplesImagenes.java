package Unidad2EjemplosDeClase;

import javax.swing.*;

import Unidad1EjemplosDeClase.Rutinas;

import java.awt.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class LienzoMultiplesImagenes extends Canvas implements ActionListener{
	String [] imagenes;
	int pos;
	Timer t;
	public LienzoMultiplesImagenes(String [] a) {
		imagenes=a;
		pos=0;
		t=new Timer(300,this);
		t.start();
	}
	public void paint(Graphics g) 	{
		g.drawImage(Rutinas.AjustarImagen(imagenes[pos%imagenes.length], this.getWidth(), this.getHeight()).getImage(), 0, 0,null);
		g.drawString("EJEMPLO DEL LLIENZO EN CANVAS", 20, 20);
	//	g.drawImage(Rutinas.AjustarImagen("avion.png", 50, 50).getImage(), 1+xAvion, this.getHeight()-55,null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		pos++;
		repaint();
		
	}

}
