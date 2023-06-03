package Proyecto;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel extends JPanel{
	
	MyPanel () {
		this.setPreferredSize(new Dimension(1000,1000));
		
	}
	
public void paint(Graphics g) {
		super.paint(g);
	    
		Graphics2D g2D = (Graphics2D) g;
		
	     
		//fondo 
		GradientPaint Degra1 = new GradientPaint(0,0, new Color( 160, 215, 235 ), 0, 550, new Color( 215, 237, 248 ), false);
	    g2D.setPaint(Degra1); 
		g2D.fillOval(80, 100, 1000, 1000);
		
		
		//edificio 1
		/*g2D.setColor(new Color(215, 229, 178));
		g2D.fillRect(260, 620, 140, 180);
		g2D.setColor(new Color(219, 215, 188));
		g2D.fillRect(232, 608, 175, 12);
		g2D.setColor(new Color(248, 246, 233));
		g2D.fillRect(230, 593, 180, 15);
		
		//sombra 1
		g2D.setColor(new Color(168, 179, 136));
		g2D.fillRect(240, 620, 20, 180);
		
		//ventanas 1
		
		GradientPaint Degra2 = new GradientPaint(280,630, new Color( 70, 199, 241 ), 280, 680, new Color( 215, 237, 248 ), false);
	    g2D.setPaint(Degra2);
		g2D.fillRect(280, 630, 50, 80);
		g2D.fillRect(340, 630, 50, 80);
		GradientPaint Degra3 = new GradientPaint(280,735, new Color(215, 237, 248 ), 280, 760, new Color(  70, 199, 241), false);
	    g2D.setPaint(Degra3);
		g2D.fillRect(340, 715, 50, 80);
		g2D.fillRect(280, 715, 50, 80);
		
		//edificio 4
		
		g2D.setColor(new Color(110, 132, 192));
		g2D.fillRect(680, 380, 150, 420);
		
		
		//sombras 4
		
		int x[] = new int[]{680,660,720,810};
		int y[] = new int[]{355, 300,300,355};
		g.setColor(new Color(186, 206, 233));
		g.fillPolygon(x,y,4);
		 
		int x1[] = new int[]{620,640,660,680};
		int y1[] = new int[]{355, 300,300,355};
		g2D.setColor(new Color(150, 173, 204));
		g2D.fillPolygon(x1,y1,4);
		
		g2D.setColor(new Color(75, 98, 148));
		g2D.fillRect(680, 365, 150, 15);
		g2D.setColor(new Color(42, 67, 105));
		g2D.fillRect(610, 365, 70, 15);
		g2D.setColor(new Color(186, 204, 226));
		g2D.fillRect(680, 353, 155, 12);
		g2D.setColor(new Color(110, 134, 168));
		g2D.fillRect(605, 353, 75, 12);
		g2D.setColor(new Color(69, 97, 147));
		g2D.fillRect(610, 380, 70, 420);
		
		//ventanas 4
		
		GradientPaint Degra7 = new GradientPaint(635 ,715, new Color( 70, 199, 241 ), 645, 625, new Color( 215, 237, 248 ), false);
	    g2D.setPaint(Degra7);
		g2D.fillRect(615, 775, 60, 15);
		g2D.fillRect(615, 750, 60, 15);
		g2D.fillRect(615, 725, 60, 15);
		g2D.fillRect(615, 700, 60, 15);
		g2D.fillRect(615, 675, 60, 15);
		g2D.fillRect(615, 650, 60, 15);
		g2D.fillRect(615, 625, 60, 15);
		g2D.fillRect(615, 600, 60, 15);
		GradientPaint Degra4 = new GradientPaint(635 ,590, new Color( 70, 199, 241 ), 645, 620, new Color( 215, 237, 248 ), false);
	    g2D.setPaint(Degra4);
		g2D.fillRect(615, 575, 60, 15);
		g2D.fillRect(615, 550, 60, 15);
		g2D.fillRect(615, 525, 60, 15);
		g2D.fillRect(615, 500, 60, 15);
		g2D.fillRect(615, 475, 60, 15);
		g2D.fillRect(615, 450, 60, 15);
		g2D.fillRect(615, 425, 60, 15);
		g2D.fillRect(615, 400, 60, 15);
		
		GradientPaint Degra5 = new GradientPaint(675 ,715, new Color( 70, 199, 241 ), 645, 625, new Color( 215, 237, 248 ), false);
	    g2D.setPaint(Degra5);
		g2D.fillRect(685, 775, 65, 15);
		g2D.fillRect(760, 775, 65, 15);
		g2D.fillRect(685, 750, 65, 15);
		g2D.fillRect(760, 750, 65, 15);
		g2D.fillRect(685, 725, 65, 15);
		g2D.fillRect(760, 725, 65, 15);
		g2D.fillRect(685, 700, 65, 15);
		g2D.fillRect(760, 700, 65, 15);
		g2D.fillRect(685, 675, 65, 15);
		g2D.fillRect(760, 675, 65, 15);
		g2D.fillRect(685, 650, 65, 15);
		g2D.fillRect(760, 650, 65, 15);
		g2D.fillRect(685, 625, 65, 15);
		g2D.fillRect(760, 625, 65, 15);
		g2D.fillRect(685, 600, 65, 15);
		g2D.fillRect(760, 600, 65, 15);
		GradientPaint Degra8 = new GradientPaint(635 ,590, new Color( 70, 199, 241 ), 645, 620, new Color( 215, 237, 248 ), false);
	    g2D.setPaint(Degra8);
		g2D.fillRect(685, 575, 65, 15);
		g2D.fillRect(760, 575, 65, 15);
		g2D.fillRect(685, 550, 65, 15);
		g2D.fillRect(760, 550, 65, 15);
		g2D.fillRect(685, 525, 65, 15);
		g2D.fillRect(760, 525, 65, 15);
		g2D.fillRect(685, 500, 65, 15);
		g2D.fillRect(760, 500, 65, 15);
		g2D.fillRect(685, 475, 65, 15);
		g2D.fillRect(760, 475, 65, 15);
		g2D.fillRect(685, 450, 65, 15);
		g2D.fillRect(760, 450, 65, 15);
		g2D.fillRect(685, 425, 65, 15);
		g2D.fillRect(760, 425, 65, 15);
		g2D.fillRect(685, 400, 65, 15);
		g2D.fillRect(760, 400, 65, 15);
		
		//edificio 3
		
		g2D.setColor(new Color(255, 250, 255));
		g2D.fillRect(500, 490, 140, 310);
		g2D.setColor(new Color(171, 188, 196));
		g2D.fillRect(484, 482, 160, 8);
		g2D.setColor(new Color(248, 252, 255));
		g2D.fillRect(484, 466, 160, 16);
		
		//sombras 3
		g2D.setColor(new Color(168, 185, 203));
		g2D.fillRect(488, 490, 12, 310);
		
		//ventanas 3
		GradientPaint Degra6 = new GradientPaint(500 ,620, new Color( 70, 199, 241 ), 510, 640, new Color( 215, 237, 248 ), false);
	    g2D.setPaint(Degra6);
		g2D.fillRect(508, 500, 17, 50);
		g2D.fillRect(528, 500, 17, 50);
		g2D.fillRect(551, 500, 18, 50);
		g2D.fillRect(572, 500, 17, 50);
		g2D.fillRect(595, 500, 17, 50);
		g2D.fillRect(615, 500, 17, 50);
		
		g2D.fillRect(508, 560, 17, 50);
		g2D.fillRect(528, 560, 17, 50);
		g2D.fillRect(551, 560, 18, 50);
		g2D.fillRect(572, 560, 17, 50);
		g2D.fillRect(595, 560, 17, 50);
		g2D.fillRect(615, 560, 17, 50);
		
		GradientPaint Degra9 = new GradientPaint(550 ,650, new Color( 215, 237, 248 ), 560, 680, new Color(  70, 199, 241), false);
	    g2D.setPaint(Degra9);
		g2D.fillRect(508, 620, 17, 50);
		g2D.fillRect(528, 620, 17, 50);
		g2D.fillRect(551, 620, 18, 50);
		g2D.fillRect(572, 620, 17, 50);
		g2D.fillRect(595, 620, 17, 50);
		g2D.fillRect(615, 620, 17, 50);
		
		g2D.fillRect(508, 680, 17, 50);
		g2D.fillRect(528, 680, 17, 50);
		g2D.fillRect(551, 680, 18, 50);
		g2D.fillRect(572, 680, 17, 50);
		g2D.fillRect(595, 680, 17, 50);
		g2D.fillRect(615, 680, 17, 50);
		
		g2D.fillRect(508, 740, 17, 50);
		g2D.fillRect(528, 740, 17, 50);
		g2D.fillRect(551, 740, 18, 50);
		g2D.fillRect(572, 740, 17, 50);
		g2D.fillRect(595, 740, 17, 50);
		g2D.fillRect(615, 740, 17, 50);
		
		//edificio 2
		g2D.setColor(new Color(247, 226, 199));
		g2D.fillRect(370, 680, 162, 120);
		g2D.setColor(new Color(223, 196, 166));
		g2D.fillRect(368, 675, 167, 05);
		g2D.setColor(new Color(255, 248, 238));
		g2D.fillRect(365, 660, 172, 15);
		
		//ventanas 2
		
		
		GradientPaint Degra = new GradientPaint(430 ,720, new Color(70, 199, 241 ), 435, 740, new Color(215, 237, 248), false);
	    g2D.setPaint(Degra);
		g2D.fillRect(430, 685, 45, 110);
		g2D.fillRect(375, 685, 50, 35);
		g2D.fillRect(375, 725, 50, 35);
		g2D.fillRect(375, 765, 50, 30);
		g2D.fillRect(479, 685, 48, 35);
		g2D.fillRect(479, 725, 48, 35);
		g2D.fillRect(479, 765, 48, 30);
		
		//arbustos 1
	
		g2D.setColor(new Color(112, 164, 79));
		g2D.fillArc(80, 750, 120, 100, 0, 180);
		g2D.fillArc(200, 750, 100, 100, 0, 180);
		g2D.fillArc(155, 765, 70, 70, 0, 180);
		
		//sombras arbustos 1
		
		GradientPaint Degra16 = new GradientPaint(90 ,775, new Color(112, 164, 79), 90, 790, new Color(82, 119, 57), false);
	    g2D.setPaint(Degra16);
		g2D.fillArc(80, 760, 120, 80, 0, 180);
		g2D.fillArc(200, 760, 100, 80, 0, 180);
		g2D.fillArc(155, 772, 70, 55, 0, 180);
		
		//arbustos 2
		g2D.setColor(new Color(112, 164, 79));
		g2D.fillArc(370, 755, 90, 90, 0, 180);
		g2D.setColor(new Color(112, 164, 79));
		g2D.fillArc(470, 760, 80, 80, 0, 180);
		g2D.setColor(new Color(112, 164, 79));
		g2D.fillArc(440, 775, 50, 50, 0, 180);
		g2D.setColor(new Color(112, 164, 79));
		g2D.fillArc(545, 735, 120, 130, 0, 180);
		
		//sombras arbustos2
		
		GradientPaint Degra17 = new GradientPaint(370 ,780, new Color(112, 164, 79), 370, 800, new Color(82, 119, 57), false);
	    g2D.setPaint(Degra17);
		g2D.fillArc(370, 765, 90, 70, 0, 180);
		g2D.fillArc(470, 770, 80, 60, 0, 180);
		g2D.fillArc(440, 782, 50, 35, 0, 180);
		g2D.fillArc(545, 745, 120, 110, 0, 180);
		
		//arbustos 3
		
		g2D.setColor(new Color(112, 164, 79));
		g2D.fillArc(830, 780, 90, 40, 0, 180);
		g2D.setColor(new Color(112, 164, 79));
		g2D.fillArc(890, 740, 110, 120, 0, 180);
		
		//sombras 3
		
		GradientPaint Degra18 = new GradientPaint(830 ,780, new Color(112, 164, 79), 830, 800, new Color(82, 119, 57), false);
	    g2D.setPaint(Degra18);
		g2D.fillArc(830, 780, 90, 40, 0, 180);
		g2D.fillArc(890, 740, 110, 120, 0, 180);
		
		//cesped
		GradientPaint Degra19 = new GradientPaint(00 ,820, new Color(163, 191, 49), 00, 830, new Color(126, 150, 36), false);
	    g2D.setPaint(Degra19);
		g2D.fillRect(00, 800, 1200, 200);
		
		//arboles
			
		g2D.setColor(new Color(164, 89, 60));
		g2D.setStroke(new BasicStroke(3));
		g2D.drawLine(135, 740, 110, 710);
		g2D.drawLine(140, 730, 125, 710);
		g2D.drawLine(132, 732, 150, 715);
		g2D.drawLine(145, 732, 155, 710);
		g2D.fillRect(130, 732, 15, 75);
		
		GradientPaint Degra11 = new GradientPaint(135 ,680, new Color(139, 182, 39), 135, 690, new Color(121, 163, 37), false);
	    g2D.setPaint(Degra11);
		g2D.fillOval(90, 665, 50, 50);
		g2D.fillOval(135, 670, 50, 50);
		g2D.fillOval(113, 635, 50, 60);
		g2D.fillOval(115, 670, 50, 50);
		g2D.fillOval(95, 655, 80, 50);
		
		g2D.setColor(new Color(164, 89, 60));
		g2D.fillRect(210, 730,15, 75);
		g2D.setStroke(new BasicStroke(3));
		g2D.drawLine(210, 730, 200, 710);
		g2D.drawLine(225, 730, 230, 710);
		g2D.drawLine(220, 730, 210, 713);
		g2D.drawLine(210, 730, 230, 713);
		
		GradientPaint Degra12 = new GradientPaint(177 ,690, new Color(139, 182, 39), 176, 700, new Color(121, 163, 37), false);
	    g2D.setPaint(Degra12);
		g2D.fillOval(177, 670, 50, 50);
		g2D.fillOval(210, 665, 50, 55);
		g2D.fillOval(185, 645, 55, 50);
		
		g2D.setColor(new Color(164, 89, 60));
		g2D.fillRect(290, 740, 15, 70);
		g2D.setStroke(new BasicStroke(3));
		g2D.drawLine(290, 740, 280, 720);
		g2D.drawLine(305, 740, 320, 720);
		g2D.drawLine(300, 740, 290, 720);
		g2D.drawLine(295, 740, 310, 720);
		
		GradientPaint Degra13 = new GradientPaint(249 ,700, new Color(21, 161, 39), 250, 710, new Color(18, 137, 33), false);
	    g2D.setPaint(Degra13);
		g2D.fillOval(250, 675, 55, 55);
		g2D.fillOval(290, 680, 55, 50);
		g2D.fillOval(275, 650, 55, 50);
		g2D.fillOval(275, 680, 50, 50);
		
		
		g2D.setColor(new Color(164, 89, 60));
		g2D.fillRect(800, 729,15, 80);
		g2D.setStroke(new BasicStroke(3));
		g2D.drawLine(805, 740, 790, 710);
		g2D.drawLine(810, 740, 830, 710);
		g2D.drawLine(805, 730, 820, 710);
		g2D.drawLine(810, 730, 800, 712);
		
		GradientPaint Degra14 = new GradientPaint(760 ,680, new Color(139, 182, 39), 762, 710, new Color(115, 154, 33), false);
	    g2D.setPaint(Degra14);
		g2D.fillOval(760, 670, 50, 50);
		g2D.fillOval(800, 670, 50, 50);
		g2D.fillOval(770, 640, 50, 50);
		g2D.fillOval(785, 645, 50, 50);
		
		g2D.setColor(new Color(164, 89, 60));
		g2D.fillRect(870, 730,15, 75);
		g2D.setStroke(new BasicStroke(3));
		g2D.drawLine(875, 740, 860, 710);
		g2D.drawLine(890, 710, 880, 750);
		g2D.drawLine(865, 710, 885, 730);
		g2D.drawLine(885, 710, 870, 730);
		
		GradientPaint Degra15 = new GradientPaint(830 ,660, new Color(21, 161, 39), 830, 690, new Color(18, 137, 33), false);
	    g2D.setPaint(Degra15);
		g2D.fillOval(830, 665, 50, 50);
		g2D.fillOval(860, 670, 60, 50);
		g2D.fillOval(835, 640, 50, 50);
		g2D.fillOval(860, 640, 50, 50);
		
		//nubes
		
		GradientPaint Degra20 = new GradientPaint(200 ,520, new Color(238, 238, 239), 200, 537, new Color(232, 232, 255), false);
	    g2D.setPaint(Degra20);	
	    g2D.fillArc(250, 490, 90, 120, 0, 180);
		g2D.fillArc(200, 510, 70, 80, 0, 180);
		g2D.fillArc(320, 510, 70, 80, 0, 180);
		
		GradientPaint Degra21 = new GradientPaint(270 ,360, new Color(238, 238, 239), 270, 390, new Color(232, 232, 255), false);
	    g2D.setPaint(Degra21);	
	    g2D.fillArc(270, 340, 110, 140, 0, 180);
		g2D.fillArc(200, 360, 90, 100, 0, 180);
		g2D.fillArc(360, 360, 90, 100, 0, 180);
	
		GradientPaint Degra22 = new GradientPaint(520 ,160, new Color(238, 238, 239), 520, 180, new Color(232, 232, 255), false);
	    g2D.setPaint(Degra22);	
		g2D.fillArc(520, 140, 90, 120, 0, 180);
		g2D.fillArc(465, 160, 70, 80, 0, 180);
		g2D.fillArc(600, 160, 70, 80, 0, 180);
		
		GradientPaint Degra23 = new GradientPaint(880 ,470, new Color(238, 238, 239), 880, 485, new Color(232, 232, 255), false);
	    g2D.setPaint(Degra23);	
		g2D.fillArc(880, 450, 90, 120, 0, 180);
		g2D.fillArc(830, 470, 70, 80, 0, 180);
		g2D.fillArc(960, 470, 70, 80, 0, 180);*/
	}
}
