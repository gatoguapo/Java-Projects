package Unidad1;

public class prueba {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep((1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Cerdo " + i);
		}
		
		for (int i = 0; i < 10; i++) {
			
			System.out.println("Hola " + i);
		}
	}
}