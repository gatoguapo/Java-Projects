package Unidad2EjemplosDeClase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControladorHanoi implements ActionListener{
	VistaHanoi vista;
	ModeloHanoi modelo;
	int nDiscos;
	public ControladorHanoi(VistaHanoi vista,ModeloHanoi modelo, int nDiscos) {
		this.vista=vista;
		this.modelo=modelo;
		this.nDiscos=nDiscos;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vista.btnIniciar) {
			modelo.Hanoi('A','B','C',nDiscos);
			vista.getNDiscos(nDiscos);
			vista.Imprime(modelo.getMovtos());
		}
		
	}

}