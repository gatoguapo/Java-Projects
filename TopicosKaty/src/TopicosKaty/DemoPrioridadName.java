package TopicosKaty;

public class DemoPrioridadName {
	
	public static void main(String[] args) {
		Thread ph1 = new Thread(new PrioridadHilos(),"Prioridad Alta");
		Thread ph2 = new Thread(new PrioridadHilos(),"Prioridad Baja");
		Thread ph3 = new Thread(new PrioridadHilos(),"Prioridad Normal #1");
		Thread ph4 = new Thread(new PrioridadHilos(),"Prioridad Normal #2");
		Thread ph5 = new Thread(new PrioridadHilos(),"Prioridad Normal #3");
		
		//Establecer prioridades
		ph1.setPriority(Thread.MAX_PRIORITY);
		ph2.setPriority(Thread.MIN_PRIORITY);
		//Deje ph3, ph4 y ph5 en el nivel de prioridad normal predeterminado
		
		//Comenzar los hilos 
		ph1.start();
		ph2.start();
		ph3.start();
		ph4.start();
		ph5.start();
		
		System.out.println("\nHilo de alta prioridad conto hasta "+ph1.getName());
		System.out.println("Hilo de baja prioridad conto hasta "+ph2.getName());
		System.out.println("Hilo de normal prioridad #1 conto hasta "+ph3.getName());
		System.out.println("Hilo de normal prioridad #2 conto hasta "+ph4.getName());
		System.out.println("Hilo de normal prioridad #3 conto hasta "+ph5.getName());
	}

}
