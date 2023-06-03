package TopicosKaty;

public class MainMetodoYield {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread ramirez = new Thread (new MetodoYield("Ramirez"));
	       Thread victor = new Thread (new MetodoYield("Victor"));
	      
	       ramirez.start();
	       victor.start();
	       
	       try {
			ramirez.join();
			victor.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	       
	       for (int i=0;i<10;i++) {
	    	   System.out.println(i);
	       }
	       
	}
}
