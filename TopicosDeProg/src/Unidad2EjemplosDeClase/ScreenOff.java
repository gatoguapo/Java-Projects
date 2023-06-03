package Unidad2EjemplosDeClase;

import java.awt.*;
import javax.swing.*;

import Unidad1EjemplosDeClase.Rutinas;

import java.awt.event.*;


public class ScreenOff extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnAvanzar, btnTriangulo, btnRectangulo, btnCirculo;
	int x=0, xAvion=0;
	Timer t;
	JPanel panel;
	Graphics g;
	Image myImagen = null;	
	
	boolean band=true, bandAvion=true, bandCirculo=false,bandTriangulo=false;
	
	public ScreenOff() {
		super("MANEJO DE GRAFICOS screen off");
		HazInterfaz();
		HazEscuchas();
		t=new Timer(300,this);
		t.start();
		myImagen = createImage(getWidth(), getHeight());
		g =myImagen.getGraphics();
	}
	
	public void HazInterfaz() {
		setSize(600,500);
		setLocationRelativeTo(null);
		
		btnAvanzar=new JButton("Avanzar");
		add(btnAvanzar,BorderLayout.SOUTH);
		panel=new JPanel();
		panel.setLayout(new GridLayout(0,1));
		
		btnTriangulo=new JButton("Triangulo");
		btnCirculo=new JButton("Circulo");
		btnRectangulo=new JButton("Rectangulo");
		
		panel.add(btnTriangulo);
		panel.add(btnCirculo);
		panel.add(btnRectangulo);
		
		add(panel,BorderLayout.EAST);
		
		
		setVisible(true);
	}
	public void HazEscuchas() {
		btnAvanzar.addActionListener(this);
		btnCirculo.addMouseListener(this);
		btnTriangulo.addMouseListener(this);
		btnRectangulo.addMouseListener(this);
	}
	
	public void paint( Graphics gl) 	{
		 Dibuja();
		   gl.drawImage(myImagen, 0, 0, getWidth(), getHeight(), this);		
	}
	
	private void Dibuja() {
		if(g==null)
			return;
		super.paint(g);
	       g.drawString("INSTITUTO TECNOLÓGICO DE CULIACÁN",50,40);
	        g.drawLine(20,45,300,45);
	        g.drawString("INGENIERÍA EN SISTEMAS COMPUTACIONALES",50,60);
	        g.setColor(Color.BLUE);
	        g.fillRect(50,70,100,50);
	        g.fillRoundRect(250, 70,100, 50, 20, 20);
	        Color CAFE=new Color(192,128,64);
	        g.setColor(CAFE);
	        g.fillRect(50+x,150,200,100);
	        g.setColor(Color.RED);
	        g.fillOval(60+x,220,60,60);
	        g.fillOval(190+x,220,50,60);
	        g.setColor(Color.WHITE);
	        g.fillRect(200+x,160,50,30);
	        if(bandAvion)
	            g.drawImage( Rutinas.AjustarImagen(  "1.jpg", 60, 60).getImage() ,5+xAvion   , 400   ,null);
	        else
	        	g.drawImage( Rutinas.AjustarImagen(  "1.jpg", 60, 60).getImage() ,5+xAvion   , 400   ,null);
	        if(bandCirculo) {
	        	 g.setColor(CAFE);
	        	g.fillOval(this.getWidth()/2-50,this.getHeight()/2-50,100,100);
	        }
	        if(bandTriangulo) {
	        	int [] vx= {400,300,500};
		    	   int [] vy= {400,500,500};
		    	   g.setColor(Color.red);
		    	   g.fillPolygon(vx,vy,vx.length);
	        	
	        }
	}
	public static void main(String [] a) {
		new ScreenOff();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource()==btnAvanzar) {
			if (x<0 || x+270>this.getWidth())
				band=!band;
			if(band)
			   x+=10;
			else
				x-=10;

			repaint();
			return;
		}
		if(e.getSource()==t) {
			if (xAvion<0 || xAvion+80>this.getWidth())
				bandAvion=!bandAvion;
			if(bandAvion)
			   xAvion+=10;
			else
				xAvion-=10;
			
			repaint();
		}
		
	}
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		if(e.getSource()==btnCirculo) {
			bandCirculo=true;
			repaint();
			return;
		}
		if(e.getSource()==btnTriangulo) {
			bandTriangulo=true;
			repaint();

			return;
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnCirculo) {
			bandCirculo=false;
			repaint();
			return;
		}
		if(e.getSource()==btnTriangulo) {
			bandTriangulo=false;
			repaint();
			return;
		}		
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

