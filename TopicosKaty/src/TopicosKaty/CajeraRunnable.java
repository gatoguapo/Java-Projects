package TopicosKaty;

public class CajeraRunnable implements Runnable {

	private Cliente cliente;
	private long initialTime;
	private int precioTotal;
	private String name;
	
	public CajeraRunnable(String name, Cliente cliente, long initialTime) {
		this.cliente = cliente;
		this.initialTime = initialTime;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("La " + getName() 
				+ " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " +
                        this.cliente.getNombre() 
				+ " EN EL TIEMPO: " + 
                        (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

		for (int i = 0; i < this.cliente.getCarroCompra().size(); i++) { 	
			esperarXsegundos(cliente.getCarroCompra().size());
                    precioTotal += cliente.getCarroCompra().get(i);
               	    System.out.println("Procesado el producto " + (i + 1) + " del " +
                            cliente.getNombre()+ "->Precio del producto: " + cliente.getCarroCompra().get(i) +
                    "->Tiempo: " + (System.currentTimeMillis() - initialTime) / 1000 +
                    "seg");
		}
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("La " + getName() +
                        " HA TERMINADO DE PROCESAR " 
				+ cliente.getNombre() + " EN EL TIEMPO: " 
				+ (System.currentTimeMillis() - initialTime) / 1000 
				+ "seg" + ", el precio total a pagar es de: " + precioTotal 
				+ ", la edad del cliente es: "+ cliente.getEdad()) ;
		System.out.println("--------------------------------------------------------------------------");
	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
	
	public String getName() {
		return name;
	}
}
