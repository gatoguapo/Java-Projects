package PracticaTopicos;

import java.awt.*;

import javax.swing.*;

public class Grid extends JFrame {

	public Grid() {
		setLayout(new GridLayout(5,2,10,10));
		add(new JButton("1"));
		add(new JButton("2"));
		add(new JButton("3"));
		add(new JButton("4"));
		add(new JButton("5"));
		add(new JButton("6"));
		add(new JButton("7"));
		add(new JButton("8"));
		add(new JButton("9"));
		
	}

	public static void main(String[] args) {
		Grid grid = new Grid();
		grid.setSize(500, 500);
		grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grid.setVisible(true);
	}

}
