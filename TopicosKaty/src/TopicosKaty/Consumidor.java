package TopicosKaty;

import java.util.Iterator;

public class Consumidor extends Thread{

	private Tuberia tuberia;
	
	Consumidor(Tuberia tuberia) {
		this.tuberia = tuberia;
	}
	
	public void run() {
		int num;
		
		for(int i=0;i<10;i++) {
			num = tuberia.recogerNumeros();
			
			System.out.println("Recogido el numero impar: "+num);
			
			for(int j=0;j<10;j++) {
				System.out.println("Recogido el numero par: "+num);
			}
			
			try {
				Consumidor.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("Error de hilo "+e);
			}
		}
	}
	
	
}
