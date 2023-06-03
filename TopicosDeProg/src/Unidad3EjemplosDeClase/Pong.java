package Unidad3EjemplosDeClase;

public class Pong extends Thread{
	Semaforo sping,spong;
	public Pong(Semaforo sping, Semaforo spong) {
		this.sping=sping;
		this.spong=spong;
	}
	public void run() {
		
		for(int i=0 ; i<100; i++) {
			spong.Espera();
			System.out.println("P O N G");
			sping.Libera();
		}
		
	}
}
