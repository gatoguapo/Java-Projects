package ProyectoProcesos;

import java.util.ArrayList;
import java.util.Collections;

public class ProyectoProcesos {

	private ArrayList<Procesos> procesos;

	public ProyectoProcesos(ArrayList<Procesos> procesosOtraClase) {
		procesos = procesosOtraClase;

		HazPorTorneo();
		System.out.println();
		HazPorPrioridad();
		System.out.println();
		HazMasCorto();
		System.out.println();
		PorPolitica();
	}

	public void HazPorTorneo() {
		System.out.println("------------- POR TORNEO -------------");
		System.out.printf("%4s %8s %8s %8s", "Proceso", "Llegada", "Duracion", "Prioridad\n");
		Collections.sort(procesos, Procesos.TAparicionComparador);
		for (Procesos e : procesos) {
			System.out.printf("%4d %8d %8d %8d", e.getNumero(), e.getTiempoDeInicio(), e.getDuracion(),
					e.getPrioridad());
			System.out.println();
		}
		System.out.println();

		System.out.println("Proceso " + procesos.get(0).getNumero() + " llega en el segundo "
				+ procesos.get(0).getTiempoDeInicio() + " y termina en el segundo "
				+ ((procesos.get(0).getTiempoDeInicio() + procesos.get(0).getDuracion())));

		for (int i = 1; i < procesos.size(); i++) {
			System.out.println("Proceso " + procesos.get(i).getNumero() + " llega en el segundo "
					+ procesos.get(i).getTiempoDeInicio() + " y termina en el segundo "
					+ ((procesos.get(i).getTiempoDeInicio() + procesos.get(i).getDuracion()
							+ (procesos.get(i - 1).getTiempoDeInicio() + procesos.get(i).getDuracion()))));
		}
	}

	public void HazPorPrioridad() {
		System.out.println("------------- POR PRIORIDAD ------------- ");
		System.out.printf("%4s %8s %8s %8s", "Proceso", "Llegada", "Duracion", "Prioridad\n");
		Collections.sort(procesos, Procesos.PrioridadComparador);
		for (Procesos e : procesos) {
			System.out.printf("%4d %8d %8d %8d", e.getNumero(), e.getTiempoDeInicio(), e.getDuracion(),
					e.getPrioridad());
			System.out.println();
		}

		System.out.println();

		int tAparicion;
		for (int i = 0; i < procesos.size(); i++) {
			tAparicion = procesos.get(i).getTiempoDeInicio() + procesos.get(i).getDuracion();
			System.out.println("Proceso " + procesos.get(i).getNumero() + " llega en el segundo "
					+ procesos.get(i).getTiempoDeInicio() + " y termina en el segundo "
					+ ((procesos.get(i).getTiempoDeInicio() + procesos.get(i).getDuracion())
							+ (tAparicion + procesos.get(i).getDuracion())));
		}
	}

	public void HazMasCorto() {
		System.out.println("----------- MAS CORTO PRIMERO -----------");
		System.out.printf("%4s %8s %8s %8s", "Proceso", "Llegada", "Duracion", "Prioridad\n");
		Collections.sort(procesos, Procesos.DuracionComparador);
		for (Procesos e : procesos) {
			System.out.printf("%4d %8d %8d %8d", e.getNumero(), e.getTiempoDeInicio(), e.getDuracion(),
					e.getPrioridad());
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("Proceso " + procesos.get(0).getNumero() + " llega en el segundo "
				+ procesos.get(0).getTiempoDeInicio() + " y termina en el segundo "
				+ ((procesos.get(0).getTiempoDeInicio() + procesos.get(0).getDuracion())));

		for (int i = 1; i < procesos.size(); i++) {
			System.out.println("Proceso " + procesos.get(i).getNumero() + " llega en el segundo "
					+ procesos.get(i).getTiempoDeInicio() + " y termina en el segundo "
					+ ((procesos.get(i).getTiempoDeInicio() + procesos.get(i).getDuracion()
							+ (procesos.get(i - 1).getTiempoDeInicio() + procesos.get(i).getDuracion()))));
		}
	}

	public void PorPolitica() {
		System.out.println("----------- POR POLITICA -----------");
		System.out.printf("%4s %8s %8s %8s", "Proceso", "Llegada", "Duracion", "Prioridad\n");

		int sumaDur = 0;
		for (int i = 0; i < procesos.size(); i++) {
			sumaDur += procesos.get(i).getDuracion();
		}
		int mediaDuracion = sumaDur / procesos.size();

		for (Procesos e : procesos) {
			System.out.printf("%4d %8d %8d %8d %8d", e.getNumero(), e.getTiempoDeInicio(), e.getDuracion(),
					e.getPrioridad(), mediaDuracion);
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("Proceso " + procesos.get(0).getNumero() + " llega en el segundo "
				+ procesos.get(0).getTiempoDeInicio() + " y termina en el segundo "
				+ ((procesos.get(0).getTiempoDeInicio() + procesos.get(0).getDuracion())));

		for (int i = 1; i < procesos.size(); i++) {
			System.out.println("Proceso " + procesos.get(i).getNumero() + " llega en el segundo "
					+ procesos.get(i).getTiempoDeInicio() + " y termina en el segundo "
					+ ((procesos.get(i).getTiempoDeInicio() + procesos.get(i).getDuracion()
							+ (procesos.get(i - 1).getTiempoDeInicio() + procesos.get(i).getDuracion()))));
		}
	}
}
