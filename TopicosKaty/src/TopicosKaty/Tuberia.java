package TopicosKaty;

public class Tuberia {
	private int buffer[]= new int[6];
    private int buffer2[]= new int [6];
    private int siguiente=0;
    private boolean estaLlena=false;
    private boolean estaVacia=true;

    public synchronized int recogerNumeros(){
        while(estaVacia==true){
            try{
                wait();
            }catch (InterruptedException e){
            	;
            }
        }
        siguiente--;
        if(siguiente==0)
            estaVacia=true;
            estaLlena=false;
            notify();
        return(buffer[siguiente]);
    }

   public synchronized void LanzaNumerosImpares(int num){
        while(estaLlena==true){
            try{
                wait();
            }catch(InterruptedException e){
                ;
            }
        }
        buffer[siguiente]=num;
        siguiente++;
        if(siguiente==6)
            estaLlena=true;
            estaVacia=false;
            notify();
   }

   public synchronized void lanzarNumerosPares(int num){
        while(estaLlena==true){
            try{
                wait();
            }catch (InterruptedException e){
                ;
            }
        }
        buffer2[siguiente]=num;
        siguiente++;
        if(siguiente==6)
            estaLlena=true;
            estaVacia=false;
            notify();
   }
   
}
