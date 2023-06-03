package TopicosKaty;

public class Productor_NumerosImpares extends Thread{
	private Tuberia tuberia;
	private boolean suspendido;
	
	public synchronized void suspender() {
		System.out.println("#####.....suspendiendo el hilo.......######");
		suspendido = true;
	}
	
	public synchronized void reanudar() {
		System.out.println("#####.....reanudado el hilo.......######");
		suspendido = false;
		notify();
	}
	
	public synchronized void enSuspension() {
		while(suspendido = true) {
			try {
				wait();
				System.out.println("zZzZzZzZzZzZzZzZzz");
			} catch (InterruptedException e) {
				interrupt();
			}
		}
	}
	
	Productor_NumerosImpares(Tuberia tuberia) {
		super();
		this.tuberia = tuberia;
	}
	
	@Override
	public void run() {
		try {
			while (!isInterrupted()) {
				enSuspension();
				for (int i=0;i<10;i++) {
					int num = (int) (Math.random()*100)+1;
					if (esPar(num)) {
						System.out.println("-------numeros pares-------");
						System.out.println(num+" _:par");
						tuberia.lanzarNumerosPares(num);
						System.out.println("Lanzado "+num+" a la tuberia pares.");
					}
					Thread.sleep(5000);
				}
			}
		} catch (InterruptedException e) {
			System.out.println("error de hilo par "+e);
		}
	}
	
	private boolean esPar(int num) {
			return (num%2==0);
	}
}
