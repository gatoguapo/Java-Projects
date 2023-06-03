package Ejercicios;

	public class Videojuegos {
	private String Titulo,Genero,Compa�ia;
	private byte HrsE;
	private boolean Entrega;
	
	public Videojuegos(String Titulo, byte HrsE,boolean Entrega, String Genero, String Compa�ia) {
	this.Titulo = Titulo;
	this.HrsE = HrsE;
	this.Genero = Genero;
	this.Compa�ia = Compa�ia;
	Entrega=false;
	}
	
	public Videojuegos(String Titulo, byte HrsE, String Genero, String Compa�ia) {
		this.Titulo = Titulo;
		this.HrsE = 10;
		this.Genero = "";
		this.Compa�ia = "";
	}
		
	public Videojuegos() {
	this("",(byte)10,"","");
	}
		
	
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String Titulo) {
		this.Titulo = Titulo;
	}
	public byte getHrsE() {
		return HrsE;
	}
	public void setHrsE(byte HrsE) {
		this.HrsE = HrsE;
	}
	public String getGenero() {
		return Genero;
	}
	public void setGenero (String Genero) {
		this.Genero = Genero;
	}
	public String getCompa�ia() {
		return Compa�ia;
	}
	public void setCompa�ia (String Compa�ia) {
		this.Compa�ia = Compa�ia;
	}
}
