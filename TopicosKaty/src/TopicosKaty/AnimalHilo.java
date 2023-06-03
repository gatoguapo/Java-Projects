package TopicosKaty;

public class AnimalHilo extends Thread{
	
	private int sleep;
	
	AnimalHilo(String name, int sleep) {
		setName(name);
		this.sleep = sleep;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
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
	
}
