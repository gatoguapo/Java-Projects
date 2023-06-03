package Unidad1EjemplosDeClase;

import javax.swing.*;
import java.awt.*;

public class PrimerPrograma {
	static private JButton btn1,btn2,btn3,btn4,btn5;
	
	public static void main(String[] args) {
		JFrame pan = new JFrame("Instituto TECNOLÓGICO");
		
		pan.setSize(300, 300);
		pan.setLocationRelativeTo(null);
		pan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pan.setLayout(new GridLayout(0,2,5,5);
		
		btn1=new JButton("btn1");
		btn2=new JButton("btn2");
		btn3=new JButton("btn3");
		btn5=new JButton("btn5");
		btn4=new JButton("btn4");

			
		btn2.setSize(100,300);
		pan.add(btn1);
		pan.add(btn2,BorderLayout.SOUTH);
		pan.add(btn3,BorderLayout.NORTH);
		pan.add(btn4,BorderLayout.EAST);
		pan.add(btn5,BorderLayout.WEST);
		
		pan.setVisible(true);

	}

}
