package Ejercicios;

public class Cuenta {
 public String Titular;
 public double Cantidad;
 
public Cuenta (String titular){
	this(titular,0);
}

public Cuenta (String titular, double cantidad) {
	Titular = titular;
	Cantidad = cantidad;
}

public void setTitular (String titular) {
Titular = titular;
}

public String getTitular () {
return Titular;
}

public void setCantidad (double cantidad) {
Cantidad = cantidad;
}

public double getCantidad () {
return Cantidad;
}

public String toString () {
	return "Titular: "+Titular+", Saldo: "+Cantidad;
}

public void ingresar (double cant) {
	if (cant>0)
		Cantidad+=cant;
}

public void retirar (double cant) {
	if (cant>Cantidad)
		Cantidad=0;
	else 
		Cantidad-=cant;
}

}
