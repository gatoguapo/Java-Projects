package Proyecto;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Edificio extends JFrame{
	
	MyPanel panel; {
	
	}
	
	Edificio() {
	
	panel = new MyPanel();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(1400,700);
	
	this.add(panel);
	this.pack();
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	}
	
	
}
