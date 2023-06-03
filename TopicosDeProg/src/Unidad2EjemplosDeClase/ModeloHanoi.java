package Unidad2EjemplosDeClase;

import java.util.ArrayList;

public class ModeloHanoi {
	private ArrayList<Movimiento> movtos;
	public ModeloHanoi() {
		movtos=new ArrayList();
		
	}
	 public void Hanoi(char Inicial,char Central,char Final,int N) {
		 if(N==1) {
			 movtos.add(new Movimiento(Inicial,Final,N));
			 return;	
		 }
		 Hanoi(Inicial,Final,Central,N-1);
		 movtos.add(new Movimiento(Inicial,Final,N));
		 Hanoi(Central,Inicial,Final,N-1);
	 }
	 
	public ArrayList<Movimiento> getMovtos() {
		return movtos;
	}


	
}
