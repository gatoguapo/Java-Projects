package TopicosKaty;

public class MetodosHilos extends Thread {

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("thread methods demo");
			try {
				System.out.println("thread is going to sleep");
				//Sleep, nos permite dormir la ejecucion del hilo por una cantidad de tiempo establecida
				MetodosHilos.sleep(1000);

				//El metodo yield regresa el estado del hilo a Runnable(listo para ejecutar) permitiendo
				//que otros hilos de la misma prioridad puedan ejecutarse
				Thread.yield();
				System.out.println("thread wake up");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws
		InterruptedException {
			
		MetodosHilos de = new MetodosHilos();
		 
		//getState nos indica el estado actual del hilo, el cual puede ser New,Runnable,Running,Waiting,Termimanted
		System.out.println("getstate1: "+de.getState());
		//start inicializa el hilo, llamando al metodo run de nuestro hilo
		de.start();
		System.out.println("getstate2: "+de.getState());
		System.out.println("getstate3: "+de.getState());
	
		System.out.println("getstate4: "+de.getState());
		//setName nos permite cambiar el nombre actual del hilo, el cual por defecto es Thread-0
		de.setName("Hilo gato");
		//getName nos devuelve el nombre actual del hilo
		System.out.println("thread Name: "+de.getName());
		//getPriority nos devuelve el nivel de prioridad del hilo
		System.out.println("thread Priority: "+de.getPriority());
		//Devuelve un true si el hilo sigue corriendo y un false si ya terminó
		de.isAlive();
		//Detiene el hilo actual hasta que el hilo llamado termina
		de.join();
		System.out.println("getstate5: "+de.getState());
		}

}

