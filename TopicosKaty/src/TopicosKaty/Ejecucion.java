package TopicosKaty;

public class Ejecucion {

	public static void main(String[] args) throws InterruptedException{
		Tuberia tuberia = new Tuberia();
		Consumidor consumidor = new Consumidor(tuberia);
		Productor_NumerosImpares productor1 = new Productor_NumerosImpares(tuberia);
		Productor_NumerosPares productor2 = new Productor_NumerosPares(tuberia);
		
		productor1.start();
		productor2.start();
		consumidor.start();
		Thread.sleep(2000);
        productor2.suspender();

        Thread.sleep(2000);
        productor2.reanudar();

        Thread.sleep(2000);
        productor2.interrupt();
        System.out.println("Hilos pares: finalizado");

        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("Error de hilo consumidor" +e);
        }

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println("Error hilo consumidor" +e);
        }

    }
}