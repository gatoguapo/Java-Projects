package TopicosKaty;

public class MyThread implements Runnable{
	
	MyThread(String name) {
		Thread.currentThread().setName(name);
	}
	
	public void run() {
		System.out.println("MyThread - START "+Thread.currentThread().getName());
		try {
			doDBProcessing();
		} catch (InterruptedException e){
			
		}
		System.out.println("MyThread - END "+Thread.currentThread().getName());
	}

	private void doDBProcessing() throws InterruptedException{
		Thread.sleep(5000);
	}
}
