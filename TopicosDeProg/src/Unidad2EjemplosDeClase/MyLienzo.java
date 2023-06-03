package Unidad2EjemplosDeClase;

import javax.swing.*;

import Unidad1EjemplosDeClase.Rutinas;

import java.awt.*;
import java.awt.event.*;

public class MyLienzo extends Canvas implements ActionListener{
	private String nomImagen;
	private int xAvion;
	Timer t;
	boolean bandAvion;
	public MyLienzo() {
		this("caballo.png");
	}
	
	public MyLienzo(String nomImagen) {
		this.nomImagen=nomImagen;
		xAvion=0;
		t=new Timer(300,this);
		t.start();
		bandAvion=true;
	}
	public void paint(Graphics g) 	{
		g.drawImage(Rutinas.AjustarImagen(nomImagen, this.getWidth(), this.getHeight()).getImage(), 0, 0,null);
		g.drawString("EJEMPLO DEL LIENZO EN CANVAS", 20, 20);
		g.drawImage(Rutinas.AjustarImagen("1.jpg", 50, 50).getImage(), 1+xAvion, this.getHeight()-55,null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (xAvion<0 || xAvion+80>this.getWidth())
			bandAvion=!bandAvion;
		if(bandAvion)
		   xAvion+=10;
		else
			xAvion-=10;
		
		repaint();
	}
}
