package Practica;

public class Ventana {

public int posX;
public int posY;
public int largo;
public int alto;
	
public Ventana () {

}
public Ventana (int posX, int posY,int largo, int alto)	{
	this.posX = posX;
	this.posY = posY;
	this.largo = largo;
	this.alto = alto;
}
public void moverVentana () {
	posX=0;
	posY=0;
}

public void moverVentana (int X,int Y) {
	posX=X;
	posY=Y;
}


}
