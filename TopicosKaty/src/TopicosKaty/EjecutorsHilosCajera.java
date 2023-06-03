package TopicosKaty;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.time.LocalDateTime;

public class EjecutorsHilosCajera {

    private static final int numCajeras = 3;
    
    public static void main(String[] args) {
    	EjecutorsHilosCajera obj = new EjecutorsHilosCajera();
    	
        ArrayList<Cliente>clientes = new ArrayList<Cliente>();
        ArrayList<Integer> carrito1 = new ArrayList<>();
        ArrayList<Integer> carrito2 = new ArrayList<>();
        ArrayList<Integer> carrito3 = new ArrayList<>();
        ArrayList<Integer> carrito4 = new ArrayList<>();
        ArrayList<Integer> carrito5 = new ArrayList<>();
        ArrayList<Integer> carrito6 = new ArrayList<>();
        ArrayList<Integer> carrito7 = new ArrayList<>();
        ArrayList<Integer> carrito8 = new ArrayList<>();
        
        clientes.add(new Cliente("Cliente 1", carrito1, 20));
        clientes.add(new Cliente("Cliente 2", carrito2, 41));
        clientes.add(new Cliente("Cliente 3", carrito3, 34));
        clientes.add(new Cliente("Cliente 4", carrito4, 18));
        clientes.add(new Cliente("Cliente 5", carrito5, 25));
        clientes.add(new Cliente("Cliente 6", carrito6, 26));
        clientes.add(new Cliente("Cliente 7", carrito7, 43)); 
        clientes.add(new Cliente("Cliente 8", carrito8, 50)); 

        long init = System.currentTimeMillis();
        
        System.out.println("Tiempo INICIAL de procesamiento: "+(init)/1000+" Segundos");
        
        //Llenamos los carritos
        for(int i=0;i<5;i++) {
        	carrito1.add(obj.asignarPrecio());
        	carrito2.add(obj.asignarPrecio());
        	carrito3.add(obj.asignarPrecio());
        	carrito4.add(obj.asignarPrecio());
        	carrito5.add(obj.asignarPrecio());
        	carrito6.add(obj.asignarPrecio());
        	carrito7.add(obj.asignarPrecio());
        	carrito8.add(obj.asignarPrecio());
        }
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
        ExecutorService executor = Executors.newFixedThreadPool(numCajeras);
        int i = 1;
        for (Cliente obtCliente: clientes) {
            Runnable cajera = new CajeraRunnable("Cajera "+i,obtCliente, init);
            i++;
            executor.execute(cajera);
        }
        executor.shutdown();	// Cierro el Executor
        while (!executor.isTerminated()) {
        	// Espero a que terminen de ejecutarse todos los procesos 
        	// para pasar a las siguientes instrucciones 
        }
        
        long fin = System.currentTimeMillis();	// Instante final del procesamiento
        
        System.out.println("Tiempo FINAL de procesamiento: "+(fin)/1000+" Segundos");
        
        System.out.println("Tiempo total de procesamiento: "+(fin-init)/1000+" Segundos");
        
         dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
    }
    
    public int asignarPrecio() {
    	int precio = (int) (Math.random() * (1001 - 10)) + 10;
    	return precio;
    }
}

