package Proyecto;

public class Usuario {
	String Usuario;
    String Contraseña;
    public static final int TAMANIO = 304;

    public Usuario(String usuario, String contraseña) {
        this.Usuario = usuario;
        this.Contraseña = contraseña;
    }

    public Usuario() {
        this("", "");
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        this.Usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        this.Contraseña = contraseña;
    }

    public static int getTAMANIO() {
        return TAMANIO;
    }
}
