package TopicosKaty;

public class Productor_NumerosPares extends Thread{
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
	
	Productor_NumerosPares(Tuberia tuberia) {
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
					if (!esPar(num)) {
						System.out.println("-------numeros impares-------");
						System.out.println(num+" _:impar");
						tuberia.LanzaNumerosImpares(num);
						System.out.println("Lanzado "+num+" a la tuberia impares.");
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
