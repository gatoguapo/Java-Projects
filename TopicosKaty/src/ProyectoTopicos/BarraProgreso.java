package ProyectoTopicos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
 
public class BarraProgreso extends JFrame implements ActionListener{

	public JProgressBar barra;
	public JToggleButton Onof;
	static Timer timer;
	
	public BarraProgreso() {
		super("Ventana de progreso");
		
	}
	
	public void hazInterfaz() {
		setBounds(100, 100, 394, 269);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		barra = new JProgressBar();
		barra.setBounds(106,37,175,29);
		barra.setStringPainted(true);
		barra.setForeground(Color.green);
		barra.setBackground(Color.lightGray);
		barra.setBorder(new LineBorder(Color.DARK_GRAY));
		barra.setVisible(true);
		add(barra);
		
		Onof = new JToggleButton("On / Of");
		Onof.addActionListener(this);
		Onof.setBounds(146,88,100,29);
		add(Onof);
		
		timer = new Timer(100, new ActionListener() {
			private int x = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				barra.setValue(x++);
				if (x>100) {
					
					timer.stop();
					JOptionPane.showMessageDialog(null, "Progress Completed");
					
					x=0;
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (Onof.isSelected()) {
			timer.start();
		} else {
			timer.stop();
		}
	}
	
}