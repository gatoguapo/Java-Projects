package TopicosKaty;

public class AnimalSinHilo {
	
	private String name;
	private int sleep;
	
	AnimalSinHilo(String name,int sleep) {
		this.name = name;
		this.sleep = sleep;
	}
	
	public void run() {
		int i=0;
		System.out.println("Arranca "+getName());
		while (i<5) {
			try {
				Thread.sleep(sleep);
				System.out.println("Caminando "+getName());
			} catch(InterruptedException e) {
				e.getMessage();
			}
			i++;
		}
		System.out.println("Termina "+getName());
	}
	
	String getName() {
		return name;
	}
}
