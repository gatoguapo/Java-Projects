package Unidad3;

public class Filosofo extends Thread{
	Semaforo [] tenedores;
	boolean [] ocupado;
	int filosofo;
	
	public Filosofo(Semaforo [] tenedores ,boolean [] ocupado, int filosofo) {
		this.tenedores = tenedores;
		this.ocupado = ocupado;
		this.filosofo = filosofo;
	}
	
	public void run() {
		for (int i=0;i<5;i++) {
			System.out.println(getName()+" intenta levantar tenedor izquierdo");
			
			if (!ocupado[filosofo - 1]) {
				tenedores[filosofo - 1].Espera();
				ocupado[filosofo - 1] = true;
				System.out.println(getName()+" levantó tenedor izquierdo");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(getName()+" intenta levantar tenedor derecho");
				
				if (Integer.valueOf(filosofo).equals(5) && !ocupado[0]) {
					System.out.println(getName()+" levantó tenedor derecho");
					tenedores[0].Espera();  
					ocupado[0] = true;
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(getName()+" come un poco");
					tenedores[filosofo - 1].Libera();
					tenedores[0].Libera();
					ocupado[filosofo - 1] = false;
					ocupado[0] = false;
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(getName()+" libera los tenedores");
				} else if (Integer.valueOf(filosofo).equals(5) && ocupado[0]){
					System.out.println(getName()+" no puede levantar tenedor derecho");
					tenedores[filosofo - 1].Libera();
					ocupado[filosofo - 1] = false;
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(getName()+" libera tenedor izquierdo ");
				}

				if(!ocupado[filosofo] && !Integer.valueOf(filosofo).equals(5)) {
					System.out.println(getName()+" levantó tenedor derecho");
					tenedores[filosofo].Espera();
					ocupado[filosofo] = true;
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(getName()+" come un poco");
					tenedores[filosofo - 1].Libera();
					tenedores[filosofo].Libera();
					ocupado[filosofo - 1] = false;
					ocupado[filosofo] = false;
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(getName()+" libera los tenedores");
				}
				if (ocupado[filosofo] && !Integer.valueOf(filosofo).equals(5)) {
					System.out.println(getName()+" no puede levantar tenedor derecho");
					System.out.println(getName()+" libera tenedor izquierdo ");
					tenedores[filosofo - 1].Libera();
					ocupado[filosofo - 1] = false;
				}
			}
			if (ocupado[filosofo - 1]) {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(getName()+" no puede levantar tenedor izquierdo");
			}
		}
	}
	
}
