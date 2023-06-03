package TopicosKaty;

public class PrioridadHilos implements Runnable{
	int contar;
	
	static boolean stop=false;
	static String actualNombre;
	
	public PrioridadHilos() {
		contar=0;
		actualNombre = Thread.currentThread().getName();
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" iniciando.");
		
		for (int i=0;i<10000;i++) {
			contar++;
			if (!stop) {
				actualNombre=Thread.currentThread().getName();
				System.out.println("En "+actualNombre+" contador "+contar);
			} else {
				return;
			}
		}
		stop=true;
		System.out.println("\n"+Thread.currentThread().getName()+" terminado.");
	}
}
