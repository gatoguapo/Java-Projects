package Ejercicios;

public class Ventana {
	class ventana {
		int posX;

		int posY;

		int largo;

		int alto;
		public ventana() {
			
		}
		public ventana(int posX,int posY, int largo,int alto) {
			posX = this.posX;
			posY = this.posY;
		}
		 void  moverVentana() {
			posX = 0;
			posY=0;
		}
		 void  moverVentana(int X,int Y) {
			 posX = X;
			 posY= Y;
		}
		 
		 public void main (String [ ] args) {
			 ventana ventana1= new ventana();
			 
			 ventana1.moverVentana(10,5);
			 ventana1.moverVentana();
			 
			 
		 } 
}}
