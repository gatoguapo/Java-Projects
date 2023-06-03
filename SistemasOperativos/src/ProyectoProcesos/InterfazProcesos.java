package ProyectoProcesos;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

public class InterfazProcesos extends JPanel implements ComponentListener{
	
	private JPanel panelProcesos;
	private JTable tablaTorneo;
	private DefaultTableModel columnaProcesos;
	private JScrollPane scTorneo;
	private ArrayList<Procesos> listaTorneo;
	private Semaforo semaforo;
	
	public InterfazProcesos () {
		HazInterfaz();
		HazEscuchas();
	}
	
	public void HazInterfaz() {
		setLayout(null);
		setSize(500,600);
		
		panelProcesos = new JPanel();
		tablaTorneo = new JTable();
		columnaProcesos = new DefaultTableModel();
		
		String [] columna = {"Proceso","T.Aparición","Duración","Prioridad"};
		columnaProcesos.setColumnIdentifiers(columna);
		tablaTorneo.setModel(columnaProcesos);
		
		ArrayList<Procesos> listaTorneo = new ArrayList<>();
		semaforo = new Semaforo(1);
		
		ProcesosPorTorneo [] hilosTorneos = new ProcesosPorTorneo[10];
		
		for (int i=0;i<hilosTorneos.length;i++) {
			hilosTorneos [i] = new ProcesosPorTorneo((int)(Math.random()*50), (int)(Math.random()*20+1), (int)(Math.random()*3+1), semaforo, listaTorneo);
			hilosTorneos [i].setName("Proceso "+i);
		}
		
		for (int i=0;i<hilosTorneos.length;i++) {
			hilosTorneos [i].start();
			listaTorneo = hilosTorneos[i].getListaTorneo();
		}
		
		Object[] torneoObjetos = new Object[listaTorneo.size()];

		while (columnaProcesos.getRowCount() > 0) {
			columnaProcesos.removeRow(0);
		}

		for (Procesos e : listaTorneo) {
			torneoObjetos[0] = e.getnProceso();
			torneoObjetos[1] = e.gettAparicion();
			torneoObjetos[2] = e.getDuracion();
			torneoObjetos[3] = e.getPrioridad();
			columnaProcesos.addRow(torneoObjetos);
		}
		
		scTorneo = new JScrollPane(tablaTorneo);
	}
	
	public void HazEscuchas() {
		this.addComponentListener(this);
	}
	
	@Override
	public void componentResized(ComponentEvent e) {
		int h = getHeight();
		int w = getWidth();
		
		scTorneo.setBounds((int) (w * 0.03), (int) (h * 0.02), (int) (w * 0.45), (int) (h * 0.54));
		
		add(scTorneo);
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
