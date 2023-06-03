package ProyectoProcesos;

import java.util.*;

public class SimuladorDeProcesos {

	private ArrayList<Procesos> procesos;
	int[] quantum;
	int tiempoDeInicio, prioridad, duracion;

	public SimuladorDeProcesos() {
		quantum = new int[10];
		Arrays.fill(quantum, 2);
		crearProcesos();
		HazPorTorneo();
		System.out.println();
		HazPorPrioridad();
		System.out.println();
		HazMasCorto();
		System.out.println();
		PorPolitica();
		System.out.println();
		listaDeEsperaMultiple();
	}

	public void crearProcesos() {
		procesos = new ArrayList<>();
		System.out.println("- - - SIMULADOR DE UN PLANIFICADOR DE- - -\n"
				+ " - - PROCESOS DE UN SISTEMAS OPERATIVO - -\n" + "- - - - - - - - - - - - - - - - - - - - - -\n ");

		System.out.printf("%4s %8s %8s %8s", "Proceso", "Llegada", "Duracion", "Prioridad\n");
		for (int i = 0; i < 10; i++) {
			tiempoDeInicio = new Random().nextInt(50);
			prioridad = new Random().nextInt(3) + 1;
			duracion = new Random().nextInt(20) + 1;
			System.out.printf("%4d %8d %8d %8d", (i + 1), tiempoDeInicio, duracion, prioridad);
			System.out.println();
			procesos.add(new Procesos((i + 1), tiempoDeInicio, duracion, prioridad));
		}
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - ");
	}

	public void impresion(String planificador) {
		// System.out.printf("%4s %8s %8s %8s %8s", "Proceso", "Llegada", "Duracion",
		// "Prioridad", "Tiempo de salida\n");
		System.out.println("----- " + planificador + " -----");
		for (int i = 0; i < procesos.size(); i++) {
			System.out.printf("%4d %12s %8d", procesos.get(i).getNumero(), " Termino: ",
					procesos.get(i).getTiempoDeSalida());

			System.out.println();
		}
	}

	public void porDosNiveles() {
		Collections.shuffle(procesos);

	}

	public void listaDeEsperaMultiple() {
		ArrayList<Procesos> ejecucion = new ArrayList<>();
		for (int i = 0; i < procesos.size(); i++) {
			ejecucion.add(procesos.get(i));
		}
		int ul = 0;
		Collections.sort(ejecucion, Procesos.TAparicionComparador);
		do {
			ul = 1;
			for (int i = 0; i < ejecucion.size(); i++) {
				int salida = ejecucion.get(i).getTiempoDeSalida();
				if (salida == 0) {
					procesarEsperas(ejecucion.get(i));
				}
			}
			for (int i = 0; i < ejecucion.size(); i++) {
				int aux = ejecucion.get(i).getTiempoDeSalida();
				if (aux == 0)
					ul = 0;
			}
		} while (ul == 0);

		for (Procesos p : ejecucion) {
			// System.out.println("n: " + p.getNumero() + " s:" + p.getTiempoDeSalida());
		}
		Collections.sort(procesos, Procesos.ordenar);
		impresion("LISTA DE ESPERAS MULTIPLES");
	}

	public void procesarEsperas(Procesos proc) {
		int n = proc.getNumero();
		int duracion = proc.getDuracion();
		int inicio = proc.getTiempoDeInicio();
		// System.out.println("P" + n + " d:" + duracion + " t:" + inicio);
		if (duracion > (quantum[n - 1])) {
			proc.setDuracion(duracion - quantum[n - 1]);
			proc.setTiempoDeInicio(inicio + quantum[n - 1]);
			quantum[n - 1] *= 2;
		} else {
			proc.setTiempoDeInicio(inicio + duracion);
			proc.setDuracion(0);
		}
		duracion = proc.getDuracion();
		if (duracion == 0) {
			// System.out.println(proc.getNumero() + " ");
			proc.setTiempoDeSalida(proc.getTiempoDeInicio());
		}

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
		
		int duracionAux[] = new int [10];
		
		for (int i = 1; i < duracionAux.length; i++) {
			duracionAux[i] = procesos.get(i).getDuracion();
		}
		
		for (int i = 1; i < procesos.size(); i++) {
			procesos.get(i).setDuracion(procesos.get(i).getDuracion() + procesos.get(i - 1).getDuracion());
			System.out.println("Proceso " + procesos.get(i).getNumero() + " llega en el segundo "
					+ procesos.get(i).getTiempoDeInicio() + " y termina en el segundo "
					+ ((procesos.get(i).getTiempoDeInicio() + procesos.get(i).getDuracion()
							)));
		}
		
		for (int i = 1; i < duracionAux.length; i++) {
			procesos.get(i).setDuracion(duracionAux[i]);
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

		System.out.println("Proceso " + procesos.get(0).getNumero() + " llega en el segundo "
				+ procesos.get(0).getTiempoDeInicio() + " y termina en el segundo "
				+ ((procesos.get(0).getTiempoDeInicio() + procesos.get(0).getDuracion())));
		
		int duracionAux[] = new int [10];
		
		for (int i = 1; i < duracionAux.length; i++) {
			duracionAux[i] = procesos.get(i).getDuracion();
		}
		
		for (int i = 1; i < procesos.size(); i++) {
			procesos.get(i).setDuracion(procesos.get(i).getDuracion() + procesos.get(i - 1).getDuracion());
			System.out.println("Proceso " + procesos.get(i).getNumero() + " llega en el segundo "
					+ procesos.get(i).getTiempoDeInicio() + " y termina en el segundo "
					+ ((procesos.get(i).getTiempoDeInicio() + procesos.get(i).getDuracion()
							)));
		}
		
		for (int i = 1; i < duracionAux.length; i++) {
			procesos.get(i).setDuracion(duracionAux[i]);
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
		
		int duracionAux[] = new int [10];
		
		for (int i = 1; i < duracionAux.length; i++) {
			duracionAux[i] = procesos.get(i).getDuracion();
		}
		
		for (int i = 1; i < procesos.size(); i++) {
			procesos.get(i).setDuracion(procesos.get(i).getDuracion() + procesos.get(i - 1).getDuracion());
			System.out.println("Proceso " + procesos.get(i).getNumero() + " llega en el segundo "
					+ procesos.get(i).getTiempoDeInicio() + " y termina en el segundo "
					+ ((procesos.get(i).getTiempoDeInicio() + procesos.get(i).getDuracion()
							)));
		}
		
		for (int i = 1; i < duracionAux.length; i++) {
			procesos.get(i).setDuracion(duracionAux[i]);
		}
	}

	public void PorPolitica() {
		System.out.println("----------- POR POLITICA -----------");
		System.out.printf("%4s %8s %8s %8s %4s", "Proceso", "Llegada", "Duracion", "Prioridad", "T.en CPU\n");

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
		
		int duracionAux[] = new int [10];
		
		for (int i = 1; i < duracionAux.length; i++) {
			duracionAux[i] = procesos.get(i).getDuracion();
		}
		
		for (int i = 1; i < procesos.size(); i++) {
			procesos.get(i).setDuracion(procesos.get(i).getDuracion() + procesos.get(i - 1).getDuracion());
			System.out.println("Proceso " + procesos.get(i).getNumero() + " llega en el segundo "
					+ procesos.get(i).getTiempoDeInicio() + " y termina en el segundo "
					+ ((procesos.get(i).getTiempoDeInicio() + procesos.get(i).getDuracion()
							)));
		}
		
		for (int i = 1; i < duracionAux.length; i++) {
			procesos.get(i).setDuracion(duracionAux[i]);
		}
	}

}
