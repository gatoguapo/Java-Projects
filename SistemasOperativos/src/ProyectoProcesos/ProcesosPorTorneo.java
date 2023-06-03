package ProyectoProcesos;

import java.util.ArrayList;

public class ProcesosPorTorneo extends Thread{
	
	private  ArrayList<Procesos> listaTorneo;
	private int tAparicion, duracion, prioridad;
	private Semaforo semaforo;
	
	public ProcesosPorTorneo(int tAparicion, int duracion, int prioridad, Semaforo semaforo, ArrayList<Procesos> listaTorneo) {
		this.tAparicion = tAparicion;
		this.duracion = duracion;
		this.prioridad = prioridad;
		this.semaforo = semaforo;
		this.listaTorneo = listaTorneo;
	}
	
	public void run() {	
		for (int i=0;i<5;i++) {
			semaforo.Espera();
			listaTorneo.add(new Procesos(getName(),tAparicion, duracion, prioridad));
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			semaforo.Libera();
		}
	}

	public ArrayList<Procesos> getListaTorneo() {
		return listaTorneo;
	}
}
