package Unidad3;

import java.awt.*;
import javax.swing.*;

public class FilosofosComensales extends JFrame {
	Graphics g;
	Image myImagen = null;
	Semaforo[] tenedores;
	Filosofo[] filosofos;
	boolean[] ocupado;
	JLabel[] filosofo_nombre, tenedores_imagenes;
	JPanel[] panel_nombres, panel_tenedor;
	
	
	public static void main(String args[]) {
		new FilosofosComensales();
	}

	public FilosofosComensales() {
		HazInterfaz();
		myImagen = createImage(getWidth(), getHeight());
		g = myImagen.getGraphics();
		Mesa();
	}

	public void HazInterfaz() {
		setSize(900, 700);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public void Mesa() {
		filosofos = new Filosofo[5];
		tenedores = new Semaforo[filosofos.length + 1];
		ocupado = new boolean[filosofos.length + 1];

		for (int i = 0; i < tenedores.length; i++) {
			tenedores[i] = new Semaforo(1);
		}

		for (int i = 0; i < filosofos.length; i++) {
			System.out.println(i + 1);
			filosofos[i] = new Filosofo(tenedores, ocupado, i + 1);
		}

		for (int i = 0; i < filosofos.length; i++) {
			filosofos[i].setName("Filosofo " + (i + 1));
		}

		for (int i = 0; i < filosofos.length; i++) {
			filosofos[i].start();
		}

		
	}

	public void paint(Graphics gl) {
		Dibuja();
		gl.drawImage(myImagen, 0, 0, getWidth(), getHeight(), this);
	}

	public void Dibuja() {
		if (g == null)
			return;
		super.paint(g);

		// mesa
		ImageIcon filosofos = new ImageIcon("Filosofos.png");
		g.drawImage(filosofos.getImage(), 0, 0, getWidth(), getHeight(), this);

		filosofo_nombre = new JLabel[5];
		panel_nombres = new JPanel[5];

		filosofo_nombre[0] = new JLabel("Albert Camus");
		filosofo_nombre[1] = new JLabel("Nietzche");
		filosofo_nombre[2] = new JLabel("Schopenhauer");
		filosofo_nombre[3] = new JLabel("Socrates");
		filosofo_nombre[4] = new JLabel("Rene Descartes");
		
		for(int i=0;i<panel_nombres.length;i++) {
			panel_nombres[i] = new JPanel();
		}
			
		panel_nombres[0].setBounds(370, -9, 100, 100);
		panel_nombres[0].setBackground(Color.white);
		panel_nombres[1].setBounds(80, 170, 100, 100);
		panel_nombres[1].setBackground(Color.white);
		panel_nombres[2].setBounds(110, 440, 100, 100);
		panel_nombres[2].setBackground(Color.white);
		panel_nombres[3].setBounds(570, 450, 100, 100);
		panel_nombres[3].setBackground(Color.white);
		panel_nombres[4].setBounds(640, 170, 100, 100);
		panel_nombres[4].setBackground(Color.white);
		
		for(int i=0;i<panel_nombres.length;i++) {
			panel_nombres[i].add(filosofo_nombre[i]);
			add(panel_nombres[i]);
		}
		
		ImageIcon tenedor_img = new ImageIcon("caballo.png");
		
		tenedores_imagenes = new JLabel[5];
		panel_tenedor = new JPanel[5];
		
		for(int i=0;i<tenedores_imagenes.length;i++) {
			tenedores_imagenes[i] = new JLabel();
			panel_tenedor[i] = new JPanel();
			tenedores_imagenes[i].setIcon(tenedor_img);	
			panel_tenedor[i].add(tenedores_imagenes[i]);
			add(panel_tenedor[i]);
		}
		
		tenedores_imagenes[0].setBounds(100,100,100,100);
		tenedores_imagenes[1].setBounds(100,100,100,100);
		setVisible(true);
	}
}
