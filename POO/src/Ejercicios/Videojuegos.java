package Ejercicios;

	public class Videojuegos {
	private String Titulo,Genero,Compañia;
	private byte HrsE;
	private boolean Entrega;
	
	public Videojuegos(String Titulo, byte HrsE,boolean Entrega, String Genero, String Compañia) {
	this.Titulo = Titulo;
	this.HrsE = HrsE;
	this.Genero = Genero;
	this.Compañia = Compañia;
	Entrega=false;
	}
	
	public Videojuegos(String Titulo, byte HrsE, String Genero, String Compañia) {
		this.Titulo = Titulo;
		this.HrsE = 10;
		this.Genero = "";
		this.Compañia = "";
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
	public String getCompañia() {
		return Compañia;
	}
	public void setCompañia (String Compañia) {
		this.Compañia = Compañia;
	}
}
